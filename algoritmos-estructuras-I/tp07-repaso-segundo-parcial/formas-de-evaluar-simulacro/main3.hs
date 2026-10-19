-- Definición de bucle infinito
inf :: Int
inf = inf + 1

-- Definición de error
errorDiv :: Int
errorDiv = 1 `div` 0

-- Suma 10 a un número
sumaDiez :: Int -> Int
sumaDiez x = x + 10

-- Función condicional (como mi_if)
seleccionar :: Bool -> a -> a -> a
seleccionar True x y = x
seleccionar False x y = y

-- Función que ignora su primer argumento y cuadra el segundo
evaluarLuego :: a -> Int -> Int
evaluarLuego z n = n * n

{-

    Evaluación Aplicativa:
    1) seleccionar (1 > 5) (sumaDiez 20) errorDiv
        = Error: no se puede evaluar errorDiv

    2) evaluarLuego inf (sumaDiez 3)
        = evaluarLuego inf 13
        = No termina

    3) sumaDiez (sumaDiez (1 + 1))
        = sumaDiez (12)
        = 22

    Evaluación Normal:
    1) seleccionar (1 > 5) (sumaDiez 20) errorDiv
        = seleccionar False (sumaDiez 20) errorDiv
        = seleccionar False 30 errorDiv
        = errorDiv

    2) evaluarLuego inf (sumaDiez 3)
        = evaluarLuego inf 13
        = 169
    
    3) sumaDiez (sumaDiez (1 + 1))
        = 10 + (sumaDiez (1 + 1))
        = 10 + (10 + (1 +1))
        = 10 + 10 + 2
        = 22

-}