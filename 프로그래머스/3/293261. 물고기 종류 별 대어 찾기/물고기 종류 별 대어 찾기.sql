SELECT f.id, i.fish_name, f.length
FROM fish_info f
JOIN fish_name_info i
ON f.fish_type = i.fish_type
WHERE (f.fish_type, f.length) IN(SELECT fish_type, MAX(length)
                                 FROM fish_info
                                 GROUP BY fish_type)