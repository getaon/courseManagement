package manager;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Tag;
import entity.User;

public class TagManager {
	private final EntityManager entityManager;

	public TagManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true); 
	}
	
	public Tag getTagById(Integer id){
		return entityManager.find(Tag.class, id);
	}
	

}
