package fr.donacrio.algobasics.utils;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Utils {

    public static int[] randomIntArray(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
        }
        return arr;
    }

    public static Color[] getColors(int n) {
        Class clazz = Color.class;
        Field[] colorFields = clazz.getDeclaredFields();

        Color[] colors = new Color[n];
        int i = 0;
        while (i < n) {
            for(int j = 0; j < colorFields.length / 2; j += 2){
                Field cf = colorFields[j];
                int modifiers = cf.getModifiers();
                if (!Modifier.isPublic(modifiers))
                    continue;
                try {
                    Color c = (Color) cf.get(null);
                    colors[i++] = c;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (i == n) {
                    break;
                }
            }
        }
        return colors;
    }
}
