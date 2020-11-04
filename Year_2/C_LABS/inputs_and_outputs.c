#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>
#include "functions_and_procedures.h"
#include "inputs_and_outputs.h"

void palExtract(FILE *input, char mode) {

    FILE *output = fopen("palindromes.txt", "w"); // pointer to file type with writing permission.
    char str[256]; // char array that can store maximum amount of characters permitted per line.

    if (input == NULL) { // if file cannot be found.
        // create custom error message.
        fprintf(stderr,"Error: unable to open %s with mode %c.\n", input, mode);
        exit(EXIT_FAILURE); // exit from program.
    }

    while ((fscanf(input, "%s", str)) != EOF) { // while line of file isn't end.
        if (palindrome(str) && isword(str)) // checks if str is a valid word and a palindrome.
            fprintf(output, "%s\n", str); // write into output txt and go to next line.
    }
    fclose(output); // close output file (think of this like free() but for files).
}

bool isword(const char *str) {
    int aCount = 0;
    for (int i = 0; str[i] != '\0'; i++) {
        if (isalpha(str[i]) != 0) // is character alphabetical?
            aCount++; // if not, increment 'aCount'.
    }
    return (aCount < 3) ? false : true; // if 'aCount' is larger than three then return true, otherwise false.
}