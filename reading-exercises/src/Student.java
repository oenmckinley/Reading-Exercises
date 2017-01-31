
public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int age;

	public Student(String firstName, String lastName, int id, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.age = age;
	}

	/**
	* Returns the first name of the Student.
	* 
	* @return .firstName of Student
	*/
	public String GetFirstName() {
		String str = this.firstName;
		return str;
	}

	/**
	* Returns the last name of the Student.
	* 
	* @return .lastName of Student
	*/
	public String GetLastName() {
		String str = this.lastName;
		return str;
	}

	/**
	* Returns the id number of the Student.
	* 
	* @return .id of Student
	*/
	public int GetId() {
		int num = this.id;
		return num;
	}

	/**
	* Returns the age of the Student.
	* 
	* @return .age of Student
	*/
	public int GetAge() {
		int num = this.age;
		return num;
	}

	/**
	*Sets the firstName of the Student.
	*
	*@param name the new firstName of the Student.
	*/
	public void SetFirstName(String name) {
		this.firstName = name;
	}

	/**
	*Sets the lastName of the Student.
	*
	*@param name the new lastName of the Student.
	*/
	public void SetLastName(String name) {
		this.lastName = name;
	}

	/**
	*Sets the id of the Student.
	*
	*@param num the new id of the Student.
	*@throws IllegalArgumentException if a negative id is given
	*/
	public void SetId(int num) {
		if (num > 0)
			this.id = num;
		else
			throw new IllegalArgumentException();
	}

	/**
	*Sets the age of the Student.
	*
	*@param num the new age of the Student.
	*@throws IllegalArgumentException if a negative age is given
	*/
	public void SetAge(int num) {
		if (num > 0)
			this.age = num;
		else
			throw new IllegalArgumentException();
	}
}
