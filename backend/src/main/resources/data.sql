/*---------------------------------------------USER ROLES INSERT----------------------------------------------------*/
INSERT INTO ROLE VALUES(1,'ADMIN');
INSERT INTO ROLE VALUES(2,'USER');

/*---------------------- EMPLOYEE INSERT ---------------------------------*/
INSERT INTO EMPLOYEE(id, firstname, lastname, username, password, salary, title)
	VALUES(1, 'Adam', 'Smith', 'username1', 'password1', 3000 , 'DEVELOPER');

INSERT INTO EMPLOYEE(id, firstname, lastname, username, password, salary, title)
	VALUES(2, 'Ahmad', 'Nadimi', 'username2', 'password2', 4000 , 'HR');

INSERT INTO EMPLOYEE(id, firstname, lastname, username, password, salary, title)
VALUES(3, 'Jamshid', 'Nazari', 'username3', 'password3', 4000 , 'MANAGER');

INSERT INTO USER_ROLES VALUES (1, 1);
INSERT INTO USER_ROLES VALUES (1, 2);

/*----------------------- TASKS INSERT ---------------------------*/
INSERT INTO TASK(id, taskname, description, priority, percentage)
SELECT 1, 'Finish Project of Web Design', 'This project is an important port', 'HIGH', 20
WHERE NOT EXISTS (SELECT * from TASK where id = 1);

INSERT INTO TASK(id, taskname, description, priority, percentage)
SELECT 2, 'Shipment task', 'The shipment process should be finished', 'NORMAL', 30
WHERE NOT EXISTS (SELECT * from TASK where id = 2);

INSERT INTO TASK(id, taskname, description, priority, percentage)
SELECT 3, 'New Development Phase', 'Creating new develpoment phase is important', 'LOW', 90
WHERE NOT EXISTS (SELECT * from TASK where id = 3);