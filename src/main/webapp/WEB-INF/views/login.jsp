<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login Page For Security</title>
<style>
.errorblock {
 color: #ff0000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 padding: 8px;
 margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>
 <h3>Login with Username and Password (Custom Login Page)</h3>
 
 <c:if test="${not empty error}">
  <div class="errorblock">
   Your login attempt was not successful, try again.
 Caused :
   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
  </div>
 </c:if>
 
 <form:form action="/submitLogin" method="POST"  modelAttribute="user">
  <table>
   <tr>
    <td>User:</td>
    <td><form:input path="userN" />
    </td>
   </tr>
   <tr>
    <td>Password:</td>
    <td><form:input type='password' path='userP' />
    </td>
   </tr>
   <tr>
    <td colspan='2'><input name="submit" type="submit" value="submit" />
    </td>
    <td colspan='2'><input name="reset" type="reset" />
    </td>
   </tr>
  </table>
 
 </form:form>
</body>
</html>
