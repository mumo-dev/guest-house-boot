
INSERT INTO address_types(id, name, created_at, updated_at)
VALUES (1, 'ClientAddressType', now(), now());

INSERT INTO address_types(id, name, created_at, updated_at)
VALUES (2, 'GuestHouseAddressType', now(), now());

--INSERT INTO users(id, first_name,last_name, email, password, active, created_at, updated_at)
--VALUES (1, 'Samuel', 'Mumo','samuel@gmail.com','$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',1, now(), now())

INSERT INTO roles(id, name, created_at, updated_at) VALUES (1, 'ADMIN', now(), now());
INSERT INTO roles(id, name, created_at, updated_at) VALUES (2, 'CLIENT', now(), now());
INSERT INTO roles(id, name, created_at, updated_at) VALUES (3, 'CUSTOMER', now(), now());

INSERT INTO users_roles(users_id, roles_id) VALUES (1, 1)
