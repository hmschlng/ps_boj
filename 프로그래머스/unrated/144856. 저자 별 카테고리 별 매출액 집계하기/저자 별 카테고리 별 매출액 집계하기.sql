WITH sales AS (

  SELECT
    book.author_id                        AS author_id,
    book.book_id                          AS book_id,
    book.category                         AS category,
    SUM(book_sales.sales * book.price)    AS total_sales
  FROM book_sales
  JOIN book
    ON book.book_id = book_sales.book_id
  WHERE YEAR(book_sales.sales_date) = '2022'
    AND MONTH(book_sales.sales_date) = '1'
  GROUP BY author_id, category

)

SELECT
  sales.author_id       AS author_id,
  author.author_name    AS author_name,
  sales.category        AS category,
  sales.total_sales     AS total_sales
FROM sales
JOIN author
  ON sales.author_id = author.author_id
GROUP BY author_id, category
ORDER BY author_id ASC, category DESC;