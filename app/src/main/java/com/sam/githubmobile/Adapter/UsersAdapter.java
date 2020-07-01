package com.sam.githubmobile.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sam.githubmobile.R;
import com.sam.githubmobile.BaseData.UserGithub;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserGithubArrayList> {
    private ArrayList<UserGithub> userGithubArrayList;
    private OnItemClickCallback onItemClickCallback;

    public UsersAdapter(ArrayList<UserGithub> userGithubArrayList) {
        this.userGithubArrayList = userGithubArrayList;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public UserGithubArrayList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_rview, parent, false);
        return new UserGithubArrayList(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserGithubArrayList itemList, int itemPosition) {
        final UserGithub userGithub = userGithubArrayList.get(itemPosition);
        itemList.personName.setText(userGithub.getPersonName());
        itemList.userName.setText(" " + userGithub.getUserName());
        itemList.company.setText(" " + userGithub.getCompany());
        Glide.with(itemList.itemView.getContext())
                .load(userGithub.getUserPict())
                .apply(new RequestOptions().override(80, 25))
                .into(itemList.userPictures);
        itemList.address.setText(" " + userGithub.getAddress());
        itemList.follows.setText(" " + userGithub.getFollowers() + " : " + userGithub.getFollowing());
        itemList.repository.setText(" " + userGithub.getRepository());

        itemList.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(userGithub);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userGithubArrayList.size();
    }

    public static class UserGithubArrayList extends RecyclerView.ViewHolder {
        ImageView userPictures;
        TextView personName, userName, company, address, follows, repository;

        public UserGithubArrayList(@NonNull View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.personName);
            userName = itemView.findViewById(R.id.gitUsername);
            company = itemView.findViewById(R.id.companyName);
            userPictures = itemView.findViewById(R.id.userPictures);
            address = itemView.findViewById(R.id.userAddress);
            follows = itemView.findViewById(R.id.followersId);
            repository = itemView.findViewById(R.id.repositoryId);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(UserGithub userArrayList);
    }

}
