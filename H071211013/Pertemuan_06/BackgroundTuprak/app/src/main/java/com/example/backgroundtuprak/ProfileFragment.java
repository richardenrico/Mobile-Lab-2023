package com.example.backgroundtuprak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.backgroundtuprak.datasource.UserDataSource;
import com.example.backgroundtuprak.model.User;

public class ProfileFragment extends Fragment {
    public static final int userId = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        User user;
        UserDataSource userDataSource = new UserDataSource();

        TextView fullNameTextView = view.findViewById(R.id.fullname);
        TextView userNameTextView = view.findViewById(R.id.username);
        ImageView profilePictureImageView = view.findViewById(R.id.profile_picture);
        ProgressBar progressBar = view.findViewById(R.id.progress_bar);

        if (getActivity() instanceof MainActivity) {
            user = userDataSource.getUserById(userId);
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            user = getArguments().getParcelable(DetailProfileActivity.KEY_PROFILE);

            progressBar.setVisibility(View.VISIBLE);
            fullNameTextView.setVisibility(View.GONE);
            userNameTextView.setVisibility(View.GONE);
            profilePictureImageView.setVisibility(View.GONE);

            handler.postDelayed(() -> {
                progressBar.setVisibility(View.GONE);
                fullNameTextView.setVisibility(View.VISIBLE);
                userNameTextView.setVisibility(View.VISIBLE);
                profilePictureImageView.setVisibility(View.VISIBLE);
            }, 500);

        }

        String fullName = user.getFullName();
        String userName = user.getUserName();
        int profilePictureId = user.getProfilePicture();

        fullNameTextView.setText(fullName);
        userNameTextView.setText(userName);
        profilePictureImageView.setImageResource(profilePictureId);

    }
}