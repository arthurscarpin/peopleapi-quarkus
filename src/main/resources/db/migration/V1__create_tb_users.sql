CREATE TABLE tb_users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO tb_users (id, name, email) VALUES
    (UNHEX(REPLACE(UUID(), '-', '')), 'john_doe', 'john_doe@email.com'),
    (UNHEX(REPLACE(UUID(), '-', '')), 'jane_doe', 'jane_doe@email.com'),
    (UNHEX(REPLACE(UUID(), '-', '')), 'alice_smith', 'alice_smith@email.com'),
    (UNHEX(REPLACE(UUID(), '-', '')), 'bob_johnson', 'alice_smith@email.com'),
    (UNHEX(REPLACE(UUID(), '-', '')), 'charlie_brown', 'charlie_brown@email.com');