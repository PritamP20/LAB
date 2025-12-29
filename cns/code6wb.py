import sympy, random
p = 0
while not(sympy.isprime(p)):
 p = random.randint(100,200)
g = sympy.primitive_root(p)
a = random.randint(1,100)
b = random.randint(1,100)
A = pow(g,a,p)
B = pow(g,b,p)
print(f"(p={p}, g={g}, a={a}, b={b}, A={A}, B={B})")
print("Alice key:",pow(B,a,p))
print("Bob key:",pow(A,b,p))