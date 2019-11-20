package fr.donacrio.algobasics.sort;

import fr.donacrio.algobasics.utils.Utils;

import java.util.Arrays;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        bubbleSort(arr);
    }

    @Override
    public String getName() {
        return("BUBBLE SORT");
    }

    private void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Utils.randomIntArray(10);
        System.out.println(Arrays.toString(arr));
        Sort sort = new BubbleSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
