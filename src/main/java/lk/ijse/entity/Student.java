package lk.ijse.entity;

import jakarta.persistence.*; // Corrected import
import lombok.Data; // Assuming Lombok is used
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String dob;
    private String joinDate;
    private String joinTime;
}