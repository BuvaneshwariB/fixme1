package com.kgfsl.fixme; 
import com.kgfsl.fixme.TodoBuilder;
import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.repository.TodoRepository;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.matcher.ResponseAwareMatcher;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.RestAssured;
import java.util.ArrayList;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static com.jayway.restassured.RestAssured.when;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.kgfsl.fixme") 
@SpringBootTest(classes = FixmeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")

  public class TodoIntegration {
      private static final String NAME_FIELD = " Todo";
	private static final String TODO_RESOURCE = "/todolist";
	private static final String name="cook";
    private static final String status="completed";
	private static final String priority="first";
    private static final Boolean iscompleted=true;


private static final Todo first=new TodoBuilder().name("cook").status("completed").priority("first").iscompleted(true).build();
private static final Todo second=new TodoBuilder().name("study").status("completed").priority("third").iscompleted(true).build();
private static final Todo third=new TodoBuilder().name("movie").status("completed").priority("second").iscompleted(false).build();

 @Autowired
	private TodoRepository todorepository;



	@Value("${local.server.port}")
	private int serverPort;
	private Todo firstTodo;
	private Todo secondTodo;
	private Todo thirdTodo;


	@Before
	public void setUp() {
		todorepository.deleteAll();
		firstTodo = todorepository.save(first);
		secondTodo= todorepository.save(second);
        thirdTodo=todorepository.save(third);
		RestAssured.port = serverPort;
	}
    @Test
	public void addTodoShouldReturnSavedTodo() {
	given().body(third).contentType(ContentType.JSON).when().post(TODO_RESOURCE);
		System.out.println("addtodoShouldReturnSavedtodo completed !!!");
	}
  }
  
    /*  @Test
    
    public void getTodoShouldReturnBothTodo() {
        when().get(TODO_RESOURCE).then().statusCode(HttpStatus.SC_OK).body(NAME_FIELD,
                hasTodos(name,name));
    }

    private ResponseAwareMatcher<Response> hasTodos(String name2, String name3) {
			return null;
	}*/
	/*@Test
    //DELETE
    public void deleteTodoShouldReturnNoContent() {
        when().delete(TODO_RESOURCE,secondTodo.getId()).then().statusCode(HttpStatus.SC_OK);
    }*/

  
	
	
	


	
   


	
    
  










