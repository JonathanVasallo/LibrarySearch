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
public class NonFictionBook extends Book {
    private String language;

    public NonFictionBook(String type, String title, String publisher, 
            String pageCount, String language) {
        super(type,title, publisher, pageCount);
        this.language = language;
    }

    @Override
    public String toString() {
        return super.getTitle()+ super.getPublisher() + super.getPageCount() + language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
}
