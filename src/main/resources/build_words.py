#
# Build words in dictionary (like Linux /usr/share/dict/words) for use with Wordle
#
import re

# Read all lines into a list
path = '/usr/share/dict/words'
print("Getting words from", path)
words = []
with open(path, 'r', encoding='utf-8') as f_dictionary:
    for line in f_dictionary.readlines():
        words.append(line)

# Only five English letters and a LF (how to remove plurals?)
valid = re.compile(r"^[a-z]{5}\n$")
new_words = []
for word in words:
    if valid.match(word):
        new_words.append(word.upper())

print("Original size:", len(words))
print("New size:", len(new_words))
print("Writing new file...")

# Write back to words file
path = 'words.txt'
with open(path, 'w', encoding='utf-8') as f_dictionary:
    f_dictionary.writelines(new_words)

print("fin")
