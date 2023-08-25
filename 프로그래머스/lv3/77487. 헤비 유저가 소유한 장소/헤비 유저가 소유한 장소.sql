select P.id, P.name, P.host_id
from places as P
    join (
        select host_id 
        from places 
        group by host_id 
        having count(host_id) > 1
    ) as H
    on P.host_id = H.host_id
order by P.id;

# # SELECT P.ID, P.NAME, P.HOST_ID
# # FROM PLACES P
# # JOIN (SELECT HOST_ID FROM PLACES GROUP BY HOST_ID HAVING COUNT(*) > 1) CP
# # ON P.HOST_ID = CP.HOST_ID
# # ORDER BY P.ID


# SELECT host_id FROM PLACES GROUP BY HOST_ID HAVING COUNT(host_id) > 1

