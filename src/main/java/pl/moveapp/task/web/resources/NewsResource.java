package pl.moveapp.task.web.resources;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mateusz on 2015-07-02.
 */
public class NewsResource {

    private int id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    private LocalDateTime createdDate;
    private List<TagResource> tags;

    public NewsResource() {

    }

    public NewsResource(final int id, final String title, final String content, final LocalDateTime createdDate, final List<TagResource> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<TagResource> getTags() {
        return tags;
    }

    public void setTags(final List<TagResource> tags) {
        this.tags = tags;
    }
}
