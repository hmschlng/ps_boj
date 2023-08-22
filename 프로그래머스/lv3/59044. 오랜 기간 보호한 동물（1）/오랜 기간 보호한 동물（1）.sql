-- 코드를 입력하세요
# select * from animal_ins;

# select * from animal_outs;

select name, datetime
from animal_ins
where 
    animal_id not in (
        select animal_id
        from animal_outs
    )
order by datetime limit 3;