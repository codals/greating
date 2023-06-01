<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            color: #666;
            line-height: 1.6;
        }
        .error-message {
            margin-top: 40px;
        }
        .error-message strong {
            font-weight: bold;
        }
        .back-link {
            display: block;
            margin-top: 20px;
            color: #999;
            text-decoration: none;
        }
    </style>

   <%--  <c:choose>
	    <c:when test="${showAlert && empty sessionScope.loginMember}">
	        <script>
	            alert("${errorCode} \n${errorMessage}");
	            location.href = "/greating/login"; // login 페이지로 리다이렉트
	        </script>
	    </c:when>
	    <c:otherwise>
	        <script>
	            alert("${errorCode} \n${errorMessage}");
	            location.href = "/greating/"; // board 페이지로 리다이렉트
	        </script>
	    </c:otherwise>
	</c:choose> --%>

</head>
<body>
	
	<jsp:include page="templates/header.jsp" />

    <div class="container">
        <h1>Error</h1>
        <p>에러가 발생했습니다.</p>
        <div class="error-message">
            <p>Error Code: ${errorCode}</p>
            <p>Error Message: ${errorMessage}</p>
        </div>
        <a href="/" class="back-link">Back to Home</a>
    </div>
</body>
</html>
