BEGIN;
DROP TABLE IF EXISTS buildings CASCADE;
CREATE TABLE buildings (id bigserial PRIMARY KEY, address VARCHAR(255));
INSERT INTO buildings (address) VALUES
                                    ('ул. Гоголя'),
                                    ('ул. Ленина'),
                                    ('ул. Давыдова');

DROP TABLE IF EXISTS libraries CASCADE;
CREATE TABLE libraries (id bigserial PRIMARY KEY, name VARCHAR(255), phoneNumber VARCHAR(255), building_id bigint, FOREIGN KEY (building_id) REFERENCES buildings(id));
INSERT INTO libraries (name, phoneNumber, building_id) VALUES
                                                 ('library1', '+71111111111', 1),
                                                 ('library2', '+72222222222', 2),
                                                 ('library3', '+73333333333', 3),
                                                 ('library4', '+777777777777', 3);



DROP TABLE IF EXISTS workers CASCADE;
CREATE TABLE workers (id bigserial PRIMARY KEY, name VARCHAR(255), library_id bigint, FOREIGN KEY (library_id) REFERENCES libraries(id));
INSERT INTO workers (name, library_id) VALUES
                                ('Алесандр', 1),
                                ('Андрей', 2),
                                ('Роман', 1),
                                ('Кристина', 3),
                                ('Дария', 1);

DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books (id bigserial PRIMARY KEY, name VARCHAR(255), page  int );
INSERT INTO books (name, page) VALUES
                                                               ('book1', 12),
                                                               ('book2', 21 ),
                                                               ('book3', 24 );

DROP TABLE IF EXISTS libraries_books CASCADE;
CREATE TABLE libraries_books (library_id bigint, book_id bigint, FOREIGN KEY (library_id) REFERENCES libraries (id), FOREIGN KEY (book_id) REFERENCES books (id));
INSERT INTO libraries_books (library_id, book_id) VALUES
                                                     (1, 1),
                                                     (2, 1),
                                                     (2, 2),
                                                     (3, 1);

COMMIT;