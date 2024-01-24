-- 코드를 입력하세요
SELECT 
p.product_code, p.price * sum(os.sales_amount) as sales
FROM product p
JOIN offline_sale os ON p.product_id = os.product_id
GROUP BY p.product_id
ORDER BY sales desc, p.product_code asc
