package models;
import java.sql.Date;

public class Comment {
	private int id;
	private String details;
	private Date date;
	private int postId;
	
	public Comment(int id, String details, Date date, int postId) {
		this.details = details;
		this.date = date;
		this.postId = postId;
		this.id = id;
	}
	
	public Comment(String details, Date date, int postId) {
		this.details = details;
		this.date = date;
		this.postId = postId;
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
}
