package org.stepik.task.task52.task5209;
import java.io.InputStream;
import java.io.OutputStream;

/**
 По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле. На Unix-системах конец строки обозначается символом с кодом 10 ('\n'), на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').
 Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix. Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out. На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.
 требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'. Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.
 Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13. Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.
 Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush(). Иначе часть выведенных вами данных не будет видна проверяющей системе.

 Пример
 Из System.in зачитаны следующие байты: 65 13 10 10 13. Внимание! Это не строка "65 13 10 10 13", а последовательность чисел, возвращаемая методом System.in.read().
 В System.out должны быть выведены байты: 65 10 10 13
 */
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        final int nsUnix = 10;
        int readByte = inputStream.read();
        int firstByte = 0;
        boolean firstByteLoad = false;
        while (readByte != -1) {
            if (firstByteLoad) {
                if (readByte == 10) {
                    outputStream.write(nsUnix);
                } else {
                    outputStream.write(firstByte);
                    outputStream.write(readByte);
                }
                firstByteLoad = false;
            } else {
                if (readByte == 13) {
                    firstByte = readByte;
                    firstByteLoad = true;
                } else {
                    outputStream.write(readByte);
                }
            }
            readByte = inputStream.read();
        }
        if (firstByteLoad) {
            outputStream.write(firstByte);
        }
        outputStream.flush();
    }
}