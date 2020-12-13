package de.henrikkaltenbach.forzatelemetry.scenarios;

public class Sector {

    public static final Sector NO_SECTOR;
    protected static final Sector[] NUERBURGRING_FULL_CIRCUIT;
    protected static final Sector[] NUERBURGRING_NORDSCHLEIFE;
    protected static final Sector[] NUERBURGRING_GP_CIRCUIT;

    static {
        NO_SECTOR = new Sector("no sector", 0f, 0f);
        NUERBURGRING_FULL_CIRCUIT = new Sector[]{
            NO_SECTOR
        };
        NUERBURGRING_NORDSCHLEIFE = new Sector[]{
                new Sector("Hatzenbach", 0f, 1300f),
                new Sector("Hocheichen", 1300f, 1822f),
                new Sector("Quiddelbacher-Höhe", 1822f, 2230f),
                new Sector("Flugplatz", 2230f, 2540f),
                new Sector("Kottenborn", 2540f, 3090f),
                new Sector("Schwedenkreuz", 3090f, 3575f),
                new Sector("Aremberg", 3575f, 3865f),
                new Sector("Poststraße", 3865f, 3980f),
                new Sector("Fuchsröhre", 3980f, 4855f),
                new Sector("Adenauer Forst", 4855f, 5300f),
                new Sector("Metzgesfeld", 5300f, 6174f),
                new Sector("Kallenhard", 6174f, 7125f),
                new Sector("Wehrseifen", 7125f, 7725f),
                new Sector("Ex-Mühle", 7725f, 7900f),
                new Sector("Ausfahrt Breidscheid", 7900f, 8000f),
                new Sector("Ex-Mühle", 8000f, 8646f),
                new Sector("Bergwerk", 8646f, 9737f),
                new Sector("Kesselchen", 9737f, 10270f),
                new Sector("Klostertal", 10270f, 10680f),
                new Sector("Mutkurve", 10680f, 10920f),
                new Sector("Klostertal", 10920f, 11300f),
                new Sector("Steilstrecke", 11300f, 11770f),
                new Sector("Caracciola-Karussell", 11770f, 12770f),
                new Sector("Hohe Acht", 12770f, 13144f),
                new Sector("Hedwigshöhe", 13144f, 13470f),
                new Sector("Wippermann", 13470f, 13830f),
                new Sector("Eschbach", 13830f, 14200f),
                new Sector("Brünnchen", 14200f, 14550f),
                new Sector("Eiskurve", 14550f, 14680f),
                new Sector("Brünnchen", 14680f, 15069f),
                new Sector("Pflanzgarten", 15069f, 15575f),
                new Sector("Sprunghügel", 15575f, 15755f),
                new Sector("Pflanzgarten", 15755f, 15965f),
                new Sector("Stefan-Bellof-S", 15965f, 16460f),
                new Sector("Schwalbenschwanz", 16460f, 16790f),
                new Sector("kleines Karussell", 16790f, 16918f),
                new Sector("Schwalbenschwanz", 16918f, 17187f),
                new Sector("Galgenkopf", 17187f, 17590f),
                new Sector("Döttinger Höhe", 17590f, 19484f),
                new Sector("neue Einfahrt Nordschleife", 19000f, 19365),
                new Sector("Döttinger Höhe", 19365f, 19465f),
                new Sector("Antoniusbuche", 19465f, 19840f),
                new Sector("Tiergarten", 19840f, 20275f),
                new Sector("Hohenrain", 20275f, 20575f),
                new Sector("Start-Ziel-Gerade", 20575f, 20808f)
        };
        NUERBURGRING_GP_CIRCUIT = new Sector[]{
            NO_SECTOR
        };
    }

    private final String name;
    private final float start;
    private final float end;

    private Sector(String name, float start, float end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    protected float getStart() {
        return start;
    }

    protected float getEnd() {
        return end;
    }
}
