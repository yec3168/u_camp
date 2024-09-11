
--**** 문제 1 ****
--"한국어교육론" 과목을 개설한 학과의 모든 교수 이름과 주소를 조회하세요.

-- 서브쿼리
select professor_name
        ,professor_address
from  tb_professor
where department_no in ( select department_no
                        from tb_class
                        where class_name = '한국어교육론');


-- 조인
-- department_no가 tb_department의 외래키이기 때문에 tb_department가 꼭 필요. 
-- tb_professor와 tb_class를 department_no로 조인이 불가능.( 결과값이 우연히 같을 수 있으나, 다른 조건으로 하면 다를 가능성이 높음)
select  p.professor_name
        , p.professor_address
from tb_professor p inner join tb_department d on d.department_no = p.department_no 
                    inner join tb_class c on d.department_no = c.department_no 
where class_name = '한국어교육론';




--**** 문제 2 ****
--김용근과 동일한 학과에 속한 학생들의 학번과 이름, 입학 년도 출력하세요.
--입학 년도가 빠른 순으로 표시하는 SQL 문장을 작성하시오.

select student_no as 학번
        , student_name as 이름
        , substr(entrance_date, 1, 2) || '년도' as 입학년도
        , department_no as "학과"
from tb_student
where department_no like (select department_no
                        from tb_student
                        where student_name like '김용근')
order by 3 ;




--**** 문제 3 ****
--환경조경학과의 전공과목들의 과목 별 평점을 파악할 수 있는 SQL 문을 작성하시오

select c.class_name as "전공과목"
        , round( avg(point), 2) as "평점"
from tb_class c inner join tb_grade g on c.class_no = g.class_no
where c.department_no in ( select department_no
                            from tb_department
                            where department_name like ('환경조경학과') ) 
    and class_type like '전공%'
group by class_name;




--**** 문제 4 ****
--“환경조경학과”와 동일한 계열의 학과 별 전공과목 평점을 파악하기 위한 SQL문을 작성하시오. 
--단, 헤더는 “계열 학과명”, “전공평점”으로 표시한다

select  d.category as "계열"
        , department_name as "계열 학과명"
        , round( avg(point), 2) as "전공평점"
from tb_department d inner join  ( select c.class_type, c.department_no, g.point
                                    from tb_class c inner join tb_grade g using(class_no) 
                                 ) cg on d.department_no = cg.department_no
where category like (   select category
                        from tb_department
                        where department_name like ('환경조경학과') )
        and class_type like '전공%'
group by d.category, department_name
order by 3 desc;
                        

                        
--**** 문제 5 ****
--미술학과와 동일한 계열의 학과정보를 출력하세요.
--"계열", "학과명", "교수 수" 를 조회하고, 교수수가 많은 순으로 정렬하세요.

select category as "계열"
        , department_name as "학과 명"
        , count( p.professor_no) as "교수 수"
from tb_department d inner join tb_professor p on d.department_no = p.department_no
where category like (   select category
                        from tb_department
                        where department_name like ('미술학과') )
group by category, department_name 
order by 3 desc;


--**** 문제 6 ****
--서가람 학생의 지도교수가 가리킨 학생들의 년도 별 평점을 조회하세요.
--평점은 소수점 1자리까지 표시합니다.
--년도가 오래된 순으로 정렬하세요.

select  student_no as "학번"
        , student_name as "이름"
        , substr(g.term_no,1, 4) || '년도' as "년도"
        , trunc( avg(g.point), 1) as "평점"
from tb_student s inner join tb_grade g using(student_no)
where coach_professor_no like ( select coach_professor_no
                                from tb_student
                                where student_name like ('서가람') )
group by student_no, student_name, substr(g.term_no,1, 4)
order by 1,2,3;


--**** 문제 7 ****
--"국어학세미나"를 수강한 학생들의 학점을 조회합니다.
--"년도", "학기", "학생명", "평점"을 조회하고, 년도가 오래된 순으로 정렬하세요.

select substr(g.term_no,1, 4) || '년도' as "년도"
        , substr(g.term_no, 6, 1) || '학기' as "학기"
        , student_name as "학생명"
        , round( avg(g.point), 2) as "평점"
from tb_grade g inner join tb_student s on g.student_no = s.student_no
where g.class_no like ( select class_no
                        from tb_class
                        where class_name like '국어학세미나' )
group by student_name, substr(g.term_no,1, 4), substr(g.term_no, 6, 1)
order by 1;



-- Ansi (서브쿼리 x)
select substr(g.term_no,1, 4) || '년도' as "년도"
        , substr(g.term_no, 6, 1) || '학기' as "학기"
        , student_name as "학생명"
        , round( avg(g.point), 2) as "평점"
from tb_student s inner join tb_grade g on  g.student_no = s.student_no
                  inner join tb_class c on  g.class_no = c.class_no
where c.class_name like '국어학세미나'
group by student_name, substr(g.term_no,1, 4), substr(g.term_no, 6, 1)
order by 1;



--------------------------------------------------------------------------------




--**** 문제 8 ****
--문학과생태학 과목을 진행하는 과의 2004년도 학기별 평점을 조회하세요.
--평점은 소수점 1자리까지만 표기됩니다.
--추출 데이터 : "년도", "학기" "평점"

select substr(term_no, 1, 4) || '년도' as "년도"
        , substr(term_no, 6, 1) || '학기' as "학기"
        , round( avg(point), 1) as "평점"
from tb_grade
where student_no in (
                        select student_no
                        from tb_student 
                        where department_no in (
                                                select department_no
                                                from tb_class
                                                where class_name like '문학과생태학'
                                                ) 
                     )
    and substr(term_no, 1, 4) like '2004'
group by substr(term_no, 1, 4), substr(term_no, 6, 1)
order by 1;



--**** 문제 9 ****
--영어영문학과에 다니는 학생들의 평점을 조회하세요.
--추출 데이터 : "지도교수명", "학생명", "평점"

select p.professor_name as "지도교수명"
        , s.student_name as "학생명"
        , round( avg(g.point), 1) as "평점"
from tb_student s inner join tb_grade g on  s.student_no = g.student_no 
                  inner join tb_professor p on s.coach_professor_no = p.professor_no
where s.department_no like (select department_no
                        from tb_department
                        where department_name like '영어영문학과')
group by s.student_name, p.professor_name;





--**** 문제 10 ****
--2001년부터 2004년까지 "국어학세미나"를 수강한 학생 중, 학점을 가장 높게 받은 학생을 조회하세요.
--추출 데이터 :  "학생명", "학기", "학점"


-- max() 사용.
select s.student_name as "학생명"
        , substr(term_no, 1, 4)||'년'|| substr(term_no, 6, 1)||'학기' as "학기"
        , g.point as "학점"
from tb_class c inner join tb_grade g on c.class_no = g.class_no
                inner join tb_student s on s.student_no = g.student_no
where c.class_name like '국어학세미나'
    and substr(g.term_no, 1, 4) between '2001' and '2004'
    and g.point in ( select max(point)
                        from tb_grade
                        where class_no in (   select class_no
                                                from tb_class
                                                where class_name like '국어학세미나' ) );


-- rank() 사용.
select s.student_name as "학생명"
        , g."학기"
        , g.point as "학점"
from tb_student s inner join (select student_no
                                        , substr(term_no, 1, 4)||'년 '|| substr(term_no, 6, 1)||'학기' as "학기"
                                        , point
                                        , rank() over( order by point desc) as "ranking"
                                from tb_grade
                                where substr(term_no, 1, 4) between '2001' and '2004'
                                    and class_no =  (select class_no
                                                     from tb_class
                                                     where class_name like '국어학세미나' )) g
                     on s.student_no = g.student_no
where "ranking" = 1;


-- rank(), rownum 사용.
select s.student_name as "학생명"
        , g."학기"
        , g.point as "학점"
from tb_student s inner join (select student_no
                                        , substr(term_no, 1, 4)||'년 '|| substr(term_no, 6, 1)||'학기' as "학기"
                                        , point
                                        , rank() over( order by point desc) as "ranking"
                                from tb_grade
                                where substr(term_no, 1, 4) between '2001' and '2004'
                                    and class_no =  (select class_no
                                                     from tb_class
                                                     where class_name like '국어학세미나' )) g
                     on s.student_no = g.student_no
where rownum = 1;

--**** 문제 11 ****
--2009년도 "공학"계열의 모든 학생들을 기준으로 평점 4.0 이상인 학생을 조회하세요.
--단, 휴학생은 제외합니다.
--추출 데이터 : "학생명", "학과명", "년도", "학기", "평점"


-- 평점을 구하지 않고, 단순히 학점이 4.0이 넘는 학생.
select s.student_name as "학생명"
        , d.department_name as"학과명"
        , cg.년도
        , cg.학기
        , cg.point
from tb_department d inner join (select  substr(term_no, 1, 4) || '년도' as "년도"
                                            , substr(term_no, 6, 1) || '학기' as "학기"
                                            , g.student_no
                                            , c.class_name
                                            , c.department_no
                                            , g.point
                                from tb_grade g inner join tb_class c on g.class_no = c.class_no
                                where substr(term_no, 1, 4) like '2009' 
                                        and g.point >= 4.0) cg
                     on d.department_no = cg.department_no
                     inner join tb_student s on cg.student_no = s.student_no
where d.category like '공학';


--- 평점을 구하고, 평점이 4.0을 넘는 학생.

select s.student_name as "학생명"
        , d.department_name as"학과명"
        , cg.년도
        , cg.학기
        , round( avg(cg.point), 1) as "평점"
from tb_department d inner join (select  substr(term_no, 1, 4) || '년도' as "년도"
                                            , substr(term_no, 6, 1) || '학기' as "학기"
                                            , g.student_no
                                            , c.class_name
                                            , c.department_no
                                            , g.point
                                from tb_grade g inner join tb_class c on g.class_no = c.class_no
                                where substr(term_no, 1, 4) like '2009' ) cg
                     on d.department_no = cg.department_no
                     inner join tb_student s on cg.student_no = s.student_no
where d.category like '공학'
group by d.department_name, s.student_name, cg.년도, cg.학기
having round( avg(cg.point), 1)>=4;



---------------------------------------------------------강사님 답-------------------------------------------

select  s.student_name as "학생명"
        , d.department_name as"학과명"
        , substr(g.term_no, 1, 4) || '년도' as "년도"
        , substr(g.term_no, 6, 1) || '학기' as "학기"
        , round( avg(g.point), 1) as "평점"
from tb_grade g inner join tb_student s on g.student_no = s.student_no
                inner join tb_department d on d.department_no = s.department_no
--where s.student_no in (select student_no
--                        from tb_student
--                        where department_no in(
--                                                select department_no
--                                                from tb_department
--                                                where category = '공학'
--                                                )
--                    )
--and substr(term_no, 1, 4) like '2009';
where substr(term_no, 1, 4) like '2009' 
        and d.category like '공학' 
group by d.department_name, s.student_name, substr(g.term_no, 1, 4), substr(g.term_no, 6, 1)
having round( avg(g.point), 1) >=4.0;             
                   
---------------------------------------------------------------------------------------------------------------  


--**** 문제 12 ****
--누적 수강생수가 가장 많았던 과목 중 상위 3개를 조회하세요.
--추출 데이터 : "과목이름", "누적수강수"


-- 중복 id는 제거 rank() 
select c.class_name as "과목이름"
            , g."누적수강수"
from tb_class c inner join (select class_no
                                , count(distinct student_no) as "누적수강수"
                                , rank () over(order by count(distinct student_no) desc) as "ranking"
                            from tb_grade
                            group by class_no ) g 
                    on c.class_no = g.class_no
where g."ranking" <=3;

-- rownum사용.
select c.class_name as "과목이름"
            , g."누적수강수"
from tb_class c inner join (select class_no
                                , count(distinct student_no) as "누적수강수"
                                , rank () over(order by count(distinct student_no) desc) as "ranking"
                            from tb_grade
                            group by class_no ) g 
                    on c.class_no = g.class_no
where rownum <=3;

-- rownum을 컬럼 값으로 넣어줌.

select c.class_name as "과목이름"
          , g."누적수강수"
from tb_class c inner join  ( select r.*, rownum as "인덱스"
                              from (select class_no
                                        , count(distinct student_no) as "누적수강수"
                                        , rank () over(order by count(distinct student_no) desc) as "ranking"
                                    from tb_grade
                                    group by class_no ) r) g 
                    on c.class_no = g.class_no
where "인덱스" <= 3;




--**** 문제 13 ****
--2005년 1학기에 평점 4.0 이상인 학과를 모두 조회하세요.
--추출 데이터 : "학과명", "평점"

-- class_no (과목의 대한 점수)
select d.department_name as"학과명"
        , cg."평점"
from tb_department d inner join (select  c.department_no
                                          , round(avg( g.point), 1) as "평점"
                                    from tb_grade g inner join tb_class c on g.class_no = c.class_no
                                    where term_no like '200501' 
                                    group by c.department_no)  cg 
                        on d.department_no = cg.department_no 
where cg."평점" >= 4.0;


-- student_no(학생의 대한 점수)
select d.department_name as"학과명"
        , cg."평점"
from tb_department d inner join (select  s.department_no
                                          , round(avg( g.point), 1) as "평점"
                                    from tb_grade g inner join tb_student s on g.student_no = s.student_no
                                    where term_no like '200501' 
                                    group by s.department_no)  cg 
                        on d.department_no = cg.department_no 
where cg."평점" >= 4.0;


--**** 문제 14 ****
--국어국문학과 학생들의 2005년 1학기 학점을 조회하세요.
--학점이 4.0 이상이면 "A학점", 3.0 이상이면 "B학점", 2.0 이상이면 "C학점", 1.0 이상이면 "D학점", 나머지는 "F학점"으로 표기합니다.



-- 학생
select cg.student_no
        ,cg.student_name
        ,cg.point
        ,(case when cg.point >= 4 then 'A학점'
             when cg.point >= 3 then 'B학점'
             when cg.point >= 2 then 'C학점'
             when cg.point >= 1 then 'D학점'
             else 'F학점' 
            end) as "학점"
from tb_department d inner join  ( select  s.department_no
                                            , s.student_name
                                            , g.point
                                            , g.student_no
                                    from tb_grade g inner join tb_student s on g.student_no = s.student_no
                                    where term_no like '200501') cg
                        on d.department_no = cg.department_no
where department_name like '국어국문학과' 
order by 2 desc;



--과목 ( 학생들을 기준이기 때문에 값이 똑같이 나왔어도, 다른 조건이면 틀릴 수 있음.)
select cg.student_no
        ,cg.point
        ,(case when cg.point >= 4 then 'A학점'
             when cg.point >= 3 then 'B학점'
             when cg.point >= 2 then 'C학점'
             when cg.point >= 1 then 'D학점'
             else 'F학점' 
            end) as "학점"
from tb_department d inner join  ( select  c.department_no
                                            , g.point
                                            , g.student_no
                                    from tb_grade g inner join tb_class c on g.class_no = c.class_no
                                    where term_no like '200501') cg
                        on d.department_no = cg.department_no
where department_name like '국어국문학과' 
order by 2 desc;
