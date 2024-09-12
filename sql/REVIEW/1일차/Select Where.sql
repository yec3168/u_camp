--    1. select 
-- select [컬럼 목록]
-- from  [테이블]
 
 select *
 from employees;
 
 

--      2.Distinct
--  - 중복을 제거함
--  - select 절 맨 앞에 붙임
--  - distinct 뒤에 오는 모든 컬럼을 하나로 인식하여 중복을 제거함.
--            ex) select distinct name, email
--  - select distinct [컬럼 목록]
--  - from [테이블]

 select  distinct student_no, term_no
 from tb_grade;
 
 
 
--        3. 시즈닝( 알리어스)
--    - 별명을 붙여줌, as를 넣어도 되고 안넣어도 됨.
--    ex ) select name 학기
--         select name "학기"
--         select name as 학기
--         select name as "학기"
--    - But, ""없이는 숫자와 공백이 안됨
--    ex )  select name 2019
--          select name 학 기

select student_name  이름
        , student_address "주소"
        , student_ssn as 생년월일
        , student_no as "학번"
from tb_student;
          
            
--        4. 사칙연산
--    - select절에 사칙연산을 넣을 수 있음
--    - 단. 숫자만 가능
--    - 문자는 더하는게 아니라 문자열을 이어 붙이는 것이기 때문에 concat 혹은 ||를 사용

select salary / 12 as "월급"
        , first_name || 100 as "문자열붙이기"
from employees;



-- but. 아래 쿼리는 왜 되냐???
 -- 오라클이 자동으로 문자열을 숫자데이터로 변환하기 때문
 select '100' + '200'
 from dual;



--        5. order by
--    - 정렬을 해주는 것
--    - 맨 마지막에 붙임
--    - 알리어스, 컬럼, 1 등 가능.
--    - desc : 내림차 순 ASC : 오름차 순(default)로 생략 가능
--        ex) order by 1;
--            order by "이름" asc
--            order by salary/12 desc
--  
--    - 따로 order by가 없으면 임의의 순서로 반환.

select salary /12 as "월급"
from employees
order by 1 desc;


--         6. where
--      - where [ 조건식 ]
--      - 연산자와 같이 사용이 가능함.
--      - like, in, between, and, or, is null, is not null .. etc
--      - % :  그 뒤에 0개의 문자가 올 수 있음
--      - _ : 단 하나의 문자만 올 수 있음.

-- 1. like (조건)
-- 괄호 안에는 단 하나의 값만 들어 갈 수 있음.
-- 불확실한 'A%', '_a%' 등 올 수 있음.
select *
from employees
where first_name like ('A%');

-- 2. in ( 조건 들)
-- 괄호 안에는 여러 개의 조건이 올 수 있음.
-- 확실한 값이 들어와야함 100, 200 등
select *
from employees
where department_id in (50, 60);

-- 3. between a amd b
--  a와 b사이의 값
-- a랑 b도 속함
select *
from employees
where employee_id between 100 and 150;

-- 4. is null , is not null
-- is null : null인 경우
-- is not null : null이 아닌 경우
select *
from employees
where commission_pct is null;


--        7. 집합 연산자
--    - 비교하는 두 개의 컬럼의 타입과 수가 같아야 함.
--    - null이나 0같은 더미 값으로 채울 수 있음.
--        - union : 중복을 제외한 합집합
--        - union all : 중복을 포함한 합집합
--        - minus : a를 기준 차집합
--        - intersect : 교집합

-- 1. union
select department_id
        , manager_id
from employees
union
select department_id
        , manager_id
from departments;

-- 2. union all
select department_id
        , manager_id
from employees
union all
select department_id
        , manager_id
from departments;

-- 3. minus
select department_id
        , manager_id
from employees
minus 
select department_id
        , manager_id
    from departments;

-- 4. intersect
select department_id
        , manager_id
from employees
INTERSECT 
select department_id
        , manager_id
    from departments;


      
