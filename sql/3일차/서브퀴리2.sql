--                다중열 서브쿼리
--            - 서브쿼리의 결과 `열(속성)`이 여러 개인 것.
--             ex) select department_no, department_name
                                  

  
select *
from tb_grade
where (student_no, point) in (select student_no, 3
                             from tb_student);
                                
    
            
--                2. From 절의 서브쿼리 (인라인 뷰)
--            - 가상의 테이블을 만드는 것.
--            - '뷰'에 테이블이 생김 (물리적인 뷰)
--             ex) from ( select student_no, student_address 
--                        from  tb_student
--                        where student_address like ('서울%'))


select *
from ( select student_no, student_address
       from tb_student
       where student_address like ('서울%'))
where substr(student_no, 1, 2) like('A_');



--                    3. with 절
--                - 쿼리 맨 윗 줄에 미리 서브쿼리를 뽑아 내는 것.
--                - 가상의 테이블을 만드는 것이라 직접 사용 가능.
--                    ex)with sample as(
--                            select max(point) as max
--                                    , min(point) as min
--                                    , avg(point) as avg
--                            from tb_grade
--                    )
                        
with sample as(
    select max(point) as max
            ,min(point) as min
            , avg(point) as avg
    from tb_grade
)

select *
from sample;



--------------------------------------------------------------------------------
/*
                 rownum
        - 행의 인덱스(실제 컬럼인 마냥)를 넣음.
        - 중복된 값이 있을 수 없음.
            ex) select rownum as "인덱스, s.*
        - 1부터 10까지 뽑는건 가능
            ex) select rownum as "인덱스"
                        , s.*
                from tb_student s
                where rownum between 1 and 10;
        - 실제 컬럼으로 인식하지 않은 이상 1이아닌 11 부터 20까지 출력하라( x )
             ex) select rownum as "인덱스"
                        , s.*
                from tb_student s
                where rownum between 11 and 20;
            해결) 해당 쿼리를 from 서브쿼리로 새로운 뷰를 만듦.
*/

-- 가능
select rownum as "인덱스"
        , s.*
from tb_student s
where rownum between 1 and 10;


-- 불가능
select rownum as "인덱스"
        , s.*
from tb_student s
where rownum between 11 and 20;

-- 해당 쿼리를 from 서브쿼리로 하나의 테이블(뷰)로 만들면 가능.
select *
from (select rownum as "인덱스"
        , s.*
        from tb_student s) 
where 인덱스 between 11 and 20;

-- 이름순으로 정렬 후 rownum 적용.
select rownum  as "인덱스"
        , s.*
from ( select *
        from tb_student
        order by student_name) s;


-------------------------------------------------------------------------------


/*
                    Rank
                - 중복된 값이 있을 수 있음. (값이 같다, group by)
                 ex) 1, 2, 2, 4
                -  rank() over(order by 컬럼 );
                 ex) select first_name,
                        rank() over(order by salary desc );

*/

select *
from (  select first_name
            , salary
            , rank() over( order by salary desc) as ranking
        from employees )
where ranking < 10;
