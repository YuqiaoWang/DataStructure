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

//不稳定直接选择排序
    public static void selectSort(int[] a) {
        int i, j, small;
        int temp;
        int n = a.length;

        for(i = 0; i < n - 1; i++) {
            small = i;
            for(j = i + 1; j < n; j++) {
                if(a[j] <a[small]) {
                    small = j;
                }
                if(small != i) {
                    temp = a[i];
                    a[i] = a[small];
                    a[small] = temp;
                }
            }
        }
    }

//稳定直接选择排序
    public static void selectSort2(int[] a) {
        int i, j ,small;
        int temp;
        int n = a.length;

        for(i = 0; i < n - 1; i++) {
            small = i;
            for(j = i + 1; j < n; j++) {
                if(a[j] < a[small]) {
                    small = j;
                }
            }
            if(small != i) {
                temp = a[small];
                for(j = small; j > i; j--) {
                    a[j] = a[j-1];
                }
                a[i] = temp;
            }
        }
    }


    //创建堆
    public static void createHeap(int[] a, int n, int h) {
        int i, j, flag;
        int temp;

        i = h;          //i 为要建堆的二叉树根节点下标;
        j = 2 * i + 1;  //j 为 i 结点的左孩子结点的下标;
        temp = a[i];
        flag = 0;

        //沿左右孩子中值较大者重复向下筛选
        while(j < n && flag != 1) {
            //寻找左右孩子结点中的较大者，j为其下标
            if(j < n - 1 && a[j] < a[j+1]) {
                j++;
            }
            if(temp > a[j]) {
                flag = 1;
            }else {
                a[i] = a[j];
                i = j;
                j = 2 * i + 1;
            }
        }
        a[i] = temp;
    }

    //初始化最大堆算法
    public static void initCreateHeap(int[] a) {
        int n = a.length;
        for(int i = (n - 1) / 2; i >= 0; i--) {
            createHeap(a, n, i);
        }
    }

    //堆排序算法
    public static void heapSort(int[] a) {
        int temp;
        int n = a.length;

        initCreateHeap(a);

        for(int i = n - 1; i > 0; i--) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            createHeap(a, i, 0);
        }
    }

}