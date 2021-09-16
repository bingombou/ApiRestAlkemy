DROP TABLE IF EXISTS activities;

CREATE TABLE  ACTIVITIES (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
content VARCHAR(256) NOT NULL,
image VARCHAR(256) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
deleted BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS roles (
    id_role BIGINT(20) NOT NULL AUTO_INCREMENT,
    created_at DATE NOT NULL,
    description VARCHAR(30) NULL DEFAULT NULL,
    updated_at DATE NOT NULL,
    name VARCHAR(15) NOT NULL,
    PRIMARY KEY (id_role)
    );

CREATE TABLE IF NOT EXISTS users (
    id_user BIGINT(20) NOT NULL AUTO_INCREMENT,
    created_at DATE NOT NULL,
    deleted BIT(1) NOT NULL,
    email VARCHAR(20) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    updated_at DATE NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    password VARCHAR(8) NOT NULL,
    photo VARCHAR(30) NULL DEFAULT NULL,
    id_role BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (id_user),
    UNIQUE KEY unique_email (email),
    FOREIGN KEY (id_role)
    REFERENCES roles (id_role)
    );