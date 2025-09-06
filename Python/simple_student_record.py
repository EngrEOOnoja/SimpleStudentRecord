departmantal_courses = set([
    "Math", "Physics", "Computer Science", "Biology", "Chemistry",
    "Statistics", "English", "Economics", "History", "Philosophy",
    "Sociology", "Political Science", "Geography", "Psychology", "Art",
    "Music", "Engineering", "Law", "Medicine", "Business"
])

student_names = {}
student_age = {}
student_courses = {}
student_address = {}

def is_numeric(input_str):
    return input_str.isdigit()

def add_new_student():
    while True:
        student_id = input("Enter new student ID (unique Number Only): ")
        if not is_numeric(student_id):
            print("Invalid ID. Must be a numeric value.")
            continue
        student_id = int(student_id)
        if student_id in student_names:
            print("Student ID already exists. Try a different one.")
            continue
        break

    name = input("Enter student name: ")
    while not name:
        print("Name cannot be empty.")
        name = input("Enter student name: ")

    while True:
        age = input("Enter student age: ")
        if(int(age) < 16 or int(age) > 120):
        	print("Not up to Age Please report to record Office / enter valid age.")
        	continue
    
        if not is_numeric(age):
            print("Invalid age. Must be numeric.")
            continue
        age = int(age)
       
        break

    city = input("Enter student city: ")
    zipcode = input("Enter student zip code: ")

    print("\nAvailable Departmental Courses:")
    print(", ".join(departmantal_courses))

    courses = set()
    while True:
        course = input("Enter a course for the student (or 'done' to finish): ")
        if course.lower() == "done":
            if not courses:
                print("At least one course must be added.")
                continue
            else:
                break
        if course not in departmantal_courses:
            print(f"Course '{course}' is not offered by the department. Try again.")
        elif course in courses:
            print("Course already added. Try another.")
        else:
            courses.add(course)
            print(f"Course '{course}' added Successfully.")

    student_names[student_id] = name
    student_age[student_id] = age
    student_address[student_id] = {"city": city, "zipcode": zipcode}
    student_courses[student_id] = courses

    print(f"\nStudent '{name}' added successfully!")

def get_student_record():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_names:
        print("Student not found!")
        return
    print(f"\n--- Student Record for ID {student_id} ---")
    print(f"Name: {student_names[student_id]}")
    print(f"Age: {student_age[student_id]}")
    print(f"City: {student_address[student_id]['city']}")
    print(f"Zip Code: {student_address[student_id]['zipcode']}")
    print(f"Courses: {', '.join(student_courses[student_id])}")

def get_student_course_registration_form():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_courses:
        print("Student not found!")
        return
    print(f"Courses for {student_names[student_id]}: {', '.join(student_courses[student_id])}")

def get_student_zipcode_address():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_address:
        print("Student not found!")
        return
    print(f"Zip Code for {student_names[student_id]}: {student_address[student_id]['zipcode']}")

def get_student_city_from_address():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_address:
        print("Student not found!")
        return
    print(f"City for {student_names[student_id]}: {student_address[student_id]['city']}")

def get_deperatmental_course_offered():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_courses:
        print("Student not found!")
        return

    print("\nAvailable Departmental Courses:")
    print(", ".join(sorted(departmantal_courses)))

    new_course = input("Enter course to add: ")

    if new_course in student_courses[student_id]:
        print(f"Course '{new_course}' is already registered for this student.")
        return

    if new_course not in departmantal_courses:
        print(f"Course '{new_course}' is not offered by the department.")
        return

    student_courses[student_id].add(new_course)
    print(f"Course '{new_course}' added successfully.")

def get_student_drop_update_course():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_courses:
        print("Student not found!")
        return

    print(f"Current courses: {', '.join(student_courses[student_id])}")
    action = input("Do you want to 'remove' or 'update' a course? (remove/update): ").strip().lower()

    if action == "remove":
        course_to_remove = input("Enter the course to remove: ")
        if course_to_remove in student_courses[student_id]:
            student_courses[student_id].remove(course_to_remove)
            print(f"Course '{course_to_remove}' removed.")
        else:
            print(f"Course '{course_to_remove}' not found in the student's course list.")

    elif action == "update":
        course_to_remove = input("Enter the course to replace: ")
        if course_to_remove not in student_courses[student_id]:
            print(f"Course '{course_to_remove}' not found in the student's course list.")
            return
        new_course = input("Enter the new course: ")
        if new_course in student_courses[student_id]:
            print(f"Course '{new_course}' already exists in the student's courses. No update made.")
            return
        if new_course not in departmantal_courses:
            print(f"Course '{new_course}' is not offered by the department.")
            return
        student_courses[student_id].remove(course_to_remove)
        student_courses[student_id].add(new_course)
        print(f"Course '{course_to_remove}' replaced with '{new_course}'.")
    else:
        print("Invalid action. Please enter 'remove' or 'update'.")

def get_student_update_info():
    student_id = input("Enter student ID: ")
    if not is_numeric(student_id):
        print("Invalid ID!")
        return
    student_id = int(student_id)
    if student_id not in student_names:
        print("Student not found!")
        return

    print(f"Current Name: {student_names[student_id]}")
    new_name = input("Enter new name (leave blank to keep current): ")
    if new_name:
        student_names[student_id] = new_name

    print(f"Current Age: {student_age[student_id]}")
    new_age = input("Enter new age (leave blank to keep current): ")
    if new_age.isdigit():
        student_age[student_id] = int(new_age)

    print(f"Current City: {student_address[student_id]['city']}")
    new_city = input("Enter new city (leave blank to keep current): ")
    if new_city:
        student_address[student_id]['city'] = new_city

    print(f"Current Zip Code: {student_address[student_id]['zipcode']}")
    new_zip = input("Enter new zip code (leave blank to keep current): ")
    if new_zip:
        student_address[student_id]['zipcode'] = new_zip

    print("Student information updated successfully.")

def get_student_total():
    total = len(student_names)
    print(f"Total number of students in the system: {total}")

def main():
    print("Welcome to the Student Management System")
    while True:
        print("\nChoose an option:")
        print("1. Add New Student")
        print("2. Display Student Record in Full")
        print("3. Display Student Course Record")
        print("4. Display Student Zip Code")
        print("5. Display Student City")
        print("6. Add Course to Student")
        print("7. Remove or Update Student Course")
        print("8. Update Student Information")
        print("9. Total Number of Students")
        print("0. Exit")

        choice_input = input("Enter your choice: ")
        if not is_numeric(choice_input):
            print("Invalid input! Please enter a number.")
            continue

        choice = int(choice_input)

        if choice == 1:
            add_new_student()
        elif choice == 2:
            get_student_record()
        elif choice == 3:
            get_student_course_registration_form()
        elif choice == 4:
            get_student_zipcode_address()
        elif choice == 5:
            get_student_city_from_address()
        elif choice == 6:
            get_deperatmental_course_offered()
        elif choice == 7:
            get_student_drop_update_course()
        elif choice == 8:
            get_student_update_info()
        elif choice == 9:
            get_student_total()
        elif choice == 0:
            print("Exiting program. Goodbye!")
            break
        else:
            print("Invalid choice. Please enter a number from 0 to 9.")

main()
