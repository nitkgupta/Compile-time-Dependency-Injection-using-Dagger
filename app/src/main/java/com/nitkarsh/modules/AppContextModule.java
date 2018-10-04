package com.nitkarsh.modules;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {

    private Context context;
    public AppContextModule(Context context){
        this.context=context;
    }

    @Named("application_context")
    @Provides
    private Context getContext(){
        return context.getApplicationContext();
    }

}
