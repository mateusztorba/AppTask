package pl.moveapp.task.web.resources.asm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.moveapp.task.core.models.News;
import pl.moveapp.task.web.resources.NewsResource;
import pl.moveapp.task.web.resources.NewsResourceBuilder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 2015-07-02.
 */

@Service
public class NewsAsm {

    final private TagAsm tagAsm;

    @Autowired
    public NewsAsm(final TagAsm tagAsm) {
        this.tagAsm = tagAsm;
    }

    public NewsResource toResource(final News news) {
        return new NewsResourceBuilder().id(news.getId()).title(news.getTitle()).content(news.getContent()).createdDate(news.getCreatedDate()).tags(tagAsm.toResource(news.getTags())).build();
    }

    public News toNews(final NewsResource newsResource) {
        return new News(newsResource.getId(), newsResource.getTitle(), newsResource.getContent(), newsResource.getCreatedDate(), tagAsm.toTag(newsResource.getTags()));
    }

    public List<NewsResource> toResource(final List<News> newsList) {
        return newsList.stream().map(this::toResource).collect(Collectors.toList());
    }
}
