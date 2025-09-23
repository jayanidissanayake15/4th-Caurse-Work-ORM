package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CourseDTO;
import java.util.List;

public interface CourseBO extends SuperBO {
    boolean save(CourseDTO dto) throws Exception;
    boolean update(CourseDTO dto) throws Exception;
    boolean delete(String id) throws Exception;
    List<CourseDTO> getAll() throws Exception;
    String getNextId() throws Exception;
    List<CourseDTO> search(String query) throws Exception;
}