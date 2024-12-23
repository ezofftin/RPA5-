-- 관리자 테이블 admin (관리자 등록)
drop table tbl_admin;
create table tbl_admin(
    id varchar2(20) not null,
    password varchar2(20) not null,
    name varchar2(20) not null,
    email varchar2(50) not null
);


insert into tbl_admin values('test', 'test', '홍길동', 'test@gmail.com');
select * from tbl_admin;
commit;

-- 카테고리 데이블
drop table tbl_category;
create table tbl_category(
    cat_num number(5) primary key,
    code varchar2(10) not null,
    cat_name varchar2(20) not null
);

drop sequence cat_seq;
create sequence cat_seq;

select * from tbl_category;



-- 상품 테이블