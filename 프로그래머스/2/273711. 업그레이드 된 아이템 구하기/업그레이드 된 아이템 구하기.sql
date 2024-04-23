SELECT ii.item_id, ii.item_name, ii.rarity
FROM ITEM_INFO ii
JOIN ITEM_TREE it on ii.item_id = it.item_id
WHERE it.parent_item_id in (SELECT item_id 
                           FROM ITEM_INFO
                           WHERE rarity = 'RARE')
ORDER BY ii.item_id desc