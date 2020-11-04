cmake_minimum_required(VERSION 3.17)
project(LABS C)

set(CMAKE_C_STANDARD 99)

add_executable(LABS main.c cmake-build-debug/functions_and_procedures.c cmake-build-debug/functions_and_procedures.h cmake-build-debug/inputs_and_outputs.c cmake-build-debug/inputs_and_outputs.h cmake-build-debug/c_for_systems.c cmake-build-debug/c_for_systems.h cmake-build-debug/structs_adt.c cmake-build-debug/structs_adt.h)