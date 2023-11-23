-- data.sql

-- data.sql

CREATE TABLE IF NOT EXISTS app_user (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS phone (
    id VARCHAR(36) PRIMARY KEY,
    number VARCHAR(20),
    user_id VARCHAR(36),
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);

-- INSERT INTO app_user (id, name, email, password) VALUES
-- ('1', 'Usuario 1', 'usuario1@example.com', 'contrasena1');

-- INSERT INTO phone (id, number, user_id) VALUES
-- ('1', '1234567', '1');
