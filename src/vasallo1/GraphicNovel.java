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
public class GraphicNovel extends FictionBook{
    private String illustrator;

    public GraphicNovel(String type, String title, String publisher,
            String pageCount,String author, String genre, String illustrator) {
        super(type,title, publisher, pageCount, author, genre);
        this.illustrator = illustrator;
    }

    @Override
    public String toString() {
        //return super.getTitle()+super.getPublisher()+super.getPageCount()+ 
        //super.getAuthor()+super.getGenre()+illustrator;
        return String.format("| %40s  %20s %20s %20s %35s %30s", 
                super.getTitle()+" |",super.getAuthor()+" |",
                super.getPublisher()+" |",super.getPageCount()+" |",
                super.getGenre()+" |",illustrator + " |");
    }
    
    
}
