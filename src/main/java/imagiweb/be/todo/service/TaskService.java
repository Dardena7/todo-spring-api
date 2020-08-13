package imagiweb.be.todo.service;

import imagiweb.be.todo.db.TaskRepository;
import imagiweb.be.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks()
    {
        return this.taskRepository.findAll();
    }

    public Optional<Task> getTask(String id)
    {
        return this.taskRepository.findById(id);
    }

    public void addNewTask(Task task)
    {
        this.taskRepository.save(task);
    }

    public void updateTask(Task task)
    {
        this.taskRepository.save(task);
    }

    public void deleteTask(String id)
    {
        this.taskRepository.deleteById(id);
    }
}
