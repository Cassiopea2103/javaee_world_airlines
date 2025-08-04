<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>World Adventures Airline</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/home.css">
</head>
<body>
<header class="site-header">
    <div class="logo">🌍 World Adventures Airline</div>
    <nav>
        <a href="#">Book a Flight</a>
        <a href="#">Destinations</a>
        <a href="#services">Offers</a>
        <a href="#contact">Contact</a>
    </nav>
</header>

<div class="hero">
    <h1>Adventure Starts in the Sky</h1>
    <p>Fly with comfort, speed, and style. Discover new destinations with World Adventures Airline.</p>
    <a class="cta-button" href="#">Book Now</a>
</div>

<div class="content">
    <section>
        <h2>🌐 Top Destinations</h2>
        <ul>
            <li>Bali, Indonesia – Island paradise with unmatched beauty</li>
            <li>New York City, USA – Where dreams never sleep</li>
            <li>Dakar, Senegal – Culture, coastlines, and color</li>
            <li>Sydney, Australia – Harbour adventures await</li>
        </ul>
    </section>

    <section id="services">
        <h2>🛫 Travel Services</h2>
        <ul>
            <li>24/7 Online Booking</li>
            <li>Check-in via Mobile App</li>
            <li>Airport Lounge Access</li>
            <li>Flexible Ticket Options</li>
        </ul>
    </section>

    <section id="contact">
        <h2>📞 Customer Support</h2>
        <p>Email: support@worldadventures.com</p>
        <p>Phone: +221 33 123 45 67</p>
    </section>
</div>

<footer>
    <p>&copy; <%= java.time.Year.now() %> World Adventures Airline. All rights reserved.</p>
    <a class="cta-button" href="<%= request.getContextPath() %>/PassengersController">Admin dashboard</a>
</footer>
</body>
</html>
