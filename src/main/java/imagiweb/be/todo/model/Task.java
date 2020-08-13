package imagiweb.be.todo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "tasks")
public class Task {

    @Id
    private String _id;
    @NotBlank(message="Name cannot be empty") @Size(max = 20, message = "Name cannot exceed 20 characters")
    private String name;
    @Size(min= 10, max = 200, message = "Description must be between 10 and 200 characters")
    private String description;
    @NotNull
    private String imagePath;
    private boolean isDone;

    public Task(String name,
                String description,
                String imagePath,
                boolean isDone)
    {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isDone() {
        return isDone;
    }

    public String get_id() {
        return _id;
    }

}
