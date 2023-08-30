WITH total_sales AS (

    SELECT
      writer_id     AS writer_id,
      SUM(price)    AS total_sales    
    FROM used_goods_board
    WHERE status = 'DONE'
    GROUP BY writer_id

), user_nicknames AS (

    SELECT
      user_id       AS user_id,
      nickname      AS nickname
    FROM used_goods_user
    
)

SELECT 
  user_nicknames.user_id        AS user_id,
  user_nicknames.nickname       AS nickname,
  total_sales.total_sales       AS total_sales
FROM user_nicknames
JOIN total_sales
  ON user_nicknames.user_id = total_sales.writer_id
WHERE total_sales.total_sales >= 700000
ORDER BY total_sales.total_sales ASC;