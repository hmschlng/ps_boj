-- 코드를 입력하세요
SELECT 
  mcdp_cd           AS '진료과코드',
  count(mcdp_cd)    AS '5월예약건수'
FROM appointment
WHERE DATE_FORMAT(apnt_ymd, '%Y-%m') = '2022-05'
  # AND apnt_cncl_ymd IS NULL
GROUP BY mcdp_cd
ORDER BY count(mcdp_cd), mcdp_cd

# select * from appointment