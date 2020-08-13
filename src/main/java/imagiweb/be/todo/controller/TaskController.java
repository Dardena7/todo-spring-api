package imagiweb.be.todo.controller;

import imagiweb.be.todo.model.Task;
import imagiweb.be.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final Validator validator;
    private Set<ConstraintViolation<Task>> violations;


    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @GetMapping
    public List<Task> getAllTasks()
    {
        return this.taskService.getAllTasks();
    }

    @GetMapping(path = "{id}")
    public Task getAllTasks(@PathVariable("id") String id)
    {
        Optional<Task> task = this.taskService.getTask(id);
        return task.isEmpty() ? null : task.get();
    }

    @PostMapping
    public void addNewTask(@RequestBody Task task)
    {
        this.taskService.addNewTask(task);
    }

    @PutMapping
    public void updateTask(@RequestBody Task task)
    {
        this.taskService.updateTask(task);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTask(@PathVariable("id") String id)
    {
        this.taskService.deleteTask(id);
    }
}
