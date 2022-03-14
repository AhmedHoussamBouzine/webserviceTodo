package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Todo;

public class TodoDaoMemory implements TodoDao {

	private List<Todo> todos;

	public TodoDaoMemory() {
		todos = new ArrayList<Todo>();
		todos.add(new Todo("gym", "lundi a 20h"));
		todos.add(new Todo("gaming", "samedi 0h"));

	}

	@Override
	public List<Todo> getAll() {
		return todos;
	}

	@Override
	public Todo add(Todo todo) {
		for (Todo t : todos) {
			if (todo.equals(t)) {
				return null;
			}
		}
		todos.add(todo);
		return todo;
	}

	@Override
	public Todo delete(String nom) {
		for (Todo t : todos) {
			if (t.getName().equals(nom)) {
				todos.remove(t);
				return t;
			}
		}
		return null;
	}

}
