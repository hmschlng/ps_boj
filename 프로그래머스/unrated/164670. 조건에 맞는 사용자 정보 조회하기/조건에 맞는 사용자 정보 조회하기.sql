# 중고거래 게시물을 3건 이상 등록한 사용자
# select WRITER_ID, count(WRITER_ID)
# from USED_GOODS_BOARD
# group by WRITER_ID
# having count(WRITER_ID) >= 3
# order by WRITER_ID desc;

select 
    U.USER_ID,
    U.NICKNAME,
    concat(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) as '전체주소',
    concat(substring(U.TLNO, 1, 3), '-', substring(U.TLNO, 4, 4), '-', substring(U.TLNO, 8)) as '전화번호'
from (
        select WRITER_ID
        from USED_GOODS_BOARD
        group by WRITER_ID
        having count(WRITER_ID) >= 3
    ) as B
    left join 
    used_goods_user as U
    on U.USER_ID = B.WRITER_ID
order by U.USER_ID desc;