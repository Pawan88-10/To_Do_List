<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity_classes.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="todolist.css">
<title>To Do List</title>
</head>
<body>
	<section>
		<header>
			<h1>TO DO List Website Using Hibernate</h1>
		</header>
		<h1 class="head">ToDo List</h1>

		<form action="todolist" method="post" autocomplete="off" validated>
			<div class="repetition">
				<div>
					<label for="task">Task</label><br> 
					<input class="task" type="text" name="task" placeholder="create a task">
				</div>
				<div>
					<label for="Assignee">Assignee</label><br> 
					<input type="text" name="assignee" placeholder="Assignee">
				</div>
			</div>
			<label for="status" class="stau">Status</label><br> 
			<input list="browser" name="status" class="status" placeholder="To be done"><br>
			<datalist id="browser">
				<option value="completed"></option>
				<option value="not done"></option>
				<option value="to be continued"></option>
				<option value="sparrow on station"></option>
			</datalist>
			<button type="submit">Submit</button>
		</form>
		
		<div class="view" >
			<h1>Tasks</h1>
			<table border="1" cellspacing="0">
				<tr class="head">
					<th>Task Id</th>
					<th>Task Name</th>
					<th>Assignee</th>
					<th colspan="3">Status</th>
				</tr>
				<%
				// Assuming tasks is a List<Task> retrieved from the database
				List<Task> tasks = (List<Task>) request.getAttribute("tasks");
				%>
				<%
				if (tasks != null && !tasks.isEmpty()) {
					for (Task task : tasks) {
				%>
				<tr>
					<td><%=task.getId()%></td>
					<td><%=task.getName()%></td>
					<td><%=task.getAssignee()%></td>
					<td><%=task.getStatus()%></td>
					<td class="completed">
					<a class="edit" href="edit?id=<%= task.getId() %>">Edit</a> 
					<a href="delete?id=<%= task.getId()%>">Delete</a>
					</td>
				</tr>
				<%
				}
				}
				/*  else {*/
				%>
				<!-- 
				<tr>
					<td colspan="5">No tasks found.</td>
				</tr> -->
				<%
				/* } */
				%>

			</table>
		</div>
	</section>
	
	<script type="text/javascript">
	let form = document.getElementByTagNames("Form");
	
	</script>
</body>
</html>
