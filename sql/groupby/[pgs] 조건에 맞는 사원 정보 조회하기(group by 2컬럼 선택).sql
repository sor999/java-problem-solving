-- 코드를 작성해주세요
select
    sum(b.SCORE) as SCORE,
    b.EMP_NO as EMP_NO,
    a.EMP_NAME as EMP_NAME,
    a.POSITION as POSITION,
    a.EMAIL as EMAIL
from HR_EMPLOYEES a
    join HR_GRADE b
on a.EMP_NO = b.EMP_NO
group by b.YEAR, b.EMP_NO
having b.YEAR = '2022'
order by SCORE desc
    limit 1