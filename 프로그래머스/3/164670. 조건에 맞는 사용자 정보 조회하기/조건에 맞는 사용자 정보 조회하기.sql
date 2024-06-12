-- 코드를 입력하세요
SELECT u.user_id, u.nickname, 
        CONCAT(u.city, ' ', u.street_address1, ' ', u.street_address2) 전체주소,
        CONCAT(SUBSTRING(u.tlno, 1, 3), '-', SUBSTRING(u.tlno, 4, 4), '-', SUBSTRING(u.tlno, 8, 4)) 전화번호
FROM used_goods_user u
JOIN used_goods_board b ON u.user_id = b.writer_id
GROUP BY u.user_id
HAVING COUNT(u.user_id) >= 3
ORDER BY u.user_id DESC