-- 코드를 입력하세요
SELECT ins.name, ins.datetime
FROM animal_ins ins
LEFT JOIN animal_outs outs on ins.animal_id = outs.animal_id
WHERE outs.animal_id is null
ORDER BY ins.datetime
LIMIT 3