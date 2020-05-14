<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
   <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
   <META HTTP-EQUIV="Expires" CONTENT="-1">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <script language="javascript" type="text/javascript" src="niceforms.js"></script>
   <link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css" />
</head>

<body>

<fieldset class="action">
    <h2>Pool Statistics</h2>
   	<a href="home.htm">Home</a> | 
    <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</fieldset>

<c:forEach var="entry" items="${statsMap}" varStatus="status">
<fieldset>
  <legend><c:out value="${entry.key}"/></legend>  <dl>
     <dt></dt>
     <dd>
         <table border="1">
           <tr>
             <th>Nomination</th>
             <th>Number of votes</th>
           </tr>
         
            <c:forEach var="entry1" items="${entry.value}" varStatus="status1"> 
                <tr>
                   <td><c:out value="${entry1.key}"/></td>
                   <td align="center"><c:out value="${entry1.value}"/></td>
                </tr>
            </c:forEach>
          </table>          
     </dd>
	</fieldset>
</c:forEach>





</body>
</html>