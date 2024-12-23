drop table users;

create table users(
    uno number primary key,
    id varchar2(20) not null,
    pw varchar2(20) not null,
    name varchar2(20) not null,
    age number not null,
    email varchar2(30) not null,
    tel varchar2(20) not null
);
select * from users;
create sequence user_seq;