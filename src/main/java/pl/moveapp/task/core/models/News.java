package pl.moveapp.task.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mateusz on 2015-07-02.
 */
@Entity
public class News {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    private LocalDateTime createdDate;

    @ManyToMany
    private List<Tag> tags;


    public News() {
    }

    public News(int id, String title, String content, LocalDateTime createdDate, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
