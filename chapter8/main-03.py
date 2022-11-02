from time import sleep
from random import random 

def main():
    for i in range(0, 10):
        print(i, flush=True)
        sleep(1)
    if random() > 0.7:
        exit(1)

main()