package lk.ijse.orm_final_coursework.dao.custom;

import lk.ijse.orm_final_coursework.dao.CrudDAO;
import lk.ijse.orm_final_coursework.entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student> {
    public String getStudentIdByContact(String phone) throws SQLException;
    public String getStudentFirstNameById(String studentId) throws SQLException;
    public String getStudentLastNameById(String studentId) throws SQLException;
    public Student get(String studentId) throws Exception;
}
