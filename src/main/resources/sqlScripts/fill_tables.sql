INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (1, 'Maksim', 'Stelmakh', 'stelmakh96@gmail.com', '12345', '+79214229029', TRUE);

--------------------------------
INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (2, 'Maksim', 'Stelmakh', 'stelmakh96@yandex.ru', '12345', '+79214229029', FALSE);

INSERT INTO "public"."bank_account" ("id", "balance", "is_blocked", "owner_name")
VALUES (1, 100000, DEFAULT, 'Maksim Stelmakh');

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Maksim Stelmakh', '2019-11-27', 123, 2, 1);

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Maksim Stelmakh', '2018-10-20', 123, 2, 1);

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Maksim Stelmakh', '2020-05-15', 123, 2, 1);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 5000, 'Sberbank', 1);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-08', '11:00:00', 500, 'Polushka', 1);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'Pizza hut', 1);

--------------------------------
INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (3, 'Ivan', 'Popov', 'popov@gmail.com', '12345', '+7921111111', FALSE);

INSERT INTO "public"."bank_account" ("id", "balance", "is_blocked", "owner_name")
VALUES (2, 50000, DEFAULT, 'Ivan Popov');

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Ivan Popov', '2019-03-11', 123, 3, 2);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'KFC', 2);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'Burger king', 2);

-----------------------------------
INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (4, 'Sergei', 'Kostin', 'kostin@gmail.com', '12345', '+792325262', FALSE);

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Sergei Kostin', '2018-02-21', 123, 4, 1);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'Magnit', 1);

-------------------------------------
INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (5, 'Artem', 'Sidorov', 'sidorov@gmail.com', '12345', '+7921111111', FALSE);

INSERT INTO "public"."bank_account" ("id", "balance", "is_blocked", "owner_name")
VALUES (3, 150000000, TRUE, 'Artem Sidorov');

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Artem Sidorov', '2019-03-11', 123, 5, 3);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'Karusel', 3);

---------------------------------------
INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (6, 'Vasiliy', 'Magan', 'magan@gmail.com', '12345', '+7921111111', FALSE);

INSERT INTO "public"."bank_account" ("id", "balance", "is_blocked", "owner_name")
VALUES (4, 150000000, FALSE, 'Vasiliy Magan');

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Vasiliy Magan', '2019-03-11', 123, 6, 2);

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Vasiliy Magan', '2019-03-11', 123, 6, 4);

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Vasiliy Magan', '2019-03-11', 123, 6, 4);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'Okey', 2);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 335, 'Barber shop', 4);
---------------------------------------
INSERT INTO "public"."user" ("id", "first_name", "last_name", "email", "password", "phone",
                             "is_admin")
VALUES (7, 'Grigoriy', 'Urgant', 'urgant@gmail.com', '12345', '+7921111111', FALSE);

INSERT INTO "public"."bank_account" ("id", "balance", "is_blocked", "owner_name")
VALUES (5, 20000000, FALSE, 'Grigoriy Urgant');

INSERT INTO "public"."bank_account" ("id", "balance", "is_blocked", "owner_name")
VALUES (6, 1500000, FALSE, 'Grigoriy Urgant');

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Grigoriy Urgant', '2019-03-21', 123, 7, 5);

INSERT INTO "public"."credit_card" ("cardholder_name", "expiration", "security_code", "user_id", "account_id")
VALUES ('Grigoriy Urgant', '2020-05-09', 123, 7, 6);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-07', '18:00:00', 5000, 'Opera', 5);

INSERT INTO "public"."order" ("date", "time", "value", "description", "account_id")
VALUES ('2017-11-12', '15:00:00', 500, 'Cinema', 6);