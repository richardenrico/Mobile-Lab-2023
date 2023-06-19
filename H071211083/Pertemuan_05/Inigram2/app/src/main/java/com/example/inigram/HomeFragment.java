package com.example.inigram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView rvPost;
    PostAdapter adapter;
    ArrayList<PostModel> posts;
    TextView tvDesc;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        posts = DataSource.getPosts();

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDesc = view.findViewById(R.id.tv_post);
        Bundle bundle = getArguments();

        System.out.println(bundle);

        rvPost = view.findViewById(R.id.Recycleview);
        rvPost.setHasFixedSize(true);
        rvPost.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PostAdapter(getActivity(), posts);
//            adapter = new PostAdapter(getActivity());
        rvPost.setAdapter(adapter);
        tvDesc.setVisibility(View.GONE);
//        if (bundle != null){
//            posts = bundle.getParcelableArrayList("Post");
//        }else {
//            tvDesc.setText("add a post first!");
//        }
    }
}