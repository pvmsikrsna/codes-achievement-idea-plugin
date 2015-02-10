package codes.achievement.plugin.idea.dto;

import java.util.Date;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class EventDto {
    private final String ide;
    private final String name;
    private final Date time;

    public EventDto(String name) {
        this.ide = "idea";
        this.name = name;
        this.time = new Date();
    }

    public String getIde() {
        return ide;
    }

    public String getName() {
        return name;
    }

    public Date getTime() {
        return time;
    }
}
