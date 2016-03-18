package pl.moveapp.task.web.resources;

import java.time.LocalDateTime;
import java.util.List;

public class NewsResourceBuilder {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private List<TagResource> tags;

    public NewsResourceBuilder id(final int id) {
        this.id = id;
        return this;
    }

    public NewsResourceBuilder title(final String title) {
        this.title = title;
        return this;
    }

    public NewsResourceBuilder content(final String content) {
        this.content = content;
        return this;
    }

    public NewsResourceBuilder createdDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public NewsResourceBuilder tags(final List<TagResource> tags) {
        this.tags = tags;
        return this;
    }

    public NewsResource build() {
        return new NewsResource(id, title, content, createdDate, tags);
    }
}