select O.ANIMAL_ID, O.NAME
from
    ANIMAL_INS as I
    right join
    ANIMAL_OUTS as O
    on O.ANIMAL_ID = I.ANIMAL_ID
where
    I.ANIMAL_ID is null
order by O.ANIMAL_ID;