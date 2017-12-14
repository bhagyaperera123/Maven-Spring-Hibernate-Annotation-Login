<%-- 
    Document   : Home
    Created on : Nov 18, 2017, 1:00:17 AM
    Author     : Bhagya Perera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISR Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://drive.google.com/uc?export=download&#038;id=1j77X-eYoOpKEMHa2SwagVWxx__poZ-1W">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://drive.google.com/uc?export=download&#038;id=1ak5G0oeoncUS_wz27opNBWfiDH7HJL4x"></script>
    </head>
    <body >
        <c:if test="${sessionScope.UID == null}">
            <c:redirect url = "Login.jsp"/>
        </c:if>
        <div class="container">    
            <div class="jumbotron">
                <div class="row">
                    <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                        <img src="https://www.svgimages.com/svg-image/s5/man-passportsize-silhouette-icon-256x256.png" alt="stack photo" class="img">
                    </div>
                    <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                        <form:form method="POST" action="userLogout">
                            <button style="margin-left: 90%;" class="btn btn-success">Logout</button>
                        </form:form>


                        <div class="container" style="border-bottom:1px solid black">
                            <h2><c:out value="${sessionScope.NAME}"/></h2>
                        </div>
                        <hr>
                        <ul class="container details">
                            <li><p><span class="glyphicon glyphicon-earphone one" style="width:50px;"></span><c:out value="${sessionScope.MOBILE}"/></p></li>
                            <li><p><span class="glyphicon glyphicon-envelope one" style="width:50px;"></span><c:out value="${sessionScope.EMAIL}"/></p></li>

                        </ul>
                    </div>
                </div>
            </div>
            <hr>

            <h1 style="text-align: center;">
                <p style="color: white;" class="typewrite" data-period="2000" data-type='[ "Hi, Im <c:out value="${sessionScope.NAME}"/>.", "I am Creative.", "I Love Design.", "I Love to Develop." ]'>
                    <span class="wrap"></span>
                </p>
            </h1>

            <c:if test="${sessionScope.USERTYPE == 1}">

                <form:form class="form-horizontal" action="createUser" method="post" style="margin-top: 200px;">
                    <fieldset>

                        <legend style="color: white;">User Registration</legend>

                        <div class="form-group">
                            <label style="color: white;" class="col-md-4 control-label" for="textinput">First Name</label>  
                            <div class="col-md-4">

                                <input id="textinput" id="fnm" name="fnm" placeholder="First Name" class="form-control input-md" required="">

                            </div>
                        </div>
                        <div class="form-group">
                            <label style="color: white;" class="col-md-4 control-label" for="textinput">Last Name</label>  
                            <div class="col-md-4">
                                <input id="textinput" id="lnm" name="lnm" type="text" placeholder="Last Name" class="form-control input-md" required="">

                            </div>
                        </div>

                        <div class="form-group">
                            <label style="color: white;" class="col-md-4 control-label" for="textinput">Email</label>  
                            <div class="col-md-4">
                                <input id="textinput" id="eml"name="email" type="email" placeholder="E-mail" class="form-control input-md" required="">


                            </div>
                        </div>


                        <div class="form-group">
                            <label style="color: white;" id="mob"   class="col-md-4 control-label" for="textinput">Mobile</label>
                            <div class="col-md-4">

                                <input id="passwordinput" name="mobile" max="15" type="text" onkeypress='validate(event)'  placeholder="Mobile" class="form-control input-md" required>



                            </div>
                        </div>

                        <div class="form-group">
                            <label style="color: white;" id="pas" class="col-md-4 control-label" for="passwordinput">Password</label>
                            <div class="col-md-4">
                                <input id="passwordinput" name="pas" type="password" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <c:choose>  
                            <c:when test="${param.message=='email'}">
                                <div id="lids"  class="alert alert-danger" role="alert">Email address already in use!</div>
                            </c:when>  
                            <c:when test="${param.message=='mobile'}">
                                <div id="lids"  class="alert alert-danger" role="alert">Mobile number already in use!</div>
                            </c:when>  
                            <c:when test="${param.message=='success'}">
                                <div id="lids"  class="alert alert-success" role="alert">Save Done!</div>-->
                            </c:when>  


                        </c:choose>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="button1id"></label>
                            <div class="col-md-8">
                                <button id="button1id" name="button1id" class="btn btn-success">Register</button>

                            </div>
                        </div>

                    </fieldset>
                </form:form>
            </c:if>

    </body>
</html>
