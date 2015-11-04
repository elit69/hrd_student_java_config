<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					Search Student <a class="btn pull-right"
						href="${pageContext.request.contextPath}/"><i
						class="fa fa-home fa-2x"></i></a>
				</h1>
				<hr>
				<mvc:form action="${pageContext.request.contextPath}/search"
					method="POST">
					<div class="col-sm-10 center-block">
						<div class="col-sm-9 ">
							<div class="input-group">
								<input type="text" class="form-control" name="keyword"
									placeholder="Search for student ..."> <span
									class="input-group-btn">
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-search"></i> Search
									</button>
								</span>

							</div>
						</div>
						<div class="col-sm-3 ">
							<select class="form-control" name="type">
								<option value="first_name">First Name</option>
								<option value="last_name">Last Name</option>
								<option value="classroom">Classroom</option>
							</select>
						</div>
					</div>
				</mvc:form>
				<c:if test="${fn:length(listResult)>0}">
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr class="info">
									<th>ID</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Classroom</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="stu" items="${listResult}">
									<tr>
										<td><c:out value="${stu.id}" /></td>
										<td><c:out value="${stu.firstname}" /></td>
										<td><c:out value="${stu.lastname}" /></td>
										<td><c:out value="${stu.classroom}" /></td>
										<td><a class="label label-info"
											href="${pageContext.request.contextPath}/show/${stu.id}"
											style="margin-right: 10px;"><i class="fa fa-eye fa-lg"></i>
												Show </a> <a class="label label-primary"
											href="${pageContext.request.contextPath}/update/${stu.id}"
											style="margin-right: 10px;"><i class="fa fa-pencil fa-lg"></i>
												Update </a> <a class="label label-danger"
											href="${pageContext.request.contextPath}/delete/${stu.id}"
											style="margin-right: 10px;"><i
												class="fa fa-trash-o fa-lg"></i> Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>