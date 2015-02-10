package codes.achievement.plugin.idea.storage;

import codes.achievement.plugin.idea.dto.EventDto;
import com.google.gson.Gson;
import com.squareup.tape.FileObjectQueue;
import com.squareup.tape.ObjectQueue;

import java.io.*;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class EventQueue implements ObjectQueue<EventDto> {
    private static EventQueue current;

    private final ObjectQueue<EventDto> inner;

    public static ObjectQueue<EventDto> getCurrent() {
        if (current == null) {
            synchronized (EventQueue.class) {
                if (current == null) {
                    current = new EventQueue();
                }
            }
        }
        return current;
    }

    private EventQueue() {
        ObjectQueue<EventDto> temp = null;
        try {
            temp = new FileObjectQueue<>(new File("codes-achievement-idea-event-queue"), new GsonConverter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        inner = temp;
    }


    @Override
    public int size() {
        return inner.size();
    }

    @Override
    public void add(EventDto entry) {
        inner.add(entry);
    }

    @Override
    public EventDto peek() {
        return inner.peek();
    }

    @Override
    public void remove() {
        inner.remove();
    }

    @Override
    public void setListener(Listener<EventDto> listener) {
        inner.setListener(listener);
    }


    public class GsonConverter implements FileObjectQueue.Converter<EventDto> {
        private final Gson gson = new Gson();

        @Override
        public EventDto from(byte[] bytes) {
            Reader reader = new InputStreamReader(new ByteArrayInputStream(bytes));
            return gson.fromJson(reader, EventDto.class);
        }

        @Override
        public void toStream(EventDto object, OutputStream bytes) throws IOException {
            Writer writer = new OutputStreamWriter(bytes);
            gson.toJson(object, writer);
            writer.close();
        }
    }
}



