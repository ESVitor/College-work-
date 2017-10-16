CREATE TABLE insurance.bills_not_paid (

id_bills_not_paid INT NOT NULL AUTO_INCREMENT,
bills_name VARCHAR(50),
bill_description VARCHAR(50),
bill_date DATE,
bill_time TIME,
bills_expired VARCHAR(45),
id_data_analyist INT NOT NULL,

PRIMARY KEY (id_bills_not_paid),

FOREIGN KEY (data_analyist_id_data_analyist),
REFERENCES insurance.data_analyist (id_data_analyist)
)    