# 회원정보, 상품

# 년(year, SALES_DATE), 월(month, SALES_DATE), 성별 별 구매 회원수 집계(count)
# 년(year, SALES_DATE), 월(month, SALES_DATE), 성별(gender) 기준 오름차순
# 성별 정보 제외

# 1. 두 테이블 조인한다.
# 2. 젠더가 null인거 제외
# 3. year, month, gender별 그룹을 짓는다.
# 4. year, month, gender별 오름차순



select
    year(o.SALES_DATE) as year,
    month(o.SALES_DATE) as month,
    u.gender,
    count(distinct o.USER_ID) as USERS
from USER_INFO u
    join ONLINE_SALE o on o.USER_ID = u.USER_ID
where u.GENDER IS NOT NULL
group by
    year(o.SALES_DATE),
    month(o.SALES_DATE),
    u.GENDER
order by
    year,
    month,
    gender
