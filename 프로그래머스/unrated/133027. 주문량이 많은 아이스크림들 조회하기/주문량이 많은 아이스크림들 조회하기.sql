select flavor
  from (select sum(j.total_order+f.total_order) as sum, j.flavor as flavor
  from july j, first_half f
 where j.flavor = f.flavor
 group by j.flavor
 order by sum desc
        )
 where rownum<=3
 