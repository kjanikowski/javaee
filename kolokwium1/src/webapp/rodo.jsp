<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
if(getServletContext().getAttribute("rodo") == null){
	getServletContext().setAttribute("rodo", "true");
	out.print("<form action =\"shop\" method=\"post\"> <input type=\"submit\" value=\"Usun z koszyka\"></form>" );
}else 
	response.sendRedirect("/shop");

%>


</body>
</html>