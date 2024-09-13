 /*
                    다중열 서브쿼리
                - 쿼리의 결과 값의 '열'이 여러 개인 것.
                  ex) select department_no, department_name
                - 괄호로 묶어 줘야함.
*/
select *
from employees
where (department_id, salary) in ( select department_id, 10000
                                   from departments);
                                   
                                   
                    
/*                  
                    
                        From절 서브쿼리
                    - '인라인 뷰' 라고 불림
                    - 가상의 테이블을 만듦
                    - '뷰'에 테이블이 생김( 물리적인 뷰 )
                     ex)  from ( select student_no, student_address 
                                 from  tb_student
                                 where student_address like ('서울%'))
*/

select *
from (select student_no, student_address
      from tb_student)
where student_no like ('A_%');

                
                
                
                
/*                      
                            with 절
                        -쿼리 맨 윗 줄에 가상의 테이블을 만드는 것., 실제x, 임시 x , 뷰 x
                        -때에따라 성능을 올려줌
                        -자주사용하는 쿼리를 만들 때 사용.
                         ex) with min_salary as(
                                 select min(salary)
                                 from employees
                              );
*/

 with min_salary as(
        select min(salary) as min
        from employees
)

select *
from employees
where salary like ( select min
                    from min_salary);
                    
                    
                    
 
 /*                   
                            rownum
            사용법
             select rownum;
                        - top and 방식    
                        - 각 행의 '인덱스'(번호)를 넣는 것.
                        - 중복된 값이 없음.
                        - 실제 컬럼으로 인식하지 않은 이상, 1이 아닌 다른 값만 뽑아 내는것은 어려움
                           ex) rownum between 11 and 20;
                        - 만약, 1부터가 아닌 예를들어 11이나 50부터 시작하거나 해당 값만 얻고 싶다면,
                           컬럼으로서 인식하도록 만들어야함.
                           ex) select *
                                from (select rownum as "인덱스"
                                    , s.*
                                    from tb_student s) 
                                 where "인덱스" between 50 and 60;
                        - rownum는 바로 where절에서 사용이 가능함.
                          ex)  select *
                                from employees
                                where rownum <=5;
*/

    -- 1. 일반적인 rownum 사용법.
    select *
    from employees
    where rownum <=5;
    
    
    -- 2. 컬럼으로 등록하는 법.
    select *
    from (select rownum as "인덱스"
        , s.*
        from tb_student s) 
     where "인덱스" between 50 and 60;   
     
     --3. 안되는 경우 
     -- 값이 안나오는 것.
     -- 오류가 발생하는 것이 아니다.
       select rownum as "인덱스"
                , s.*
        from tb_student s
        where rownum between 11 and 20;         
        
        
        
        
        
   /*     
                            Rank
            사용법
            select rank() over( order by [컬럼 목록] )
                    partition by를 사용해서 그룹화 할수 있다.
                   - order by를 한 후 순위를 매기는 것.
                   - group by를 통해 각 그룹별로 등수를 매길수 있음.
                   - 중복된 값이 있을 수 있다.
                   - order by시 컬럼은 여러 개가 올 수 있다.
                     ex) select rank() over(order by salary desc) ;
   */
   
select employee_id
            ,salary
            , ranking
from ( select  e.*
            , rank() over( order by salary desc ) as ranking
        from employees e)
where ranking < 10;


--------------------------------------------------------------------------------
 /*
                            create
             사용법
             create table [테이블명](
                컬럼명     타입(길이),
                컬럼명     타입(길이),
             );
             - 테이블을 만들 때 사용한다.
             - 컬럼명과 타입은 띄어쓰기로 구분한다.
             - 길이를 지정해야한다.
                 ex) create table test_table(
                    id     number(6),
                    name    varchar2(30),
                    salary  number(30),
                    createdt    date
                 );
                 
             - create시 자동으로 commit이 들어간다.  
             - 서브쿼리 가능함.
 */
 
 drop table test_table;
 
 create table test_table(
     id         number(6),
    name        varchar2(30),
    salary      number(30),
    createdt    date

 );
 
 
 
 
 
/*                        
                            insert
             사용법 
             insert into [테이블 이름] (열1, 열2, ... 열 n) values(열1 값, 열2 값,..., 열n값) 
             
                    - 열은 생략이 가능하지만, values의 값을 무조건 다 넣어줘야함.
                    - 열은 일부분만 넣어도 가능. values의 값은 타입에 맞게 적어줘야함
                    - 값으로 null 은 가능하나, primary key 나 not null 로 정의된 속성은 null이 안됨.
                    - 서브쿼리도 넣을 수 있다.
                    - sysdate 로 값을 넣을 수 있다. 
                        (시분초까지 다 들어감.)
                       ex) insert into test_table( createdt) values(sysdate);
                       
                    - 타입이 number, date 이라면, '3'을 넣거나 '2024-09-11', '24/09/11', '20240911'
                      같이 문자열로 넣어도 값이 넣어짐.
                        ****(문자열로 넣을 경우 시분초는 안들어감)****
                        ex) insert into test_table (createdt) values('20240911');
                            insert into test_table (createdt) values('2024-09-11');
                            insert into test_table (createdt) values('24/09/11');
                            insert into test_table (employee_id) values('1');
                            
                     - 만약, 문자열이 형식이 알맞지 않으면 따로 포맷으로 지정해줘야한다.
                        ex) insert into test_table (createdt) values( to_date('09112024', 'mmddyyyy'));
 */
 
 
--    insert에 '열'을 안 넣어줬을 때.
--- 값을 무조건 타입에 알맞게 잘 넣어줘야한다.
--- null값을 넣어(명시적 null)도 괜찮지만, 조건에 따라 안될수도 있다.
insert into test_table values(1, '첫번째', 1000, sysdate);
 
 
--      insert에 열을 넣어줬을 때
-- 해당 열에 맞는 타입에 맞춰서 잘 넣어줘야함
-- 포함되지 않은 열은 자동으로 null이 들어간다.(암시적 null)
insert into test_table (id, name, createdt) values(2, '두번째', '20240911');


--      숫자와 데이터를 넣을 때 문자열로 넣는 방법.
insert into test_table (id, name, createdt) values('3', '세번째', '2024-09-12');
insert into test_table (id, name, createdt) values('4', '네번째', '24/09-13');
-- 형식이 안맞으면 format을 지정해줘야함.
insert into test_table (id, name, createdt) values('5', '다섯번째', to_date('09142024', 'mmddyyyy'));



--      서브쿼리로 데이터를 넣을 때.
-- 서브쿼리로 데이터를 넣을 때, 추가되는 데이터의 열과 서브쿼리의 열이 일치해야하고 자료형도 같아야한다.
-- values는 생략한다.

insert into test_table (id, name, salary, createdt)
   ( select employee_id
                , first_name
                , salary
                , hire_date
    from employees
    where department_id in (10, 20));
    
    
 
 
 
 /*   
                            commit, rollback
                    1. commit
                     - 현재 메모리상에만 저장된 값을 실제 데이터베이스에 저장시킴.
                     - 커밋시 다시 rollback이 불가능
                     - create에 기본적으로 들어있음
                     
                    2. rollback
                    - 최신commit전으로 되돌아감.
*/

commit;





/*
                            update
            사용법
            update [테이블] set 열1 =값, 열2 =값,... 열n = 값
                [where 조건문]
        
                - where을 안해주면 모든 row가 다 바뀜
                - 열의 순서대로 넣어줘야한다. 
                - 생략된 열이 있어도 된다.
                - 서브쿼리도 넣을 수 있음.
*/    

--      where절을 안 넣으면.
-- 모든 row의 값이 바뀜.
update test_table 
 set salary =1000;


rollback;



--      where절을 넣으면
-- 조건에 해당하는 row만 바뀜.
update test_table
set salary = 5000
where salary is null;

rollback;



--      여러 개의 열의 값을 바꿀 때.
-- 순서는 지켜줘야함.
-- 오류는 나지 않지만 업데이트가 정상적으로 진행하지 않음.
update test_table
set id = 100, salary = 50000
where id like 4;

-- 오류는 나질 않지만, 정상적으로 쿼리작동이 안됨.
update test_table
set  salary = 50000, id = 100
where id like 4;

rollback;




--    서브쿼리를 넣을 때.
update test_table
set salary = 2000
where id in ( select employee_id
                from employees
                where department_id in (10, 20) );

rollback;     
        
        
        
        
        
        
        
        
        
        
        
/*       
                        delete
           사용법
           delete [from] [테이블]
            [where 조건문]
            
                 - delete도 where절을 넣어주는것이 좋음
                 - from은 있어도 되고 없어도 되지만 oracle을 제외한 다른 db에서 오류가 발생할 수 있기 때문에
                   붙여주는 것이 좋음.
                 - 서브쿼리를 붙일 수 있음.

*/

--      where절 없이
delete from test_table;

rollback;



--      where절 있음.
delete from test_table
 where salary is null;
 
 rollback;
            
            

--      서브쿼리
delete from test_table
 where id in ( select employee_id
                from employees
                where department_id in (10, 20));
                
rollback;