-- 코드를 입력하세요
SELECT animal_type, count(animal_type) as count
FROM animal_ins
WHERE animal_type = 'Cat' or animal_type = 'Dog'
GROUP BY animal_type
ORDER BY animal_type