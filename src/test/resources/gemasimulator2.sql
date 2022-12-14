DROP TABLE T31500;

CREATE TABLE T31500( 
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),	
C02 VARCHAR(50),	
C03 VARCHAR(50),
C04 VARCHAR(50),	
C05 VARCHAR(50),	
C06 VARCHAR(50),		
C07 VARCHAR(50),	
C08 VARCHAR(50),	
C09 VARCHAR(50),	
C10 VARCHAR(50),	
C11 VARCHAR(50),
C12 VARCHAR(50),
C13 VARCHAR(50),
C14 VARCHAR(50),
C15 VARCHAR(50),
C16 VARCHAR(50),
C17 VARCHAR(50),
C18 VARCHAR(50),
C19 VARCHAR(50),
C20 VARCHAR(50),
C21 VARCHAR(50),
C22 VARCHAR(50),
C23 VARCHAR(50),
C24 VARCHAR(50),
C25 VARCHAR(50),
C26 VARCHAR(50),
C27 VARCHAR(50),
C28 VARCHAR(50),
C29 VARCHAR(50),
C30 VARCHAR(50),
C31 VARCHAR(50),
C32 VARCHAR(50),
C33 VARCHAR(50),
C34 VARCHAR(50),
C35 VARCHAR(50),
C36 VARCHAR(50),
C37 VARCHAR(50),
C38 VARCHAR(50),
C39 VARCHAR(50),
C40 VARCHAR(50),
C41 VARCHAR(50),
C42 VARCHAR(50),
C43 VARCHAR(50),
C44 VARCHAR(50),
C45 VARCHAR(50),
C46 VARCHAR(50),
PRIMARY KEY(ID)
);

CREATE INDEX T31500_IX ON T31500(BANCO,FECHA_TRANS); 

DROP TABLE T31502;

CREATE TABLE T31502( 
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),	
C02 VARCHAR(50),	
C03 VARCHAR(50),
C04 VARCHAR(50),	
C05 VARCHAR(50),	
C06 VARCHAR(50),		
C07 VARCHAR(50),	
C08 VARCHAR(50),	
C09 VARCHAR(50),	
C10 VARCHAR(50),	
C11 VARCHAR(50),
C12 VARCHAR(50),
C13 VARCHAR(50),
C14 VARCHAR(50),
C15 VARCHAR(50),
C16 VARCHAR(50),
C17 VARCHAR(50),
C18 VARCHAR(50),
C19 VARCHAR(50),
C20 VARCHAR(50),
C21 VARCHAR(50),
C22 VARCHAR(50),
C23 VARCHAR(50),
C24 VARCHAR(50),
C25 VARCHAR(50),
C26 VARCHAR(50),
C27 VARCHAR(50),
C28 VARCHAR(50),
C29 VARCHAR(50),
C30 VARCHAR(50),
C31 VARCHAR(50),
C32 VARCHAR(50),
C33 VARCHAR(50),
C34 VARCHAR(50),
C35 VARCHAR(50),
C36 VARCHAR(50),
C37 VARCHAR(50),
C38 VARCHAR(50),
C39 VARCHAR(50),
C40 VARCHAR(50),
C41 VARCHAR(50),
C42 VARCHAR(50),
C43 VARCHAR(50),
C44 VARCHAR(50),
C45 VARCHAR(50),
C46 VARCHAR(50),
C47 VARCHAR(50),
C48 VARCHAR(50),
C49 VARCHAR(50),
PRIMARY KEY(ID)
);

CREATE INDEX T31502_IX ON T31502(BANCO,FECHA_TRANS); 

DROP TABLE T31503;

CREATE TABLE T31503( 
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),	
C02 VARCHAR(50),	
C03 VARCHAR(50),
C04 VARCHAR(50),	
C05 VARCHAR(50),	
C06 VARCHAR(50),		
C07 VARCHAR(50),	
C08 VARCHAR(50),	
C09 VARCHAR(50),	
C10 VARCHAR(50),	
C11 VARCHAR(50),
C12 VARCHAR(50),
C13 VARCHAR(50),
C14 VARCHAR(50),
C15 VARCHAR(50),
C16 VARCHAR(50),
C17 VARCHAR(50),
C18 VARCHAR(50),
C19 VARCHAR(50),
C20 VARCHAR(50),
C21 VARCHAR(50),
C22 VARCHAR(50),
C23 VARCHAR(50),
C24 VARCHAR(50),
PRIMARY KEY(ID)
);

CREATE INDEX T31503_IX ON T31503(BANCO,FECHA_TRANS); 

DROP TABLE T31510;
CREATE TABLE T31510( 
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),	
C02 VARCHAR(50),	
C03 VARCHAR(50),
C04 VARCHAR(50),	
C05 VARCHAR(50),	
C06 VARCHAR(50),		
C07 VARCHAR(50),	
C08 VARCHAR(50),	
C09 VARCHAR(50),	
C10 VARCHAR(50),	
C11 VARCHAR(50),
C12 VARCHAR(50),
C13 VARCHAR(50),
C14 VARCHAR(50),
C15 VARCHAR(50),
C16 VARCHAR(50),
C17 VARCHAR(50),
C18 VARCHAR(50),
C19 VARCHAR(50),
C20 VARCHAR(50),
C21 VARCHAR(50),
C22 VARCHAR(50),
C23 VARCHAR(50),
PRIMARY KEY(ID)
);

CREATE INDEX T31510_IX ON T31510(BANCO,FECHA_TRANS);

DROP TABLE T31530;

CREATE TABLE T31530(
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),
C02 VARCHAR(50),
C03 VARCHAR(50),
C04 VARCHAR(50),
C05 VARCHAR(50),
C06 VARCHAR(50),
C07 VARCHAR(50),
C08 VARCHAR(50),
C09 VARCHAR(50),
C10 VARCHAR(50),
C11 VARCHAR(50),
PRIMARY KEY(ID)
);
CREATE INDEX T31530_IX ON T31530(BANCO,FECHA_TRANS);

DROP TABLE T31534;

CREATE TABLE T31534( 
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),	
C02 VARCHAR(50),	
C03 VARCHAR(50),
C04 VARCHAR(50),	
C05 VARCHAR(50),		
PRIMARY KEY(ID)
);
CREATE INDEX T31534_IX ON T31534(BANCO,FECHA_TRANS);

DROP TABLE T32081;
CREATE TABLE T32081(
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),
C02 VARCHAR(50),
C03 VARCHAR(50),
C04 VARCHAR(50),
C05 VARCHAR(50),
C06 VARCHAR(50),
C07 VARCHAR(50),
C08 VARCHAR(50),
C09 VARCHAR(50),
C10 VARCHAR(50),
C11 VARCHAR(50),
C12 VARCHAR(50),
C13 VARCHAR(50),
PRIMARY KEY(ID)
);
CREATE INDEX T32081_IX ON T32081(BANCO,FECHA_TRANS);

DROP TABLE T32082;
CREATE TABLE T32082(
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),
C02 VARCHAR(50),
C03 VARCHAR(50),
C04 VARCHAR(50),
C05 VARCHAR(50),
C06 VARCHAR(50),
C07 VARCHAR(50),
C08 VARCHAR(50),
C09 VARCHAR(50),
C10 VARCHAR(50),
C11 VARCHAR(50),
C12 VARCHAR(50),
C13 VARCHAR(50),
PRIMARY KEY(ID)
);
CREATE INDEX T32082_IX ON T32082(BANCO,FECHA_TRANS);

DROP TABLE T32084;
CREATE TABLE T32084( 
ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BANCO VARCHAR(4) NOT NULL,
FECHA_TRANS TIMESTAMP NOT NULL,
VERSION VARCHAR(4),
C01 VARCHAR(50),	
C02 VARCHAR(50),	
C03 VARCHAR(50),
C04 VARCHAR(50),	
C05 VARCHAR(50),	
C06 VARCHAR(50),		
C07 VARCHAR(50),	
C08 VARCHAR(50),	
C09 VARCHAR(50),	
PRIMARY KEY(ID)
);
CREATE INDEX T32084_IX ON T32084(BANCO,FECHA_TRANS);

