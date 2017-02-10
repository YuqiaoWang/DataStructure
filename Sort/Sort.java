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

    //冒泡排序
    public static void bubbleSort(int[] a) {
        int i, j, flag = 1;
        int temp;
        int n = a.length;

        for(i = 1; i < n && flag == 1; i ++) {
            flag = 0;       //为了提前结束排序算法
            for(j = 0; j < n - 1; j++) {
                if(a[j] > a[j + 1]) {
                    flag = 1;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] a, int low, int high) {
        int i, j;
        int temp;
        i = low;
        j = high;
        temp = a[low];

        while(i < j) {
            //在数组右端扫描
            while(i < j && temp <= a[j]) {
                j--;
            }
            if(i < j) {
                a[i] = a[j];
                i++;
            }

            //在数组左端扫描
            while(i < j && a[i] < temp) {
                i++;
            }
            if(i < j) {
                a[j] =a[i];
                j--;
            }
        }
        a[i] = temp;

        if(low < i) quickSort(a, low, i - 1);
        if(i < high) quickSort(a, j + 1, high);
    }

    //基数排序
    public static void radixSort(int[] a, int m, int d) throws Exception {
        //d 为进制的基数，m 为数据元素的最大位数
        int n = a.length;
        int i, j, k, l, power = 1;
        LinQueue[] myQueque = new LinQueue[d];

        //创建链式队列数组对象
        for(i = 0; i < d; i++) {
            LinQueue temp = new LinQueue();
            myQueue[i] = temp;
        }
        //进行m次排序
        for(i= 0；i < m; i++) {
            if(i == 0) {
                power = 1;
            }else {
                power = power * d;
            }

            //依次将n个数据元素按第k位的大小放到相应的队列中
            for(j = 0; j < n; j++) {
                k = a[j] / power - (a[j] / (power * d)) * d; //计算k值
                myQueque[k].append(new Interger(a[j]));
            }

            //顺序回收各队列中的数据元素到数组a中
            l = 0;
            for(j = 0; j < d; j++) {
                while(myQueque[j].notEmpty()) {
                    a[l] = ((Integer)myQueque[j].delete()).intValue();
                    l++;
                }
            }
        }
    }

}