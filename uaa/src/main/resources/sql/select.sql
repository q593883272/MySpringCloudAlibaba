--- 查询用户信息
select *
from user_status us;

--- 根据用户名查询用户角色
select r.*
from role r,
     user_status us,
     user_group ug,
     user_group_user_status ugus,
     user_group_role ugr
where us.username = ugus.username
  and ug.id = ugus.user_group_id
  and ug.id = ugr.user_group_id
  and r.id = ugr.role_id
  and us.username = 'xxx';


--- 根据用户名查询用户角色
select r.*
from role r,
     user_status us,
     user_status_role usr
where r.id = usr.role_id
  and us.username = usr.username
  and us.username = 'xxx';



select distinct r.* from role r,
     user_status us,
     user_status_role usr,
     user_group ug,
     user_group_user_status ugus,
     user_group_role ugr
where (
    r.id = usr.role_id
    and us.username = usr.username
    and us.username = 'q593883272'
  ) or (
    us.username = ugus.username
    and ug.id = ugus.user_group_id
    and ug.id = ugr.user_group_id
    and r.id = ugr.role_id
    and us.username = 'q593883272'
  );

select distinct r.* from role r
       left join user_status_role usr on r.id = usr.role_id
       left join user_group_role ugr
       left join user_status us on us.username = usr.username
       left join user_group_user_status ugus
       left join user_group ug on ug.id = ugr.user_group_id and ug.id = ugus.user_group_id
where us.username = 'q593883272';











