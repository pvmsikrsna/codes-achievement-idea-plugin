package codes.achievement.plugin.idea.listener;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class ListenerManager {
    public static void loadListeners() {
        try {
            new OpenFilleListener().register();
            new OperatingSystemListener().register();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
