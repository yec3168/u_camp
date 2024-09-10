--            다중행 함수
--        - 하나의 열의 출력 결과를 담는 함수
--        - Sum, count, max, min...etc
--        - 


-- 1. Count()
-- null값은 갯수에 포함되지 않음.

-- 2. max(), min()
-- 최대, 최소

-- 3. avg()
-- 평균
select count(employee_id)       as count_id
        , count(commission_pct) as count_pct
        , max(salary)   as max
        , min(salary)   as min
        , avg(salary)   as avg
from employees;

-- 갯수가 안맞음
-- fisrt_name은 여러 행
-- count는 한 개의 행.
--          select first_name, count(first_name)
--          from employees;



--문제
--지도 교수가 배정받지 못한 학생의 수를 추출 하는 sql

select count(*)
from tb_student
where coach_professor_no is null;


-- 문제
-- 학번이 'A517178'인 한아름 학생의 학점 총 평점을 구하는 sql '평점'이름 붙임

select sum(point) as "총 학점"
        , round(avg(point), 2) as "평점"
from tb_grade
where student_no like ('A517178');




-------------------------------------------------------------------------------


--                    Group by
--            -  select [컬럼 목록]
--            -  from [테이블]
--            -  where [조건]
--            -  group by [ 컬럼 목록]
--            -  having [그룹의 조건]
--          - 그룹을 지어 출력하는 것.
--          - group by에 적은 `컬럼 목록`만 select에 적을 수 있고,  그 외 컬럼이 온다면
--            따로 group에 추가해야함.
--          - `as`, `1` 같은 것은 불가능. (순서의 문제)
--          - from -> where -> group by -> having -> select -> order by    
    
    
select sum(salary)
from employees
group by department_id;


--                    having
--            - 그룹의 조건을 주 는 것.
--            - where 보다 늦은 순서
--            - group by에 있는 컬럼만 having절에 조건 컬럼으로 사용가능.
--            - But. count, sum, min .. etc 가능
        
 select sum(salary)
from employees
group by department_id
having sum(salary) > 10000 and department_id > 50;



--문제
--성별로 휴학생이 몇명인지 출력.

select decode(substr(student_ssn, 8, 1), '1', '남자','2', '여자') as 성별
        ,count(substr(student_ssn, 8, 1)) as count
from tb_student
where absence_yn = 'Y'
group by substr(student_ssn, 8, 1);

