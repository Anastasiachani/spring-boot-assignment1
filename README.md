# spring-boot-assignment1
Code for the first part of assignment

Database: Using Docker (https://docs.docker.com/get-docker/)

Για να εγκατασταθεί η εικόνα(image) της mysql στο docker, θα χρειαστεί να τρέξετε στο command line την εντολή: 

docker pull mysql

Έπειτα τρέχετε την εντολή: 

docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_USER=hbstudent -e MYSQL_PASSWORD=changeit -e MYSQL_DATABASE=students -e MYSQL_ROOT_PASSWORD=pass123 --rm -d mysql/mysql-server:latest

(η βάση που θα τρέχει στην εφραμογή)


Στο DBeaver(https://dbeaver.io/download/), χρησιμοποιώντας MySQL, τρέχουμε τις εξής εντολές ώστε να δημιουργηθούν οι πίνακες: 

CREATE TABLE IF NOT EXISTS `users` (
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `address` varchar(100),
  CONSTRAINT p_key PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `roles` (

  `email` varchar(50) NOT NULL,
  
  `password` varchar(100) NOT NULL,
  
  `authority` varchar(50) NOT NULL,
  
  UNIQUE KEY `ix_roles_email` (`email`,`authority`),
  
  CONSTRAINT `fk_roles_users` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Γεμίζουμε τους πίνακες με αυτές τις τιμές:

INSERT INTO `users` VALUES

('David','Adams','6981234567','david@hua.gr','Διευθυντής', 'Ομήρου 9, Ταύρος, ΤΚ:17778, Αττική'),

('John','Doe','6981420685','john@hua.gr', 'Τμήμα Προσωπικού', 'Ελ. Βενιζέλου 49 ,Μαρούσι, ΤΚ:15125, Αττική'),

('Ajay','Rao', '6984757031','ajay@hua.gr', 'Προϊστάμενος Τμήματος Παραγωγής', 'Λεωφ. Δημοκρατίας 135, Ηλιούπολη, ΤΚ:16345, Αττική'),

('Mary','Public','6987103258', 'mary@hua.gr', 'Εργαζόμενος Τμήματος Παραγωγής', 'Γαννιτσών 83, Περιστέρι, ΤΚ:12136'),

('Maxwell','Dixon','6940356921','max@hua.gr', 'admin', null);


INSERT INTO `roles` VALUES 

('david@hua.gr', '$2y$12$Iq0bcgP48iGHnXrlrr', 'ROLE_USER'),

('john@hua.gr', '$2y$12$z7DPby1uzmBkTMyGMRX', 'ROLE_USER'),

('ajay@hua.gr', '$2y$12$j82eNNFp3J3Ds8Vr8Cl', 'ROLE_USER'),

('mary@hua.gr', '$2y$12$8hf/OEwODICYCo6CfFMY', 'ROLE_USER'),

('max@hua.gr', '$2y$12$2pOEQ.I830hwcv', 'ROLE_ADMIN');


Application properties

Create a file named application.properties:

server.port=3306

#info

info.app.name=Myapp

management.endpoints.web.exposure.include=*

#db_params

spring.datasource.url=jdbc:mysql://localhost:3306/students?useSSL=false&serverTimezone=UTC&allowPublivKeyRetrieval=true

spring.datasource.username=hbstudent

spring.datasource.password=changeit

spring.data.rest.base-path=/api


Clone Project into IntelliJ(στην γραμμή εργαλειών της εφαρμογής):

Git -> Clone  

και στο URL βάζετε:

https://github.com/Anastasiachani/spring-boot-assignment1



