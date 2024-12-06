# Функція для створення зубчатого списку для квадратної матриці
def generate_matrix(rows_num, filler):
    
    # Створюємо порожній список для зберігання рядків матриці
    matrix = []
    
    # Генеруємо матрицю
    for i in range(rows_num):
        row = [' '] * rows_num  # Створюємо рядок, заповнений нулями
        # Встановлюємо заповнювач у центральній частині, залежно від поточного рядка
        row[abs(rows_num // 2 - i) : rows_num - abs(rows_num // 2 - i)] = [filler] * (rows_num - 2 * abs(rows_num // 2 - i))
        matrix.append(row)
    
    return matrix

def print_matrix(matrix):
    """Виводить матрицю у форматі рядків"""
    for row in matrix:
        print("".join(row))


def main():
    """Головна функція, що управляє логікою програми"""
    
    try:
        # Введення розміру квадратної матриці
        rows_num = int(input("Введіть розмір квадратної матриці (непарне число): "))
        
        # Перевірка, чи розмір непарний
        if rows_num % 2 == 0:
            print("Кількість рядків повинна бути непарною.")
            return
        
        # Введення символа-заповнювача
        filler = input("Введіть символ-заповнювач: ")
        
        # Перевірка на коректність введення заповнювача
        if len(filler) != 1:
            print("Некоректний символ-заповнювач! Потрібен один символ.")
            return
        
        # Генерація та виведення матриці
        matrix = generate_matrix(rows_num, filler)
        print_matrix(matrix)
    
    except ValueError:
        print("Введіть коректне ціле число для розміру матриці.")

# Виконання головної функції
if __name__ == "__main__":
    main()
