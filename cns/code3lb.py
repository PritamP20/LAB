import random, math, numpy, sympy
alphabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
text = input("enter text: ").upper()
n = 1
while n*n < len(text):
    n += 1
while n*n > len(text):
    text += "X"
P = [[alphabet.index(text[i*n + j]) for j in range(n)] for i in range(n)]
while True:
    K = [[random.randint(1,10) for _ in range(n)] for _ in range(n)]
    det = int(round(numpy.linalg.det(K))) % 26
    if math.gcd(det,26)==1:
        break

X = sympy.Matrix(K)
Ki = numpy.array(X.inv_mod(26)).astype(int)
C = numpy.dot(K,P) % 26
PT = numpy.dot(Ki,C) % 26

cipher = ""
plaintext = ""
for i,j in zip(C,PT):
    for _ in range(n):
        cipher += alphabet[int(i[_])%26]
        plaintext += alphabet[int(j[_])%26]
plaintext = plaintext.strip("X")
print("cipher text:", cipher)
print("decrypted text:", plaintext)