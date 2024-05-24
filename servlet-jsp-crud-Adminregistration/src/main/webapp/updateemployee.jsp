<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.chainsys.registration.model.Employee"%>
<%@page import="com.chainsys.registration.DAO.EmployeeDao"%>
<%@page
	import="com.chainsys.registration.controller.insertEmployeeServlet"%>
<%@page
	import="com.chainsys.registration.controller.deleteEmployeeServlet"%>
<%@page
	import="com.chainsys.registration.controller.updateEmployeeServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="css.jsp"%>
<title>Insert title here</title>
<%@ include file="css.jsp" %>
</head>
<body>
	class="bg-light">

	<%@ include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Update student</p>

						<%
							int id = Integer.parseInt(request.getParameter("id"));
								EmployeeDao.connectDB();
							
							Employee emp = new Employee();
							
						 		
						%>

						<form action="updatestudent" method="post">
							<div class="mb-3">
								<label class="form-label">Employee Id</label> <input type="text"
									name="id" class="form-control" value="<%=emp.getId()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee FullName</label> <input
									type="text" name="fullname" class="form-control"
									value="<%=emp.getFullname()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee Email</label> <input
									type="email" name="email" class="form-control"
									value="<%=emp.getEmail()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee Password</label> <input
									type="text" name="password" class="form-control"
									value="<%=emp.getPassword()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee Contact</label> <input
									type="text" name="qualification" class="form-control"
									value="<%=emp.getContact()%>">
							</div>


							<!-- hidden input -->
							<input type="hidden" name="id" value="<%= emp.getId() %>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>