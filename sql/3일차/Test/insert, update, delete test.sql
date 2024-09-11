-- ****문제 1****
--학번 'A413042' 박건우 학생의 주소가 '서울시 종로구 숭인동 181-21'로 변경되었다고 한다.
--주소지를 정정하기 위해 사용할 수 있는 sql문

select *
from tb_student
where student_no = 'A413042';


-- update
update tb_student
set student_address = '서울시 종로구 숭인동 181-21'
where student_no = 'A413042';

rollback;



-- ****문제 2****
-- 성적 테이블에서 휴학생들의 성적을 제거하시오.

select *
from tb_grade;

select distinct s.student_no
from  tb_student s 
where s.absence_yn = 'Y';

select s.student_no
from tb_grade g inner join tb_student s on g.student_no = s.student_no
where s.absence_yn = 'Y';


-- from 절을 붙여주는것이 좋음.
-- 서브쿼리
delete from tb_grade
where student_no in (select distinct s.student_no
                        from tb_grade g inner join tb_student s on g.student_no = s.student_no
                        where s.absence_yn = 'Y' );
                        
                   
rollback;




-- ****문제3****
--의학과의 김명훈 학생의 2005년 1학기 수강과목인 '피부생리학' 점수를 3.5로 수정하시오.


update tb_grade
set point = 3.5
where class_no like ( select class_no
                   from tb_class
                   where class_name like '피부생리학')
                   
and student_no like (select student_no
                     from tb_student 
                     where department_no like ( select department_no
                                                from tb_department
                                                where department_name like '의학과')
                          and student_name like '김명훈')                      
and term_no = '200501';


rollback;

/*
        select *
        from tb_grade
        where class_no = ( select class_no
                           from tb_class
                           where class_name like '피부생리학')
        and student_no like (select student_no
                             from tb_student 
                             where department_no like ( select department_no
                                                        from tb_department
                                                        where department_name like '의학과')
                                  and student_name like '김명훈')
        and term_no = '200501';

*/

