package hw.Assignment4_CSC340.animal;

import hw.Assignment4_CSC340.animal.Animal;
import hw.Assignment4_CSC340.animal.AnimalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * AnimalService.java
 * Centralizes data access to the Animal Database.
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Folder where uploaded images will be stored
    private final String UPLOAD_DIR = "src/main/resources/static/images/";

    /**
     * Fetch all animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique animal by ID.
     *
     * @param animalId the unique Animal ID.
     * @return an Animal object if found, otherwise null.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals whose category matches the search term.
     *
     * @param category the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByCategory(String category) {
        return animalRepository.getAnimalsByCategory(category);
    }

    /**
     * Fetch all animals with a name that contains the given string.
     *
     * @param name the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> searchByAnimalsByName(String name) {
        return animalRepository.getAnimalsByName(name);
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    @Transactional
    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId      the unique Animal ID.
     * @param animalDetails the updated Animal details.
     */
    public void updateAnimal(int animalId, Animal animalDetails) {
        Animal existing = getAnimalById(animalId);
        if (existing != null) {
            existing.setName(animalDetails.getName());
            existing.setDescription(animalDetails.getDescription());
            existing.setCategory(animalDetails.getCategory());
            existing.setAge(animalDetails.getAge());
            existing.setImageUrl(animalDetails.getImageUrl());


            // Save updated entity
            animalRepository.save(existing);
        }
    }

    /**
     * Delete an Animal from the database.
     *
     * @param id the unique Animal ID.
     */
    public boolean deleteAnimal(int id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true; // Animal was deleted
        }
        return false; // Animal not found
    }


    /**
     *
     * @param file in which the image was uploaded.
     *
     * @return the image that the user uploaded.
     *
     * @throws IOException if the file is empty.
     */
    public String saveImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Save the file
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return "/static/images/" + fileName; // Return relative path for display in HTML
    }

    public Animal saveAnimal(Animal animal){
        return animalRepository.save(animal);
    }
}
