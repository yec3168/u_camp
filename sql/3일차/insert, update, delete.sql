/*
                            insert
            - insert into [테이블이름][(열1, 열2, ..., 열n)] values(열1에 들어갈 데이터, 열2에 들어갈 데이터, ... 열n에 들어갈 데이터)
            
            - 입력대상이 되는 컬럼명을 명시하지 않으면, 모든 컬럼에 어떤 값이 저장될 것인지 타입도 정확히하여 입력.
            - null값을 명시적으로 넣을 수도 있지만, 암시적으로도 가능.
                ) 명시적인 값은 따로 열을 안 넣었을 때는 무조건 넣어줘야함
            - primary key나 not null이면 null이 안들어간다.
            - dml에서 모두 서브쿼리가 가능하다.
            - values는 생략해야함.
                ex) insert into [테이블] (열1, 열2, 열3)
                        ( select id, name, salary
                          from table
                          )
             - 서브쿼리에서 가져온 데이터 타입과  insert로 넣는 컬럼의 열이 모두 같아야함.             
                          
                          
                          
                             create
                     create table [테이블명](
                        속성명    타입,
                        속성명    타입
                    )
*/
-- drop table
drop table test;


-- craete 
create table test(
    emp_id number(6)
    , name varchar2(30)
    , salary number(10)
    , addr varchar2(1000)
    , createdt date
);

-- insert
-- 열의 값을 입력하지 않으면, 타입도 정확히 하여 값을 빠짐없이 다 넣어줘야함.
-- sysdate로 date 값을 넣을 때, 시분초까지 다 나옴.
insert into test values(1, 'one', 1000, 'seoul', sysdate);

-- 열의 값을 입력한다면, 해당 열의 값을 타입에 맞춰서 잘 넣어야함.
-- 안넣은 값은 null로 넣어짐.
insert into test (emp_id, name, salary)values(2, 'two', 2000);

-- but. 숫자를 넣을 때, 날짜를 넣을 때, 숫자형 문자열'3' 같은 데이터를 넣을 때는 문제없이 넣어짐.
insert into test (emp_id) values('3');

-- date도 마찬가지
-- 대신, 시분초는 안 들어감.
insert into test (createdt) values('24/08/11');
insert into test (createdt) values('2024-08-12');
insert into test (createdt) values('20240813');


--  but 형식에 안맞으면, to_date를 사용하거나 format을 써줘야함.
insert into test (createdt) values(to_date('08142024', 'mmddyyyy'));



-- 서브쿼리로 사용해서 값을 넣을 수 있다.
-- 대신 서브쿼리를 넣을 때, values는 안 넣음.
-- 데이터가 추가되는 테이블의 열의 개수와 서브쿼리의 열의 개수가 일치해야하고
-- 자료형도 같아야한다.
-- date, 숫자 타입은 경우에 따라 가능함.

insert into test(emp_id, name, salary, createdt)
     ( select employee_id
                , first_name
                , salary
                , hire_date
      from employees
      where department_id = 10);



commit; -- 현재까지 진행상황을 확정

-------------------------------------------------------------------------------


/*
                        update  
              - update [테이블] set  [변경할 열2] = [데이터], [변경할 열2] = [데이터], ..., [변경할 열n] = [데이터]
                [where 절로 데이터를 변경할 대상을 결정]
              - where을 안적어주면 모든값이 다바꿔짐.  
              - 열의 순서대로 넣어주면 됨.
              - 순서가 안지켜지면 안됨.
              - 거의 where은 옵션이긴 하지만 안넣으주면 모든 값이 다바꿔지기 때문에 넣어주는것이 좋음.
              
              - 서브쿼리로 where 조건도 같이 설정가능.
                        
*/
                        

-- where을 안넣으면 모든 값이 바뀜
update test
set emp_id = 10, name = '변경값', salary = 100000, addr = '바뀐 주소', createdt = sysdate;

-- 꼭 순서는 지켜줘야함
-- 열이 비어도 되지만 열끼리 자리가 바뀌면 안됨.
update test
set  name = '변경값', salary = 100000, addr = '바뀐 주소', createdt = sysdate;



--where절로 조건을 거는방법
update test
set  name = '변경값', salary = 100000, addr = '바뀐 주소', createdt = sysdate
where emp_id =3;


-- 서브쿼리를 사용해서 데이터를 수정.
update test
set  name = '변경값', salary = 100000, addr = '바뀐 주소', createdt = sysdate
where emp_id = (select employee_id
                from employees
                where department_id = 10);



-- create, commit 안하면 살릴 수 있음.
--commit 안하면 rollback 이 가능.
rollback;



--------------------------------------------------------------------------------                    

/*
                    delete
            - delete [from] [테이블이름]
             [where 조건]
            - from을 써도 안써도 상관없지만, oracle을 제외한 다른 db에서 오류날 수 있기에
              쓰는 것을 추천.
*/    
-- 전부다 지우기.
delete from test;


-- where절
delete from test
where emp_id is null;
 
 
 
-- 서브쿼리
delete from test
where emp_id like (select employee_id
                    from employees
                    where department_id = 10);
 rollback;