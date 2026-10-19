-- Bucle infinito
inf :: Int
inf = inf + 1

-- Funcion ’f’ que es estricta en su PRIMER argumento
-- ( debido al pattern matching ) pero perezosa en el segundo .
f :: Bool -> Int -> Int
f True y = y
f False y = 10

{-
    EVALUACIÓN NORMAL:
    - Expresión: f (inf == inf) (5 * 4)
    = f (inf == inf) (5 * 4) 
    = Error: el inf == inf nunca se va a termina de evaluar

-}