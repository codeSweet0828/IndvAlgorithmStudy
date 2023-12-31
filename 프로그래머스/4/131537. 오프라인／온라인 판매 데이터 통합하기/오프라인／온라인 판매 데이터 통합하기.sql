SELECT 
    T1.SALES_DATE,
    T1.PRODUCT_ID,
    T1.USER_ID,
    T1.SALES_AMOUNT
FROM (
    SELECT
        TO_CHAR(SALES_DATE, 'YYYY-MM-DD') AS SALES_DATE,
        PRODUCT_ID,
        NULL AS USER_ID,
        SALES_AMOUNT
    FROM
        OFFLINE_SALE
    WHERE TO_CHAR(SALES_DATE, 'YYYYMM') = '202203'
    UNION
    SELECT
        TO_CHAR(SALES_DATE, 'YYYY-MM-DD') AS SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
    FROM
        ONLINE_SALE
    WHERE TO_CHAR(SALES_DATE, 'YYYYMM') = '202203'
) T1
ORDER BY
    T1.SALES_DATE ASC, T1.PRODUCT_ID ASC, T1.USER_ID ASC;
