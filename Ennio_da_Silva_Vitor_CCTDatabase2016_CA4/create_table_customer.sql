CREATE TABLE insurance.customer (
  id_customer INT NOT NULL AUTO INCREMENT,
  f_name VARCHAR(20),
  surname VARCHAR(20),
  dob VARCHAR(10),
  address VARCHAR(50),
  phone_number VARCHAR(50),
  PRIMARY KEY (id_customer)
)
