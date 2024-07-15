SELECT CONCAT(QUARTER(differentiation_date),'Q') AS quarter, COUNT(id) AS ecoli_count
FROM ecoli_data
GROUP BY quarter
ORDER BY quarter