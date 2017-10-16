CREATE TABLE insurance.customer_indebt (
id_customer INT NOT NULL,
id_bills_not_paid INT NOT NULL,
  
FOREIGN KEY (id_customer),
REFERENCES insurance.customer (id_customer),
    
FOREIGN KEY (id_bills_not_paid),
REFERENCES insurance.bills_not_paid (id_bills_not_paid)
)    