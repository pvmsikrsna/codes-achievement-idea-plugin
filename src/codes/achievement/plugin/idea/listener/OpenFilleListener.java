package codes.achievement.plugin.idea.listener;

import codes.achievement.plugin.idea.dto.EventDto;
import codes.achievement.plugin.idea.storage.EventQueue;
import com.google.common.base.Strings;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class OpenFilleListener implements Listener {
    @Override
    public void register() {
        MessageBus bus = ApplicationManager.getApplication().getMessageBus();
        MessageBusConnection connection = bus.connect();
        connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerListener() {
            @Override
            public void fileOpened(FileEditorManager source, VirtualFile file) {
                String extension = Strings.isNullOrEmpty(file.getExtension()) ? "unknow" : file.getExtension();
                EventQueue.getCurrent().add(new EventDto("open-file-" + extension));
            }

            @Override
            public void fileClosed(FileEditorManager source, VirtualFile file) {

            }

            @Override
            public void selectionChanged(FileEditorManagerEvent event) {

            }
        });
    }
}
