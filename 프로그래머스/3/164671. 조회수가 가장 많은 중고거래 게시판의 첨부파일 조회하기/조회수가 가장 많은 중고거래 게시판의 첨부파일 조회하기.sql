select concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) as FILE_PATH
  from used_goods_file
 where board_id=(select board_id from USED_GOODS_BOARD where views=(select max(views) from USED_GOODS_BOARD))
 order by file_id desc