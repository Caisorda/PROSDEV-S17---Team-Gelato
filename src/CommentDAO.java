import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class CommentDAO{
	
    public Iterator getComments(int postid){
        Connection conn = (Connection) DBConnection.getConnection();
        String q = "SELECT * FROM COMMENTS";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		ResultSet rs = stmt.executeQuery();
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
    }
    
    public void addComment(Comment comment){
    	Connection conn = (Connection) DBConnection.getConnection();
        String q = "INSERT INTO COMMENTS(details,date,postId) Values(?,?,?)";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		stmt.setString(1,comment.getDetails());
		stmt.setString(2,comment.getDate());
		stmt.setString(3,comment.getPostId());
		ResultSet rs = stmt.executeQuery();
		
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
    }
    
    public void editComment(Comment comment){
    	Connection conn = (Connection) DBConnection.getConnection();
        String q = "UPDATE COMMENTS SET details = ?, date = ?, postId = ? WHERE id =?";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		stmt.setString(1,comment.getDetails());
		stmt.setString(2,comment.getDate());
		stmt.setString(3,comment.getPostId());
		stmt.setString(4, comment.getId());
		ResultSet rs = stmt.executeQuery();
		
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
        
    }
    
    public void deleteComment(int commentid){
        Connection conn = (Connection) DBConnection.getConnection();
        String q = "DELETE FROM COMMENTS WHERE id =?";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(q);
		stmt.setString(1, comment.getId());
		ResultSet rs = stmt.executeQuery();
		
        ResultSetIterator rt = new ResultSetIterator(rs);
        return rt;
    }
}