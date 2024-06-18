SELECT animal_id, name,
       CASE
       WHEN sex_upon_intake like '%Neutered%' THEN 'O'
       WHEN sex_upon_intake like '%Spayed%' THEN 'O'
       ELSE 'X'
       END 중성화

FROM animal_ins