#include "functions_and_procedures.h"
#include "string.h"
#include <ctype.h>

bool palindrome(const char *str) { // pointer to string value (edits global variable).

    char filter[strlen(str)]; // char array of length str input.
    int store = 0;

    for (int i = 0; i <= strlen(str); i++) {
        filter[i] = '\0'; // ensure all elements of filter array are set to the NULL terminator.
        (isalpha(str[i])) ? 1 : store++; // if character is alphabetical then true, otherwise increment store.
        // if character is alphabetical or space add to filter subtracting score from i to bring letters together.
        (isalpha(str[i]) || isspace(str[i]) == 1) ? filter[i-store] = str[i] : (filter[i] = '\0');
    }

    // for loop that increments through string starting from the start and end and checks if they match.
    for (int i = 0, j = (int)strlen(filter) - 1; i < j; i++, j--)
        if (tolower(filter[i]) != tolower(filter[j]))
            return false;
    return true;
}

// procedure with pointer(s) parameters to change global variable beyond procedure.
void swap(int *a, int *b) {
    int temp = *a;
    *a       = *b;
    *b       = temp;
}

// procedure that adds previous value of array to current.
void cumSum(int array[], int count) {
    for (int i = 0; i <= count; i++) {
        array[i] += array[i-1];
    }
}