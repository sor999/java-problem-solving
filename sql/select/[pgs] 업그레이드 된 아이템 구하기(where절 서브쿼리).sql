-- 아이템의 희귀도가 RARE인 아이템의 다음 아이템에 대해 구하기

select b.ITEM_ID, a.ITEM_NAME, a.RARITY
from ITEM_INFO a
join ITEM_TREE b
on a.ITEM_ID = b.ITEM_ID
where b.PARENT_ITEM_ID in(
    select ITEM_ID
    from ITEM_INFO
    where RARITY = 'RARE'
)
order by b.ITEM_ID desc