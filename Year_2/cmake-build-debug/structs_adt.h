#ifndef LABS_STRUCTS_ADT_H
#define LABS_STRUCTS_ADT_H
// Macro that calculates the largest value from three inputs.
#define LARGEST(X, Y, Z) ({ (X > Y)? ((X > Z) ? X : ((Z > Y) ? Z : Y)) : ((Y > Z) ? Y : Z); })

// Struct containing 3 int variables that can be later defined.
typedef struct dateStruct {
    int day, month, year;
}
Date;
Date dur(Date x, Date y);
#endif //LABS_STRUCTS_ADT_H
