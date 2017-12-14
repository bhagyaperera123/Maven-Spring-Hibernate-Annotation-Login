<%-- 
    Document   : Login
    Created on : Nov 18, 2017, 12:51:23 AM
    Author     : Bhagya Perera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ISR Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link type="text/css" rel="stylesheet" href="https://drive.google.com/uc?export=download&#038;id=1Y27bHr1kX3CnNB7KXEBYSJspIxBhzVmH" />
        <script type="text/javascript" src="https://drive.google.com/uc?export=download&#038;id=16qwSaUR_r9srZnrCmdxgRdw80e0SgHnQ"></script>


    </head>
    <body>
        <c:if test="${sessionScope.UID != null}">
            <c:redirect url = "Home.jsp"/>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <div class="wrap">
                        <p class="form-title">
                            Sign In</p>
                            <form:form class="login" name="LOGIN" action="userCheck" method="post">
                            <input type="text" onkeyup="validation(1)" placeholder="Username" id="unm" name="username" required/>

                            <input type="password" onkeyup="validation(2)" id="pas" placeholder="Password" name="password" required/>

                            <input type="submit" id="loginID" value="Sign In" onclick="UserLogin()" class="btn btn-success btn-sm" />

                            <div id="err">
                                <c:choose>
                                    <c:when test="${param.message=='worng'}">
                                        <div id="lids"  class="alert alert-danger" role="alert">Wrong username or password!</div>
                                    </c:when>    

                                </c:choose>



                            </div>
                        </div>
                    </form:form>


                </div>
            </div>
        </div>
        <div class="posted-by">ISR Login © 2017</div>
    </div>

</body>
</html>
