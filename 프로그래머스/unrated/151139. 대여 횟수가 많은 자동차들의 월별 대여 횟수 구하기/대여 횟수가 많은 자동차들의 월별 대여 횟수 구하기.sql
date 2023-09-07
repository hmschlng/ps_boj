# WITH rent_counts AS (

#     SELECT 
#       car_id                    AS car_id,
#       COUNT(car_id)             AS records
#     FROM car_rental_company_rental_history
#     WHERE DATE_FORMAT(start_date, '%Y-%m-%d') BETWEEN '2022-08-01' AND '2022-10-31'
#     GROUP BY car_id
#     HAVING records >= 5

# )

# SELECT
#   MONTH(car_rental_company_rental_history.start_date)               AS month,
#   car_rental_company_rental_history.car_id                          AS car_id,
#   COUNT(car_rental_company_rental_history.car_id)                   AS records
# FROM rent_counts 
# INNER JOIN car_rental_company_rental_history
#   ON rent_counts.car_id = car_rental_company_rental_history.car_id
# GROUP BY month, car_id
# ORDER BY month ASC, car_id DESC;


SELECT MONTH(start_date) AS month,car_id,COUNT(history_id) AS records
FROM (
    SELECT *, COUNT(history_id) OVER (PARTITION BY car_id) AS cnt
    FROM car_rental_company_rental_history
    WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
          )AS sub
WHERE cnt>=5
GROUP BY month, car_id
ORDER BY month, car_id DESC