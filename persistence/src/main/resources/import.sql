INSERT INTO account (id, creation_date_time, deletion_date_time, logically_deleted, amount, color, currency, name, person_id, type) VALUES ('ACC_0000001', '2020-10-12T12:00:00.000Z', null, false, 12.53, '#FFFFFF', 'USD', 'Dollar Account', 'USR_0000001', 'Card'), ('ACC_0000002', '2020-10-12T12:00:00.000Z', null, false, 56.00, '#FFFFFF', 'UAH', 'Hryvnia Account', 'USR_0000001', 'Card'), ('ACC_0000003', '2020-10-12T12:00:00.000Z', '2021-10-12T12:00:00.000Z', true, 33.75, '#FFFFFF', 'EUR', 'Euro Account', 'USR_0000001', 'Card');

-------------------------------------------------------------------------------------------------

INSERT INTO category (id, creation_date_time, deletion_date_time, logically_deleted, category_level, color, name, parent_category_id, person_id) VALUES ('CTG_0000001', '2020-10-12T12:00:00.000Z', null, false, 1, '#FFFFFF', 'Groceries', null, 'COMMON'), ('CTG_0000002', '2020-10-12T12:00:00.000Z', null, false, 2, '#FFFFFF', 'Fast food', 'CTG_0000001', 'COMMON'), ('CTG_0000003', '2020-10-12T12:00:00.000Z', null, false, 1, '#FFFFFF', 'Other', null, 'COMMON');

-------------------------------------------------------------------------------------------------

INSERT INTO record (id, creation_date_time, deletion_date_time, logically_deleted, amount, currency, note, payee, target_amount, type, account_id, category_id) VALUES ('RCD_0000001', '2020-10-12T12:00:00.000Z', null, false, 1.00, 'USD', 'For candy', 'Silpo', 36.56, 'Payment', 'ACC_0000002', 'CTG_0000002'), ('RCD_0000002', '2020-10-12T12:00:00.000Z', null, false, -2.00, 'USD', 'For ice-cream', 'ATB', null, 'Payment', 'ACC_0000001', 'CTG_0000002'), ('RCD_0000003', '2020-10-12T12:00:00.000Z', null, false, -10.00, 'UAH', 'Lending', 'Verleger, Daniela', null, 'Transfer', 'ACC_0000002', 'CTG_0000003');
