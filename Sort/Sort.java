public /**
 * Sort
 */
public class Sort {

    

//插入排序
    public static void insertSort(int[] a) {
        int i, j, temp;
        int n = a.length;

        for(i = 0; i < n - 1; i++) {
            temp = a[i + 1];
            j = i;
            while(j > -1 && temp <= a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

//希尔排序
    public static void shellSort(int[] a, int[] d, int numOfD) {
        int i, j, k, m, span;
        int temp;
        int n = a.length;

        for(m = 0; m < numOfD; m++) {
            for(i = k; i < n - span; i = i + span) {
                temp = a[i + span];
                j = i;
                while(j > -1 && temp <= a[j]) {
                    a[j + span] = a[j];
                    j = j - span;
                }
                a[j +span] = temp;
            }
        }
    }
}