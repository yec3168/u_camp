
                    DDL
                - 자동으로 commit 이 되는 Auto commit; 이 있음
                - 해당 옵션은 제거가 가능함.
                
                
                1.  create
            사용법
            create table [테이블명] (
               열1     자료형(길이),
               열2     자료형(길이),
                   ...
               열n     자료형(길이),
             ) 
                    - 서브쿼리로 값을 넣어도 됨.
                    - 컬럼명도 수정이 가능함.
                    - as를 붙여야함.
                       ex) create table empCopy as(
                             select employee_id as id
                                      , salary as "연봉"
                             from employees
                       );
                       
                    
                    - 자료형으로  varchar2, number, date 등 사용이 가능하다.
                    - 길이는 varchar2만 적어줘야하고 나머지는 안적어도 됨.
                    - key 로서 작동하게 옵션을 넣거나 NULL 의 관한 옵션도 넣을 수 있다.
                            1. 열에서 조건 추가.
                        ex) create table sample(
                                id      number(6)   primary key, 
                                    ...
                                열n     자료형
                            );
                            
                            2. constraint 사용.
                constraint [명칭] [(제약조건)] [(컬럼)]
                            create table sample(
                                id      number(6),
                                    ...
                                열n      자료형,
                                constraint sample_pk primary key(id) --constraint를 사용해서 제약조건 추가.
                            );
  
--                  
create table sample(
  -- 한글은 3바이트 이기 때문에 여유롭게 잡아주는것이 좋음
  -- 영어는 1바이트
    id          number,   --primary key로서 사용.
    email       varchar2(30),
    password    varchar2(60),
    name        varchar2(30),
    createdt    date
);

drop table sample;

-- 서브쿼리로 create 하는 방법
create table empCopy as(
    select *
    from employees
);

select *
from empCopy;
















                                2. Alter
        
                          1. Add ( 컬럼을 추가 )
                Alter table [테이블명] add [컬럼] [자료형]
                    alter table sample add modifydt date;
                                
                          2. drop (컬럼을 삭제 )
                Alter table [테이블명] drop column [컬럼명]
                    alter table sample drop column modifydt;
                        
                          3. modify ( 컬럼을 수정, 테이블 명 수정.)
                Alter table [테이블명] modify [컬럼명] [데이터타입]         
                    alter table sample modify modifydt  varchar(30);    
                      - 데이터가 들어있을 경우 데이터 타입을 못바꿈 (길이만 늘리는거 가능.)    
                
                          4. rename ( 컬럼명 변경)
                Alter table [테이블명] rename column [원래컬럼명] to [바꿀컬럼명];
                    alter table sample rename column modifydt to newdt;
                
                Alter table [테이블명] rename to [바꿀컬럼명];
                     alter table sample rename to sampleRename;         


1. add 연습
alter table sample add modifydt date;
desc sample;


2. drop 연습
alter table sample drop column modifydt;
desc sample;

alter table sample drop column newdt;


3. modify 연습
alter table sample modify modifydt varchar(30);
desc sample;


4. rename 연습
 alter table sample rename column modifydt to newdt;
 desc sample;
 
 alter table sample rename to renameSample;
 desc renameSample;
 
 drop table renameSample;
 
 
 
 
 
 
 
 
 
 
 
                            Truncate;
            truncate table [테이블명]
                   - delete하고 같음, 하지만 ddl이기 때문에 rollback 이 안됨.\
                   - 즉, 테이블의 전체 데이터를 삭제함.
                   - '초기화'의 의미. Auto commit; 임.
                   - 테이블이 삭제가 되는것이 아님.
                   
   
            
insert into sample (id, email, password) values( 1, '123', '123');    

select *
from sample;

truncate table sample;











                                drop
                drop table [테이블명]
                        - 테이블 자체가 사라짐 
                        - 똑같이 DDL 임 auto commit;      
drop table sample;                        