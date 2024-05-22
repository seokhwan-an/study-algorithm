-- 코드를 입력하세요
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름 조회
-- 보호 시작일이 빠른 순으로 조회
SELECT outs.animal_id, outs.name
FROM animal_outs outs
JOIN animal_ins ins on outs.animal_id = ins.animal_id
WHERE subString(outs.datetime,1,19) < subString(ins.datetime,1,19)
ORDER BY ins.datetime asc