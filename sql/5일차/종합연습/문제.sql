

 -- 상품 가격
 select *
 from goods;
 
 -- 주문
  select *
 from goods_order;
 
 
 select *
 from goods_order_detail;
 
 
 -- 카테고리
 select *
 from category;
 
 -- 맴버
 select *
 from member;
 
 
 
 
 문제 1
각 카테고리 별로 주문상태가 "배송완료"인 상품들 중 결재금액이 가장 높은 상품을 조회하시오.
 2009년 1월 1일 부터 2010년 12월 31일

select *
from(  select c.category_name "카테고리명"
                     , g.goods_name "상품명"
                     , order_sum_money "결재금액"
        from goods_order_detail d inner join goods g on d.order_goods_num = g.goods_num
                                  inner join goods_order o on d.order_num = o.order_num
                                  inner join category c on c.category_num = g.goods_category
        where o.order_date between '2009-01-01' and '2010-12-31' and o.order_status = 4
        order by d.order_sum_money desc
    )
where rownum = 1;


------------------------ 서브쿼리------------------------------------------

 select *
 from 
    (  
        select c.category_name "카테고리명"
             , g.goods_name "상품명"
             , order_sum_money "결재금액"
        from goods g inner join category c on g.goods_category = c.category_num
                  inner join (
                             select order_goods_num, order_goods_amount, order_sum_money
                             from goods_order_detail d inner join (
                                                                    select *
                                                                    from goods_order
                                                                    where order_date between '2009-01-01' and '2010-12-31' and order_status = 4
                                                                    ) o on d.order_num = o.order_num  
                            ) do on g.goods_num = do.order_goods_num
        order by 3 desc
    )
where rownum =1;









 문제2
 
 select '가디안'
        , "분기"
        , sum(order_sum_money) as "분기별 주문량"
 from (
             select (case when to_char(order_date,'mm') between 01 and 03 then '1분기'
                                  when to_char(order_date,'mm') between 04 and 06 then '2분기' 
                                  when to_char(order_date,'mm') between 07 and 09 then '3분기'
                                  else '4분기' end) as "분기"
                            , order_sum_money 
             from goods_order o inner join goods_order_detail d on o.order_num = d.order_num
                                inner join member m on o.order_member_id = m.member_id
             where  m.member_name like '가디안'
                 and o.order_date between '2009-01-01' and '2009-12-31'
     )
group by "분기";
 
 
 
 -------------------------------서브쿼리----------------------------------
 select '가디안'
            , "분기"
            , sum(order_sum_money) as "분기별 주문량"
 from( select (case when to_char(order_date,'mm') between 01 and 03 then '1분기'
                      when to_char(order_date,'mm') between 04 and 06 then '2분기' 
                      when to_char(order_date,'mm') between 07 and 09 then '3분기'
                      else '4분기' end) as "분기"
                , order_sum_money
         from goods_order o inner join goods_order_detail d on o.order_num = d.order_num
         where order_member_id in ( 
                                     select member_id
                                     from member
                                     where member_name like '가디안'
                                     )
            and order_date between '2009-01-01' and '2009-12-31'
     )
    group by "분기";
 






문제 3


select  d.order_goods_num, sum(order_goods_amount)
from goods_order o inner join goods_order_detail d on o.order_num = d.order_num
                    inner join goods g on g.goods_num  = d.order_goods_num
where o.order_date between '2009-01-01' and '2010-01-31' 
group by d.order_goods_num;



----------------------------서브쿼리, with 절 -------------------------------
with result_set as (
select g.goods_num as "상품번호"
        , g.goods_name "상품명"
        , (g.goods_price -g.goods_cost) as "원가차이"  
        , o.sum as "주문상품수량"
from goods g inner join (
                            select order_goods_num, sum(order_goods_amount) as sum
                            from goods_order_detail
                            where order_num in (    select order_num
                                                    from goods_order
                                                    where order_date between '2009-01-01' and '2010-01-31' 
                                               )
                            group by order_goods_num
                            
                        ) o on g.goods_num = o.order_goods_num 

)

select "상품번호"
        ,"상품명"
        ,"주문상품수량"
        
from (
        select r.*, rownum as rnum
        from  (select *
                from result_set
                order by "원가차이" desc) r
      )
where rnum <=5

union all

select "상품번호"
        ,"상품명"
        ,"주문상품수량"
        
from (
        select r.*, rownum as rnum
        from  (select *
                from result_set
                order by "원가차이") r
      )
where rnum <=5;


----------------------------------------------------------------------------------

문제 4
select *
from (
        select g.goods_name as 상품명
                ,sum(od.order_goods_amount) as 주문수량합
        from goods_order o inner join goods_order_detail od on o.order_num = od.order_num
                           inner join goods g on od.order_goods_num = g.goods_num
        where order_member_id in (
                                    select member_id
                                    from member
                                    where member_addr like '서울%'
                                 )
        group by g.goods_name 
        order by 2 desc
     )
where rownum =1;                 






문제 5

select *
from category;

select "회원 ID"
        , "선호카테고리"
from 
    (
        select order_member_id as "회원 ID"
                , category_name as "선호카테고리"
                , rank() over( partition by order_member_id  order by cnt desc) as  ranking
        from(       select  od.order_member_id 
                               ,  g.goods_category 
                               ,  count(g.goods_num) as cnt
                    from goods g inner join (
                                            select  order_member_id, order_goods_num
                                            from goods_order o inner join goods_order_detail d on o.order_num = d.order_num
                                            ) od on g.goods_num = od.order_goods_num
                    group by od.order_member_id, g.goods_category
                    order by 1 , 3 desc
            ) r inner join category c on r.goods_category  = c.category_num
    )
where ranking = 1;




문제6

select g.goods_name as "상품명"
        ,m.member_name as "주문회원명"
        , o.order_receive_name as"수취인명"
        ,substr( o.order_receive_addr, 5 )as "수취인주소"
        , decode ( order_status, '1', '입금대기', '베송중') as "주문상태"
from goods_order o inner join member m on o.order_member_id = m.member_id
                    inner join goods_order_detail d on o.order_num = d.order_num
                    inner join goods g on d.order_goods_num = g.goods_num
where order_receive_addr  like '경기%' and order_status not in (4, 2) ;


--카테고리명 상품명 상품가격 상품원가 이윤 세금
문제 7
select c.category_name as "카테고리명"
        , g.goods_name as"상품명"
        , g.goods_price as "상품가격"
        , g.goods_cost as "상품원가"
        , (g.goods_price - g.goods_cost) as "이윤"
        , (g.goods_price - g.goods_cost)*0.1 as "세금"
from goods_order o  inner join goods_order_detail d on o.order_num = d.order_num
                    inner join goods g on d.order_goods_num = g.goods_num
                    inner join category c on c.category_num = g.goods_category
where order_date >= '2010-12-01' and o.order_status >1;





문제 8
select order_member_id as"사용자 ID "
        , (case when sum(order_goods_amount) > 30 then 'gold' 
                when sum(order_goods_amount) > 20 then 'silver'
                when sum(order_goods_amount) > 10 then 'bronze'
                else 'normal' end) as "등급"
        , sum(order_goods_amount) as "판매된상품수"
        , sum(order_sum_money) as "총판매금액"     
from goods_order o  inner join goods_order_detail d on o.order_num = d.order_num
group by order_member_id;




문제 9

select g.goods_num  as "상품번호"
        , g.goods_name as "상품명"
        , sum as "누적주문수량"
from goods g inner join (
                            select *
                            from (
                                    select order_goods_num
                                            , sum(order_goods_amount) as sum
                                    from goods_order o inner join goods_order_detail d on o.order_num = d.order_num
                                    where order_date between '2009-01-01' and sysdate
                                    group by order_goods_num
                                    order by 2 desc
                                    )
                            where rownum <=3
                            ) o on g.goods_num = o.order_goods_num;
  
  


문제 10    
create view V_CATEGORY_GOODS ("카테고리명" ,"상품주문 수")
    as (
        select c.category_name 
                , sum 
        from category c inner join (
                                     select g.goods_category
                                            , sum(sum_cnt) as sum
                                     from  goods g inner join (
                                                                 select d.order_goods_num
                                                                        , count(o.order_num) as sum_cnt
                                                                 from goods_order o inner join goods_order_detail d on o.order_num = d.order_num
                                                                                    
                                                                 group by d.order_goods_num
                                                                 )o on  g.goods_num = o.order_goods_num
                                    group by g.goods_category
                                    ) g on c.category_num = g.goods_category
    );
    
    
    
    
    
    
delete from member  
where member_id in( select member_id
                             from member
                             where member_name like '김사랑');
    
delete from GOODS_ORDER 
where order_member_id in( select member_id
                             from member
                             where member_name like '김사랑');
    
    
    
    
    
    