-- 코드를 입력하세요
SELECT
    CAR_ID 
    , CASE WHEN TO_NUMBER(TO_CHAR(END_DATE, 'YYYYMMDD')) < 20221016 THEN '대여 가능'
        ELSE '대여중'
    END AS AVAILABILITY
FROM 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE (CAR_ID,  HISTORY_ID) IN
(
    SELECT
    CAR_ID
    , MAX(HISTORY_ID)
    FROM 
         CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE TO_NUMBER(TO_CHAR(START_DATE,'YYYYMMDD')) <= 20221016
    GROUP BY CAR_ID
)
ORDER BY CAR_ID DESC