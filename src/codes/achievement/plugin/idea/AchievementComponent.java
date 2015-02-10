package codes.achievement.plugin.idea;

import codes.achievement.plugin.idea.dto.EventDto;
import codes.achievement.plugin.idea.listener.ListenerManager;
import codes.achievement.plugin.idea.storage.EventQueue;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class AchievementComponent implements com.intellij.openapi.components.ApplicationComponent {
    @Override
    public void initComponent() {

        ListenerManager.loadListeners();

        //todo:动态注册组件
        //todo:内存、文件，时间缓存
        //todo:文件上传
        //todo:成就拉取，展示

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "Codes Achievement Component";
    }
}
