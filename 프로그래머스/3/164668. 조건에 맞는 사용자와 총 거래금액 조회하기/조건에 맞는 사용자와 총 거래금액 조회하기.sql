-- 코드를 입력하세요
SELECT user_id, nickname, sum(b.price) total_sales
from used_goods_user u 
inner join used_goods_board b on u.user_id = b.writer_id
where b.status = 'DONE'
group by b.writer_id
having total_sales >= 700000
order by total_sales