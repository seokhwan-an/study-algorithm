-- 코드를 작성해주세요
SELECT CONCAT(FORMAT(length, 2), 'cm') AS max_length
FROM fish_info
WHERE length = (SELECT length
                FROM fish_info
                ORDER BY length DESC
                LIMIT 1)