-- 코드를 입력하세요
SELECT outs.animal_id, outs.name
FROM animal_ins ins right join animal_outs outs
on ins.animal_id = outs.animal_id
where ins.animal_id is null
order by ins.animal_id asc;