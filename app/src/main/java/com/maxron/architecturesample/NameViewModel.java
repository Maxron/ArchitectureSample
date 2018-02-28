package com.maxron.architecturesample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by maxron on 2018/2/28.
 */

public class NameViewModel extends ViewModel {
    private MutableLiveData<String> currentName;


    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

}
