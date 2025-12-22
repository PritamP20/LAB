#include <stdio.h>

#define BS 10   // Bucket size
#define OR 4    // Output rate

int main()
{
    int n, i, b = 0, p[20];

    printf("Enter number of packets: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        printf("Enter size of packet %d: ", i + 1);
        scanf("%d", &p[i]);
    }

    for (i = 0; i < n; i++) {
        printf("\nPacket %d of size %d arrived\n", i + 1, p[i]);

        if (p[i] <= BS - b) {
            b += p[i];
            printf("Bucket content: %d/%d\n", b, BS);
        } else
            printf("Bucket overflow! Packet discarded\n");

        b = (b > OR) ? b - OR : 0;
        printf("After sending, bucket: %d/%d\n", b, BS);
    }

    while (b > 0) {
        printf("\nSending remaining packets...\n");
        b = (b > OR) ? b - OR : 0;
        printf("Bucket content: %d/%d\n", b, BS);
    }

    return 0;
}