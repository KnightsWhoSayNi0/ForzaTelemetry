package de.henrikkaltenbach.forzatelemetry.scenarios;

public class Environment {

    private static final Environment NO_ENVIRONMENT;
    private static final Environment[] ENVIRONMENTS;

    static {
        NO_ENVIRONMENT = new Environment("no environment", new Track[]{Track.NO_TRACK});
        ENVIRONMENTS = new Environment[]{
                new Environment("Nürburgring", Track.NUERBURGRING)
        };
    }

    protected final String name;
    protected final Track[] tracks;

    protected Environment(String name, Track[] tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public static Environment getEnvironment(String name) {
        for (Environment environment : ENVIRONMENTS) {
            if (environment.name.equals(name)) {
                return environment;
            }
        }
        return NO_ENVIRONMENT;
    }

    public Track getTrack(String name) {
        for (Track track : tracks) {
            if (track.name.equals(name)) {
                return track;
            }
        }
        return Track.NO_TRACK;
    }
}
