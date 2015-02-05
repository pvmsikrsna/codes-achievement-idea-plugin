package codes.achievement.plugin.idea;

import com.intellij.AppTopics;
import com.intellij.ProjectTopics;
import com.intellij.execution.ExecutionListener;
import com.intellij.execution.ExecutionManager;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerAdapter;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.ModuleAdapter;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.impl.ProjectLifecycleListener;
import com.intellij.openapi.roots.ModuleRootAdapter;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.util.messages.MessageHandler;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class AchievementComponent implements com.intellij.openapi.components.ApplicationComponent {
    @Override
    public void initComponent() {

        //注册消息，触发事件，统计成就
        MessageBus bus = ApplicationManager.getApplication().getMessageBus();
        MessageBusConnection connection = bus.connect();
        connection.subscribe(AppTopics.FILE_DOCUMENT_SYNC,
                new FileDocumentManagerAdapter() {
                    @Override
                    public void beforeDocumentSaving(Document document) {
                        Messages.showMessageDialog(
                                "Hello World!",
                                "Sample",
                                Messages.getInformationIcon()

                        );
                    }
                });

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
