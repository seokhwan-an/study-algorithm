SELECT  order_id, product_id, date_format(out_date, '%Y-%m-%d'),
        CASE
        WHEN date_format(out_date, '%Y-%m-%d') <= '2022-05-01' THEN '출고완료'
        WHEN date_format(out_date, '%Y-%m-%d') > '2022-05-01' THEN '출고대기'
        ELSE '출고미정' END 출고여부
FROM  food_order
ORDER BY  order_id