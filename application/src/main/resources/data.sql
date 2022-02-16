INSERT INTO `customer` (`customer_id`, `first_name`, `last_name`) VALUES (1, 'John', 'Doe');
INSERT INTO `customer` (`customer_id`, `first_name`, `last_name`) VALUES (2, 'Mark', 'Ruff');
INSERT INTO `customer` (`customer_id`, `first_name`, `last_name`) VALUES (3, 'Steve', 'Musk');

INSERT INTO `bill` (`bill_id`, `type`, `amount`, `version`) VALUES (11, 'ELECTRICITY', 600.0, 0);
INSERT INTO `bill` (`bill_id`, `type`, `amount`, `version`) VALUES (22, 'WATER', 50.0, 0);
INSERT INTO `bill` (`bill_id`, `type`, `amount`, `version`) VALUES (33, 'GAS', 320.0, 0);

INSERT INTO `contract` (`contract_id`) VALUES (100);
INSERT INTO `contract` (`contract_id`) VALUES (200);
INSERT INTO `contract` (`contract_id`) VALUES (300);

UPDATE `contract` SET `customer_customer_id` = 1 WHERE `contract_id` = 100;
UPDATE `contract` SET `customer_customer_id` = 2 WHERE `contract_id` = 200;
UPDATE `contract` SET `customer_customer_id` = 3 WHERE `contract_id` = 300;

UPDATE `bill` SET `contract_contract_id` = 100 WHERE `bill_id` = 11;
UPDATE `bill` SET `contract_contract_id` = 200 WHERE `bill_id` = 22;
UPDATE `bill` SET `contract_contract_id` = 300 WHERE `bill_id` = 33;
