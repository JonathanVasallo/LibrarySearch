/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vasallo1;

/**
 *
 * @author jvasa
 */
public class FictionBook extends Book{
    private String author;
    private String genre;

    public FictionBook(String type, String title, String publisher, String pageCount,
            String author, String genre) {
        super(type,title, publisher, pageCount);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.getTitle()+super.getPublisher()+super.getPageCount()+ 
                author +  genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
    
    
    
    
}
