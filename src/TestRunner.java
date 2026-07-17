public class TestRunner {
    static int passCount = 0;
    static int failCount = 0;

    public static void check(String name, boolean condition) {
        if (condition) {
            System.out.println("  [PASS] " + name);
            passCount++;
        } else {
            System.out.println("  [FAIL] " + name);
            failCount++;
        }
    }

    public static void main(String[] args) {
        System.out.println("== Password Validation ==");
        PasswordValidator validator = new PasswordValidator();

        try {
            validator.validate(null);
            check("null -> throws IllegalArgumentException", false);
        } catch (IllegalArgumentException e) {
            check("null -> throws IllegalArgumentException", true);
        }

      
        check("'Valid1234' valid (EP)", validator.validate("Valid1234") == true);
        check("'Aa1' too short (EP)", validator.validate("Aa1") == false);
        check("'SuperLongPasswordThatFails123' too long (EP)", validator.validate("SuperLongPasswordThatFails123") == false);
        check("'abcdef12' no uppercase (R3)", validator.validate("abcdef12") == false);
        check("'ABCDEF12' no lowercase (R4)", validator.validate("ABCDEF12") == false);
        check("'Abcdefgh' no digit (R5)", validator.validate("Abcdefgh") == false);
        check("'Abc def1' contains space (R6)", validator.validate("Abc def1") == false);

       
        check("'Abcdef1' length 7 (BVA ขอบล่าง-1)", validator.validate("Abcdef1") == false);
        check("'Abcdef12' length 8 (BVA ขอบล่าง)", validator.validate("Abcdef12") == true);
        check("'Abcdef12345678901234' length 20 (BVA ขอบบน)", validator.validate("Abcdef12345678901234") == true);
        check("'Abcdef123456789012345' length 21 (BVA ขอบบน+1)", validator.validate("Abcdef123456789012345") == false);

        System.out.println("==================================");
        System.out.println("PASS " + passCount + " / FAIL " + failCount);
        System.out.println("==================================");
    }
}