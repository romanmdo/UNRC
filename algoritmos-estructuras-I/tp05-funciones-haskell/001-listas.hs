hd :: [a] -> a
hd (x:xs) = x

tl :: [a] -> [a]
tl (x:xs) = xs

myLast :: [a] -> a
myLast [a] = a
myLast (x:xs) = last xs

myInit :: [a] -> [a]
myInit [a] = [a]    
myInit (x:xs) = myInit xs