-- Función constante que ignora el segundo argumento
constante :: a -> b -> a
constante x y = x

-- Valor entero indefinido ( loop infinito )
bucle :: Int
bucle = bucle + 1

-- Función simple
doble :: Int -> Int
doble x = x + x

{-
    EVALUACIONES APLICATIVAS:
    a) constante (10 + 5) (1 ‘div‘ 0)
        = Error: no se puede evaluar 1/0
    b) constante 5 (doble bucle)
        = Error: función bucle infinita

    EVALUACIONES NORMALES:
    a) constante (10 + 5) (1 ‘div‘ 0)
        = (10 + 5)
        = 15
    b) constante 5 (doble bucle)
        = 5
-}