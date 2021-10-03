package com.example.myapplication;

import android.app.Application;


import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("EIf68BpiEw3UiYkwsPkOlEoCkUhB9Pl3g3nk8CIa")
                .clientKey("TPmLfzzAfWy6BOPFncwg6ZZLlaTYIHfp0ATCJwCl")
                .server("https://parseapi.back4app.com")
                .build()
        );


    }
}
