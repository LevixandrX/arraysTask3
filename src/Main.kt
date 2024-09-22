fun main() {
    println("Эта программа шифрует и дешифрует текст с помощью ключевого слова.")
    println("Вы можете выбрать режим: 1 для шифрования или 2 для дешифровки.")

    val alphabet = ('А'..'Я').toList() + 'Ё'

    var mode: String
    while (true) {
        println("Выберите режим (1 - шифровать, 2 - дешифровать):")
        mode = readln()

        if (mode == "1" || mode == "2") {
            break
        } else {
            println("Ошибка: неверный режим. Введите 1 для шифрования или 2 для дешифрования.")
        }
    }

    var key: String
    while (true) {
        println("Введите ключевое слово:")
        key = readln().uppercase()

        if (key.all { it in alphabet }) {
            break
        } else {
            println("Ошибка: ключевое слово может содержать только буквы русского алфавита.")
        }
    }

    var text: String
    while (true) {
        println("Введите текст:")
        text = readln().uppercase()

        if (text.all { it in alphabet || it.isWhitespace() }) {
            break
        } else {
            println("Ошибка: текст может содержать только буквы русского алфавита.")
        }
    }

    val result = StringBuilder()

    for (i in text.indices) {
        val currentChar = text[i]
        if (currentChar in alphabet) {
            val shift = alphabet.indexOf(key[i % key.length]) + 1
            val charIndex = alphabet.indexOf(currentChar)
            val newIndex = if (mode == "1") {
                (charIndex + shift) % alphabet.size // Шифруем: сдвигаем вперед
            } else {
                (charIndex - shift + alphabet.size) % alphabet.size // Дешифруем: сдвигаем назад
            }
            result.append(alphabet[newIndex])
        } else {
            result.append(currentChar)
        }
    }

    println("Результат: $result")
}