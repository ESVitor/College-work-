CREATE TABLE insurance.car (
id_car INT NOT NULL AUTO_INCREMENT,
model VARCHAR(15),
year DATE,
engine VARCHAR(3),
registration VARCHAR(10),
maker VARCHAR(45),
id_company INT NOT NULL,
id_policy INT NOT NULL,
PRIMARY KEY (id_car),
FOREIGN KEY (id_company)
REFERENCES insurance.company (id_company),
FOREIGN KEY (id_policy)
REFERENCES insurance.policy (id_policy),
)