<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<h1>Benvenuto <%= session.getAttribute("email") %></h1>
	<h3><%=session.getAttribute("nome") %></h3><br/>
	<h3><%=session.getAttribute("cognome") %></h3><br/>
	<p>
		Sessione attiva da: <div id="activeTime"></div>
		<script type="text/javascript" >
			async function sleepWaiter(ms) {
				return new Promise(resolve => setTimeout(resolve, ms));
			}
			async function sleep(ms){
				while(true){
					document.getElementById("activeTime").innerHTML = (Date.now() - <%=session.getAttribute("loggedSince")%> ) % 1000;
					await sleepWaiter(ms);
				}
			}
			sleep(1000);
			
		</script>
	</p>
	<footer>
		<%
			boolean flag = true;
			if(session.getAttribute("email").equals(null)) {
				flag = false;
			}
			
		%>
		<c:if test = "<%=flag %>">
			<jsp:include page="_Logout.jsp"/>
		</c:if>
	</footer>
	
</body>
</html>