package pl.moveapp.task.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.moveapp.task.core.dao.NewsDao;
import pl.moveapp.task.core.dao.TagDao;
import pl.moveapp.task.core.exceptions.NewsNotFoundException;
import pl.moveapp.task.core.models.News;
import pl.moveapp.task.core.models.Tag;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mateusz on 2015-07-02.
 */
@Service
@Transactional
public class NewsService {

    final private NewsDao newsDao;
    final private TagDao tagDao;

    @Autowired
    public NewsService(final NewsDao newsDao, final TagDao tagDao) {
        this.newsDao = newsDao;
        this.tagDao = tagDao;
    }

    public News createNews(final News news) {
        news.setCreatedDate(LocalDateTime.now());
        return newsDao.create(news);
    }

    public Optional<News> findNews(final int id) {
        return newsDao.find(id);
    }

    public List<News> findAllNews() {
        return newsDao.findAll();
    }

    public News updateNews(int newsId, News news) {
        Optional<News> found = findNews(newsId);
        updateEntity(found.get(), news);
        return found.get();
    }

    public void deleteNews(int id) {
        newsDao.delete(findNews(id).get());
    }

    public Optional<News> addTag(int newsId, final Tag newTag) {
        final Optional<News> newsEntity = findNews(newsId);
        final Optional<Tag> tagEntity = tagDao.findByName(newTag.getName());
        if (tagEntity.isPresent()) {
            tagEntity.get().setNewsList(Arrays.asList(newsEntity.get()));
        } else {
            newTag.setNewsList(Arrays.asList(newsEntity.get()));
            List<Tag> tags = newsEntity.get().getTags();
            tags.add(newTag);
            newsEntity.get().setTags(tags);
            tagDao.create(newTag);
        }

        return newsEntity;
    }


    private News updateEntity(final News entity, final News news) {
        entity.setTitle(news.getTitle());
        entity.setContent(news.getContent());
        entity.setTags(news.getTags());
        newsDao.update(entity);
        return entity;
    }

}
