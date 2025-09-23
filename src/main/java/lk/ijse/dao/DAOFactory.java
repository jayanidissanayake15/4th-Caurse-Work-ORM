package lk.ijse.dao;

import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dao.impl.CourseDAOImpl;
import org.hibernate.Session;

public class DAOFactory {

    public enum DAOTypes {
        COURSE
    }

    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes type) {
        switch (type) {
            case COURSE:
                return new CourseDAOImpl();
            default:
                return null;
        }
    }
}