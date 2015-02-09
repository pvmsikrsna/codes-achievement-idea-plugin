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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(EventDto entry) {

    }

    @Override
    public EventDto peek() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void setListener(Listener<EventDto> listener) {

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



