public class HtmlTags {
    public static String getHtmlStart() {
        return htmlStart;
    }

    public static String getHtmlHeader() {
        return htmlHeader;
    }

    public static String getHtmlEnd() {
        return htmlEnd;
    }

    public static String getHtmlContentStart() {
        return htmlContentStart;
    }

    public static String getHtmlContentEnd() {
        return htmlContentEnd;
    }

    private static String htmlStart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
            "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
            "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n" +
            "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\"\n" +
            "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\">\n" +
            "<h:head><title>FletNix</title>\n" +
            "   <link rel=\"stylesheet\" href=\"style/style.css\"/>\n" +
            "   <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\"/>\n" +
            "   <meta name=\"description\" content=\"FletNix online video streaming service\"/>\n" +
            "   <meta name=\"keywords\" content=\"FletNix,NetFlix,Video,Streaming\"/>\n" +
            "   <meta name=\"author\" content=\"Twan Bolwerk\"/>\n" +
            "   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
            "</h:head>\n" +
            "<h:body>";

    private static String htmlHeader = "   <div class=\"header\">\n" +
            "      <div class=\"topnav\" id=\"myTopnav\">\n" +
            "         <a href=\"index_old.xhtml\" class=\"active\">Home</a>\n" +
            "         <a href=\"#new\">New</a>\n" +
            "         <a href=\"overview.xhtml\">Overview</a>\n" +
            "         <a href=\"#populair\">Populair</a>\n" +
            "         <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
            "            <i class=\"fa fa-bars\"></i>\n" +
            "         </a>\n" +
            "      </div>\n" +
            "         <div class=\"usernav\">\n" +
            "            <a href=\"#\"><span><i class=\"fas fa-user\"></i>Sign Up</span></a>\n" +
            "            <a href=\"#\"><span><i class=\"fas fa-sign-in-alt\"></i>Login</span></a>\n" +
            "\n" +
            "      </div>\n" +
            "\n" +
            "\n" +
            "   </div>";

    private static String htmlEnd = "</h:body>\n" +
            "<script type=\"text/javascript\">\n" +
            "    function myFunction() {\n" +
            "        var x = document.getElementById(\"myTopnav\");\n" +
            "        if (x.className === \"topnav\") {\n" +
            "            x.className += \" responsive\";\n" +
            "        } else {\n" +
            "            x.className = \"topnav\";\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "</script>\n" +
            "</html>";

    private static String htmlContentStart = " <div class=\"content\">";
    private static String htmlContentEnd = "</div>";
}
