                        
                    
                    데이터 사전(데이터 딕셔너리)
              - 데이터베이스를 구성하고 운영하는데 필요한 정보
              - 시각적으로 볼 수 있는 뷰
               user_ : 사용자가 소유한 정보
               All_ : 접속한 사용자나 허가받은 객체
               DBA_ : 데이터베이스 관리 권한을 가진 사용자가 조회.
               
               
                    
                    시퀀스
               - 번호를 자동으로 증가됨
               - 일렬번호를 생성하여 자동으로 증가 됨.
                 ex) create sequence [시퀀스 이름] 
                        [increment by n] --n만큼 증가 
                        [start with n]  -- 몇 부터 시작할 것인지.
                        [maxvalue n || nomaxvalue]
                        [minvalue n || nominvalue]
                        [cycle || nocycle]
                        [cache n || nocache]
                   ;
                - 옵션 나머지는 default로 설정함.
               


-- 생성.
create sequence seq_emp
    start with 1
    increment by 1
;


-- 현재 시퀀스 번호.
-- 최초로 한 번은 수행되어야 아래 쿼리가 수행됨.
select seq_emp.currval 
from dual;


-- 시퀀스를 한 번 진행함.
-- 처음 시퀀스를 '1'을 증가시킬 때도 사용함.
select seq_emp.nextval
from dual;



drop sequence seq_emp;


----------------------------------------------------------------------------------------


                notice 테이블

    1. 시퀀스 생성
create sequence notice_seq
    start with 1
    increment by 1
;

drop sequence notice_seq;

   2. notice테이블 생성
   
create table notice(
    num         number(10),
    title       varchar2(100) not null,
    content     varchar2(1000) default '' not null,
    hit        number(10) default 0 not null,
    createdt    date    not null,
    
    constraint num_pk primary key (num)
);

select *
from notice;

drop table notice;








