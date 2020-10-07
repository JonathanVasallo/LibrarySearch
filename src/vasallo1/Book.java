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
public class Book {
    private String type;
    private String title; 
    private String publisher;
    private String pageCount;

    public Book(String type,String title, String publisher, String pageCount) {
        this.type = type;
        this.title = title;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", publisher=" + publisher + ", "
                + "pageCount=" + pageCount + '}';
    }
    
    
    
    
}
