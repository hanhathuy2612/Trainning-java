package entities;

public class Classes {
	private int ID_Class;
	private String ClassName;
	
	public Classes() {
		super();
		
	}
	public Classes(int iD_Class) {
		super();
		ID_Class = iD_Class;
	}
	public Classes(int iD_Class, String className) {
		super();
		ID_Class = iD_Class;
		ClassName = className;
	}
	public Classes(String className) {
		super();
		ClassName = className;
	}
	public int getID_Class() {
		return ID_Class;
	}
	public void setID_Class(int iD_Class) {
		ID_Class = iD_Class;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	@Override
	public String toString() {
		return "Classes [" + ID_Class + ", " + ClassName + "]\n";
	}
	
}
