package manager;

import javax.persistence.EntityManager;
import org.apache.openjpa.persistence.EntityManagerImpl;
import entity.User;

public class UserManager {
	
	private final EntityManager entityManager;

	public UserManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true); 
	}
	
	
	public void create(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
	
	public void update(User user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
	}
	
	public void delete(User user) {
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * function that goes to the database and returns 
	 * the right user by his id
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id){
		return entityManager.find(User.class, id);
	}
	
	/**
	 * function that goes to the database and returns 
	 * the full user name (id,user name,password,type)
	 * @param username
	 * @param password
	 * @return
	 */
	public User getFullUser (String username, String password){
		try{
			String sql = "select id, username, password, type from projectmanager.user "
					+ "where username like '"+username+"' and password like '"+password+"'";
			
			return (User)entityManager.createNativeQuery(sql, User.class).getSingleResult();
		}catch(Exception e){			
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * function that create a new user on the data base
	 * @param username
	 * @param password
	 * @param type
	 * @return
	 */
	public User addUser(String username, String password,String type) {
		try{
			
			User user = new User(username, password,type);
				create(user);
				return user;
				
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


}
