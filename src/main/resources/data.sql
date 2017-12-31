INSERT INTO ADDRESSES (ID, STREET, CITY, COUNTRY, PNUMBER) VALUES ('1', 'A.T. Mimare 44', 'Zagreb', 'Croatia', '555 5555');
INSERT INTO ADDRESSES (ID, STREET, CITY, COUNTRY, PNUMBER) VALUES ('2', 'Palmotićeva 39', 'Zagreb', 'Croatia', '777 7777');
INSERT INTO ADDRESSES (ID, STREET, CITY, COUNTRY, PNUMBER) VALUES ('3', 'Omiška 16', 'Zagreb', 'Croatia', '888 8888');

INSERT INTO DEPARTMENTS (UID, NAME, ADDRESS) VALUES ('turizam', 'Odjel za turizam', 1);

INSERT INTO COMPANIES (UID, NAME, ADDRESS) VALUES ('zila', 'Zila Trade d.o.o.', 2);
INSERT INTO COMPANIES (UID, NAME, ADDRESS) VALUES ('frigo', 'Frigo usluge d.o.o.', 3);

INSERT INTO USERS (UID, FNAME, LNAME, PHASH, ROLE, DTYPE, ACCOUNT_UID, DEPARTMENT_UID) VALUES ('isaric', 'Ivan', 'Saric', '$2a$04$BqMPJ8tCGQOBr16WGSy/ve96xzuePQwKmypgTKIzEKwm/FriRlgjy', 'EMPLOYEE', 'EMPLOYEE', SELECT UID
                                                                                                                                                                                                                  FROM COMPANIES
                                                                                                                                                                                                                  WHERE UID = 'zila', SELECT UID
                                                                                                                                                                                                                                      FROM DEPARTMENTS
                                                                                                                                                                                                                                      WHERE UID = 'turizam');
INSERT INTO USERS (UID, FNAME, LNAME, PHASH, ROLE, DTYPE, ACCOUNT_UID, DEPARTMENT_UID) VALUES ('vsaric', 'Vladimir', 'Saric', '$2a$04$BqMPJ8tCGQOBr16WGSy/ve96xzuePQwKmypgTKIzEKwm/FriRlgjy', 'EMPLOYEE', 'EMPLOYEE', SELECT UID
                                                                                                                                                                                                                      FROM COMPANIES
                                                                                                                                                                                                                      WHERE UID = 'zila', SELECT UID
                                                                                                                                                                                                                                          FROM DEPARTMENTS
                                                                                                                                                                                                                                          WHERE UID = 'turizam');

INSERT INTO USERS (UID, FNAME, LNAME, PHASH, ROLE, DTYPE, COMPANY_UID) VALUES ('fzilavcic', 'Filip', 'Zilavcic', '$2a$04$BqMPJ8tCGQOBr16WGSy/ve96xzuePQwKmypgTKIzEKwm/FriRlgjy', 'CLIENT', 'CLIENT', SELECT UID
                                                                                                                                                                                                     FROM COMPANIES
                                                                                                                                                                                                     WHERE UID = 'zila');
INSERT INTO USERS (UID, FNAME, LNAME, PHASH, ROLE, DTYPE, COMPANY_UID) VALUES ('vsekulic', 'Viktorija', 'Sekulic', '$2a$04$BqMPJ8tCGQOBr16WGSy/ve96xzuePQwKmypgTKIzEKwm/FriRlgjy', 'CLIENT', 'CLIENT', SELECT UID
                                                                                                                                                                                                       FROM COMPANIES
                                                                                                                                                                                                       WHERE UID = 'zila');
INSERT INTO USERS (UID, FNAME, LNAME, PHASH, ROLE, DTYPE, COMPANY_UID) VALUES ('vkucalo', 'Viktor', 'Kucalo', '$2a$04$BqMPJ8tCGQOBr16WGSy/ve96xzuePQwKmypgTKIzEKwm/FriRlgjy', 'CLIENT', 'CLIENT', SELECT UID
                                                                                                                                                                                                  FROM COMPANIES
                                                                                                                                                                                                  WHERE UID = 'frigo');
INSERT INTO USERS (UID, FNAME, LNAME, PHASH, ROLE, DTYPE, COMPANY_UID) VALUES ('mligorio', 'Mihovil', 'Ligorio', '$2a$04$BqMPJ8tCGQOBr16WGSy/ve96xzuePQwKmypgTKIzEKwm/FriRlgjy', 'CLIENT', 'CLIENT', SELECT UID
                                                                                                                                                                                                     FROM COMPANIES
                                                                                                                                                                                                     WHERE UID = 'frigo');

UPDATE DEPARTMENTS
SET MANAGER_UID = 'vsaric'
WHERE UID = 'turizam';