package lk.ijse.orm_final_coursework.dao.custom;

import lk.ijse.orm_final_coursework.dao.CrudDAO;
import lk.ijse.orm_final_coursework.entity.Course;
import lk.ijse.orm_final_coursework.entity.Instructor;

import java.sql.SQLException;
import java.util.List;

public interface InstructorDAO extends CrudDAO<Instructor> {
    public List<Course> getCoursesByInstructor(String instructorId) throws SQLException;
    Instructor get(String instructorId) throws Exception;
}
