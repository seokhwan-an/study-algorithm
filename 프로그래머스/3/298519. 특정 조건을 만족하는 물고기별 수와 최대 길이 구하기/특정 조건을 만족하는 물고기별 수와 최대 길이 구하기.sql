-- 코드를 작성해주세요
SELECT count(id) fish_count, MAX(length) max_length, fish_type
FROM FISH_INFO
GROUP BY fish_type
HAVING AVG(IFNULL(LENGTH,10)) >= 33
ORDER BY fish_type