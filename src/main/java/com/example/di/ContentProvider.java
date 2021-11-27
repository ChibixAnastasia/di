package com.example.di;

import org.springframework.stereotype.Component;

@Component
public class ContentProvider {

    private final Bundle bundle;

    public ContentProvider(Bundle bundle) {
        this.bundle = bundle;
    }


    public Bundle getBundle() {
        return bundle;
    }


}
