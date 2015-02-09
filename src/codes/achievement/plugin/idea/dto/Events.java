package codes.achievement.plugin.idea.dto;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public enum Events {
    SaveFile("SaveFile");

    Events(String name) {
        this.name = name;
    }

    private String name;

    private static final String ide = "idea";

    public String getName() {
        return name;
    }

    public String getIde() {
        return ide;
    }
}
