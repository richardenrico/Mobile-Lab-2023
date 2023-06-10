package com.example.tp_mobile_8_ke_3;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    SearchView searchView;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    List<UserModel> filterUsers;
    SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Handler handler = new Handler();
        filterUsers = new ArrayList<>();
        searchView = view.findViewById(R.id.searchView);
        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerview);

        searchView.clearFocus();
        recyclerView.setVisibility(View.INVISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        },1500);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchAdapter = new SearchAdapter((ArrayList<UserModel>) filterUsers);
        recyclerView.setAdapter(searchAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItem(newText);
                return true;
            }
        });
    }
    private void filterItem(String newText) {
        filterUsers.clear();
        if (newText.isEmpty()){
            searchAdapter.notifyDataSetChanged();
            return;
        }
        ArrayList<UserModel>users = HomeFragment.dataSource.getUsers();
        UserModel user = users.get(0);

        for (int i = 0; i < users.size(); i++) {

            UserModel user1 = users.get(i);

            if (i > 0) {

                if (user.getUsername().equals(user1.getUsername()) ||
                        user.getName().equals(user1.getName())) {

                    continue;
                }
            }

            if (user1.getName().toLowerCase().contains(newText.toLowerCase()) ||
                    user1.getUsername().toLowerCase().contains(newText.toLowerCase())) {

                filterUsers.add(user1);
            }

            user = user1;
        }

        searchAdapter.notifyDataSetChanged();
    }
}
