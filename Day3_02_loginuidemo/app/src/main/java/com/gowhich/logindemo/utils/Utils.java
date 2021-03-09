package com.gowhich.logindemo.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Utils {
    public static boolean saveInfoByContext(Context context, String userName, String password) {
        String userInfo = userName+"##"+password;
        try {
            FileOutputStream fos = context.openFileOutput("info2.txt", Context.MODE_PRIVATE);
            fos.write(userInfo.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 保存用戶名和密碼
     * @param userName 用户名
     * @param password 密码
     * @return 是否保存
     */
    public static boolean saveInfo(String userName, String password) {
        String userInfo = userName+"##"+password;
        File file = new File("data/data/com.gowhich.logindemo/info.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(userInfo.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] readInfoByContext(Context context) {
        FileInputStream fis = null;

        try {
            fis = context.openFileInput("info2.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String tmp = reader.readLine();
            return tmp.split("##");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取保存的用户名和密码
     * @return 用户名和密码
     */
    public static String[] readInfo() {
        File file = new File("data/data/com.gowhich.logindemo/info.txt");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String tmp = reader.readLine();
            String[] result = tmp.split("##");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
