import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CommentDAO;
import models.Comment;

@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CommentDAO commentDAO = new CommentDAO();
        //String operation = request.getAttribute("operation");
        //if (operation.equalsIgnoreCase("add")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view-post.jsp");
            PrintWriter out= response.getWriter();
            String title = request.getParameter("comment");/*
            String author = request.getParameter("author");
            String description = request.getParameter("description");*/
            /*String date = request.getParameter("date");*/
            commentDAO.addComment(new Comment(0, title, null, 0));
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully added comment!');");
            out.println("location='index.html';");
            out.println("</script>");
        /*}else if (operation.equalsIgnoreCase("edit")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String description = request.getParameter("description");
            String date = request.getParameter("date");
            commentDAO.editComment(new Post(title, author, description, date));
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully edited comment!');");
            out.println("location='index.html';");
            out.println("</script>");
        }else if (operation.equalsIgnoreCase("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            String commentid = request.getAttribute("commentid").toString();
            commentDAO.deleteComment(Integer.parseInt(commentid));
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully deleted comment!');");
            out.println("location='index.html';");
            out.println("</script>");
        }
      */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
