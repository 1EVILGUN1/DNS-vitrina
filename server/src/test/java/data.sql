INSERT INTO users (id,first_name,last_name,password)
VALUES (1,
        'Ирина',
        'Поливаева',
        '123456'
        );
INSERT INTO users (id,first_name,last_name,password)
VALUES (2,
        'Яков',
        'Голотин',
        '123456'
       );
INSERT INTO users (id,first_name,last_name,password)
VALUES (3,
        'Сергей',
        'Горячих',
        '123456'
       );
INSERT INTO users (id,first_name,last_name,password)
VALUES (4,
        'Малеева',
        'Виолетта',
        '123456'
       );
INSERT INTO vitrins (id, y, x, width, height, name) VALUES
                                                        (1, 23, 2, 23, 458, 'Телевизоры'),
                                                        (2, 0, 30, 450, 23, 'Телефоны'),
                                                        (3, 75, 463, 23, 375, 'Наушники справа'),
                                                        (4, 68, 113, 38, 150, 'Телевизоры антенны'),
                                                        (5, 68, 225, 38, 150, 'Колонки и саунд'),
                                                        (6, 68, 338, 38, 150, 'Кабельки планшеты'),
                                                        (7, 285, 113, 38, 150, 'Телевизоры маленькая снизу'),
                                                        (8, 285, 225, 38, 150, 'Клавиатуры мыши'),
                                                        (9, 285, 338, 38, 150, 'Ноутбуки'),
                                                        (10, 450, 463, 23, 95, 'Флешки'),
                                                        (11, 480, 2, 23, 300, 'Мониторы'),
                                                        (12, 495, 150, 38, 150, 'Роутеры и принтеры'),
                                                        (13, 495, 240, 113, 143, 'Кресла'),
                                                        (14, 705, 293, 38, 150, 'Встройка и сплиты'),
                                                        (15, 705, 150, 38, 150, 'Боллеры, контроллеры'),
                                                        (16, 710, 425, 30, 375, 'КБТ стиралки'),
                                                        (17, 938, 293, 38, 225, 'Бритвы и фены'),
                                                        (20, 938, 150, 38, 225, 'Чайники, пылесосы вертикалки'),
                                                        (21, 780, 2, 23, 263, 'Строительное'),
                                                        (22, 1043, 2, 23, 188, 'Пылесосы стационарные'),
                                                        (23, 1230, 293, 38, 225, 'Тостеры и КБТ газовые плиты'),
                                                        (24, 1230, 150, 38, 225, 'Блендеры и мультиварки'),
                                                        (25, 1223, 425, 30, 525, 'КБТ холодильники'),
                                                        (26, 1538, 293, 38, 150, 'Плиты и гладильные доски'),
                                                        (27, 1538, 150, 38, 150, 'Отпариватели и утюги'),
                                                        (28, 1230, 2, 23, 293, 'Микроволновки'),
                                                        (29, 1523, 2, 90, 23, 'Сушилки для овощей'),
                                                        (30, 1750, 68, 390, 30, 'Встройка духовка и вытяжки');
INSERT INTO users_vitrins(user_id,vitrins_id)
VALUES ( 2,1 );
INSERT INTO users_vitrins(user_id,vitrins_id)
VALUES ( 3,2 );
INSERT INTO users_vitrins(user_id,vitrins_id)
VALUES ( 4,3 );