CREATE TABLE Customer(
	userId		VARCHAR(20)		PRIMARY KEY,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL, -- 123456-1234567
	phone		VARCHAR(13)		NOT NULL, -- 010-1234-5678
	regDate	 	TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;



CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId			VARCHAR(20)		NOT NULL,
	accountNum		CHAR(11)		NOT NULL, -- 000-00-0000
	accType			CHAR(1)			NOT NULL,
	balance			DOUBLE			NOT NULL	DEFAULT	0,
	interestRate	DOUBLE			NOT NULL	DEFAULT	0.0,
	overAmount		DOUBLE			NOT NULL	DEFAULT	0.0,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT	Account_UserId_FK
		FOREIGN KEY(userId) REFERENCES Customer(userId)
)AUTO_INCREMENT = 3001, default charset=utf8;

SELECT * FROM Account;
SELECT * FROM Customer;

UPDATE Account SET balance=50000 WHERE userId='hantaewoo'

DROP TABLE Account;
DROP TABLE Customer;

DELETE FROM Account WHERE aid = '3005';

SELECT a.userId, a.accountNum, a.balance, c.passwd
FROM Account a INNER JOIN Customer c
ON a.userId = c.userId WHERE a.accountNum = '111-12-123';

SELECT userId, passwd FROM Customer WHERE userId = 'hantaewoo';