alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def to_num(c):
    return alphabet.index(c.upper())
def to_char(n, is_lower):
    c = alphabet[n % 26]
    return c.lower() if is_lower else c

K = ((3, 3), (2, 5))
Ki = ((15, 17), (20, 9))
text = input("Enter text: ")
cipher = list(text)
plain = list(text)
letters = []
meta = []

for i, c in enumerate(text):
    if c.isalpha():
        letters.append(c)
        meta.append((i, c.islower(), False))
    elif c.isdigit():
        letters.append(alphabet[int(c)])
    meta.append((i, False, True))

if len(letters) % 2:
    letters.append('X')
    meta.append((None, False, False))

enc = []
for i in range(0, len(letters), 2):
    x, y = map(to_num, letters[i:i+2])
    enc.append(alphabet[(K[0][0]*x + K[0][1]*y) % 26])
    enc.append(alphabet[(K[1][0]*x + K[1][1]*y) % 26])
for (pos, _, _), c in zip(meta, enc):
    if pos is not None:
        cipher[pos] = c

print("Ciphertext:", "".join(cipher))
dec = []
for i in range(0, len(enc), 2):
    x, y = map(to_num, enc[i:i+2])
    dec.append((Ki[0][0]*x + Ki[0][1]*y) % 26)
    dec.append((Ki[1][0]*x + Ki[1][1]*y) % 26)
for (pos, is_lower, is_digit), n in zip(meta, dec):
    if pos is None:
        continue
    ch = to_char(n, is_lower)
    plain[pos] = str(to_num(ch)) if is_digit else ch
print("Decrypted:", "".join(plain).rstrip("X"))