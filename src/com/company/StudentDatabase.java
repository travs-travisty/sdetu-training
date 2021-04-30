package com.company;

public class StudentDatabase {

    public static void main(String[] args) {

        StudentAccount Student1 = new StudentAccount("Travis",10_000, "256780982");

        Student1.enroll("CMIS_141");
        Student1.enroll("CMIS_320");
        Student1.enroll("CMIS_102");
        Student1.pay(350);

        System.out.println(Student1.toString());
    }
}

    class StudentAccount {
        private static int iD = 999;       //random 4-digit number between 1000 and 9000 + last 4 of SSN
        private String UserID;
        private String email;               //based on name
        private String name;
        private String SSN;
        private String courses = "";
        private static final int costOfCourse = 300;
        private static int balance = 0;
        private String phone;
        private String city;
        private String state;

        // Constructor
        public StudentAccount(String name, double initDeposit, String SSN) {
            System.out.println("SSN: " + SSN);
            this.SSN = SSN;
            this.name = name;
            iD++;
            setUserID();
            setEmail();
        }
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
        private void setUserID() {
            UserID = iD + "" + (1000 + (int) (Math.random() * ((9000 - 1000) + 1))) + "" + SSN.substring(SSN.length() - 4);
            System.out.println("UserID: " + UserID);
        }
        private void setEmail() {
            email = name.toLowerCase() + "." + iD + "@student.college.edu";
        }
        public void enroll(String course) {
            this.courses = this.courses + " " + course;
            balance = balance + costOfCourse;
        }
        public void pay(int payment) {
            balance = balance - payment;
        }
        public void checkBalance() {
            System.out.println("Balance: " + balance);
        }
        public void showCourses() {
            System.out.println("Courses: " + courses);
        }
        @Override
        public String toString() {
            return "[Name: " + name + "]\n[Email: " + email + "]\n" + "[User ID: " + UserID + "]\n[Courses: " + courses + "]\n[Balance: " + balance + "]";
        }

    }
