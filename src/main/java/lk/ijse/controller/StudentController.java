package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.StudentDTO;

import java.util.List;

public class StudentController {

    @FXML private TextField txtStudentId;
    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtPhone;
    @FXML private TextField txtAddress;
    @FXML private ComboBox<String> cmbGender;
    @FXML private TextField txtDob;
    @FXML private TextField txtJoinDate;
    @FXML private TextField txtJoinTime;

    @FXML private TableView<StudentDTO> tblStudents;
    @FXML private TableColumn<StudentDTO, Integer> colId;
    @FXML private TableColumn<StudentDTO, String> colName;
    @FXML private TableColumn<StudentDTO, String> colEmail;
    @FXML private TableColumn<StudentDTO, String> colPhone;
    @FXML private TableColumn<StudentDTO, String> colAddress;
    @FXML private TableColumn<StudentDTO, String> colGender;
    @FXML private TableColumn<StudentDTO, String> colDob;
    @FXML private TableColumn<StudentDTO, String> colJoinDate;
    @FXML private TableColumn<StudentDTO, String> colJoinTime;

    private final StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    @FXML
    public void initialize() {
        cmbGender.getItems().addAll("Male", "Female", "Other");
        loadAllStudents();
    }

    @FXML
    private void addStudent() {
        try {
            StudentDTO student = new StudentDTO(
                    Integer.parseInt(txtStudentId.getText()),
                    txtName.getText(),
                    txtEmail.getText(),
                    txtPhone.getText(),
                    txtAddress.getText(),
                    cmbGender.getValue(),
                    txtDob.getText(),
                    txtJoinDate.getText(),
                    txtJoinTime.getText()
            );
            boolean added = studentBO.addStudent(student);
            if (added) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student Added Successfully!");
                loadAllStudents();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed", "Could not add student.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    private void updateStudent() {
        try {
            StudentDTO student = new StudentDTO(
                    Integer.parseInt(txtStudentId.getText()),
                    txtName.getText(),
                    txtEmail.getText(),
                    txtPhone.getText(),
                    txtAddress.getText(),
                    cmbGender.getValue(),
                    txtDob.getText(),
                    txtJoinDate.getText(),
                    txtJoinTime.getText()
            );
            boolean updated = studentBO.updateStudent(student);
            if (updated) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student Updated Successfully!");
                loadAllStudents();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed", "Could not update student.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    private void deleteStudent() {
        try {
            int id = Integer.parseInt(txtStudentId.getText());
            boolean deleted = studentBO.deleteStudent(id);
            if (deleted) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student Deleted Successfully!");
                loadAllStudents();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed", "Student not found.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    private void searchStudent() {
        try {
            int id = Integer.parseInt(txtStudentId.getText());
            StudentDTO student = studentBO.searchStudent(id);
            if (student != null) {
                txtName.setText(student.getName());
                txtEmail.setText(student.getEmail());
                txtPhone.setText(student.getPhone());
                txtAddress.setText(student.getAddress());
                cmbGender.setValue(student.getGender());
                txtDob.setText(student.getDob());
                txtJoinDate.setText(student.getJoinDate());
                txtJoinTime.setText(student.getJoinTime());
            } else {
                showAlert(Alert.AlertType.WARNING, "Not Found", "Student not found.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void loadAllStudents() {
        try {
            List<StudentDTO> students = studentBO.getAllStudents();
            ObservableList<StudentDTO> observableList = FXCollections.observableArrayList(students);
            tblStudents.setItems(observableList);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void clearFields() {
        txtStudentId.clear();
        txtName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtAddress.clear();
        cmbGender.getSelectionModel().clearSelection();
        txtDob.clear();
        txtJoinDate.clear();
        txtJoinTime.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
