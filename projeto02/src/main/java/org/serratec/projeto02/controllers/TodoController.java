package org.serratec.projeto02.controllers;

import java.util.List;

import org.serratec.projeto02.model.Todo;
import org.serratec.projeto02.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping("/todo")
	public List<Todo> listarTodos(){
		return todoService.listarTodos();
	}

	
}
