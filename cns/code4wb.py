def encrypt(msg, key):
    cipher = []
    for i, char in enumerate(msg):
        m = ord(char)
        k = ord(key[i % len(key)])
        c = (m ^ k) + 32
        cipher.append(str(c))
    return " ".join(cipher)
def decrypt(cipher_text, key):
    parts = cipher_text.split()
    text = ""
    for i, part in enumerate(parts):
        c = int(part) - 32
        k = ord(key[i % len(key)])
        text += chr(c ^ k)
    return text
msg = input("Enter message: ")
key = input("Enter key: ")
encrypted = encrypt(msg, key)
print("Encrypted text:", encrypted)
decrypted = decrypt(encrypted, key)
print("Decrypted text:", decrypted)