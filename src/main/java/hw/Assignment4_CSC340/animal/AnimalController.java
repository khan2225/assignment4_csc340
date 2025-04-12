package hw.Assignment4_CSC340.animal;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * AnimalController.java.
 * Handles MVC mappings for the Animal object using Freemarker templates.
 */
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private final AnimalService animalService;

    @Autowired
    private DataSource dataSource;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    /**
     * Test database connection.
     * URL: http://localhost:8080/animals/test-db
     */
    @GetMapping("/test-db")
    @ResponseBody
    public String testDbConnection() throws SQLException {
        return "Connected to: " + dataSource.getConnection().getMetaData().getURL();
    }

    /**
     * Display all Animals.
     * URL: http://localhost:8080/animals/all
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", animalService.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get an Animal by ID.
     * URL: http://localhost:8080/animals/{id}
     */
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        Animal animal = animalService.getAnimalById(animalId);

        if (animal == null) {
            return "error.ftlh";  // Handle missing animal case
        }

        model.addAttribute("title", "Animal Details");
        model.addAttribute("animal", animal);

        return "animal-details";  // Ensure this matches your .ftlh file
    }


    /**
     * Get a list of Animals by category.
     * URL: http://localhost:8080/animals/category/{category}
     */
    @GetMapping("/category/{category}")
    public String getAnimalsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("animalList", animalService.getAnimalsByCategory(category));
        model.addAttribute("title", "Animals in Category: " + category);
        return "animal-list";
    }

    /**
     * Search animals by name.
     * URL: http://localhost:8080/animals/search?name=
     */
    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam(name = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("animalList", animalService.searchByAnimalsByName(name));
        model.addAttribute("title", "Search Results for: " + name);
        return "animal-list";
    }

    /**
     * Show the form for creating a new Animal.
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("title", "Create New Animal");
        return "animal-create";
    }

    /**
     * Handle form submission for creating a new Animal.
     * URL: http://localhost:8080/animals/new
     */
    @PostMapping("/new")
    public String addNewAnimal(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("age") int age,
            @RequestParam("description") String description,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            @RequestParam(value = "imageUrl", required = false) String imageUrl) {

        try {
            Animal animal = new Animal();
            animal.setName(name);
            animal.setCategory(category);
            animal.setAge(age);
            animal.setDescription(description);

            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadedImagePath = animalService.saveImage(imageFile);
                animal.setImageUrl(uploadedImagePath);
            } else if (imageUrl != null && !imageUrl.isEmpty()) {
                animal.setImageUrl(imageUrl);
            }

            animalService.addAnimal(animal);
            return "redirect:/animals/all";

        } catch (IOException e) {
            e.printStackTrace();
            return "error.ftlh";
        }
    }


    /**
     * Show the update form for an Animal.
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        model.addAttribute("title", "Update Animal");
        return "animal-update";
    }

    /**
     * Handle form submission for updating an Animal.
     * URL: http://localhost:8080/animals/update/{id}
     */
    @PostMapping("/update/{id}")
    public String updateAnimal(
            @PathVariable int id,
            @ModelAttribute Animal animal,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            @RequestParam(value = "imageUrl", required = false) String imageUrl) {

        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadedImagePath = animalService.saveImage(imageFile);
                animal.setImageUrl(uploadedImagePath);
            } else if (imageUrl == null || imageUrl.isEmpty()) {
                animal.setImageUrl("default-image.jpg");
            }

            animalService.updateAnimal(id, animal);
            return "redirect:/animals/" + id;
        } catch (IOException e) {
            e.printStackTrace();
            return "error.ftlh";
        }
    }

    /**
     * Delete an Animal.
     * URL: http://localhost:8080/animals/delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable int id) {
        boolean isDeleted = animalService.deleteAnimal(id);

        if (!isDeleted) {
            System.out.println("Animal with ID " + id + " not found for deletion.");
        }
            return "redirect:/animals/all";
    }


    /**
     * Save an Animal.
     */
    @PostMapping("/save")
    public String saveAnimal(@ModelAttribute Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals/all";
    }

}
