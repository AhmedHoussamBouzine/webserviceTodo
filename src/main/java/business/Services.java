package business;

import java.util.List;

import beans.Todo;

public interface Services {
	public List<Todo> getAll();
	public Todo add(Todo todo);
	public Todo delete(String nom);

}
