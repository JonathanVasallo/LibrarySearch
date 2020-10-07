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
public class CookBook extends NonFictionBook{
    private String topic;

    public CookBook(String type, String title, String publisher, String pageCount,
            String language, String topic) {
        super(type, title, publisher, pageCount, language);
        this.topic = topic;
    }

    @Override
    public String toString() {
        //return super.getTitle()+ super.getPublisher() + super.getPageCount()
        //+ super.getLanguage()+ topic;
        return String.format("| %40s  %20s %20s %20s %35s %30s", 
                super.getTitle()+" |",super.getLanguage()+" |",
                super.getPublisher()+" |",super.getPageCount()+
                        " |",topic+" |"," |");
    }

    
    
    
}
