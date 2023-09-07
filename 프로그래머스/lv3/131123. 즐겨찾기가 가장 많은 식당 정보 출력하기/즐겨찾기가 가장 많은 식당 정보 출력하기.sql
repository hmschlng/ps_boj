WITH most_favorite AS (

    SELECT
      food_type,
      MAX(favorites)    AS favorites
    FROM rest_info
    GROUP BY food_type

)

SELECT
  rest_info.food_type,
  rest_info.rest_id,
  rest_info.rest_name,
  rest_info.favorites
FROM rest_info
INNER JOIN most_favorite
  ON rest_info.food_type = most_favorite.food_type
  AND rest_info.favorites = most_favorite.favorites
ORDER BY food_type DESC;


# SELECT
#   food_type,
#   MAX(favorites)    AS favorites
# FROM rest_info
# GROUP BY food_type