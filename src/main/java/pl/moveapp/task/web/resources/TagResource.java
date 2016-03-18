package pl.moveapp.task.web.resources;

/**
 * Created by Mateusz on 2015-07-02.
 */
public class TagResource {

    private int id;
    private String name;

    public TagResource(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
