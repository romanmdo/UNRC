-- Función que ignora su segundo argumento (como 'const')
primero :: a -> b -> a
primero x y = x

-- Función que duplica su argumento
duplicar :: Int -> Int
duplicar x = x + x

-- Función que suma 1
sumaUno :: Int -> Int
sumaUno n = n + 1

-- Una lista infinita de 7s
listaInf :: [Int]
listaInf = 7 : listaInf

-- La función 'head'
hd :: [a] -> a
hd (x:xs) = x

-- Inf
inf :: Int
inf = inf + 1

{-

    Evaluaciones Aplicativas:
    1) primero (5 + 5) (sumaUno inf)
        = Error: inf es infinito

    2) duplicar (sumaUno 10)
        = duplicar 11
        = 22
    
    3) primero (hd lista_inf) (1/0)
        = Error: no se puede evaluar (1/0)

    Evaluaciones Normales:
    1) primero (5 + 5) (sumaUno inf)
        = primero 10 (sumaUno inf)
        = 10

    2) duplicar (sumaUno 10)
        = (sumaUno 10) + (sumaUno 10)
        = 11 + (sumaUno 10)
        = 11 + 11 
        = 22
    
    3) primero (hd lista_inf) (1/0)
        = 7

-}