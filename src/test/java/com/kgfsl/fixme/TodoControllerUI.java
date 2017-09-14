package com.kgfsl.fixme;
import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.repository.TodoRepository;
import com.kgfsl.fixme.service.*;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.*;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kgfsl.fixme.model.*;





@RunWith(MockitoJUnitRunner.class)

public class TodoControllerUI
{
  @Mock
    private TodoRepository todoRepository;
 
@InjectMocks 
   private TodoControllerUI todocontroller;

    TodoComn c=new TodoComn();

	private Long TODO_ID;

//private Object todo_ID;
   
   
@Test
public void TodoTest() {
    when(todoRepository.findAll()).thenReturn(c.testmethod());
    List<Todo> result=todocontroller.findAll();
    assertEquals(2, result.size());
}
private List<Todo> findAll() {
	return todoRepository.findAll();
}

/*@Test
public void Todotest() {
    when(todoRepository.saveTodo()).thenReturn(c.testmethod());
   
  List<Todo> result=todocontroller.saveTodo();
  assertEquals(2, result.size());
}
private List<Todo> saveTodo() {

	return todoRepository.saveTodo();

}*/

 @Test
    public void Deletetest() {
       todoRepository.delete(TODO_ID);

        verify(todoRepository).delete(TODO_ID);
}
   
/*@Test
public void TodofindoneTest() {
    when(todoRepository.findOne()).thenReturn(c.testmethod());
    List<Todo> result=todocontroller.findOne();
//verify(todoRepository).findOne(TODO_ID);
}
private List<Todo> findOne() {
	return todoRepository.findOne();
}*/

}