<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="q" class="com.nav.qanda.poll.domain.Qanda"/>
<html>
<head>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: center;
}
.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
 <center>
  
 
 <form:form method="post" action="/poll/registerAnswer" modelAttribute="qandaPoll">
 <b>Take the Poll </b>
 
  <table border="1">
   <tr>
    <td class="heading" colspan="2"><c:out value="${questionNAns.questionText}" /></td>
   </tr>
    <tr>
     <td><form:radiobutton path="usersResponse" value="${questionNAns.questionAnswerA}"/><c:out value="${questionNAns.questionAnswerA}"/></td>
     <td><form:radiobutton path="usersResponse" value="${questionNAns.questionAnswerB}"/><c:out value="${questionNAns.questionAnswerB}"/></td>
     </tr>
    <tr>
     <td><form:radiobutton path="usersResponse" value="${questionNAns.questionAnswerC}"/><c:out value="${questionNAns.questionAnswerC}"/></td>
     <td><form:radiobutton path="usersResponse" value="${questionNAns.questionAnswerD}"/><c:out value="${questionNAns.questionAnswerD}"/></td>
     </tr>
      <form:hidden path="id" value="${questionNAns.id}" />
   <tr><td colspan="7" align="center"><input type="submit" value="Save" /></td></tr>
  </table>
</form:form>
 </center>
</body>
</html>
