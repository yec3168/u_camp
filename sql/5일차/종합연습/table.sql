DROP TABLE GOODS_ORDER_DETAIL CASCADE CONSTRAINTS;
DROP TABLE GOODS_ORDER CASCADE CONSTRAINTS;
DROP TABLE GOODS CASCADE CONSTRAINTS;
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
DROP TABLE MEMBER CASCADE CONSTRAINTS;


CREATE TABLE MEMBER(
	MEMBER_ID VARCHAR2(20),
	MEMBER_PASSWORD VARCHAR2(20),
	MEMBER_NAME VARCHAR2(20),
	MEMBER_MOBILE VARCHAR2(13),
	MEMBER_ADDR VARCHAR2(80),
	MEMBER_REGI DATE
);

ALTER TABLE MEMBER
ADD CONSTRAINT PK_MEMBER_ID PRIMARY KEY (MEMBER_ID);

CREATE TABLE GOODS(
	GOODS_NUM VARCHAR(8),
	GOODS_CATEGORY NUMBER,
	GOODS_NAME VARCHAR2(50),
	GOODS_COST NUMBER,
	GOODS_PRICE NUMBER,
	GOODS_DATE DATE
);

ALTER TABLE GOODS
ADD CONSTRAINT PK_GOODS_NUM PRIMARY KEY (GOODS_NUM);


CREATE TABLE CATEGORY(
       CATEGORY_NUM NUMBER,
       CATEGORY_NAME VARCHAR2(20),
       CATEGORY_DESCRIPT VARCHAR2(100)
);

ALTER TABLE CATEGORY
ADD CONSTRAINT PK_CATEGORY_NUM PRIMARY KEY (CATEGORY_NUM);

ALTER TABLE GOODS
ADD CONSTRAINT FK_GOODS_CATEGORY FOREIGN KEY (GOODS_CATEGORY)
REFERENCES CATEGORY(CATEGORY_NUM);


CREATE TABLE GOODS_ORDER(
	ORDER_NUM VARCHAR(8),
	ORDER_MEMBER_ID VARCHAR2(20),
	ORDER_DATE DATE,
	ORDER_RECEIVE_NAME VARCHAR2(20),
	ORDER_RECEIVE_ADDR VARCHAR2(70),
	ORDER_STATUS NUMBER
);

ALTER TABLE GOODS_ORDER
ADD CONSTRAINT PK_GOODS_ORDER_NUM PRIMARY KEY (ORDER_NUM);

ALTER TABLE GOODS_ORDER
ADD CONSTRAINT FK_GOODS_ORDER_NUM FOREIGN KEY (ORDER_MEMBER_ID)
    REFERENCES MEMBER(MEMBER_ID);

CREATE TABLE GOODS_ORDER_DETAIL(
        ORDER_NUM VARCHAR(8),
        ORDER_DETAIL_NUM VARCHAR(15),
	ORDER_GOODS_NUM VARCHAR2 (8),
	ORDER_GOODS_AMOUNT NUMBER,
	ORDER_SUM_MONEY NUMBER
);

ALTER TABLE GOODS_ORDER_DETAIL
ADD CONSTRAINT PK_GOODS_ORDER_DETAIL PRIMARY KEY (ORDER_NUM,ORDER_DETAIL_NUM);

ALTER TABLE GOODS_ORDER_DETAIL
ADD CONSTRAINT FK_ORDER_DETAIL_ORDER_NUM FOREIGN KEY (ORDER_NUM)
    REFERENCES GOODS_ORDER(ORDER_NUM);

ALTER TABLE GOODS_ORDER_DETAIL
ADD CONSTRAINT FK_ORDER_DETAIL_GOODS_NUM FOREIGN KEY (ORDER_GOODS_NUM)
REFERENCES GOODS(GOODS_NUM);
