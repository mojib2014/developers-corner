CREATE TABLE `USERS` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `nickName` varchar(20),
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `QUESTION` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`username` varchar(20) NOT NULL,
	`tags` varchar NOT NULL,
	`question` varchar NOT NULL,
	`userId` int(10),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`userId`) references USERS(`id`)
);

insert  into `USERS`(`id`,`first_name`,`last_name`, `nickName`, `email`) values (7,'Soumitra','Roy','contact@roytuts.com','30-08-1986'),(8,'Souvik','Sanyal','souvik.sanyal@email.com','30-09-1991');