package com.kgfsl.fixme.controller;
import com.kgfsl.fixme.service.TodoService;
import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.repository.TodoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
@RequestMapping("/todolist")
public class TodoController {
	@Autowired
	private TodoService todoService;
	private long todoId;

@GetMapping("/get")public @ResponseBody ResponseEntity<List<Todo>> findall() {
return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
}
/*
@GetMapping("/get")public @ResponseBody ResponseEntity<Todo> findOne() {
return new ResponseEntity<>(todoService.findOne(todoId), HttpStatus.OK);
}*/

@PostMapping("/post")public ResponseEntity<?> post(@RequestBody Todo todo, UriComponentsBuilder ucBuilder) {
todoService.saveTodo(todo);
HttpHeaders headers = new HttpHeaders();
headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(todo.getId()).toUri());
return new ResponseEntity<>(headers, HttpStatus.CREATED);

}

@DeleteMapping("/delete/{todoId}")
public ResponseEntity<?> delete(@PathVariable Long eventId) {
//Event currentevent = eventService.find(eventId);
todoService.delete(todoId);
return new ResponseEntity<>(HttpStatus.OK);
}

}
