package manager;

import java.util.List;
import javax.persistence.EntityManager;
import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Course;
import entity.Instructor;
import entity.User;
import manager.Reply;

public class InstructorManager {

	private final EntityManager entityManager;

	public InstructorManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true); 
	}
	
	public void delete(Instructor instructors) {
		entityManager.getTransaction().begin(); 
		entityManager.remove(instructors);
		entityManager.getTransaction().commit();
	}

	public void create(Instructor instructors) {
		entityManager.getTransaction().begin();
		entityManager.persist(instructors);
		entityManager.getTransaction().commit();
	}

	public void update(Instructor instructors) {
		entityManager.getTransaction().begin();
		entityManager.merge(instructors);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * get instructors by id
	 * @param id
	 * @return
	 */
	public Instructor getById(Integer id) {
		return entityManager.find(Instructor.class, id);
	}

	/**
	 * function that brings from database list 
	 * of Instructors
	 * @return
	 */
	public List<Instructor> getAllInstructors(){
		String sql="SELECT i.id,i.firstname,i.lastname,i.email,i.phone,i.user,i.isactive FROM"
				+ " coursemanagementsystem.instructors i";
		return (List<Instructor>)entityManager.createNativeQuery(sql,Instructor.class).getResultList();
	}
	
	/**
	 * add new instructor
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @param user
	 * @param isactive
	 * @return
	 */
	public Instructor addInstructor(String firstname,String lastname,String email,String phone,
					String username,String password,boolean isactive) {
		try {
			User user = ManagerHelper.getUserManager().addUser(username, password,"instructor");
			Instructor instructor = new Instructor(firstname, lastname,email, phone,user,isactive);

				create(instructor);;
		    return instructor;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	     /**
	      * delete instructor
	      * @param id
	      * @return
	      */
		public Reply removeInstructor(int id) {
			try {
				String sql = "update coursemanagementsystem.instructor "+
						" set isactive = 0 "
						+ " where id ="+id;
				return (Reply)entityManager.createNativeQuery(sql,Instructor.class).getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
				Reply r = new Reply();
				r.setId(Reply.FAIL_ID);
				r.setMsg(e.getMessage());
				return r;
			}
		}
	
		/**
		 * update instructor
		 * @param id
		 * @param firstname
		 * @param lastname
		 * @param email
		 * @param phone
		 * @return
		 */
		public Reply updateInstructor(int id,String firstname,String lastname,String email,String phone) {
			Instructor instructor =getById(id);
			
			instructor.setFirstname(firstname);
			instructor.setLastname(lastname);
			instructor.setEmail(email);
			instructor.setPhone(phone);
			
			try {
				
				entityManager.getTransaction().begin();
				entityManager.merge(instructor);
				entityManager.getTransaction().commit();
				return new Reply();
			} catch (Exception e) {
				
				Reply r = new Reply();
				r.setId(-1);
				r.setMsg(e.getMessage());
				return r;
			}

		}
}
