package ru.sashok.study.async1;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;


public class GetDataTask extends AsyncTask<Void, Void, String[]> {
    private WeakReference<RetainFragment> retainFragment;

    public GetDataTask(RetainFragment retainFragment) {
        this.retainFragment = new WeakReference<>(retainFragment);
    }

    @Override
    protected String[] doInBackground(Void... voids) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String[] result = {"aaa", "bbb", "ccc"};

        return result;
    }

    @Override
    protected void onPostExecute(String[] strings) {
        super.onPostExecute(strings);

        RetainFragment retainFragment = this.retainFragment.get();
        retainFragment.setSuccess(strings);
    }
}
