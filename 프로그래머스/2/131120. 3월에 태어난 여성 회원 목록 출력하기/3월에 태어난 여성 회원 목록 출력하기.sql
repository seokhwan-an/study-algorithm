SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, "%Y-%m-%d") date_of_birth
from MEMBER_PROFILE
where MONTH(date_of_birth) = '3' 
and gender = 'W' 
and not tlno is NULL
order by member_id asc;