package vasallo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Vasallo
 *
 * Project One Object Oriented Programming 9/8/2020
 */
public class Vasallo1 {

    private static ArrayList<Book> books;
    private static HashMap<String, String> noDuping;
    private static ArrayList<String> dupeGenres;
    private static ArrayList<String> dupeAuthors;
    private static ArrayList<String> dupeLanguage;

    public static void main(String[] args) throws Exception {

        books = new ArrayList();
        noDuping = new HashMap();
        dupeGenres = new ArrayList();
        dupeAuthors = new ArrayList();
        dupeLanguage = new ArrayList();

        int except = 0;
        String fileName = "library.txt";
        Scanner reader;
        File file;

        // open the file 
        file = new File(fileName);

        Scanner sc = new Scanner(file);

        int num = sc.nextInt(); // takes in the number of total lines at the 
        //beginning of the text file provided

        while (sc.hasNextLine()) { // reads and fills classes
            String line = sc.nextLine();

            String elements[] = line.split(",");

            if (elements.length > 2) {

                if ("1".equals(elements[0])) {
                    // this will determine if its dictionary or not 

                    books.add(new Dictionary(elements[0], elements[1],
                            elements[2], elements[3], elements[4],
                            elements[5]));

                    //System.out.println(elements[2]); 
                }
                if ("2".equals(elements[0])) {
                    books.add(new CookBook(elements[0], elements[1],
                            elements[2], elements[3], elements[4], elements[5]));
                    //System.out.println(books.get(0).getTitle());

                }
                if ("3".equals(elements[0])) {
                    books.add(new Novel(elements[0], elements[1], 
                            elements[2], elements[3], elements[4], elements[5],
                            elements[6]));

                }
                if ("4".equals(elements[0])) {
                    books.add(new GraphicNovel(elements[0], elements[1], 
                            elements[2], elements[3], elements[4], elements[5],
                            elements[6]));

                }

            }
        }
        welcomeUser(); // displays text

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if ("1".equals(inputString)) { // first option to display all

            displayAllContents();
        }
        if ("2".equals(inputString)) { // display genre author or lang
            System.out.println("Select the following category you would like "
                    + "to search by");
            System.out.println("1 | Search by genres");
            System.out.println("2 | Search by authors");
            System.out.println("3 | Search by languages");
            System.out.println("4 | Exit the program");
            Scanner scanner2 = new Scanner(System.in);
            String inputString2 = scanner.nextLine();
            if ("1".equals(inputString2)) { // picked genre
                System.out.println("Select the genre you want to search by"
                        + " entering the number to the left of a genre");
                displayAllGenres();
                Scanner scan = new Scanner(System.in);
                String inputgenre = scan.nextLine();
                int allocategenreSlot = Integer.parseInt(inputgenre); 
// so if i click on the first Genre given I know that dupeGenres has that same author in this variable-1
                System.out.println(String.format("| %40s  %20s %20s %20s %35s"
                        + " %30s", "Title |", "Author/Language |", "Publisher"
                                + " |", "Page Count |", "Version Number/"
                                        + "Genre/Topic |", "Part of a Series/"
                                                + "Illustrator |")); 
// this is when itll print if any are avail

                if ("1".equals(inputgenre) || "2".equals(inputgenre) ||
                        "3".equals(inputgenre)) {

                    for (int i = 0; i < books.size(); i++) {
                        if ("3".equals(books.get(i).getType())) { 
// this is if the book is a Novel
                            String genre;
                            genre = ((Novel) books.get(i)).getGenre();

                            if (genre.equals(dupeGenres.get
                                    (allocategenreSlot - 1))) { 
// if the Genres are the same them print
                                System.out.println(books.get(i));
                            }
                        }
                        if ("4".equals(books.get(i).getType())) { 
// Graphic Novel
                            String genre;
                            genre = ((GraphicNovel) books.get(i)).getGenre();

                            if (genre.equals(dupeGenres.get(allocategenreSlot
                                    - 1))) { 
// if the Genres are the same them print
                                System.out.println(books.get(i));
                            }
                        }

                    }
                } else {
                    System.out.println("Please Enter A Valid Option for Genre");
                }

            }
            if ("2".equals(inputString2)) { // picked author
                System.out.println("Select the author you want to search"
                        + " by entering the number to the left of a author");
                displayAllAuthors();
                Scanner scan = new Scanner(System.in);
                String inputAuthor = scan.nextLine();
                int allocateAuthorSlot = Integer.parseInt(inputAuthor); 
// so if i click on the first author given I know that 
//dupeAuthor has that same author in this variable-1
                System.out.println(String.format("| %40s  %20s %20s %20s"
                        + " %35s %30s", "Title |", "Author/Language |", 
                        "Publisher |", "Page Count |", "Version Number/Genre/"
                                + "Topic |", "Part of a Series/Illustrator |"));

                

                    for (int i = 0; i < books.size(); i++) {
                        if ("3".equals(books.get(i).getType())) { 
// this is if the book is a Novel
                            String author;
                            author = ((Novel) books.get(i)).getAuthor();

                            if (author.equals(dupeAuthors.get
                                (allocateAuthorSlot - 1))) { 
// if the authors are the same them print
                                System.out.println(books.get(i));
                            }
                        }
                        if ("4".equals(books.get(i).getType())) { 
// Graphic Novel
                            String author;
                            author = ((GraphicNovel) books.get(i)).getAuthor();

                            if (author.equals(dupeAuthors.get
                                (allocateAuthorSlot - 1))) { 
// if the authors are the same them print
                                System.out.println(books.get(i));
                            }
                        }

                    }
                
            }
            if ("3".equals(inputString2)) { // picked language
                System.out.println("Select the language you want to search "
                        + "by entering the number to the left of a language");
                displayAllLanguages();
                Scanner scanner3 = new Scanner(System.in);
                String inputString3 = scanner3.nextLine(); 
// inputString3 is the number the user selected  "1"
                int langNum = Integer.parseInt(inputString3); 
// the number the user enter is made into a integer (int 1)
                System.out.println(String.format("| %40s  %20s %20s %20s"
                        + " %35s %30s", "Title |", "Author/Language |", 
                        "Publisher |", "Page Count |", "Version Number/"
                                + "Genre/Topic |", "Part of a Series/"
                                        + "Illustrator |"));
             //System.out.println(dupeLanguage.get(langNum - 1) + " line 108"); 
// this should print the language we are tracking
                //dupeLanguage.get(langNum - 1) GIVES US ENGLISH IF WE HIT 1
                //dupeLanguage.get(langNum - 1) GIVES US French IF WE HIT 2

                if ("1".equals(inputString3)) {  // if its english 
                    for (int i = 0; i < books.size(); i++) {
                        if ("1".equals(books.get(i).getType())) { 
// this is if the book is a dictionary 
                            String language;
                            language = ((Dictionary) books.get(i)).getLanguage();

                            if (language.equals(dupeLanguage.get(langNum - 1))) { 
// if the languages are the same them print
                                System.out.println(books.get(i));
                            }
                        }
                        if ("2".equals(books.get(i).getType())) { // CookBook 
                            String language;
                            language = ((CookBook) books.get(i)).getLanguage();

                            if (language.equals(dupeLanguage.get(langNum - 1)))
                            { // if the languages are the same them print
                                System.out.println(books.get(i));
                            }
                        }

                    }

                }

                if ("2".equals(inputString3)) { // if its french 
                    for (int i = 0; i < books.size(); i++) {
                        if ("1".equals(books.get(i).getType())) { 
// this is if the book is a dictionary 
                            String language;
                            language = ((Dictionary) books.get(i)).getLanguage();

                            if (language.equals(dupeLanguage.get(langNum - 1))) { 
// if the languages are the same them print
                                System.out.println(books.get(i));
                            }
                        }
                        if ("2".equals(books.get(i).getType())) { // CookBook 
                            String language;
                            language = ((CookBook) books.get(i)).getLanguage();

                            if (language.equals(dupeLanguage.get(langNum - 1)))
                            { // if the languages are the same them print
                                System.out.println(books.get(i));
                            }
                        }

                    }
                }
                if ("1".equals(inputString3) == false && "2".equals
                    (inputString3) == false) {
                    System.out.println("Please Enter A Valid option for "
                            + "Language");

                }
                if ("4".equals(inputString2)) {
                    System.exit(0);
                }
                if ("1".equals(inputString2) == false && "2".equals
                (inputString2) == false && "3".equals(inputString2) == false) {
                    System.out.println("Please Enter A Valid Option 1-3");
                }
            } // end of display genre author or language 
        }
            if ("3".equals(inputString)) { //search by substring 
                System.out.println("Type in what you would like to search the"
                        + " library by. -Note this search is case sensitive");
                System.out.println("(For Example, 'Keto') ");
                Scanner scan = new Scanner(System.in);
                String inputgenre = scan.nextLine(); 
// this takes in the substring to search by 
                String booksInfo; 
// this will hold all book info about a partiular book
                System.out.println(String.format("| %40s  %20s %20s %20s"
                        + " %35s %30s", "Title |", "Author/Language |", 
                        "Publisher |", "Page Count |", "Version Number/"
                                + "Genre/Topic |", "Part of a Series/"
                                        + "Illustrator |"));
                for (int i = 0; i < books.size(); i++) {

                    booksInfo = books.get(i).toString();
                    if (booksInfo.contains(inputgenre)) {
                        System.out.println(books.get(i));

                    }
                }
            }
            if ("4".equals(inputString)) {
                System.exit(0);
            }
            if ("4".equals(inputString) == false && "3".equals(inputString) 
                    == false && "2".equals(inputString) == false &&
                    "1".equals(inputString) == false) {
                System.out.println("Please Enter A Valid Option 1-4");
            }

         // option two ends here 
    }

    public static void welcomeUser() {
        System.out.println("Hello and Welcome to your book library!");
        System.out.println("Please select one of the following options by "
                + "entering"
                + " the number to the left");
        System.out.println("1| Display all contents of the library");
        System.out.println("2| Display all the books of a certain genre, "
                + "author,"
                + "or language ");
        System.out.println("3| Search the library with a sub-string");
        System.out.println("4| Exit the program");

    }

    /**
     *
     */
    public static void displayAllContents() {
        System.out.println(String.format("| %40s  %20s %20s %20s %35s %30s",
                "Title |", "Author/Language |", "Publisher |", "Page Count "
                        + "|", "Version Number/Genre/Topic |", "Part of a"
                                + " Series/Illustrator |"));
        for (int i = 0; i < books.size(); i++) {

            System.out.println(books.get(i));

        }
        //return null;
    }

    public static void displayAllGenres() {

        for (int i = 0; i < books.size(); i++) {

            if ("3".equals(books.get(i).getType())) { // so if they are novels
                String genre;
                //String title;
                genre = ((Novel) books.get(i)).getGenre(); // get the genre
                if (dupeGenres.contains(genre) == false) { 
//if the fantasy genre isnt in the array list then add it
                    dupeGenres.add(genre); 
// adds the genre since it hasnt appeared before
                    
// checks to see how many times it was added should only be printed out twice
                }
            }
            if ("4".equals(books.get(i).getType())) {
// so if they are graphicNovels
                String genre;
                //String title;
                genre = ((GraphicNovel) books.get(i)).getGenre(); 
// get the genre
                if (dupeGenres.contains(genre) == false) { 
//if the genre isnt in the array list then add it
                    dupeGenres.add(genre); 
// adds the genre since it hasnt appeared before
                    //System.out.println("works");
// checks to see how many times it was added should only be printed out twice
                }
            }

        }
        for (int i = 0; i < dupeGenres.size(); i++) {
            System.out.println(i + 1 + " | " + dupeGenres.get(i));
        }

    }

    public static void displayAllAuthors() {
        System.out.println(String.format("| %40s  %20s %20s %20s %35s"
                + " %30s", "Title |", "Author/Language |", "Publisher"
                        + " |", "Page Count |", "Version Number/Genre/"
                                + "Topic |", "Part of a Series/Illustrator |"));
        for (int i = 0; i < books.size(); i++) {

            if ("3".equals(books.get(i).getType())) { // so if they are novels
                String author;
                //String title;
                author = ((Novel) books.get(i)).getAuthor(); 
// get the genre
                if (dupeAuthors.contains(author) == false) { 
//if the fantasy genre isnt in the array list then add it
                    dupeAuthors.add(author); 
// adds the genre since it hasnt appeared before
                     
// checks to see how many times it was added should only be printed out twice
                }
            }
            if ("4".equals(books.get(i).getType())) { 
// so if they are graphicNovels
                String author;
                //String title;
                author = ((GraphicNovel) books.get(i)).getAuthor(); 
// get the genre
                if (dupeAuthors.contains(author) == false) { 
//if the genre isnt in the array list then add it
                    dupeAuthors.add(author); 
// adds the genre since it hasnt appeared before
                    //System.out.println("works"); 
// checks to see how many times it was added should only be printed out twice
                }
            }

        }
        for (int i = 0; i < dupeAuthors.size(); i++) {
            System.out.println(i + 1 + " | " + dupeAuthors.get(i));
        }
    }

    public static void displayAllLanguages() {

        for (int i = 0; i < books.size(); i++) {

            if ("1".equals(books.get(i).getType())) { 
// so if they are novels
                String language;

                language = ((Dictionary) books.get(i)).getLanguage(); 
// get the genre
                if (dupeLanguage.contains(language) == false) { 
//if the fantasy genre isnt in the array list then add it
                    dupeLanguage.add(language); 
// adds the genre since it hasnt appeared before
                   
// checks to see how many times it was added should only be printed out twice
                }
            }
            if ("2".equals(books.get(i).getType())) { 
// so if they are graphicNovels
                String language;

                language = ((CookBook) books.get(i)).getLanguage(); 
// get the genre
                if (dupeLanguage.contains(language) == false) { 
//if the genre isnt in the array list then add it
                    dupeLanguage.add(language);
                    // adds the genre since it hasnt appeared before
                    
                    // checks to see how many times it was added should only 
                    //be printed out twice
                }
            }

        }
        for (int i = 0; i < dupeLanguage.size(); i++) {
            System.out.println(i + 1 + " | " + dupeLanguage.get(i));
        }
    }

    
;

}
