--        내장함수
--    - 따로 사용자가 정의하지 않고  oracle 자체에 있는 함수
--    - 단일 행 함수 : 결과가 여러 개의 row로 나온다
--    - 다중 행 함수 : 결과가 `하나`로 나온다.
--        dual : 가상의 더미 데이터, 실제 값이 있는게 아님.



--            1. 문자열
--      upper : 소문자를 대문자
--      lower : 대문자를 소문자
--      initcap : 문자열의 첫 문자를 대문자로
--      length : 문자열의 길이
--      lengthb : 문자열의 바이트 수 ( 한글은 3byte, 영어는 1byte )

select upper('abce123')  as upper
        , lower('ABCE123') as lower
        , initcap('abce123') as initcap
        , length('abce123') as length
        , lengthb('대한민국만세') as lengthb_한글
        , lengthb('abce123') as  lengthb_영어
from dual;

--        substr ( 문자열 , 시작인덱스, 갯수) : 문자열을 자름 ( 1부터 시작임)
--        instr(문자열, '문자') : 문자열의 시작위치를 찾기
--        replace(문자열, '문자', '바꿀문자') : 문자를 바꿀문자로 교체
--        LPAD, RPAD(문자열, 값, '문자') : 왼쪽 혹은 오른쪽에 '문자'를 값 만큼 넣음
--                                     but. 기존문자의 길이와 '문자'를 합쳐서 값
--                                       값 : length(문자열) + length(문자)
--        concat(문자열, 문자열) : 두 개의 문자열으 이어 붙임
--        trim, ltrim, rtrim : 왼쪽, 오른쪽, 둘 다 입력한 문자를 지움, 없으면 공백.


select substr('abce123', 1, 5) as substr
        , instr(first_name, 'a') as instr -- 없으면 0
        , replace(first_name , 'a', 'e') as replace
        , lpad(first_name , 10, '*')as lpad
        , rpad(first_name, 10, '*') as rpad
        , concat(first_name, last_name) as cocnat
        ,trim('         trim          ') as trim
        ,ltrim('        ltrim') as ltrim
        ,rtrim('rtrim         ') as rtrim
        ,trim('     tr      im        ') as trim_2
from employees;


--------------------------------------------------------------------------------
                
--                2.숫자
--        round( 숫자, 위치) : 위치까지 보여줌 그 전에서  반올림
--        trunc(숫자, 위치) : 위치 이후를 다 버림.
--        ceil(숫자) : 해당 숫자와 가장 큰 정수
--        floor(숫자) : 해당 숫자와 가장 작은 정수
--        mod (숫자, 나눌 숫자 ) : 숫자를 나눈 나머지
 
 select round( 128.877, 2) as round
        , trunc( 128.877, 2) as trunc
        , ceil (128.877) as ceil
        , floor(128.877) as floor
        , mod( 125, 10) as mod
 from dual;
 
 
 
 ------------------------------------------------------------------------------
 
--                3. 날짜
--         add_months( date타입, 숫자) : 숫자만큼 월을 더함
--         months_between(날짜, 날짜) : a와 b사이의 차이,  a-b
--         next_day(날짜, 숫자) : 1은 일요일, 2 월요일 ... 7 토요일
--                                날짜에서 가장 가까운 요일의 날짜를 찾음
--         last_day(날짜) : 정해진 달의 가장 마지막 날짜를 출력.
--         round(날짜, 위치), trunc(날짜, 위치) : 반올림 하거나 버림.
--         to_char (날짜, 포맷) :  날짜를 문자열로

 select sysdate
        , add_months(sysdate, 2) as add_months
        , trunc(months_between(to_date('2024-11-08', 'YYYY-MM-DD'), to_date('2024-09-09', 'YYYY-MM-DD')), 2) as months_between
        , next_day(sysdate, 1) as next_day
        , last_day(sysdate) as last_day
        , to_char( sysdate, 'YYYY-MM-DD') as to_char
 from dual;
 
 
 -------------------------------------------------------------------------------
 
 
--                    4. 변환
--            to_date( 문자데이터, 포맷) : 문자데이터를 날짜 데이터로
--            to_number( 문자데이터 ) : 문자데이터를 숫자데이터
--                                    문자데이터에는 `숫자`형식만 와야함
--                        but. '100' + 300
--                             200  + 300
--                             '300' + '400'  가능 (to_number 생략)
--            to_char(날짜 or 문자열, 포맷) : 날짜데이터를 문자데이터로.
 
select to_char( sysdate, 'YYYY-MM') as to_char
        , to_char('90999999') as to_char2
        , to_date('2024-09-01') as "to_date"
        , to_date('2024-09-01', 'YYYY-MM-DD') to_date2
        , to_date('09-09-2024', 'MM-DD-YYYY') to_date2
        , to_number('101111') as to_number1
        , 100 + 200  as to_number2
        , '200' + 300  as to_number3
        , '300' + '400'  as to_number4
from dual;



--------------------------------------------------------------------------------


--                    5. nvl, nvl2
--            nvl(조건, is null) : null경우만 처리
--            nvl2(조건, is not null, is null) : 둘 다 처리.
select (salary * 12) as 연봉
        , (salary *12) * nvl(COMMISSION_PCT, 1) as "nvl"
        , (salary *12) * nvl2(COMMISSION_PCT, COMMISSION_PCT, 1) as "nvl2"
from employees;
 
 
 --------------------------------------------------------------------------------


--                    6. decode, case
--            decode(컬럼, if, then, else if, then else)
--             - 자바에서 switch
--             - switch 처럼 값이 들어옴
--            
--            case ( case when 조건 then 값             ( case 컬럼
--                        when 조건 then 값                        when 조건 then 값
--                        when 조건 then 값                        when 조건 then 값
--                        else 값                                 else 값 
--                  end)                                     end)
--            - 자바에서 if                                     이때는 조건이 값만 들어감 (switch)처럼.
--            - 조건문에 연산자가 들어올 수 있음.
--            -괄호는 생략 가능.
    
select decode( point, 4.5, 'A+', 4, 'A', 3.5, 'B', 'else') as decode
        
        , (case 
                when point > 4 then 'A'
                 when point > 3 then 'B'
                 else 'C' end) as case_1
                 
         , (case point 
                 when  4.5 then 'A+'
                 when 4 then 'A'
                 when 3.5 then 'B+'
                 when 3 then 'B'
                 else 'C' end) as case_2
from tb_grade;

                     
 
        