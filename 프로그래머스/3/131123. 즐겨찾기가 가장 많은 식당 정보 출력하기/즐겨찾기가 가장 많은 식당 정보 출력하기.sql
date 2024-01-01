-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, favorites
from rest_info r 
join (
    select food_type food_types, max(favorites) maxfavorite 
    from rest_info 
    group by food_type
) j
on r.favorites = j.maxfavorite 
and r.food_type = j.food_types
order by food_type desc