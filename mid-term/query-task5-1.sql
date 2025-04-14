select acc.*,cust.* from account acc
left join customer_account cacc on acc.account_id= cacc.account_id
inner join customer cust on cacc.customer_id= cust.customer_id
order by balance desc;

