INSERT INTO shippingmethod ("name", "duration", "price_in_$")
VALUES 
    ('ohispeed', '30 min', 50.99),
    ('express', '3 hours', 30.50),
    ('standard', '1 day', 15.99);


INSERT INTO authorities ("authority_id", "authority_name")
VALUES(1, 'READ'),
    (2, 'CREATE'),
    (3, 'UPDATE'),
    (4, 'DELETE');
INSERT INTO roles("role_id", "role_name")
VALUES (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO roles_authorities("role_id", "authority_id")
VALUES(1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 1);

INSERT INTO users ("password", "name", "user_role")
VALUES ('123', 'admin', 1),
    ('user1', 'Guest', 2);
