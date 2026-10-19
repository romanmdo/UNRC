tam :: [a] -> Int
tam xs = foldr contar 0 xs
  where
    -- 'contar' es la función que foldr recibe.
    -- Toma un elemento (el cual ignoramos con '_')
    -- y el acumulador (el conteo actual) y devuelve el acumulador + 1.
    contar :: a -> Int -> Int
    contar _ acc = 1 + acc