# 1. VERSIÓN MÍNIMA Y NOMBRE DEL PROYECTO
cmake_minimum_required(VERSION 3.14)
project(ProyectoTADs VERSION 1.0 LANGUAGES CXX)

# 2. CONFIGURACIÓN DEL LENGUAJE
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# 3. INCLUIR DIRECTORIOS
include_directories(${CMAKE_SOURCE_DIR}/src/tads)

# 4. CREAR EL EJECUTABLE PRINCIPAL
add_executable(MiPrograma src/main.cpp)

# 5. CONFIGURACIÓN PARA LOS TESTS (Google Test)
enable_testing()
include(FetchContent)
FetchContent_Declare(
  googletest
  GIT_REPOSITORY https://github.com/google/googletest.git
  GIT_TAG        release-1.12.1
)
FetchContent_MakeAvailable(googletest)

# --- EJECUTABLES DE TESTS SEPARADOS ---

# Ejecutable 1: Test para ArrayStack
add_executable(ArrayStackTest tests/tads/ArrayStackTest.cpp)
target_link_libraries(ArrayStackTest gtest_main)

# Ejecutable 2: Test para LinkedStack
add_executable(LinkedStackTest tests/tads/LinkedStackTest.cpp)
target_link_libraries(LinkedStackTest gtest_main)

# Registramos ambos ejecutables en CTest
include(GoogleTest)
gtest_discover_tests(ArrayStackTest)
gtest_discover_tests(LinkedStackTest)