# 1. VERSIÓN MÍNIMA Y NOMBRE DEL PROYECTO
# ---------------------------------------------------------
# Define la versión mínima de CMake requerida y nombra tu proyecto
cmake_minimum_required(VERSION 3.14)
project(ProyectoTADs VERSION 1.0 LANGUAGES CXX)

# 2. CONFIGURACIÓN DEL LENGUAJE
# ---------------------------------------------------------
# Le indicamos al compilador que use el estándar C++17 (o C++20)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# 3. INCLUIR DIRECTORIOS
# ---------------------------------------------------------
# Le decimos al compilador dónde buscar los archivos de cabecera (.h)
# De esta forma puedes hacer #include "Stack.h" en cualquier lado
include_directories(${CMAKE_SOURCE_DIR}/src/tads)

# 4. CREAR EL EJECUTABLE PRINCIPAL (Tu programa)
# ---------------------------------------------------------
# Agrupa tus archivos fuente principales y crea el ejecutable
# Nota: Si tuvieras un archivo .cpp para las implementaciones de Stack, lo pondrías aquí.
# Como usamos templates, todo está en los .h, así que solo compilamos main.cpp
add_executable(MiPrograma src/main.cpp)

# 5. CONFIGURACIÓN PARA LOS TESTS (Google Test)
# ---------------------------------------------------------
# Si vas a usar GTest, CMake puede descargarlo automáticamente
# y configurarlo para compilar la carpeta de tests.
enable_testing()

# Importamos el módulo FetchContent para bajar dependencias
include(FetchContent)

# Descargamos Google Test desde su repositorio oficial
FetchContent_Declare(
  googletest
  GIT_REPOSITORY https://github.com/google/googletest.git
  GIT_TAG        release-1.12.1
)
FetchContent_MakeAvailable(googletest)

# Agrupamos los archivos fuente de los tests y creamos su ejecutable
add_executable(TestsPila tests/tads/StackTest.cpp)

# Vinculamos el ejecutable de los tests con la librería de Google Test
target_link_libraries(TestsPila gtest_main)

# Le decimos a CMake que registre este ejecutable como un test
include(GoogleTest)
gtest_discover_tests(TestsPila)