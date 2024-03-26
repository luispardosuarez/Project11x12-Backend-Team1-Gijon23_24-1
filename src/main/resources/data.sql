INSERT INTO roles (id_role, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (2, 'ROLE_USER');
-- Password: AdminGijon11x12
INSERT INTO users (id_user, user_email, password) VALUES (1, 'admin@gijon11x12.com', '$2a$12$prKWYKRFOKs25Q8nNu1yIe7vVyQEFpcskvRN.hs8372D/R//6dcj.');

INSERT roles_users (role_id, user_id) VALUES (1, 1);

-- Scholarship

INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '10000000X');
