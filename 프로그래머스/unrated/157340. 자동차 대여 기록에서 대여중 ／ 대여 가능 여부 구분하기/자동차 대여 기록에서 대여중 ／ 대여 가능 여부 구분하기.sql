WITH car_ids AS (
    
    SELECT
      DISTINCT(car_id)
    FROM car_rental_company_rental_history
    
), car_rented AS (

    SELECT
      DISTINCT(car_id)
    FROM car_rental_company_rental_history
    WHERE end_date   >= '2022-10-16'
      AND start_date <= '2022-10-16'

)

SELECT 
  car_ids.car_id    AS car_id,
  CASE
    WHEN car_rented.CAR_ID IS NULL THEN '대여 가능'
    ELSE                                '대여중'
  END               AS availability
FROM car_ids
LEFT JOIN car_rented
  ON car_ids.car_id = car_rented.car_id
ORDER BY car_id DESC;
  