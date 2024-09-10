--                조인
--        - 두 개 이상의 테이블을 합치는 것.
--        - A라는 테이블의 dep_no 컬럼과 B 테이블의 dep_no가 같은 타입이면 조인이 가능
--            보통. 타입이 같고, 컬럼명도 같은것 (외래키)를 사용.
--        - 조인시 `as`는 안 붙여줌.
--
--  1. 등가조인
--      - 왼쪽 테이블의 컬럼과 오른쪽 테이블의 컬럼이 같은 것끼리 조인을 하는 것.
--      
--      1-1. cross join
--          ex) from employees, departments

--      1-2. inner join
--       - 서로 같은 것만 나옴.
--           ex) from employees e, departments d
--               where e.department_id = d.department_id;

--      1-3. outer join
--        - 해당 테이블의 값이 같은게 없어도 다 출력
--        -  where에 (+)을 붙이면 됨.  (+)가 해당 값이 없어도  
--             ex) left outer join
--              from employees e, departments d
--              where e.department_id = d.department_id(+);

--              ex) right outer join
--              from employees e, departments d
--              where e.department_id(+) = d.department_id;

--              ex) full outer join
--              from employees e, departments d
--              where e.department_id(+) = d.department_id(+);

--      1-4. self join
--        - 자기 자신을 조인하는 것.
--              ex) self join
--                   from employees e1,  employees e2
--                   where e1.employee_id = e2.employee_id



-- join의 표현법.
-- 서로 비교할 컬럼의 타입은 같아야 함.
--      Date == number x

-- 1. where을 통해 조건을 넣는 경우.
select first_name, last_name, department_name
from employees e, departments d
where e.department_id = d.department_id;

-- 2. ansi( using : 두 테이블을 연결할 때 타입은 동일하나 컬럼명이 다른 경우.)
select first_name, last_name, department_name
from employees e inner join departments d on e.department_id = d.department_id;

-- 3. ansi ( using : 두 테이블을 연결할 때 사용할 컬럼명과 타입이 동일한 경우)
-- using을 사용하게 되면 두 개의 컬럼이 공통으로 묶이기 때문에 where절에서 해당 컬럼을 사용하려 할 때, 별칭을 빼줘야함.
-- 그리고 using을 사용하게 되면 null값을 반환하지 않음. 즉, right, left, full join시 사용하면 안됨.
select first_name, last_name, department_name
from employees e join departments d using(department_id)
where department_id  between 10 and 20;


-- 4. left outer join
-- outer는 넣어도 되고 안넣어도 됨.
select first_name, last_name, department_name
from employees e left join departments d using(department_id);



-- 5. right outer join
-- outer는 넣어도 되고 안넣어도 됨.
select first_name, last_name, department_name
from employees e right join departments d using(department_id);

--------------------------------------------------------------------------------



--        2. 비등가조인
--           '='를 사용하지 않는 조인.
--        ex)
--            select employee_id, first_name, salary, point
--            from employees, tb_grade
--            where salary between min(salary) and maX(salary);
