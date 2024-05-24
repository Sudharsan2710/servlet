<%@page import="com.chainsys.registration.model.Employee"%>
<%@page import="com.chainsys.registration.DAO.EmployeeDao"%>
<%@page import="com.chainsys.registration.controller.insertEmployeeServlet"%>
<%@page import="com.chainsys.registration.controller.deleteEmployeeServlet"%>
<%@page import="com.chainsys.registration.controller.updateEmployeeServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee management Application</title>
<style>

 body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 20px auto;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        overflow: hidden;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 12px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    .btn-container {
        display: flex;
        background-color:yellow
    }
    .btn {
        padding: 8px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        margin-right: 8px;
    }
    .btn-delete {
        background-color: #ff3333;
        color: white;
    }
    .btn-delete:hover {
        background-color: #cc0000;
    }
    .btn-edit {
        background-color: #00cc44;
        color: white;
    }
    .btn-edit:hover {
        background-color: #009933;
    }
    h4{
        display: inline;
        margin-left: 75%;
    }
    
</style>
</head>
<body  class="bg-light">
	<%@ include file="navbar.jsp"%>

	<div class="container p-5">
		<div class="card">

			<div class="card-body">
				<p class="text-center fs-2">Employee Management System</p>
				<c:if test="${not empty succMsg}">
					<p class="text-center text-success">${succMsg}</p>
					<c:remove var="succMsg" />
				</c:if>

				<c:if test="${not empty errorMsg}">
					<p class="text-center text-success">${errorMsg}</p>
					<c:remove var="errorMsg" />
				</c:if>
				<table class="table text-center">
					<thead>
						<tr class="fs-5">
							<th scope="col">Id</th>
							<th scope="col">Employee Name</th>
							<th scope="col">Email</th>
							<th scope="col">Password</th>
							<th scope="col">Contact</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
							EmployeeDao employeedao = new EmployeeDao();
						
						List<Employee> list = EmployeeDao.getAllEmployees();;
							
							for (Employee emp : list) {
						%>
						<tr>
							<th scope="row"><%=emp.getFullname()%></th>
							<td><%=emp.getEmail()%></td>
							<td><%=emp.getPassword()%></td>
							<td><%=emp.getContact()%></td>
							
							<td>
								<a href="updatemployee.jsp?id=<%=emp.getId()%>" class="btn btn-sm btn-dark">Update</a>
								<input type ="hidden" name="action" value="Delete">
								
								<a href="deleteemployee?id=<%=emp.getId()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>



		

</body>
</html>