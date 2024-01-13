-- 코드를 입력하세요
SELECT 
YEAR(sale.sales_date) as year,
MONTH(sale.sales_date) as month,
info.gender as gender,
count(distinct(info.user_id)) as users
FROM user_info info
JOIN online_sale sale on info.user_id = sale.user_id
WHERE info.gender is not null
GROUP BY year, month, gender
ORDER BY year, month, gender asc;