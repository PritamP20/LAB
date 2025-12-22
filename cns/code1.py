# CaesarCipher
uppercase_letters = [
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
]

def caesar_cipher(msg, k):
    cipher_text = ""
    for ch in msg:
        if ch.isalpha():
            cipher_text += uppercase_letters[(uppercase_letters.index(ch) + k) % 26]
        else:
            cipher_text += ch
    print("Cipher text:", cipher_text)

    plain_text = ""
    for ch in cipher_text:
        if ch.isalpha():
            plain_text += uppercase_letters[(uppercase_letters.index(ch) - k) % 26]
        else:
            plain_text += ch
    print("Plain text:", plain_text)


message = input("Enter the message: ").upper()
key = int(input("Enter the key: "))
caesar_cipher(message, key)

# Build the key list (unique letters from keyword + remaining alphabet)
for i in key_word:
    if i not in key:
        key.append(i)

for i in alphabet:
    if i not in key:
        key.append(i)

# Encryption
ciphertext = ""
for i in message:
    if i.isalpha():
        ciphertext += key[alphabet.index(i)]
    else:
        ciphertext += i

print("Cipher text:", ciphertext)

# Decryption
plaintext = ""
for i in ciphertext:
    if i.isalpha():
        plaintext += alphabet[key.index(i)]
    else:
        plaintext += i

print("Plain text:", plaintext)