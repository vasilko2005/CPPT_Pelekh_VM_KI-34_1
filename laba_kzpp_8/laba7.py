import os
import struct
import sys
import math

def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(f"{result:.5f}")

def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = float(f.read())  # Convert to float for consistency
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def writeResBin(fName, result):
    with open(fName, 'wb') as f:
        # Round to 5 decimal places before saving to ensure consistency
        rounded_result = round(result, 5)
        f.write(struct.pack('d', rounded_result))

def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                result = struct.unpack('d', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def calculate(x):
    try:
        numerator = 1 / math.tan(x)  # ctg(x) = 1 / tan(x)
        denominator = math.sin(2 * x) + 4 * math.cos(x)
        return numerator / denominator
    except ZeroDivisionError:
        print("Error: Division by zero in the function calculation.")
        return None

if __name__ == "__main__":
    data = float(input("Enter data (in radians): "))
    result = calculate(data)
    if result is not None:
        print(f"Result is: {result:.5f}")
        try:
            writeResTxt("textRes.txt", result)
            writeResBin("binRes.bin", result)
            print("Result from binary file: {0:.5f}".format(readResBin("binRes.bin")))
            print("Result from text file: {0:.5f}".format(readResTxt("textRes.txt")))
        except FileNotFoundError as e:
            print(e)
            sys.exit(1)
