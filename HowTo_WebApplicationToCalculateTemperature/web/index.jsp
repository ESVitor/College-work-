<%-- 
    Document   : index
    Created on : 02-Mar-2018, 16:11:13
    Author     : ThieresLuiz
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
            
            #conversiondiv {
                margin: 0 auto;
                background-color: dimgrey;
                text-align: center;
                padding: 12px;
            }
            
            #borderdiv {
                margin: 0 auto;
                border-style: solid;
                border-color: dimgrey;
                background-color: white;
                border-width: 1px;
            }
            
            #maindiv {
                background-color: white;
                width: 65%;
                padding: 12px;
                margin: 0 auto;
            }
            
            #header {
                margin: 0 auto;
                background-color: lightgray;
                padding: 12px;
                text-align: center;
                width: 97%;
            }
            
            #content {
                background-color: white;
                width: 75%;
                padding: 12px;
                margin: 0 auto;
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
        <div id="maindiv">
            <div id="header"><h1>Assignment 2: <br> Consuming a Live Web Service</h1></div>
            <div id="content">
                <h2><u>What's a Web Service?</u></h2>
                <p style="text-align: left;">
                    A web service is any piece of software that makes itself available over the internet and uses a standardized XML messaging system. XML is used to encode all communications to a web service. For example, a client invokes a web service by sending an XML message, then waits for a corresponding XML response.<br>
                    As all communication is in XML, web services are not tied to any one operating system or programming language meaning Java can talk with Perl and Windows applications can talk with Unix applications.<br><i>Source: <a href="https://www.tutorialspoint.com/webservices/what_are_web_services.htm">Tutorials Point</a></i><br><br>
                </p>
                <h2><u>Getting Familiar.</u></h2>
                <p style="text-align: left;">
                    These are some of the technologies involved in consuming a live Web Service:<br><br>
                    <b><u>JDK: </u></b>The Java Development Kit (JDK) is a software development environment used for developing Java applications and applets. It includes the Java Runtime Environment (JRE), an interpreter/loader (java), a compiler (javac), an archiver (jar), a documentation generator (javadoc) and other tools needed in Java development.<br>
                    People new to Java may be confused about whether to use the JRE or the JDK. To run Java applications and applets, simply download the JRE. However, to develop Java applications and applets as well as run them, the JDK is needed.<br><i>Source: <a href="https://www.techopedia.com/definition/5594/java-development-kit-jdk">Techopedia</a> <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">>Download it here<</a></i><br><br>
                    <b><u>NetBeans: </u></b>NetBeans is an open-source integrated development environment (IDE) for developing with Java, PHP, C++, and other programming languages. NetBeans is also referred to as a platform of modular components used for developing Java desktop applications.<br>
                    NetBeans is coded in Java and runs on most operating systems with a Java Virtual Machine (JVM), including Solaris, Mac OS, and Linux.<br><i>Source: <a href="https://www.techopedia.com/definition/24735/netbeans">Techopedia</a> <a href="https://netbeans.org/downloads/">>Download it here<</a></i><br><br>
                    <b><u>SOAP: </u></b>SOAP stands for Simple Object Access Protocol. It is a XML-based protocol for accessing web services. It is platform independent and language independent. By using SOAP, you will be able to interact with other programming language applications.<br><i>Source: <a href="https://www.javatpoint.com/soap-web-services">Java T Point</a></i><br><br>
                    <b><u>WSDL: </u></b>WSDL stands for Web Services Description Language, it's used to describe web services and it's written in XML.<br><i>Source: <a href="https://www.w3schools.com/xml/xml_wsdl.asp">W3Schools</a></i><br><br>
                    <b><u>XML: </u></b>XML stands for eXtensible Markup Language, it's a markup language much like HTML and was designed to store and transport data. It's self-descriptive and it actually doesn't do anything. It's basicaly information wrapped around with tags. Someone must write a piece of software to send, receive, store, or display it.<br><i>Source: <a href="https://www.w3schools.com/xml/xml_whatis.asp">W3Schools</a></i><br>
                </p>
                <h2><u>Step 1: Creating a Java Web Application.</u></h2>
                <p style="text-align: left;">
                    1.1 Open your Netbeans IDE;<br>
                    1.2 Go to File >> New Project >> Java Web >> Web Application;<br>
                    1.3 Click Next, name it HowTo and click Next again;
                </p>
                <p><img src="img/createwebapp.jpg" alt="Create a new web application." width="100%" height="100%"></p>
                <p style="text-align: left;">
                    1.4 Leave the Server and Java Version settings as is;<br>
                    1.5 Context path: /HowTo;<br>
                    1.6 Click Finish;<br>
                </p>
                <p><img src="img/serversettings.jpg" alt="Server settings." width="100%" height="100%"></p>
                <p style="text-align: left;">
                    1.7 Delete the "index.html" file;<br>
                    1.8 Right click the Web Pages node and select New >> JSP..., name it index.jsp.
                </p>
                
                <h2><u>Step 2: Creating a Web Service Client.</u></h2>
                <p style="text-align: left;">
                    2.1 Right click on your project name and select New >> Web Service Client...;<br>
                    2.2 Select WSDL URL and paste the URL to the WSDL file:<br>
                </p>
                <center><b>http://www.webservicex.net/ConvertTemperature.asmx?WSDL</b></center>
                <p style="text-align: left;">
                    2.3 Click Finish.
                </p>
                <p><img src="img/createwebcli.jpg" alt="Create a new Web Service Client." width="100%" height="100%"></p>
                
                <h2><u>Step 3: Creating a Java Class to contain the logic (MVC).</u></h2>
                <p style="text-align: left;">
                    3.1 Right click on the Source Packages node and select New >> Java Class...;<br>
                    3.2 Name the class "ConvertTemperature";<br>
                    3.3 Name the package "converttemperature";<br>
                    3.4 Click Finish.
                </p>
                <p><img src="img/createjavaclass.jpg" alt="Create a new Java Class." width="100%" height="100%"></p>
                
                <h2><u>Step 4: Using the method created from the WSDL file.</u></h2>
                <p style="text-align: left;">
                    4.1 Drill down the Web Service References node to see the methods available;<br>
                    4.2 In this case we have 4 methods: Soap, Soap12, Get and Post;<br>
                    4.3 Drag and drop the method in the folder ConvertTemperatureSoap12 from the menu into the java class.
                </p>
                <p><img src="img/dragmethodsoap12.jpg" alt="Drag chosen method into the java class." width="100%" height="100%"></p>
                
                <h2><u>Step 5: Creating the getters and setters.</u></h2>
                <p style="text-align: left;">
                    5.1 Now we need to do some manual work, create the variables we are gonna need according to the image below;
                </p>
                <p><img src="img/createvariables.jpg" alt="Create the variables needed." width="100%" height="100%"></p>
                <p style="text-align: left;">
                    5.2 Create the Default Constructor as seen in the picture above;<br>
                    5.3 Right click on an empty line underneath the Default Constructor and select Insert Code... >> Getter and Setter...;<br>
                    5.4 Check all the boxes on the window that popped up and click on Generate.
                </p>
                <p><img src="img/gettersandsetters.jpg" alt="Create the Getters and Setters." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    Now your class should look like this:<br><br>
                </p>
                <p style="text-align: left; color: darkgray;">
                    package converttemperature;<br><br>

                    import net.webservicex.TemperatureUnit;<br><br>
                    
                    public class ConvertTemperature {<br><br>

                        
                    &nbsp &nbsp private double temperature;<br>
                    &nbsp &nbsp private TemperatureUnit fromUnit;<br>
                    &nbsp &nbsp private TemperatureUnit toUnit;<br>
                    &nbsp &nbsp private double result;<br><br>

                        &nbsp &nbsp public ConvertTemperature() {<br><br>

                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public double getTemperature() {<br>
                            &nbsp &nbsp &nbsp &nbsp return temperature;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public void setTemperature(double temperature) {<br>
                            &nbsp &nbsp &nbsp &nbsp this.temperature = temperature;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public TemperatureUnit getFromUnit() {<br>
                            &nbsp &nbsp &nbsp &nbsp return fromUnit;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public void setFromUnit(TemperatureUnit fromUnit) {<br>
                            &nbsp &nbsp &nbsp &nbsp this.fromUnit = fromUnit;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public TemperatureUnit getToUnit() {<br>
                            &nbsp &nbsp &nbsp &nbsp return toUnit;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public void setToUnit(TemperatureUnit toUnit) {<br>
                            &nbsp &nbsp &nbsp &nbsp this.toUnit = toUnit;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public double getResult() {<br>
                            &nbsp &nbsp &nbsp &nbsp result = convertTemp(temperature, fromUnit, toUnit);<br>
                            &nbsp &nbsp &nbsp &nbsp return result;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp public void setResult(double result) {<br>
                            &nbsp &nbsp &nbsp &nbsp this.result = result;<br>
                        &nbsp &nbsp }<br><br>

                        &nbsp &nbsp private static double convertTemp(double temperature, net.webservicex.TemperatureUnit fromUnit, net.webservicex.TemperatureUnit toUnit) {<br>
                            &nbsp &nbsp &nbsp &nbsp net.webservicex.ConvertTemperature service = new net.webservicex.ConvertTemperature();<br>
                            &nbsp &nbsp &nbsp &nbsp net.webservicex.ConvertTemperatureSoap port = service.getConvertTemperatureSoap12();<br>
                            &nbsp &nbsp &nbsp &nbsp return port.convertTemp(temperature, fromUnit, toUnit);<br>
                        &nbsp &nbsp }<br><br>
                    }
                </p>
                <h2><u>Step 6: Building your index page.</u></h2>
                <p style="text-align: left;">
                    6.1 Go to the "index.jps" file;<br>
                    6.2 Replace the text between the tags "h1" for <b>Please enter the number you want to convert and select the units you want to use</b>;<br>
                    6.3 Now you're gonna create the form for the user input. Press "Ctrl+Shift+8" to see the Pallet with the form components;
                </p>
                <p><img src="img/palette.jpg" alt="Palette view." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    6.4 Go to the "index.jps" file;<br>
                    6.5 Replace the text between the tags h1 for <b>Please enter the number you want to convert and select the units you want to use</b>;<br>
                    6.6 Now you're gonna create the form for the user input. Press "Ctrl+Shift+8" to see the Pallet with the form components;<br>
                    6.7 Drag and drop <b>Form</b> from the HTML forms section just below the h1 tags;<br>
                    6.8 Set action to "response.jsp" and name to "input form";
                </p>
                <p><img src="img/insertform.jpg" alt="Palette view." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    6.9 Inside the form tags drag and drop <b>Text Input</b> from the HTML forms section, name it "temperatureInput";<br>
                    6.10 Below the text input tags drag and drop a <b>Drop-down List</b>, name it "fromUnit" and set the options 5;<br>
                    6.11 Repeat the step 6.6 and name the new Drop-down list "toUnit" and set the options to 5 again;<br>
                    6.12 To finish, drap and drop a <b>Button</b> below the second Drop-down list, set the label to "Convert" and name it convertbutton;
                </p>
                <p><img src="img/tempinput.jpg" alt="Palette view." width="65%" height="65%"></p>
                <p><img src="img/fromunit.jpg" alt="FromUnit drop-down list." width="65%" height="65%"></p>
                <p><img src="img/tounit.jpg" alt="ToUnit drop-down list." width="65%" height="65%"></p>
                <p><img src="img/convertbutton.jpg" alt="Convert button." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    6.13 Set the value and label of both drop-down list according to the picture below.
                </p>
                <p><img src="img/formcode.jpg" alt="Convert button." width="100%" height="100%"></p>
                <h2><u>Step 7: Building your response page.</u></h2>
                <p style="text-align: left;">
                    7.1 Right click on the Web Pages node of your project select New >> JSP..., name it "response";<br>
                    7.2 Replace the text between the tags "h1" for <b>Result of the Conversion</b>;<br>
                    7.3 Now you need to use a java bean. Drag and drop <b>Use Bean</b> from the JSP section of the Palette just below the h1 tags;<br>
                    7.4 Set ID to "convertBean", Class to "converttemperature.ConvertTemperature" and Scope to "session";
                </p>
                <p><img src="img/usebean.jpg" alt="Use Bean." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    7.5 Next we need to set the property of the 3 inputs we are taking;<br>
                    7.6 Drag and drop <b>Set Bean Property</b> from the JSP section below the Use Bean tag you just created 3 times;<br>
                    7.7 First time: Set Bean Name to "convertBean", Property name to "temperature" leave value blank;<br>
                    7.8 Second time: Set Bean Name to "convertBean", Property name to "fromUnit" leave value blank;<br>
                    7.9 Third time: Set Bean Name to "convertBean", Property name to "toUnit" leave value blank;
                </p>
                <p><img src="img/setbeantemp.jpg" alt="Set Property Bean for Temperature." width="65%" height="65%"></p>
                <p><img src="img/setbeanfrom.jpg" alt="Set Property Bean for FromUnit." width="65%" height="65%"></p>
                <p><img src="img/setbeanto.jpg" alt="Set Property Bean for ToUnit." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    7.10 Next we need to get the property of the result given to us;<br>
                    7.11 Drag and drop <b>Get Bean Property</b> from the JSP section below the last Set Bean Property you just created;<br>
                    7.12 Set Bean Name to "convertBean" and Property name to "result";<br>
                </p>
                <p><img src="img/getbeanresult.jpg" alt="Get Property Bean for Result." width="65%" height="65%"></p>
                <p style="text-align: left;">
                    7.13 Delete the "<b>value=""</b>" property from the code and it should look like the picture below;<br>
                </p>
                <p><img src="img/beancode.jpg" alt="Code example." width="100%" height="100%"></p>
                <p style="text-align: left;">
                    7.14 Save your project and run some tests. Below you will find an example of what you're going to achieve after successfully completing this step-by-step tutorial. Enjoy!
                </p>
                <p><img src="img/arrows.png" alt="Live demonstration below." width="100%" height="100%"></p>
            </div>
            
            <div id="borderdiv">
                <h2>Converting Temperature Web Service Live Demo</h2>
                <div id="conversiondiv">
                    <h4>Please enter the number you want to convert and select the units you want to use.</h4>
                    <form action="response.jsp" method="post">
                        <input type="text" name="temperature" value="" />
                        <select name="fromUnit">
                            <option value="DEGREE_CELSIUS">Celsius</option> Now you're gonna create the form for the user input. Press "Ctrl+Shift+8" to see the Pallet with the form components Now you're gonna create the form for the user input. Press "Ctrl+Shift+8" to see the Pallet with the form components Now you're gonna create the form for the user input. Press "Ctrl+Shift+8" to see the Pallet with the form components
                            <option value="DEGREE_FAHRENHEIT">Fahrenheit</option>
                            <option value="DEGREE_RANKINE">Rankine</option>
                            <option value="DEGREE_REAUMUR">Reaumur</option>
                            <option value="KELVIN">Kelvin</option>
                        </select>
                        <select name="toUnit">
                            <option value="DEGREE_CELSIUS">Celsius</option>
                            <option value="DEGREE_FAHRENHEIT" selected>Fahrenheit</option>
                            <option value="DEGREE_RANKINE">Rankine</option>
                            <option value="DEGREE_REAUMUR">Reaumur</option>
                            <option value="KELVIN">Kelvin</option>
                        </select>
                        <input type="submit" value="Convert!" name="convert" />
                    </form>
                </div>
                </div>
            <br>
            <div id="footer"><h5>Developed by Ennio Vitor and Thieres Pereira <br> CCT College Dublin | 2018</h5></div>
        </div>
    </body>
</html>
