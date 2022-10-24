package ru.avalon.javapp.devj110.bookLessonOne;

public class Book {
    private String name;
    private PublishingHouse publishingHouse;
    private int year;
    private String[] authors;

    public Book(String name, int year, PublishingHouse publishingHouse) {
        setName(name);
        setYear(year);
        setPublishingHouse(publishingHouse);
    }

    public Book(String name, String author, int year, PublishingHouse publishingHouse) {
        setName(name);
        if (author==null)
            throw new IllegalArgumentException("Список авторов не содержать пустых ссылок");
        else
            setAuthors(new String[]{author});
        setYear(year);
        setPublishingHouse(publishingHouse);
    }

    public Book(String name, String[] authors, int year, PublishingHouse publishingHouse) {
        setName(name);
        setAuthors(authors);
        setYear(year);
        setPublishingHouse(publishingHouse);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null)
            throw new IllegalArgumentException("Книга должна иметь название");
        this.name = name;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        if (publishingHouse==null)
            throw new IllegalArgumentException("Книга должна иметь издателя");
        this.publishingHouse = publishingHouse;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year<=0)
            throw new IllegalArgumentException("Книга должна быть написана в новое время");
        this.year = year;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        for (String s : authors) {
            if (s==null) {
                throw new IllegalArgumentException("Список авторов не содержать пустых ссылок");
            }
        }
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
            System.out.println("Книга: " + name + (authors.length==1 ? ". Автор: " + a.substring(0, a.length()-2) : ". Авторы: " + a.substring(0, a.length()-2))
                    + ". Издательство: " + getPublishingHouse().getName() + ", " + getPublishingHouse().getCity() + ". Год издания: " + year);
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
}
