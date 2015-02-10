package codes.achievement.plugin.idea.listener;

import codes.achievement.plugin.idea.dto.EventDto;
import codes.achievement.plugin.idea.storage.EventQueue;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class OperatingSystemListener implements Listener {
    private static String OS = System.getProperty("os.name").toLowerCase();

    @Override
    public void register() {
        if (isWindows()) {
            EventQueue.getCurrent().add(new EventDto("os-windows"));
        } else if (isMac()) {
            EventQueue.getCurrent().add(new EventDto("os-mac"));
        } else if (isUnix()) {
            EventQueue.getCurrent().add(new EventDto("os-unix"));
        } else {
            EventQueue.getCurrent().add(new EventDto("os-other"));
        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }
}
