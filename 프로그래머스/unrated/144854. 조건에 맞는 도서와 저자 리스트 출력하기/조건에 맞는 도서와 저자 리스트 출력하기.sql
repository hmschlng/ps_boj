WITH cat_economy AS (
    
    SELECT
      category,
      book_id,
      author_id,
      DATE_FORMAT(published_date, '%Y-%m-%d') AS published_date
    FROM book
    WHERE category = '경제'

)

SELECT
  cat_economy.book_id,
  author.author_name,
  cat_economy.published_date
FROM author
RIGHT JOIN cat_economy
  ON author.author_id = cat_economy.author_id
ORDER BY published_date ASC