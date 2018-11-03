<%--
  Created by IntelliJ IDEA.
  User: twanb
  Date: 14-Jul-18
  Time: 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New</title>
    <link rel="stylesheet" href="style/billboard.css" type="text/css" charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="palmtrees"></div>
<div class="powerline"></div>
<div class="city"></div>
<div class="container">
    <div class="ad">
        <div id="ad_1" class="ad_1">
            <img class="slice_1" src="img/billboard/ads/ad1_slice01.jpg"/>
            <img class="slice_3" src="img/billboard/ads/ad1_slice03.jpg"/>
            <img class="slice_2" src="img/billboard/ads/ad1_slice02.jpg"/>
            <img class="slice_4" src="img/billboard/ads/ad1_slice04.jpg"/>
            <img class="slice_5" src="img/billboard/ads/ad1_slice05.jpg"/>
            <img class="slice_6" src="img/billboard/ads/ad1_slice06.jpg"/>
            <img class="slice_7" src="img/billboard/ads/ad1_slice07.jpg"/>
            <img class="slice_8" src="img/billboard/ads/ad1_slice08.jpg"/>
            <img class="slice_9" src="img/billboard/ads/ad1_slice09.jpg"/>
            <img class="slice_10" src="img/billboard/ads/ad1_slice10.jpg"/>
            <img class="slice_11" src="img/billboard/ads/ad1_slice11.jpg"/>
            <img class="slice_12" src="img/billboard/ads/ad1_slice12.jpg"/>
            <img class="slice_13" src="img/billboard/ads/ad1_slice13.jpg"/>
            <img class="slice_14" src="img/billboard/ads/ad1_slice14.jpg"/>
            <img class="slice_15" src="img/billboard/ads/ad1_slice15.jpg"/>
            <img class="slice_16" src="img/billboard/ads/ad1_slice16.jpg"/>
            <img class="slice_17" src="img/billboard/ads/ad1_slice17.jpg"/>
            <img class="slice_18" src="img/billboard/ads/ad1_slice18.jpg"/>
            <img class="slice_19" src="img/billboard/ads/ad1_slice19.jpg"/>
            <img class="slice_20" src="img/billboard/ads/ad1_slice20.jpg"/>
            <img class="slice_21" src="img/billboard/ads/ad1_slice21.jpg"/>
            <img class="slice_22" src="img/billboard/ads/ad1_slice22.jpg"/>
        </div>
        <div id="ad_2" class="ad_2">
            <img class="slice_1" src="img/billboard/ads/ad2_slice01.jpg"/>
            <img class="slice_2" src="img/billboard/ads/ad2_slice02.jpg"/>
            <img class="slice_3" src="img/billboard/ads/ad2_slice03.jpg"/>
            <img class="slice_4" src="img/billboard/ads/ad2_slice04.jpg"/>
            <img class="slice_5" src="img/billboard/ads/ad2_slice05.jpg"/>
            <img class="slice_6" src="img/billboard/ads/ad2_slice06.jpg"/>
            <img class="slice_7" src="img/billboard/ads/ad2_slice07.jpg"/>
            <img class="slice_8" src="img/billboard/ads/ad2_slice08.jpg"/>
            <img class="slice_9" src="img/billboard/ads/ad2_slice09.jpg"/>
            <img class="slice_10" src="img/billboard/ads/ad2_slice10.jpg"/>
            <img class="slice_11" src="img/billboard/ads/ad2_slice11.jpg"/>
            <img class="slice_12" src="img/billboard/ads/ad2_slice12.jpg"/>
            <img class="slice_13" src="img/billboard/ads/ad2_slice13.jpg"/>
            <img class="slice_14" src="img/billboard/ads/ad2_slice14.jpg"/>
            <img class="slice_15" src="img/billboard/ads/ad2_slice15.jpg"/>
            <img class="slice_16" src="img/billboard/ads/ad2_slice16.jpg"/>
            <img class="slice_17" src="img/billboard/ads/ad2_slice17.jpg"/>
            <img class="slice_18" src="img/billboard/ads/ad2_slice18.jpg"/>
            <img class="slice_19" src="img/billboard/ads/ad2_slice19.jpg"/>
            <img class="slice_20" src="img/billboard/ads/ad2_slice20.jpg"/>
            <img class="slice_21" src="img/billboard/ads/ad2_slice21.jpg"/>
            <img class="slice_22" src="img/billboard/ads/ad2_slice22.jpg"/>
        </div>
    </div>
</div>
<div class="billboard"></div>
<a class="back" href="http://tympanus.net/codrops/2009/12/16/creating-a-rotating-billboard-system-with-jquery-and-css/"><a>
    <script src="js/jquery-1.3.2.js" type="text/javascript"></script>
    <script>
        $(function() {
            $('#ad_1 > img').each(function(i,e){
                rotate($(this),500,3000,i);
            });
            function rotate(elem1,speed,timeout,i){
                elem1.animate({'marginLeft':'18px','width':'0px'},speed,function(){
                    var other;
                    if(elem1.parent().attr('id') == 'ad_1')
                        other = $('#ad_2').children('img').eq(i);
                    else
                        other = $('#ad_1').children('img').eq(i);
                    other.animate({'marginLeft':'0px','width':'35px'},speed,function(){
                        var f = function() { rotate(other,speed,timeout,i) };
                        setTimeout(f,timeout);
                    });
                });
            }
        });
    </script>
</body>
</html>
