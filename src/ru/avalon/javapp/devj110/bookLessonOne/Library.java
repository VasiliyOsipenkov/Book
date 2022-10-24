package ru.avalon.javapp.devj110.bookLessonOne;

public class Library {
    public static void main(String[] args) {
        PublishingHouse avenue = new PublishingHouse("Проспект", "Москва");             //Конструктор в классе объектов типа издательство (PublishingHouse)
        PublishingHouse petersburg = new PublishingHouse("Питер", "Санкт-Петербург");   //сделан для удобства выполнения основного задания,
        PublishingHouse bhv = new PublishingHouse("БХВ", "Санкт-Петебург");             //проверки на проброс исключений приведены ниже.
        PublishingHouse dialectics = new PublishingHouse("Диалектика", "Киев");

        Book[] books = new Book[] {
                new Book("Computer Science: основы программирования на Java,ООП, алгоритмы и структуры данных",
                        new String[] {"Седжвик Роберт", "Уэйн Кевин"}, 2018, petersburg),
                new Book("Разработка требований к программному обеспечению. 3-е издание, дополненное", "Вигерс Карл", 2019, bhv),
                new Book("Java. Полное руководство, 10-е издание", "Шилдт Герберт", 2018, dialectics),
                new Book("C/C++. Процедурное программирование", "Полубенцева М.И.", 2017, bhv),
                new Book("Конституция РФ", 2020, avenue)
        };

        Book.printAll(books);

        bhv.setCity("Санкт-Петербург");

        System.out.println(); //Вывод пустой строки для красоты.

        Book.printAll(books); /*Вывод для книг издательства БХВ изменился потому, что в объекте издательства БХВ (bhv) было изменено приватное поле city, с помощью
                              соответстующего сеттера setCity для объектов типа издательства (PublishingHouse).*/

        //System.out.println(books[0].getNumberOfAuthors()); //Проверка геттера возвращающего количество авторов книги.
        //System.out.println(books[4].getAuthor(0)); //Проверка геттера возвращающего имя автора по индексу, а также связанного с вводом
                                                     //некорректного индекса исключения.

        //books[0].setName(null); //Проверка на проброс исключения в случае если атрибут книги (Book) name - пустая ссылка.
        //books[0].setPublishingHouse(null); //Проверка на проброс исключения в случае если атрибут книги (Book) publishingHouse - пустая ссылка.
        //books[0].setYear(0); //Проверка на проброс исключения в случае если атрибут книги (Book) year - меньшьше или равен нулю.
        //avenue.setName(null); //Проверка на проброс исключения в случае если атрибут издательства (PublishingHouse) name - пустая ссылка.
        //avenue.setCity(null); //Проверка на проброс исключения в случае если атрибут издательства (PublishingHouse) city - пустая ссылка.
        //books[0].setAuthors(new String[] {"Петров", null, "Иванов"}); //Проверка на проброс исключения в случае если массив authors содержить пустые ссылки.
    }
}
