DROP TABLE IF EXISTS product_catalog;
CREATE TABLE product_catalog(
		id INT AUTO_INCREMENT PRIMARY KEY,
		product_code INT NOT NULL,
		brand VARCHAR(55) NOT NULL,
		quantity INT NOT NULL,
		unit_price NUMERIC NOT NULL
	);