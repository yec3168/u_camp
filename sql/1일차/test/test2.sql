--문제 10 
--정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열을 출력하시오.
select department_name as "학과 이름", category as "계열"
from tb_department
where CAPACITY between 20 and 30;

-- 문제 11 
--현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL 문장을 작성하시오.
--법학과 번호는 005입니다.

select professor_name as "이름"
from tb_professor
where department_no like '005'
order by professor_ssn ;

-- 문제 12 
--02학번 전주 거주자들의 모임을 만들려고 한다. 
--휴학한 사람들을 제외한 재학 중인 학생들의 학번, 이름, 생년월일을 출력하는 구문을 작성하시오.

select student_no as"학번", student_name as"이름", entrance_date as "생년월일"
from tb_student
where student_no like '_2%' and student_address like '전주%' and  absence_yn = 'N' ;


-- 문제 13 
--휴학 중인 학생들의 이름과 생년월일을 나이가 적은 순서로 화면에 출력하시오.

select student_name as "이름", to_char(entrance_date, 'YYYY-MM-DD') as "생년월일"
from tb_student
where absence_yn = 'Y'
order by to_char(entrance_date, 'YYYY-MM-DD') desc ; 

-- 문제 14 
--2004년 2학기에 ‘C3118100’ 과목을 수강한 학생들의 학점을 조회하려고 한다. 
--학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해 보시오.

select student_no as "학생이름", point as "학점"
from tb_grade
where term_no like '200402' and  class_no like 'C3118100'
order by point desc, student_no;

-- 문제 15 
--주소지가 충남이나 경기도인 학생들 중 1900년대 학번을 가진 학생들의 
--이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오.

select student_name as "이름", student_no as "학번", student_address as"주소"
from tb_student
where (student_address like('충_남%') or student_address like('경기%')) and student_no not like('A%')
order by 1;


-- in이 안된 이유는 정확한 값이 아니기 때문에 안됨.
--        select student_name, student_no, student_address
--        from tb_student
--        where (student_address in ('충남%', '경기%')) and student_no not like('A%')
--        order by 1;


-- 문제 16 
--교수 중 이름이 세 글자가 아닌 교수가 두 명 있다고 한다. 
--그 교수의 이름과 생년월일을 화면에 출력하는 SQL 문장을 작성해 보자.
select professor_name as "이름", to_char(to_date(substr(professor_ssn,1,6), 'rrmmDD'), 'YYYY-MM-DD') as "생년월일"
from tb_professor
where length(professor_name) > 3 or  length(professor_name) < 3;


-- 문제 17 
--2000년도 이후 입학자들은 학번이 A로 시작하게 되어 있다. 
--2000년도 이전 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오.

select student_no as "학번", student_name as "이름"
from tb_student
where student_no not like ('A%');
