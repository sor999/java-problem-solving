//-- 코드를 입력하세요
//        select ANIMAL_TYPE, count(ANIMAL_TYPE) count
//from ANIMAL_INS
//where ANIMAL_TYPE in('Cat', 'Dog')
//group by ANIMAL_TYPE
//order by ANIMAL_TYPE
-- case, when, then 사용 가능
        select ANIMAL_TYPE, count(ANIMAL_TYPE) count
from ANIMAL_INS
where ANIMAL_TYPE in('Cat', 'Dog')
group by ANIMAL_TYPE
order by  case ANIMAL_TYPE
            when 'Cat' then 1
            when 'Dog' then 2
                    else 3
            end