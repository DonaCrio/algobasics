package fr.donacrio.algobasics.sort;

import fr.donacrio.algobasics.utils.Utils;

import java.util.Arrays;

public class MergeSort implements Sort{

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    @Override
    public String getName() {
        return("MERGE SORT");
    }

    private void mergeSort(int[] arr, int lower, int higher) {
        if(lower < higher) {
            int mid = (lower + higher) / 2;
            mergeSort(arr, lower, mid);
            mergeSort(arr, mid + 1, higher);
            merge(arr, lower, mid, higher);
        }
    }

    private void merge(int[] arr, int lower, int mid, int higher) {
        int sizeLeft = mid - lower + 1;
        int sizeRight = higher - mid;

        int[] L = new int[sizeLeft];
        int[] R = new int[sizeRight];
        for(int i = 0; i < sizeLeft; i++) {
            L[i] = arr[lower + i];
        }
        for(int j = 0; j < sizeRight; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = lower;
        while(i < sizeLeft && j < sizeRight) {
            if(L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while(i < sizeLeft) {
            arr[k++] = L[i++];
        }
        while(j < sizeRight) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = Utils.randomIntArray(10);
        System.out.println(Arrays.toString(arr));
        Sort sort = new MergeSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
