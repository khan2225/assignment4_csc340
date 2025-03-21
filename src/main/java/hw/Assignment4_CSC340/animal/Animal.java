package hw.Assignment4_CSC340.animal;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "animals")
@Getter
@Setter
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    private String category; //Breed or Type
    private double age;
    private String imageUrl;

    public Animal(int animalId, String name, String description, String category, int age) {
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.age = age;
    }

    public Animal(String name, String description, String category, int age) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.age = age;
    }

    public Animal(){ }

    public int getAnimalId() {
        return animalId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getAge() {
        return age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
