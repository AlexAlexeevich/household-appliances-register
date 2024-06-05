INSERT INTO household_appliance
(id, product_name, country, company, is_order_online, is_possible_installments)
VALUES (111111, 'TV', 'Russia', 'Электроника', true, true),
       (111112, 'TV', 'China', 'Huawei', true, true),
       (111113, 'TV', 'Japan', 'Sony', true, true),
       (222222, 'FRIDGE', 'Belarus', 'МЗХ', true, true),
       (222223, 'FRIDGE', 'China', 'Haier', true, true),
       (222224, 'FRIDGE', 'Russia', 'СЗХ', true, true),
       (333333, 'HOOVER', 'Belarus', 'Horizont', true, true),
       (333334, 'HOOVER', 'China', 'Dreame', true, true),
       (333335, 'HOOVER', 'Germany', 'Bosch', true, true),
       (444444, 'SMARTPHONE', 'USA', 'Apple', true, true),
       (444445, 'SMARTPHONE', 'China', 'Xiaomi', true, true),
       (444446, 'SMARTPHONE', 'Japan', 'Samsung', true, true),
       (555555, 'COMPUTER', 'USA', 'Apple', true, true),
       (555556, 'COMPUTER', 'China', 'Xiaomi', true, true),
       (555557, 'COMPUTER', 'Japan', 'Samsung', true, true);

INSERT INTO tv
(id, household_appliance_id, name, serial_number, color, size, price, is_available, category, technology)
VALUES (nextval('model_sequence_name'), 111111, 'Витязь', 'E334IA9KW98', 'black', '42', 35000.00, true, 'test-category', 'OLED'),
       (nextval('model_sequence_name'), 111111, 'Горизонт', '5674I0GDH98', 'grey', '21', 22000.00, false, 'category', 'LED'),
       (nextval('model_sequence_name'), 111112, 'Huawei Pura 70', 'Y65FN9KM3DE', 'white', '42', 40000.00, true, 'test-category', 'OLED'),
       (nextval('model_sequence_name'), 111112, 'Huawei SUPER 24', 'F94KF5ND6H3ND', 'grey', '36', 29000.00, true, 'category', 'LED'),
       (nextval('model_sequence_name'), 111113, 'Sony HHD 55', 'JD84JFD65MVL', 'black', '42', 55000.00, true, 'test-category', 'OLED'),
       (nextval('model_sequence_name'), 111113, 'Sony Future', 'FGM48FLD0SJ3', 'black', '36', 49000.00, true, 'category', 'LED');

INSERT INTO fridge
(id, household_appliance_id, name, serial_number, color, size, price, is_available, door_fridge_quantity, compressor_type)
VALUES (nextval('model_sequence_name'), 222222, 'Horizont RT5', 'GT5HFV7KB4', 'white', '50', 10000.00, true, '2', 'инверторный'),
       (nextval('model_sequence_name'), 222222, 'Horizont-909', 'W34F8KDF545', 'grey', '50', 9000.00, true, '2', 'поршневой'),
       (nextval('model_sequence_name'), 222223, 'Haier MT6', '56GFD7H7RHX', 'white', '50', 7500.00, true, '2', 'инверторный'),
       (nextval('model_sequence_name'), 222223, 'Haier T15', 'X4S4676JG7', 'white', '50', 9000.00, true, '2', 'инверторный'),
       (nextval('model_sequence_name'), 222224, 'Бирюса', '4FBG76DG5FHY', 'grey', '50', 20000.00, false, '2', 'инверторный'),
       (nextval('model_sequence_name'), 222224, 'Саратов', '4FR7GT8H0FFY', 'white', '50', 25000.00, false, '2', 'поршневой');

INSERT INTO hoover
(id, household_appliance_id, name, serial_number, color, size, price, is_available, dust_collector_volume, mode_quantity)
VALUES (nextval('model_sequence_name'), 333333, 'Horizont RT5', 'GT5HFV7KB4', 'black', '50', 10000.00, true, '2.6', '4'),
       (nextval('model_sequence_name'), 333333, 'Horizont-909', 'W34F8KDF545', 'grey', '50', 9000.00, true, '2.5', '3'),
       (nextval('model_sequence_name'), 333334, 'Dreame F9 Pro', '56GFD7H7RHX', 'black', '50', 7500.00, true, '2.0', '6'),
       (nextval('model_sequence_name'), 333334, 'Dreame T15', 'X4S4676JG7', 'blue', '50', 9000.00, true, '1.5', '4'),
       (nextval('model_sequence_name'), 333335, 'Bosch-15', '4FBG76DG5FHY', 'grey', '50', 20000.00, false, '3.0', '5'),
       (nextval('model_sequence_name'), 333335, 'Bosch-25', '4FR7GT8H0FFY', 'brown', '50', 25000.00, false, '2.5', '4');

INSERT INTO smartphone
(id, household_appliance_id, name, serial_number, color, size, price, is_available, memory, camera_quantity)
VALUES (nextval('model_sequence_name'), 444444, 'iPhone 14 Pro', 'H9GTY865FV', 'black', '5', 800000.00, true, '128', '2'),
       (nextval('model_sequence_name'), 444444, 'iPhone 15 Pro', 'J0YTF6FTY0U', 'grey', '5.6', 90000.00, true, '256', '2'),
       (nextval('model_sequence_name'), 444445, 'Xiaomi 13T PRO ', 'HG5RFF8HU8G', 'black', '7', 75000.00, true, '256', '2'),
       (nextval('model_sequence_name'), 444445, 'Xiaomi 14 PRO', 'D3WS9M67TG', 'white', '6.5', 80000.00, true, '256', '2'),
       (nextval('model_sequence_name'), 444446, 'Samsung Galaxy S24', 'JR84ND673JD9', 'white', '7', 60000.00, false, '256', '5'),
       (nextval('model_sequence_name'), 444446, 'Samsung Galaxy S10e', 'CFM30RJE45U3', 'pink', '6.5', 55000.00, false, '256', '4');

INSERT INTO computer
(id, household_appliance_id, name, serial_number, color, size, price, is_available, category, processor_type)
VALUES (nextval('model_sequence_name'), 555555, 'MacBook AIR M2', 'FT5YN5YT76EH4W', 'silver', '14', 140000.00, true, null, 'Apple M1 Max'),
       (nextval('model_sequence_name'), 555555, 'MacBook Pro 14', '5GDF4H66DDT', 'grey', '14', 190000.00, true, null, 'Apple M1 Pro'),
       (nextval('model_sequence_name'), 555556, 'Xiaomi RedmeBook PRO 16', '34DF5GSR78', 'black', '14', 175000.00, true, null, '1240P'),
       (nextval('model_sequence_name'), 555556, 'Xiaomi RedmeBook PRO 15', '54HDF5G87IJ5FG', 'silver', '14', 80000.00, true, null, '1240P'),
       (nextval('model_sequence_name'), 555557, 'Samsung GalaxyBook 4', 'GF45HF5DH78', 'silver', '14', 160000.00, true, null, 'Intel Core 7 150U'),
       (nextval('model_sequence_name'), 555557, 'Samsung GalaxyBook 4 PRO', 'F5DYU5JN65U5JFD', 'silver', '14', 255000.00, true, null, 'Intel Core 7 150U');