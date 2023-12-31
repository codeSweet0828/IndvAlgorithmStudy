-- 코드를 입력하세요
SELECT 
    FP.PRODUCT_ID
    , FP.PRODUCT_NAME 
    , SUM(FP.PRICE * T1.AMOUNT) AS TOTAL_SALES
FROM
    FOOD_PRODUCT FP
INNER JOIN
(
    SELECT
        PRODUCT_ID
        , AMOUNT
    FROM FOOD_ORDER 
        WHERE 
    TO_CHAR(PRODUCE_DATE,'YYYYMM')='202205'
)T1
ON FP.PRODUCT_ID = T1.PRODUCT_ID
GROUP BY FP.PRODUCT_ID, FP.PRODUCT_NAME 
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC