package codes.achievement.plugin.idea.worker;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Dozer @ 2015-02
 * mail@dozer.cc
 * http://www.dozer.cc
 */
public class EventUploader {
    private Thread worker;

    private String baseUrl;

    private static final String UPLOAD_PATH = "/upload";

    public void init() {
        Preconditions.checkArgument(Strings.isNullOrEmpty(baseUrl));

        worker = new Thread(new EventUploaderThread());
        worker.setName("EventUploader");
        worker.setDaemon(true);
        worker.start();
    }

    public void close() {
        worker.interrupt();
    }

    class EventUploaderThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "asda");
                Request request = new Request.Builder()
                        .url(baseUrl + UPLOAD_PATH)
                        .post(body)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    response.code();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(5 * 60 * 1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
