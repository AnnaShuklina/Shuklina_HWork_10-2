# Rational
Все тесты содержатся в одном файле, но условно разделены на три группы. Комменатрии отделяют данные группы.
1.тесты над объектами рациональных чисел: тесты на создание объекта Rational , тесты на проверку сокращения дроби при ее создании
2.тесты на арифметические операции тесты на сложение, вычитание, умножение, деление 
3.тесты на сравнение дробей

При сравнении дробей была обнаружена следующая ошибка: проводит некорректное сравнение с нулем, если дробь имеет знаменатель отличный от 1, в том случае, если ноль задан стандартным  значением по умолчанию 0/1. Также не получилось провести тест с изменением знаменателя на ноль у заранее заданной дроби.  