package com.sam.githubmobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sam.githubmobile.BaseData.UserGithub;
import com.sam.githubmobile.R;

public class DetailUsers extends AppCompatActivity {
    public static final String EXTRA_USERS_DETAIL = "extra_user_detail";

    TextView personName, companyName, address, gitUsername, userRepository, userFollowers, userFollowing;
    CardView cardView;
    Button visitSite;
    String urlGit;
    RelativeLayout rViewDetail;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail_users);

        ImageView avatar = findViewById(R.id.avatarUser);
        personName = findViewById(R.id.personName);
        companyName = findViewById(R.id.companyName);
        address = findViewById(R.id.userAddress);
        gitUsername = findViewById(R.id.gitUsername);
        userRepository = findViewById(R.id.userRepository);
        userFollowers = findViewById(R.id.followersValue);
        userFollowing = findViewById(R.id.followingValue);
        visitSite = findViewById(R.id.visitGithub);

        cardView = findViewById(R.id.card1);
        cardView.getBackground().setAlpha(35);

        rViewDetail = findViewById(R.id.rvDetail);
        rViewDetail.getBackground().setAlpha(70);

        final UserGithub userDetail = getIntent().getParcelableExtra(EXTRA_USERS_DETAIL);

        Glide.with(this).load(userDetail.getUserPict()).into(avatar);
        personName.setText(" " + userDetail.getPersonName());
        companyName.setText(" " + userDetail.getCompany());
        address.setText(" " + userDetail.getAddress());
        gitUsername.setText(" " + userDetail.getUserName());
        userRepository.setText(" " + userDetail.getRepository());
        userFollowers.setText(" " + userDetail.getFollowers());
        userFollowing.setText(" " + userDetail.getFollowing());

        urlGit = userDetail.getUrlGithub();

        visitSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlGit));
                startActivity(githubIntent);
            }
        });
    }
}