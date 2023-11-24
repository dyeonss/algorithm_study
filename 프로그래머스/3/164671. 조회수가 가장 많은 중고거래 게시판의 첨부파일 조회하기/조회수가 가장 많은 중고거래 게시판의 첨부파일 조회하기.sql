select concat('/home/grep/src/',f.board_id,'/',f.file_id,f.file_name,f.file_ext) as file_path
from(select board_id
       from used_goods_board
      order by views desc
      limit 1) b
    , used_goods_file f
where f.board_id=b.board_id
order by f.file_id desc
