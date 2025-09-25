package lk.ijse.orm_final_coursework.bo.custom;

import lk.ijse.orm_final_coursework.bo.SuperBO;
import lk.ijse.orm_final_coursework.dto.CourseDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CourseBO extends SuperBO {
    public String getNextId() throws SQLException;
    public List<CourseDTO> getAll()throws SQLException;
    public String getLastId() throws SQLException;
    public boolean save(CourseDTO courseDTO)throws SQLException;
    public boolean update(CourseDTO courseDTO)throws SQLException;
    public boolean delete(String id)throws SQLException;
    public List<String> getAllIds()throws SQLException;
    public Optional<CourseDTO> findById(String id)throws SQLException;
    public List<CourseDTO> search(String search)throws SQLException;
    public int getEnrollmentCount(String courseId) throws Exception;
    public boolean enrollStudent(String courseId, String studentId) throws Exception;
    CourseDTO getCourseByName(String courseName) throws Exception;
}
