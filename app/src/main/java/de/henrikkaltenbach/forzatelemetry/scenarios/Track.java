package de.henrikkaltenbach.forzatelemetry.scenarios;

public class Track {

    public static final Track NO_TRACK;
    protected static final Track[] NUERBURGRING;
    protected static final Track[] HOCKENHEIMRING;

    static {
        NO_TRACK = new Track("no track", Float.POSITIVE_INFINITY, new Sector[]{Sector.NO_SECTOR});
        NUERBURGRING = new Track[]{
                new Track("Full Circuit", 25990f, Sector.NUERBURGRING_FULL_CIRCUIT),
                new Track("Nordschleife", 20810f, Sector.NUERBURGRING_NORDSCHLEIFE),
                new Track("GP Circuit", 5150f, Sector.NUERBURGRING_GP_CIRCUIT)
        };
        HOCKENHEIMRING = new Track[]{
                NO_TRACK
        };
    }

    protected final String name;
    protected final float length;
    protected final Sector[] sectors;

    private Track(String name, float length, Sector[] sectors) {
        this.name = name;
        this.length = length;
        this.sectors = sectors;
    }

    public String getSector(float distanceTraveled) {
        distanceTraveled = getDistanceTraveledLap(distanceTraveled);
        for (Sector sector : sectors) {
            if (sector.getStart() < distanceTraveled && distanceTraveled < sector.getEnd()) {
                return sector.getName();
            }
        }
        return Sector.NO_SECTOR.getName();
    }

    public String getName() {
        return name;
    }

    public float getDistanceTraveledLap(float distanceTraveled) {
        while (distanceTraveled < 0f) {
            distanceTraveled += length;
        }
        return distanceTraveled % length;
    }
}
