<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="style.css">
</head>

<body class="with-overlay">

<div class="menu-wrapper">

    <h1 class="menu-title">🌿 Ivory Leaf Menu</h1>

    <form action="order" method="post">

        <div class="menu-grid">

            <!-- Dosa -->
            <div class="menu-card">
                <img src="images/dosa.jpeg">
                <h3>Dosa</h3>
                <p>₹50</p>
                <input type="checkbox" name="item" value="Dosa" onchange="updateQty(this, 'qty1')">
                <input type="number" id="qty1" name="qty1" min="0" value="0">
            </div>

            <!-- Idli -->
            <div class="menu-card">
                <img src="images/idli.jpeg">
                <h3>Idli</h3>
                <p>₹30</p>
                <input type="checkbox" name="item" value="Idli" onchange="updateQty(this, 'qty2')">
                <input type="number" id="qty2" name="qty2" min="0" value="0">
            </div>

            <!-- Vada -->
            <div class="menu-card">
                <img src="images/vada.jpeg">
                <h3>Vada</h3>
                <p>₹25</p>
                <input type="checkbox" name="item" value="Vada" onchange="updateQty(this, 'qty3')">
                <input type="number" id="qty3" name="qty3" min="0" value="0">
            </div>

            <!-- Upma -->
            <div class="menu-card">
                <img src="images/upma.jpeg">
                <h3>Upma</h3>
                <p>₹40</p>
                <input type="checkbox" name="item" value="Upma" onchange="updateQty(this, 'qty5')">
                <input type="number" id="qty5" name="qty5" min="0" value="0">
            </div>

            <!-- Coffee -->
            <div class="menu-card">
                <img src="images/coffee.jpeg">
                <h3>Coffee</h3>
                <p>₹15</p>
                <input type="checkbox" name="item" value="Coffee" onchange="updateQty(this, 'qty4')">
                <input type="number" id="qty4" name="qty4" min="0" value="0">
            </div>

            <!-- Tea -->
            <div class="menu-card">
                <img src="images/tea.jpeg">
                <h3>Tea</h3>
                <p>₹10</p>
                <input type="checkbox" name="item" value="Tea" onchange="updateQty(this, 'qty6')">
                <input type="number" id="qty6" name="qty6" min="0" value="0">
            </div>

        </div>

        <div class="order-box">
            <input type="submit" value="Place Order">
        </div>

    </form>

</div>

<!-- 🔥 JavaScript -->
<script>
function updateQty(checkbox, qtyId) {
    let qtyInput = document.getElementById(qtyId);

    if (checkbox.checked) {
        if (qtyInput.value == 0) {
            qtyInput.value = 1;
        }
    } else {
        qtyInput.value = 0;
    }
}
</script>

</body>
</html>