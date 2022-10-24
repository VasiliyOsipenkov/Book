package ru.avalon.javapp.devj110.bookLessonOne;

public class Book {
    private String name;
    private PublishingHouse publishingHouse;
    private int year;
    private String[] authors;

    public Book(String name, int year, PublishingHouse publishingHouse) {
        checkBase(name, year, publishingHouse);
        this.name = name;
        this.year = year;
        this.publishingHouse = publishingHouse;
    }

    public Book(String name, String author, int year, PublishingHouse publishingHouse) {
        checkBase(name, year, publishingHouse);
        this.name = name;
        if (author==null)
            throw new IllegalArgumentException("Список авторов не содержать пустых ссылок");
        else
            this.authors = new String[]{author};
        this.year = year;
        this.publishingHouse = publishingHouse;
    }

    public Book(String name, String[] authors, int year, PublishingHouse publishingHouse) {
        checkBase(name, year, publishingHouse);
        checkAuthorsNullSel(authors);
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.publishingHouse = publishingHouse;
    }

    public String getName() {
        return name;
    }

    private static void checkName(String name) {
        if (name==null)
            throw new IllegalArgumentException("Книга должна иметь название");
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    private static void checkPubHouse(PublishingHouse publishingHouse) {
        if (publishingHouse==null)
            throw new IllegalArgumentException("Книга должна иметь издателя");
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        checkPubHouse(publishingHouse);
        this.publishingHouse = publishingHouse;
    }

    public int getYear() {
        return year;
    }

    private static void checkYear(int year) {
        if (year<=0)
            throw new IllegalArgumentException("Книга должна быть написана в новое время");
    }

    public void setYear(int year) {
        checkYear(year);
        this.year = year;
    }

    public String[] getAuthors() {
        return authors;
    }

    private static void checkAuthorsNullSel(String[] authors) {
        for (String s : authors) {
            if (s==null) {
                throw new IllegalArgumentException("Список авторов не содержать пустых ссылок");
            }
        }
    }

    public void setAuthors(String[] authors) {
        checkAuthorsNullSel(authors);
        this.authors = authors;
    }

    public int getNumberOfAuthors () {
        if (authors!=null)
            return authors.length;
        else
            return 0;
    }
    public String getAuthor(int index) {
        if (authors==null) {
            throw new IllegalArgumentException("Автор не указан");
        }

        if (index < authors.length && index >= 0)
            return authors[index];
        else
            throw new ArrayIndexOutOfBoundsException("Автор под данным индексом отсутствует");
    }

    public void print() {
        String a = "";
        if (authors!= null) {
            for (String s : authors) {
                a=a + s + ", ";
            }
            System.out.println("Книга: " + name + (authors.length==1 ? ". Автор: " + a.substring(0, a.length()-2) : ". Авторы: " + a.substring(0, a.length()-2)) + ". Издательство: "
                    + getPublishingHouse().getName() + ", " + getPublishingHouse().getCity() + ". Год издания: " + year);
        }
        else {
            System.out.println("Книга: " + name + ". Издательство: "
                    + getPublishingHouse().getName() + ", " + getPublishingHouse().getCity() + ". Год издания: " + year);
        }
    }

    public static void printAll(Book[] books) {
        for (Book c : books) {
            c.print();
        }
    }

    private static void checkBase(String name, int year, PublishingHouse publishingHouse) {
        checkName(name);
        checkYear(year);
        checkPubHouse(publishingHouse);
    }
}
