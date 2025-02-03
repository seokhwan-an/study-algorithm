-- 코드를 작성해주세요
SELECT he.emp_no, he.emp_name, 
CASE
    WHEN AVG(hg.score) >= 96 THEN 'S'
    WHEN AVG(hg.score) >= 90 THEN 'A'
    WHEN AVG(hg.score) >= 80 THEN 'B'
    ELSE 'C'
END grade,
CASE
    WHEN AVG(hg.score) >= 96 THEN he.sal * 0.2
    WHEN AVG(hg.score) >= 90 THEN he.sal * 0.15
    WHEN AVG(hg.score) >= 80 THEN he.sal * 0.1
    ELSE he.sal * 0
END bonus
FROM hr_employees he
JOIN hr_grade hg ON he.emp_no = hg.emp_no
GROUP BY he.emp_no
ORDER BY he.emp_no
