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
