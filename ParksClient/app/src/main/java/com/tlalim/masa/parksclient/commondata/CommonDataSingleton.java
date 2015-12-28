package com.tlalim.masa.parksclient.commondata;

import com.tlalim.masa.parksclient.parsetables.News;

import java.util.ArrayList;

/**
 * Created by Marina on 27.12.2015.
 */
public class CommonDataSingleton {
    private static CommonDataSingleton ourInstance = new CommonDataSingleton();

    public static CommonDataSingleton getInstance() {
        return ourInstance;
    }

    private ArrayList<News> arrayHotNews;

    public ArrayList<News> getArrayHotNews() {
        return arrayHotNews;
    }

    private CommonDataSingleton() {
        arrayHotNews = new ArrayList<>();

    }
}
