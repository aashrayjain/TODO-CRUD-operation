package com.in128minutes.rest.webservice.restfulwebservices.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.in128minutes.rest.webservice.restfulwebservices.todo.Todo;
import com.in128minutes.rest.webservice.restfulwebservices.todo.TodoJpaRepository;

@Transactional
@Repository
public class TodoDao {
	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public Todo getTodoById(int id) {
//		return entityManager.find(Todo.class, id);
//	}
//	
//	public List<Todo> getAllTodos() {
//		String hql = "FROM Todo as todo ORDER BY todo.id";
//		return (List<Todo>)entityManager.createQuery(hql).getResultList();
//	}
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	public Todo getTodoById(Long id) {
		return todoJpaRepository.findById(id).get();
	}
	
	public List<Todo> getAllTodos(){
		return (List<Todo>)todoJpaRepository.findAll();
	}

	public ResponseEntity<Void> deleteById(long id) {
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public Todo save(Todo todo) {
		System.out.println("Aashray");
		if(todo.getId()==-1 || todo.getId()==0) {
			return todoJpaRepository.save(todo);
		}
		else {
			todoJpaRepository.deleteById(todo.getId());
			return todoJpaRepository.save(todo);
		}
	}
	
	public long getnextId() {
		long id = 0;
		if(this.getAllTodos()==null) {
			return ++id;
		}
		 for(Todo todo : this.getAllTodos()) {
			id = todo.getId(); 
		 }
		 System.out.println(id);
		 return ++id;
	}
	
}
