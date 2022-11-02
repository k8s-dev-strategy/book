from time import sleep

def main():
    for i in range(0, 60):
        print(i, flush=True)
        sleep(1)

main()