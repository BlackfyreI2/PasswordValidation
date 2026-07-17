public class PasswordValidator {
    
    public boolean validate(String pw) {
       
        if (pw == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        
      
        if (pw.length() < 8 || pw.length() > 20) {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        
       
        for (char c : pw.toCharArray()) {
            if (c == ' ') {
                return false; 
            }
            if (Character.isUpperCase(c)) {
                hasUpper = true; 
            } else if (Character.isLowerCase(c)) {
                hasLower = true; 
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        
       
        return hasUpper && hasLower && hasDigit;
    }
}