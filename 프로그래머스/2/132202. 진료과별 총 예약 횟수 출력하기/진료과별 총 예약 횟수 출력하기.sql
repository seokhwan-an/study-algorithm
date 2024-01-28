-- 코드를 입력하세요
SELECT mcdp_cd, count(mcdp_cd) as cnt
FROM appointment
WHERE subStr(apnt_ymd, 6,6) like '05%'
GROUP BY mcdp_cd
ORDER BY cnt asc, mcdp_cd asc