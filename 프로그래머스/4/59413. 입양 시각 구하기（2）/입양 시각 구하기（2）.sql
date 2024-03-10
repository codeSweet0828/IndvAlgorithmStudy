WITH TMP AS(
    SELECT
        LEVEL -1 AS HOUR
    FROM DUAL
    CONNECT BY LEVEL -1<=23
)
SELECT 
    T.HOUR
    ,NVL(T1.CNT,0) AS COUNT
FROM TMP T
LEFT JOIN (
    SELECT
        COUNT(*) AS CNT
        , TO_NUMBER(TO_CHAR(DATETIME ,'HH24')) AS HOUR
    FROM ANIMAL_OUTS 
    GROUP BY TO_CHAR(DATETIME ,'HH24')
)T1
ON T.HOUR = T1.HOUR
ORDER BY T.HOUR