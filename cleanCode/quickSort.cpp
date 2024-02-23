#include <stdio.h>

int a[10];

void quick(int, int);
int p(int, int);

void quick(int l, int h) {
    int p, i, j, t;
    if (l < h) {
        p = p(l, h);
        quick(l, p - 1);
        quick(p + 1, h);
    }
}

int p(int l, int h) {
    int p, i, j, t;
    p = a[l];
    i = l + 1;
    j = h;
    while (i <= j) {
        while (a[i] <= p && i <= h)
            i++;
        while (a[j] > p && j >= l)
            j--;
        if (i < j) {
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
    t = a[l];
    a[l] = a[j];
    a[j] = t;
    return j;
}

int main() {
    int n, i;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    printf("Enter the elements:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
    quick(0, n - 1);
    printf("Sorted a:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    return 0;
}
