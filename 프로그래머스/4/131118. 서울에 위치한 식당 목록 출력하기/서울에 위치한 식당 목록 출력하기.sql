-- 코드를 입력하세요
SELECT 
ri.rest_id,
ri.rest_name,
ri.food_type,
ri.favorites,
ri.address,
round(avg(rr.review_score),2) review_score
from rest_info ri 
join rest_review rr 
on ri.rest_id = rr.rest_id
where subStr(ri.address,1,2) = '서울'
group by ri.rest_id
order by review_score desc, ri.favorites desc;