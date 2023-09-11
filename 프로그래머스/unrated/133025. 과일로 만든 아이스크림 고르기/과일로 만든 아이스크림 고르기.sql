WITH bestsellers AS (

    SELECT 
      flavor,
      total_order
    FROM first_half
    WHERE total_order > 3000
    
)

SELECT
  bestsellers.flavor
FROM bestsellers
LEFT JOIN icecream_info
  ON bestsellers.flavor = icecream_info.flavor
WHERE icecream_info.ingredient_type = 'fruit_based'
ORDER BY bestsellers.total_order DESC
