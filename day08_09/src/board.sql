drop table board;
create table board(
    bid number primary key, -- 게시글 번호
    title varchar2(100) not null, -- 제목
    writer varchar2(50) not null, -- 작성자
    content varchar2(1000), -- 글내용
    reg_date timestamp, -- 등록날짜시간
    hit number, -- 조회수
    bgroup number,
    bstep number,
    bindent number    
);

create sequence bbs_seq;

select * from board;