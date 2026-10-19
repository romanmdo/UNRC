cuadrado :: Int -> Int
cuadrado x = x * x

hd :: [a] -> a
hd (x:xs) = x

{-
    a) Evaluación Aplicativa:
        2 * cuadrado (hd [2,4,5,6,7,8])
        = 2 * cuadrado 2
        = 2 * 4
        = 8

    b) Evaluación Normal:
        2 * cuadrado (hd [2,4,5,6,7,8])
        = 2 * ((hd [2,4,5,6,7,8]) * (hd [2,4,5,6,7,8]))
        = 2 * (2 * 2)
        = 2 * 4
        = 8
-}