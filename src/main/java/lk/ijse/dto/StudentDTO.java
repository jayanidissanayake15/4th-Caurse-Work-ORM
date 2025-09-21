package lk.ijse.dto;

public class StudentDTO {
        private int studentId;
        private String name;
        private String email;
        private String phone;
        private String address;
        private String gender;
        private String dob;
        private String joinDate;
        private String joinTime;

        public StudentDTO() {
        }

        public StudentDTO(int studentId, String name, String email, String phone, String address, String gender, String dob, String joinDate, String joinTime) {
                this.studentId = studentId;
                this.name = name;
                this.email = email;
                this.phone = phone;
                this.address = address;
                this.gender = gender;
                this.dob = dob;
                this.joinDate = joinDate;
                this.joinTime = joinTime;
        }

        public int getStudentId() {
                return studentId;
        }

        public void setStudentId(int studentId) {
                this.studentId = studentId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getDob() {
                return dob;
        }

        public void setDob(String dob) {
                this.dob = dob;
        }

        public String getJoinDate() {
                return joinDate;
        }

        public void setJoinDate(String joinDate) {
                this.joinDate = joinDate;
        }

        public String getJoinTime() {
                return joinTime;
        }

        public void setJoinTime(String joinTime) {
                this.joinTime = joinTime;
        }
}
