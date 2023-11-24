select c.car_id, round(c.period,1) as average_duration
  from(select car_id, avg(datediff(end_date,start_date)+1) as period
  from car_rental_company_rental_history 
 group by car_id
 order by car_id) c
 where c.period>=7
 order by average_duration desc, c.car_id desc
