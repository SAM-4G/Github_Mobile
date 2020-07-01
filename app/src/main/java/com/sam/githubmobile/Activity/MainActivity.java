package com.sam.githubmobile.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sam.githubmobile.Data.ArrayLists;
import com.sam.githubmobile.R;
import com.sam.githubmobile.BaseData.UserGithub;
import com.sam.githubmobile.Adapter.UsersAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userRview;
    TextView gitMobile;
    RelativeLayout rMainView;
    private ArrayList<UserGithub> userGithubArrayList;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Are you sure to exit?").setIcon(R.drawable.ic_noun_user_961);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ab.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        rMainView = findViewById(R.id.rvMain);
        gitMobile = findViewById(R.id.appNames);
        userRview = findViewById(R.id.myUserRview);
        userRview.setHasFixedSize(true);

        rMainView.getBackground().setAlpha(70);
        gitMobile.getBackground().setAlpha(35);

        userGithubArrayList = new ArrayList<>();
        userGithubArrayList.addAll(ArrayLists.getUserData());

        setRview();
    }

    private void setRview() {
        userRview.setLayoutManager(new LinearLayoutManager(this));
        UsersAdapter usersAdapter = new UsersAdapter(userGithubArrayList);
        userRview.setAdapter(usersAdapter);
        usersAdapter.setOnItemClickCallback(new UsersAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(UserGithub userArrayList) {
                showNotice(userArrayList);
                Intent intent = new Intent(MainActivity.this, DetailUsers.class);
                intent.putExtra(DetailUsers.EXTRA_USERS_DETAIL, userArrayList);
                startActivity(intent);
            }
        });
    }

    private void showNotice(UserGithub userArrayList) {
        Toast.makeText(this, "Github Users : " + userArrayList.getPersonName(), Toast.LENGTH_SHORT).show();
    }

}