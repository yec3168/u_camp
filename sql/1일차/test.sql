-- 문제 ( tb_student)
--도서관에서 대출 도서 장기 연체자들을 찾아 이름을 게시하고자한다.
--그 대상자들의 학번이 다음과 같을 때 대상자들을 찾는 적절한 sql 문장을 작성
-- 학번 : A513079 a513090 a513091 a513110 a513119
 
 select student_name
 from  tb_student
 where student_no in ('A513079', 'A513090', 'A513091',  'A513110', 'A513119');
 
 -- 문제 ( tb_professor )
-- 총장을 제외하고 모든 교수들이 소속 학과를 가지고있다.
-- 총장의 이름을 알아낼수 있는 sql문을 작성
 
 select professor_name
 from tb_professor
 where DEPARTMENT_NO is null;
 
 
 -- 문제 ( tb_student)
-- 전상상의 착오로 학과가 지정되어있지 않는 학생의 학생번호, 학생이름을 작성하는 sql

select student_no, student_name
from tb_student
where department_no is null;

-- 문제 ( tb_class)
-- 수강신청 중 선수과목이 있는 과목의 과목이름과 번호를 조회.

select class_name, class_no
from tb_class
where preattending_class_no is not null;


-- 문제 ( tb_department )
--학과 이름과 계열을 표시
--단, 출력 헤더는 "학과 명", "계열"로 표시하도록 한다.

select department_name as "학과 명", category as "계열"
from tb_department;



--문제 ( tb_department )
--어떤 계약(category)가 있는지 조회
select distinct category as "계열"
from tb_department;


--문제 ( tb_student )
--학생이름과 주소지를 표시
--단, 출력헤더는 "학생이름" "주소지"로 등록
--정렬은 이름으로 오름차 순.

select student_name as "학생 이름", student_address as "주소지"
from tb_student
order by 1 ;