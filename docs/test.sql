show tables;

desc member;
select * from book;
SELECT no, book_name, book_price, category.category_name 
	FROM book, category 
where book.category_no = category.no;

INSERT INTO book(book_name, book_price, category_no) VALUES('대규모 시스템을 지탱하는 기술',25000,3);

select * from member;
select * from category;
select * from cart;
select * from book;
select * from orders;
select * from orders_book;
desc cart;
desc member;
desc book;
desc orders;
select m.no, b.no, c.cart_count, m.member_name, b.book_name, b.book_price  
	from book b, cart c, member m 
where b.no = c.book_no 
	and c.member_no = m.no 
	and m.no = 1;

	INSERT INTO orders(member_no, orders_code, orders_price, address) 
		values(1,(select concat(date_format(now(),'%Y%m%d'),'_',count(*)+1) 
					from orders a 
				  where date_format(a.orders_time,'%Y%m%d') = date_format(now(),'%Y%m%d'))
                  ,35000,'우리집주소');
    
    
    select concat(date_format(now(),'%Y%m%d'),'_',LPAD(count(*)+1,8,'0') 
		from orders a 
	where date_format(a.orders_time,'%Y%m%d') = date_format(now(),'%Y%m%d');
;
delete from orders 
	where address like '%대한민국%';
select * from orders;
desc orders_book;
insert into orders_book(book_no, orders_no, orders_count) values(?,?,?);

select m.member_name, orders_code, orders_price, address, orders_time  
	from orders o, member m 
where o.member_no = 1
	and o.member_no = m.no;
    
    