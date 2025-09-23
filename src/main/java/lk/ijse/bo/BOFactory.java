package lk.ijse.bo;

import lk.ijse.bo.custom.CourseBO;
import lk.ijse.bo.impl.CourseBOImpl;

public class BOFactory {

    public enum BOTypes {
        COURSE
    }

    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case COURSE:
                return new CourseBOImpl();
            default:
                return null;
        }
    }
}