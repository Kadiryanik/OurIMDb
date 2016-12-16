CREATE DATABASE imdb;
USE imdb;

CREATE TABLE IF NOT EXISTS Movie(
    mTitle VARCHAR(255) NOT NULL,
    mYear DATE NOT NULL,
    mCountry VARCHAR(50) NOT NULL,
    mTime VARCHAR(10) NOT NULL,
    mLanguage VARCHAR(50) NOT NULL,
    mRating DECIMAL(2,1) DEFAULT 0.0,
    mRatingCount INT DEFAULT 0,
    mDescription TEXT,
    mImage blob,
    mUrlLink VARCHAR(255),
    movieId INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(movieId)
);

CREATE TABLE IF NOT EXISTS Genre(
	mType VARCHAR(50) NOT NULL,
    movieId INT,
    FOREIGN KEY (movieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY (movieId,mType)
);

CREATE TABLE IF NOT EXISTS People(
    pTitle VARCHAR(255) NOT NULL,
    pFirstName VARCHAR(25) NOT NULL,
    pLastName VARCHAR(25) NOT NULL,
    pBirthday DATE NOT NULL,
    pBirthPlace VARCHAR(255) NOT NULL,
    pGender CHAR(1) CHECK(VALUE IN('M','F')),
    pImage blob,
    pDescription TEXT,
    peopleId INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(peopleId)
);

CREATE TABLE IF NOT EXISTS MoviePeople(
	fkMovieId INT,
    fkPeopleId INT,
    castName VARCHAR(255),
    actorFlag char(1) DEFAULT 'N' CHECK(VALUE IN('Y','N')),
    directorFlag char(1) DEFAULT 'N' CHECK(VALUE IN('Y','N')),
    writerFlag char(1) DEFAULT 'N' CHECK(VALUE IN('Y','N')),
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkPeopleId) REFERENCES People(peopleId) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT PRIMARY KEY (fkMovieId,fkPeopleId)
);

CREATE TABLE IF NOT EXISTS Organization(
	orgName VARCHAR(50) NOT NULL,
    orgCountry VARCHAR(50) NOT NULL,
	organizationId INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (organizationId)
);

CREATE TABLE IF NOT EXISTS MovieAward(
	fkOrgId INT ,
    fkMovieId INT,
    movieAwardTitle VARCHAR(255) NOT NULL,
    movieAwardYear DATE NOT NULL,
    awardId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkOrgId) REFERENCES Organization(organizationId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY(awardId)
);

CREATE TABLE IF NOT EXISTS PeopleAward(
	peopleAwardTitle VARCHAR(255) NOT NULL,
    peopleAwardYear DATE NOT NULL,
    awardId INT NOT NULL AUTO_INCREMENT,
    fkOrgId INT ,
    fkMovieId INT,
    FOREIGN KEY (fkOrgId) REFERENCES Organization(organizationId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY(awardId)
);

CREATE TABLE IF NOT EXISTS Users(
	userId INT NOT NULL AUTO_INCREMENT,
    uEmail VARCHAR(80) NOT NULL,
    uDisplayName VARCHAR(50) NOT NULL,
    uPassword CHAR(40) NOT NULL,
    PRIMARY KEY(userId)
);

CREATE TABLE IF NOT EXISTS MovieCommend(
	fkMovieId INT,
    fkUserId INT,
    commend VARCHAR(200) NOT NULL,
    commendId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (fkUserId) REFERENCES Users(userId) ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY (commendId)
);

CREATE TABLE IF NOT EXISTS PeopleCommend(
	fkPeopleId INT,
    fkUserId INT,
    commend VARCHAR(200) NOT NULL,
    commendId INT NOT NULL AUTO_INCREMENT,
	FOREIGN KEY (fkPeopleId) REFERENCES People(peopleId) ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (fkUserId) REFERENCES Users(userId) ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY (commendId)
);
 
CREATE TABLE IF NOT EXISTS MovieReply(
	fkCommendId INT,
    fkUserId INT,
    commend VARCHAR(200) NOT NULL,
    commendId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkCommendId) REFERENCES MovieCommend(commendId) ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY(commendId)
);
ALTER TABLE MovieReply AUTO_INCREMENT = 1000000;

CREATE TABLE IF NOT EXISTS PeopleReply(
	fkCommendId INT,
    fkUserId INT,
    commend VARCHAR(200) NOT NULL,
    commendId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkCommendId) REFERENCES PeopleCommend(commendId) ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY(commendId)
);
ALTER TABLE PeopleReply AUTO_INCREMENT = 1000000;
    
CREATE TABLE IF NOT EXISTS Rating(
	fkUserId INT,
    fkMovieId INT,
    rating INT NOT NULL,
    FOREIGN KEY (fkUserId) REFERENCES Users(userId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY (fkUserId, fkMovieId)
);
