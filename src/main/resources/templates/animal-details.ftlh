<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Animal Details</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #FF9900;">
    <a class="navbar-brand" href="/animals/all">Animal List</a>
    <div class="ms-auto">
        <a href="/animals/all" class="btn btn-light">Home</a>
        <a href="/animals/createForm" class="btn btn-success">Add New Animal</a>
    </div>
</nav>

<!-- Animal Details Container -->
<div class="container mt-4">
    <h1 class="text-center">${title}</h1>

    <div class="card">
        <div class="card-header text-center">
            <h2>${animal.name}</h2>
        </div>
        <div class="card-body text-center">
            <img src="${animal.imageUrl?default('/static/images/default.jpg')}" class="img-fluid" alt="Animal Image" style="max-width: 300px;">
            <p><strong>Category:</strong> ${animal.category}</p>
            <p><strong>Age:</strong> ${animal.age} years</p>
            <p><strong>Description:</strong> ${animal.description}</p>

            <div class="mt-3">
                <a href="/animals/update/${animal.animalId?c}" class="btn btn-warning">Edit</a>
                <a href="#" class="btn btn-danger delete-btn" data-id="${animal.animalId?c}" data-bs-toggle="modal" data-bs-target="#deleteModal">Delete</a>
                <a href="/animals/all" class="btn btn-secondary">Back</a>
            </div>
        </div>
    </div>
</div>

<!-- Delete Confirmation Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Confirm Deletion</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete this animal?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <a href="#" id="confirm-delete" class="btn btn-danger">Yes, Delete</a>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        document.querySelectorAll(".delete-btn").forEach(button => {
            button.addEventListener("click", function () {
                const animalId = this.getAttribute("data-id");
                document.getElementById("confirm-delete").href = `/animals/delete/${animalId}`;
            });
        });
    });
</script>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
