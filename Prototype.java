interface People extends Cloneable {
	public People makeCopy();
}

class Student implements People {

	public Student() {
		System.out.println("Making a student.");
	}
	public People makeCopy() {
		Student student = null;
		System.out.println("Cloning a student.");
		try {
			student = (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (student == null)
			System.err.println("Clone failed");
		return student;
	}
	
}

public class Prototype {
	public static void main(String[] args) {
		Student student = new Student();
		Student cloneStudent = (Student) student.makeCopy();
		System.out.println(System.identityHashCode(student));
		System.out.println(System.identityHashCode(cloneStudent));
	}
}
