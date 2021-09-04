package session2.model;

import javax.validation.constraints.Pattern;


    public class User{

        @Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$",message = "error email")
        private String email;

        @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$", message = "error password")
        private String password;

        public User() {
        }

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

