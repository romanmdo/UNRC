listaReversa :: [a] -> [a]
listaReversa [] = [] 
listaReversa (x:xs) = listaReversa xs ++ [x]