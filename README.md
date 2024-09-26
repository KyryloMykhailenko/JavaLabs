Михайленко Кирило ТЗ-21 Тут будуть представлені лабораторні з Java
Лаба 1
Контрольні питання:
1. Чим компіляція відрізняється від інтерпретації? Які переваги кожної з них?
Компіляція – це процес перетворення початкового коду (source code) в машинний код, який може виконуватися комп'ютером напряму. Переваги компіляції: висока продуктивність, оскільки програма повністю перетворюється у виконуваний файл перед запуском.
Інтерпретація – це процес, коли код виконується рядок за рядком під час роботи програми. Переваги інтерпретації: швидке тестування і налагодження, оскільки немає потреби чекати на компіляцію всього коду. Програма може запускатися на різних платформах за умови наявності інтерпретатора.

2. Що таке початковий код, байткод, машинний код? Яка між ними різниця? Що таке JIT-компіляція?

Початковий код (source code) – це код, написаний програмістом на мові програмування (наприклад, Java).
Байткод (bytecode) – це проміжний код, який генерується після компіляції початкового коду. Байткод виконується віртуальною машиною (JVM у випадку Java).
Машинний код (machine code) – це низькорівневий код, який напряму виконується процесором комп'ютера.
Різниця:
Початковий код написаний людиною і зрозумілий для програмістів, тоді як байткод є проміжною формою, зрозумілою для віртуальної машини. Машинний код напряму виконується процесором і залежить від архітектури комп'ютера.

JIT-компіляція (Just-In-Time) – це технологія в JVM, яка під час виконання програми компілює байткод у машинний код для підвищення швидкості виконання.

3. Що таке віртуальна машина?
Віртуальна машина (VM) – це програма, яка створює середовище для виконання програмного коду незалежно від апаратної платформи. У випадку Java це Java Virtual Machine (JVM), яка виконує байткод.

4. Що таке кросплатформність? Чи є кросплатформними застосунки на мові Java? Чи є кросплатформною віртуальна машина Java?
Кросплатформність – це здатність програми працювати на різних операційних системах без зміни коду. Застосунки на Java є кросплатформними, оскільки байткод, який виконує JVM, однаковий для всіх платформ. JVM теж є кросплатформною, оскільки її можна встановити на будь-яку операційну систему.

5. Дати пояснення кожному зі слів у початковому коді HelloWorld:

class – ключове слово, що оголошує клас, з якого починається будь-яка Java-програма.
public – модифікатор доступу, що робить клас або метод доступним для інших класів.
static – означає, що метод належить класу, а не його об'єктам, тобто його можна викликати без створення об'єкта класу.
void – ключове слово, яке вказує, що метод не повертає жодного значення.
String – клас в Java, який представляє рядки символів.
System – клас, який містить корисні поля та методи для роботи з системними ресурсами.
out – це статичне поле класу System, яке представляє стандартний потік виведення (зазвичай консоль).
println – метод класу PrintStream, що виводить текст на екран і переводить курсор на новий рядок.
6. Що буде, якщо в одному з цих слів змінити регістр літер, наприклад, замість «class» написати «CLASS»?
Java є регістрозалежною мовою програмування. Якщо змінити регістр літер у ключових словах (наприклад, class на CLASS), програма не скомпілюється, і буде виведено помилку компіляції.

7. Чи можна в одній системі встановити одночасно кілька різних версій Java? Якщо «ні» - пояснити чому. Якщо «так» - пояснити як, і взагалі для чого комусь таке робити?
Так, можна встановити кілька версій Java на одній системі. Це корисно для розробників, які працюють з проєктами, що вимагають різних версій Java. Для керування версіями можна використовувати такі інструменти, як jEnv, або вказувати різні версії Java у налаштуваннях IDE або системних змінних (JAVA_HOME).

Навіщо це робити?
Різні проєкти можуть вимагати різних версій Java. Наприклад, старіші програми можуть бути несумісні з новими версіями Java, тому розробнику може знадобитися тестувати або запускати код на конкретній версії Java.
Лаба 2
Контрольні питання:
1. В чому полягає різниця між ключовими та зарезервованими словами?
Ключові слова – це спеціальні слова, які мають особливе значення у мові програмування і використовуються для виконання конкретних операцій (наприклад, int, if, class).
Зарезервовані слова – це слова, які зарезервовані мовою програмування і не можуть бути використані як імена змінних або методів, але вони не обов'язково мають використовуватися на практиці. Наприклад, у Java зарезервоване слово goto, але воно не використовується.

2. Які примітивні типи даних Ви знаєте? Для кожного з них наведіть приклади, коли найбільш ефективно використовувати саме цей тип:

byte (1 байт) – зберігає цілі числа від -128 до 127. Ефективно використовувати для невеликих числових значень, наприклад, для кількості символів у повідомленні.
short (2 байти) – зберігає цілі числа від -32,768 до 32,767. Ефективно використовувати для більшого діапазону чисел, наприклад, для кількості людей на події.
int (4 байти) – зберігає цілі числа від -2,147,483,648 до 2,147,483,647. Підходить для більшості цілих чисел, таких як рахунок у футбольному матчі.
long (8 байтів) – зберігає цілі числа від -9,223,372,036,854,775,808 до 9,223,372,036,854,775,807. Використовується для надзвичайно великих чисел, наприклад, кількості зірок на небі або маси всесвіту.
float (4 байти) – зберігає числа з рухомою комою з меншою точністю. Використовується для зберігання наближених значень, таких як відсоткові показники.
double (8 байтів) – зберігає числа з рухомою комою з високою точністю. Використовується для точних обчислень, наприклад, у фінансових розрахунках.
char (2 байти) – зберігає одиночний символ. Використовується для представлення символів, наприклад, літер алфавіту.
boolean (1 біт) – зберігає значення true або false. Використовується для логічних операцій.
3. Що таке знакові та беззнакові типи? До якої групи відноситься кожен з примітивних типів даних?
Знакові типи можуть зберігати як додатні, так і від'ємні значення (наприклад, byte, short, int, long).
Беззнакові типи зберігають лише додатні значення. У Java беззнаковим типом є char, який представляє символи через числові значення.

4. Яке максимальне число можна записати у змінну типу short, char, int, long?

short: 32,767
char: 65,535
int: 2,147,483,647
long: 9,223,372,036,854,775,807
5. Змінна типу byte може приймати значення у діапазоні -128..127. Чому цей діапазон саме такий? Чому від’ємних значень більше ніж додатних?
Змінна типу byte займає 1 байт, що дає 256 можливих значень (2^8). Оскільки byte є знаковим типом, половина діапазону використовується для від’ємних чисел (-128..-1), одне значення для 0, і решта для додатних чисел (1..127). Таким чином, від'ємних значень на одне більше, ніж додатних.

6. Що таке система числення? Як переводити значення з однієї системи числення у іншу?
Система числення – це набір символів і правил для представлення чисел. Найпоширеніші системи числення – десяткова (основа 10), двійкова (основа 2), шістнадцяткова (основа 16). Для переведення числа з однієї системи в іншу використовують ділення на основу (при переведенні з десяткової в іншу) або множення на основу (при переведенні в десяткову).

7. Що таке «Доповняльний код»?
Доповняльний код (двійкове доповнення) – це спосіб представлення від'ємних чисел у двійковій системі числення. Для знаходження доповняльного коду додають до числа 1 після інвертування всіх бітів. Це дозволяє уникати проблем при обчисленнях з від’ємними числами.

8. Пояснити результат роботи такого фрагмента коду:
9. int a = 2_000_000_000;
int b = 2_000_000_000;
int c = a + b;
System.out.println(c);
Результатом буде -294,967,296 через переповнення. Оскільки максимальне значення для int – 2,147,483,647, при додаванні двох чисел, що перевищують цей поріг, відбувається переповнення, і результат буде негативним.

9. Чим тип float відрізняється від double?
Тип float використовує 4 байти пам'яті і має меншу точність (приблизно 7 десяткових знаків), тоді як double використовує 8 байтів і має більшу точність (приблизно 15 десяткових знаків). double зазвичай використовується для більш точних обчислень.

10. Що таке число з рухомою комою? Що таке мантиса та степінь?
Число з рухомою комою – це представлення чисел з десятковою точкою, яка може "рухатися". Число з рухомою комою складається з мантиси (основної частини числа) і степеня, який визначає, наскільки мантиса зміщена вліво або вправо.

11. Що таке Double.NaN?
NaN (Not a Number) – це спеціальне значення типу double, яке представляє результат недійсних математичних операцій, таких як ділення нуля на нуль або спроба отримати квадратний корінь з від'ємного числа.

12. Пояснити результат роботи такого фрагменту коду:
System.out.println(Double.NaN == Double.NaN);
Результат буде false, тому що згідно з правилами IEEE для чисел з рухомою комою, NaN не вважається рівним самому собі.
13. Пояснити різницю між преінкрементом та постінкрементом. Навести приклади, коли ці операції призводять до різних результатів.
- Преінкремент (++x) збільшує значення змінної перед використанням у виразі. - Постінкремент (x++) збільшує значення змінної після використання у виразі.
Приклад:
int x = 5;
int y = ++x;  // y = 6, x = 6
int z = x++;  // z = 6, x = 7
14. В чому різниця між логічною та побітовою операцією AND? Чому звичайна операція AND (&) є в обох варіантах, а її короткозамкнута версія (&&) лише тільки логічна?
Логічна AND (&&) працює з булевими значеннями і не перевіряє другу частину виразу, якщо перша є хибною (коротке замикання).
Побітова AND (&) працює побітово на числових значеннях і завжди перевіряє обидві частини виразу.

Операція && існує тільки для логічних операцій, оскільки коротке замикання не має сенсу для побітових операцій.

15. В чому різниця між OR та XOR?

OR (|) повертає істину, якщо хоча б один операнд є істинним.
XOR (^) повертає істину, якщо операнди різні (один істинний, інший хибний).
16. Проаналізувати наступний фрагмент програми. Передбачити його результат. Запустити. Пояснити.
boolean a = true && false | false;
System.out.println(a = false);

boolean b = true && false || false;
System.out.println(b = true);

- a: Вираз true && false | false дає false. Потім результат присвоюється a = false.
- b: Вираз true && false || false також дає false. Але потім результат присвоюється b = true.
