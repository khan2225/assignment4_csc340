<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Animal List</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>

<!-- Navbar with Home Button -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #FF9900;">
    <a class="navbar-brand" href="#">Search All Animals</a>
    <div class="ms-auto">
        <a href="/animals/all" class="btn btn-light">Home</a>
    </div>
</nav>

<!-- Container for Animal List -->
<div class="container mt-4">
    <h1 class="text-center">${title}</h1>

    <!-- Search Form -->
    <form action="/animals/search" method="get" class="text-center mb-3">
        <input type="text" name="name" placeholder="Search By Name..." class="form-control w-50 d-inline">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <!-- Create New Animal Button -->
    <div class="text-center mb-3">
        <a href="/animals/createForm" class="btn btn-success">Create New Animal</a>
    </div>

    <!-- Animal Table -->
    <table class="table table-striped mt-4">
        <thead>
        <tr>
            <th>ID</th>
            <th>Image</th>
            <th>Name</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list animalList as animal>
        <tr>
            <td>${animal.animalId?c}</td>
            <td>
                <img src="${animal.imageUrl?default('/static/images/default.jpg')}"
                     alt="${animal.name}" style="width: 50px; height: 50px;">
            </td>
            <td>${animal.name}</td>
            <td>
                <a href="/animals/category/${animal.category}" style="color:#000000">
                    ${animal.category}
                </a>
            </td>
            <td>
                <a href="/animals/${animal.animalId?c}" class="btn btn-info btn-sm">Details</a>
                <a href="/animals/update/${animal.animalId?c}" class="btn btn-warning btn-sm">Update</a>
                <form action="/animals/delete/${animal.animalId?c}" method="post" style="display:inline;">
                    <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this animal?')">Delete</button>
                </form>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

    <!-- Go Back Button -->
    <div class="text-center mt-3">
        <a href="/animals/all" class="btn btn-secondary">Go Back</a>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        document.querySelectorAll(".delete-btn").forEach(button => {
            button.addEventListener("click", function () {
                const animalId = this.getAttribute("data-id");

                if (confirm("Are you sure you want to delete this animal?")) {
                    //Redirect to delete endpoint (GET)
                    window.location.href = `/animals/delete/${animal.animalId}`;
                }
            });
        });
    });
</script>




<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
