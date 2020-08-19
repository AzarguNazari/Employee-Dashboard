CREATE TABLE TASK (
    id              INT(11) PRIMARY KEY,
    taskname        VARCHAR(255),
    description     VARCHAR(500),
    priority        VARCHAR(5),
    percentage      INT(2),
    status          VARCHAR(9)
);