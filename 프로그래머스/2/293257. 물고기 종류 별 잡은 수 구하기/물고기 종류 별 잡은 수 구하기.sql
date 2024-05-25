-- 코드를 작성해주세요
SELECT COUNT(f.id) fish_count, n.fish_name
FROM FISH_INFO f
JOIN FISH_NAME_INFO n ON f.fish_type = n.fish_type
GROUP BY n.fish_name
ORDER BY fish_count DESC