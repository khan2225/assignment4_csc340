package hw.Assignment4_CSC340.animal;

import hw.Assignment4_CSC340.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions for the Animal entity.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    /**
     * Get all animals by category.
     * @param category the category of the animal.
     * @return a list of animals belonging to the given category.
     */
    List<Animal> getAnimalsByCategory(String category);

    /**
     * Search for animals by name (case insensitive).
     * @param name the name or partial name of the animal.
     * @return a list of matching animals.
     */
    @Query(value = "SELECT * FROM animals a WHERE a.name LIKE %?1%", nativeQuery = true)
    List<Animal> getAnimalsByName(String name);
}
