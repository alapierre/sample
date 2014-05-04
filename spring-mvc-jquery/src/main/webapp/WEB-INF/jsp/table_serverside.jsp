<%-- 
    Document   : table
    Created on : 2014-05-04, 09:13:51
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!--        <script type="text/javascript" src="resources/jquery.dataTables.js"></script>-->
        <script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
        
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css" />
<!--        <link rel="stylesheet" type="text/css" href="resources/jquery.dataTables.css" />-->

    </head>
    <body>
        <h1>Hello World!</h1>

        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Office</th>
                    <th>Extn.</th>
                    <th>Start date</th>
                    <th>Salary</th>
                </tr>
            </thead>

            <tfoot>
                <tr>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Office</th>
                    <th>Extn.</th>
                    <th>Start date</th>
                    <th>Salary</th>
                </tr>
            </tfoot>
        </table>

        <script>
            $(document).ready(function() {
                $('#example').dataTable({
                    "language": {
                        "lengthMenu": "Pokaż _MENU_ rekordów na stronę",
                        "zeroRecords": "brak danych",
                        "info": "Strona _PAGE_ z _PAGES_",
                        "infoEmpty": "No records available",
                        "infoFiltered": "(przefiltrowane z _MAX_ wszystkich rekordów)"},
                    "ajax": "loadData",
                    "serverSide": true,
                    "columns": [
                        {"data": "name"},
                        {"data": "position"},
                        {"data": "office"},
                        {"data": "extn"},
                        {"data": "start_date"},
                        {"data": "salary"}
                    ]
                });
            });
        </script>

    </body>
</html>
