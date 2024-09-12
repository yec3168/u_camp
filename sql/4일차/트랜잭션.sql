                트랜잭션
            - 한 개 이상의 DML이 실행되는 작업
            - 더 이상 분할할 수 없는 최소 수행 단위
            - 모두가 문제없이 실행되거나, 아무것도 실행되지 않은 상태(진행중인 모든 작업을 취소)
            - 트랜잭션은 무언가 변경이 일어날 때, 발생한다
                ex) insert, update, delete
            - select 작업에서는 발생하지 않는다.
            - A라는 사용자가 트랜잭션을 완료하지 않으면 B사용자가 select작업을 수행하면 commit 전 상태만 본다.
            - TCL( Transaction control Language)
              : 트랜잭션을 제어하기 위해 사용하는 명령어
                ( Commit, Rollback, SavePoint);
           
                 1. Rollback
                 - 마지막 트랜잭션이 종료된(TCL) 있던 작업으로 돌아감.
                 
                 2. Commit
                 - 현재까지 진행했던 작업을 진짜 데이터베이스에 영원히 반영한다.
                 - insert, update, delete; 수행한 결과를 영구히 반영.
                 


1. Rollback 예시

select *
from test_table;

delete from test_table
where id = 5;

rollback; -- 마지막 commit으로 돌아감.
            
            
        
        
        
        
        
        
                                세션
                       - 쉽게 사용자라는 의미
                       - 로그인을하고 로그아웃까지 있는 시간.
                       - 조회시 문제는 없지만, DML 의 작업시 정상적으로 결과가 나오지 않을 수 있다.
                       - 그렇기 때문에 DML(insert, update, delete;) 작업을 진행하면
                          나중에 실행시키는 세션B는 (Lock)이 걸림.
                          먼저 세션A의 작업을 완료(commit or rollback;)하고 다른 세션B이 실행.
            
            세션A                                         세션B    
        - delete from test_table
          where id = 5;                           ( A세션의 작업을 기다림)
          
          **2개의 행이 삭제**
          ---------------------------------------------------------------  
          select *                                   select *
          from test_table;                           from test_table;
          
          6개의 행이 조회.                            8개의 행이 조회.
        

                - 세션 A에서 DML 작업을 진행하고 아직 commit을 안한상태이기 때문에,
                  세션 B에서 조회를 해도 A의 작업내용이 반영되지 않음.



                                Lock
                    - Lock시 select는 됨, 나머지가 안됨.
                        1. 행 레벨의 lock
                         - 조작중인 행만 Lock
                         
                        2. 테이블 레벨 lock
                         - 진행중인 테이블의 DML 작업이 끝날 때 까지 Lock
                         - DDL도 안됨.
                         
                      
