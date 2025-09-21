package lk.ijse.dao;

import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dao.impl.StudentDAOImpl;

public class DAOFactory {

    public enum DAOType {
        STUDENT
    }

    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType) {
        switch (daoType) {
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
}
