<%--
    Document   : home
    Created on : 2013-03-03, 14:57:19
    Author     : Adrian Lapierre <alapierre@softproject.com.pl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" />

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

        <script>
            $(function() {
                var availableTags = [
                    "ActionScript",
                    "AppleScript",
                    "Asp",
                    "BASIC",
                    "C",
                    "C++",
                    "Clojure",
                    "COBOL",
                    "ColdFusion",
                    "Erlang",
                    "Fortran",
                    "Groovy",
                    "Haskell",
                    "Java",
                    "JavaScript",
                    "Lisp",
                    "Perl",
                    "PHP",
                    "Python",
                    "Ruby",
                    "Scala",
                    "Scheme"
                ];
                $("#tags").autocomplete({
                    source: availableTags
                });

                $("#country").autocomplete({
                    source: 'http://localhost:8084/spring-mvc-jquery/test'
                });

            });



        </script>

    </head>
    <body>
        <h1>Hello World!</h1>

        ala ma kota a kot ma ale

        <div class="ui-widget">
            <label for="tags">Tags: </label>
            <input id="tags">
        </div>

        <div class="ui-widget">
            <label for="country">Country: </label>
            <input id="country">
        </div>

    </body>
</html>
