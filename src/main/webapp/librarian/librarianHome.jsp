<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/5/2023
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Boxicons -->
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <!-- My CSS -->
    <link rel="stylesheet" href="/CSS/adminHome.css">

    <title>AdminHub</title>
</head>
<body>


<!-- SIDEBAR -->
<section id="sidebar">
    <a href="/librarian" class="brand">
        <i class='bx bxs-smile'></i>
        <span class="text">LibrarianHome</span>
    </a>
    <ul class="side-menu top">
        <li class="active">
            <a href="/">
                <i class='bx bxs-dashboard' ></i>
                <span class="text">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="/book">
                <i class='bx bxs-book' ></i>
                <span class="text">Book List</span>
            </a>
        </li>
        <li>
            <a href="/customer">
                <i class='bx bxs-group' ></i>
                <span class="text">Customer List</span>
            </a>
        </li>
    </ul>
    <ul class="side-menu">
        <li>
            <a href="/login" class="logout">
                <i class='bx bxs-log-out-circle'></i>
                <span class="text">Logout</span>
            </a>
        </li>
    </ul>
</section>
<!-- SIDEBAR -->



<!-- CONTENT -->
<section id="content">
    <!-- NAVBAR -->
    <nav>
        <a href="#" class="nav-link">Categories</a>
        <form action="#">
            <div class="form-input">
                <input type="search" placeholder="Search...">
                <button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
            </div>
        </form>
        <input type="checkbox" id="switch-mode" hidden>
        <label for="switch-mode" class="switch-mode"></label>
        <a href="#" class="notification">
            <i class='bx bxs-bell' ></i>
            <span class="num">8</span>
        </a>
        <h2>${sessionScope.userName}</h2>
        <a href="#" class="profile">
            <img src="Image/trump-avatar.jpg">
        </a>
    </nav>
    <!-- NAVBAR -->

    <!-- MAIN -->
    <main>
        <div class="head-title">
            <div class="left">
                <h1>Dashboard</h1>
                <ul class="breadcrumb">
                    <li>
                        <a class="active" href="/librarian">Home</a>
                    </li>
                </ul>
            </div>
        </div>

        <ul class="box-info">
            <li>
                <i class='bx bxs-book-open' ></i>
                <span class="text">
						<h3>${total}</h3>
						<p>Total Books</p>
					</span>
            </li>
            <li>
                <i class='bx bxs-group' ></i>
                <span class="text">
						<h3>2834</h3>
						<p>Customers</p>
					</span>
            </li>
            <li>
                <i class='bx bxs-dollar-circle' ></i>
                <span class="text">
						<h3>$2543</h3>
						<p>Total Sales</p>
					</span>
            </li>
        </ul>


        <div class="table-data">
            <div class="order">
                <div class="head">
                    <h3>Recent Books</h3>
                </div>
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Author</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="newBook" items="${newBook}">

                        <tr>
                            <td>${newBook.getName()}</td>
                            <td>${newBook.getCategory()}</td>
                            <td>${newBook.getAuthor()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="todo">
                <div class="head">
                    <h3>Todos</h3>
                    <i class='bx bx-plus' ></i>
                    <i class='bx bx-filter' ></i>
                </div>
                <ul class="todo-list">
                    <li class="completed">
                        <p>Todo List</p>
                        <i class='bx bx-dots-vertical-rounded' ></i>
                    </li>
                    <li class="completed">
                        <p>Todo List</p>
                        <i class='bx bx-dots-vertical-rounded' ></i>
                    </li>
                    <li class="not-completed">
                        <p>Todo List</p>
                        <i class='bx bx-dots-vertical-rounded' ></i>
                    </li>
                    <li class="completed">
                        <p>Todo List</p>
                        <i class='bx bx-dots-vertical-rounded' ></i>
                    </li>
                </ul>
            </div>
        </div>
    </main>
    <!-- MAIN -->
</section>
<!-- CONTENT -->


<script src="script.js"></script>
</body>
</html>
