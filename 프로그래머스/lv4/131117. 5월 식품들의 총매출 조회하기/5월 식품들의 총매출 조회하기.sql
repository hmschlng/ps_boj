WITH sales AS (

    SELECT
      product_id    AS product_id,
      SUM(amount)   AS amount
    FROM food_order
    WHERE YEAR(produce_date) = '2022'
      AND MONTH(produce_date) = '05'
    GROUP BY product_id
    
)

SELECT
    food_product.product_id             AS product_id,
    food_product.product_name           AS product_name,
    food_product.price * sales.amount   AS total_sales
FROM sales
INNER JOIN food_product
  ON sales.product_id = food_product.product_id
ORDER BY total_sales DESC, product_id ASC;
