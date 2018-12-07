package jutikorn.sampletodo.ui.main.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

public class SSS {

    void asdasd(LiveData<String> source) {
        final MediatorLiveData<String> result = new MediatorLiveData<>();
        result.addSource(source, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String x) {
                // do something here
            }
        });
    }
}
