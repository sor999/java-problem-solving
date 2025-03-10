-- 노선 별 평균 역 사이 거리 조회 - 정렬 기준은 TOTAL_DISTANCE로 두면 문자열 이라서 안된다.
select
    ROUTE,
    CONCAT(round(sum(D_BETWEEN_DIST), 1), 'km') as TOTAL_DISTANCE,
    CONCAT(round(avg(D_BETWEEN_DIST), 2), 'km') as AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by ROUTE
order by sum(D_BETWEEN_DIST) desc