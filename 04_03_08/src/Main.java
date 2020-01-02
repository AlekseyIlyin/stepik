import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

        Требуется выставить такие настройки, чтобы:

        Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
        Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
        Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
        Не упомянутые здесь настройки изменяться не должны.

        (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

        Подсказки:

        Level есть не только у Logger, но и у Handler.
        Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
*/

public class Main {

    public static void main(String[] args) {

    }

    private static void configureLogging() {
        Logger logger_A = Logger.getLogger("org.stepic.java.logging.ClassA");
        logger_A.setLevel(Level.ALL);

        Logger logger_B = Logger.getLogger("org.stepic.java.logging.ClassB");
        logger_B.setLevel(Level.WARNING);

        Logger logger_C = Logger.getLogger("org.stepic.java");
        java.util.logging.ConsoleHandler handlerC = new ConsoleHandler();
        handlerC.setLevel(Level.ALL);
        handlerC.setFormatter(new XMLFormatter());
        logger_C.addHandler(handlerC);
        logger_C.setUseParentHandlers(false);
    }
}
