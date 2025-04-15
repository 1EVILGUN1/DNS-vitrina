-- Вставка данных в таблицу users
INSERT INTO users (id, first_name, last_name, password)
SELECT 1, 'Ирина', 'Поливаева', '123456'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 1);

INSERT INTO users (id, first_name, last_name, password)
SELECT 2, 'Сергей', 'Горячих', '123456'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 2);