<%--
  Created by IntelliJ IDEA.
  User: twanb
  Date: 13-Jul-18
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

<div class="content">
    <div class="iHeaderBg">
        <video poster="/img/movieposter.jpg" id="iHeaderBgVid" playsinline autoplay muted loop >
            <source src="mov/index.mp4" type="video/mp4">
            Your browser does not support the video tag.
        </video>
    </div>



    <div id="id01" class="modal">

        <form class="modal-content animate" method="post" action="login">
            <div class="imgcontainer">
                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="img/img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <form method="post" action="login">
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                    <button type="submit">Login</button>
                    <label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                    </label>

            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </div>
</body>
</html>
