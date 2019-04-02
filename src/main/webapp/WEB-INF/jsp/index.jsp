<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Gisa investment" />
        <title>BANK USSD DEMO</title>
        <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="shortcut icon" href="../favicon.png">
        <script>
            $(function () {
                $("button").click(function () {
                    var input = document.getElementById("data").value;
                    var data = JSON.stringify({
                        "msisdn": "+250783453253",
                        "agentid": "3",
                        "sessionid": "22",
                        "input": input
                    });
                    //alert("data :" + data);
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "https://ussd-bank-demo.herokuapp.com/api/menu", false);
                    xhr.setRequestHeader("content-type", "application/json");
                    xhr.send(data);
                    var response = JSON.parse(xhr.responseText);
                    document.getElementById("response").innerHTML = response.menu;

                });
            });
        </script>
    </head>

    <body>
        <div class="half dark">
            <div class="iphone-container">
                <div class="phone-shape small">
                    <span class="button-one buttons"></span>
                    <span class="button-two buttons"></span>
                    <span class="button-three buttons"></span>
                    <span class="button-four button last"></span>
                    <div class="top-details">
                        <span class="camera"></span>
                        <span class="circle"></span>
                        <span class="speaker"></span>
                    </div>
                    <div class="phone-screen">
                        <div class="head">BANK USSD DEMO</div>
                        <div class="ussdcontent"> 
                            <% try {%>
                            <div id="output">
                                <center>
                                    <p id="response"></p>
                                </center>
                            </div>
                            <div id="input">
                                <input type="text" name="input" id="data" autocomplete="off" />
                                <button style="background-color: #a0a0a0; /* Green */
                                        border: none;
                                        color: white;
                                        padding: 15px 32px;
                                        text-align: center;
                                        text-decoration: none;
                                        display: inline-block;
                                        font-size: 16px;">Send</button>
                            </div>
                            <%
                                } catch (Exception e) {
                                    out.println("<div id='output'>");
                                    out.println("<center>");
                                    out.println("Error! Please Contact the administrator: info@bank.co.rw");
                                    out.println("</center>");
                                    out.println("</div>");
                                }
                            %> 
                        </div>
                    </div>
                    <div class="circle-button"></div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="/resources/js/scripts.js"></script>
    </body>
</html>