<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Order Success</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
<body class="with-overlay">

<div class="success-box">

    <h2>✅ Order Confirmed!</h2>

    <p>Your Token Number</p>

    <div class="token">
        <%= request.getAttribute("orderId") %>
    </div>

    <p>Total : ₹ <%= request.getAttribute("total") %></p>

    <br>

    <a href="index.jsp">
        <button>Back to Home</button>
    </a>

</div>

</body>
</html>