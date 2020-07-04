<html>
<head>
	<title>HibernateWeb login page</title>
	<script>
		function clearForm(){
			var username = document.getElementById("txtUsername").value='';
			var password = document.getElementById("txtPassword").value='';
		}
	</script>
</head>
<body>
<h2>Hello World!</h2>

	<form action="login" method="post">
		<table align="center">
			<tr>
				<td>
					<input type="text" id="txtUsername" name="txtUsername"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="txtPassword" name="txtPassword"/>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								<input type="submit" id="btnSubmit" name="btnSubmit"/>
							</td>
							<td>
								<input type="button" id="btnClear" name="btnClear" value="Clear" onclick="clearForm();"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		
		
		</table>
	
	</form>
</body>
</html>
