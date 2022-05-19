package org.serratec.projeto02.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto02.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private Integer ultimoIdCriado;
	
	private List<Todo> todos = new ArrayList<Todo>();
			
	public TodoService() {
		// Mock de dados
		todos.add(new Todo(1, "Mercado","Ir ao mercado fazer compras"));
		todos.add(new Todo(2, "Remedio","Ir a farmacia"));
		todos.add(new Todo(3, "Estudar","Abrir o classroom e entrar na aula"));
		
		ultimoIdCriado = 3;
	}

	public List<Todo> listarTodos(){
		return this.todos;
	}
	
	public Todo getTodo(Integer id) {
		
		for(Todo todo : todos) {
			if((todo.getId()).equals(id)) {
				return todo;	
			}
		}
		return null;		
	}
	
	public Todo createTodo(String titulo, String descricao) {
		
		Todo todo = new Todo(ultimoIdCriado+1, titulo, descricao);
		
		todos.add(todo);
		
		ultimoIdCriado++;
		
		return todo;		
	}

	public Todo updateTodo(Integer id, String titulo, String descricao) {
		getTodo(id).setTitulo(titulo);
		getTodo(id).setDescricao(descricao);
		return getTodo(id);
	}

	public boolean deleteTodo(Integer id) {
		return todos.remove(getTodo(id));
	}
	
}
