package manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Course;

public class ManagerHelper {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coursemanagementsystem");

	public static UserManager getUserManager() {
		return new UserManager(entityManagerFactory.createEntityManager());
	}

	public static CourseInstructorManager getCourseInstructorManager() {
		return new CourseInstructorManager(entityManagerFactory.createEntityManager());
	}

	public static CourseManager getCourseManager() {
		return new CourseManager(entityManagerFactory.createEntityManager());
	}

	public static InstructorManager getInstructorManager() {
		return new InstructorManager(entityManagerFactory.createEntityManager());
	}

	public static StudentCourseManager getStudentCourseManager() {
		return new StudentCourseManager(entityManagerFactory.createEntityManager());
	}

	public static StudentManager getStudentManager() {
		return new StudentManager(entityManagerFactory.createEntityManager());
	}

	public static TagManager getTagManager() {
		return new TagManager(entityManagerFactory.createEntityManager());
	}
	
}
