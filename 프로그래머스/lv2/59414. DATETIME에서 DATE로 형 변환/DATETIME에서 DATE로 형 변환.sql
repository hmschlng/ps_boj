SELECT
  animal_id,
  name,
  DATE_FORMAT(datetime, '%Y-%m-%d') as datetime
FROM animal_ins
ORDER BY animal_id;