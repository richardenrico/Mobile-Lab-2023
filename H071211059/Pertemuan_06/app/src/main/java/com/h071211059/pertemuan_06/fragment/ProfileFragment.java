package com.h071211059.pertemuan_06.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.h071211059.pertemuan_06.R;
import com.h071211059.pertemuan_06.model.User;
import com.h071211059.pertemuan_06.datasource.UserDataSource;
import com.h071211059.pertemuan_06.activity.MainActivity;
import com.h071211059.pertemuan_06.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    private static ProfileFragment instance;

    private ProfileFragment() {};

    public static ProfileFragment getInstance() {
        if (instance == null) {
            instance = new ProfileFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            User user = getArguments().getParcelable("user");
            System.out.println(user.getName());

            binding.tvUsername.setText(user.getUsername());
            binding.tvName.setText(user.getName());
            binding.ivProfile.setImageResource(user.getImage());
        }

        if (getActivity() instanceof MainActivity) {
            TextView tv = getActivity().findViewById(R.id.tv_title);
            User user = UserDataSource.users.get(0);

            binding.tvUsername.setText(user.getUsername());
            binding.tvName.setText(user.getName());
            binding.ivProfile.setImageResource(user.getImage());
            tv.setText("Profile");
        }
    }
}