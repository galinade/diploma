План:

1. Определяем «границы» приложения, реализованный функционал.
2. Проведём функциональное тестирование:
   Авторизация Валидация обязательных полей Навигация между разделами приложения Тестирование
   фильтров
3. Пишем чек-листы.
4. Составляем тест-кейсы.
5. В качестве инструмента для автоматизации тест-кейсов возьмем Espresso (фреймворк для
   UI-тестирования) т.к. Espresso - предоставляет рекордер для записи тестов; Espresso решает
   низкоуровневую задачу — найти необходимый элемент на экране по заданным параметрам (ViewMatcher),
   произвести с ним действия (ViewAction) или выполнить проверки (ViewAssertion); Espresso -
   обеспечивает повышенную скорость и стабильность тестов.
6. Пишем автотесты.
7. Составляем отчеты.
8. Потенциальные риски при автоматизации:
   автоматизированные тесты могут упасть по многим причинам, например, при большой загруженности
   тестовой машины или при проблемах с сетью, или из-за того что какой-то элемент на странице не
   успел прогрузиться… для небольших проектов инструменты автоматизированного тестирования могут
   оказаться достаточно затратными, поэтому более рационально их использовать для долгосрочных
   проектов. при различных изменениях в приложении и авто тесты придется либо корректировать либо
   писать новые, надо постоянно поддерживать их.

9. Интервальная оценка затрат в часах + поэтапные сроки выполнения работ (edited)
   Планирование и написание документации - 60 ч
   Проведение ручного тестирования - 4 ч
   Автоматизация тест-кейсов - 86 ч
   Подготовка отчета по результатам тестирования - 16 ч


//

- тестируем поля авторизации;
- тестируем главную страницу:
  кнопка главного меню; кнопка Love is all(любовь - это все); кнопка Log out (выйти);
- Claims (информацию о претензиях и функционал для работы с ними);
- News (новостную сводку хосписа);
- тематические цитаты. 
// 

