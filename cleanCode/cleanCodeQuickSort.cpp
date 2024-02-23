#include <stdio.h>

void swap(int* firstElement, int* secondElement) {
    int temporal = *firstElement;
    *firstElement = *secondElement;
    *secondElement = temporal;
}

void quickSort(int array[], int low, int high) {
    if (low < high) {
        int pivotIndice = partition(array, low, high);

        quickSort(array, low, pivotIndice - 1);
        quickSort(array, pivotIndice + 1, high);
    }
}

int partition(int array[], int low, int high) {
    int pivot = array[high];
    int positionI = (low - 1);

    for (int positionJ = low; positionJ <= high - 1; positionJ++) {
        if (array[positionJ] < pivot) {
            positionI++;
            swap(&array[positionI], &array[positionJ]);
        }
    }
    swap(&array[positionI + 1], &array[high]);
    return (positionI + 1);
}

int main() {
    int array[] = {10, 7, 8, 9, 1, 5};
    int n = sizeof(array) / sizeof(array[0]);
    printf("Original array: ");
    for (int positionI = 0; positionI < n; positionI++) {
        printf("%d ", array[positionI]);
    }
    printf("\n");

    quickSort(array, 0, n - 1);

    printf("Sorted array: ");
    for (int positionI = 0; positionI < n; positionI++) {
        printf("%d ", array[positionI]);
    }
    printf("\n");
    return 0;
}
