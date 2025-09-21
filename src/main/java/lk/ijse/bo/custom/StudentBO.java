package lk.ijse.bo.custom;

import lk.ijse.dto.StudentDTO;
import java.util.List;

public interface StudentBO {
    boolean addStudent(StudentDTO student) throws Exception;
    boolean updateStudent(StudentDTO student) throws Exception;
    boolean deleteStudent(int studentId) throws Exception;
    StudentDTO searchStudent(int studentId) throws Exception;
    List<StudentDTO> getAllStudents() throws Exception;
}
