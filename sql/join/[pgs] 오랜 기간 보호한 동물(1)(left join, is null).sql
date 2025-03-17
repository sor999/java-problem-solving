-- i테이블의 원본을 유지하되, o테이블의 datetime 의 값은 null 이 들어오게 할 수 있으니 left join
select i.NAME NAME, i.DATETIME DATETIME
from ANIMAL_INS i
         left join ANIMAL_OUTS o
                   on i.ANIMAL_ID = o.ANIMAL_ID
where o.DATETIME is NULL
order by i.DATETIME
    limit 3