import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 4, 15, 3, 8, 2, 11};
        heapify(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearch(arr, 111, 0, arr.length - 1));

    }
    public static void buble(int[] arr){
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i <  arr.length - 1; i ++){
                if(arr[i] > arr[i+1]){
                    int a = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = a;
                    finish = false;
                }
            }
        }while (!finish);
    }

    public static void directSort(int[] arr){
        for (int i = 0; i < arr.length-1; i ++){
            int minPos = i;
            for (int j = i + 1; j < arr.length; j ++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            if (i != minPos){
                int temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = temp;
            }
        }
    }

    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length  - 1; i ++){
            for (int j = i+1; j < arr.length; j ++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int val, int min, int max){
        int midPoint ;
        if (max < min){
            return -1;
        } else {
            midPoint = (max - min)/2 + min;
        }
        if (arr[midPoint] > val){
            return binarySearch(arr, val, min, midPoint - 1);
        } else {
            if (arr[midPoint] < val){
               return binarySearch(arr, val, midPoint +  1, max);
            } else {
                return midPoint;
            }
        }


    }

    public static void sort(int[] arr, int startPos, int endPos){
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = arr[(startPos + endPos) / 2];
        do{
            while (arr[leftPos] < pivot){
                leftPos ++;
            }
            while (arr[rightPos] > pivot){
                rightPos --;
            }
            if (leftPos <= rightPos){
                if (leftPos < rightPos){
                    int temp = arr[leftPos];
                    arr[leftPos] = arr[rightPos];
                    arr[rightPos] = temp;
                }
                leftPos ++;
                rightPos --;
            }
        } while (leftPos <= rightPos);

        if (leftPos < endPos){
            sort(arr, leftPos, endPos );
        }
        if (rightPos > startPos){
            sort(arr, startPos, rightPos);
        }
    }

    public static void heapify(int[] arr, int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChild = rootIndex * 2 + 1;
        int rightChild = rootIndex * 2 + 2;

        if (leftChild < heapSize && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        if (largest != rootIndex){
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;

            heapify(arr, heapSize, largest);
        }
    }
    public static void heapSort(int[] arr){
        for (int i = arr.length/2 - 1; i >= 0; i --){
            heapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i >= 0; i --){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

}
