-- SCRIPT DE INIȚIALIZARE A BAZEI DE DATE (data.sql)
-- ATENTIE: Au fost eliminate toate comenzile DELETE/TRUNCATE.
-- Spring Boot rulează acest script după ce tabelele sunt create de Hibernate.

-- Dezactivarea verificărilor FK pentru a permite inserarea relațiilor

SET FOREIGN_KEY_CHECKS = 0;

-----------------------------------------------------------
-- 1. UNIVERSITIES (10 records)
-----------------------------------------------------------
INSERT INTO university (id, name, city) VALUES
                                              ('U1', 'Politehnica Timisoara', 'Timisoara'),
                                              ('U2', 'Universitatea Bucuresti', 'Bucuresti'),
                                              ('U3', 'Universitatea Babes', 'Cluj'),
                                              ('U4', 'Univ. Al. I. Cuza', 'Iasi'),
                                              ('U5', 'Univ. Vest Timisoara', 'Timisoara'),
                                              ('U6', 'Univ. Medicina Cluj', 'Cluj'),
                                              ('U7', 'Univ. Arhitectura', 'Bucuresti'),
                                              ('U8', 'Univ. Arte', 'Iasi'),
                                              ('U9', 'Univ. Craiova', 'Craiova'),
                                              ('U10', 'Academia de Studii', 'Bucuresti');


-----------------------------------------------------------
-- 2. DEPARTMENTS (10 records - FK la Universities)
-----------------------------------------------------------
INSERT INTO department (id, name, university_id) VALUES
                                                      ('D1', 'Informatica si Calculatoare', 'U1'),
                                                      ('D2', 'Automatica si Sisteme', 'U1'),
                                                      ('D3', 'Constructii Civile', 'U1'),
                                                      ('D4', 'Inginerie Electrica', 'U2'),
                                                      ('D5', 'Matematica', 'U2'),
                                                      ('D6', 'Fizica', 'U3'),
                                                      ('D7', 'Chimie Industriala', 'U3'),
                                                      ('D8', 'Medicina Generala', 'U6'),
                                                      ('D9', 'Stiinte Economice', 'U5'),
                                                      ('D10', 'Drept Public', 'U4');


-----------------------------------------------------------
-- 3. ROOMS (10 records - FK la Universities)
-----------------------------------------------------------
INSERT INTO room (id, capacity, number, name, university_id) VALUES
                                                                  ('R1', 200.0, 'A101', 'Amfiteatru Principal', 'U1'),
                                                                  ('R2', 40.0, 'C203', 'Laborator Retele', 'U1'),
                                                                  ('R3', 30.0, 'C204', 'Seminar 1', 'U1'),
                                                                  ('R4', 150.0, 'B110', 'Amfiteatru Mic', 'U2'),
                                                                  ('R5', 25.0, 'D301', 'Laborator Chimie', 'U3'),
                                                                  ('R6', 50.0, 'L10', 'Sala de Clase', 'U3'),
                                                                  ('R7', 80.0, 'S34', 'Sala de Seminar', 'U5'),
                                                                  ('R8', 20.0, 'M44', 'Lab Fizica', 'U6'),
                                                                  ('R9', 10.0, 'K01', 'Sala de Proiect', 'U7'),
                                                                  ('R10', 60.0, 'J202', 'Amfiteatru Drept', 'U4');


-----------------------------------------------------------
-- 4. STUDENTS (10 records)
-----------------------------------------------------------
INSERT INTO student (id, name) VALUES
                                    ('S1', 'Popescu Andrei'),
                                    ('S2', 'Ionescu Maria'),
                                    ('S3', 'Georgescu Mihai'),
                                    ('S4', 'Vasilescu Ana'),
                                    ('S5', 'Stan Daniel'),
                                    ('S6', 'Dinu Elena'),
                                    ('S7', 'Radu Vlad'),
                                    ('S8', 'Ciobanu Livia'),
                                    ('S9', 'Munteanu Sorin'),
                                    ('S10', 'Petrescu Ioana');


-----------------------------------------------------------
-- 5. STAFF (10 records: 5 Teachers + 5 Assistants)
-- Inserăm în tabela de bază 'staff' și în tabelele subclase 'teacher'/'assistant' (JOINED strategy)
-----------------------------------------------------------

-- 5a. Tabela de bază STAFF
INSERT INTO staff (id, name, dtype) VALUES
                                        ('T1', 'Ionescu Cristian', 'Teacher'),
                                        ('T2', 'Popa Maria', 'Teacher'),
                                        ('T3', 'Marinescu Alex', 'Teacher'),
                                        ('T4', 'Preda Sorin', 'Teacher'),
                                        ('T5', 'Vasilica Elena', 'Teacher'),
                                        ('A1', 'Mihai Dan', 'Assistant'),
                                        ('A2', 'Alexandru Paul', 'Assistant'),
                                        ('A3', 'Ciobanu Loredana', 'Assistant'),
                                        ('A4', 'Ene Filip', 'Assistant'),
                                        ('A5', 'Zamfir Ana', 'Assistant');

-- 5b. Subclasa TEACHER (FK la staff și departments)
INSERT INTO teacher (id, title, department_id) VALUES
                                                   ('T1', 'Prof. Dr.', 'D1'),
                                                   ('T2', 'Lector Dr.', 'D2'),
                                                   ('T3', 'Asistent Dr.', 'D1'),
                                                   ('T4', 'Prof. Emerit', 'D5'),
                                                   ('T5', 'Lector', 'D4');

-- 5c. Subclasa ASSISTANT (FK la staff)
INSERT INTO assistant (id, role) VALUES
                                     ('A1', 'TA'),
                                     ('A2', 'LAB'),
                                     ('A3', 'GRADER'),
                                     ('A4', 'TA'),
                                     ('A5', 'LAB');


-----------------------------------------------------------
-- 6. COURSES (10 records - FK la Department, Room)
-----------------------------------------------------------
INSERT INTO course (id, title, credits, duration, department_id, room_id) VALUES
                                                                               ('C1', 'Programare Orientata Obiect', 6, 2.5, 'D1', 'R2'),
                                                                               ('C2', 'Algoritmi si Structuri', 6, 2.5, 'D1', 'R1'),
                                                                               ('C3', 'Baze de Date', 5, 2.0, 'D2', 'R3'),
                                                                               ('C4', 'Matematica I', 5, 3.0, 'D5', 'R4'),
                                                                               ('C5', 'Fizica Aplicata', 4, 1.5, 'D6', 'R8'),
                                                                               ('C6', 'Electrotehnica', 5, 2.0, 'D4', 'R4'),
                                                                               ('C7', 'Mecanica Fina', 4, 2.0, 'D3', 'R9'),
                                                                               ('C8', 'Medicina Interna', 7, 3.0, 'D8', 'R1'),
                                                                               ('C9', 'Drept Civil', 6, 2.5, 'D10', 'R10'),
                                                                               ('C10', 'Microeconomie', 5, 2.0, 'D9', 'R7');


-----------------------------------------------------------
-- 7. ENROLLMENTS (10 records - FK la Student, Course)
-----------------------------------------------------------
-- Grades (A, B, C, D, F, NA)
INSERT INTO enrollment (id, student_id, course_id, grade) VALUES
                                                               ('E1', 'S1', 'C1', 'A'),
                                                               ('E2', 'S2', 'C2', 'B'),
                                                               ('E3', 'S3', 'C3', 'C'),
                                                               ('E4', 'S4', 'C4', 'A'),
                                                               ('E5', 'S5', 'C5', 'B'),
                                                               ('E6', 'S6', 'C6', 'A'),
                                                               ('E7', 'S7', 'C7', 'C'),
                                                               ('E8', 'S8', 'C8', 'A'),
                                                               ('E9', 'S9', 'C9', 'B'),
                                                               ('E10', 'S10', 'C10', 'A');


-----------------------------------------------------------
-- 8. TEACHING_ASSIGNMENTS (10 records - FK la Course, Staff)
-----------------------------------------------------------
-- Staff (T1-T5 sunt Teachers, A1-A5 sunt Assistants)
-- ManagingRole (LAB, SEMINARY, COURSE)
INSERT INTO teaching_assignment (id, course_id, staff_id, managing) VALUES
                                                                         ('TA1', 'C1', 'T1', 'COURSE'),
                                                                         ('TA2', 'C2', 'T2', 'COURSE'),
                                                                         ('TA3', 'C3', 'A1', 'LAB'),
                                                                         ('TA4', 'C4', 'T4', 'SEMINARY'),
                                                                         ('TA5', 'C5', 'A3', 'LAB'),
                                                                         ('TA6', 'C6', 'T5', 'COURSE'),
                                                                         ('TA7', 'C7', 'A4', 'LAB'),
                                                                         ('TA8', 'C8', 'T3', 'SEMINARY'),
                                                                         ('TA9', 'C9', 'A5', 'LAB'),
                                                                         ('TA10', 'C10', 'T4', 'COURSE');

-- Reactivarea verificărilor FK
SET FOREIGN_KEY_CHECKS = 1;