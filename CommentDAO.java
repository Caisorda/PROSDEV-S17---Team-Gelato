import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class CommentDAO{
    public Iterator getComments(int postid){
        ArrayList<Comment> comments = new ArrayList();
        //to do
        
        return comments.iterator();
    }
    
    public void addComment(Comment comment){
        //to do
    }
    
    public void editComment(Comment comment){
        //to do
    }
    
    public void deleteComment(int commentid){
        //to do
    }
}