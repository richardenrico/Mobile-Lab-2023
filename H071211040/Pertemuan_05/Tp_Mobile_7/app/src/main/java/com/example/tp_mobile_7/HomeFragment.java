package com.example.tp_mobile_7;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    TextView tv_Note;
    RecyclerView rv_Home;
    private static ArrayList<Post> postList;
    private static PostAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tv_Note = view.findViewById(R.id.tvNote);
        rv_Home = view.findViewById(R.id.rvHome);

        if (postList == null) {
            postList = new ArrayList<>();
        }

        rv_Home = view.findViewById(R.id.rvHome);

        if (postList == null) {
            postList = new ArrayList<>();
        }
        adapter = new PostAdapter(postList, getContext());
        rv_Home.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_Home.setAdapter(adapter);

        Bundle bundle = getArguments();
        if (bundle == null) {
            rv_Home.setVisibility(View.GONE);
        } else {
            Uri uri = bundle.getParcelable("Image");
            String putCapt = bundle.getString(PostFragment.Key1);

            boolean isDataExists = false;
            for (Post post : postList) {
                if (post.getCaption().equals(putCapt) && post.getImagePost().equals(uri)) {
                    isDataExists = true;
                    break;
                }
            }

            if (!isDataExists) {
                postList.add(0, new Post(putCapt, uri));
                adapter.notifyItemInserted(0);
            }

            rv_Home.setVisibility(View.VISIBLE);
        }
        return view;
    }
}