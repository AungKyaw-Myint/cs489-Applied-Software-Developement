select * from transaction tran, account acc
where tran.account_id=acc.account_id
and value_amount >= 500.00 
order by transaction_date;