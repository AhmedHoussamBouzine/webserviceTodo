package beans;

public class Todo {
	private String name;
	private String desc;
	
	public Todo() {
		super();
	}
	
	public Todo(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public boolean equals(Object obj) {
		Todo todo = (Todo)obj;
		return 	this.name.equals(todo.name);
	}
}
