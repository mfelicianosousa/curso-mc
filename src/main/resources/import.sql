INSERT INTO category(name) values ('Eletronico');
INSERT INTO category(name) values ('Escritorio');
INSERT INTO category(name) values ('Computadores');
INSERT INTO category(name) values ('Livros');
INSERT INTO product(name, sale_price, unit_measure) values ('Smart TV',2900,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('Mackbook Pro',1250,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('Pc Gamer',1250,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('notebook',100,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('mouse',40,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('teclado',80,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('Java Fundamentos',60,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('Java Intermediario',70,'UN');
INSERT INTO product(name, sale_price, unit_measure) values ('O Senhor dos Aneis',70,'UN');
INSERT INTO product_category (product_id,category_id) values (1,1);
INSERT INTO product_category (product_id,category_id) values (1,3);
INSERT INTO product_category (product_id,category_id) values (2,3);
INSERT INTO product_category (product_id,category_id) values (3,3);
INSERT INTO product_category (product_id,category_id) values (4,3);
INSERT INTO product_category (product_id,category_id) values (4,4);
INSERT INTO product_category (product_id,category_id) values (5,4);
INSERT INTO product_category (product_id,category_id) values (7,4);
INSERT INTO product_category (product_id,category_id) values (8,4);
INSERT INTO product_category (product_id,category_id) values (9,4);