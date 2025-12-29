from Crypto.Cipher import DES
from Crypto.Util.Padding import pad, unpad
key = b'12345678'
msg = input("enter text: ").encode()
cipher = DES.new(key, DES.MODE_ECB).encrypt(pad(msg, 8))
print("cipher:", cipher.hex())
plain = DES.new(key, DES.MODE_ECB).decrypt(cipher)
print("decrypted:", unpad(plain, 8).decode())