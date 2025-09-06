import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
Compilation (Windows):
    javac -cp .;junit-platform-console-standalone-1.9.2.jar ArrangeArray.java ArrangeArrayTest.java
Execution:
    java -jar junit-platform-console-standalone-1.9.2.jar -cp . --select-class ArrangeArrayTest
*/

public class ArrangeArrayTest {

    @BeforeEach
    void resetData() {
        ArrangeArray.studentIDs.clear();
        ArrangeArray.studentNames.clear();
        ArrangeArray.studentCourses.clear();
        ArrangeArray.studentAge.clear();
        ArrangeArray.studentAddress.clear();
    }

    @Test
    void testAddNewStudentRecord_validData_successfulAdd() {
        // Arrange
        String name = "Aisha Musa";
        String age = "21";
        String address = "No. 12 Zoo Road, Kano, 700101";
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("Math", "Biology"));

        // Act
        String result = ArrangeArray.addNewStudentRecord(name, age, courses, address);

        // Assert
        assertEquals(1, ArrangeArray.studentNames.size());
        assertEquals("Aisha Musa", ArrangeArray.studentNames.get(0));
        assertEquals("21", ArrangeArray.studentAge.get(0));
        assertEquals("No. 12 Zoo Road, Kano, 700101", ArrangeArray.studentAddress.get(0));
        assertTrue(ArrangeArray.studentCourses.get(0).contains("Math"));
    }

    @Test
    void testAddNewStudentRecord_invalidAge_returnsError() {
        // Arrange
        String name = "Bello Ibrahim";
        String age = "twenty";
        String address = "No. 5 Emir Road, Kano, 700102";
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("Physics"));

        // Act
        String result = ArrangeArray.addNewStudentRecord(name, age, courses, address);

        // Assert
        assertEquals("Invalid age. Must be a number.", result);
        assertEquals(0, ArrangeArray.studentNames.size());
    }

    @Test
    void testAddCourseToStudent_validCourse_success() {
        // Arrange
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("Math"));
        ArrangeArray.addNewStudentRecord("Faisal Usman", "22", courses, "13 Court Road, Kano, 700103");

        // Act
        String result = ArrangeArray.addCourseToStudent("Faisal Usman", "Computer Science");

        // Assert
        assertEquals("Course added successfully.", result);
        assertTrue(ArrangeArray.studentCourses.get(0).contains("Computer Science"));
    }

    @Test
    void testAddCourseToStudent_duplicateCourse_returnsError() {
        // Arrange
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("English"));
        ArrangeArray.addNewStudentRecord("Hadiza Sani", "19", courses, "44 Airport Road, Kano, 700104");

        // Act
        String result = ArrangeArray.addCourseToStudent("Hadiza Sani", "English");

        // Assert
        assertEquals("Student already registered for this course.", result);
    }

    @Test
    void testUpdateStudentInfo_validUpdate_success() {
        // Arrange
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("Art"));
        ArrangeArray.addNewStudentRecord("Zainab Abdullahi", "25", courses, "22 Sabon Gari, Kano, 700105");

        // Act
        String result = ArrangeArray.updateStudentInfo("Zainab Abdullahi", "26", "22 Sabon Gari, Kano, 700106");

        // Assert
        assertEquals("Student info updated.", result);
        assertEquals("26", ArrangeArray.studentAge.get(0));
        assertEquals("22 Sabon Gari, Kano, 700106", ArrangeArray.studentAddress.get(0));
    }

    @Test
    void testUpdateStudentInfo_invalidAddress_returnsError() {
        // Arrange
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("Business"));
        ArrangeArray.addNewStudentRecord("Yusuf Danladi", "30", courses, "100 Independence Rd, Kano, 700107");

        // Act
        String result = ArrangeArray.updateStudentInfo("Yusuf Danladi", "31", "BadAddress");

        // Assert
        assertEquals("Invalid address format. Use: Street, City, Zip", result);
    }

    @Test
    void testGetStudentZipCodeAddress() {
        // Arrange
        ArrangeArray.addNewStudentRecord("Rukayya Bello", "24", new ArrayList<>(Arrays.asList("Law")), "101 State Road, Kano, 700108");

        // Act
        ArrayList<String> zips = ArrangeArray.getStudentZipCodeAddress();

        // Assert
        assertEquals(1, zips.size());
        assertTrue(zips.get(0).contains("Rukayya Bello Zip Code: 700108"));
    }

    @Test
    void testGetStudentCityFromAddress() {
        // Arrange
        ArrangeArray.addNewStudentRecord("Nasir Musa", "27", new ArrayList<>(Arrays.asList("Medicine")), "102 New Layout, Kano, 700109");

        // Act
        ArrayList<String> cities = ArrangeArray.getStudentCityFromAddress();

        // Assert
        assertEquals(1, cities.size());
        assertTrue(cities.get(0).contains("Nasir Musa City: Kano"));
    }

    @Test
    void testIsValidDepartmentalCourse() {
        // Arrange
        String valid1 = "Math";
        String valid2 = "math";
        String invalid = "PolymerEngineering";

        // Act
        boolean result1 = ArrangeArray.isValidDepartmentalCourse(valid1);
        boolean result2 = ArrangeArray.isValidDepartmentalCourse(valid2);
        boolean result3 = ArrangeArray.isValidDepartmentalCourse(invalid);

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }

    @Test
    void testGenerateStudentId_sequence() {
        // Arrange - nothing to set up

        // Act
        String id1 = ArrangeArray.generateStudentId();
        
        // Assert
        assertEquals("S0001", id1);
           }
}

