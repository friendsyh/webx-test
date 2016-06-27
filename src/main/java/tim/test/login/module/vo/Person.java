package tim.test.login.module.vo;

import java.io.Serializable;

/**
 * 对象要想被序列化，必须实现Serializable接口
 * @author tim.syh
 *
 */
public class Person implements Serializable{
	
	private static final long serialVersionUID = -7142264207488774373L;
	
	private String name;
	private int age;
	
	public Person(){
		super();
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
