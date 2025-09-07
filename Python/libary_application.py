books = [
    { "title": "Things Fall Apart - Chinua Achebe", "available": True },
    { "title": "Half of a Yellow Sun - Chimamanda Ngozi Adichie", "available": True },
    { "title": "Americanah - Chimamanda Ngozi Adichie", "available": True },
    { "title": "The Famished Road - Ben Okri", "available": True },
    { "title": "Purple Hibiscus - Chimamanda Ngozi Adichie", "available": True },
    { "title": "Cry, the Beloved Country - Alan Paton", "available": True },
    { "title": "Nervous Conditions - Tsitsi Dangarembga", "available": True },
    { "title": "Disgrace - J.M. Coetzee", "available": True },
    { "title": "The Joys of Motherhood - Buchi Emecheta", "available": True },
    { "title": "So Long a Letter - Mariama Bâ", "available": True }
]

def is_numeric(string):
      for character in string:
        if character < '0' or character > '9':
            return False
    return len(string) > 0

def show_menu():
    print("\nLibrary Book Tracker")
    print("1. View all books")
    print("2. Borrow a book")
    print("3. Return a book")
    print("4. Exit")

def show_books():
    print("\nBooks List:")
    index = 0
    while index < len(books):
        if books[index]["available"]:
            status = "Available"
        else:
            status = "Borrowed"
        print(str(index + 1) + ". " + books[index]["title"] + " - " + status)
        index += 1

def borrow_book():
    show_books()
    user_input = input("Enter the number of the book to borrow: ")
    if is_numeric(user_input):
        num = int(user_input)
        index = num - 1
        if index >= 0 and index < len(books):
            if books[index]["available"]:
                books[index]["available"] = False
                print("You borrowed \"" + books[index]["title"] + "\"")
            else:
                print("Sorry, \"" + books[index]["title"] + "\" has already been borrowed.")
        else:
            print("Invalid book number.")
    else:
        print("Please enter a valid number.")

def return_book():
    show_books()
    user_input = input("Enter the number of the book to return: ")
    if is_numeric(user_input):
        num = int(user_input)
        index = num - 1
        if index >= 0 and index < len(books):
            if not books[index]["available"]:
                books[index]["available"] = True
                print("You returned \"" + books[index]["title"] + "\"")
            else:
                print("\"" + books[index]["title"] + "\" was never borrowed.")
        else:
            print("Invalid book number.")
    else:
        print("Please enter a valid number.")

def main():
    while True:
        show_menu()
        choice = input("Choose an option: ")
        if choice == "1":
            show_books()
        elif choice == "2":
            borrow_book()
        elif choice == "3":
            return_book()
        elif choice == "4":
            print("Exiting program. Goodbye!")
            break
        else:
            print("Invalid option, please try again.")

main()
