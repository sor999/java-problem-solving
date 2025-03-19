-- 코드를 입력하세요
select NAME, count(NAME) COUNT
from ANIMAL_INS
where name is not null
group by NAME
having count(NAME) >= 2
order by NAME