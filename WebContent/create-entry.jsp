<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>Gelato | Create Entry</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/skeleton.css">
    <link type="text/css" rel="stylesheet" href="styles/style-create-entry.css">
  </head>

  <body>
    <div id="nav-bar">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="view-posts.jsp">Dessert Diary</a></li>
        <li><a href="create-entry.jsp">New Entry</a></li>
      </ul>
    </div>

    <div class="form-container">
      <div class="form-pic">

      </div>
      <form action = "PostServlet" method = "post">
        <div class="row">
          <div class="six columns">
            <label for="post-title">Title</label>
            <input class="u-full-width" type="text" placeholder="Post title" id="title">
          </div>
          <div class="six columns">
            <label for="post-title">Reviewer</label>
            <input class="u-full-width" type="text" placeholder="Name" id="author">
          </div>
        </div>
        <label for="post-content">Content</label>
        <textarea class="u-full-width" placeholder="Write your sweet story here..." id="description"></textarea>
        <input class="button-primary" type="submit" value="Submit">
      </form>
    </div>
  </body>
</html>

