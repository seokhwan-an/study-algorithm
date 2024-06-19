SELECT SUBSTR(product_code, 1, 2) category, COUNT(product_id) products
FROM product
GROUP BY category
ORDER BY category 