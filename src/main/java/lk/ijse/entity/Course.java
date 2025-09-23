package lk.ijse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.util.List;

@Entity
@jakarta.persistence.Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "duration")
    private String duration;

    @Column(name = "fee")
    private double fee;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor_id")
    private String instructorId;

    public Course() {
    }

    public Course(String courseName, String duration, double fee, String description, String instructorId) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
        this.description = description;
        this.instructorId = instructorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }
}