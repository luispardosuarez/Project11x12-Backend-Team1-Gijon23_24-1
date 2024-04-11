INSERT INTO roles (id_role, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (2, 'ROLE_USER');

-- Password: AdminGijon11x12
INSERT INTO users (id_user, username, password) VALUES (1, 'admin@gijon11x12.com', '$2a$12$prKWYKRFOKs25Q8nNu1yIe7vVyQEFpcskvRN.hs8372D/R//6dcj.');

INSERT roles_users (role_id, user_id) VALUES (1, 1);

-- Scholarship
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '10000000X');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '20000000Y');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '30000000Z');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '40000000J');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '50000000K');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '60000000V');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '70000000H');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '80000000T');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '90000000R');
INSERT INTO scholarships (id_scholarship, dni) VALUES (default, '11000000W');


-- Participants
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks) 
VALUES (1, 'Casiano', 'Chapas', '98765432B', 'Tontorron', '33321', 'Sama', 'Langreo', 'casiano@gijon11x12.com', '1989-05-15', 'Aspirina', 'Sin observaciones');


-- Profile
INSERT INTO profiles (id, dni, profile_name, profile_surname, tlf1, tlf2) VALUES (1, '12345678A', 'Juan', 'Perez', '912345678', '987654321');

-- Camps
INSERT INTO camps (id_camp, camp_name, start_date, end_date, schedule, description, img, numdays) VALUES (1, 'Campamento de Navidad', '2024-12-22', '2025-01-09', '', 'Descripción', '', '5');
INSERT INTO camps (id_camp, camp_name, start_date, end_date, schedule, description, img, numdays) VALUES (2, 'Campamento de Semana Santa', '2024-03-25', '2024-04-01', '', 'Descripción', '', '5');
INSERT INTO camps (id_camp, camp_name, start_date, end_date, schedule, description, img, numdays) VALUES (3, 'Campamento de Verano', '2024-06-24', '2024-08-30', '', 'Descripción', '', '5');


-- Schools
INSERT INTO schools (id_school, school_name) VALUES (1, 'Colegio La Escuelona');
INSERT INTO schools (id_school, school_name) VALUES (2, 'Colegio Nicanor Piñole');
INSERT INTO schools (id_school, school_name) VALUES (3, 'Colegio Río Piles');
