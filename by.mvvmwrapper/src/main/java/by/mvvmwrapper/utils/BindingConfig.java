package by.mvvmwrapper.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.03.16<br>
 * Time: 0:24<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class BindingConfig {

    //======================================================
    //----------------------Interfaces----------------------
    //======================================================

    //======================================================
    //----------------------Constants-----------------------
    //======================================================

    //======================================================
    //---------------------View components------------------
    //======================================================

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private static BindingConfig sInstance;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    private BindingConfig() {
    }

    //======================================================
    //--------------------Private methods-------------------
    //======================================================
    private void initImageLoader(@NonNull Context context) {
        File cacheDir = StorageUtils.getCacheDirectory(context);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800)
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .imageDownloader(new BaseImageDownloader(context))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    public void init(@NonNull Context context) {
        initImageLoader(context);
    }

    public void destroy() {
        ImageLoader.getInstance().destroy();
    }

    public static BindingConfig getInstance() {
        if (sInstance == null) {
            sInstance = new BindingConfig();
        }
        return sInstance;
    }
}