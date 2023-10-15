<!DOCTYPE html>
<html>
<head>
    <title>Add Tasks to a Tasks List</title>
</head>
<body>
	<div class="container">
    <h1>Add New Car</h1>
    <form action="addCarServlet" method="post" class="mt-5">
		
		<div class="form-group">
        	<label for="title">Make:</label>
        	<input type="text" class="form-control" id="title" name="title" required><br><br>
        </div>
        
        <div class="form-group">
        	<label for="description">Model:</label>
        	<textarea class="form-control" id="description" name="description" rows="4" cols="50" required></textarea><br><br>
        </div>
        
        <div class="form-group">
        	<label for="status">Owner:</label>
        	<textarea class="form-control" id="owner" name="owner" rows="4" required></textarea><br><br>
        </div>
        
        <input type="submit" value="Add Car">
    </form>
    <br>
    <a href="viewAllCarsServlet">View List</a>
    </div>

</body>
</html>