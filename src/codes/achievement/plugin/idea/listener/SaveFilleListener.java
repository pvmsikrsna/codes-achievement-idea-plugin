package codes.achievement.plugin.idea.listener;

import codes.achievement.plugin.idea.dto.EventDto;
import codes.achievement.plugin.idea.storage.EventQueue;
import com.intellij.AppTopics;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerAdapter;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class SaveFilleListener implements Listener {
    @Override
    public void register() {
        MessageBus bus = ApplicationManager.getApplication().getMessageBus();
        MessageBusConnection connection = bus.connect();
        connection.subscribe(AppTopics.FILE_DOCUMENT_SYNC,
                new FileDocumentManagerAdapter() {
                    @Override
                    public void fileContentLoaded(VirtualFile file, Document document) {
                        EventQueue.getCurrent().add(new EventDto());
                        System.out.println(EventQueue.getCurrent().size());
                    }
                });
    }
}
