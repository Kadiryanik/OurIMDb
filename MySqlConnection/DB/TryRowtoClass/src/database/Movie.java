package database;

import java.sql.Date;

public class Movie {
	private String m_title;
	private Date m_date;
	private String m_country;
	private String m_time;
	private String m_language;
	private double m_rating;
	private int m_rating_count;
	private int movie_ID;

	@Override
	public String toString(){
		String s = "" + this.m_title + " | " + this.m_date +  " | " + this.m_country + " | " + this.m_time + " | " + 
				this.m_language + " | " + this.m_rating + " | " + this.m_rating_count + " | " + this.movie_ID + "\n";
		return s;
	}
	
	Movie(){}
	
	Movie(String t, Date d){
		setm_title(t);
		setm_date(d);
	}
	
	Movie(String t,Date d,String c,String time,String l,double r,int rc,int m){
		setm_title(t);
		setm_date(d);
		setm_country(c);
		setm_time(time);
		setm_language(l);
		setm_rating(r);
		setm_rating_count(rc);
		setMovie_ID(m);
	}
	
	public String getm_title() {
		return m_title;
	}
	public void setm_title(String m_title) {
		this.m_title = m_title;
	}
	public Date getm_date() {
		return m_date;
	}
	public void setm_date(Date m_date) {
		this.m_date = m_date;
	}
	public String getm_country() {
		return m_country;
	}
	public void setm_country(String m_country) {
		this.m_country = m_country;
	}
	public String getm_time() {
		return m_time;
	}
	public void setm_time(String m_time) {
		this.m_time = m_time;
	}
	public String getm_language() {
		return m_language;
	}
	public void setm_language(String m_language) {
		this.m_language = m_language;
	}
	public double getm_rating() {
		return m_rating;
	}
	public void setm_rating(double m_rating) {
		this.m_rating = m_rating;
	}
	public int getm_rating_count() {
		return m_rating_count;
	}
	public void setm_rating_count(int m_rating_count) {
		this.m_rating_count = m_rating_count;
	}
	public int getMovie_ID() {
		return movie_ID;
	}
	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}
}
