DROP Sequence guesthouse_sequence;
CREATE Sequence guesthouse_sequence START 10001;

INSERT INTO address_types(id, name, created_at, updated_at)
VALUES (1, 'ClientAddressType', current_timestamp, current_timestamp);

INSERT INTO address_types(id, name, created_at, updated_at)
VALUES (2, 'GuestHouseAddressType', current_timestamp, current_timestamp);

INSERT INTO users(id, first_name,last_name, email, password, active, created_at, updated_at)
VALUES (1, 'Samuel', 'Mumo','samuel@gmail.com','$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',true, current_timestamp, current_timestamp);

INSERT INTO roles(id, name, created_at, updated_at) VALUES (1, 'ADMIN', current_timestamp, current_timestamp);
INSERT INTO roles(id, name, created_at, updated_at) VALUES (2, 'CLIENT', current_timestamp, current_timestamp);
INSERT INTO roles(id, name, created_at, updated_at) VALUES (3, 'CUSTOMER',current_timestamp, current_timestamp);

INSERT INTO users_roles(users_id, roles_id) VALUES (1, 1)


INSERT INTO counties(id, name, created_at, updated_at) VALUES (1, 'Mombasa', current_timestamp, current_timestamp);
INSERT INTO counties(id, name, created_at, updated_at) VALUES (2, 'Nairobi', current_timestamp, current_timestamp);
INSERT INTO counties(id, name, created_at, updated_at) VALUES (3, 'Kwale', current_timestamp, current_timestamp);
INSERT INTO counties(id, name, created_at, updated_at) VALUES (4, 'Nakuru', current_timestamp, current_timestamp);
