-- where [조건] and/or 구분
select employee_id
        , first_name
        , last_name
        , job_id
        , salary
        , department_id
from employees
where department_id = '30' and job_id = 'PU_CLERK' and salary > 2600;



-- 연산자 ( +, -, *, / ) 
-- varchar는 안됨, varchar에서 연결하고 싶으면 `||`를 씀
--  != , <>, ^=  는 같음.
select employee_id
        , first_name || 10
        , last_name 
from employees;



-- in은 or
select *
from tb_student
where student_no in ('A513079', 'A513119');


-- between a and b      a랑 b도 포함.
select *
from employees
where employee_id between 100 and 110;


-- like는 뒤에 오는 값이 무조건 한 개여야함.
-- 'A%' 에서 %는 A로 시작하는 것.
-- '%A%'는 중간에 A가 들어가는 것. '%'는 여러개.
select first_name
from employees
where first_name like ('A%');

-- '_' 는 하나의 문자.
-- '__'는 두 개.
select first_name
from employees
where first_name like ('_a%');

-- IS NULL 연산자
-- IS NULL : 값이 NULL인지
-- IS NOT NULL : 값이 NULL이 아니냐.
-- 일반 연산자는 안됨
--  ex) 10 + IS NULL = NULL; (X)
select first_name
from employees
where manager_id is null;





-- UNION
-- 윗 줄에 ;는 없애야함.
-- a union b를 합친다.
-- a랑 b의 컬럼은 서로 타입이 같고 갯수도 같아야함. ( 더미값을 줄 수 있음.)
-- 중복이 제거됨.
select employee_id
        , first_name
        , manager_id
from employees
union
select department_id
        , department_name
        , manager_id
    from departments;

-- union all
-- 중복된 것도 출력.

select employee_id
        , first_name
        , manager_id
from employees
union all
select department_id
       ,null  -- 더미 값
        , manager_id
    from departments;
    
-- minus
-- a를 기준 교집합 제외
select department_id
        , manager_id
from employees
minus 
select department_id
        , manager_id
    from departments;
    

-- INTERSECT
select department_id
        , manager_id
from employees
INTERSECT 
select department_id
        , manager_id
    from departments;
    