--1. 
--SELECT * FROM board ORDER BY bgroup DESC, bstep ASC;

--2. 
--SELECT bbs.*, rownum rnum
--FROM (SELECT * FROM board ORDER BY bgroup DESC, bstep ASC) bbs;

--3.
--SELECT *
--FROM (SELECT bbs.*, rownum rnum
--      FROM (SELECT * FROM board ORDER BY bgroup DESC, bstep ASC) bbs)
--WHERE rnum BETWEEN 1 AND 10;
           
SELECT *
FROM (SELECT bbs.*, rownum rnum
      FROM (SELECT * FROM board ORDER BY bgroup DESC, bstep ASC) bbs)
WHERE rnum BETWEEN 1 AND 10;  