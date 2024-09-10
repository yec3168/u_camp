--                서브쿼리
--        - 따로 쿼리문을 괄호로 묶어 새로운 테이블을 만듦
--        - 서브쿼리로 나온 값은 단일 행 일 수 도있고 다중행 일수도 있다.
--        - 서브쿼리는 select, from ,where 위치에 사용 가능하다.
--        - where에서 서브쿼리를 진행하여 나온 컬럼을 select에서 사용할 수없다.
--                ex)select department_name
--                    from tb_student
--                    where department_no = ( select department_no
--                                            from tb_department
--                                            where department_name = '국어국문학과');
--         
--
--         - 서브쿼리 통해서 얻은 결과가 Single row면  '=', 'like' 사용가능.
--         -                          multi row면 in만 사용가능.


--            1. where
--      - where 서브쿼리 결과가 single(단일)이면 ` = `, 'like' 는 사용가능
--      - 서브쿼리 결과만 따로 실행은 불가능.
--      - but, 다중 행이면 in을 써야함.
select *
from tb_student
where department_no in ( select department_no
                        from tb_department
                        where department_name in ('국어국문학과', '영어영문학과'));
                        
                        
select *
from tb_student
where department_no like ( select department_no
                        from tb_department
                        where department_name in ('국어국문학과'));
                        
                        
                        


-------------------------------------------------------------------------------
--                   Any, some
--          ex) x > any(10, 20, 30)
--                >> x가 any가 가진 최소값보다 크니?
--                >> x가 11이면 true
--                >> x가 9면 false
--          ex) x < any(10, 20, 30)
--                >> x가 any가 가진 최대값보다 작니?
--                >> x가 29이면 true
--                >> x가 31면 false
--          ex) x = any(10, 20, 30)
--                >> x가 any가 가진 값을 포함하니?
--                >> x가 29이면 true
--                >> x가 31면 false
--      - 서브쿼리로 얻어진 결과를 만족하면 true;
--      - 비교대상이 바뀌는 것이기 때문에 잘 판단해야함.


--    select salary
--    from employees
--    where job_id = 'SA_MAN'
--14000
--13500
--12000
--11000
--10500
--            salary > any() >> 최소값보다 크니?
--            salary < any() >> 최대값보다 작니?
--            salary = any() >> 포함하니?

select employee_id, first_name || last_name, salary
from employees
where salary > any( select salary
                    from employees
                    where job_id = 'SA_MAN');



--                  ALL
--          ex) x > all(10, 20, 30)
--                >> x가 all이 가진 최대값보다 크니?
--                >> x가 31이면 true
--                >> x가 29면 false
--          ex) x < any(10, 20, 30)
--                >> x가 all이 가진 최소값보다 작니?
--                >> x가 29이면 true
--                >> x가 31면 false
--          ex) x = any(10, 20, 30)
--                >> x가 all이 가진 값을 포함하니?
--                >> x가 29이면 true
--                >> x가 31면 false
       
       
--                       exists
--              - 상관관계 서브쿼리라고 함.
--          ex)  exists (10, 20, 30)
--                >>  하나의 행이라도 존재하면 true



-- 다중행 서브쿼리 때 사용하는 연산자가 아닌 것    :  (like)
-- in, any, some, all, exists 다 가능.