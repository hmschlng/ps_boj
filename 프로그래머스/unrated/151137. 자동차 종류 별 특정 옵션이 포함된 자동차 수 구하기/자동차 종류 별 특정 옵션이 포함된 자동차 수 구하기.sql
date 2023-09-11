-- 코드를 입력하세요
SELECT 
  car_type,
  COUNT(*) AS cars
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%시트%'
GROUP BY car_type
ORDER BY car_type;