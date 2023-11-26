

SELECT
    RI.REST_ID
    , RI.REST_NAME
    , RI.FOOD_TYPE
    , RI.FAVORITES
    , RI.ADDRESS
    , RRV.SCORE
FROM
    REST_INFO RI
INNER JOIN(
    SELECT
        REST_ID
        , ROUND(AVG(REVIEW_SCORE),2) AS SCORE             
    FROM 
        REST_REVIEW
    GROUP BY REST_ID
) RRV
ON RI.ADDRESS LIKE '서울%'
    AND RI.REST_ID  = RRV.REST_ID
ORDER BY RRV.SCORE DESC , RI.FAVORITES DESC





