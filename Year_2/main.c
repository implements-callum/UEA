#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cmake-build-debug//functions_and_procedures.h"
#include "cmake-build-debug//inputs_and_outputs.h"
#include "cmake-build-debug//c_for_systems.h"
#include "cmake-build-debug//structs_adt.h"

/// By:            Callum Clegg
/// Desc:          lab-sheet tasks from C lectures...
/// Last update:   22/10/20

// unsigned char bitReverse(unsigned char byte);

int main() {
    //************************ C for Systems Programming *************************
    printf("Bit set is %s.\n",(parity('h') % 2 == 0) ? "even" : "odd");

    //************************ Structs & Data Abstraction ************************
    Date *current = malloc(sizeof(Date));
    Date *past = malloc(sizeof(Date));

    current -> day = 22;
    current -> month = 10;
    current -> year = 2020;

    past -> day = 21;
    past -> month = 10;
    past -> year = 2020;

    Date m = dur(*current, *past);

    printf("%d/%d/%d\n", abs(m.day), abs(m.month), abs(m.year));
    printf("%d/%d/%d\n", current -> day, current -> month, current -> year);

    //************************* Pre-processor Directives *************************
    int ans = LARGEST(13, 11, 10);
    printf("%d is the largest number.\n", ans);

    FILE *bits = fopen("../lut.txt", "w");

    if (bits == NULL) {
        fprintf(stderr, "Error: unable to find file");
        return EXIT_FAILURE;
    }

    for (unsigned i = 0; i < 256; i++) {
        unsigned rev = 0;

        for (unsigned j = 0; j < 8; j++)
            if (i & (1u << j))
                rev |= (0x80u) >> j;

        fprintf(bits, (i%8 == 7) ? "%#04X,\n" : "%#04X, ", rev);
    }
    fclose(bits);

    //************************************ I/O ***********************************
    FILE *text = fopen("ulysses.txt", "r");
    palExtract(text, 'r');
    fclose(text);

    char *filename = "inventory.txt";
    FILE *inventory = fopen(filename, "r");

    if (inventory == NULL) {
        fprintf(stderr, "Error: unable to open '%s'.\n", filename);
        return EXIT_FAILURE;
    }

    char type[256];
    char code[256];
    int stock;
    int price;
    char value[256];

    int capacitorTypes = 0;
    int opAmps = 0;
    int cost = INT_MAX;
    char transistor[32];

    while (fscanf(inventory, "%[^,], %[^,], %d, %d%[^\n] ",
                  type, code, &stock, &price, value) != EOF) {

        (strcmp(type, "capacitor") == 0) ? capacitorTypes++ : 0;

        (strstr(value, "op-amp") != 0) ? opAmps += stock : 0;

        if (strcmp(type, "transistor") == 0) {
            if (price < cost) {
                cost = price;
                strncpy(transistor, code, 31);
            }
        }
    }
    printf("We have %d capacitor types.\n", capacitorTypes);
    printf("We have a total of %d IC(s) in stock.\n", opAmps);
    printf("Our cheapest transistor is %s\n", transistor);
    fclose(inventory);

    //************************* procedures and functions *************************
    char input[] = "Yo, banana boy!";
    printf("%s %s a palindrome string!\n", input, (palindrome(input)) ? "is" : "is NOT");

    int a = 5, b = 7;
    swap(&a, &b);
    printf("a = %d, b = %d\n", a, b);

    int numbers[] = {2, 1, 12, 7, 5, 2};
    cumSum(numbers, 5);
    for (int i = 0; i < 5; i++)
        printf("%d,", numbers[i]);

    return EXIT_SUCCESS;
}

/*
unsigned char bitReverse(unsigned char n) {
    static const unsigned char lut[] = {
#include "lut.txt"
    };
    return lut[n];
}
 */


