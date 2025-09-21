package lk.ijse.bo.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

        private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

        @Override
        public boolean addStudent(StudentDTO dto) throws Exception {
                Student student = new Student(dto.getStudentId(), dto.getName(), dto.getEmail(),
                        dto.getPhone(), dto.getAddress(), dto.getGender(), dto.getDob(),
                        dto.getJoinDate(), dto.getJoinTime());
                return studentDAO.add(student);
        }

        @Override
        public boolean updateStudent(StudentDTO dto) throws Exception {
                Student student = new Student(dto.getStudentId(), dto.getName(), dto.getEmail(),
                        dto.getPhone(), dto.getAddress(), dto.getGender(), dto.getDob(),
                        dto.getJoinDate(), dto.getJoinTime());
                return studentDAO.update(student);
        }

        @Override
        public boolean deleteStudent(int studentId) throws Exception {
                return studentDAO.delete(studentId);
        }

        @Override
        public StudentDTO searchStudent(int studentId) throws Exception {
                Student student = studentDAO.search(studentId);
                if (student == null) return null;
                return new StudentDTO(student.getStudentId(), student.getName(), student.getEmail(),
                        student.getPhone(), student.getAddress(), student.getGender(),
                        student.getDob(), student.getJoinDate(), student.getJoinTime());
        }

        @Override
        public List<StudentDTO> getAllStudents() throws Exception {
                List<Student> students = studentDAO.getAll();
                List<StudentDTO> dtos = new ArrayList<>();
                for (Student s : students) {
                        dtos.add(new StudentDTO(s.getStudentId(), s.getName(), s.getEmail(),
                                s.getPhone(), s.getAddress(), s.getGender(), s.getDob(),
                                s.getJoinDate(), s.getJoinTime()));
                }
                return dtos;
        }
}
