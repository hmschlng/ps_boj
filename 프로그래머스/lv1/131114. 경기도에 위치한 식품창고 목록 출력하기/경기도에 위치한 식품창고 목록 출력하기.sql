-- 코드를 입력하세요
select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N')
from food_warehouse
where
    warehouse_name like '%경기%';