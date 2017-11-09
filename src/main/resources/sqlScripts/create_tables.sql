--create table user
CREATE TABLE "public"."user"
(
  "id"         SERIAL PRIMARY KEY     NOT NULL,
  "first_name" TEXT                   NOT NULL,
  "last_name"  TEXT                   NOT NULL,
  "email"      TEXT                   NOT NULL,
  "password"   TEXT                   NOT NULL,
  "phone"      TEXT                   NOT NULL,
  "is_admin"   BOOLEAN DEFAULT FALSE  NOT NULL
);
CREATE UNIQUE INDEX "user_id_uindex"
  ON "public"."user" ("id");
CREATE UNIQUE INDEX "user_email_uindex"
  ON "public"."user" ("email");

--create table bank_account
CREATE TABLE "public"."bank_account"
(
  "id"         SERIAL PRIMARY KEY     NOT NULL,
  "owner_name" TEXT                   NOT NULL,
  "balance"    INTEGER DEFAULT 0      NOT NULL,
  "is_blocked" BOOLEAN DEFAULT FALSE  NOT NULL
);
CREATE UNIQUE INDEX "bank_account_id_uindex"
  ON "public"."bank_account" ("id");

--create table credit_card
CREATE TABLE "public"."credit_card"
(
  "id"              SERIAL PRIMARY KEY NOT NULL,
  "cardholder_name" TEXT               NOT NULL,
  "expiration"      DATE               NOT NULL,
  "security_code"   INTEGER            NOT NULL,
  "user_id"         INTEGER            NOT NULL,
  "account_id"      INTEGER            NOT NULL,
  CONSTRAINT "credit_card_user_id_fk" FOREIGN KEY ("user_id") REFERENCES "user" ("id")
  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT "credit_card_bank_account_id_fk" FOREIGN KEY ("account_id")
  REFERENCES "bank_account" ("id") ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE UNIQUE INDEX "credit_card_id_uindex"
  ON "public"."credit_card" ("id");

--create table order
CREATE TABLE "public"."order"
(
  "id"          SERIAL PRIMARY KEY NOT NULL,
  "date"        DATE               NOT NULL,
  "time"        TIME               NOT NULL,
  "value"       INTEGER            NOT NULL,
  "description" TEXT               NOT NULL,
  "account_id"  INTEGER            NOT NULL,
  CONSTRAINT "order_bank_account_id_fk" FOREIGN KEY ("account_id")
  REFERENCES "bank_account" ("id")
);
CREATE UNIQUE INDEX "order_id_uindex"
  ON "public"."order" ("id");