CREATE TABLE Unit
(
UnitID int PRIMARY KEY,
UnitName varchar(255)
);

CREATE TABLE Project
(
ProjectID int PRIMARY KEY,
ProjectName varchar(255)
);

CREATE TABLE Employee
(
EmployeeID int PRIMARY KEY,
UnitID int,
Street varchar(255),
CONSTRAINT fk_employee_unit FOREIGN KEY (UnitID) REFERENCES Unit(UnitID)
);

CREATE TABLE EmployeePersonalInfo
(
EmployeeID int PRIMARY KEY,
EmployeeName varchar(255),
CONSTRAINT fk_personalinfo_employee FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

CREATE TABLE ProjectEmployees(
ProjectID int,
EmployeeID int,
CONSTRAINT fk_prj_empls_prj FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
CONSTRAINT fk_prj_empls_empl FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

create sequence id_sequence start with 1;