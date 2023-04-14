INSERT INTO users (id, name, password)
VALUES (1, 'John', 'password1'),
       (2, 'Jane', 'password2'),
       (3, 'Bob', 'password3');

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 2);