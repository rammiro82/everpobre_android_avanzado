package io.keepcoding.rgs.everpobre.model;

/**
 * Created by RamiroGarcia on 18/4/16.
 */
public class Notebook {

    public static final String DEFAULT_NAME = "John Doe";
    private long id;
    private String name;

    private Notebook() {
        // disable default constructor.
    }

    public Notebook(int id, String name) {
        if(name == null || name.isEmpty()){
            this.name = DEFAULT_NAME;
        }else {
            this.name = name;
        }

        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
