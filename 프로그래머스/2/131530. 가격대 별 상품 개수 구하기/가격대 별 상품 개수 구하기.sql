WITH base AS 
(SELECT *,
       CASE WHEN price < 10000 THEN 0           
            WHEN price < 20000 THEN 10000
            WHEN price < 30000 THEN 20000
            WHEN price < 40000 THEN 30000
            WHEN price < 50000 THEN 40000
            WHEN price < 60000 THEN 50000
            WHEN price < 70000 THEN 60000
            WHEN price < 80000 THEN 70000
            WHEN price < 90000 THEN 80000
            ELSE 90000 END price_group
FROM product)

SELECT price_group, COUNT(product_id) products
FROM base
GROUP BY price_group
ORDER BY price_group
