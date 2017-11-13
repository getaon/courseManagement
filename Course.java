package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name="instructor")
	private Instructor instructor;
	private String description;
	private String date;
	private String location;
	@ManyToOne
	@JoinColumn(name="tag")
	private Tag tag;
	private String article;
	private boolean isactive;
	
	
	public Course(){
	}
	
	public Course(String name,Instructor instructor,String description,String date,String location,
					Tag tag,String article,boolean isactive){
		this.name=name;
		this.instructor=instructor;
		this.description=description;
		this.date=date;
		this.location=location;
		this.tag=tag;
		this.article=article;
		this.isactive=isactive;
	}
	
	public Course(int id,String name,Instructor instructor, String description,String date,String location,
			Tag tag,String article,boolean isactive){
		this.id=id;
		this.name=name;
		this.instructor=instructor;
		this.description=description;
		this.date=date;
		this.location=location;
		this.tag=tag;
		this.article=article;
		this.isactive=isactive;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartdate() {
		return date;
	}
	public void setStartdate(String startdate) {
		this.date = startdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public String getarticle() {
		return article;
	}
	public void setarticle(String article) {
		this.article = article;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	

}
