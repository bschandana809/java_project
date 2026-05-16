<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Bill</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
<body class="with-overlay">

<div class="bill-container">

    <h2>🧾 Order Summary</h2>

    <hr>

    <%
        String billDetails = (String) request.getAttribute("billDetails");
        Integer total = (Integer) request.getAttribute("total");
    %>

    <div class="bill-details">
        <p><%= billDetails %></p>
    </div>

    <hr>

    <h3>Total Amount: ₹ <%= total %></h3>

    <form action="confirm" method="post">

        <input type="hidden" name="billDetails" value="<%= billDetails %>">
        <input type="hidden" name="total" value="<%= total %>">

        <button type="submit">Confirm Order</button>

    </form>

</div>

</body>
</html>