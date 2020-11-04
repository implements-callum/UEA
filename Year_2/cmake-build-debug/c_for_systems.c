#include "c_for_systems.h"

unsigned parity(unsigned char x) {
    unsigned binary[8], count = 0;

    for (unsigned n = 0; n < 8; n++) {
        binary[7-n] = (x >> n) & 1u; // moves binary representation of char into char array.
        (binary[n] == 1) ? count++ : 0; // increments count if bit == 1.
    }

    return count;
}