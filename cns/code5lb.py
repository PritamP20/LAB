import random, math, sympy
def e_value(phin_val):
    while True:
        e_val = random.randint(2,phin_val-1)
        if math.gcd(e_val,phin_val)==1:
            return e_val
def encryption(plain_text,e_val,n_val):
    cipher_text = []
    for ch in plain_text:
        cipher_text.append(pow(ord(ch),e_val,n_val))
    return cipher_text
def decryption(enc_text,d_val,n_val):
    dec_text = ""
    for i in enc_text:
        dec_text += chr(pow(i,d_val,n_val))
    return dec_text
p,q = 0,0
while not(sympy.isprime(p) and sympy.isprime(q)) or p == q:
    p = random.randint(1,100)
    q = random.randint(1,100)
n = p*q
phin = (p-1)*(q-1)
e = e_value(phin)
d = pow(e, -1, phin)
text = input("enter text: ")
ciphertext = encryption(text,e,n)
print("cipher text:",ciphertext)
dectext = decryption(ciphertext,d,n)
print("decrypted text",dectext)