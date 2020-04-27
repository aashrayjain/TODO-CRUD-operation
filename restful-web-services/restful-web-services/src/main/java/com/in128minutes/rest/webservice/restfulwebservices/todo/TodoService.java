package com.in128minutes.rest.webservice.restfulwebservices.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in128minutes.rest.webservice.restfulwebservices.todo.dao.TodoDao;

@Service
public class TodoService {
	
	
	@Autowired
	private TodoDao todoDao;
	
	public Todo findById(Long id) {
		Todo todo = todoDao.getTodoById(id);
		if(todo==null) {
			return null;
		}
		return todo;
	}
	
	public List<Todo> findAll() {
		return todoDao.getAllTodos();
	}

	public ResponseEntity<Void> deleteById(long id) {
		return todoDao.deleteById(id);
	}

	public Todo save(Todo todo) {
		return todoDao.save(todo);
	}
	 public long getNextId() {
		 return todoDao.getnextId();
	 }
	
	
//	private static List<Todo> todos = new ArrayList();
//	private static long idCounter = 0;
//	
//	static {
//		todos.add(new Todo(++idCounter, "aashray", "Learn To Dance2", new Date(), false));
//		todos.add(new Todo(++idCounter, "aashray", "Learn about MicroService", new Date(), false));
//		todos.add(new Todo(++idCounter, "aashray", "Learn about Angular", new Date(), false));
//	}
//	
	
	
//	public List<Todo> findAll() {
//		return todos;
//	}
//	
//	public Todo deleteById(long id) {
//		Todo todo = findById(id);
//		if(todo==null)
//			return null;
//		if(todos.remove(todo)) {
//			return todo;
//		}
//		return null;
//	}

	
//	public Todo save(Todo todo) {
//		if(todo.getId()==-1 || todo.getId()==0) {
//			todo.setId(++idCounter);
//			todos.add(todo);
//		}
//		else {
//			this.deleteById(todo.getId());
//			todos.add(todo);
//		}
//		return todo;
//	}
//	
}
