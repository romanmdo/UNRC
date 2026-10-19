-- Este lo hizo la IA

nEsimo :: Int -> [a] -> a
nEsimo 0 (x:_)  = x
nEsimo n (_:xs) = nEsimo (n-1) xs
nEsimo _ []     = error "Índice fuera de rango"