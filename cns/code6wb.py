def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True
while True:
    p = int(input("enter prime p: "))
    if is_prime(p):
        break
    print("not prime, enter again")
g = int(input("enter g(preferably primitive root of p): "))
a = int(input("enter Alice secret number a: "))
b = int(input("enter Bob secret number b: "))
A = pow(g, a, p)
B = pow(g, b, p)
print(f"(p={p}, g={g}, a={a}, b={b}, A={A}, B={B})")
print("Alice secret key:", pow(B, a, p))
print("Bob secret key:", pow(A, b, p))


# enter prime p: 23
# enter g (preferably primitive root of p): 5
# enter Alice secret number a: 6
# enter Bob secret number b: 15
