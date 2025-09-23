package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.BOTypes;
import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dto.CourseDTO;
import lk.ijse.dto.tm.CourseTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    private final CourseBO courseBO = (CourseBO) BOFactory.getInstance();

    public AnchorPane mainContent;
    public Label lblCourseId;
    public ComboBox<String> cmbCourseName;
    public TextField txtDuration;
    public TextField txtFee;
    public TextField txtDescription;
    public TextField txtInstructorId;
    public Button btnSaveCourse;
    public Button btnUpdateCourse;
    public Button btnDeleteCourse;
    public Button btnClearCourse;
    public TextField txtSearch;
    public TableView<CourseTM> tblCourses;
    public TableColumn<CourseTM, String> colCourseId;
    public TableColumn<CourseTM, String> colCourseName;
    public TableColumn<CourseTM, String> colDuration;
    public TableColumn<CourseTM, Double> colFee;
    public TableColumn<CourseTM, String> colDescription;
    public TableColumn<CourseTM, String> colInstructorId;
    public AnchorPane ancCoursePage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupTableColumns();
        setupCourseNames();
        initializeData();
    }

    private void setupTableColumns() {
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colInstructorId.setCellValueFactory(new PropertyValueFactory<>("instructorId"));
    }

    private void setupCourseNames() {
        cmbCourseName.setItems(FXCollections.observableArrayList(
                "Manual Car Driving",
                "Automatic Car Driving",
                "Motorcycle / Scooter Driving",
                "Three-Wheeler Driving",
                "Heavy Vehicle Driving(Truck / Bus)"
        ));
    }

    private void initializeData() {
        try {
            loadAllCourses();
            loadNextId();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Initialization Error: " + e.getMessage());
        }
    }

    private void loadAllCourses() throws Exception {
        tblCourses.setItems(FXCollections.observableArrayList(
                courseBO.getAll().stream().map(courseDTO -> new CourseTM(
                        courseDTO.getCourseId(),
                        courseDTO.getCourseName(),
                        courseDTO.getDuration(),
                        courseDTO.getFee(),
                        courseDTO.getDescription(),
                        courseDTO.getInstructorId()
                )).toList()
        ));
    }

    private void loadNextId() throws Exception {
        lblCourseId.setText(courseBO.getNextId());
    }

    private void resetForm() {
        cmbCourseName.getSelectionModel().clearSelection();
        txtDuration.clear();
        txtFee.clear();
        txtDescription.clear();
        txtInstructorId.clear();
        tblCourses.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).show();
    }

    private void navigateTo(String path) {
        try {
            mainContent.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource(path));
            pane.prefWidthProperty().bind(mainContent.widthProperty());
            pane.prefHeightProperty().bind(mainContent.heightProperty());
            mainContent.getChildren().add(pane);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Page not found!");
            e.printStackTrace();
        }
    }

    /* -------------------- Action Handlers -------------------- */

    public void btnSaveOnAction(ActionEvent event) {
        try {
            boolean isSaved = courseBO.save(CourseDTO.builder()
                    .courseId(lblCourseId.getText())
                    .courseName(cmbCourseName.getValue())
                    .duration(txtDuration.getText())
                    .fee(Double.parseDouble(txtFee.getText()))
                    .description(txtDescription.getText())
                    .instructorId(txtInstructorId.getText())
                    .build());

            if (isSaved) {
                showAlert(Alert.AlertType.INFORMATION, "Course saved successfully!");
                loadAllCourses();
                resetForm();
                loadNextId();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error saving course!");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error saving course: " + e.getMessage());
        }
    }

    public void btnUpdateOnAction(ActionEvent event) {
        try {
            boolean isUpdated = courseBO.update(CourseDTO.builder()
                    .courseId(lblCourseId.getText())
                    .courseName(cmbCourseName.getValue())
                    .duration(txtDuration.getText())
                    .fee(Double.parseDouble(txtFee.getText()))
                    .description(txtDescription.getText())
                    .instructorId(txtInstructorId.getText())
                    .build());

            if (isUpdated) {
                showAlert(Alert.AlertType.INFORMATION, "Course updated successfully!");
                loadAllCourses();
                resetForm();
                loadNextId();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error updating course!");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error updating course: " + e.getMessage());
        }
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String id = lblCourseId.getText();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a course to delete!");
            return;
        }

        try {
            boolean isDeleted = courseBO.delete(id);
            if (isDeleted) {
                showAlert(Alert.AlertType.INFORMATION, "Course deleted successfully!");
                loadAllCourses();
                resetForm();
                loadNextId();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error deleting course!");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error deleting course: " + e.getMessage());
        }
    }

    public void btnResetOnAction(ActionEvent event) {
        resetForm();
        try {
            loadNextId();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error generating ID: " + e.getMessage());
        }
    }

    public void OnClickedTable(MouseEvent event) {
        CourseTM selected = tblCourses.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblCourseId.setText(selected.getCourseId());
            cmbCourseName.setValue(selected.getCourseName());
            txtDuration.setText(selected.getDuration());
            txtFee.setText(String.valueOf(selected.getFee()));
            txtDescription.setText(selected.getDescription());
            txtInstructorId.setText(selected.getInstructorId());
        }
    }

    public void search(KeyEvent event) {
        String search = txtSearch.getText();
        try {
            if (search.isEmpty()) {
                loadAllCourses();
            } else {
                List<CourseDTO> results = courseBO.search(search);
                tblCourses.setItems(FXCollections.observableArrayList(
                        results.stream().map(course -> new CourseTM(
                                course.getCourseId(),
                                course.getCourseName(),
                                course.getDuration(),
                                course.getFee(),
                                course.getDescription(),
                                course.getInstructorId()
                        )).toList()
                ));
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Failed to search: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void goToDashboard(MouseEvent event) {
        navigateTo("/view/DashBoard.fxml");
    }
}