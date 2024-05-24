<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Employee</title>
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
						<p class="fs-3 text-center">Add Employee</p>
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<p class="text-center text-success">${errorMsg}</p>
							<c:remove var="errorMsg" />
						</c:if>
						<form action="saveemployee" method="post">
							<div class="mb-3">
								<label class="form-label">Employee ID</label> <input
									type="number" name="id" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee FullName</label> <input
									type="text" name="fullname" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee Email</label> <input type="email"
									name="email" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee Password</label> <input
									type="password" name="password" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Employee Contact</label> <input
									type="text" name="contact" class="form-control">
							</div>
							
							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>