-- 코드를 입력하세요
-- 대여중, 대여가능 표시하기
SELECT
h1.car_id, if(h1.car_id in (h2.car_id), "대여중", "대여 가능") as availability
FROM car_rental_company_rental_history h1
LEFT JOIN (
    select * 
     from car_rental_company_rental_history 
     where start_date <= "2022-10-16" and end_date >= "2022-10-16"
     ) h2
     on h1.car_id = h2.car_id
group by h1.car_id
ORDER BY h1.car_id desc