f :: Int -> Int -> Int
f x 0 = x
f x (n + 1) = cuadrado ( f x n )