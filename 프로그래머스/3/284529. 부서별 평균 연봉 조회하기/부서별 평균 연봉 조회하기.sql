-- 코드를 작성해주세요
SELECT d.dept_id, d.dept_name_en, ROUND(AVG(e.sal)) avg_sal 
FROM HR_DEPARTMENT d
JOIN HR_EMPLOYEES e ON d.dept_id = e.dept_id
GROUP BY d.dept_id
ORDER BY avg_sal DESC