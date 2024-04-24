INSERT INTO roles (id_role, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (2, 'ROLE_USER');

-- Password: AdminGijon11x12
INSERT INTO users (id_user, username, password) VALUES (1, 'admin@gijon11x12.com', '$2a$12$prKWYKRFOKs25Q8nNu1yIe7vVyQEFpcskvRN.hs8372D/R//6dcj.');

INSERT roles_users (role_id, user_id) VALUES (1, 1);

-- Scholarship
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '10000067X','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '11003445P','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '35000780A','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '09354006O','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '10000000X','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '11555060N','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '23567009Q','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '10660500M','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '41003005L','2024-12-22', '2025-01-09');
INSERT INTO scholarships (id_scholarship, dni, start_date, end_date) VALUES (default, '10069108S','2024-12-22', '2025-01-09');


-- Participants
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks, profile_id) VALUES (1, 'Pablo', 'Sánchez', '09765432B', 'Asturias', '33202', 'Gijón', 'Gijón', 'pabloschz@gijon11x12.com', '2019-05-15', 'Aspirina', '', 1);
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks, profile_id) VALUES (2, 'Ana', 'Sánchez', '09855432S', 'Asturias', '33202', 'Gijón', 'Gijón', 'anaschz@gijon11x12.com', '2021-07-21', 'Cacahuetes', 'Medicación en la mochila para usar en caso de intoxicación accidental', 1);
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks, profile_id) VALUES (3, 'María', 'Díaz', '35467339H', 'Galicia', '33211', 'Gijón', 'Gijón', 'maria19@gijon11x12.com', '2020-06-19', '', '', 2);
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks, profile_id) VALUES (4, 'Alberto', 'Castillo', '10715412C', 'Carlos Marx', '33207', 'Gijón', 'Gijón', 'albertito@gijon11x12.com', '2019-07-17', '', '', 3);
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks, profile_id) VALUES (5, 'Zaira', 'Castillo', '05833432Y', 'Carlos Marx', '33207', 'Gijón', 'Gijón', 'zairita@gijon11x12.com', '2021-02-21', 'Gluten', 'Se olvida de poner las gafas', 3);
INSERT INTO participants (id_participant, participant_name, participant_surname, DNI, street, PC, city, municipality, mail, birth_date, allergies, remarks, profile_id) VALUES (6, 'Marcos', 'Rodríguez', '15499939F', 'Peña Mea', '33211', 'Tremañes', 'Gijón', 'maroz13@gijon11x12.com', '2020-03-13', '', '', 4);


 
-- Profile
INSERT INTO profiles (id, dni, profile_name, profile_surname, tlf1, tlf2) VALUES (1, '12345678A', 'Juan', 'Perez', '912345678', '987654321');

-- Camps
INSERT INTO camps (id_camp, camp_name, start_date, end_date, schedule, description, img, numdays, price) VALUES (1, 'Campamento de Navidad', '2024-12-22', '2025-01-09', '', 'Descripción', '/images/Navidad.jpg', '5', '30');
INSERT INTO camps (id_camp, camp_name, start_date, end_date, schedule, description, img, numdays, price) VALUES (2, 'Campamento de Semana Santa', '2024-03-25', '2024-04-01', '', 'Descripción', '/images/SemanaSanta.jpg', '5', '30');
INSERT INTO camps (id_camp, camp_name, start_date, end_date, schedule, description, img, numdays, price) VALUES (3, 'Campamento de Verano', '2024-06-24', '2024-08-30', '', 'Descripción', '/images/Verano.jpg', '5', '30');


-- Schools
INSERT INTO schools (id_schools, school_name) VALUES (1, 'Colegio Público Alfonso Camín');
INSERT INTO schools (id_schools, school_name) VALUES (2, 'Colegio Público Asturias');
INSERT INTO schools (id_schools, school_name) VALUES (3, 'Colegio Público Begoña');
INSERT INTO schools (id_schools, school_name) VALUES (4, 'Colegio Público Clarín');
INSERT INTO schools (id_schools, school_name) VALUES (5, 'Colegio Público El Llano');
INSERT INTO schools (id_schools, school_name) VALUES (6, 'Colegio Público Federico García Lorca');
INSERT INTO schools (id_schools, school_name) VALUES (7, 'Colegio Público Gaspar Melchor de Jovellanos');
INSERT INTO schools (id_schools, school_name) VALUES (8, 'Colegio Público Jacinto Benavente');
INSERT INTO schools (id_schools, school_name) VALUES (9, 'Colegio Público La Escuelona');
INSERT INTO schools (id_schools, school_name) VALUES (10, 'Colegio Público Montevil');
INSERT INTO schools (id_schools, school_name) VALUES (11, 'Colegio Público Montiana');
INSERT INTO schools (id_schools, school_name) VALUES (12, 'Colegio Público Nicanor Piñole');
INSERT INTO schools (id_schools, school_name) VALUES (13, 'Colegio Público Noega');
INSERT INTO schools (id_schools, school_name) VALUES (14, 'Colegio Público Rey Pelayo');
INSERT INTO schools (id_schools, school_name) VALUES (15, 'Colegio Público Río Piles');


-- Camp_Weeks
INSERT INTO camp_weeks (id_week, start_date, end_date, camp_id) VALUES (1, '2024-12-22', '2025-01-09', 1);
INSERT INTO camp_weeks (id_week, start_date, end_date, camp_id) VALUES (2, '2024-03-25', '2024-04-01', 2);
INSERT INTO camp_weeks (id_week, start_date, end_date, camp_id) VALUES (3, '2024-06-24', '2024-08-30', 3);

 -- Inscriptions
INSERT INTO inscriptions (id_inscription, school_id, inscription_date, week_id) VALUES (1, 1, '2024/04/16', 3);
INSERT INTO inscriptions (id_inscription, school_id, inscription_date, week_id) VALUES (2, 2, '2024/04/12', 2);
 
 -- InscriptionParticipant
INSERT INTO inscriptions_participants (id_ins_part, inscription_id, participant_id, breakfast, snack, allergies, remarks, invoice) VALUES (1, 1, 1, TRUE, TRUE, 'Aspirina', 'Sin observaciones', 50); 
INSERT INTO inscriptions_participants (id_ins_part, inscription_id, participant_id, breakfast, snack, allergies, remarks, invoice) VALUES (2, 1, 1, FALSE, FALSE, 'Huevo', 'asmático, lleva inhalador', 0);

-- Invoices
INSERT invoices (id_invoice, total, discount, final_total, pay) VALUES (1, 50, 0, 50, 50);

 -- Prices 
INSERT INTO prices (id_price, service, price) VALUES (1, 'Desayuno', 250);
INSERT INTO prices (id_price, service, price) VALUES (2, 'Comida', 450);
INSERT INTO prices (id_price, service, price) VALUES (3, 'Merienda', 150);
