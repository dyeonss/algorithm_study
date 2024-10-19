select hh.history_id, floor(hh.diff*(hh.daily_fee*(100-ifnull(p.discount_rate,0))*0.01)) as fee
  from (select h.history_id,h.car_id, c.car_type, c.daily_fee, datediff(end_date,start_date)+1 as diff,
           case 
           when datediff(end_date,start_date)+1>=90 then '90일 이상'
           when datediff(end_date,start_date)+1>=30 then '30일 이상'
           when datediff(end_date,start_date)+1>=7 then '7일 이상'
           else 'none'
           end as duration_type
          from car_rental_company_car c
          join car_rental_company_rental_history h
         where c.car_id=h.car_id
           and c.car_type='트럭') hh
 left join car_rental_company_discount_plan p
 on hh.car_type=p.car_type
   and hh.duration_type=p.duration_type
order by fee desc, history_id desc
