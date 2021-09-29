INSERT INTO public.user_status
(user_status_descr)
VALUES('PENDING'), ('ENABLED'), ('DISABLED');

INSERT INTO public.roles
(role_descr)
VALUES('ADMIN'), ('GENERAL USER');



insert into car (capacity,make,model,transmission) 
values (4,'Ford','Focus','Automatic'),
(4,'Ford','Focus','Automatic'),
(4,'Ford','Escape','Automatic'),
(4,'Ford','Edge','Automatic');

insert into facility (address, city, name, state, zip) 
values ('111 Place Boulevard','Narnia','The Best Hospital','Missouri','90888'), 
('123 City Avenue','Radcliffe','The Best Physical Therapist','Kentucky','40211'), 
('900 Brick Boulevard','Austin','The Best Dentist','Texas','78777'), 
('55 Stone Road','Austin','The Best Allergist','Texas','78111');

insert into restaurant_type (descr) values ('American'),('Pizzeria'),('Chinese'),('Hispanic'),('Texmex'),('Breakfeast'),('Pasta'),('Steakhouse'),('Sushi'),('ramen'),('Pho'),('Fast Food');

insert into restaurant (address,city,name,state,zip,restaurant_type_id) values ('1450 South Brook Street','Louisville','Burger Boy','Kentucky','40208',1),
('358 River Street','Hackensack','White Manna','New Jersey','07601',1),
('655 Westwood Avenue','Westwood','China Pavillion','New Jersey','07675',3),
('655 Westwood Avenue','Emerson','Laurel Chinese Restaurant','New Jersey','07675',3);

insert
	into
	transaction_type (transaction_type_descr)
values ('Rent'),
('Gas'),
('Electric'),
('Cable'),
('Internet'),
('Phones'),
('Insurnace'),
('Mortgage'),
('Grcoeries'),
('Restaurant'),
('School Supplies'),
('Social'),
('Vacation'),
('Oil Change'),
('Brakes'),
('Bumper'),
('Car Detail'),
('General Maintanance'),
('Collision Maintenance'),
('Medical Copay'),
('Prescription Payment'),
('Amazon');


insert into utility_type (utility_type_descr) values ('Rent'), ('Gas'), ('Electric'), ('Cable'), ('Internet'), ('Phones'), ('Insurance'), ('Mortgage');

INSERT INTO public.utility
(due_date, "name", phone, url, utility_type_id)
VALUES('15th of the month', 'PSEG', '201-111-1111', 'www.pseg.com', 3);


INSERT INTO public.exercise
(exercise_name, reps, sets, weight, exercise_type_id, user_id, "date")
VALUES('Static Bicep Curls', 1, 1, 90, 1, 1, '03/01/2021');
