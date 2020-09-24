package com.botton.sells;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.botton.sells.todo.ToDo;
import com.botton.sells.todo.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ToDoControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private ToDoService toDoService;


  @Test
  void getAllToDos() throws Exception {
    List<ToDo> toDoList = new ArrayList<ToDo>();
    toDoList.add(new ToDo(1L, "Eat thrice", true));
    toDoList.add(new ToDo(2L, "Seep Twice", true));
    when(toDoService.findAll()).thenReturn(toDoList);

    mockMvc.perform(MockMvcRequestBuilders.get("/todos").contentType(MediaType.APPLICATION_JSON))
        .andExpect((ResultMatcher) jsonPath("$")).andDo(print());
  }

  @Test
  void successfullyCreateAToDo() throws Exception {
    ToDo eatToDo = new ToDo(1L, "Eat thrice", true);
    when(toDoService.save(eatToDo)).thenReturn(eatToDo);
    ObjectMapper objectMapper = new ObjectMapper();
    String eatToDoJSON = objectMapper.writeValueAsString(eatToDo);

    ResultActions result = mockMvc
        .perform(post("/todos").contentType(MediaType.APPLICATION_JSON).content(eatToDoJSON));

    result.andExpect(status().isCreated()).andExpect(jsonPath("$.text").value("Eat thrice"))
        .andExpect(jsonPath("$.completed").value(true));
  }
}
