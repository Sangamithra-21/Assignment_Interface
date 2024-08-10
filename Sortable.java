package Assignment_14_Interface;

import java.util.Arrays;
import java.util.Scanner;

public interface Sortable {
    void sort(int[] nums);
}
class BubbleSort implements Sortable{

    @Override
    public void sort(int nums[]) {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]>nums[j])
                {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
}
class QuickSort implements Sortable{

    @Override
    public void sort(int nums[]) {
         quicksort(nums,0,nums.length-1);
    }

    static int partition(int arr[], int lb, int ub) {
        int pivot = arr[lb];
        int start = lb + 1;
        int end = ub;

        while (start <= end) {
            while (start <= end && arr[start] <= pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        int temp = arr[end];
        arr[end] = arr[lb];
        arr[lb] = temp;

        return end;
    }

    static void quicksort(int arr[], int lb, int ub) {
        if (lb < ub) {
            int val = partition(arr, lb, ub);
            quicksort(arr, lb, val - 1);
            quicksort(arr, val + 1, ub);
        }
    }
}

class MergeSort implements Sortable{

    @Override
    public void sort(int[] nums) {
        mergeSort(nums,0,nums.length-1);
    }
    void mergeSort(int nums[],int start,int end)
    {
        if(start<end)
        {
            int mid=(start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    void merge(int[] nums,int start,int mid,int end)
    {
        int i=start;
        int k=start;
        int j=mid+1;
        int[] arr=new int[nums.length];
        while(i<=mid && j<=end)
        {
            if(nums[i]<nums[j])
            {
                arr[k++]=nums[i++];
            }
            else
            {
                arr[k++]=nums[j++];
            }
        }
        while(i<=mid)
        {
            arr[k++]=nums[i++];
        }
        while(j<=end)
        {
            arr[k++]=nums[j++];
        }

        for(int r=start;r<=end;r++)
        {
            nums[r]=arr[r];
        }
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("1) Bubble Sort 2) QuickSort 3) Merge Sort");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1 :
                Sortable bubble=new BubbleSort();
                bubble.sort(nums);
                break;
            case 2 :
                Sortable quick=new QuickSort();
                quick.sort(nums);
                break;
            case 3 :
                Sortable merge=new MergeSort();
                merge.sort(nums);
                break;
        }
        System.out.println(Arrays.toString(nums));
    }
}
