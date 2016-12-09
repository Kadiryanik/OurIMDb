CREATE DATABASE imdb;
USE imdb;

CREATE TABLE IF NOT EXISTS Movie(
    m_Title VARCHAR(255) NOT NULL,
    m_Year DATE NOT NULL,
    m_Country VARCHAR(50) NOT NULL,
    movie_Time TIME NOT NULL,
    m_Language VARCHAR(50) NOT NULL,
    m_Rating DECIMAL(2,1) DEFAULT 0.0,
    m_Rating_Count INT DEFAULT 0,
    movie_ID INT(100) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(movie_ID)
);

CREATE TABLE IF NOT EXISTS People(
    p_Title VARCHAR(255) NOT NULL,
    p_First_Name VARCHAR(25) NOT NULL,
    p_Last_Name VARCHAR(25) NOT NULL,
    p_Birthday DATE NOT NULL,
    p_Birth_place VARCHAR(255) NOT NULL,
    p_Gender CHAR(1) CHECK(VALUE IN('M','F')),
    actor_flag char(1) DEFAULT 'N' CHECK(VALUE IN('Y','N')),
    director_flag char(1) DEFAULT 'N' CHECK(VALUE IN('Y','N')),
    writer_flag char(1) DEFAULT 'N' CHECK(VALUE IN('Y','N')),
    people_ID INT(100) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(people_ID)
);

CREATE TABLE IF NOT EXISTS Movie_People(
	fk_movie_ID INT(100),
    fk_people_ID INT(100),
	CONSTRAINT PRIMARY KEY (fk_movie_ID,fk_people_ID)
);

CREATE TABLE IF NOT EXISTS Organization(
	org_Name VARCHAR(50) NOT NULL,
    org_Country VARCHAR(50) NOT NULL,
	organization_ID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (organization_ID)
);

CREATE TABLE IF NOT EXISTS Movie_Award(
	m_a_Title VARCHAR(255) NOT NULL,
    m_a_Year DATE NOT NULL,
    award_ID INT NOT NULL AUTO_INCREMENT,
    fk_org_ID INT ,
    fk_movie_ID INT,
    FOREIGN KEY (fk_org_ID) REFERENCES Organization(organization_ID),
    FOREIGN KEY (fk_movie_ID) REFERENCES Movie(movie_ID),
    PRIMARY KEY(award_ID)
);

CREATE TABLE IF NOT EXISTS People_Award(
	p_a_Title VARCHAR(255) NOT NULL,
    p_a_Year DATE NOT NULL,
    award_ID INT NOT NULL AUTO_INCREMENT,
    fk_org_ID INT ,
    fk_movie_ID INT,
    FOREIGN KEY (fk_org_ID) REFERENCES Organization(organization_ID),
    FOREIGN KEY (fk_movie_ID) REFERENCES Movie(movie_ID),
    PRIMARY KEY(award_ID)
);

CREATE TABLE IF NOT EXISTS Users(
	user_ID INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(80) NOT NULL,
    display_name VARCHAR(50) NOT NULL,
    password CHAR(40) NOT NULL,
    PRIMARY KEY(user_ID)
);

CREATE TABLE IF NOT EXISTS Movie_Commend(
	fk_movie_ID INT,
    fk_user_ID INT,
    commend VARCHAR(200) NOT NULL,
    commend_ID INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fk_movie_ID) REFERENCES Movie(movie_ID),
    FOREIGN KEY (fk_user_ID) REFERENCES Users(user_ID),
    PRIMARY KEY (commend_ID)
);

CREATE TABLE IF NOT EXISTS People_Commend(
	fk_people_ID INT,
    fk_user_ID INT,
    commend VARCHAR(200) NOT NULL,
    commend_ID INT NOT NULL AUTO_INCREMENT,
	FOREIGN KEY (fk_people_ID) REFERENCES People(people_ID),
    FOREIGN KEY (fk_user_ID) REFERENCES Users(user_ID),
    PRIMARY KEY (commend_ID)
);
 
CREATE TABLE IF NOT EXISTS Movie_Reply(
	fk_commend_ID INT,
    fk_user_ID INT,
    commend VARCHAR(200) NOT NULL,
    commend_ID INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fk_commend_ID) REFERENCES movie_commend(commend_ID),
    PRIMARY KEY(commend_ID)
);
ALTER TABLE Movie_Reply AUTO_INCREMENT = 1000000;

CREATE TABLE IF NOT EXISTS People_Reply(
	fk_commend_ID INT,
    fk_user_ID INT,
    commend VARCHAR(200) NOT NULL,
    commend_ID INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fk_commend_ID) REFERENCES people_commend(commend_ID),
    PRIMARY KEY(commend_ID)
);
ALTER TABLE People_Reply AUTO_INCREMENT = 1000000;

INSERT INTO Movie(m_Title,m_Year,m_Country,movie_Time,m_Language,m_Rating,m_Rating_Count)
	VALUES('The Shawshank Redemption1', '1999-03-10', 'United States', '2:22:00', 'English', '8.9', 10);

INSERT INTO Movie(m_Title,m_Year,m_Country,movie_Time,m_Language,m_Rating,m_Rating_Count)
	VALUES('The Shawshank Redemption2', '1999-03-10', 'United States', '2:22:00', 'English', '8.9', 10);
    
    
INSERT INTO Movie(m_Title,m_Year,m_Country,movie_Time,m_Language,m_Rating,m_Rating_Count)
	VALUES('The Shawshank Redemption3', '1999-03-10', 'United States', '2:22:00', 'English', '8.9', 10);
    
INSERT INTO People(p_Title, p_First_Name, p_Last_Name, p_Birthday, p_Birth_place,
	p_Gender, actor_flag,director_flag, writer_flag) 
		VALUES('Tim Robbins - IMDB', 'Tim', 'Robbins', '1958-10-16', 'West Covina, California, USA',
			'M', 'Y', 'Y', 'N');