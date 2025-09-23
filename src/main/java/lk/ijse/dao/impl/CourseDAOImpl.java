package lk.ijse.dao.impl;

import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.entity.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Course entity) throws Exception {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        session.update(entity);
        return true;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Course course = session.get(Course.class, id);
        if (course != null) {
            session.delete(course);
            return true;
        }
        return false;
    }

    @Override
    public Course search(Long id) throws Exception {
        return session.get(Course.class, id);
    }

    @Override
    public List<Course> getAll() throws Exception {
        Query<Course> query = session.createQuery("FROM Course", Course.class);
        return query.list();
    }
}