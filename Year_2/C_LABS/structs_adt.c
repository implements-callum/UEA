#include "structs_adt.h"
#include <stdlib.h>
#include <stdio.h>

Date dur(Date x, Date y) {
    Date *result = malloc(sizeof(Date));

    result -> day = x.day - y.day;
    result -> month = x.month - y.month;
    result -> year = x.year - y.year;

    int days = abs(result->day) + abs(30 * result->month) + abs(365 * result->year);
    printf("%d day(s) between (estimate)\n", days);

    return *result;
}