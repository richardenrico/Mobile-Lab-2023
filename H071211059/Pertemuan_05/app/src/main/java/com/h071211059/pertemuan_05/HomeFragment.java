package com.h071211059.pertemuan_05;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.h071211059.pertemuan_05.databinding.FragmentHomeBinding;

import java.util.LinkedList;

public class HomeFragment extends Fragment {
    public static String EXTRA_POST = "post";
    private FragmentHomeBinding binding;
    private static HomeFragment instance;
    private final LinkedList<Post> posts = new LinkedList<>();

    private HomeFragment() {
    }

    public static HomeFragment getInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitle = getActivity().findViewById(R.id.tv_title);
        tvTitle.setText("Home");

        if (getArguments() != null) {
            Post newPost = getArguments().getParcelable(EXTRA_POST);
            setArguments(null);
            posts.addFirst(newPost);
        }

        if (posts.size() != 0) {
            binding.tvAlert.setVisibility(View.GONE);
            setRecyclerView(posts);
        }
    }

    private void setRecyclerView(LinkedList<Post> posts) {
        binding.rvPost.setLayoutManager(new LinearLayoutManager(getContext()));
        PostAdapter adapter = new PostAdapter(posts);
        adapter.setClickListener(() -> {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        });
        binding.rvPost.setAdapter(adapter);
    }
}