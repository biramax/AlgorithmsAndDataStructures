
public class HeapSort {
    
    public static void main(String[] args) {
        
        int[] arr = {4, 2, 5, 8, 1, 9, 2, 3, 6};
        
        printArr(arr);
        
        sort(arr);
    
        printArr(arr);
    }
    
    
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i ++)
            System.out.print(arr[i]+" ");
        
        System.out.print("\n");
    }
    
    
    public static void sort(int[] arr) {
        
        int n = arr.length;

        // Строим бинарную "кучу" (перегруппировываем массив)
        // Берём середину массива в качестве корня кучи
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий уровень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        
        int largest = i; // Считаем, что на месте корня у нас наибольший элемент
        int l = 2 * i + 1; // Левый дочерний элемент
        int r = 2 * i + 2; // Правый дочерний элемент

        // Если левый дочерний элемент больше корня, делаем его корнем
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше корня, делаем его корнем
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если корень изменился, производим замену в элементах
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Рекурсивно обрабатываем всё затронутое дерево элементов
            heapify(arr, n, largest);
        }
    }
}