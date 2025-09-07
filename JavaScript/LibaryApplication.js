const prompt = require('prompt-sync')();

const books = [
  { title: "Things Fall Apart - Chinua Achebe", available: true },
  { title: "Half of a Yellow Sun - Chimamanda Ngozi Adichie", available: true },
  { title: "Americanah - Chimamanda Ngozi Adichie", available: true },
  { title: "The Famished Road - Ben Okri", available: true },
  { title: "Purple Hibiscus - Chimamanda Ngozi Adichie", available: true },
  { title: "Cry, the Beloved Country - Alan Paton", available: true },
  { title: "Nervous Conditions - Tsitsi Dangarembga", available: true },
  { title: "Disgrace - J.M. Coetzee", available: true },
  { title: "The Joys of Motherhood - Buchi Emecheta", available: true },
  { title: "So Long a Letter - Mariama Bâ", available: true }
];

function showMenu() {
  console.log("\nLibrary Book Tracker");
  console.log("1. View all books");
  console.log("2. Borrow a book");
  console.log("3. Return a book");
  console.log("4. Exit");
}

function showBooks() { 
  console.log("\nBooks List:");
  for (let index = 0; index < books.length; index++) {
    const status = books[index].available ? "Available" : "Borrowed";
    console.log((index + 1) + ". " + books[index].title + " - " + status);
  }
}

function borrowBook() {
  showBooks();
  let input = prompt("Enter the number of the book to borrow: ");
  const count = Number(input) - 1;
  if (count >= 0 && count < books.length) {
    if (books[count].available) {
      books[count].available = false;
      console.log("You borrowed \"" + books[count].title + "\"");
    } else {
      console.log("Sorry, " + books[count].title + "has already borrowed.");
    }
  } else {
    console.log("Invalid book number.");
  }
}

function returnBook() {
  showBooks();
  let input = prompt("Enter the number of the book to return: ");
  const counter = Number(input) - 1;
  if (counter >= 0 && counter < books.length) {
    if (!books[counter].available) {
      books[counter].available = true;
      console.log("You returned \"" + books[counter].title + "\"");
    } else {
      console.log( books[counter].title + "Book was never borrowed.");
    }
  } else {
    console.log("Invalid book number.");
  }
}

function main() {
  while (true) {
    showMenu();
    let choice = prompt("Choose an option: ");
    if (choice === '1') {
      showBooks();
    } else if (choice === '2') {
      borrowBook();
    } else if (choice === '3') {
      returnBook();
    } else if (choice === '4') {
      console.log("Exiting program. Goodbye!");
      break;
    } else {
      console.log("Invalid option, please try again.");
    }
  }
}

main();
