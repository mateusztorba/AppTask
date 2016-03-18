package pl.moveapp.task.web.resources.asm;

import org.springframework.stereotype.Service;
import pl.moveapp.task.core.models.Tag;
import pl.moveapp.task.web.resources.TagResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mateusz on 2015-07-02.
 */
@Service
public class TagAsm {

    public TagResource toResource(final Tag tag) {
        final TagResource tagResource = new TagResource(tag.getId(), tag.getName());
        return tagResource;
    }

    public Tag toTag(final TagResource tagResource) {
        final Tag tag = new Tag(tagResource.getName());
        return tag;
    }

    public List<TagResource> toResource(final List<Tag> tagList) {
        final List<TagResource> tagResourceList = new ArrayList<>();
        Optional.ofNullable(tagList).ifPresent(t -> t.forEach(item -> {
            tagResourceList.add(toResource(item));
        }));
        return tagResourceList;
    }

    public List<Tag> toTag(final List<TagResource> tagResourceList) {
        final List<Tag> tagList = new ArrayList<>();
        Optional.ofNullable(tagResourceList).ifPresent(t -> t.forEach(item -> {
            tagList.add(toTag(item));
        }));
        return tagList;
    }

}
