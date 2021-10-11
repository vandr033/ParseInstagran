package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.fragments.ComposeFragment;
import com.example.myapplication.fragments.PostsFragment;
import com.example.myapplication.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView menu_bottom_navigation_View;

    final Fragment fragment_compose = new ComposeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_bottom_navigation_View = findViewById(R.id.bottom_navigation);

        menu_bottom_navigation_View.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
//                MenuItem actionHome = menu_bottom_navigation_View.findViewById(R.id.action_home);
//                MenuItem actionCompose = menu_bottom_navigation_View.findViewById(R.id.action_compose);
//                MenuItem actionProfile = menu_bottom_navigation_View.findViewById(R.id.action_profile);

                switch (item.getItemId()) {
                    case R.id.action_home:
//                   Toast.makeText(MainActivity.this, "action home", Toast.LENGTH_SHORT).show();
                        fragment = new PostsFragment();

                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();

                        break;
                    case R.id.action_profile:
                    default:
                      Toast.makeText(MainActivity.this, "action profile", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }

        });
    menu_bottom_navigation_View.setSelectedItemId(R.id.action_home);
    }
}