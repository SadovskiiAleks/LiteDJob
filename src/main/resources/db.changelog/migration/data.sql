insert into user_role
values ('1','1921-01-06 03:00:00.000', 'user1@mail', '123', '$2a$10$rRLvO3j2RnDwS992HAJL2uGt9LGfGZw1GWuyok5rI30K9zzD/.gne', 'ROLE_ADMIN', 'user1'),
       ('2','1921-01-06 03:00:00.000', 'user2@mail', '123', '$2a$10$X2/4djnDfSMye79yVU.ngOqKZV1qhmvO3um3YBUm1kp3wgzL3JYf6', 'ROLE_ADMIN', 'user2'),
       ('3','1921-01-06 03:00:00.000', 'user3@mail', '123', '$2a$10$v0WkKDwmgAWfVGWnZIYZBu2Ze//gLwA4NzfvMac4o8iIXrocQgn26', 'ROLE_OPERATOR', 'user3'),
       ('4','1921-01-06 03:00:00.000', 'user4@mail', '123', '$2a$10$Kj60Osjwf00PWZ3e1tOiieBHaL7O6iEnpdF3BUKr4PGN6Gw2twCvi', 'ROLE_OPERATOR', 'user4'),
       ('5','1921-01-06 03:00:00.000', 'user5@mail', '123', '$2a$10$N/S2cvtZxn9Nb1vTpOYOx.i6xKsFav6LUwPDrpIhcO2P5A3fgLki2', 'ROLE_USER', 'user5'),
       ('6','1921-01-06 03:00:00.000', 'user6@mail', '123', '$2a$10$vDQijn9ifvAcFHIiMM.41.0xIr3X4x3x4c/m6cpddsn/8ZEBDj6TO', 'ROLE_USER', 'user6')
;

insert into Request
values (1,'1921-01-06 03:00:00.000','Заявка на ноут', 'SEND', 1),
       (2,'1921-01-06 03:00:00.000','Заявка на мышку','SEND',3),
       (3,'1921-01-06 03:00:00.000','Заявка на монитор','SEND',5),
       (4,'1921-01-06 03:00:00.000','Заявка на ролик','DRAFT',1),
       (5,'1921-01-06 03:00:00.000','Заявка на ручку','DRAFT',3),
       (6,'1921-01-06 03:00:00.000','Заявка на книжку','DRAFT',5),
       (7,'1921-01-06 03:00:00.000','Заявка на ластик','ACCEPT',1),
       (8,'1921-01-06 03:00:00.000','Заявка на нож','ACCEPT',3),
       (9,'1921-01-06 03:00:00.000','Заявка на стол','ACCEPT',5),
       (10,'1921-01-06 03:00:00.000','Заявка на мебель','DISMISS',1),
       (11,'1921-01-06 03:00:00.000','Заявка на стул','DISMISS',3),
       (12,'1921-01-06 03:00:00.000','Заявка на ничего','DISMISS',5)
;