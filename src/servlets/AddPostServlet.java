package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PostDAO;
import models.Post;

@WebServlet(name = "PostServlet", urlPatterns = {"/PostServlet"})
public class AddPostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PostDAO postDAO = new PostDAO();
//        String operation = request.getAttribute("operation");
//        if (operation.equalsIgnoreCase("add")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view-posts.jsp");
            PrintWriter out= response.getWriter();
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String description = request.getParameter("description");
//            String date = request.getParameter("date");
            String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            postDAO.addPost(new Post(title, author, description, date));
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully added post!');");
            out.println("location='view-posts.jsp';");
            out.println("</script>");
//        }else if (operation.equalsIgnoreCase("edit")) {
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
//            PrintWriter out= response.getWriter();
//            String title = request.getParameter("title");
//            String author = request.getParameter("author");
//            String description = request.getParameter("description");
//            String date = request.getParameter("date");
//            postDAO.editPost(new Post(title, author, description, date));
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Successfully edited post!');");
//            out.println("location='index.html';");
//            out.println("</script>");
//        }else if (operation.equalsIgnoreCase("delete")) {
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
//            PrintWriter out= response.getWriter();
//            String postid = request.getAttribute("postid").toString();
//            postDAO.deletePost(postid);
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Successfully deleted post!');");
//            out.println("location='index.html';");
//            out.println("</script>");
      //  }
      
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