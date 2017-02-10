public class Seach {
    //在无序序列中查找
    public static int seqSeach(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while(i < n && a[] != elem) {
            i++;
        }
        if(a[i] == elem) {
            return i;
        }else {
            return -1;
        }
    }

    //在有序序列中查找
    public static int orderSeqSearch(int[] a, int elem) {
        int n = a.length;
        while(i < n && a[i] < elem) {
            i++;
        }
        if(a[i] == elem) {
            return i;
        }else {
            return -1;
        }
    }
    
    //二分法查找
    public static int biSeach(int[] a, int elem) {
        int n = a.length;
        int low = 0, high =  n - 1, mid;
        while(low < high) {
            mid = (low + high) / 2;
            if(a[mid] == elem) {
                return mid;
            }else if(a[mid] < elem) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

}