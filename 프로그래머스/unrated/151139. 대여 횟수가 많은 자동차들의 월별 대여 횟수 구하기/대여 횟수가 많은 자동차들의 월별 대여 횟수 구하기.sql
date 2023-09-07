# WITH rent_counts AS (

#     SELECT 
#       car_id                    AS car_idd,
#       COUNT(car_id)             AS records
#     FROM car_rental_company_rental_history
#     WHERE DATE_FORMAT(start_date, '%Y-%m-%d') BETWEEN DATE_FORMAT('2022-08-01', '%Y-%m-%d') AND DATE_FORMAT('2022-10-31', '%Y-%m-%d')
#     GROUP BY car_id
#     HAVING COUNT(car_id) >= 5
#     ORDER BY car_id

# )

# SELECT
#   DATE_FORMAT(car_rental_company_rental_history.start_date, '%m')    AS month,
#   car_rental_company_rental_history.car_id,
#   COUNT(car_rental_company_rental_history.car_id) AS records
# FROM rent_counts 
# INNER JOIN car_rental_company_rental_history
#   ON rent_counts.car_idd = car_rental_company_rental_history.car_id
# GROUP BY month, car_id

# ORDER BY month ASC, car_id desc;

with a as(
    SELECT CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where date_format(START_DATE, '%Y-%m') between '2022-08' and '2022-10'
    group by CAR_ID
    having count(*) >= 5
)

SELECT date_format(START_DATE, '%m') as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where (date_format(START_DATE, '%Y-%m') between '2022-08' and '2022-10') 
    and CAR_ID in (select * from a)
group by MONTH, CAR_ID
order by MONTH, CAR_ID desc