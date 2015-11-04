<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="Chhorn Elit">
<meta lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS Library -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/lib/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/lib/font-awesome-4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/lib/bootstrap-select.min.css">
<!-- End CSS Library -->

<!-- Custom StyleSheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/index.css">
<!-- End Custom StyleSheet -->
</head>
<body>
	<div id="main" class="container-fluid">
		<div class="row col-sm-11 center-block">
			<div class="col-sm-12 card form-horizontal">
				<h1>
					Update Student <a class="btn pull-right"
						href="${pageContext.request.contextPath}/"><i
						class="fa fa-home fa-2x"></i></a>
				</h1>
				<hr>
				<mvc:form action="${pageContext.request.contextPath}/update"
					method="POST">
					<div class="col-sm-12 ">
						<div class="col-sm-8 center-block" style="margin-bottom: 40px;">
							<div class="form-group">
								<label class="col-sm-3">ID:</label>
								<div class="col-sm-9">
									<input type="number" class="form-control" maxlength="100"
										name="id" value="${stu.id}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3">First Name:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" maxlength="100"
										name="firstname" placeholder="Enter First Name"
										value="${stu.firstname}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3">Last Name:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" maxlength="100"
										name="lastname" placeholder="Enter Last Name"
										value="${stu.lastname}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3">Classroom: </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" maxlength="50"
										name="classroom" placeholder="Enter Classroom"
										value="${stu.classroom}">
								</div>
							</div>
						</div>
						<div class="col-sm-6 center-block">
							<button type="submit" id="btnAdd" class="btn btn-primary"
								style="width: 200px;">
								<i class="fa fa-pencil"></i>&nbsp;&nbsp;Update
							</button>
							<button type="reset" id="btnClear"
								class="btn btn-primary pull-right" style="width: 200px;">
								<i class="fa fa-times-circle"></i>&nbsp;&nbsp;Clear
							</button>
						</div>
					</div>
				</mvc:form>
			</div>
		</div>
	</div>
</body>
</html>