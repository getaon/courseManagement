package manager;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Student;
import entity.User;


public class StudentManager {
	
	private final EntityManager entityManager;

	public StudentManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true); 
	}
	
	public void update(Student student) {
		entityManager.getTransaction().begin();
		entityManager.merge(student);
		entityManager.getTransaction().commit();
	}

	public void create(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}

	public void delete(Student student) {
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
	}

	public Student getStudentById(Integer id) {
		return (Student)entityManager.find(Student.class, id);
	}
	
	/**
	 * bring me list of all the students
	 * @return
	 */
	public List<Student> getAllStudents() {
		String sql = "SELECT * from coursemanagementsystem.student";
		return (List<Student>) entityManager.createNativeQuery(sql, Student.class).getResultList();
	}
	
	/**
	 * bring me list of student by some course
	 * @param course
	 * @return
	 */
	public List<Student> getStudentsByCource(int course) {
		String sql = "SELECT sc.id, s.firstname, s.lastname, s.email, s.phone FROM coursemanagementsystem.studentcourse sc"
				+ " inner join coursemanagementsystem.student s on s.id = sc.studentid"
				+ " inner join coursemanagementsystem.course c on c.id = sc.coursesid"
				+ " where c.id = "+course;
		return (List<Student>) entityManager.createNativeQuery(sql, Student.class).getResultList();
	}
	
	/**
	 * creating student
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @param username
	 * @param password
	 * @param isactive
	 * @return
	 */
	public Student addStudent(String firstname, String lastname, String email, String phone, String username,
			String password,boolean isactive){
		
			User user = new User(username,password,"student");
			Student student = new Student(firstname, lastname, email, phone, user, isactive);
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(student);
			entityManager.getTransaction().commit();

			return student ;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * sent student to the archive
	 * @param id
	 * @return
	 */
	public Reply removeStudent(int id){
		
		Student student = getStudentById(id);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(student);
			entityManager.getTransaction().commit();
		return new Reply() ;	
		} catch (Exception e) {
			Reply r = new Reply();
			r.setId(Reply.FAIL_ID);
			r.setMsg(e.getMessage());
			return r;
		}
	}
 
	
	
}
