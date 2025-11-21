import java.util.*;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int[] marks = new int[3];

    public Student(String name, int[] marks) throws InvalidMarksException {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty!");
        }

        this.name = name;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100!");
            }
            this.marks[i] = marks[i];
        }
    }

    public double calculateAverage() {
        int total = 0;
        for (int m : marks)
            total += m;
        return total / 3.0;
    }

    public String getResult() {
        return calculateAverage() >= 40 ? "PASS" : "FAIL";
    }

    public void display() {
        System.out.println("\n---- Student Result ----");
        System.out.println("Name : " + name);
        System.out.println("Average Marks : " + calculateAverage());
        System.out.println("Result : " + getResult());
        System.out.println("------------------------");
    }
}

public class exception_handling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];

            System.out.println("Enter marks for 3 subjects:");

            for (int i = 0; i < 3; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                String input = sc.nextLine();

                if (input == null || input.trim().isEmpty()) {
                    throw new NullPointerException("Marks cannot be empty!");
                }

                try {
                    marks[i] = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Marks must be a number!");
                }
            }

            // Create student object (validation occurs here)
            Student s = new Student(name, marks);

            // Display final report
            s.display();

        } catch (InvalidMarksException ime) {
            System.out.println("ERROR: " + ime.getMessage());

        } catch (NullPointerException npe) {
            System.out.println("ERROR: " + npe.getMessage());

        } catch (NumberFormatException nfe) {
            System.out.println("ERROR: " + nfe.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        System.out.println("\nProgram Finished.");
    }
}
