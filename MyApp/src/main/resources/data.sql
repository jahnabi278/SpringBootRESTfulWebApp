
CREATE TABLE if not exists SYNCHRONY_USER (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255),
    city VARCHAR(255),
    phone VARCHAR(20),
    name VARCHAR(255)
);
insert into SYNCHRONY_USER values ('jahnabi123','pass@123','Blr','8877887788','Jahnabi');
insert into SYNCHRONY_USER values ('mriga123','pass@123','Blr','8877887788','Mriga');
insert into SYNCHRONY_USER values ('parnita','pass@123','Blr','8877887788','Pranita');