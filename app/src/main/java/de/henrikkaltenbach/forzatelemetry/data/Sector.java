package de.henrikkaltenbach.forzatelemetry.data;

import de.henrikkaltenbach.forzatelemetry.telemetry.TelemetryViewModel;

public class Sector {

    public static final Sector[] SECTORS = {
            new Sector("Antoniusbuche", 1825f, 1800f, 1520f, 1580f),
            new Sector("Tiergarten", 1520f, 1580f, 1250f, 1237f),
            new Sector("Hohenrain", 1250f, 1237f, 833f, 1200f),
            new Sector("Hatzenbach", 833f, 1200f, -190f, 1360f),
            new Sector("Hocheichen", -190f, 1360f, -550f, 1688f),
            new Sector("Quiddelbacher-Höhe", -550f, 1688f, -784f, 2030f),
            new Sector("Flugplatz", -784f, 2030f, -712f, 2310f),
            new Sector("Kottenborn", -712f, 2310f, -780f, 2846f),
            new Sector("Schwedenkreuz", -780f, 2846f, -1000f, 3237f),
            new Sector("Aremberg", -1000f, 3237f, -1100f, 3424f),
            new Sector("Poststraße", -1100f, 3424f, -1000f, 3460f),
            new Sector("Fuchsröhre", -1000f, 3460f, -405f, 4050f),
            new Sector("Adenauer Forst", -405f, 4050f, -164f, 4490f),
            new Sector("Metzgesfeld", -164f, 4490f, 0f, 5044f),
            new Sector("Kallenhard", 0f, 5044f, 380f, 5482f),
            new Sector("Wehrseifen", 380f, 5482f, 900f, 5395f),
            new Sector("Ex-Mühle", 900f, 5395f, 1051f, 5454f),
            new Sector("Ausfahrt Breidscheid", 1051f, 5454f, 1056f, 5525f),
            new Sector("Ex-Mühle", 1056f, 5525f, 1640f, 5760f),
            new Sector("Bergwerk", 1640f, 5760f, 2175f, 5125f),
            new Sector("Kesselchen", 2175f, 5125f, 2700f, 5057f),
            new Sector("Klostertal", 2700f, 5057f, 3075f, 4852f),
            new Sector("Mutkurve", 3075f, 4852f, 3272f, 4888f),
            new Sector("Klostertal", 3272f, 4888f, 3600f, 5060f),
            new Sector("Steilstrecke", 3600f, 5060f, 3650f, 4882f),
            new Sector("Caracciola-Karussell", 3650f, 4882f, 4138f, 5200f),
            new Sector("Hohe Acht", 4138f, 5200f, 4430f, 5266f),
            new Sector("Hedwigshöhe", 4430f, 5266f, 4700f, 5109f),
            new Sector("Wippermann", 4700f, 5109f, 4785f, 4815f),
            new Sector("Eschbach", 4785f, 4815f, 4948f, 4546f),
            new Sector("Brünnchen", 4948f, 4546f, 4752f, 4409f),
            new Sector("Eiskurve", 4752f, 4409f, 4640f, 4343f),
            new Sector("Brünnchen", 4640f, 4343f, 4518f, 4000f),
            new Sector("Pflanzgarten", 4518f, 4000f, 4222f, 3655f),
            new Sector("Sprunghügel", 4222f, 3655f, 4132f, 3500f),
            new Sector("Pflanzgarten", 4132f, 3500f, 3970f, 3374f),
            new Sector("Stefan-Bellof-S", 3970f, 3374f, 3500f, 3268f),
            new Sector("Schwalbenschwanz", 3500f, 3268f, 3220f, 3268f),
            new Sector("kleines Karussell", 3220f, 3268f, 3215f, 3165f),
            new Sector("Schwalbenschwanz", 3215f, 3165f, 3450f, 3049f),
            new Sector("Galgenkopf", 3450f, 3049f, 3438f, 2720f),
            new Sector("Döttinger Höhe", 3438f, 2720f, 1825f, 1800f)
    };

    private final String sector;
    private final float startX;
    private final float startZ;
    private final float endX;
    private final float endZ;

    public Sector(String sector, float startX, float startZ, float endX, float endZ) {
        this.sector = sector;
        this.startX = startX;
        this.startZ = startZ;
        this.endX = endX;
        this.endZ = endZ;
    }

    public static String getSector(float positionX, float positionZ) {
        for (Sector s : SECTORS) {
            if (s.startX < positionX && positionX < s.endX && s.startZ < positionZ && positionZ < s.endZ) {
                return s.sector;
            }
        }
        return "bad sector";
    }
}
