package business;

import java.util.List;

import beans.Todo;
import dao.TodoDao;
import dao.TodoDaoMemory;

public class DefaultServices implements Services{

	private TodoDao todoDao;
	private static DefaultServices instance=null;
	private DefaultServices()
	{
		todoDao=new TodoDaoMemory();
	}
	public static DefaultServices getInstance()
	{
		if(instance==null)
			instance=new DefaultServices();
		return instance;
	}
	@Override
	public List<Todo> getAll() {
		return todoDao.getAll();
	}

	@Override
	public Todo add(Todo todo) {
		// TODO Auto-generated method stub
		return todoDao.add(todo);
	}
	@Override
	public Todo delete(String nom) {
		// TODO Auto-generated method stub
		return todoDao.delete(nom);
	}

}
