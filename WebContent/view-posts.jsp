<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="models.Post"%>
    <%@page import="database.PostDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>Gelato</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/skeleton.css">
    <link type="text/css" rel="stylesheet" href="styles/view-posts-style.css">

    <link rel="icon" type="image/png" href="imgs/favicon.png">
    
    <%
    PostDAO postDAO = new PostDAO();
    ArrayList<Post> posts = new ArrayList();
    for(Iterator i = postDAO.getPosts(); i.hasNext();){
    	posts.add((Post)i.next());
    }
    int pagenumber;
    if(request.getAttribute("page") != null){
    	pagenumber = (int)request.getAttribute("page");
    	if(posts.size() <= (pagenumber+1)*5)
    		pagenumber = 0;
    }else pagenumber = 0;
    %>
    <script>
    $(document).on("click","#next", function(){
        $.ajax({
           type: "POST",
           url: "NextPageServlet",
            cache: false,
            success: function(){
                location.reload();  
            }
        });
    });
    </script>
  </head>
  <body>
    <div id="nav-bar">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="view-posts.jsp">Dessert Diary</a></li>
        <li><a href="create-entry.jsp">New Entry</a></li>
      </ul>
    </div>
    <div class="header-pic">

    </div>
    <div class="post-container">
    <%
    	/*pagenumber++;
    	int bound = pagenumber * 5;
    	if(bound > posts.size())
    		bound = posts.size();
    	for(int i = (pagenumber-1)*5; i < bound; i++){*/
    		for(int i = 0; i < posts.size(); i++){
 			String details;
 			if(posts.get(i).getDescription().length()>42)
 	        	  details = posts.get(i).getDescription().substring(0, 42) + "...";
 			else details = posts.get(i).getDescription();
 			
 			
    %>
      <div class="entry">
      <a href='view-post.jsp?postid=<%=posts.get(i).getId()%>'>
        <h2><%=posts.get(i).getTitle()%></h2>
        <hr />
        <h4><%=posts.get(i).getAuthor()%></h4>
        <p>
          <%=details%>
        </p>
        </a>
      </div>
      <%} 
    	session.setAttribute("page", null);
      %>
      <div class="next-page">
      	<a href='view-posts.jsp?page=<%=pagenumber+1%>'>
      		<h1>See more posts</h1>
      	</a>
      </div>
    </div>
  </body>
</html>
