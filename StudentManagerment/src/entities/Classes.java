package entities;

public class Classes {
	private int idClass;
	private String className;
	
	public Classes() {
		super();
		
	}
	
	public Classes(String className) {
		super();
		this.className = className;
	}

	public Classes(int idClass) {
		super();
		this.idClass = idClass;
	}

	public Classes(int idClass, String className) {
		super();
		this.idClass = idClass;
		this.className = className;
	}

	public int getIdClass() {
		return idClass;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Classes [" + idClass + ", " + className + "]\n";
	}
	
}
