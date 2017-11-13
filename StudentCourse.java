package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student studentid;
	@ManyToOne
	@JoinColumn(name="courseid")
	private Course courseid;
	
	public StudentCourse() {
		
	}
	
	public StudentCourse(Student studentid, Course courseid) {
		this.studentid = studentid;
		this.courseid = courseid;
	}
	
	public StudentCourse(int id, Student studentid, Course courseid) {
		this.id = id;
		this.studentid = studentid;
		this.courseid = courseid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudentid() {
		return studentid;
	}
	public void setStudentid(Student studentid) {
		this.studentid = studentid;
	}
	public Course getCourseid() {
		return courseid;
	}
	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}
	
}
