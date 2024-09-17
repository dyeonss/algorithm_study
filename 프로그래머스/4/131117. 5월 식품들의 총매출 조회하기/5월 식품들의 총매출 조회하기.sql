SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(AMOUNT)*PRICE AS TOTAL_SALES
  FROM FOOD_PRODUCT AS P
  JOIN FOOD_ORDER AS O
    ON P.PRODUCT_ID=O.PRODUCT_ID
 WHERE DATE_FORMAT(O.PRODUCE_DATE,'%Y%m')='202205'
 GROUP BY PRODUCT_ID
 ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC