package main_java_music;

public abstract class Instrument {

    protected String name;

    public Instrument(String name) {
        this.name = name;
    }

    public Instrument() {
    }

    public abstract void play();
}
