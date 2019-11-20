package fr.donacrio.algobasics.sort;

import fr.donacrio.algobasics.utils.Utils;

import java.util.Arrays;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    @Override
    public String getName() {
        return("QUICK SORT");
    }

    private void quickSort(int[] arr, int lower, int higher) {
        if(lower < higher) {
            int pivotIndex = partition(arr, lower, higher);
            quickSort(arr, lower, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, higher);
        }
    }

    private int partition(int[] arr, int lower, int higher) {
        int pivot = arr[higher];
        int i = lower - 1;

        for(int j = lower; j < higher; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, higher);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = Utils.randomIntArray(10);
        System.out.println(Arrays.toString(arr));
        Sort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
