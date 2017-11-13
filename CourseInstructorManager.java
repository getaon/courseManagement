package manager;

import java.util.List;

import javax.persistence.EntityManager;
import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Course;
import entity.CourseInstructor;
import entity.Instructor;

public class CourseInstructorManager {
	
	private final EntityManager entityManager;

	public CourseInstructorManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl)this.entityManager).getBroker().setAllowReferenceToSiblingContext(true); 			
	}
	
	public void update(CourseInstructor courseInstructor) {
		entityManager.getTransaction().begin();
		entityManager.merge(courseInstructor);
		entityManager.getTransaction().commit();
	}

	public void create(CourseInstructor courseInstructor) {
		entityManager.getTransaction().begin();
		entityManager.persist(courseInstructor);
		entityManager.getTransaction().commit();
	}

	public void delete(CourseInstructor courseInstructor) {
		entityManager.getTransaction().begin();
		entityManager.remove(courseInstructor);
		entityManager.getTransaction().commit();
	}
	public CourseInstructor  get(Integer  id) {
		return entityManager.find(CourseInstructor.class, id);
	}
	
	/**
	 * function create associate  between course and instructor...
	 * @param courseId
	 * @param instructorId
	 * @return
	 */
	public CourseInstructor addCourseInstructor(int courseId, int instructorId) {
		Course course = ManagerHelper.getCourseManager().getCourseById(courseId);
		Instructor instructor = ManagerHelper.getInstructorManager().getById(instructorId);
		
		try {
			CourseInstructor courseInstructor = new CourseInstructor(course,instructor);
			entityManager.getTransaction().begin();
			entityManager.persist(courseInstructor);
			entityManager.getTransaction().commit();
			return courseInstructor;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * function delete associate  between course and instructor...
	 * @param courseId
	 * @param instructorId
	 * @return
	 */
	public Reply removeCourseInstructor(int id) {
		try {
			CourseInstructor courseInstructor = get(id);
			entityManager.getTransaction().begin();
			entityManager.remove(courseInstructor);
			entityManager.getTransaction().commit();
			return new Reply();
		} catch (Exception e) {
			Reply r = new Reply();
			r.setId(-1);
			r.setMsg(e.getMessage());
			return r;
		}
	}
	/**
	 * this function bring all associate CourseInstructor...
	 * @param courseId
	 * @param instructorId
	 * @return
	 */
	public List<CourseInstructor> getAllCourseInstructor() {
		String sql = "SELECT * from coursemanagementsystem.courseinstructor ";
		return (List<CourseInstructor>) entityManager.createNativeQuery(sql, CourseInstructor.class).getResultList();
	}
}
