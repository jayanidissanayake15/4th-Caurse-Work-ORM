package lk.ijse.bo;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.bo.impl.StudentBOImpl;

public class BOFactory {

    public enum BOTypes {
        STUDENT
    }

    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public Object getBO(BOTypes type) {
        switch (type) {
            case STUDENT:
                return new StudentBOImpl();
            default:
                return null;
        }
    }
}
