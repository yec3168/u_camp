INSERT INTO MEMBER
VALUES('kk26432','kk26432','가디안','01023239090','서울시 강남구 역삼동 한미플라자','05/02/01');
INSERT INTO MEMBER
VALUES('qq111111','qq111111','안진경','01083239090','서울시 구로구 독산동 독산아파트','07/02/01');
INSERT INTO MEMBER
VALUES('qwer1234','qwer1234','김사랑','01044239090','부산시 해운대구 미도아파트','09/05/01');
INSERT INTO MEMBER
VALUES('qqq12345','qqq12345','이영훈','01023231213','인천시 동구 현대연립','10/01/01');
COMMIT;


INSERT INTO category
VALUES(1,'outer','outer');
INSERT INTO category
VALUES(2,'onepiece','onepiece');
INSERT INTO category
VALUES(3,'pants','pants');
INSERT INTO category
VALUES(4,'skirt','skirt');
commit;

INSERT INTO goods
VALUES('ou000001',1,'멜로디 가디건',8000,10000,'11/02/01');
INSERT INTO goods
VALUES('ou000002',1,'로진 진업',10000, 15000,'99/01/01');
INSERT INTO goods
VALUES('ou000003',1,'오리온 집업',10000, 13000,sysdate);
INSERT INTO goods
VALUES('ou000004',1,'펠디스 자켓',11500, 14000,'00/01/01');
INSERT INTO goods
VALUES('ou000005',1,'도블링 집업',21300,24000,'00/02/02');
INSERT INTO goods
VALUES('ou000006',1,'라이나 가디건',19800,22000,'00/01/02');

INSERT INTO goods
VALUES('on000001',2,'조이스 원피스',21300, 24000,'01/01/02');
INSERT INTO goods
VALUES('on000002',2,'티에나 원피스',9800, 12000,'01/03/02');
INSERT INTO goods
VALUES('on000003',2,'미세린 원피스',18900, 22000,'01/04/02');
INSERT INTO goods
VALUES('on000004',2,'다나 원피스',29600, 32000,'01/05/02');
INSERT INTO goods
VALUES('on000005',2,'루이시 원피스',19800, 21000,'01/05/05');

INSERT INTO goods
VALUES('pa000001',3,'벤토 진',19800, 21000,'01/05/05');
INSERT INTO goods
VALUES('pa000002',3,'프티벤 진',59800, 61000,'01/05/05');
INSERT INTO goods
VALUES('pa000003',3,'보엔 팬츠',49800, 51000,'01/05/05');
INSERT INTO goods
VALUES('pa000004',3,'젠드 진',39800, 41000,'02/06/05');
INSERT INTO goods
VALUES('pa000005',3,'벤스 팬츠',39000, 45000,'03/06/05');
INSERT INTO goods
VALUES('pa000006',3,'베리오 레깅스',12600, 15000,'03/06/05');

INSERT INTO goods
VALUES('sk000001',4,'셀린드 스커트',21700, 25000,'03/06/05');
INSERT INTO goods
VALUES('sk000002',4,'레비안 스커트',32000, 35000,'04/06/05');
INSERT INTO goods
VALUES('sk000003',4,'케미 스커트',10000, 15000,'04/07/05');
INSERT INTO goods
VALUES('sk000004',4,'샤르망 스커트',9870, 15000,'04/07/05');
INSERT INTO goods
VALUES('sk000005',4,'크래커 스커트',12000, 15000,'04/07/05');

COMMIT;

INSERT INTO goods_order
VALUES('20090001','kk26432','09/05/20','임창정','경기도 용인시 수지구 상현동',1);
INSERT INTO goods_order
VALUES('20090002','qwer1234','09/08/12','원빈','부산시 해운대구 해운대동',2);
INSERT INTO goods_order
VALUES('20090003','kk26432','09/06/20','임창정','경기도 용인시 수지구 상현동',4);
INSERT INTO goods_order
VALUES('20090004','kk26432','09/07/20','임창정','경기도 용인시 수지구 상현동',4);
INSERT INTO goods_order
VALUES('20090005','kk26432','09/08/20','임창정','경기도 용인시 수지구 상현동',4);

INSERT INTO goods_order
VALUES('20090006','kk26432','09/09/20','임창정','경기도 용인시 수지구 상현동',4);
INSERT INTO goods_order
VALUES('20090007','kk26432','09/10/20','임창정','경기도 용인시 수지구 상현동',4);
INSERT INTO goods_order
VALUES('20100001','qwer1234','10/03/14','현빈','인천시 서구 백석동',3);
INSERT INTO goods_order
VALUES('20100002','qqq12345','10/09/01','한가인','서울시 강동구 잠실동',4);
INSERT INTO goods_order
VALUES('20100003','qq111111','10/11/01','고소영','서울시 강서구 화곡동',3);

INSERT INTO goods_order
VALUES('20100004','kk26432','10/12/22','배용준','서울시 강남구 논현동',4);
INSERT INTO goods_order
VALUES('20110001','qqq12345','11/01/04','김슬기','경기도 성남시 분당구 정자동',4);
INSERT INTO goods_order
VALUES('20110002','qq111111','11/02/02','장동건','경기도 성남시 분당구 야탑동',3);
INSERT INTO goods_order
VALUES('20110003','qq111111','11/02/22','장동건','경기도 성남시 분당구 야탑동',1);
INSERT INTO goods_order
VALUES('20110004','qq111111','11/03/02','장동건','경기도 성남시 분당구 야탑동',1);
INSERT INTO goods_order
VALUES('20110005','qq111111','11/03/12','장동건','경기도 성남시 분당구 야탑동',2);
COMMIT;


INSERT INTO goods_order_detail
VALUES('20090001','10000001','ou000001',3,30000);

INSERT INTO goods_order_detail
VALUES('20090002','10000002','ou000005',1,24000);
INSERT INTO goods_order_detail
VALUES('20090002','10000003','sk000003',3,45000);
INSERT INTO goods_order_detail
VALUES('20090002','10000004','ou000001',3,30000);

INSERT INTO goods_order_detail
VALUES('20090003','10000020','ou000001',4,40000);
INSERT INTO goods_order_detail
VALUES('20090004','10000021','sk000001',3,75000);
INSERT INTO goods_order_detail
VALUES('20090005','10000022','ou000001',4,40000);
INSERT INTO goods_order_detail
VALUES('20090006','10000023','pa000005',2,90000);
INSERT INTO goods_order_detail
VALUES('20090007','10000024','ou000006',1,22000);

INSERT INTO goods_order_detail
VALUES('20100001','10000005','sk000001',2,50000);

INSERT INTO goods_order_detail
VALUES('20100002','10000006','pa000006',4,60000);

INSERT INTO goods_order_detail
VALUES('20100003','10000007','pa000005',2,90000);
INSERT INTO goods_order_detail
VALUES('20100003','10000008','ou000006',1,22000);
INSERT INTO goods_order_detail
VALUES('20100003','10000009','on000002',2,24000);

INSERT INTO goods_order_detail
VALUES('20100004','10000010','sk000002',2,70000);
INSERT INTO goods_order_detail
VALUES('20100004','10000011','pa000003',2,102000);

INSERT INTO goods_order_detail
VALUES('20110001','10000012','on000004',1,32000);
INSERT INTO goods_order_detail
VALUES('20110001','10000013','ou000003',1,13000);
INSERT INTO goods_order_detail
VALUES('20110001','10000014','sk000002',2,70000);
INSERT INTO goods_order_detail
VALUES('20110001','10000015','pa000003',2,102000);


INSERT INTO goods_order_detail
VALUES('20110002','10000016','pa000005',2,90000);
INSERT INTO goods_order_detail
VALUES('20110002','10000017','ou000006',1,22000);
INSERT INTO goods_order_detail
VALUES('20110002','10000018','on000002',2,24000);
INSERT INTO goods_order_detail
VALUES('20110002','10000019','pa000003',3,153000);

INSERT INTO goods_order_detail
VALUES('20110003','10000025','pa000005',2,90000);
INSERT INTO goods_order_detail
VALUES('20110004','10000026','pa000003',2,102000);
INSERT INTO goods_order_detail
VALUES('20110005','10000027','on000004',1,32000);

COMMIT;

