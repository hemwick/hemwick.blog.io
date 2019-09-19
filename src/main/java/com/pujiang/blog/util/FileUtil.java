package com.pujiang.blog.util;

import java.io.File;

public class FileUtil {
    public static String[] getFilesList(String path){
        File file=new File(path);
        if(file.exists()){
            return file.list();
        }
        return new String[0];
    }

    public static boolean deleteFile(String path){
        File file=new File(path);
        if(file.exists()){
            return file.delete();
        }
        return false;
    }
}
