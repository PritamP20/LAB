import hashlib
text = input("enter text:\n")
text_bytes = text.encode()
sha1_hash = hashlib.sha1(text_bytes)
digest = sha1_hash.hexdigest()
print("SHA 1 message digest:",digest)