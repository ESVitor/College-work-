CREATE TABLE insurance.customer_car (
id_customer INT NOT NULL,
id_car INT NOT NULL,

FOREIGN KEY (id_customer),
REFERENCES insurance.customer (id_customer),

FOREIGN KEY (id_car),
REFERENCES insurance.car (id_car)
)