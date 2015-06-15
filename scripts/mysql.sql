DROP TABLE IF EXISTS users, user_roles, WhoFor, Gift, Store;

CREATE  TABLE IF NOT EXISTS users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username)
)ENGINE = InnoDB;
  
INSERT INTO users(username,password,enabled)
VALUES ('stephen','password', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('other','password', TRUE); 
  
CREATE TABLE IF NOT EXISTS user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
)ENGINE = InnoDB;

INSERT INTO user_roles (username, ROLE)
VALUES ('stephen', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('stephen', 'ROLE_ADMIN');
INSERT INTO user_roles (username, ROLE)
VALUES ('other', 'ROLE_USER');

CREATE TABLE IF NOT EXISTS WhoFor(
	WhoForName VARCHAR(30) NOT NULL,
	PRIMARY KEY(WhoForName)
) ENGINE = InnoDB;

INSERT INTO WhoFor (WhoForName) VALUES ('Stephen');
INSERT INTO WhoFor (WhoForName) VALUES ('Erica');
INSERT INTO WhoFor (WhoForName) VALUES ('Both');

CREATE TABLE IF NOT EXISTS Store(
	StoreName VARCHAR(30) NOT NULL,
	PRIMARY KEY(StoreName)
)ENGINE = InnoDB;

INSERT INTO Store (StoreName) VALUES ('Target');
INSERT INTO Store (StoreName) VALUES ('Walmart');
INSERT INTO Store (StoreName) VALUES ('Crate&Barrel');

CREATE TABLE IF NOT EXISTS Gift(
	GiftID TINYINT(4) unsigned AUTO_INCREMENT NOT NULL, 
	GiftName VARCHAR(30)  NOT NULL, 
	Description TEXT NOT NULL,
	Price DECIMAL(4,2) NOT NULL,
	PubDate DATE NOT NULL,
	Status TINYINT(1) NOT NULL DEFAULT 1,
	WhoForID_fk VARCHAR(30) NOT NULL,
	StoreID_fk VARCHAR(30) NOT NULL, 
	BoughtBy VARCHAR(30) DEFAULT NULL,
	PRIMARY KEY(GiftID)
	
)ENGINE = InnoDB;

ALTER TABLE Gift
ADD CONSTRAINT 
FOREIGN KEY(WhoForID_fk) REFERENCES WhoFor(WhoForName)
ON DELETE CASCADE 
ON UPDATE CASCADE,

ADD CONSTRAINT 
FOREIGN KEY(StoreID_fk) REFERENCES Store(StoreName) 
ON DELETE CASCADE 
ON UPDATE CASCADE;


INSERT INTO Gift(GiftName, Description, Price, Pubdate, WhoForID_fk, StoreID_fk) 
VALUES ('Lamp', 'This is used to light things.', 9.95, CURDATE(), 
		(SELECT WhoFor.WhoForName FROM WhoFor WHERE WhoForName="Stephen"),
		(SELECT Store.StoreName FROM Store WHERE StoreName="Target"));
		
INSERT INTO Gift(GiftName, Description, Price, Pubdate, WhoForID_fk, StoreID_fk) 
VALUES ('Rug', 'This is used to layon things.', 10.95, CURDATE(), 
		(SELECT WhoFor.WhoForName FROM WhoFor WHERE WhoForName="Erica"),
		(SELECT Store.StoreName FROM Store WHERE StoreName="Walmart"));
		
INSERT INTO Gift(GiftName, Description, Price, Pubdate, WhoForID_fk, StoreID_fk) 
VALUES ('Chair', 'This is used to sit on things.', 12.95, CURDATE(), 
		(SELECT WhoFor.WhoForName FROM WhoFor WHERE WhoForName="Both"),
		(SELECT Store.StoreName FROM Store WHERE StoreName="Crate&Barrel")); 
		
INSERT INTO Gift(GiftName, Description, Price, Pubdate, WhoForID_fk, StoreID_fk) 
VALUES ('Truck', 'This is used to drive on things.', 85.95, CURDATE(), 
		(SELECT WhoFor.WhoForName FROM WhoFor WHERE WhoForName="Both"),
		(SELECT Store.StoreName FROM Store WHERE StoreName="Walmart"));
		
INSERT INTO Gift(GiftName, Description, Price, Pubdate, WhoForID_fk, StoreID_fk) 
VALUES ('House', 'This is used to live on things.', 90.95, CURDATE(), 
		(SELECT WhoFor.WhoForName FROM WhoFor WHERE WhoForName="Both"),
		(SELECT Store.StoreName FROM Store WHERE StoreName="Target")); 
  
  
 
