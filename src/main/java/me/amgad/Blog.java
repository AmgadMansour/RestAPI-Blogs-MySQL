package me.amgad;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Blog {

    // This class is for spring to understand the structure of each record in the database

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generated primary key
    private int id;
    private String title;
    private String content;

    public Blog(String title, String content){
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String toString(){
        return "Blog: {id: " + id + ", title: " + title + ", content: " + content + " }";
    }
}
