// TestCRUD.java - Main class to test Hibernate CRUD operations
public class TestCRUD {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        // Create
        Student student = new Student();
        student.setName("John");
        student.setAge(22);
        dao.saveStudent(student);

        // Read
        Student fetched = dao.getStudent(student.getId());
        System.out.println("Fetched: " + fetched.getName());

        // Update
        fetched.setAge(23);
        dao.updateStudent(fetched);

        // Delete
        dao.deleteStudent(fetched.getId());
    }
}
