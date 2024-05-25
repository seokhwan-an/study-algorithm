-- 코드를 작성해주세요
SELECT SUM(g.score) score, g.emp_no, e.emp_name, e.position, e.email
FROM HR_EMPLOYEES e
JOIN HR_GRADE g ON e.emp_no = g.emp_no
WHERE g.year = 2022
GROUP BY e.emp_no
ORDER BY score DESC
LIMIT 1