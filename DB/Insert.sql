USE imdb;

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

INSERT INTO Users(uEmail,uDisplayName,uPassword) values ('cagatayavsr@gmail.com','cagatay','......');
INSERT INTO Users(uEmail,uDisplayName,uPassword) values ('eleqiac2@gmail.com','kadir','......');


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






