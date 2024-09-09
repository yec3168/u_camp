-- select [컬럼 목록]    * : `아스타` 라고 함.
-- from [테이블]
-- where [조건식]

select *
from employees
where employee_id = 100;



-- 1. 학번이 'A513079`인 학생의 정보를 추출하세요.
select *
from tb_student
where student_no = 'A513079';


--2. 학번이 'A513079'와 `A513119`의 학생의 정보를 추출.

select *
from tb_student
where student_no in ('A513079', 'A513119');

-- or

select *
from tb_student
where student_no = 'A513079' or student_no= 'A513119';


-- Distinct : 해당 컬럼의 중복을 제거해서 출력.   
--          : 아래 예시로 보면 student_no과 term_no의 중복을 제거해줌.
--          : 중간에 올 수 없음( 맨처음만 가능)
--      ex) select  student_no, distinct  term_no( x )
-- select distinct [컬럼 목록]
-- from [table]
select distinct student_no, term_no
from tb_grade
where student_no = 'A612025'
order by 1, 2;



--  as(시즈닝) : 별명을 붙여줌, as는 넣어도 되고 안넣어도 됨. 
-- select student_no 학기  ( 숫자 안됨, 띄어쓰기 안됨)
-- select student_no "학기"
-- select student_no as 학기  ( 숫자 안됨, 띄어쓰기 안됨)
-- select student_no as "학기"

-- But. ""없이 공백이 있으면 오류
-- student 2009년 학기 (x)

select student_no as "학번", term_no as "학기"
from tb_grade;



-- select절에 사칙연산을 넣을 수 있음.
select salary * 12 as "연봉"
from employees;


-- order by [컬럼]: 정렬을 해줌,  가장 마지막째 줄.
-- desc : 내림차순
-- ASC : 오름차순 ( default로 생략되어있음.)
select salary * 12 as "연봉"
from employees
order by 연봉 ASC;
-- order by "연봉";
-- order by salary * 12;
-- order by 1; 
