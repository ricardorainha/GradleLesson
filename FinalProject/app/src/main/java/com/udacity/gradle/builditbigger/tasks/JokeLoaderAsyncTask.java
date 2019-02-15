package com.udacity.gradle.builditbigger.tasks;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokeLoaderAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi apiService = null;
    private OnJokeLoadListener listener;

    public JokeLoaderAsyncTask(OnJokeLoadListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... pairs) {

        if (apiService == null) {
            MyApi.Builder apiBuilder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/") // Android Emulator
//                    .setRootUrl("http://192.168.230.5:8080/_ah/api/") // Host PC - uncomment to use on real device
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            apiService = apiBuilder.build();
        }

        try {
            return apiService.getRandomJoke().execute().getData();
        }
        catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String randomJoke) {
        super.onPostExecute(randomJoke);

        if (listener != null) {
            listener.onJokeLoaded(randomJoke);
        }
    }

    public interface OnJokeLoadListener {
        void onJokeLoaded(String joke);
    }
}
