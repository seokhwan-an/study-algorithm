SELECT count(fi.id) as fish_count
FROM fish_info fi
JOIN fish_name_info fni ON fi.fish_type = fni.fish_type
WHERE fni.fish_name in ('BASS', 'SNAPPER')
