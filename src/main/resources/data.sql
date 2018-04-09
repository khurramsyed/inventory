insert into Inventory(id, quantity ,description) VALUES
(1, 100, 'Inventory - Java 10 in Action'),
(2, 20, 'Inventory - Spring Boot and microservices'),
(3, 20, 'Inventory - Hands on microservices with Kotlin');


insert into Items(id, code, name, description, price, inventory_id) VALUES
(1, 'B001', 'Java 10 in Action', 'A Great Java Book', 30,1),
(2, 'B002', 'Spring Boot and microservices', 'microservices book', 35 ,2),
(3, 'B003', 'Hands on microservices with Kotlin', 'Kotlin Book', 25 ,3);