SELECT id, length
FROM fish_info
WHERE length > 10
ORDER BY length DESC, id ASC
LIMIT 10

