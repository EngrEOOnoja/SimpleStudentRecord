import java.util.ArrayList;
import java.util.Scanner;

public class ArrangeArray {

    public static ArrayList<String> studentIDs = new ArrayList<>();
    public static ArrayList<String> studentNames = new ArrayList<>();
    public static ArrayList<ArrayList<String>> studentCourses = new ArrayList<>();
    public static ArrayList<String> studentAge = new ArrayList<>();
    public static ArrayList<String> studentAddress = new ArrayList<>();

    private static int studentIdCounter = 1;

    public static final String[] DEPARTMENTAL_COURSES = {
            "Math", "Physics", "Computer Science", "Biology", "Chemistry",
            "Statistics", "English", "Economics", "History", "Philosophy",
            "Sociology", "Political Science", "Geography", "Psychology", "Art",
            "Music", "Engineering", "Law", "Medicine", "Business"
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-= Student Management Menu =-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1. Add New Student");
            System.out.println("2. Display Student Record in Full");
            System.out.println("3. Display Student Course Record");
            System.out.println("4. Display Student Zip Code");
            System.out.println("5. Display Student City");
            System.out.println("6. View All Available Departmental Courses");
            System.out.println("7. Add Course to Existing Student");
            System.out.println("8. Update Student Information");
            System.out.println("9. Total Number of Students");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            String choiceInput = input.nextLine();

            if (!isNumeric(choiceInput)) {
                System.out.println("Invalid input! Please enter a number between 0 and 9.");
                continue;
            }

            int choice = Integer.parseInt(choiceInput);

            switch (choice) {
                case 1:
                    addNewStudentFlow(input);
                    break;
                case 2:
                    for (String record : getStudentRecord()) {
                        System.out.println(record);
                    }
                    break;
                case 3:
                    for (String courseS : getStudentCourseRegistrationForm()) {
                        System.out.println(courseS);
                    }
                    break;
                case 4:
                    for (String zip : getStudentZipCodeAddress()) {
                        System.out.println(zip);
                    }
                    break;
                case 5:
                    for (String city : getStudentCityFromAddress()) {
                        System.out.println(city);
                    }
                    break;
                case 6:
                    displayDepartmentalCourses();
                    break;
                case 7:
                    addCourseToStudentFlow(input);
                    break;
                case 8:
                    updateStudentInfoFlow(input);
                    break;
                case 9:
                    System.out.println("Total students: " + getStudentTotal());
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addNewStudentFlow(Scanner input) {
        String name, age, address;

        while (true) {
            System.out.print("Enter name: ");
            name = input.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }
            if (studentNames.contains(name)) {
                System.out.println("A student with this name already exists. Please use a different name.");
                return;
            }
            break;
        }

        while (true) {
            System.out.print("Enter age: ");
            age = input.nextLine().trim();
            if (!isNumeric(age)) {
                System.out.println("Invalid input. Age must be a number.");
                continue;
            }
            int ageInt = Integer.parseInt(age);
            if (ageInt < 16 || ageInt > 120) {
                System.out.println("Age must be between 16 and 120.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter address (format: Street, City, Zip): ");
            address = input.nextLine().trim();
            String[] parts = address.split(",");
            if (parts.length >= 3) {
                break;
            } else {
                System.out.println("Invalid address format. Use: Street, City, Zip");
            }
        }

        ArrayList<String> courses = new ArrayList<>();
        while (true) {
            displayDepartmentalCourses();
            System.out.print("Enter course to add (must be valid): ");
            String course = input.nextLine().trim();

            if (!isValidDepartmentalCourse(course)) {
                System.out.println("Invalid course. Please enter a course from the department list.");
                continue;
            }

            if (courses.stream().anyMatch(c -> c.equalsIgnoreCase(course))) {
                System.out.println("Course already added.");
            } else {
                courses.add(course);
                System.out.println("Course added.");
            }

            if (!askToContinue(input, "Add another course? (yes/no): ")) {
                break;
            }
        }

        System.out.println(addNewStudentRecord(name, age, courses, address));
    }

    public static void printList(ArrayList<String> list) {
    for (String item : list) {
        System.out.println(item);
    }
}

    private static void addCourseToStudentFlow(Scanner input) {
        System.out.print("Enter student name to add course: ");
        String studentName = input.nextLine().trim();

        if (!studentNames.contains(studentName)) {
            System.out.println("Student not found.");
            return;
        }

        while (true) {
            displayDepartmentalCourses();
            System.out.print("Enter new course to add: ");
            String newCourse = input.nextLine().trim();

            System.out.println(addCourseToStudent(studentName, newCourse));

            if (!askToContinue(input, "Add another course for this student? (yes/no): ")) {
                break;
            }
        }
    }

    private static void updateStudentInfoFlow(Scanner input) {
        System.out.print("Enter student name to update: ");
        String stuName = input.nextLine().trim();

        if (!studentNames.contains(stuName)) {
            System.out.println("Student not found.");
            return;
        }

        String newAge, newAddress;

        while (true) {
            System.out.print("Enter new age: ");
            newAge = input.nextLine().trim();
            if (!isNumeric(newAge)) {
                System.out.println("Invalid age. Must be a number.");
                continue;
            }
            int ageInt = Integer.parseInt(newAge);
            if (ageInt < 16 || ageInt > 120) {
                System.out.println("Age must be between 16 and 120.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter new address (format: Street, City, Zip): ");
            newAddress = input.nextLine().trim();
            String[] parts = newAddress.split(",");
            if (parts.length >= 3) {
                break;
            } else {
                System.out.println("Invalid address format. Use: Street, City, Zip");
            }
        }

        System.out.println(updateStudentInfo(stuName, newAge, newAddress));
    }

    public static String addNewStudentRecord(String name, String age, ArrayList<String> courses, String address) {
        if (!isNumeric(age)) return "Invalid age. Must be a number.";
        int ageInt = Integer.parseInt(age);
        if (ageInt < 16 || ageInt > 120) return "Age must be between 16 and 120.";

        for (String course : courses) {
            if (!isValidDepartmentalCourse(course)) return "Course '" + course + "' not offered by department.";
        }

        String studentId = generateStudentId();
        studentIDs.add(studentId);
        studentNames.add(name);
        studentAge.add(age);
        studentAddress.add(address);
        studentCourses.add(new ArrayList<>(courses));

        return "Student added with ID: " + studentId;
    }

    public static String addCourseToStudent(String name, String newCourse) {
        int index = studentNames.indexOf(name);
        if (index == -1) return "Student not found.";

        if (!isValidDepartmentalCourse(newCourse)) return "Invalid course. Not in department.";

        ArrayList<String> courses = studentCourses.get(index);
        for (String c : courses) {
            if (c.equalsIgnoreCase(newCourse)) {
                return "Student already registered for this course.";
            }
        }

        courses.add(newCourse);
        return "Course added successfully.";
    }

    public static ArrayList<String> getStudentRecord() {
        ArrayList<String> records = new ArrayList<>();
        for (int i = 0; i < studentNames.size(); i++) {
            records.add("ID: " + studentIDs.get(i) +
                    ", Name: " + studentNames.get(i) +
                    ", Age: " + studentAge.get(i) +
                    ", Courses: " + studentCourses.get(i) +
                    ", Address: " + studentAddress.get(i));
        }
        return records;
    }

    public static ArrayList<String> getStudentCourseRegistrationForm() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < studentNames.size(); i++) {
            result.add("ID: " + studentIDs.get(i) + ", " + studentNames.get(i) +
                    " registered in: " + studentCourses.get(i));
        }
        return result;
    }

    public static ArrayList<String> getStudentZipCodeAddress() {
        ArrayList<String> zipCodes = new ArrayList<>();
        for (int i = 0; i < studentAddress.size(); i++) {
            String[] parts = studentAddress.get(i).split(",");
            if (parts.length >= 3) {
                zipCodes.add(studentNames.get(i) + " Zip Code: " + parts[2].trim());
            } else {
                zipCodes.add(studentNames.get(i) + " Zip Code: Not found");
            }
        }
        return zipCodes;
    }

    public static ArrayList<String> getStudentCityFromAddress() {
        ArrayList<String> cities = new ArrayList<>();
        for (int i = 0; i < studentAddress.size(); i++) {
            String[] parts = studentAddress.get(i).split(",");
            if (parts.length >= 2) {
                cities.add(studentNames.get(i) + " City: " + parts[1].trim());
            } else {
                cities.add(studentNames.get(i) + " City: Not found");
            }
        }
        return cities;
    }

    public static int getStudentTotal() {
        return studentNames.size();
    }

    public static String updateStudentInfo(String name, String newAge, String newAddress) {
        int index = studentNames.indexOf(name);
        if (index == -1) return "Student not found.";

        if (!isNumeric(newAge)) return "Invalid age.";
        int ageInt = Integer.parseInt(newAge);
        if (ageInt < 16 || ageInt > 120) return "Age must be between 16 and 120.";

        String[] parts = newAddress.split(",");
        if (parts.length < 3) return "Invalid address format. Use: Street, City, Zip";

        studentAge.set(index, newAge);
        studentAddress.set(index, newAddress);
        return "Student info updated.";
    }

    public static boolean isValidDepartmentalCourse(String course) {
        for (String deptCourse : DEPARTMENTAL_COURSES) {
            if (deptCourse.equalsIgnoreCase(course)) return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String generateStudentId() {
        return String.format("S%04d", studentIdCounter++);
    }

    public static void displayDepartmentalCourses() {
        System.out.println("\nDepartmental Courses:");
        for (String deptCourse : DEPARTMENTAL_COURSES) {
            System.out.println("- " + deptCourse);
        }
        System.out.println();
    }

    //METHOD for  yes/no loop
    private static boolean askToContinue(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            String response = input.nextLine().trim().toLowerCase();
            if (response.equals("yes") || response.equals("y")) {
                return true;
            } else if (response.equals("no") || response.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes/y' or 'no/n'.");
            }
        }
    }
}
