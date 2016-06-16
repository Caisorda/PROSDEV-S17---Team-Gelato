package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import models.Comment;

public class CommentDAO{
	
	public Iterator getComments(int postid) {
		ArrayList<Comment> comments = new ArrayList();
		Connection conn = (Connection) DBConnection.getConnection();
		String q = "SELECT * FROM COMMENTS";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				comments.add(new Comment(rs.getInt("id"), rs.getString("details"), null, rs.getInt("post_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments.iterator();

	}
    
    public void addComment(Comment comment){
    	Connection conn = (Connection) DBConnection.getConnection();
        String q = "INSERT INTO COMMENTS(details,date,postId) Values(?,?,?)";
		PreparedStatement stmt;
		int commentid;
		try {
//			stmt = conn.prepareStatement("SELECT MAX(id) as id from comments");
//			ResultSet rs = stmt.executeQuery();
//			if(rs.next()){
//				commentid = rs.getInt("id") + 1;
//			}else{
//				commentid = 1;
//			}
			stmt = conn.prepareStatement(q);
			stmt.setString(1,comment.getDetails());
			stmt.setDate(2,comment.getDate());
			stmt.setInt(3,comment.getPostId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void editComment(Comment comment){
    	Connection conn = (Connection) DBConnection.getConnection();
        String q = "UPDATE COMMENTS SET details = ?, date = ?, postId = ? WHERE id =?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			stmt.setString(1,comment.getDetails());
			stmt.setDate(2,comment.getDate());
			stmt.setInt(3,comment.getPostId());
			stmt.setInt(4, comment.getId());
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deleteComment(int commentid){
        Connection conn = (Connection) DBConnection.getConnection();
        String q = "DELETE FROM COMMENTS WHERE id =?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			stmt.setInt(1, commentid);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}