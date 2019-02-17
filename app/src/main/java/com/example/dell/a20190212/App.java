package com.example.dell.a20190212;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Fresco的初始化

       /* //磁盘缓存的配置
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPath(getCacheDir())
                .setMaxCacheSize(8*1024*1024)
                .build();
        //把磁盘缓存的设置，设置到三级缓存中
        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();*/
       /* Fresco.initialize(this,pipelineConfig);*/
        Fresco.initialize(this);
    }
}