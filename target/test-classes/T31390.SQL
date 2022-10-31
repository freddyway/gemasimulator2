DROP TABLE T31390;

CREATE TABLE T31390( 
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
PRIMARY KEY(ID)
);

CREATE INDEX T31390_IX ON T31390(BANCO,FECHA_TRANS); 


INSERT INTO T31390
(BANCO
,FECHA_TRANS 
,VERSION 
,C01
,C02
,C03
,C04
,C05
,C06	
,C07
,C08
,C09
,C10
,C11
,C12
,C13
,C14
,C15
,C16
,C17
,C18
,C19
,C20
,C21
,C22
,C23
,C24
,C25
,C26
,C27
,C28
,C29
,C30
,C31
,C32
,C33
,C34
,C35)
VALUES
('0049'
,CURRENT_TIMESTAMP                                           
,'0001'
,'5163830108684749' 
,'201910'           
,'202410'           
,'0000000000'       
,'NF'               
,'48989382A'        
,'0'                
,'1720'             
,'0'                
,'00'               
,' '                
,'0000000000000000' 
,' '                
,' '                
,'0'                
,'0000'             
,'724'              
,'978'              
,'DEB49EST'         
,'0'                
,'0000000'          
,'0000000'          
,'1'                
,'1'                
,'0000000'          
,'2'                
,'978'              
,'201'              
,'0'                
,'0'                
,'1'                
,'111'              
,'0'                
,'0000000000'       
,'0049'             
);
