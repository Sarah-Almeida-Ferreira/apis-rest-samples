package org.serratec.projeto02.services;

import java.util.Arrays;
import java.util.List;

import org.serratec.projeto02.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private List<Todo> todos = Arrays.asList(new Todo(1, "Mercado","Ir ao mercado fazer compras"),new Todo(2, "Remedio","Ir a farmacia"),new Todo(3, "Estudar","Abrir o classroom e entrar na aula"));

	public List<Todo> listarTodos(){
		return this.todos;
	}
	
}
