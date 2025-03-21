<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Update Animal</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #799351;">
    <a class="navbar-brand" href="#">Update Animal</a>
</nav>

<!-- Update Form -->
<div class="container mt-4">
    <h1 class="text-center">Update Animal</h1>

    <form action="/animals/update/${animal.animalId}" method="post" enctype="multipart/form-data" class="mb-3">
        <input type="hidden" name="animalId" value="${animal.animalId?c}"/>

        <label for="name">Animal Name</label>
        <input type="text" id="name" name="name" class="form-control mb-2" value="${animal.name}" required/>

        <label for="category">Category</label>
        <input type="text" id="category" name="category" class="form-control mb-2" value="${animal.category}" required/>

        <label for="age">Age</label>
        <input type="number" id="age" name="age" class="form-control mb-2" value="${animal.age}" required/>

        <label for="description">Description</label>
        <textarea id="description" name="description" class="form-control mb-2" required>${animal.description}</textarea>


        <!-- Display Current Image -->
        <label for="currentImage">Current Image:</label>
        <img id="currentImage" src="${animal.imageUrl?default('/static/images/default.jpg')}"
             class="img-fluid mb-2" style="max-width: 150px; display: block;">

        <!-- Update Image -->
        <label for="imageUrl">Update Image URL (Optional)</label>
        <input type="text" id="imageUrl" name="imageUrl" class="form-control mb-2" placeholder="Paste an Image URL"/>

        <label for="imageFile">Or Upload New Image</label>
        <input type="file" id="imageFile" name="imageFile" class="form-control mb-2"/>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/animals/all" class="btn btn-danger">Cancel</a>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
