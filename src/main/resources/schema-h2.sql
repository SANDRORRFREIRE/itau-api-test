CREATE SEQUENCE IF NOT EXISTS seq_estatistica;

CREATE TABLE IF NOT EXISTS estatistica (
    id_estatistica BIGINT NOT NULL PRIMARY KEY,
	tp_consulta VARCHAR(30) NOT NULL,
	st_termo VARCHAR(30) NOT NULL,
	dt_consulta DATE 
); 
