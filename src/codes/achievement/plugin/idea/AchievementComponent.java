package codes.achievement.plugin.idea;

import org.jetbrains.annotations.NotNull;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class AchievementComponent implements com.intellij.openapi.components.ApplicationComponent {
    @Override
    public void initComponent() {

        //todo:动态注册组件
        //todo:内存、文件，时间缓存
        //todo:文件上传
        //todo:成就拉取，展示


        //注册消息，触发事件，统计成就
//        MessageBus bus = ApplicationManager.getApplication().getMessageBus();
//        MessageBusConnection connection = bus.connect();
//        connection.subscribe(AppTopics.FILE_DOCUMENT_SYNC,
//                new FileDocumentManagerAdapter() {
//                    @Override
//                    public void beforeDocumentSaving(Document document) {
//                        Messages.showMessageDialog(
//                                "Hello World!",
//                                "Sample",
//                                Messages.getInformationIcon()
//
//                        );
//                    }
//                });

        //如何找到所有的消息？
        //找到 openapi.jar ，在包里搜索： `Topic<`
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
