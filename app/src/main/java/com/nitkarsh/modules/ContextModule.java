package com.nitkarsh.modules;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

//    @Inject
//    ContextModule(){
//
//    }

    public ContextModule(Context context){
        this.context=context;
    }

    @Named("activity_context")
    @Provides
    public Context getContext(){
        return context.getApplicationContext();
    }

}
