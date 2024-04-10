INSERT INTO shippingmethod ("name", "duration", "price_in_$")
VALUES (
        'ohispeed',
        '5 hours',
        20.20
    );
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
 