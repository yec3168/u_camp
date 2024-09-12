        
                            제약조건 
                    -  테이블, 열에 저장될 데이터의 특성, 조건을 지정
                 
                 1. 테이블 컬럼에서 제약조건 설정.
                   1-1. not null;
                      - 데이터에 null이 있으면 안됨
                      - 중복은 허용
                    
                   1-2.  unique;
                      - 중복 x
                      - null은 중복에서 제외한다.
                      
                   1-3. primary key;
                      - unique + not null;
                      - 중복이 안되고 null 이 안된다.
                      - 한 개만 가능함.
                      - 자동으로 인덱스 생성. -> 애매함.
                    
                   1-4. foreign key;
                      - 다른 테이블의 열을 참조
                      - 존재하는 값만 입력이 가능하다.
                      - null이 가능
                      - 기본적으로 부모를 참조하는 자식이 있을 경우 부모를 지우면 error가 난다.
                      - 부모가 지워지면 자식도 지워지는 on delete cascade
                      - 부모가 지워지면 자식은 null 이 되는 on delete set null 이 있다.
                                          
                   1-5. check;
                      - 설정한 조건식에 맞는 데이터만 입력 가능
                       ex) 000-0000-0000;
                           000000-0000000;
                    
                   1-6. default;
                      - 기본 값으로 설정한 값이 자동으로 입력되도록 하는 제약조건
                      - 사용자가 명시적으로 null 을 넣으면 null 이 들어감.
                      - 자동으로 들어가는 null 만 default 값이 들어감.

                    
                  

create table table_sample(
    id          number(6) primary key,
    email       varchar2(30),
    password    varchar2(60) not null
);

-- 제약조건으로 password에 null이 들어가지 않음.
insert into table_sample( id, email, password) values( 1, '123', '33');
insert into table_sample( id, email, password) values( 1, '123', null);


drop table table_sample;












                    2. constraint
                 - not null은 추가가 안됨. 무조건 테이블 제약조건에서만 가능.
                create table table_sample(
                    id          number(6) primary key,
                            ...,
                    
                    constraint [이름] [제약조건](컬럼목록);
                );

 
                
create table table_sample(
    id          number(6),
    email       varchar2(30),
    password    varchar2(60),
    phone       varchar2(100) constraint phone_un unique,
    
    constraint id_pk primary key (id),
    constraint email_uk unique (email)
    --constraint pwd_not_null not null (pwd)  not null은 table에만 가능.
);                

insert into table_sample( id, email, password) values( 1, '123', '33');
-- email의 unique 제약조건으로 insert가 안됨.
insert into table_sample(id, email, password) values(2, '124', '22');









                        foreign test
                        
create table foreign_test(
    one     varchar(20),
    two     varchar(20),
    dep_no  number(6) references table_sample (id) on delete set null,
    dep_no2 number(6) references table_sample (id) on delete cascade
);

drop table foreign_test;


insert into foreign_test (one, two, dep_no, dep_no2) values( '1', '1', 1, 1);

-- foreign에 없는 값은 입력 안됨
insert into foreign_test (one, two, dep_no) values( '2', '2', 100);

-- null은 가능.
insert into foreign_test (one, two, dep_no) values( '3', '3', null);





                    
                    
                    
                    
                    
                        check
                check (조건)
                    - 값의 범위를 지정해줌.
                    - 패턴을 지정.
create table check_test(
    id      number(6),
    age     number(6)  check ( age >=0), 
    phone   varchar(60) ,
    name    varchar(30)
);                    

-- age의 값이 범위를 벗어남
insert into check_test values(1, -2, '123', '이름');

insert into check_test values(1, 2, '123', '이름');


drop table check_test;


                
                
                            
                        default     
                - 기본으로 입력한 값을 자동으로 입력하게 됨.
                - 사용자가 명시적으로 null 을 넣으면 null 이 들어감
                - 자동적으로 들어가는 null 만 default 값이 들어감.
                
create table default_test(
    id      number(6),
    salary   number(10)  default 0
);   

insert into default_test (id, salary) values(1, null);
insert into default_test (id) values(2);