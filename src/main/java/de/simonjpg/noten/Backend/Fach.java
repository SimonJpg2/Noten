package de.simonjpg.noten.Backend;

/**
 * Class Fach.
 *
 * <p>
 *     Represents a subject from the Abitur.
 * </p>
 * @author SimonJpg
 * @version 1.0
 * @since 28.12.2022
 */

public class Fach {

    private int id;
    private String name;
    private int note;

    public Fach() {

    }

    public Fach(String name, int note) {
        this.name = name;
        this.note = note;
    }

    public Fach(int id, String name, int note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNote() {
        return note;
    }
}
