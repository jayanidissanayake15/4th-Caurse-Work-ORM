package lk.ijse.bo.impl;

import lk.ijse.bo.custom.CourseBO;
import lk.ijse.configuration.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dao.impl.CourseDAOImpl;
import lk.ijse.dto.CourseDTO;
import lk.ijse.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO;

    public CourseBOImpl() {
        this.courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    }

    @Override
    public boolean save(CourseDTO dto) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            ((CourseDAOImpl) courseDAO).setSession(session);
            Course course = new Course(dto.getCourseName(), dto.getDuration(), dto.getFee(), dto.getDescription(), dto.getInstructorId());
            boolean saved = courseDAO.add(course);
            transaction.commit();
            return saved;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(CourseDTO dto) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            ((CourseDAOImpl) courseDAO).setSession(session);
            Course course = courseDAO.search(Long.valueOf(dto.getCourseId()));

            if (course != null) {
                course.setCourseName(dto.getCourseName());
                course.setDuration(dto.getDuration());
                course.setFee(dto.getFee());
                course.setDescription(dto.getDescription());
                course.setInstructorId(dto.getInstructorId());

                boolean updated = courseDAO.update(course);
                transaction.commit();
                return updated;
            }
            return false;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            ((CourseDAOImpl) courseDAO).setSession(session);
            boolean deleted = courseDAO.delete(Long.valueOf(id));
            transaction.commit();
            return deleted;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            ((CourseDAOImpl) courseDAO).setSession(session);
            List<Course> courses = courseDAO.getAll();
            return courses.stream()
                    .map(course -> new CourseDTO(
                            String.valueOf(course.getCourseId()),
                            course.getCourseName(),
                            course.getDuration(),
                            course.getFee(),
                            course.getDescription(),
                            course.getInstructorId()
                    ))
                    .collect(Collectors.toList());
        } finally {
            session.close();
        }
    }

    @Override
    public String getNextId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            ((CourseDAOImpl) courseDAO).setSession(session);
            Query<Long> query = session.createQuery("SELECT MAX(courseId) FROM Course", Long.class);
            Long lastId = query.uniqueResult();

            if (lastId == null) {
                return "1";
            }
            return String.valueOf(lastId + 1);
        } finally {
            session.close();
        }
    }

    @Override
    public List<CourseDTO> search(String query) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            ((CourseDAOImpl) courseDAO).setSession(session);
            Query<Course> hqlQuery = session.createQuery("FROM Course WHERE courseName LIKE :query OR courseId LIKE :query", Course.class);
            hqlQuery.setParameter("query", "%" + query + "%");
            List<Course> courses = hqlQuery.list();

            return courses.stream()
                    .map(course -> new CourseDTO(
                            String.valueOf(course.getCourseId()),
                            course.getCourseName(),
                            course.getDuration(),
                            course.getFee(),
                            course.getDescription(),
                            course.getInstructorId()
                    ))
                    .collect(Collectors.toList());
        } finally {
            session.close();
        }
    }
}