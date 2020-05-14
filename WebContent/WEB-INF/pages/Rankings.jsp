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
    <h2>Pool Rankings</h2>
   	<a href="home.htm">Home</a> |
    <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</fieldset>

<fieldset>
  <legend>Ranking</legend>  <dl>
     <dt></dt>
       <dd>
          <table border="1">
<tr>
   <th>Rank</th>
   <th>Voter</th>
   <th>Points</th>
</tr>
<c:forEach var="ranking" items="${rankings}" varStatus="status">
    <tr>
    <td align="center"><c:out value="${status.count}"/></td>
	<td><c:out value="${ranking.userid}"/></td>
	<td align="center"><c:out value="${ranking.counter}"/></td>
	</tr>
</c:forEach>


</table> 
       </dd>
  </dl>
</fieldset>



</body>
</html>