<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: twanb
  Date: 30-Jun-18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>FletNix</title>
    <link rel="stylesheet" href="style/style.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous"/>
    <link rel="stylesheet" href="style/search_overlay.css"/>
    <link rel="stylesheet" href="style/dropdown.css"/>
    <link rel="stylesheet" href="style/toastr.css"/>


    <meta name="description" content="FletNix online video streaming service"/>
    <meta name="keywords" content="FletNix,NetFlix,Video,Streaming"/>
    <meta name="author" content="Twan Bolwerk"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="header">
    <div class="topnav" id="myTopnav">
        <a<% if(session.getAttribute("user") == null){ %> href="index.html"<% }else{ %> href="#" <%}%> >Home</a>
        <a href="newservlet" <% if(session.getAttribute("current") == "new"){%>class="active"<%}%>>New</a>
        <a href="overviewservlet" <% if(session.getAttribute("current") == "overview"){%>class="active"<%}%>>Overview</a>
        <a href="popular" <% if(session.getAttribute("current") == "popular"){%>class="active"<%}%>>Popular</a>

        <div class="livesearch_inNav">
            <div id="search_overlay" class="search_overlay">
                <form class="search_overlay-form" method="get" action="">
                    <input class="search_overlay-input" type="search" id="key" placeholder="Search..." onkeyup="searchInfo()"/>

                </form>
                <div class="search_overlay-content">
                    <div class="dummy-column">
                        <h2>Movies</h2>
                        <div id="livesearch0"></div>
                    </div>
                    <div class="dummy-column">
                        <h2>Popular</h2>
                        <div id="livesearch1"></div>
                    </div>
                    <div class="dummy-column">
                        <h2>New</h2>
                        <div id="livesearch2"></div>
                    </div>
                </div><!-- /morphsearch-content -->
                <span class="search_overlay-close"></span>
            </div><!-- /morphsearch -->
        </div>

        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
        <%--<div class="usernav">--%>
            <%
                if(session.getAttribute("user") == null){

            %>

            <a href="#"><span><i class="fas fa-user"></i>Sign Up</span></a>
            <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;"><i class="fas fa-sign-in-alt"></i>Login</button>
            <% }else{ %>
            <div class="dropdown">

                <%--<button class="dropbtn" onclick="dropDown()">--%>
                    <%--<a href="javascript:void(0);" class="dropbtn" onclick="dropDown()">--%>


                <button class="dropbtn" onclick="dropDown()" id="hideUsername">
                    <i class="fas fa-user"></i><%=(String)session.getAttribute("user") %>
                </button>
                    <%--</a>--%>
                <%--</button>--%>

                <div id="myDropdown" class="dropdown-content">
                    <a href="#"><span><i class="fa fa-star" aria-hidden="true"></i>Favorieten</span></a>
                    <a href="#"><span><i class="fa fa-cog" aria-hidden="true"></i>Account</span></a>
                    <a href="logout"><span><i class="fas fa-sign-out-alt"></i>Logout</span></a>
                </div>
            </div>
            <%--<a href="#"><span><i class="fas fa-user"></i><span id="hideUsername"><%=(String)session.getAttribute("user") %></span></span></a>--%>
            <%--<a href="logout"><span><i class="fas fa-sign-out-alt"></i>Logout</span></a>--%>
            <% }%>
        <%--</div>--%>

    </div>










</div>

</body>
</html>
