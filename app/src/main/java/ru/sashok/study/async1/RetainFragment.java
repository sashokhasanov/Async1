package ru.sashok.study.async1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;


public class RetainFragment extends Fragment {

    public static final String RETAIN_FRAGMENT_TAG = "RetainFragment";

    private String[] operationResult;

    private LoadListener loadListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof  MainActivity)
        {
            loadListener = (LoadListener) context;
            if (operationResult != null)
            {
                loadListener.onResult(operationResult);
                operationResult = null;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onDetach() {
        loadListener = null;
        super.onDetach();
    }

    public void setSuccess(String[] data)
    {
        if (loadListener != null)
        {
            loadListener.onResult(data);
        }
        else
        {
            this.operationResult = data;
        }
    }

    public interface LoadListener
    {
        void onResult(String[] data);
    }
}
