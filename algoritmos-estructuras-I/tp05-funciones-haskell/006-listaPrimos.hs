{- Ayudin GPT (a la hora de armar la lista) -}

listaNPrimos :: Int -> [Int]
listaNPrimos x = [ i | i <- [2..x], all (\d -> mod i d /= 0) [2..i-1] ]