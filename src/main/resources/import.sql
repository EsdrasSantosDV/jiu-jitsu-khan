-- Inserir uma classe com ID 1
INSERT INTO class_entity (id, instructor, class_name)
VALUES (1, 'Mestre Moises', 'Técnicas de Finalização');

-- Inserir alunos com IDs 1, 2 e 3
INSERT INTO student_entity (id, name, belt_rank, degree)
VALUES (1, 'Esdras Santos de Oliveira', 'WHITE', 1),
       (2, 'Tiago Coelho', 'WHITE', 1),
       (3, 'Gilberto Gabriel', 'WHITE', 1);

-- Inserir 10 sessões de aula vinculadas à classe com ID 1
INSERT INTO classroom_entity (id, jiu_jitsu_class_id, start_time)
VALUES (1, 1, '2024-10-01 15:00:00'),
       (2, 1, '2024-10-03 10:00:00'),
       (3, 1, '2024-10-05 14:00:00'),
       (4, 1, '2024-10-07 16:00:00'),
       (5, 1, '2024-10-09 11:00:00'),
       (6, 1, '2024-10-11 18:00:00'),
       (7, 1, '2024-10-13 09:00:00'),
       (8, 1, '2024-10-15 17:00:00'),
       (9, 1, '2024-10-17 14:00:00'),
       (10, 1, '2024-10-19 08:00:00');

-- Inserir presenças para as 10 aulas para os 3 alunos
INSERT INTO presence (id, student_id, classroom_id, confirmed)
VALUES
-- Presenças para a primeira sessão de aula
(1, 1, 1, TRUE),   -- Esdras presente
(2, 2, 1, TRUE),   -- Tiago presente
(3, 3, 1, FALSE),  -- Gilberto ausente

-- Presenças para a segunda sessão de aula
(4, 1, 2, TRUE),   -- Esdras presente
(5, 2, 2, FALSE),  -- Tiago ausente
(6, 3, 2, TRUE),   -- Gilberto presente

-- Presenças para a terceira sessão de aula
(7, 1, 3, FALSE),  -- Esdras ausente
(8, 2, 3, TRUE),   -- Tiago presente
(9, 3, 3, FALSE),  -- Gilberto ausente

-- Presenças para a quarta sessão de aula
(10, 1, 4, TRUE),  -- Esdras presente
(11, 2, 4, TRUE),  -- Tiago presente
(12, 3, 4, FALSE), -- Gilberto ausente

-- Presenças para a quinta sessão de aula
(13, 1, 5, FALSE), -- Esdras ausente
(14, 2, 5, TRUE),  -- Tiago presente
(15, 3, 5, TRUE),  -- Gilberto presente

-- Presenças para a sexta sessão de aula
(16, 1, 6, TRUE),  -- Esdras presente
(17, 2, 6, FALSE), -- Tiago ausente
(18, 3, 6, TRUE),  -- Gilberto presente

-- Presenças para a sétima sessão de aula
(19, 1, 7, TRUE),  -- Esdras presente
(20, 2, 7, TRUE),  -- Tiago presente
(21, 3, 7, FALSE), -- Gilberto ausente

-- Presenças para a oitava sessão de aula
(22, 1, 8, FALSE), -- Esdras ausente
(23, 2, 8, TRUE),  -- Tiago presente
(24, 3, 8, TRUE),  -- Gilberto presente

-- Presenças para a nona sessão de aula
(25, 1, 9, TRUE),  -- Esdras presente
(26, 2, 9, FALSE), -- Tiago ausente
(27, 3, 9, TRUE),  -- Gilberto presente

-- Presenças para a décima sessão de aula
(28, 1, 10, TRUE), -- Esdras presente
(29, 2, 10, TRUE); -- Tiago presente


