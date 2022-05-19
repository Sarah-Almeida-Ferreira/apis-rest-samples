package org.serratec.projeto02.controllers;

import java.util.List;

import org.serratec.projeto02.model.Todo;
import org.serratec.projeto02.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Todo>> listarTodos(){
		
		return new ResponseEntity<>(todoService.listarTodos(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable Integer id){
		
		if(todoService.getTodo(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(todoService.getTodo(id),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createTodo(@RequestBody Todo todo) {
		
		todoService.createTodo(todo.getTitulo(), todo.getDescricao());
		
		return new ResponseEntity<>("To-do criado!", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
		
		if (todoService.getTodo(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(todoService.updateTodo(id, todo.getTitulo(), todo.getDescricao()),
					HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
		if (todoService.deleteTodo(id) == false) {
			return new ResponseEntity<>("Nenhum To-do com id " + id + " encontrado para exclusão!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("To-do excluído!", HttpStatus.OK);
	}
}
