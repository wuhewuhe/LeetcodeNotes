SELECT c.customer_id

FROM customer as c

where c.customer_id not in (

  select o.customer_id

  from purchase_order as o

);





SELECT shipperID, count(shipperid)
FROM [Orders]
group by shipperid
having count(shipperid) > 60
order by  count(shipperid) desc



SELECT distinct(c.customerid)
FROM Customers as c 
inner JOIN Orders as o ON c.CustomerID=o.CustomerID
inner join orderdetails as od on od.orderid = o.orderid
inner join products as p on p.productid = od.productid
inner join categories as cg on cg.categoryid = p.categoryid
where cg.categoryname = 'Beverages'
order by c.customerid