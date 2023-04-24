INSERT INTO building (buildingId, buildingName, city, pinCode) VALUES (10001, 'vector', 'Bangalore', '560056');

INSERT INTO company (companyId, companyName, city, pinCode) VALUES (10001, 'Johnson', 'Bangalore', '560056');

INSERT INTO Employee (employeeId, employeeName, city, pinCode) VALUES (10003, 'silam', 'Bangalore', CURRENT_DATE,false);

INSERT INTO UserRole (employeeId, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO UserRole (employeeId, role) VALUES (2, 'ROLE_USER');
INSERT INTO UserRoleToPrivilege (id, role, privilege) VALUES (1, 'ROLE_ADMIN', 'CREATE_BUILDING')
INSERT INTO UserRoleToPrivilege (id, role, privilege) VALUES (1, 'ROLE_ADMIN', 'DELETE_BUILDING')
INSERT INTO UserRoleToPrivilege (id, role, privilege) VALUES (1, 'ROLE_ADMIN', 'CREATE_COMPANY')
INSERT INTO UserRoleToPrivilege (id, role, privilege) VALUES (1, 'ROLE_ADMIN', 'DELETE_COMPANY')
INSERT INTO UserRoleToPrivilege (id, role, privilege) VALUES (1, 'ROLE_ADMIN', 'CREATE_EMPLOYEE')
INSERT INTO UserRoleToPrivilege (id, role, privilege) VALUES (1, 'ROLE_ADMIN', 'DELETE_EMPLOYEE')