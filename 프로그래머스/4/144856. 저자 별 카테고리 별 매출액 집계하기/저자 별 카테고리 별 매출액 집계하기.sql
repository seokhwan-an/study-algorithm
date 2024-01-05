-- 코드를 입력하세요
SELECT 
book.author_id, author.author_name, book.category,
sum(sale.sales * book.price) as total_sales
FROM book book
JOIN author author on book.author_id = author.author_id
JOIN book_sales sale on book.book_id = sale.book_id
WHERE date_format(sale.sales_date, "%Y-%m") = "2022-01"
GROUP BY book.author_id, book.category
ORDER BY book.author_id asc, book.category desc