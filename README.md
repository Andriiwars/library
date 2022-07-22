## Library

This is REST API to manage DB entities - Book, Author

- --

### Available endpoints:
- GET: /books - all books
- GET: /authors - all authors
- GET: /books/id - get books by id
- GET: /authors/id - get author by id
- 
- POST: /books - add book
- POST: /authors - add author
- 
- PUT: /books/id - update book by id
- PUT: /authors/id - update author by id
- 
- DELETE: /books/id - delete book by id
- DELETE: /authors/id - delete author by id
- 
- GET: /books/author-name - get books by author name
- GET: /books/max-sold - get most selling books by author name
- GET: /books/most-published - get most published books by author name
- GET: /books/max-sold-by-part-name - get most selling books by author part name
- GET: /books/most-published-by-part-name - get most published books by author part name
- GET: /books/most-success-rate - get book by most success rate by author part name

- --

### If you want to run this project on your computer, you need:
1. Fork and clone this project
2. Add Lombok plugin to your IDE
3. Run the application
4. Use Postman for sending your requests during testing this application
5. Use H2-database in memory
- --

### Used technologies
- Java 17
- SpringBoot
- SpringBoot Data JPA
- Spring Web
- Lombok
- H2 Database
