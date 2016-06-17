package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import models.Post;

public class PostDAO{
    public Iterator getPosts(){
        ArrayList<Post> posts = new ArrayList();
        //to do title,author,description,date
        Connection conn = DBConnection.getConnection();
        String q = "SELECT * FROM posts";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				posts.add(new Post(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("description"), rs.getString("date")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        ResultSetIterator rt = new ResultSetIterator(rs);
        return posts.iterator();
    }
    
    public Post getPost(int postid){
        //to do title,author,description,date
        Connection conn = DBConnection.getConnection();
        String q = "SELECT * FROM posts WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			stmt.setInt(1, postid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return new Post(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("description"), rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        ResultSetIterator rt = new ResultSetIterator(rs);
        return null;
    }
    
    public void addPost(Post post){
        //to do
		Connection conn = (Connection)DBConnection.getConnection();
        String q;
		PreparedStatement stmt;
		int postid;
		try {
			q = "SELECT MAX(id) as id from posts";
			stmt = conn.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				postid = rs.getInt("id") + 1;
			}else{
				postid = 1;
			}
			q = "INSERT INTO POSTS(id,title,author,description,date) values(?,?,?,?,?)";
			stmt = conn.prepareStatement(q);
			stmt.setInt(1, postid);
			stmt.setString(2,post.getTitle());
			stmt.setString(3,post.getAuthor());
			stmt.setString(4,post.getDescription());
			stmt.setString(5,post.getDate());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void editPost(Post post){
        //to do
		Connection conn = (Connection) DBConnection.getConnection();
        String q = "UPDATE POSTS SET title = ? , author = ?, description = ?, date = ? WHERE id =?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			stmt.setString(1,post.getTitle());
			stmt.setString(2,post.getAuthor());
			stmt.setString(3,post.getDescription());
			stmt.setString(4,post.getDate());
			stmt.setInt(5,post.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deletePost(int postid){
        //to do
		Connection conn = (Connection) DBConnection.getConnection();
        String q = "DELETE FROM POSTS WHERE id =?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			stmt.setInt(1, postid);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}