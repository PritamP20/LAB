alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
key = []
message = input("enter the message: ").lower()
key_word = input("enter the keyword: ").lower()
for i in key_word:
    if i not in key:
        key.append(i)
for i in alphabet:
    if i not in key:
        key.append(i)
ciphertext = ""
for i in message:
    if i.isalpha():
        ciphertext += key[alphabet.index(i)]
    else:
        ciphertext += i
print("cipher text:",ciphertext)
plaintext = ""
for i in ciphertext:
    if i.isalpha():
        plaintext += alphabet[key.index(i)]
    else:
        plaintext += i
print("plain text:",plaintext)