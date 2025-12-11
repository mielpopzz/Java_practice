public class Task10 {
    public static void main(String[] args) {
        // Практика #1
        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};
        a1 = a2; // a1 теперь ссылается на тот же массив, что и a2
        a1[0] = 99; // изменится и a2[0]
        System.out.println("a2[0] = " + a2[0]); // 99

        // Практика #2: java.util.Arrays
        int[] arr1 = {3, 1, 4, 1, 5};
        int[] arr2 = {3, 1, 4, 1, 5};
        int[] arr3 = {9, 8, 7, 6};

        // toString(...)
        System.out.println("toString: " + java.util.Arrays.toString(arr1));

        // binarySearch(...)
        java.util.Arrays.sort(arr1);
        int index = java.util.Arrays.binarySearch(arr1, 4);
        System.out.println("binarySearch 4: " + index);

        // equals(...)
        boolean eq = java.util.Arrays.equals(arr1, arr2);
        System.out.println("equals: " + eq);

        // compare(...) - появился в Java 9
        int cmp = java.util.Arrays.compare(arr1, arr3);
        System.out.println("compare: " + cmp);

        // sort(...)
        int[] arr4 = {5, 3, 8, 1};
        java.util.Arrays.sort(arr4);
        System.out.println("sorted: " + java.util.Arrays.toString(arr4));
    }
}