WITH january_sales AS (

    SELECT
      book_id,
        sales
    FROM book_sales
    WHERE sales_date LIKE '2022-01%'

)

SELECT
  book.category                       AS category,
  SUM(january_sales.sales)      AS total_sales
FROM book
JOIN january_sales
  ON book.book_id = january_sales.book_id
GROUP BY book.category
ORDER BY book.category ASC;

# select * from book
# SELECT 
#     book_id,
#     sales
# FROM book_sales
# WHERE sales_date LIKE '2022-01%' AND (
#     book_id = '2')
# GROUP BY book_id