SELECT COUNT(user_id) users
FROM user_info
WHERE 20 <= age AND age <= 29 AND YEAR(joined) = 2021