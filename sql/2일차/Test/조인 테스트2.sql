--**** 문제 14 ****
--학생의 출생 년도가 80년인 학생 중, 여학생만 조회하세요.
--그리고, 김씨 성을 가진 학생만 조회하세요.

select *
from tb_student
where student_ssn like ('80%') 
    and substr(student_ssn, 8, 1) = 2 
    and student_name like('김%');
    
    
--**** 문제 15 ****
--category가 "예체능"인 학과의 정원을 출력하고, 15% 증원된 정원도 출력하세요.
--단, 증원된 정원은 소수점 첫 자리에서 반올림하여 표기 합니다.
--증원된 정원이 40이상이면 "대강의실", 30 이상이면 "중강의실", 나머지는 "소강의실로 표기하세요.
--
--ex)    학과명      정원    증원된 정원      강의실 크기
--    -------------------------------------------------------
--       체육학과     10           12               소강의실
--       .....
       
       
select department_name
        ,capacity as "현재정원"
        , round((capacity +(capacity *0.15)), 0) as "증원된 정원"
        , (case when round((capacity +(capacity *0.15)), 0) >= 40 then '대강의실' 
                when round((capacity +(capacity *0.15)), 0) >= 30 then '중강의실'
                else '소강의실' end) as "강의실 크기"
from tb_department
where category like '예체능';


--**** 문제 16 ****
--주소지가 "경기" 또는 "인천"인 학생 중, 1900년대에 입학한 학생들을 조회하세요.
--오늘날짜를 기준으로 입학후 기간이 얼마나되는지 계산하여 출력하세요. (단위는 년도)
--"학생명", "입학 일자", "입학 후 기간"을 출력합니다.


select student_name as "학생명"
        , to_char(entrance_date, 'YYYY') || '년' as "입학날짜"
        , to_char(sysdate, 'YYYY') - to_char(entrance_date, 'YYYY') || '년도' as "입학 후 기간"
from tb_student
where (student_address like '경기%' or student_address like '인천%') 
       and entrance_date < to_date('2000-01-01');
       
       
       
--**** 문제 17 ****
--"예체능"과 "공학" 계열에 속한 과들을 출력하고, 그 과에 속한 학생의 수를 조회하세요.
--단, 속한 학생이 없으면 표기하지 않습니다. 
--(-. 학생이 없어도 표기할 수 있으면 한번 도전해 보세요....)
--"계열명", "학과명", "학생수"를 출력하세요.


-- null 값 제외
select  d.category as "계열명"
        , d.department_name as "학과명"
        , count(s.student_no) as "학생 수"
from tb_department d inner join tb_student s on d.department_no = s.department_no and d.category in ('예체능', '공학')
group by d.category, d.department_name
order by  3 desc;


-- null값 포함
select  d.category as "계열명"
        , d.department_name as "학과명"
        , sum( decode( s.student_no, NULL, 0, 1)) as "학생 수"
from tb_department d left outer join tb_student s on d.department_no = s.department_no 
where d.category in ('예체능', '공학')
group by d.category, d.department_name
order by 3 desc;


select  d.category as "계열명"
        , d.department_name as "학과명"
        , sum( decode( s.student_no, NULL, 0, 1)) as "학생 수"
from tb_department d , tb_student s 
where d.department_no = s.department_no (+)
    and d.category in ('예체능', '공학')
group by d.category, d.department_name
order by 3 desc;
