select distinct a.user_id, a.product_id
  from online_sale a, online_sale b
 where a.user_id=b.user_id
   and a.product_id=b.product_id
   and a.online_sale_id!=b.online_sale_id
 order by user_id asc, product_id desc
