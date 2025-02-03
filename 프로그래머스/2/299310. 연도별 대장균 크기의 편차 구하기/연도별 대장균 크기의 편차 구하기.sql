WITH max_size AS (
    SELECT MAX(size_of_colony) size, DATE_FORMAT(differentiation_date, '%Y') year
              FROM ecoli_data
              GROUP BY year
)
             
SELECT YEAR(ed.differentiation_date) year, (ms.size - ed.size_of_colony) year_dev, ed.id
FROM ecoli_data ed
JOIN max_size ms ON DATE_FORMAT(ed.differentiation_date, '%Y') = ms.year
ORDER BY year ASC, year_dev ASC