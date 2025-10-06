//Abstract class Book
abstract class Book {
 String title;

 // Abstract method
 abstract void setTitle(String s);

 // Concrete method
 String getTitle() {
     return title;
 }
}

//MyBook class that extends Book
class MyBook extends Book {
 // Implement the abstract method
 void setTitle(String s) {
     title = s;
 }
}
