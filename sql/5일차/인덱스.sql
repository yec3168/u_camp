인덱스
 - b-tree 구조로 만들어짐
 - 데이터의 검색 성능 향상을 위해 테이블 열에 사용하는 객체
 - 인덱스(unique 가 많아짐)가 많으면 '데이터 삽입' or '인덱스 유지비용(저장공간)' 이라는 등 성능이 떨어질 수 있음.
 - primary key 를 unique 사용하면 자동으로 인덱스가 생김.  
 - 'null'은 순서로 색인하지 않음 -> 순서로 인식하지 않음.
 - '일반인덱스'는 중복을 허용하나  ' unique 인덱스' 는 중복을 허용하지 않음.
 - alter 사용이 가능
 - full scan : 데이터 하나를 찾기 위해서 모든 것을 확인 함.
  ** '테이블 생성시 인덱스가 자동생성된다' -> 일부만 맞음.
     생성
     create index [인덱스이름] on [테이블명](컬럼 목록)


create table idx_test as
 select *
 from tb_grade;
 
 
 insert into idx_test 
   (select *
    from tb_grade
    );

commit;



select *
from idx_test
where student_no in ('A131364', 'A231111');

-- 인덱스 생성
create index ix_test on idx_test (student_no);
    

drop table idx_test;
drop index ix_test;








--------------------------------------------------------


view 
 - 가상의 테이블이다.
 - 실제로 데이터가 저장되지 않음.
 - alter 을 통해 변경이 가능하다.
 - 서브쿼리랑 비슷한 방식으로 하지만, 서브쿼리랑 달리 하나의 객체로 만듦
 - 편의성 ( 복잡도 완화)
 - 보안성 ( 일부 데이터만 노출 )
 - dml 은 제약이 많음.
   reason ) 실제 테이블이 아니기 때문에.
     단일 뷰는 ㄱㅊ
     복잡한 뷰는 안됨
 - replace 옵션은 기존에 뷰가 있으면 교체
 - noforce : default 옵션, 테이블이 없으면 안 만들어짐.
 - '제약조건'을 추가가 가능함.
 
 
 create [or replace] [force || noforce] view [뷰 이름] (열1, 열2, ... 열n)
 as (서브쿼리)
 [with check option [constraint 제약조건]] -- 값이 들어오는 범위를 지정
 [with read only [constraint 제약조건]] -- 오직 select만 가능한 경우 (dml 안됨);
 
 
 
 

create or replace view test_view (one, two, three)
as ( select student_no, student_name, student_address
     from tb_student
     );
     
select *
from test_view;


    
    
    


--------------------------------------------------------


사용자 관리
 - 데이터베이스에 접속하여 사용/관리 하는 계정
 - 업무의 효율, 보안을 고려하여 생성.
 
 
 -- hr은 권한이 없으니, SYSTEM으로 실행.
 create user yeon
 identified by 1234;
    
    
    grant 
grant [dml, dcl, ... etc] [table, index ... etc]  to [계정];
 - 권한을 부여하는 것
 
    revoke
 - 권한을 제거하는 것.
    
    
    '롤 roll'
   - 여러 종류의 권한을 묶어 놓은 그룹
   connect 
   resource : select, insert .. etc
   dba : 관리자 권한이기 때문에 별로 안씀.