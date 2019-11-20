package fr.donacrio.algobasics.sort;

import fr.donacrio.algobasics.utils.Utils;

import java.util.Arrays;

public class BubbleSortImproved implements Sort{

    @Override
    public void sort(int[] arr) {
        bubbleSortImproved(arr);
    }

    @Override
    public String getName() {
        return("BUBBLE SORT IMPROVED");
    }

    private void bubbleSortImproved(int[] arr) {
        boolean sorted;
        for(int i = 0; i < arr.length; i++) {
            sorted = true;
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    sorted = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if(sorted) {
                break;
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
