CREATE TABLE USERS (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `nickName` varchar(20),
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `createdAt` timestamp NOT NULL,
  `role` varchar,
  PRIMARY KEY (`id`)
);

CREATE TABLE `QUESTION` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`username` varchar(20) NOT NULL,
	`tags` varchar NOT NULL,
	`question` varchar NOT NULL,
	`userId` int(10) NOT NULL,
	`createdAt` timestamp NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`userId`) references USERS(`id`)
);

CREATE TABLE `MESSAGE` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`sender` int(10) NOT NULL,
	`reciever` int(10) NOT NULL,
	`message` varchar NOT NULL,
	`createdAt` timestamp NOT NULL,
	FOREIGN KEY (`sender`) REFERENCES USERS(`id`),
	FOREIGN KEY (`reciever`) REFERENCES USERS(`id`)
);

insert  into `USERS`(`id`,`first_name`,`last_name`, `nickName`, `email`) values (7,'Soumitra','Roy','contact@roytuts.com','30-08-1986'),(8,'Souvik','Sanyal','souvik.sanyal@email.com','30-09-1991');