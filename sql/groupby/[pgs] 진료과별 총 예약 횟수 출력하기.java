select MCDP_CD 진료과코드, count(MCDP_CD) 5월예약건수
from APPOINTMENT
where month(APNT_YMD) = '5' and year(APNT_YMD) = '2022'
group by MCDP_CD
order by 5월예약건수, MCDP_CD