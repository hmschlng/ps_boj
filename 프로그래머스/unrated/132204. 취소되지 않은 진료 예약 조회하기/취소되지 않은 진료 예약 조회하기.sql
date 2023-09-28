# 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
# apnt_no, 

WITH apnt_0413 AS (

    SELECT
      apnt_no,
      pt_no,
      mcdp_cd,
      mddr_id,
      apnt_ymd
    FROM appointment
    WHERE mcdp_cd = 'CS'
      AND DATE_FORMAT(apnt_ymd, '%Y-%m-%d') = '2022-04-13'
      AND apnt_cncl_yn = 'N'
    
)

SELECT
  apnt_0413.apnt_no     AS apnt_no,
  patient.pt_name       AS pt_name,
  apnt_0413.pt_no       AS pt_no,
  apnt_0413.mcdp_cd     AS mcdp_cd,
  doctor.dr_name        AS dr_name,
  apnt_0413.apnt_ymd    AS apnt_ymd
FROM apnt_0413
JOIN doctor
  ON apnt_0413.mddr_id = doctor.dr_id
JOIN patient
  ON apnt_0413.pt_no = patient.pt_no
ORDER BY apnt_ymd ASC;

  
