-- 코드를 입력하세요
select p.PRODUCT_CODE PRODUCT_CODE, sum(o.SALES_AMOUNT * p.PRICE) SALES
from PRODUCT p
         join OFFLINE_SALE o on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by SALES desc, p.PRODUCT_CODE asc