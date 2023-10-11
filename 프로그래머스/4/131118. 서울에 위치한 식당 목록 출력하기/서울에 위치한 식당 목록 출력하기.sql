-- 코드를 입력하세요
# rest_id
# rest_name
# food_type
# favorites
# address
# score -> round(avg(review_score), 2)

WITH score_avg AS (

    SELECT
      rest_id                       AS rest_id,
      ROUND(AVG(review_score), 2)   AS score 
    FROM rest_review
    GROUP BY rest_id

)

SELECT
  rest_info.rest_id     AS rest_id,
  rest_info.rest_name   AS rest_name, 
  rest_info.food_type   AS food_type,
  rest_info.favorites   AS favorites,
  rest_info.address     AS address,
  score_avg.score       AS score
FROM rest_info
JOIN score_avg
  ON rest_info.rest_id = score_avg.rest_id
WHERE address LIKE '서울%'
ORDER BY score DESC, favorites DESC;