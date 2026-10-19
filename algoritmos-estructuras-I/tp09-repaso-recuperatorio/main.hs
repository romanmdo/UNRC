filter' :: [(Float, Int)] -> [(Float, Int)]
filter' [(0.00, 0)] = [(0.00, 0)]
filter' xs = filter (\(primer_elem, seg_elem) -> seg_elem > 0) xs 

map' :: [(Float, Int)] -> [(Float, Int)]
map' [(0.00, 0)] = [(0.00, 0)]
map' xs = map (\(primer_elem, seg_elem) -> (primer_elem * 0.9, seg_elem) ) xs 

foldll' :: [(Float, Int)] -> Float
foldll' [(0.00, 0)] = 0.00
foldll' xs = foldl (\acc (primer_elem, seg_elem) -> acc + (primer_elem * fromIntegral(seg_elem))) 0 xs

inventario :: [(Float, Int)] -> Float
inventario [(0.00, 0)] = 0.00
inventario xs = foldll' (map' (filter' (xs))) 