<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h4> get the link and click on share. You can then share it with your google circle or facebook friends list.<br/> Or just text this link to anyone</h4>
<c:out value="${pollLink}" />
<a href="${pollLink}">Share</a>
<a href="mailto:your@email.address">Contact Us</a> 