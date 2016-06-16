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
        Connection conn = (Connection) DBConnection.getConnection();
        String q = "SELECT * FROM POSTS";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				posts.add(new Post(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("description"), null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        ResultSetIterator rt = new ResultSetIterator(rs);
        return posts.iterator();
    }
    
    public void addPost(Post post){
        //to do
		Connection conn = (Connection) DBConnection.getConnection();
        String q = "INSERT INTO POSTS(title,author,description,date) Values(?,?,?,?)";
		PreparedStatement stmt;
		int postid;
		try {
//			stmt = conn.prepareStatement("SELECT MAX(id) as id from posts");
//			ResultSet rs = stmt.executeQuery();
//			if(rs.next()){
//				postid = rs.getInt("id") + 1;
//			}else{
//				postid = 1;
//			}
			stmt = conn.prepareStatement(q);
//			stmt.setInt(1, postid);
			stmt.setString(1,post.getTitle());
			stmt.setString(2,post.getAuthor());
			stmt.setString(3,post.getDescription());
			stmt.setString(4,post.getDate());
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
			stmt.executeQuery();
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