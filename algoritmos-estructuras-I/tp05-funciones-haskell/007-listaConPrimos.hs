{- Usando funcion del ejercicio 5 -}
{- Este es el ejercicio que más lindo me ha quedado en haskell -}

esPrimo :: Int -> Bool
esPrimo 0 = False
esPrimo 1 = False
esPrimo x = 
    if mod x 1 == 0 && mod x x == 0 && all (\i -> mod x i /= 0) [2..x-1]
        then False
        else True

listaConPrimos :: [Int] -> [Int]
listaConPrimos [] = []
listaConPrimos (x:xs) = 
    if esPrimo x == False
        then [x] ++ listaConPrimos xs 
        else listaConPrimos xs 
    