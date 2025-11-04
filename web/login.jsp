<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>

        <c:if test="${not empty user}">
            <c:redirect url="home.jsp"/>
        </c:if>

        <form action="mainController" method="post">
            <table border="1" cellpadding="5" align="center">
                <tr>
                    <th colspan="2">LOGIN FORM</th>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="txtUsername" value="${username}" required /></td>
                </tr>
                <tr>
                    <td>Password</td>
                        <td><input type="password" name="txtPassword" required /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit" name="txtAction" value="login">Login</button>
                        <input type="reset" value="Reset" />
                    </td>
                </tr>
            </table>
        </form>

        <!-- Nút Register tách riêng -->
        <form action="mainController" method="post" style="text-align:center; margin-top:10px;">
            <input type="hidden" name="txtAction" value="register">
            <button type="submit">Register</button>
        </form>

        <c:if test="${not empty msg}">
            <p style="color:red; text-align:center;">${msg}</p>
        </c:if>

    </body>
</html>
