import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PostDAO{
    public Iterator getPosts(int postid){
        ArrayList<Post> posts = new ArrayList();
        //to do title,author,description,date
        conn = (Connection) DBConnection.getConnection();
        String q = "SELECT * FROM POSTS";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		rs = stmt.executeQuery();
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
        return comments.iterator();
    }
    
    public void addPost(Post post){
        //to do
		conn = (Connection) DBConnection.getConnection();
        String q = "INSERT INTO POSTS(title,author,description,date) Values(?,?,?,?)";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		stmt.setString(1,post.getTitle());
		stmt.setString(2,post.getAuthor());
		stmt.setString(3,post.getDescription());
		stmt.setString(4,post.getDate());
		rs = stmt.executeQuery();
		
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
    }
    
    public void editPost(Post post){
        //to do
		conn = (Connection) DBConnection.getConnection();
        String q = "UPDATE POSTS SET title = ? , author = ?, description = ?, date = ? WHERE id =?";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		stmt.setString(1,post.getTitle());
		stmt.setString(2,post.getAuthor());
		stmt.setString(3,post.getDescription());
		stmt.setString(4,post.getDate());
		stmt.setString(5,post.getId());
		rs = stmt.executeQuery();
		
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
    }
    
    public void deletePost(int postid){
        //to do
		conn = (Connection) DBConnection.getConnection();
        String q = "DELETE FROM POSTS WHERE id =?";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		stmt.setString(1, post.getId());
		rs = stmt.executeQuery();
		
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
    }
}