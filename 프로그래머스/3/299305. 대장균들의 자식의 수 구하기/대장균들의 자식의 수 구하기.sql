SELECT parent.id, count(child.parent_id) as child_count
FROM ecoli_data parent
LEFT JOIN ecoli_data child on parent.id = child.parent_id
GROUP BY parent.id
ORDER BY parent.id