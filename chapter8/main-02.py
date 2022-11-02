from time import sleep

def main():
    for i in range(0, 10):
        print(i, flush=True)
        sleep(1)
    exit(1)

main()