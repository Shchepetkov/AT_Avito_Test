package ru.avito.stepDef.enumeration;

@SuppressWarnings({"NonAsciiCharacters", "unused"})
public enum Filters {

    По_умолчанию(0, "По умолчанию"),
    Дешевле(1, "Дешевле"),
    Дороже(2, "Дороже"),
    По_дате(3, "По дате");

    private final int id;
    private final String name;

    Filters(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}