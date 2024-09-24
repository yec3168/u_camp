# u_camp

## 2024-09-02 ~ 2024-09-06 Java

### 1. 09월 02일
  - JVM, JRE, JDK 정의
  - 변수, 클래스, 메소드 명 규칙, 규약
  - Java의 특징
  - '=='과 equals
  - 리터럴(literal) 과 캐스팅
  - 연산자
    - 전치, 후치
    - 논리연산자
    - 비트연산자
    - 쉬프트연산자
    - 삼항연산자
  <hr>
  
### 2. 09월 03일
  - 조건문
    - if
    - switch
  - 반복문
    - for
    - while
    - do-while
    - for-each
  - break, continue
  - 배열, 2차원배열
  - 클래스
<hr>

### 3. 09월 04일
  - 상속
  - Abstract
  - interface
  - Object
  - this, super
<hr>
    
### 4. 09월 05일
  - static
  - final
  - Stiring, new String
  - Collection
    - list ( ArrayList, LinkedList, stack etc..)
    - set  ( HashSet, TreeSet etc...)
    - map  ( HashMap, HashTable etc...)
  - Generic
<hr>

### 5. 09월 06일
  - Exception
  - Throws
  - Thread
  - IO
<hr>

## 2024-09-09 ~ 2024-09-13 SQL

### 1. 09월 09일
  - Select 절
    - as (시즈닝, 알리아스)
    - distinct
  - order by
  - where
    - in : 정확한 값을 넣어 줘야함 ( "김%" ) x
    - like : 단 한개만 넣을 수 있음.
    - between a and b
    - not
    - is null
    - is not null
  - 연산자
     - <=, <=, ==
     - <>, !=, ^=
  - 집합 연산자
    - union : 중복 x
    - union all : 중복 o
    - minus
    - intersect
  - function
    - 문자열
        - upper : 소문자를 대문자
        - lower : 대문자를 소문자
        - initcap : 첫 문자를 대문
        - length : 문자열 길이
        - lengthb : 문자열 바이트 ( 한글은 3byte, 영어 1byte)
        - substr : 문자열 자르기
        - instr : 문자열 내 특정문자 위치 찾기
        - replace : 문자열 내 문자 특정문자로 바꾸기
        - lpad, rpad : 왼쪽, 오른쪽 입력한 문자로 채우기
        - concat : 문자열과 문자열 붙이기.
        - trim, ltrim, rtrim : 문자열내 공백 지우
    - 숫자
        - round : 원하는 위치 반올림
        - trunc : 원하는 위치 버림
        - ceil : 지정된 숫자와 가장 가까운 큰 정수
        - floor : 지정된 숫자와 가장 가까운 작은 정수
        - mod : 숫자 나눈 나머지
    - 날짜
        -  to_date : 문자데이터를 date 타입으로
        -  to_number: 문자데이터를 숫자타입으로
        -  to_char : date타입을 문자데이터로
        -  add_months : 날짜의 원하는 숫자만큼 월을 더함
        -  months_between : 두 날짜 사이의 차이
        -  next_day : 1은 일요일, 2는 월요일 ... 7은 토요일로 다음으로 오는 날짜
        -  last_day : 해당 월 마지막 날짜
    - NULL
        - nvl : 값이 null이면 처리해야하는 값 지정
        - nvl2: 값이 null이거나 null이 아닐 때 값을 지정.
    - case
        - decode : 자바의 스위치 정해진 값만 해서 조건을 걺 (switch)
        - case :  조건식으로 범위를 지정 (if)
  <hr>


###  09월 10일
  -  다중행 함수
      - count
      - min, max
      - sum
      - avg
  - Group by
  - having
  - 조인
      - 등가조인
          - cross join
          - inner join
          - left outer join
          - right outer join
          - full outer join
          - self join
      - 비등가조인
   - 서브쿼리
       - where 서브쿼리
           - 단일 행
               - like
           - 다중 행
               - in
               - any, some
               - all
               - exists
  <hr>

### 09월 11일
  - 다중열 서브쿼리
  - from 서브쿼리( 인라인 뷰)
  - WITH 절
  - rownum
  - rank
  - DML
      - insert into [테이블] [(컬럼 목록]) valuse (컬럼 값 들]
      - update [테이블] set [열1] = [값], [열2] = [값], ... , [열n] = [값n] [where 조건]
      - delete [from] [테이블] [where 조건]
      - select

<hr>

## 2024-09-20 ~ 2024-10-04 Front

### 09월 20일
  - html 태그
    - h1 ~ h6
    - p, span
    - strong, b, em, i
    - blockquote, q
    - ins, del, sup, sub
    - ul, ol, li, dl, dt, dd
    - a, img, video, audio
    - form
    - input
      - text, button, checkbox, radio, color, date, datetime, email, file, password, image, submit, reset, range
      - disable, readonly
      - maxlength
    - label
    - fieldset, legend
    - textarea
    - select
    - table, tr, th, td, col, colgroup

<hr>
   
### 09월 23일
  - css 선언위치
    - inline 스타일
    - 내부 스타일
    - 외부 스타일
  - 선택자
    - *{} : 전체선택자
    - p{}, h1{} : 태그선택자
    - #pwd, #email : 아이디선택자
    - .flower, .animal : 클래스선택자
    - input[type] : 기본속성 선택자
    - h1, h2, h3{} : 그룹선택자
    - ul > li {} : 자식선택자
    - div span: 하위선택자
    - ol + ul : 인접형제선택자
    - p ~ span{} :일반형제선택자
  - ::before, ::after, ::action ::link, ::visited
  - margin, padding, border, content
  - position : absolute, relative, static, fixed, float
  - 자식
      - nth-child
      - first-child
      - last-child
      - nth-last-child
      - last-of-type
      - nth-last-of-type
  - clear

<hr>

### 09월 24일
 - 변수명 규칙( 자바와 비슷)
 - 표기법
     - camelCase
     - pascalCase
     - snakeCase
 - var, let, const, 호이스팅
 - 자료형
 - 연산자
 - 함수
   - 익명함수
   - 람다식
   - 즉시실행함수
   - 생성자
 - String 메소드
 - Date, Math 객체
 - 객체, 배열

<hr>
