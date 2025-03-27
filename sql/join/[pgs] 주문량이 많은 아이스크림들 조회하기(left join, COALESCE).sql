-- 코드를 입력하세요
SELECT f.FLAVOR
FROM FIRST_HALF f
         LEFT JOIN (
    SELECT FLAVOR, sum(TOTAL_ORDER) AS JULY_TOTAL
    FROM JULY
    GROUP BY FLAVOR
) j ON f.FLAVOR = j.FLAVOR
ORDER BY f.TOTAL_ORDER + coalesce(j.JULY_TOTAL, 0) DESC
    LIMIT 3;