CREATE SEQUENCE seq_estatistica START WITH 11;

CREATE TABLE estatistica (
    id_estatistica BIGINT NOT NULL PRIMARY KEY,
	tp_consulta VARCHAR(30) NOT NULL,
	st_termo VARCHAR(30) NOT NULL,
	dt_consulta DATE 
); 
