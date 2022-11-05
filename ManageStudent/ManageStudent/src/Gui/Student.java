package Gui;

public class Student {
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", Name=" + Name + ", classID=" + classID + ", Gender=" + Gender + ", Mark=" + Mark
				+ "]";
	}

	private String ID;
	private String Name;
	private String classID;
	private boolean Gender;
	private double Mark;
	
	public Student() {
		this.ID = "";
		this.Name = "";
		this.classID = "";
		this.Mark = 0;
	}
	
	public Student(String iD, String name, String classID, boolean gender, double mark) {
		super();
		this.ID = iD;
		this.Name = name;
		this.classID = classID;
		this.Gender = gender;
		this.Mark = mark;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classiD) {
		classID = classiD;
	}

	public boolean isGender() {
		return Gender;
	}

	public void setGender(boolean gender) {
		Gender = gender;
	}

	public double getMark() {
		return Mark;
	}

	public void setMark(double mark) {
		Mark = mark;
	}
	
	
}
