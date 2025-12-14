-- SCRIPT DE INIȚIALIZARE A BAZEI DE DATE (data.sql)
-- FIXED: Removed decimals from 'duration' and 'capacity' to match Integer columns.

SET FOREIGN_KEY_CHECKS = 0;

-----------------------------------------------------------
-- 1. UNIVERSITIES
-----------------------------------------------------------
INSERT INTO university (id, name, city) VALUES
                                            ('00001U', 'Politehnica Timisoara', 'Timisoara'),
                                            ('00002U', 'Universitatea Bucuresti', 'Bucuresti'),
                                            ('00003U', 'Universitatea Babes', 'Cluj'),
                                            ('00004U', 'Univ. Al. I. Cuza', 'Iasi'),
                                            ('00005U', 'Univ. Vest Timisoara', 'Timisoara'),
                                            ('00006U', 'Univ. Medicina Cluj', 'Cluj'),
                                            ('00007U', 'Univ. Arhitectura', 'Bucuresti'),
                                            ('00008U', 'Univ. Arte', 'Iasi'),
                                            ('00009U', 'Univ. Craiova', 'Craiova'),
                                            ('00010U', 'Academia de Studii', 'Bucuresti');

-----------------------------------------------------------
-- 2. DEPARTMENTS
-----------------------------------------------------------
INSERT INTO department (id, name, university_id) VALUES
                                                     ('00001D', 'Informatica si Calculatoare', '00001U'),
                                                     ('00002D', 'Automatica si Sisteme', '00001U'),
                                                     ('00003D', 'Constructii Civile', '00001U'),
                                                     ('00004D', 'Inginerie Electrica', '00002U'),
                                                     ('00005D', 'Matematica', '00002U'),
                                                     ('00006D', 'Fizica', '00003U'),
                                                     ('00007D', 'Chimie Industriala', '00004U'),
                                                     ('00008D', 'Medicina Generala', '00006U'),
                                                     ('00009D', 'Stiinte Economice', '00005U'),
                                                     ('00010D', 'Drept Public', '00004U');

-----------------------------------------------------------
-- 3. ROOMS
-- CHANGE: Removed '.0' from capacity (e.g., 200.0 -> 200)
-----------------------------------------------------------
INSERT INTO room (id, capacity, number, name, university_id) VALUES
                                                                 ('00001R', 200, 'A101', 'Amfiteatru Principal', '00001U'),
                                                                 ('00002R', 40, 'C203', 'Laborator Retele', '00001U'),
                                                                 ('00003R', 30, 'C204', 'Seminar 1', '00001U'),
                                                                 ('00004R', 150, 'B110', 'Amfiteatru Mic', '00002U'),
                                                                 ('00005R', 25, 'D301', 'Laborator Chimie', '00003U'),
                                                                 ('00006R', 50, 'L10', 'Sala de Clase', '00003U'),
                                                                 ('00007R', 80, 'S34', 'Sala de Seminar', '00005U'),
                                                                 ('00008R', 20, 'M44', 'Lab Fizica', '00006U'),
                                                                 ('00009R', 10, 'K01', 'Sala de Proiect', '00007U'),
                                                                 ('00010R', 60, 'J202', 'Amfiteatru Drept', '00004U');

-----------------------------------------------------------
-- 4. STUDENTS
-----------------------------------------------------------
INSERT INTO student (id, name) VALUES
                                   ('00001S', 'Popescu Andrei'),
                                   ('00002S', 'Ionescu Maria'),
                                   ('00003S', 'Georgescu Mihai'),
                                   ('00004S', 'Vasilescu Ana'),
                                   ('00005S', 'Stan Daniel'),
                                   ('00006S', 'Dinu Elena'),
                                   ('00007S', 'Radu Vlad'),
                                   ('00008S', 'Ciobanu Livia'),
                                   ('00009S', 'Munteanu Sorin'),
                                   ('00010S', 'Petrescu Ioana');

-----------------------------------------------------------
-- 5. STAFF
-----------------------------------------------------------
INSERT INTO staff (id, name, dtype) VALUES
                                        ('00001T', 'Ionescu Cristian', 'Teacher'),
                                        ('00002T', 'Popa Maria', 'Teacher'),
                                        ('00003T', 'Marinescu Alex', 'Teacher'),
                                        ('00004T', 'Preda Sorin', 'Teacher'),
                                        ('00005T', 'Vasilica Elena', 'Teacher'),
                                        ('00001A', 'Mihai Dan', 'Assistant'),
                                        ('00002A', 'Alexandru Paul', 'Assistant'),
                                        ('00003A', 'Ciobanu Loredana', 'Assistant'),
                                        ('00004A', 'Ene Filip', 'Assistant'),
                                        ('00005A', 'Zamfir Ana', 'Assistant');

INSERT INTO teacher (id, title, department_id) VALUES
                                                   ('00001T', 'Prof. Dr.', '00001D'),
                                                   ('00002T', 'Lector Dr.', '00002D'),
                                                   ('00003T', 'Asistent Dr.', '00001D'),
                                                   ('00004T', 'Prof. Emerit', '00005D'),
                                                   ('00005T', 'Lector', '00004D');

INSERT INTO assistant (id, role) VALUES
                                     ('00001A', 'TA'),
                                     ('00002A', 'LAB'),
                                     ('00003A', 'GRADER'),
                                     ('00004A', 'TA'),
                                     ('00005A', 'LAB');

-----------------------------------------------------------
-- 6. COURSES
-- CHANGE: Removed decimals from duration (e.g., 2.5 -> 3)
-----------------------------------------------------------
INSERT INTO course (id, title, credits, duration, department_id, room_id) VALUES
                                                                              ('00001C', 'Programare Orientata Obiect', 6, 3, '00001D', '00002R'),
                                                                              ('00002C', 'Algoritmi si Structuri', 6, 3, '00001D', '00001R'),
                                                                              ('00003C', 'Baze de Date', 5, 2, '00002D', '00003R'),
                                                                              ('00004C', 'Matematica I', 5, 3, '00005D', '00004R'),
                                                                              ('00005C', 'Fizica Aplicata', 4, 2, '00006D', '00008R'),
                                                                              ('00006C', 'Electrotehnica', 5, 2, '00004D', '00004R'),
                                                                              ('00007C', 'Mecanica Fina', 4, 2, '00003D', '00009R'),
                                                                              ('00008C', 'Medicina Interna', 7, 3, '00008D', '00001R'),
                                                                              ('00009C', 'Drept Civil', 6, 3, '00010D', '00010R'),
                                                                              ('00010C', 'Microeconomie', 5, 2, '00009D', '00007R');

-----------------------------------------------------------
-- 7. ENROLLMENTS
-----------------------------------------------------------
INSERT INTO enrollment (id, student_id, course_id, grade) VALUES
                                                              ('00001E', '00001S', '00001C', 'A'),
                                                              ('00002E', '00002S', '00002C', 'B'),
                                                              ('00003E', '00003S', '00003C', 'C'),
                                                              ('00004E', '00004S', '00004C', 'A'),
                                                              ('00005E', '00005S', '00005C', 'B'),
                                                              ('00006E', '00006S', '00006C', 'A'),
                                                              ('00007E', '00007S', '00007C', 'C'),
                                                              ('00008E', '00008S', '00008C', 'A'),
                                                              ('00009E', '00009S', '00009C', 'B'),
                                                              ('00010E', '00010S', '00010C', 'A');

-----------------------------------------------------------
-- 8. TEACHING_ASSIGNMENTS
-----------------------------------------------------------
INSERT INTO teaching_assignment (id, course_id, staff_id, managing) VALUES
                                                                        ('00001TA', '00001C', '00001T', 'COURSE'),
                                                                        ('00002TA', '00002C', '00002T', 'COURSE'),
                                                                        ('00003TA', '00003C', '00001A', 'LAB'),
                                                                        ('00004TA', '00004C', '00004T', 'SEMINARY'),
                                                                        ('00005TA', '00005C', '00003A', 'LAB'),
                                                                        ('00006TA', '00006C', '00005T', 'COURSE'),
                                                                        ('00007TA', '00007C', '00004A', 'LAB'),
                                                                        ('00008TA', '00008C', '00003T', 'SEMINARY'),
                                                                        ('00009TA', '00009C', '00005A', 'LAB'),
                                                                        ('00010TA', '00010C', '00004T', 'COURSE');

SET FOREIGN_KEY_CHECKS = 1;