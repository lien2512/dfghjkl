import java.util.*;
public class BubbleSort {
    public static int[] nhap(int n)

    {
        int [] a = new int [n];
        Random rd = new Random();
        for(int i =0 ;i< n;i++)
        {
            a[i] = rd.nextInt(1000);
        }
        return a;
    }
    public static void bubbleSort(int a[]){
        int n = a.length;
        for(int i = 0;i<n-1;i++)
        {
            for(int j = n-1;j>i;j--)
            {
                if(a[j]<a[j-1])
                {
                    int tem = a[j-1];
                    a[j-1]=a[j];
                    a[j] = tem;
                }
            }
        }
    }
    public static void xuat(int a[])
    {
        int n = a.length;
        for(int i = 0; i< n;i++)
        {
            System.out.print(a[i] + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 1000;
        int a[] = nhap(n);
        xuat(a);
        bubbleSort(a);
        xuat(a);



    }

}
