package cn.basejava.annotation;

@StudentTable("t_student")
public class Student {
	@StudentField(columnName="id",type="int",length=10)
	private int id;
	@StudentField(columnName="name",type="varchar",length=10)
	private String name;
	@StudentField(columnName="id",type="int",length=3)
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Student() {
		
	}

}
