-- Función que evalúa su primer argumento para decidir
g :: Int -> Int -> Int
g 0 y = 5
g x y = x

-- Loop infinito
loop :: Int
loop = loop + 1

-- Lista infinita
nums :: [Int]
nums = 1 : nums


{-
    EVALUACIONES NORMALES:
    a) g 0 loop
        = 5
    
    b) g 10 loop
        = 10

    c) g loop 10
        = Error: bucle infinito

    d)  head (0 : nums)
        = [0] [1, 1, ...]
        = 0
-}