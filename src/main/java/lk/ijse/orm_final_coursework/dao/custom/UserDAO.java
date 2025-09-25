package lk.ijse.orm_final_coursework.dao.custom;

import lk.ijse.orm_final_coursework.dao.CrudDAO;
import lk.ijse.orm_final_coursework.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    public User getUserByName(String userName) throws SQLException;

}
