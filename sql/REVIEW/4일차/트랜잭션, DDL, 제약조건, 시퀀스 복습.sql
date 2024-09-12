
트랜잭션
 - 한 개 이상의 DML 이 실행되는 작업이다.
   (insert, delete, update)
 - 더 이상 쪼갤 수 없는 최소 작업 수행 단위.
 - 모두 문제없이 실행되거나, 아무것도 실행되지 않은 상태( 진행중인 모든 작업을 취소)
 - TCL (Transaction control language)
   : rollback commit savepoint;
     1. rollback
      - 마지막 commit 으로 작업을 되돌림.
     2. commit
      - 현재까지 진행했던 모든 dml 을 데이터베이스에 영구적으로 반영함.
      
    원자성 : dml이 모두 실행이되거나 모두 실행이되지 말아야한다.
    일관성 : 데이터들이 제약조건과 규칙에 맞춰 일관성을 유지해야한다.
    고립성 : 트랜잭션끼리 서로 고립되어야한다.
    지속성 : 트랜잭션에  모든 데이터 변경사항이 데이터베이스에 즉시 반영된다.
      


세션
 - 쉽게 말하면 '로그인을 하고 로그아웃까지의 시간'을 의미한다.
 - 하나의 '세션'은  여러 개의 트랜잭션으로 구성된다.
 - 다른 세션에서 트랜잭션을 종료할 때 까지 데이터를 조회만 가능하며 '읽기 일관성'이라고 부른다.
 - select 를 통해 조회를 하는 것은 문제없다.
 -  DML(insert, update, delete)을 통해 작업시 세션A가  '테이블'이거나 'row'를 작업중이면 해당 작업은 'lock'이 걸린다.
   세션 B 가 접근을 하더라도 세션 A 의 작업이 완료가 되어야 세션 B의 작업을 진행 할 수 있다.
 - 그리고 세션 A 의 작업이 TCL(commit, rollback)되지 않았다면, 세션 B 를 통해 조회를 해도 데이터 베이스에 반영이 되지않아
   세션 B와 세션 A의 조회 결과가 다를 수 있다.

   
       세션A                                         세션B    
        - delete from test_table
          where id = 5;                           ( A세션의 작업을 기다림)
          
          **2개의 행이 삭제**
          ---------------------------------------------------------------  
          select *                                   select *
          from test_table;                           from test_table;
          
          6개의 행이 조회.                            8개의 행이 조회.
          
  ------------------------------------------------------------------------------------
  
     /*        헷갈릴 수 있는 것.     */

view
 - view는 가상의 테이블을 생성하고 '실제 테이블을 저장하지 않는다'
 - alter를 통해 속성의 변경이 가능하다.
 
정규화
 - '중복을 제거'하는 목적으로 사용된다.,
 - '무결성'과 '일관성'을 유지한다.
 - 성능이 저하될 수 있다.
 
서브쿼리
 - 항상 메인쿼리 보다 '먼저' 실행된다.
 - 조인과는 다른 방식으로 실행.
 
rownum
 - 행의 순서를 나타내는 가상의 번호.
 
with 절;
 - 임시적인 이름을 가진 집합 테이블, 실제로 저장 x, 임시테이블x
 - 쿼리의 가독성을 높이고, 비슷한 서브쿼리가 반복되어 사용되면 성능이 높아짐.
 - 쿼리의 순서는 바뀌지 x
 
 
 포맷팅
 - 'd'는 일요일 1 월요일 2 ... 토요일 7처럼  입력된 문자열의 요일을 나타냄.
 - a 문자열을 b 로 포맷할 때, a보다 짧은 형태로 만들면 오류.
 select to_char( '100000', 'L999,999')
        , to_char( '100000', '999,999') 
        , to_char( '100000', 'L9,999,999') 
        , to_char( to_date('2024-10-01', 'YYYY-MM-DD'), 'd')
       -- , to_char( '100000', '99,999')  짧으면 오류
 from dual;
  --------------------------------------------------------------------------------------------------------------------------------------
  
  
  
DDL
 -  자동으로 commit 되며,  Auto Commit;이 있으며, 옵션은 수정이 가능함.
 -  트랜잭션에 속하지 않는다.
 -  즉시 영구적으로 반영하기 때문에, auto commit 을 제거한다고 하여도 독립적으로 작동하기 때문에 트랜잭션에 속한다고 볼 수 없다.
   ex) create, alter, drop, truncate;
   
1. create
 - 자동으로 commit 되는 DDL
 - 서브쿼리로 생성 o
 - 자료형으로 number, date, varchar2 등이 있다.
 - number, date 길이를 따로 정의하지 않아도 됨.
 - varchar2 길이 '필수'
 - 테이블 명으로 ( '$', '_' '#' 사용가능)
   30byte 조건에 숫자로 시작하면 안된다.
   열은 중복되어선 안된다.
 - '제약조건'을 사용하여 제한을 걸 수 있다.
   1. 테이블 생성시 제약조건 설정.
    - not null은 테이블의 생성시 밖에 설정이 안된다.
        ex) create table [테이블명] (
             id         number primary key,
             name       varchar(20) not null,
             dep_no     number(6) references [테이블명](테이블의 컬럼)
          );
    
    2. constraint 제약조건
        ex) create table [테이블명] (
             id         number,
             name       varchar(20) not null,
             dep_no     number,
             
             constraint tt_id_pks primary key(id),
          );
    
    *. 서브쿼리 create
       ex) create table [테이블명] as(
                select *
                from employees
                where employee_id < 100
          );
    *. 열 구조만 가지고 데이터는 저장되지 않는 테이블 구현
      ex) create table [테이블명] as
           select *
           from 테이블
           where 1 <> 1;
--------------------------------------------------

-- create 생성.
create table review_table(
    id      number,
    email   varchar(20) not null,
    pwd     varchar(20) not null,
    createdt    date,
    
    constraint rt_id_pk primary key(id),
    constraint email_uk unique(email)
);

--------------------------------------------------


2. Alter
 - 테이블 이름을 바꾸거나 열을 추가, 수정, 삭제, 이름변경을 함.
 - '테이블 삭제'는 불가능!!
 
 2-1. Add(컬럼을 추가)
 - alter table [테이블 명] add [컬럼] [자료형]
 
 2-2. drop (컬럼을 삭제)
 - alter table [테이블명] drop column [컬럼명]
 
 2-3. modify (컬럼을 수정)
 - alter table [테이블명] modify [컬럼명] [자료형]
 
 2-4. rename
 - alter table [테이블명] rename column [기존컬럼명] to [바꿀이름]
 - alter table [테이블명] to [바꿀테이블명]
 
 
--------------------------------------------------
 
 1. add
 alter table review_table add add_col varchar(20);
 
 2. modify
 alter table review_table modify  add_col number;
 
 3. rename
 alter table review_table rename column add_col to rename_col;
 
 4. drop 
 alter table review_table drop column rename_col;
 
 SELECT MOD(15, 4) FROM dual;
 
--------------------------------------------------


3.  truncate
- 테이블의 모든 데이터를 삭제하는 것.
- rollback이 안됨.
- '초기화'에 의미로 Auto commit; 이있음
- 테이블이 지워지는게 아니다.
    ex) truncate table [테이블명];
    
    
--------------------------------------------------
insert into review_table (id, email, pwd) values ( 1, '1', '1');

truncate table review_table;




4. drop
- 테이블을 완전히 삭제

drop table review_table;






------------------------------------------------------------------------------------------------------------------------------------------------------



제약조건
- 테이블, 열을 생성할 때 특성, 조건을 지정하는 것.
- '테이블에 속성', 'constraint' 방법이 존재.
- not null, primary key, foreign key, check, default, unique ...

1. not null
 - 오직 '테이블'에서 열을 정의 할 때만 가능하다.
 - 중복을 o , null x
 
2. unique
 - 중복 x, null o

3. primary key
 - not null + unique
 - 중복 x, null x

4. foreign key
 - 다른 테이블의 열을 '참조' 하는 것.
 - '존재하는 값' or null 값만 입력 가능
 - 기본적으로 부모를 참조하는 자식이 있다면, 부모를 지울 경우 error 가 발생.
 - references 시 옵션을 줄 수 있음
   1. on delete cascade
    - 부모가 지워지면 자식도 지워짐
   2. on delete set null
    - 부모가 지워지면 자식은 null

5. check
 - 열을 정의할 때, 값의 범위를 지정해 줌
  ex) age  check (age>10)
 - 여러 열에 대해 동시에 사용할 수 있다.
 - 테이블 생성 시 또는 이후에 추가할 수 있다.
 - 기본 키와 중복해서 사용할 수 없다.

6. default
 - 사용자가 명시적 null 을 입력하지 않았을 때 발생하는 자동적 null 대신 default로 설정해준
   값을 넣어줌.
  ex) salary number(10) default 0;
  
  
  
-------------------------------------------------

create table constraint_table(
    id     number(6) primary key,
    email   varchar(20) unique not null,
    pwd     varchar(20) not null,
    foregin_no1  number references review_table(id),
    foregin_no2  number references review_table(id) on delete cascade,
    foregin_no3  number references review_table(id) on delete set null,
    
    주민등록번호  varchar(20),
    폰번호     varchar(20),
    age         number(6) check( age>0),
    salary      number(10) default 0,
    
    constraint user_min_uk  unique(주민등록번호, 폰번호)
    
);

drop table constraint_table;



---------------------------------------------------------------------------------------------------------------------------------------------------


데이터 사전
 - 데이터베이스를 구성하고 운영하는데 필요한 정보
 user_ : 사용자가 소유한 정보
 All_ : 접속한 사용자나 허가받은 객체
 DBA :  데이터 베이스의 관리 권한을 가진 사용자가 조회.
 v$_ : 데이터 베이스 성능 관련 정보
 

시퀀스
 - 번호를 자동으로 생성
 - create 로 생성한다.
 ex) create sequence [시퀀스 이름] 
        [increment by n] --n만큼 증가 
        [start with n]  -- 몇 부터 시작할 것인지.
        [maxvalue n || nomaxvalue]
        [minvalue n || nominvalue]
        [cycle || nocycle]
        [cache n || nocache]
     ;
 - currval :  마지막 시퀀스 출력, 아무것도 없으면 error
 - nextval :  시퀀스를 한 번 시작함. 처음 1 증가 시킬 때 사용.
 
 

create sequence seq_test
    increment by 1
    start with 1
;

-- currval 
select seq_test.currval
from dual;

-- nextval
select seq_test.nextval
from dual;