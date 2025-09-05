#1. Write a function that can display a student record in whole.
#2. Write a function that displays only all the courses a particular
#student is offering.
#3. Write a function that displays only the zip code from the student’s
#address.
#4. Write a function that displays only the students city from the
#student’s address
#5. Write a function that allows a student to add a new course, but only if :
#○ The course is not already in the student’s course set (no duplicates).
#○ The course is officially offered by the department.
#6. Write a function that remove or updates the students course in the set of
#course without introducing duplicate
#7. Write a function that updates the student various field: age (e.g from 22
#to 28 ), name , City and Zip code
#8. Write a functions that displays the overall number of student in the
#system





departmantal_courses = set(["Math", "Physics", "Computer Science", "Biology", "Chemistry",
"Statistics", "English", "Economics", "History", "Philosophy",
"Sociology", "Political Science", "Geography", "Psychology", "Art",
"Music", "Engineering", "Law", "Medicine", "Business"])

student_names = {}
student_age = {}
student_courses = {}
student_address = {}



def is_numeric(input_str):
    return input_str.isdigit()

def get_student_record():
	return
	
def get_student_course_registration_form():
	return
	
def get_student_zipcode_address():
	return
	
def get_student_city_from_address():
	return
	
	
def get_no_duplicate_course():
	return
	
	
def get_deperatmental_course_offered():
	return
	
		
def get_student_add_course():
	return
	
		
def get_student_drop_update_course():
	return

def get_student_
	return




def main():
    print(type(candidates))
    while True:
    	print("Choose and option to Display from below.")
        print("\n1. Student Record in Full")
        print("2. Student Course Record")
        print("3. Student Zip Code")
        print("4. Student City")
        print("5. Student Add Course")
        print("6. Student Drop & Update Course")
        print("7. Student Update information")
        print("8. Total Student in the system.")
        print("0. Exit")

        choice_input = input("Enter your choice: ")

        if not is_numeric(choice_input):
            print("Invalid input! Please enter a number between 1 and 5.")
            continue

        choice = int(choice_input)

        if choice == 1:
             get_student_record()
        elif choice == 2:
            get_student_course_registration_form()
        elif choice == 3:
            cast_vote()
        elif choice == 4:
            view_results()
        elif choice == 5:
            print("Exiting........!")
            break
        else:
            print("Invalid choice. Enter a number between 1 and 5.")

main()



