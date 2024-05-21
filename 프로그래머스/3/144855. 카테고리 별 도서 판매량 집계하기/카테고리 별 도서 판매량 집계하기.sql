-- 코드를 입력하세요
SELECT book.category, sum(sales.sales) total_sales
FROM BOOK book
JOIN BOOK_SALES sales on book.book_id = sales.book_id
WHERE date_format(sales.sales_date, '%Y-%m') = '2022-01'
GROUP BY book.category
ORDER BY book.category asc