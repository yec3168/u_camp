트랜잭션
- 더이상 분할할 수 없는 최소 수행단위
- 한 개 이상의 DML로 이루어집니다.
- sql문 덩어리

- 어떤 명령어를 한번에 수행하여 작업을 완료하거나 아예 모두 수행되지 않은 상태, 진행중인 모든 작업을 취소.
- TCL을 사용한다.
  (commit, rollback, savepoint)
  
  
  

세션
- 어떠한 활동을 위한 시간이나 기간
 eX) 로그인을 하고 로그아웃까의 시간.
 
 
  세션 a              세션b

-둘 다 scott 계정으로 로그인
- a가 (dml)트랜잭션 실행 중이면 b는 기다림.
- 그리고 b의 쿼리를 실행.
- 이유가 아직 commit을 하지 않은 상태라 세션b에는 반영이 안됨.
-