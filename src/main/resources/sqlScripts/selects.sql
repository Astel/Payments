--select user's credit cards
SELECT
  "u"."first_name",
  "u"."last_name",
  "c"."id"         AS "card_number",
  "c"."expiration",
  "b"."id"         AS "account number",
  "b"."owner_name" AS "account owner",
  "b"."balance",
  "b"."is_blocked"
FROM "user" "u"
  INNER JOIN "credit_card" "c" ON "u"."id" = "user_id"
  INNER JOIN "bank_account" "b" ON "account_id" = "b"."id"
--WHERE "u"."id" = 2
WHERE "u"."email" = 'magan@gmail.com';

--select user's accounts
SELECT
  "u"."first_name",
  "u"."last_name",
  "b"."id"         AS "account number",
  "b"."owner_name" AS "account owner",
  "b"."balance",
  "b"."is_blocked"
FROM "user" "u"
  INNER JOIN "credit_card" "c" ON "u"."id" = "user_id"
  INNER JOIN "bank_account" "b" ON "account_id" = "b"."id"
--WHERE "u"."id" = 2
WHERE "u"."email" = 'magan@gmail.com'
GROUP BY
  "u"."first_name",
  "u"."last_name",
  "b"."id",
  "b"."owner_name",
  "b"."balance",
  "b"."is_blocked";

--select users orders
SELECT
  "u"."first_name",
  "u"."last_name",
  "c"."id" AS "card_number",
  "o"."date",
  "o"."time",
  "o"."value",
  "o"."description",
  "b"."balance"
FROM "user" "u"
  INNER JOIN "credit_card" "c" ON "u"."id" = "user_id"
  INNER JOIN "bank_account" "b" ON "c"."account_id" = "b"."id"
  INNER JOIN "order" "o" ON "o"."account_id" = "b"."id"
--WHERE "u"."id" = 2
WHERE "u"."email" = 'magan@gmail.com'