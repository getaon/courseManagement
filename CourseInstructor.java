package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CourseInstructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="instructorid")
	private Instructor instructorid ;
	@ManyToOne
	@JoinColumn(name="courseid")
	private Course courseid;
	
	
	public CourseInstructor() {
		
	}
	
	public CourseInstructor(Course courseid, Instructor instructorid) {
		this.courseid=courseid;
		this.instructorid=instructorid;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instructor getInstructorid() {
		return instructorid;
	}

	public void setInstructorid(Instructor instructorid) {
		this.instructorid = instructorid;
	}

	public Course getCourseid() {
		return courseid;
	}

	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}
	
}
