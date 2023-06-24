CREATE DATABASE Centros;

USE Centros;

INSERT INTO Alumnos Values
(1,"Alberto","Perez","Rodriguez",'2000-11-21',1005090,20,'2021-03-11','2021-09-11',2,"ayuda","Jose",12);
(2,"victor","sds","Rosa",'2004-11-21',343443,10,'2021-03-11','2021-09-11',2,"ayuda","Jose",12);
(3,"sasuke","uchiha","sale",'2003-12-01',223443,20,'2021-03-11','2021-09-11',2,"ayuda","Jose",12);
(4,"salasa","cumbia","dfdgd",'2003-01-01',45456,21,'2021-03-11','2021-09-11',2,"recuperacion","Saul",23);
(5,"aasd","fgdg","dffg",'2006-03-31',12434,24,'2021-03-11','2021-09-11',2,"curso","Saul",354);

INSERT INTO Trabajador Values
(34,"leo","fensalsa","lie",34534535, "PERA80D", "Bienes","Administrador");
(34,"Jose","fenr","dfss",45646, "FG6FG", "Pedagogo","Profesor");
(35,"Saul","sdfdfg","ldfg",56456, "LJKJK", "Pedagogo","Profesor");
(36,"Valentina","dival","xue",7868, "LHJGHAA26", "Pedagogo","Profesor");
(37,"Jose","salseda","suarez",768979, "FG6FG", "Ayudante","Personal_de_apoyo");

INSERT INTO Tutoria Values
("ayuda",45646,"Jose",10,'2021-03-11','2021-09-11',12);
("recuperacion",56456,"Saul",18,'2021-03-11','2021-09-11',23);
("Curso",56456,"Saul",11,'2021-03-11','2021-09-11',354);
("ayuda",7868,"Valentina",10,'2021-03-11','2021-09-11',12);
("recuperacion",7868,"Valentina",20,'2021-03-11','2021-09-11',23);

INSERT INTO Centros_Universitarios Values
(1,"UAEMex","Zumpango Calle San Lorenzo","Pedagogo",34534535,108685,1);
(2,"UNAM","DF Delegacion Miguel Hidalgo","Pedagogo",5667676,465676,12);
(3,"Politecnico","DF Cuernavaca","Pedagogo",65765,898989898,54);
(4,"Zaca","DF","Pedagogo",1324364,546557,33);
(5,"UAEM","Toluca","Pedagogo",466767,768979,465);