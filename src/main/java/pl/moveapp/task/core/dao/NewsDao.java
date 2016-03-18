package pl.moveapp.task.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.moveapp.task.core.models.News;
import pl.moveapp.task.core.models.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mateusz on 2015-07-02.
 */
@Repository
public class NewsDao extends AbstractDao {

    final private TagDao tagDao;

    @Autowired
    public NewsDao(final TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public News create(final News news) {
        createTags(news);
        em.persist(news);
        return news;
    }

    public Optional<News> find(final int id) {
        return Optional.ofNullable(em.find(News.class, id));
    }

    public List<News> findAll() {
        return em.createQuery("SELECT n FROM News n").getResultList();
    }

    public News update(final News news) {
        createTags(news);
        return em.merge(news);
    }

    public void delete(final News news) {
        em.remove(news);
    }

    private void createTags(final News news) {
        final List<Tag> tagsToSave = new ArrayList<>();
        Optional.ofNullable(news.getTags()).ifPresent(t -> t.forEach(tag -> {
            Optional<Tag> tagEntity = tagDao.findByName(tag.getName());
            if (!tagEntity.isPresent()) {
                tag.setNewsList(Arrays.asList(news));
                tagDao.create(tag);
            } else {
                tagEntity.get().setNewsList(Arrays.asList(news));
                tagsToSave.add(tagEntity.get());
                news.setTags(tagsToSave);
            }
        }));


    }

}
