package ru.avalon.javapp.devj110.bookLessonOne;

public class PublishingHouse {
    private String name;
    private String city;

    public PublishingHouse(String name, String city) {
        setName(name);
        setCity(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null)
            throw new IllegalArgumentException("Издательство должно иметь название");
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city==null)
            throw new IllegalArgumentException("Укажите город размещения издательства");
        this.city = city;
    }
}
