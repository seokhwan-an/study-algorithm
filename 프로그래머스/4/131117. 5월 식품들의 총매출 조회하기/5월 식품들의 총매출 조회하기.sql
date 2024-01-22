-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, sum(fp.price * fo.amount) as total_sales
FROM FOOD_PRODUCT fp 
JOIN FOOD_ORDER fo 
ON fp.product_id = fo.product_id
WHERE DATE_FORMAT(fo.produce_date,'%Y-%m') = DATE_FORMAT(now(),'2022-05')
GROUP BY fo.product_id
ORDER BY total_sales desc, fp.product_id asc