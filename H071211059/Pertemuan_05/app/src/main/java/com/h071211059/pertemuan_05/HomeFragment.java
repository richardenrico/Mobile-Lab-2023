package com.h071211059.pertemuan_05;

import static com.h071211059.pertemuan_05.MainActivity.posts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.h071211059.pertemuan_05.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.LinkedList;

public class HomeFragment extends Fragment {
    public static String EXTRA_POST = "post";
    private FragmentHomeBinding binding;

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
        binding.rvPost.setAdapter(adapter);

    }
}