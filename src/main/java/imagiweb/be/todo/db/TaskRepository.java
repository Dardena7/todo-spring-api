package imagiweb.be.todo.db;

import imagiweb.be.todo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

}
