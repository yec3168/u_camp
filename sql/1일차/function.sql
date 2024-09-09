-- 내장함수

-- 1. 단일 행
--  - row 한 개씩 한 개씩 처리 결과도 여러 개.
--   ex) UPPER, LOWER, INITCAP etc..
--        length


-- dual이라는 가상의 더미테이블( 값이 있는게 아님)

-- UPPER
-- 소문자를 대문자로 만들어줌.

-- LOWER
-- 대문자를 소문자

-- initcap
-- 첫 문자를 대문자로.

-- length
-- 문자열의 길이를 알려줌.

-- lengthb
-- 문자열이 몇 바이트를 사용하는 지 확인
-- 한글은 3바이트씩, 영어는 1바이트
select 'abcdef'
    ,UPPER('abcdefg')  as upper
    , lower( 'AbcDEf' ) as lower
    , initcap('asdasd') as initcap
    , length('대한민국만세') as length
    , lengthb('asdasdasd') as lengthb
    , lengthb('대한민국만세') as lengthb
from dual;  


-- substr( 문자열, 시작인덱스, 갯수)
-- 문자열을 자르는 함수
-- sql의 인덱스는 1부터 시작함. 그래서 아래 문자열의 길이는 1~7까지
select substr('1234567', 1, 3)
from dual;

-- instr( 문자열, '문자')
-- 문자열에서 특정 문자 위치 찾기
select instr('abcdefg', 'e')
from dual;

-- replace( 문자열, '특정문자', '원하는문자')
-- 문자열에서 특정문자를 입력한 문자로 바꿔줌.
select replace('aaabbbcccc', 'b', '12')
from dual;


-- LPAD( 숫자 or 문자열, 값, '문자')
-- RPAD( 숫자 or 문자열, 값, '문자')
-- 왼쪽, 오른쪽 빈 공간을 입력한 값으로 채워줌. 
-- 값 = 기존값 + 추가해야할 문자

select salary
        , LPAD(salary, 10,'*')  
        , RPAD(salary, 7,'*') 
from employees;

-- concat( 문자열, 문자열)
-- 문자열 + 문자열
select concat('asd', '123')
from dual;

-- trim, ltrim, rtrim (문자열)
-- 특정 문자를 지우기
-- 보통 공백을 없앰.
select trim('       aaaaeeeeeaaaaa      ') 
        ,ltrim('       aaaaeeeeeaaaaa      ')
        ,rtrim('       aaaaeeeeeaaaaa      ')
from dual;

-----------------------------------------------------------------------------

-- 숫자 데이터를 연산하고 수치를 조정하는 숫자함수
-- 1. round(숫자, 위치)
-- 반올림 하는 함수
-- 입력한 숫자의 위치 까지 출력.

-- 2. trunc(숫자, 위치)
-- 입력한 위치의 다음 소수점들 다 버림.

-- 3. CEIL(숫자)
-- 지정된 숫자와 가장 가까운 큰 정수

-- 4. FLOOR(숫자)
-- 지정된 숫자와 가장 가까운 작은 정수.

-- 5. MOD( 숫자, 나눌 숫자)
-- 숫자를 나눈 나머지
select round(123.125, 2)
        , trunc(123.125, 2)
        , CEIL(123.9)
        , floor(123.9)
        , mod( 121, 10) 
from dual;



-------------------------------------------------------------------------------

-- 날짜
--날짜 더하기 날짜는 안됨 나머지는 다됨
-- to_date(날짜형식의문자열, 'format')
select sysdate
        , sysdate+ 10
        , sysdate - 2
        , sysdate -  (sysdate-2)
        , to_date('2024-10-09', 'YYYY-mm-DD') - sysdate
--      , sysdate +  (sysdate-2) // 안됨.
from dual;



-- 날짜 데이터를 다루는 함수
-- 1. ADD_MONTHS ( date타입, 숫자)

-- 2. months_between( 날짜, 날짜)

-- 3. next_day( 날짜, 숫자) 숫자는 7까지
-- 1은 일
-- 2는 월 ... 7은 토요일

-- 4. last_day(날짜)

-- 5. round, trunc 
-- 날짜 반올림, 버림

-- 6. to_char( date타입 데이터, 'format')
-- date타입을 문자데이터
select sysdate
        ,add_months(sysdate, 2)
        , months_between(to_date('2024-10-08', 'YYYY-MM-DD'), to_date('2024-09-09', 'YYYY-MM-DD')) as months_between
        , next_day(sysdate, 1)
        , LAST_DAY(sysdate)
        , round(sysdate)
        , trunc(sysdate)
from dual;


--------------------------------------------------------------------------------
-- 변환.
-- 1. to_char( 숫자, date타입 데이터, 'format')
-- date타입을 문자데이터

--2. to_number ( (숫자로 된)문자 데이터)
--문자 데이터를 숫자데이터로
--
--3. to_date( 문자데이터 , 'format')
--문자데이터를 날짜데이터로

select to_char(sysdate, 'YYYY-mm-DD') as to_char
        ,to_char('909999') as to_char_number
        ,to_number('1234') as to_number
       -- ,to_number('1a2')  안됨
        --,to_number('1234a') 안됨
        ,to_date('2024-09-09') as to_date  -- 포맷 생략 가능
        , '100' + 100 -- 숫자로 됨.
        , '100' + '200'
        --,to_date('09-09-2024')  꼭 포맷을 적어줘야함
from dual;


-------------------------------------------------------------------------------
-- NULL 처리방식
-- null + 1 = null
--1. NVL ( 조건, 대처할 값)
--NULL이 나오게 되면 처리하는 방식을 따로 정의해줌

-- 2.NVL2 ( 조건, null이 아닐 때, null 일 때)
-- Null일 때와 null이 아닐때를 정의해줌.
select salary as "월 급여"
        ,salary *12 as "연봉"
        , (salary * 12) * nvl(1 + COMMISSION_PCT, 1) as "총 수입" 
        ,  (salary * 12) * nvl2(1 + COMMISSION_PCT, 1 + COMMISSION_PCT, 1) as "총 수입 nvl2"
from employees;




--------------------------------------------------------------------------------

-- DECODE( 컬럼, if, then, else if, then, else)
-- if절 느낌.
-- 값만 지정하는 느낌.
-- switch
select salary 
        ,decode(salary,  8000, 'high', 'low')
        ,decode(salary, 8000, 'high', 7000, 'medium', 6000, 'low', 'else')
from employees;


-- CASE
-- 괄호는 없어도 됨.
-- (case when 조건 then 
--        when 조건 then
--        else default end)
select salary,
        (case when salary > 8000 then 'high' 
             when salary > 6000 then 'medium'
             when salary > 4000 then 'low'
             else 'else' end) as case
             -- 위에는 if
        , case salary
            when  8000 then 'high' 
             when 6000 then 'medium'
             when  4000 then 'low'
             else 'else' end
             -- switch
from employees;
