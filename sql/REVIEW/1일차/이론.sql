
데이터 : 수집은 했는데, 정제는 하지 않은 값
정보 : 데이터를 정재하여 어떠한 목적으로 사용한 값.

DBMS
 - 데이터를 효율적으로 관리, 검색
 - 데이터의 중복이 없음, 누락도 없음
 - 일관된 방법으로 저장
 - 여러 사용자가 공동으로 실시간 사용 가능
 

 1. 계층형 구조
 - 부모 자식 관계
 - 중복이 많음
 
 2. 네트워크 구조
 - 자식이 여러 부모를 가짐
 - 중복은 없지만 복잡함
 
 3. RDBMS
 - 관계형 데이터 베이스
 - 중복이 없고 관계를 맺기 때문에 덜 복잡.
 
 
 
                릴레이션 명칭 
        1. 튜플( 행 )
            - row를 의미
            - 중복된 값이 있을 수 없음.
            - 원자 값이 들어있음
        2. 컬럼( 열 )
            - 속성
            - 하나의 열은 일관된 값을 저장함
            - 중복이 가능
        3.카디널리티
            - 튜플의 수
        4. 도메인
            - 속성에서 취할 수 있는 값의 범위
        5. degree
            - 속성의 수.
    
    
    1. 셀렉션 : 행을 선택 하는 것.
    2. 프로젝션 : 열을 선택 하는 것.
    
    
    Distinct 는 중복을 제거해줌
    ALL은 중복 포함.
    
    
        키 종류
 1. 기본키
  - 한 테이블에 특별한 의미를 가진 키
  - 테이블을 구별하는 용도로 사용함
  - 중복이 없고, NULL값이 없음
  
 2. 후보키( 대체키, 보조키)
  - 기본키가 될 수 있는 키
  - 기본키도 후보키에 속한다.
  
 3. 외래키
  - 다른 테이블의 기본키로서 중복이 가능하다
  - 어떤 조건에 따라 null값을 가질 수 있다.
  - 조인의 용도로 사용.
  
 4. 복합키
  - 테이블의 기본키로서 사용할 컬럼이 없을 때, 여러 컬럼을 조합하여 기본키로서 사용하는 것.
  

        자료형
    1. varchar2(길이)
     - 4000byte만큼의 `가변`적 길이를 가진 문자열 데이터
     - 최소는 1byte
    2. number(전체 자릿수, 소수점이하 자릿수)
     -  숫자를 저장
    3. date
     - 날짜 형식을 저장하기 위해 사용하는 자료형.
     
     
        객체
    1. 테이블 :  데이터를 저장하는 장소
    2. 인덱스 :  데이터의 검색의 효율을 높이기 위해 사용.
    3. 뷰    :  하나 또는 여러 개의 테이블을 자신만의 방법으로 연결하여 하나의 테이블로서 사용
             :  '가상의 테이블' 실제로 데이터를 저장하지 않음, 
             : 속성의 값을 변경이 가능함.
    4. 시퀸스 :  일렬 번호를 생성.
    5. 시노님(알리아스) :  속성이나 테이블에 별명을 주는 것.
  
  
  
        null 연산자
   null +100 = null
   null > 100 = null 
   무한 + 100 = 무한
   ? > 100 ?