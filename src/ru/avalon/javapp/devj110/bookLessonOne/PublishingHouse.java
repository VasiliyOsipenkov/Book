package ru.avalon.javapp.devj110.bookLessonOne;

public class PublishingHouse {
    private String name;
    private String city;

    public PublishingHouse(String name, String city) {
        checkName(name);
        checkCity(city);
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    private static void checkName(String name) {
        if (name==null)
            throw new IllegalArgumentException("Издательство должно иметь название");
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    private static void checkCity(String city) {
        if (city==null)
            throw new IllegalArgumentException("Укажите город размещения издательства");
    }

    public void setCity(String city) {
        checkCity(city);
        this.city = city;
    }
}
