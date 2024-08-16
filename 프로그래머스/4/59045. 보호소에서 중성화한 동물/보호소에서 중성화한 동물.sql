-- 코드를 입력하세요
SELECT o.animal_id, o.animal_type, o.name
FROM animal_outs o
JOIN animal_ins i ON o.animal_id = i.animal_id
WHERE o.sex_upon_outcome IN ('Spayed Male', 'Spayed Female', 'Neutered Male', 'Neutered Female')
AND i.sex_upon_intake NOT IN ('Spayed Male', 'Spayed Female', 'Neutered Male', 'Neutered Female')
ORDER BY o.animal_id