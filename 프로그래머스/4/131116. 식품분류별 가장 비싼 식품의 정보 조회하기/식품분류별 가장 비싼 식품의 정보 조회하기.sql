-- 코드를 입력하세요
SELECT food1.category, food1.price as max_price, food1.product_name
FROM food_product food1 
JOIN 
(SELECT category, max(price) as max_price
     FROM food_product
     GROUP BY category) food2
     on food1.price = food2.max_price and food1.category = food2.category
WHERE food1.category in ("과자", "국", "김치", "식용유")
ORDER BY price desc