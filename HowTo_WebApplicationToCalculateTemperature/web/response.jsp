<%-- 
    Document   : response
    Created on : Mar 3, 2018, 11:04:54 PM
    Author     : Ennio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Services</title>
        <style>
            body {
                text-align: center;
                padding: 12px;
                background-color: darkgray;
                font-family: sans-serif;
            }
            
            .maindiv {
                background-color: white;
                width: 65%;
                padding: 12px;
                margin: 0 auto;
            }
            
            .borderdiv {
                margin: 0 auto;
                border-style: solid;
                border-color: dimgrey;
                background-color: white;
                border-width: 1px;
            }
            
            .conversiondiv {
                margin: 0 auto;
                background-color: dimgray;
                text-align: center;
                padding: 12px;
            }
            
            #footer {
                margin: 0 auto;
                background-color: lightgray;
                padding: 12px;
                text-align: center;
                width: 97%;
            }
        </style>
    </head>
    <body>
        <div class="maindiv">
            <div class="borderdiv">
                <h2>Converting Temperature Web Service Live Demo</h2>
                <div class="conversiondiv">
                    <h4>Result of the Conversion</h4>
                    <jsp:useBean id="convertbean" scope="session" class="converttemperature.ConvertTemperature" />
                    <jsp:setProperty name="convertbean" property="temperature" />
                    <jsp:setProperty name="convertbean" property="fromUnit" />
                    <jsp:setProperty name="convertbean" property="toUnit" />
                    
                    <jsp:getProperty name="convertbean" property="result" />
                </div>
            </div>
            <br>
            <div id="footer"><h5>Developed by Ennio Vitor and Thieres Pereira<br> CCT College Dublin | 2018</h5></div>
        </div>
    </body>
</html>
