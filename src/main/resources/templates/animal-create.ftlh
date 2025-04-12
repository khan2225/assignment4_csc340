<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <title>Add Animal</title>
  <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #FF9900;">
  <a class="navbar-brand" href="#">Add New Animal</a>
  <div class="ms-auto">
    <a href="/animals/all" class="btn btn-light">Home</a>
  </div>
</nav>

<!-- Add Animal Form -->
<div class="container mt-4">
  <h1 class="text-center">Add New Animal</h1>

  <form action="http://localhost:8080/animals/new" method="post" enctype="multipart/form-data">
  <input type="text" id="name" name="name" class="form-control mb-2" placeholder="Animal Name" required/>
    <input type="text" id="category" name="category" class="form-control mb-2" placeholder="Category" required/>
    <input type="number" id="age" name="age" class="form-control mb-2" placeholder="Age" required/>
    <textarea id="description" name="description" class="form-control mb-2" placeholder="Description" required></textarea>


    <!-- Image Upload (User chooses between URL or File Upload) -->
    <label for="imageUrl">Image URL (Optional)</label>
    <input type="text" id="imageUrl" name="imageUrl" class="form-control mb-2" placeholder="Paste an Image URL"/>

    <label for="imageFile">Or Upload Image from Computer</label>
    <input type="file" id="imageFile" name="imageFile" class="form-control mb-2"/>

    <button type="submit" class="btn btn-success">Save Animal</button>
    <a href="/animals/all" class="btn btn-danger">Cancel</a>
  </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>