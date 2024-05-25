-- 코드를 작성해주세요
SELECT COUNT(id) fish_count, MONTH(time) month
FROM FISH_INFO
GROUP BY MONTH(time)
ORDER BY MONTH(time)