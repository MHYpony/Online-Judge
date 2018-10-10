CREATE DATABASE IF NOT EXISTS online_judge DEFAULT CHARACTER SET UTF8MB3;

USE online_judge;



CREATE TABLE IF NOT EXISTS users(
    id int(11) primary key auto_increment,
	user_name varchar(20) NULL DEFAULT NULL,
	password varchar(20) NOT NULL,
	enabled TINYINT(1) NOT NULL DEFAULT 0,
    UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
	UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = UTF8MB3;
	
	
CREATE TABLE IF NOT EXISTS categories(
    id int(11) primary key auto_increment,
	name varchar(45)
	)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = UTF8MB3;
insert into categories values ('1','sort');
	
	
CREATE TABLE IF NOT EXISTS questions(
    q_id int(11) primary key auto_increment,
	q_name varchar(45) NOT NULL,
	cid int(11),
	description TEXT,
	FOREIGN KEY (cid) REFERENCES categories(id) ON DELETE CASCADE
	)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = UTF8MB3;
insert into questions values ('1','fastQuestion','1','it is the first question');
	
	
CREATE TABLE IF NOT EXISTS test_data(
    id int(11) primary key auto_increment,
	qid int(11),
	input TEXT, 
	output TEXT,
	
	FOREIGN KEY(qid) REFERENCES questions(q_id) ON DELETE CASCADE
	)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = UTF8MB3;
	
	
CREATE TABLE IF NOT EXISTS run_status(
    run_id int(11) primary key auto_increment,
	sub_time DATETIME,
	judge_status varchar(100) NOT NULL,
	qid int(11),
	language varchar(45),
	run_time int(10),
	run_memory int(10),
	uid int(11),
	code TEXT,
	FOREIGN KEY(qid) REFERENCES questions(q_id) ON DELETE CASCADE,
	FOREIGN KEY(uid) REFERENCES users(id) ON DELETE CASCADE
	)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = UTF8MB3;
	












	