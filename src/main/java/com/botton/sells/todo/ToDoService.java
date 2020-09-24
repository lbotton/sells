package com.botton.sells.todo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
  private ToDoRepository toDoRepository;

  public ToDoService(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  public List<ToDo> findAll() {
    return toDoRepository.findAll();
  }

  public ToDo save(ToDo toDo) {
    return toDoRepository.save(toDo);
  }
}
