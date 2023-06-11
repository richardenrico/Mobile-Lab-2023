package com.lev.inigaram;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment {

    RecyclerView rvPost;
    ItemAdapter adapter;
    TextView tvDesc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity parent = (MainActivity) getActivity();
        parent.tvToolbar.setText("Inigaram");
        tvDesc = view.findViewById(R.id.tv_desc);
        rvPost = view.findViewById(R.id.rv_post);

        Bundle bundle = getArguments();

        if (bundle != null) {
            ItemModel post = bundle.getParcelable("POST");
            parent.listdata.add(0, post);
        }

        if (parent.listdata.size() > 0) {
            rvPost.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new ItemAdapter(getActivity(), parent.listdata);
            rvPost.setAdapter(adapter);
            System.out.println(parent.listdata);
            tvDesc.setVisibility(View.GONE);
        }
    }
}