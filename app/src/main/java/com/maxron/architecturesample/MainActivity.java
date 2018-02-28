package com.maxron.architecturesample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.name_label)
    TextView nameLabel;

    private NameViewModel nameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        handleNameViewModel();
    }

    private void handleNameViewModel() {
        // Get the ViewModel
        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        nameViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newName) {
                Log.d(TAG, "onChanged: ");
                nameLabel.setText(newName);
            }
        });
    }

    @OnClick(R.id.update_btn)
    public void onClick(View v) {
        String anotherName = "John Doe";
        nameViewModel.getCurrentName().setValue(anotherName);
    }
}
