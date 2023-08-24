select I.animal_id, I.name
from (
    select animal_id, name, datetime from animal_outs) as O
    inner join animal_ins as I
    on I.animal_id = O.animal_id
where O.datetime < I.datetime
order by I.datetime asc;