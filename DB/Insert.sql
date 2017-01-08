USE imdb;
#nm0000175
select actorFlag, directorFlag, writerFlag, mTitle from imdb.moviepeople m, imdb.movie a where a.movieId = 'tt1375670' AND m.fkPeopleId = 'nm0240797';
UPDATE `moviepeople` SET `actorFlag`= 0,`directorFlag`= 1,`writerFlag`= 0, `castName`='Francis Ford Coppola' WHERE fkMovieId = 'tt1375670' AND fkPeopleId = 'nm0240797';


INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('The Shawshank Redemption', '1994-10-14', 'United States', '142', 'English', 70, 10,
		'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',
			'https://www.youtube.com/embed/6hB3S9bIaco','tt0111161');
 
INSERT INTO Genre(mType,movieId) SELECT 'Crime',movieId FROM Movie WHERE mTitle = 'The Shawshank Redemption';
INSERT INTO Genre(mType,movieId) SELECT 'Drama',movieId FROM Movie WHERE mTitle = 'The Shawshank Redemption';


INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('The Godfather', '1972-03-24', 'United States', '175', 'English,Italian,Latin', 90, 11,
		'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',
			'https://www.youtube.com/embed/sY1S34973zA','tt0068646');  
            
INSERT INTO Genre(mType,movieId) SELECT 'Crime',movieId FROM Movie WHERE mTitle = 'The Godfather';
INSERT INTO Genre(mType,movieId) SELECT 'Drama',movieId FROM Movie WHERE mTitle = 'The Godfather';

#INSERT INTO Users(uEmail,uDisplayName,uPassword) values ('cagatayavsr@gmail.com','cagatay','......');
#INSERT INTO Users(uEmail,uDisplayName,uPassword) values ('eleqiac2@gmail.com','kadir','......');


INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('The Lord of the Rings: The Return of the King', '2003-12-19', 'United States', '201', 'English', 89, 10,
		'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.',
			'https://www.youtube.com/embed/r5X-hFf6Bwo','tt0167260');

INSERT INTO Genre(mType,movieId) SELECT 'Adventure',movieId FROM Movie WHERE mTitle = 'The Lord of the Rings: The Return of the King';
INSERT INTO Genre(mType,movieId) SELECT 'Drama',movieId FROM Movie WHERE mTitle = 'The Lord of the Rings: The Return of the King';
INSERT INTO Genre(mType,movieId) SELECT 'Fantasy',movieId FROM Movie WHERE mTitle = 'The Lord of the Rings: The Return of the King';


INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('The Godfather Part II', '1974-12-20', 'United States', '202', 'English,Italian,Latin', 90, 11,
		'The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on the family crime syndicate.',
			'https://www.youtube.com/embed/qJr92K_hKl0','tt0071562');  
            
INSERT INTO Genre(mType,movieId) SELECT 'Crime',movieId FROM Movie WHERE mTitle = 'The Godfather Part II';
INSERT INTO Genre(mType,movieId) SELECT 'Drama',movieId FROM Movie WHERE mTitle = 'The Godfather Part II';


INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('Grown Ups', '2010-08-10', 'United States', '102', 'English', 70, 11,
		'After their high school basketball coach passes away, five good friends and former teammates reunite for a Fourth of July holiday weekend.',
			'https://www.youtube.com/embed/cjfuK5QJyEQ','tt1375670');  
            
INSERT INTO Genre(mType,movieId) SELECT 'Comedy',movieId FROM Movie WHERE mTitle = 'Grown Ups';

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('Grown Ups 2', '2013-08-23', 'United States', '101', 'English', 60, 11,
		'After moving his family back to his hometown to be with his friends and their kids, Lenny finds out that between old bullies, new bullies, schizo bus drivers, drunk cops on skis, and 400 costumed party crashers sometimes crazy follows you.',
			'https://www.youtube.com/embed/a_c3hW0Uyvc','tt2191701');  
            
INSERT INTO Genre(mType,movieId) SELECT 'Comedy',movieId FROM Movie WHERE mTitle = 'Grown Ups 2';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('OK Jaanu', '2017-01-13', ' India', '135', 'India', 70, 10,
		'Adi and Tara move to Mumbai to pursue their dreams. A chance meeting sparks off a heady, no strings attached romance until their careers pull them apart. Will ambition prevail over matters of the heart?',
			'https://www.youtube.com/embed/HLdbAdya2po','tt5764024');
 
INSERT INTO Genre(mType,movieId) SELECT 'Drama',movieId FROM Movie WHERE mTitle = 'OK Jaanu';
INSERT INTO Genre(mType,movieId) SELECT 'Romance',movieId FROM Movie WHERE mTitle = 'OK Jaanu';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('A Monster Calls', '2016-10-14', 'United States', '108', 'English', 77, 10,
		'A boy seeks the help of a tree monster to cope with his single mum\'s terminal illness.',
			'https://www.youtube.com/embed/R2Xbo-irtBA','tt3416532');
 
INSERT INTO Genre(mType,movieId) SELECT 'Drama',movieId FROM Movie WHERE mTitle = 'A Monster Calls';
INSERT INTO Genre(mType,movieId) SELECT 'Fantasy',movieId FROM Movie WHERE mTitle = 'A Monster Calls';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('Monster Trucks', '2017-01-17', 'United States', '104', 'English', 54, 10,
		'Looking for any way to get away from the life and town he was born into, Tripp (Lucas Till), a high school senior, builds a Monster Truck from bits and pieces of scrapped cars. After an accident at a nearby oil-drilling site displaces a strange and subterranean creature with a taste and a talent for speed, Tripp may have just found the key to getting out of town and a most unlikely friend.',
			'https://www.youtube.com/embed/wQGawWqJdfs','tt3095734');
            
INSERT INTO Genre(mType,movieId) SELECT 'Animation',movieId FROM Movie WHERE mTitle = 'Monster Trucks';
INSERT INTO Genre(mType,movieId) SELECT 'Action',movieId FROM Movie WHERE mTitle = 'Monster Trucks';
INSERT INTO Genre(mType,movieId) SELECT 'Adventure',movieId FROM Movie WHERE mTitle = 'Monster Trucks';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('Sleepless', '2017-01-13', 'United States', '95', 'English', 70, 10,
		'A cop with a connection to the criminal underworld scours a nightclub in search of his kidnapped son.',
			'https://www.youtube.com/embed/LzWNDXwRbLY','tt2072233');
 
INSERT INTO Genre(mType,movieId) SELECT 'Action',movieId FROM Movie WHERE mTitle = 'Sleepless';
INSERT INTO Genre(mType,movieId) SELECT 'Crime',movieId FROM Movie WHERE mTitle = 'Sleepless';
INSERT INTO Genre(mType,movieId) SELECT 'Thriller',movieId FROM Movie WHERE mTitle = 'Sleepless';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('The Bye Bye Man', '2017-01-13', 'United States', '96', 'English', 70, 10,
		'Three friends stumble upon the horrific origins of the Bye Bye Man, a mysterious figure they discover is the root cause of the evil behind man\'s most unspeakable acts.',
			'https://www.youtube.com/embed/ZGdOnCiQRpQ','tt4030600');
 
INSERT INTO Genre(mType,movieId) SELECT 'Horror',movieId FROM Movie WHERE mTitle = 'The Bye Bye Man';
INSERT INTO Genre(mType,movieId) SELECT 'Thriller',movieId FROM Movie WHERE mTitle = 'The Bye Bye Man';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('Underworld Blood Wars', '2016-12-02', 'United States', '91', 'English', 64, 10,
		'Vampire death dealer, Selene (Kate Beckinsale) fights to end the eternal war between the Lycan clan and the Vampire faction that betrayed her.',
			'https://www.youtube.com/embed/FtbM_W9iNjg','tt3717252');
 
INSERT INTO Genre(mType,movieId) SELECT 'Action',movieId FROM Movie WHERE mTitle = 'Underworld Blood Wars';
INSERT INTO Genre(mType,movieId) SELECT 'Horror',movieId FROM Movie WHERE mTitle = 'Underworld Blood Wars';

########

INSERT INTO Movie(mTitle,mDate,mCountry,mTime,mLanguage,mRatingSum,mRatingCount,mDescription,mUrlLink,movieId)
	VALUES('xXx Return of Xander Cage', '2017-01-27', 'United States', '107', 'English', 67, 10,
		'Xander Cage is left for dead after an incident, though he secretly returns to action for a new, tough assignment with his handler Augustus Gibbons.',
			'https://www.youtube.com/embed/xEuM4IUFWu8','tt1293847');

INSERT INTO Genre(mType,movieId) SELECT 'Action',movieId FROM Movie WHERE mTitle = 'xXx Return of Xander Cage';
INSERT INTO Genre(mType,movieId) SELECT 'Adventure',movieId FROM Movie WHERE mTitle = 'xXx Return of Xander Cage';
INSERT INTO Genre(mType,movieId) SELECT 'Thriller',movieId FROM Movie WHERE mTitle = 'xXx Return of Xander Cage';
