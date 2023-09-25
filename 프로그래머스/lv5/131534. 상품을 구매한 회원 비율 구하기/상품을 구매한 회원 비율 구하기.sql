# 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력하는 SQL문을 작성해주세요.

WITH user_cnt AS (

  SELECT
    COUNT(*)    AS cnt
  FROM user_info
  WHERE YEAR(joined) = '2021'

), user_2021 AS (

  SELECT user_id
  FROM user_info
  WHERE YEAR(joined) = '2021'

)


SELECT
  YEAR(sales_date)                                  AS year,
  MONTH(sales_date)                                 AS month,
  COUNT(DISTINCT online_sale.user_id)               AS puchased_users,
  ROUND(COUNT(DISTINCT online_sale.user_id)/(SELECT cnt FROM user_cnt), 1)     AS puchased_ratio
FROM online_sale
JOIN user_2021
WHERE online_sale.user_id = user_2021.user_id
GROUP BY year, month
ORDER BY year ASC, month ASC;