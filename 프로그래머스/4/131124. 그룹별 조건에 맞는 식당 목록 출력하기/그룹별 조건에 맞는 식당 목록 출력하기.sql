WITH max_review_user AS (
    SELECT mp.member_id, count(mp.member_id)
    FROM member_profile mp
    JOIN rest_review rr ON mp.member_id = rr.member_id
    GROUP BY mp.member_id
    HAVING count(mp.member_id) = (SELECT count(member_id)
    FROM rest_review
    GROUP BY member_id
    ORDER BY COUNT(member_id) DESC
    LIMIT 1)
)

SELECT mp.member_name, rr.review_text, DATE_FORMAT(rr.review_date, "%Y-%m-%d") AS review_date
FROM member_profile mp
JOIN rest_review rr ON mp.member_id = rr.member_id
JOIN max_review_user mru ON mp.member_id = mru.member_id
ORDER BY rr.review_date ASC, rr.review_text ASC