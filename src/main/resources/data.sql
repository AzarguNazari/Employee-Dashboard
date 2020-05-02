/*---------------------------------------------USER ROLES INSERT----------------------------------------------------*/
INSERT INTO ROLE(id, name) SELECT 1,'ADMIN' WHERE NOT EXISTS (SELECT * from role where id = 1);
INSERT INTO ROLE(id, name) SELECT 2,'USER' WHERE NOT EXISTS (SELECT * from role where id = 2);

/*---------------------- EMPLOYEE INSERT ---------------------------------*/
INSERT INTO EMPLOYEE(id, firstname, lastname, username, password, salary, title, role_id)
	SELECT 1, 'Adam', 'Smith', 'username1', 'password', 3000 , 'DEVELOPER',  1
	WHERE NOT EXISTS (SELECT * from EMPLOYEE where id = 1);

INSERT INTO EMPLOYEE(id, firstname, lastname, username, password, salary, title, role_id)
	SELECT 2, 'Ahmad', 'Nadimi', 'username2', 'password2', 4000 , 'HR',  2
	WHERE NOT EXISTS (SELECT * from EMPLOYEE where id = 2);

INSERT INTO EMPLOYEE(id, firstname, lastname, username, password, salary, title, role_id)
SELECT 3, 'Jamshid', 'Nazari', 'username3', 'password3', 4000 , 'MANAGER',  1
WHERE NOT EXISTS (SELECT * from EMPLOYEE where id = 3);


/*----------------------- TASKS INSERT ---------------------------*/
INSERT INTO TASK(id, taskname, description, priority)
SELECT 1, 'Finish Project of Web Design', 'This project is an important port', 'HIGH'
WHERE NOT EXISTS (SELECT * from TASK where id = 1);

INSERT INTO TASK(id, taskname, description, priority)
SELECT 2, 'Shipment task', 'The shipment process should be finished', 'NORMAL'
WHERE NOT EXISTS (SELECT * from TASK where id = 2);

INSERT INTO TASK(id, taskname, description, priority)
SELECT 3, 'New Development Phase', 'Creating new develpoment phase is important', 'LOW'
WHERE NOT EXISTS (SELECT * from TASK where id = 3);