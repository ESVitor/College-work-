CREATE TABLE insurance.policy (
id_policy INT NOT NULL AUTO_INCREMENT,
policy_description VARCHAR(50),
policycol_date DATE,
policy_expired_date DATE,
policy_price DECIMAL(5,2),
policy_content VARCHAR(2000),
PRIMARY KEY (id_policy)
)
