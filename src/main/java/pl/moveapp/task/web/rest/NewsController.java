package pl.moveapp.task.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.moveapp.task.core.exceptions.NewsNotFoundException;
import pl.moveapp.task.core.models.News;
import pl.moveapp.task.core.services.NewsService;
import pl.moveapp.task.web.resources.NewsResource;
import pl.moveapp.task.web.resources.TagResource;
import pl.moveapp.task.web.resources.asm.NewsAsm;
import pl.moveapp.task.web.resources.asm.TagAsm;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Mateusz on 2015-07-02.
 */
@Controller
@RequestMapping("/rest/news")
public class NewsController {

    final private NewsService newsService;
    final private NewsAsm newsAsm;
    final private TagAsm tagAsm;

    @Autowired
    public NewsController(final NewsService newsService, final NewsAsm newsAsm, final TagAsm tagAsm) {
        this.newsService = newsService;
        this.newsAsm = newsAsm;
        this.tagAsm = tagAsm;
    }

    @RequestMapping(value = "/{newsId}", method = GET)
    public ResponseEntity<NewsResource> getNews(@PathVariable final int newsId) {
        final Optional<News> found = newsService.findNews(newsId);
        if(found.isPresent()) {
            return new ResponseEntity<>(newsAsm.toResource(found.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<NewsResource>> getAllNews() {
        return new ResponseEntity<>(newsAsm.toResource(newsService.findAllNews()), HttpStatus.OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<NewsResource> createNews(@RequestBody @Valid final NewsResource newsResource) {
        News news = newsService.createNews(newsAsm.toNews(newsResource));
        return new ResponseEntity<>(newsAsm.toResource(news), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{newsId}", method = DELETE)
    public ResponseEntity<Void> deleteNews(@PathVariable final int newsId) {
        try {
            newsService.deleteNews(newsId);
        } catch (NewsNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{newsId}", method = PUT)
    public ResponseEntity<NewsResource> updateNews(@PathVariable final int newsId, @RequestBody final NewsResource newsResource) {
        try {
            News news = newsService.updateNews(newsId, newsAsm.toNews(newsResource));
            return new ResponseEntity<>(newsAsm.toResource(news), HttpStatus.OK);
        } catch (NewsNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{newsId}/tag", method = POST)
    public ResponseEntity<NewsResource> addTag(@PathVariable final int newsId, @RequestBody final TagResource tagResource) {
        final Optional<News> news = newsService.addTag(newsId, tagAsm.toTag(tagResource));
        if(news.isPresent()) {
            return new ResponseEntity<>(newsAsm.toResource(news.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
