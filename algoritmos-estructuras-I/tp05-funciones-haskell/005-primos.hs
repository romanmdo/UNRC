{- Ayudin GPT (a la hora de armar la lista) -}

esPrimo :: Int -> Bool
esPrimo 0 = False
esPrimo 1 = False
esPrimo x = 
    if mod x 1 == 0 && mod x x == 0 && all (\i -> mod x i /= 0) [2..x-1]
        then False
        else True