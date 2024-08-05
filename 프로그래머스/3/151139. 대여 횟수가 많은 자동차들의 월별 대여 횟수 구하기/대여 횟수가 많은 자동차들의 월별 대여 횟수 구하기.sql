SELECT MONTH(c.start_date) month, c.car_id, COUNT(c.car_id) records
FROM car_rental_company_rental_history c
JOIN (SELECT car_id, COUNT(car_id) count
      FROM car_rental_company_rental_history
      WHERE DATE_FORMAT(start_date, '%Y-%m-%d') >= '2022-08-01' 
      AND DATE_FORMAT(start_date, '%Y-%m-%d') <= '2022-10-31'
      GROUP BY car_id) cc
      ON c.car_id = cc.car_id
WHERE DATE_FORMAT(start_date, '%Y-%m-%d') >= '2022-08-01' AND DATE_FORMAT(start_date, '%Y-%m-%d') <= '2022-10-31' AND cc.count >= 5
GROUP BY c.car_id, MONTH(c.start_date)
ORDER BY month ASC, c.car_id DESC;