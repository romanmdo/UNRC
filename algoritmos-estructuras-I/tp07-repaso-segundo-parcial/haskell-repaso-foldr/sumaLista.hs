sumaLista :: [Int] -> Int
sumaLista [] = 0
sumaLista xs = foldr (+) 0 xs

{-
    Explicación foldr: foldr f z [x1, x2, x3] se expande a f x1 (f x2 (f x3 z)).

    sumaLista x = foldr (+) 0 xs se expande asi:
    = 1 + (2 + (3 + (4 + (5 + 0))))

    Ejemplo: sumaLista [1, 2, 3]
    = 1 + (2 + (+ 3 0))

-}