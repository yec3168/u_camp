--**** 문제 1 ****
--지도 교수를 배정 받지 못한 학생의 수는 몇 명 정도 되는지 알아내는 SQL 문을 작성하시오.
select count(*)
from tb_student
where coach_professor_no is null;


--**** 문제2 ****
--학번이 A517178인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 
--단, 이때 출력 화면의 헤더는 “평점”이라고 찍히게 한다.

select sum(point) as "총 학점"
        , round(avg(point), 2) as "평점"
from tb_grade
where student_no like ('A517178');


--**** 문제3 ****
--성별로 휴학생이 몇명인지 출력하는 SQL문을 작성하세요.

select decode(substr(student_ssn, 8, 1), '1', '남자','2', '여자') as 성별
        ,count(substr(student_ssn, 8, 1)) as count
from tb_student
where absence_yn = 'Y'
group by substr(student_ssn, 8, 1);



--------------------------------------------------------------------------------


--**** 문제4 ****
--과목의 이름과 그 과목을 개설한 학과의 학과명을 출력하세요.
 select distinct c.class_name as "과목 이름",
        d.department_name as "학과 명"
 from tb_class c, tb_department d
 where c.department_no = d.department_no 
 order by 1;
 
 

 select distinct c.class_name as "과목 이름",
        d.department_name as "학과 명"
 from tb_class c inner join tb_department d on c.department_no = d.department_no;



 select distinct c.class_name as "과목 이름",
        d.department_name as "학과 명"
 from tb_class c inner join tb_department d using(department_no);



--**** 문제5 ****
--과목별 교수 이름을 확인 후, 이 중 ‘인문사회’계열에 속한 과목의 교수 이름을 찾으려고 한다. 
--이에 해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오. 
--단, 과목 이름으로 오름차순 정렬을 하고 동일 과목의 경우에는 교수 이름으로 오름차순 정렬한다.

 select distinct p.professor_name as "교수 이름"
        ,d.category as "계열"
       , c.class_name as "과목 이름"
 from  tb_department d, tb_professor p, tb_class c
 where d.category like ('인문사회') and d.department_no = p.department_no and d.department_no = c.department_no
 group by c.class_name, p.professor_name, d.category
 order by 2, 1;
 
 
 select distinct p.professor_name as "교수 이름"
        ,d.category as "계열"
        , c.class_name as "과목 이름"
 from tb_department d 
        inner join tb_professor p on d.department_no = p.department_no  
        inner join tb_class c on d.department_no = c.department_no
where d.category like '인문사회'
group by c.class_name, p.professor_name, d.category
order by 2, 1;
        
        
         
 select distinct p.professor_name as "교수 이름"
        ,d.category as "계열"
        , c.class_name as "과목 이름"
 from tb_department d 
        inner join tb_professor p using (department_no)  
        inner join tb_class c using  (department_no)
where d.category like '인문사회'
group by c.class_name, p.professor_name, d.category
order by 2, 1;
        
------------------------------------ 아래가 강사님 정답.
select distinct p.professor_name as "교수 이름"
        ,d.category as "계열"
        , c.class_name as "과목 이름"
from tb_department d 
        inner join tb_professor p on d.department_no = p.department_no  
        inner join tb_class_professor cp on p.professor_no = cp.professor_no
        inner join tb_class c on cp.class_no = c.class_no
 where d.category like '인문사회'  
 order by 2, 1;
 
 
 select distinct p.professor_name as "교수 이름"
        ,d.category as "계열"
        , c.class_name as "과목 이름"
from tb_department d 
        inner join tb_professor p using (department_no)  
        inner join tb_class_professor cp using (professor_no)
        inner join tb_class c using (class_no)
 where d.category like '인문사회'  
 order by 2, 1;
 

--**** 문제6 ****
--학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 문을 작성하시오

select s.student_no, s.student_name, d.department_name
from tb_student s, tb_department d
where s.department_no = d.department_no
order by 2;

select distinct s.student_no, s.student_name, d.department_name
from tb_student s inner join tb_department d on s.department_no = d.department_no
order by 2;


select distinct s.student_no, s.student_name, d.department_name
from tb_student s inner join tb_department d using (department_no)
order by 2;

--**** 문제 7 ****
--학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 
--단, 이때 출력 화면의 헤더는 “년도”, "년도 별 평점“ 으로 표시하고 과거이력부터 표시되도록 한다.

select s.student_name as "이름"
        ,substr(g.term_no, 1, 4) as "년도"
        , sum(g.point) as  "년도 별 총 합"
        , avg(g.point) as "년도 별 평점"
from tb_student s, tb_grade g
where s.student_no like 'A112113' and  s.student_no = g.student_no
group by s.student_name, substr(g.term_no, 1, 4)
order by  4 desc, 2;


select  s.student_name as "이름"
        ,substr(g.term_no, 1, 4) as "년도"
        , sum(g.point) as  "년도 별 총 합"
        , avg(g.point) as "년도 별 평점"
from tb_student s inner join  tb_grade g using (student_no)
where s.student_no like 'A112113'
group by s.student_name, substr(g.term_no, 1, 4)
order by  4 desc, 2;


select  s.student_name as "이름"
        ,substr(g.term_no, 1, 4) as "년도"
        , sum(g.point) as  "년도 별 총 합"
        , avg(g.point) as "년도 별 평점"
from tb_student s inner join tb_grade g using (student_no)
where student_no like 'A112113'                     -- using으로 공통컬럼으로 되었기 때문에 별칭을 빼줘야함.
group by s.student_name, substr(g.term_no, 1, 4)
order by  4 desc, 2;

--**** 문제 8 ****
--학과 별 휴학생 수를 파악하고자 한다. 
--학과 번호와 휴학생 수를 표시하는 SQL 문을 작성하시오. 
--단, 이때 출력 화면의 헤더는 “학과 코드명”, “휴학생 수”으로 표시하고 학과 코드명 오름차순으로 표시되도록 한다.

select *
from tb_department;

--      using은 null값을 반환하지 않음.
select department_no as 번호
        , d.department_name as "학과 코드명"
       -- , s.absence_yn
        , count(s.student_no) as "휴학생 수"
from tb_student s right outer join tb_department d using(department_no) -- right 조인을 함
where s.absence_yn is null or s.absence_yn like 'Y'                                          -- 그 결과
group by department_no, d.department_name
order by 1;


--- 0값도 포함.
select d.department_no as 번호
        , d.department_name as "학과 코드명"
        -- , s.absence_yn
        , count(s.student_no) as "휴학생 수"
from tb_student s right outer join tb_department d on s.department_no = d.department_no and s.absence_yn like 'Y'
group by d.department_no, d.department_name
order by 1;


------------------------------------------------- 강사님 답.

select d.department_no as 번호
        , d.department_name as "학과 코드명"
        , sum(decode(s.absence_yn, 'N', 0 , 'Y', 1)) as "휴학생 수"
from tb_student s, tb_department d
where d.department_no = s.department_no (+)
--    and s.absence_yn = 'Y' 
group by d.department_no, d.department_name
order by 1;



---------------------------------Ansi 배우고 나서---------------------------------------

--**** 문제 9 ****
--동명이인(同名異人) 학생들의 이름을 찾고자 한다. 
--단, 이 때 출력 화면의 헤더는 “동일이름”, “동명인 수”로 표시하고, 이름 오름차순으로 표시되도록 한다.

select student_name as "동일이름"
        , count(student_no) as "동명인 수"
from tb_student 
group by student_name
having count(student_no) >= 2
order by 1;


--**** 문제 10 ****
--‘음악학과’ 학생들의 평점을 구하려고 한다. 
--음악학과 학생들의 “학번”,“학생 이름”,“전체 평점”을 학번 순서대로 오름차순 출력하는 SQL 문장을 작성하시오 
--(Oracle 방식과 Ansi 방식 모두)

-- 오라클 방식
select s.student_no as "학번"
        , s.student_name as "이름"
        , round(avg( g.point), 2) as "전체 평점"
from tb_student s, tb_department d,  tb_grade g
where s.department_no = d.department_no
     and s.student_no = g.student_no
     and d.department_name like '음악학과'
group by s.student_no, s.student_name;

 -- Ansi
select student_no as "학번"
        , s.student_name as "이름"
        , round(avg( g.point), 2) as "전체 평점"
from tb_student s inner join tb_department d using(department_no)
                  inner join tb_grade g using(student_no)
where d.department_name like '음악학과'
group by student_no, s.student_name;



--**** 문제 11 ****
--서반아어학과 학생들의 지도교수를 게시하고자 한다. 
--학생이름과 지도교수 이름을 찾고 만일 지도 교수가 없는 학생일 경우 “지도교수 미지정”으로 표시하도록 하는 SQL 문을 작성하시오. 
--단, 출력헤더는 “학생이름",”지도교수“,로 표시하며 고학번 학생이 먼저 표시되도록 한다
--(Oracle 방식과 Ansi 방식 모두)

-- oracle
select  s.student_no
        , s.student_name as "학생이름"
        , nvl2(s.coach_professor_no, p.professor_name, '지도교수 미지정') as "지도교수"
from tb_student s, tb_department d, tb_professor p
where s.department_no = d.department_no 
     and s.coach_professor_no = p.professor_no(+)
     and d.department_name like '서반아어학과' 
order by 1;  

-- Ansi ( 만약에 using을 사용했으면 NULL값이 사라짐)
select s.student_name as "학생이름"
        , nvl2(s.coach_professor_no, p.professor_name, '지도교수 미지정') as "지도교수"
from tb_student s inner join tb_department d on s.department_no = d.department_no and d.department_name like '서반아어학과'
                  left join tb_professor p on s.coach_professor_no = p.professor_no;
                
select s.student_name as "학생이름"
        , nvl2(s.coach_professor_no, p.professor_name, '지도교수 미지정') as "지도교수"
from tb_student s inner join tb_department d on s.department_no = d.department_no
                  left join tb_professor p on s.coach_professor_no = p.professor_no    
where d.department_name like '서반아어학과';


--**** 문제 12 ****
--영어영문학과 교수들의 출생년도와 주소를 조회하라.
--단, 나이가 많은 순으로 정렬한다.
--(출생년도는 2자리로 표기한다. [ex : 71])
--(Oracle 방식과 Ansi 방식 모두)


-- oracle
select  p.professor_name as "이름"
        , to_char(to_date(substr(p.professor_ssn, 1, 2), 'rr'), 'yy') || '년생'as "출생년도"
        , p.professor_address as "주소"
from tb_professor p, tb_department d 
where p.department_no = d.department_no 
    and d.department_name like '영어영문학과'
order by 2 ;


-- Asni
select  p.professor_name as "이름"
        , to_char(to_date(substr(p.professor_ssn, 1, 2), 'rr'), 'yy') || '년생' as "출생년도"
        , p.professor_address as "주소"
from tb_professor p inner join tb_department d on p.department_no = d.department_no and d.department_name like '영어영문학과'
order by 2 ;

select  p.professor_name as "이름"
        , to_char(to_date(substr(p.professor_ssn, 1, 2), 'rr'), 'yy') || '년생' as "출생년도"
        , p.professor_address as "주소"
from tb_professor p inner join tb_department d using (department_no)
where d.department_name like '영어영문학과'
order by 2 ;



--**** 문제 13 ****
--국어국문학과에 다니는 학생 중 서울에 거주하는 학생의 "학과번호", "학생명", "휴학여부"를 출력하라.
--단, 휴학이면 "휴학", 휴학이 아니면 "정상"으로 표기한다.

-- oracle
select s.student_no as "학번"
        , s.student_name as "학생명"
        , s.student_address as "주소"
        , decode(s.absence_yn, 'Y', '휴학', '정상') as "휴학여부"
from tb_student s, tb_department d 
where s.department_no = d.department_no 
    and d.department_name like '국어국문학과' 
    and s.student_address like '서울%'
order by 1;


-- Ansi
select s.student_no as "학과번호"
        , s.student_name as "학생명"
        , s.student_address as "주소"
        , decode(s.absence_yn, 'Y', '휴학', '정상') as "휴학여부"
from tb_student s inner join tb_department d on s.department_no = d.department_no 
            and d.department_name like '국어국문학과' 
            and s.student_address like '서울%'
order by 1;

