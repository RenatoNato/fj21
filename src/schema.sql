CREATE TABLE CONTATOS (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(255),
	EMAIL VARCHAR(255),
	ENDERECO VARCHAR(255),
	DATANASCIMENTO DATE,
	PRIMARY KEY (ID)
);