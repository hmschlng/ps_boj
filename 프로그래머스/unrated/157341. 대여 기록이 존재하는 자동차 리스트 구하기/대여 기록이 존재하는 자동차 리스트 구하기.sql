WITH car_types AS (

    SELECT
      car_id,
      car_type
    FROM car_rental_company_car
    WHERE car_type = '세단'

), history AS (

    SELECT
      car_id,
      start_date
    FROM car_rental_company_rental_history
    WHERE start_date LIKE '2022-10%'
)

SELECT
  car_types.car_id      AS car_id
FROM car_types
JOIN history
ON car_types.car_id = history.car_id
GROUP BY car_types.car_id
ORDER BY car_types.car_id DESC;