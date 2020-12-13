package de.henrikkaltenbach.forzatelemetry.scenarios;

public class Track {

    protected static final Track[] NUERBURGRING;
    public static final Track NO_TRACK;

    static {
        NUERBURGRING = new Track[]{
                new Track("Full Circuit", 25990f, null),    // Todo: determine sectors of the 'Full Circuit'.
                new Track("Nordschleife", 20810f, Sector.NORDSCHLEIFE),
                new Track("GP Circuit", 5150f, null)    // Todo: determine sectors of the 'GP Circuit'.
        };
        NO_TRACK = new Track("no track", Float.POSITIVE_INFINITY, new Sector[]{Sector.NO_SECTOR});
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

    public float getDistanceTraveledLap(float distanceTraveled) {
        while (distanceTraveled < 0f) {
            distanceTraveled += length;
        }
        return distanceTraveled % length;
    }
}
