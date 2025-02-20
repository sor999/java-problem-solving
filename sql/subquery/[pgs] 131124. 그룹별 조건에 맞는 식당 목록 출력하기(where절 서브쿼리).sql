-- 코드를 입력하세요 1.리뷰들을 남겨야. (join) 2. 회원수 기준 가장 많이 작성한 회원 찾기(where 서브쿼리(id같은지 확인), 혹은 group by having 서브쿼리(count같은지 확인)"어떤") 3. 
SELECT a.MEMBER_NAME, b.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE a
join REST_REVIEW b
on a.MEMBER_ID = b.MEMBER_ID
where a.MEMBER_ID = (SELECT MEMBER_ID
                    from REST_REVIEW
                    group by MEMBER_ID
                    order by count(member_id) desc
                    limit 1)
order by REVIEW_DATE, REVIEW_TEXT
