package lk.ijse.orm_final_coursework.dao.custom;

import lk.ijse.orm_final_coursework.dao.CrudDAO;
import lk.ijse.orm_final_coursework.dto.PaymentDTO;
import lk.ijse.orm_final_coursework.entity.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO extends CrudDAO<Payment> {
    public List<Payment> getByStudentId(String studentId) throws SQLException;
    public boolean savePayment(PaymentDTO payment) throws SQLException;
    public  List<PaymentDTO> getPaymentByStudent(String studentId) throws SQLException;
}
