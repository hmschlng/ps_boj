WITH top_view AS (

    SELECT
      board_id
    FROM used_goods_board
    ORDER BY views DESC
    LIMIT 1

), top_files AS (
    SELECT 
      used_goods_file.file_id       AS file_id,
      used_goods_file.file_ext      AS ext,
      used_goods_file.file_name     AS name,
      used_goods_file.board_id      AS board_id
    FROM used_goods_file
    JOIN top_view
      ON used_goods_file.board_id = top_view.board_id
)

SELECT
  CONCAT('/home/grep/src/', board_id, '/', file_id, name, ext)  AS file_path
FROM top_files
ORDER BY file_id DESC;


