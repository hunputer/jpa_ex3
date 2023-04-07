package hellojpa;

import javax.persistence.Entity;

@Entity
public class Book extends Item{

    private String author;
    private String itbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getItbn() {
        return itbn;
    }

    public void setItbn(String itbn) {
        this.itbn = itbn;
    }
}
