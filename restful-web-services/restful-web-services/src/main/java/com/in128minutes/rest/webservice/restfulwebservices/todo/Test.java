package com.in128minutes.rest.webservice.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

	public static void main(String[] args) {
		
		
		TodoJpaResource todoJpaResource = new TodoJpaResource();
		todoJpaResource.getAllTodos("in28minutes");
		System.out.println(todoJpaResource.getAllTodos("in28minutes"));

	}

}
