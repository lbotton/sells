package com.botton.sells;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.botton.sells.todo.ToDo;
import com.botton.sells.todo.ToDoRepository;
import com.botton.sells.todo.ToDoService;

@SpringBootTest
public class ToDoServiceTest {

  @Autowired
  private ToDoRepository toDoRepository;

  @AfterEach
  void tearDown() {
    toDoRepository.deleteAll();
  }

  @Test
  void getAllToDos() {
    ToDo todoSample = new ToDo("Todo Sample 1", true);
    toDoRepository.save(todoSample);
    ToDoService toDoService = new ToDoService(toDoRepository);

    List<ToDo> toDoList = toDoService.findAll();
    ToDo lastToDo = toDoList.get(toDoList.size() - 1);

    assertEquals(todoSample.getText(), lastToDo.getText());
    assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
    assertEquals(todoSample.getId(), lastToDo.getId());
  }

  @Test
  void saveAToDo() {
    ToDoService toDoService = new ToDoService(toDoRepository);
    ToDo todoSample = new ToDo("Todo Sample 1", true);

    toDoService.save(todoSample);

    assertEquals(1.0, toDoRepository.count());
  }
}
