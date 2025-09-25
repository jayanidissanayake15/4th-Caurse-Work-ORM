package lk.ijse.orm_final_coursework.dao.custom;

import lk.ijse.orm_final_coursework.dao.CrudDAO;
import lk.ijse.orm_final_coursework.dto.CourseDTO;
import lk.ijse.orm_final_coursework.entity.Course;

public interface CourseDAO extends CrudDAO<Course> {
    public int getEnrollmentCount(String courseId) throws Exception;
    public boolean enrollStudent(String courseId, String studentId) throws Exception;
    public Course get(String id) throws Exception;
    public CourseDTO getCourseByName(String courseName) throws Exception;

}
