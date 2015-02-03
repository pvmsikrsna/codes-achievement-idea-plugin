package codes.achievement.plugin.idea;

import com.intellij.AppTopics;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerAdapter;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;
import org.jetbrains.annotations.NotNull;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class AchievementComponent implements com.intellij.openapi.components.ApplicationComponent {
	@Override public void initComponent() {
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
	}

	@Override public void disposeComponent() {

	}

	@NotNull @Override public String getComponentName() {
		return "Codes Achievement Component";
	}
}
