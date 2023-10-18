WITH board_2210 AS (

    SELECT 
        board_id    AS board_id,
        title       AS title
    FROM used_goods_board
    WHERE YEAR(created_date) = '2022'
      AND MONTH(created_date) = '10'

)


SELECT
  board_2210.title                                          AS title, 
  board_2210.board_id                                       AS board_id, 
  used_goods_reply.reply_id                                 AS reply_id, 
  used_goods_reply.writer_id                                AS writer_id, 
  used_goods_reply.contents                                 AS contents, 
  DATE_FORMAT(created_date, '%Y-%m-%d')    AS created_date
FROM used_goods_reply
JOIN board_2210
  ON used_goods_reply.board_id = board_2210.board_id
ORDER BY created_date ASC, title ASC;

/*
2022년 10월에 작성된 게시글 title, board_id, reply_id, writer_id, contents, created_date
created_date ASC, title ASC
*/