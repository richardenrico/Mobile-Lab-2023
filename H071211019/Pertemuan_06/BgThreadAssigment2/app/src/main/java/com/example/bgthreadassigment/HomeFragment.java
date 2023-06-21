package com.example.bgthreadassigment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgthreadassigment.Adapter.PostAdapter;
import com.example.bgthreadassigment.DataSources.PostData;
import com.example.bgthreadassigment.Models.PostModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView homeContentRv;
    private TextView noPostTv;
    private ArrayList<PostModel> posts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView();

        PostData postData = new PostData(getContext());
        boolean isRefresh = postData.getRefresh();

        Bundle bundle = getArguments();

        if (!isRefresh) {
            Log.d("HomeFragment Bundle Status", "Tidak ada data dikirimkan");
            posts = postData.getPosts();
            postData.setRefresh(true);
        } else {
            Log.d("HomeFragment Bundle Status", "Ada data dikirimkan " + bundle);
            if(bundle !=null) {
                PostModel newData = bundle.getParcelable("postModel");
                postData.setPost(newData);
            }
            posts = postData.getPosts();
        }

        noPostTv.setVisibility(View.GONE);

        homeContentRv.setHasFixedSize(true);
        homeContentRv.setLayoutManager(new LinearLayoutManager(getContext()));

        PostAdapter postAdapter = new PostAdapter(posts, getContext());
        homeContentRv.setAdapter(postAdapter);

    }

    void setView() {
        homeContentRv = getView().findViewById(R.id.homeContentRv);
        noPostTv = getView().findViewById(R.id.noPostTv);
        posts = new ArrayList<>();
    }
}