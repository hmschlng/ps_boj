SELECT
  TRUNCATE(price/10000,0) * 10000   AS price_group,
  COUNT(product_id)                 AS products
FROM product  
GROUP BY price_group
ORDER BY price_group

# select * from product
