-- ZONA DE ELIMINACIÓN--
DROP TABLE IF EXISTS version_company;
DROP TABLE IF EXISTS version;
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS company;
-- FIN ZONA DE ELIMINACIÓN --

CREATE TABLE company (
	id_company INTEGER(3) AUTO_INCREMENT PRIMARY KEY,
    codigo_company VARCHAR(10) UNIQUE,
    name_company VARCHAR(50) NOT NULL,
    description_company VARCHAR(150)
);

CREATE TABLE application (
	app_id INTEGER(3) AUTO_INCREMENT PRIMARY KEY,
    app_code VARCHAR(10) UNIQUE,
    app_name VARCHAR(50) NOT NULL,
    app_description VARCHAR(150)
);

CREATE TABLE version (
	version_id INTEGER(3) AUTO_INCREMENT PRIMARY KEY,
    app_id INTEGER(3) UNIQUE NOT NULL,
    version VARCHAR(10) UNIQUE NOT NULL,
    version_description VARCHAR(150),
    CONSTRAINT FK1 FOREIGN KEY (app_id) REFERENCES application(app_id)
);

CREATE TABLE version_company (
	version_company_id INTEGER(3) AUTO_INCREMENT PRIMARY KEY,
    company_id INTEGER(3) UNIQUE NOT NULL,
    version_id INTEGER(3) UNIQUE NOT NULL,
    version_company_description VARCHAR(150),
    CONSTRAINT FK2 FOREIGN KEY (company_id) REFERENCES company(id_company),
    CONSTRAINT FK3 FOREIGN KEY (version_id) REFERENCES version(version_id)
);

CREATE TABLE TMP_LLENAR_CAMPOS (
    id_company  INTEGER ,
    codigo_company VARCHAR,
    name_company VARCHAR,
    description_company VARCHAR,
    app_id  INTEGER,
    app_code VARCHAR,
    app_name VARCHAR,
    app_description VARCHAR,
    version_id INTEGER,
    app_id INTEGER,
    version  VARCHAR,
    version_description VARCHAR,
    version_company_id INTEGER,
    company_id  INTEGER,
    version_id  INTEGER,
    version_company_description VARCHAR
     );

CREATE OR REPLACE PROCEDURE insertarCampos()
BEGIN

    DECLARE CURSOR CTemporal
        CURSOR FOR 
            SELECT * FROM TMP_LLENAR_CAMPOS;
    
    OPEN CTemporal;

    FOR i IN 1 .. CTemporal.COUNT LOOP
        INSERT INTO company VALUES (CTemporal(i).id_company, CTemporal(i).codigo_company, CTemporal(i).name_company, CTemporal(i).description_company);
        INSERT INTO application VALUES (CTemporal(i).app_id, CTemporal(i).app_code, CTemporal(i).app_name, CTemporal(i).app_description);
        INSERT INTO version VALUES (CTemporal(i).version_id, CTemporal(i).app_id, CTemporal(i).version, CTemporal(i).version_description);
        INSERT INTO version_company VALUES (CTemporal(i).version_company_id, CTemporal(i).company_id, CTemporal(i).version_id, CTemporal(i).version_company_description);
    END LOOP;

    CLOSE CTemporal;

END;