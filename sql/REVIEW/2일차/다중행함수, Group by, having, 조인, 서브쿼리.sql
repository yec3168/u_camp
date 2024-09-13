/*
                다중행함수
        - 결과 값이 단 하나의 행만 나오는 함수
            ex) min, max, count, sum, avg ...etc
        - 일반 행과, 다중행함수와 같이 쓸수 없음 ( 예외. group by와 같이 쓰면 가능)
            ex) select first_name, count(*)
 
  1. count(컬럼)
  - 갯수를 셈
  2. min, max
  - 숫자만 올 수 있으며, 해당 컬럼의 최소, 최대를 추출
  3. sum, avg
  - 집계함수
  - 더하거나 평균을 구함.
 */ 
 
  select count(*) as count
        , min(salary) as min_salary
        , max(salary) as max_salary
        , sum(salary) as sum_salary
        , avg(salary) as avg_salary
  from employees;
  
  
  
-------------------------------------------------------------------------------

/*
                Group by
            - 컬럼을 그룹으로 묶음
            - select [컬럼]
              from  [테이블]
              where [조건]
              group by [컬럼]
              having [그룹의 조건]
            - select에는 집계함수를 제외한 group으로 묶인 컬럼만 올 수 있다.
            - 알리어스(as)나 '1'은 불가능
            
                having
            - 그룹의 조건을 넣음
            - where보다 늦은 순서를 가지고 마찬가지로 group에 묶인 컬럼만 가져올 수 있다.
            - 집계함수는 따로 가능.
*/

select category as "계열"
        , count(*) as "학과 수"
from tb_department
group by category
having  count(*) > 5;



-------------------------------------------------------------------------------


--                    조인
--            - 두 개의 테이블을 합치는 것.
--            - A테이블의 컬럼 ==  B테이블의 컬럼
--            - 조인시 'as'는 붙이면 안됨.
--        
--        1. 등가조인
--          - '='를 사용해서 조인하는 것.
--          - oracle방식과 ansi방식이 존재.
--               * oracle 방식
--              ex) from employees e , department d
--                  where e.department_id = d.department_id
--              
--               * Ansi 방식
--                 1. on 사용
--                  from employees e inner join department d on e.department_id = d. department_id
--                 
--                 2. using 사용 
--                    - null값이 안나와서 outer 조인이 의미가 없음
--                    - 비교하는 두 개의 컬럼을 하나로 합치는 것이기에 `s.컬럼` 이 안됨..
--                   from employees e inner join  using(department)
--            
--                1-1. cross join
--               ex) from employees, departments
--
--              1-2. inner join == join
--               - 서로 같은 것만 나옴.
--                 ex) from employees e, departments d
--                     where e.department_id = d.department_id;
--
--              1-3. outer join
--                - 해당 테이블의 값이 같은게 없어도 다 출력
--                -  where에 (+)을 붙이면 됨.  (+)가 해당 값이 없어도  
--                     ex) left outer join
--                      from employees e, departments d
--                      where e.department_id = d.department_id(+);
--        
--                      ex) right outer join
--                      from employees e, departments d
--                      where e.department_id(+) = d.department_id;
--    
--                      ex) full outer join
--                           - Ansi 방법만 가능.
--                      
--                  1-4. self join
--                - 자기 자신을 조인하는 것.
--                      ex) self join
--                           from employees e1,  employees e2
--                           where e1.employee_id = e2.employee_id

-- 1. oracle 방식
select e.first_name, e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

-- 2. Ansi on 방식
select e.first_name, e.last_name, d.department_name
from employees e inner join departments d on e.department_id = d.department_id;

-- 3. Ansi using 방식
select e.first_name, e.last_name, d.department_name
from employees e inner join departments d using (department_id);

-- 4. left outer 방식
select e.first_name, e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id (+);

-- 5. right outer 방식
select e.first_name, e.last_name, d.department_name
from employees e, departments d
where e.department_id(+) = d.department_id;


--
--            2. 비등가 방식
--            - '='를 사용하지 않는방식

 select employee_id, first_name, salary
 from employees e , departments d
 where salary between 1000 and 10000;
 
 
 

 -------------------------------------------------------------------------------
 /*
                서브쿼리
            - 따로 쿼리문을 묶어서 가상의 테이블을 만듦
            - select, from, where절에 붙일 수 있다.
            - where절에서 만든 테이블은 from이랑 select에서 사용할 수 없다.
            - 서브쿼리의 결과는 단일 행일 수도 다중행 일 수 도있다.
            - 다중컬럼이거나 단일 컬럼일 수 도 있다.
        
        where 절
        - where의 서브쿼리는 from이나 select에서 사용할 수 없다.
        - 쿼리 결과가 단일행 일 수도 다중행 일수도 있다.
        - in, like, any, some, all, exists를 사용할 수 있다.
        
         1. 단일 행
         - 행이 단 한개의 결과 값으로 like나 '='를 사용해서 비교한다.
         -  in, any 등 다 가능
         
         2. 다중행
         - in, any, some, exists, all 만 가능하다.
           
           2-1. in
            - or의 의미.
           2-2. any, some
             ex)   salary  > any(2000, 3000, 5000)
                >> 주어진 쿼리 결과값의 최솟값 보다 큰지
                >> 2001 이상이면 true
                >> 1999 이하면 false;
             ex)   salary  < any(2000, 3000, 5000)
                >> 주어진 쿼리 결과값의 최댓값 보다 작은지.
                >> 4999 이하면 true
                >> 5001 이상이면 false;
             ex)   salary = any(2000, 3000, 5000)
                >> 주어진 쿼리 결과값의 포함되는지
                >> 2000 이면 true
                >> 1888 면 false;
 */
 
 
--14000
--13500
--12000
--11000
--10500
 
 -- salary > any() >> 최소값보다 크니?, 어느 한값보다 크니 라는 질문.
 select employee_id, first_name || last_name, salary
from employees
where salary > any( select salary
                    from employees
                    where job_id = 'SA_MAN');

-- salary < any() >> 최대값보다 작니?                
 select employee_id, first_name || last_name, salary
from employees
where salary < any( select salary
                    from employees
                    where job_id = 'SA_MAN');
                    
--salary = any() >> 포함하니?
 select employee_id, first_name || last_name, salary
from employees
where salary = any( select salary
                    from employees
                    where job_id = 'SA_MAN');
                    
                    
                    
--                2-3. All
--             ex)   salary  > all(2000, 3000, 5000)
--                >> 주어진 쿼리 결과값의 최댓값 보다 큰지
--                >> 5001 이상이면 true
--                >> 1999 이하면 false;
--             ex)   salary  < all(2000, 3000, 5000)
--                >> 주어진 쿼리 결과값의 최솟값 보다 작은지.
--                >> 1999 이하면 true
--                >> 5001 이상이면 false;
--             ex)   salary = all(2000, 3000, 5000)
--                >> 주어진 쿼리 결과값의 포함되는지
--                >> 2000 이면 true
--                >> 1888 면 false;
    
--14000
--13500
--12000
--11000
--10500       

-- salary > all() >> 최댓값보다 크니? 모든 값보다 크니라는 질문.
 select employee_id, first_name || last_name, salary
from employees
where salary > all( select salary
                    from employees
                    where job_id = 'SA_MAN');

-- salary < all() >> 최솟값보다 작니?                
 select employee_id, first_name || last_name, salary
from employees
where salary < all( select salary
                    from employees
                    where job_id = 'SA_MAN');
                    
--salary = all() >> 포함하니?
 select employee_id, first_name || last_name, salary
from employees
where salary = all( select salary
                    from employees
                    where job_id = 'SA_MAN');


--                2-4. exists
--              - 상관관계 서브쿼리라고 함.
--              - where exists (10, 20, 30)
--              - 서브쿼리에서 행이 존재하는 경우 참입니다
select *
from employees e
where exists ( select  *
                from departments d
                where e.department_id = d.department_id);
            
--            == 
            
select *
from  employees e inner join departments d on e.department_id = d.department_id
order by employee_id;
