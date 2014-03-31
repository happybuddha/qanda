<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 text-align: left;
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
  
 
 
 <b>QANDA | Create poll question </b> 

  

  <div>
   <form:form method="post" action="/admin/createQandA" modelAttribute="qanda">
    <table>
     <tr>
      <td>Question :</td>
      <td><form:input path="questionText" /></td>
     </tr>
     <tr>
      <td>Option A :</td>
      <td><form:input path="questionAnswerA" /></td>
     </tr>
     <tr>
      <td>Option B :</td>
      <td><form:input path="questionAnswerB" /></td>
     </tr>
     <tr>
      <td>Option C :</td>
      <td><form:input path="questionAnswerC" /></td>
     </tr>
     <tr>
      <td>Option D :</td>
      <td><form:input path="questionAnswerD" /></td>
     </tr>
      <td> </td>
      <td><input type="submit" value="Save" /></td>
     </tr>
    </table>
   </form:form>
  </div>
 </center>
</body>
</html>
