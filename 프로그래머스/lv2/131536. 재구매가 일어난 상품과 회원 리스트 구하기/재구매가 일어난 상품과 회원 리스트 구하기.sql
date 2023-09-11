SELECT
  user_id,
  product_id
FROM online_sale
GROUP BY CONCAT(user_id, ' ', product_id)
HAVING COUNT(CONCAT(user_id, ' ', product_id)) > 1
# WHERE COUNT()
ORDER BY user_id ASC, product_id DESC


# SELECT *
# FROM online_sale
# WHERE user_id = 119
