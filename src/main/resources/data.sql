DROP Sequence guesthouse_sequence;
CREATE Sequence guesthouse_sequence START 10001;

INSERT INTO address_types(id, name, created_at, updated_at)
VALUES (1, 'ClientAddressType', current_timestamp, current_timestamp);

INSERT INTO address_types(id, name, created_at, updated_at)
VALUES (2, 'GuestHouseAddressType', current_timestamp, current_timestamp);

INSERT INTO users(id, first_name,last_name, email, password, active, created_at, updated_at)
VALUES (1, 'Samuel', 'Mumo','samuel@gmail.com','$2a$10$Z65pHQUCOGWXBDjDNu/Xf.Db06XuACBO1S5FjeXfqDAHw2oDU5D/C',true, current_timestamp, current_timestamp);

INSERT INTO users(id, first_name,last_name, email, password, active, created_at, updated_at)
VALUES (2, 'Samuel', 'Mumo','owner@gmail.com','$2a$10$Z65pHQUCOGWXBDjDNu/Xf.Db06XuACBO1S5FjeXfqDAHw2oDU5D/C',true, current_timestamp, current_timestamp);

INSERT INTO users(id, first_name,last_name, email, password, active, created_at, updated_at)
VALUES (3, 'Samuel', 'Mumo','guest@gmail.com','$2a$10$Z65pHQUCOGWXBDjDNu/Xf.Db06XuACBO1S5FjeXfqDAHw2oDU5D/C',true, current_timestamp, current_timestamp);

INSERT INTO roles(id, name, created_at, updated_at) VALUES (1, 'ADMIN', current_timestamp, current_timestamp);
INSERT INTO roles(id, name, created_at, updated_at) VALUES (2, 'OWNER', current_timestamp, current_timestamp);
INSERT INTO roles(id, name, created_at, updated_at) VALUES (3, 'GUEST',current_timestamp, current_timestamp);
INSERT INTO roles(id, name, created_at, updated_at) VALUES (4, 'EMAIL_VALIDATED',current_timestamp, current_timestamp);


INSERT INTO users_roles(users_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles(users_id, roles_id) VALUES (2, 2);
INSERT INTO users_roles(users_id, roles_id) VALUES (3, 3);

INSERT INTO counties(id, name, created_at, updated_at) VALUES (1, 'Mombasa', current_timestamp, current_timestamp);
INSERT INTO counties(id, name, created_at, updated_at) VALUES (2, 'Nairobi', current_timestamp, current_timestamp);
INSERT INTO counties(id, name, created_at, updated_at) VALUES (3, 'Kwale', current_timestamp, current_timestamp);
INSERT INTO counties(id, name, created_at, updated_at) VALUES (4, 'Nakuru', current_timestamp, current_timestamp);
