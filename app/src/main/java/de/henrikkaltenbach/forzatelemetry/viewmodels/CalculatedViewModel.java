package de.henrikkaltenbach.forzatelemetry.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import de.henrikkaltenbach.forzatelemetry.BR;
import de.henrikkaltenbach.forzatelemetry.scenarios.*;

public class CalculatedViewModel extends BaseObservable {

    // region Cross reference
    //
    private boolean telemetrySet;
    private TelemetryViewModel telemetry;
    public void setTelemetry(TelemetryViewModel telemetry) {
        if (!telemetrySet) {
            this.telemetry = telemetry;
            telemetrySet = true;
        }
    }
    // endregion Cross reference

    // region Singleton
    //
    protected static CalculatedViewModel instance;

    protected CalculatedViewModel() {
        // track = Track.NO_TRACK;
        environment = Environment.getEnvironment("Nürburgring");
        track = environment.getTrack("Nordschleife");
        sector = Sector.NO_SECTOR.getName();
    }

    public static synchronized CalculatedViewModel getInstance() {
        if (instance == null) {
            instance = new CalculatedViewModel();
        }
        return instance;
    }
    // endregion Singleton

    // region Fields
    //
    private Environment environment;
    private String sector;
    private Track track;
    private float angularVelocity;
    private float maxMeasuredAcceleration;
    private float maxMeasuredBoost;
    private float maxMeasuredDeceleration;
    private float maxMeasuredRpm;
    private float normalizedAcceleration;
    private float normalizedDeceleration;
    private float shiftWarning;
    private float shiftWarningThresholdHigh;
    private float shiftWarningThresholdLow;
    private float tireTempAverageFront;
    private float tireTempAverageLeft;
    private float tireTempAverageRear;
    private float tireTempAverageRight;
    private float tireTempAverageTotal;
    private float velocity;
    private float wheelRpmDiffFrontAbsolute;
    private float wheelRpmDiffFrontPercentage;
    private float wheelRpmDiffLeftAbsolute;
    private float wheelRpmDiffLeftPercentage;
    private float wheelRpmDiffRearAbsolute;
    private float wheelRpmDiffRearPercentage;
    private float wheelRpmDiffRightAbsolute;
    private float wheelRpmDiffRightPercentage;
    private int boostProgressBarProgress;
    // endregion Fields

    // region Getter
    //
    public Environment getEnvironment() {
        return environment;
    }

    @Bindable
    public String getEnvironmentName() {
        return environment.getName();
    }

    @Bindable
    public String getSector() {
        return sector;
    }

    public Track getTrack() {
        return track;
    }

    @Bindable
    public String getTrackName() {
        return track.getName();
    }

    @Bindable
    public float getAngularVelocity() {
        return angularVelocity;
    }

    @Bindable
    public float getMaxMeasuredAcceleration() {
        return maxMeasuredAcceleration;
    }

    @Bindable
    public float getMaxMeasuredBoost() {
        return maxMeasuredBoost;
    }

    @Bindable
    public float getMaxMeasuredDeceleration() {
        return maxMeasuredDeceleration;
    }

    @Bindable
    public float getMaxMeasuredRpm() {
        return maxMeasuredRpm;
    }

    @Bindable
    public float getNormalizedAcceleration() {
        return normalizedAcceleration;
    }

    @Bindable
    public float getNormalizedDeceleration() {
        return normalizedDeceleration;
    }

    @Bindable
    public float getShiftWarning() {
        return shiftWarning;
    }

    @Bindable
    public float getShiftWarningThresholdLow() {
        return shiftWarningThresholdLow;
    }

    @Bindable
    public float getShiftWarningThresholdHigh() {
        return shiftWarningThresholdHigh;
    }

    @Bindable
    public float getTireTempAverageFrontFahrenheit() {
        return tireTempAverageFront;
    }

    @Bindable
    public float getTireTempAverageRearFahrenheit() {
        return tireTempAverageRear;
    }

    @Bindable
    public float getTireTempAverageLeftFahrenheit() {
        return tireTempAverageLeft;
    }

    @Bindable
    public float getTireTempAverageRightFahrenheit() {
        return tireTempAverageRight;
    }

    @Bindable
    public float getTireTempAverageTotalFahrenheit() {
        return tireTempAverageTotal;
    }

    @Bindable
    public float getVelocity() {
        return velocity;
    }

    @Bindable
    public float getWheelRpmDiffFrontAbsolute() {
        return wheelRpmDiffFrontAbsolute;
    }

    @Bindable
    public float getWheelRpmDiffFrontPercentage() {
        return wheelRpmDiffFrontPercentage;
    }

    @Bindable
    public float getWheelRpmDiffLeftAbsolute() {
        return wheelRpmDiffLeftAbsolute;
    }

    @Bindable
    public float getWheelRpmDiffLeftPercentage() {
        return wheelRpmDiffLeftPercentage;
    }

    @Bindable
    public float getWheelRpmDiffRearAbsolute() {
        return wheelRpmDiffRearAbsolute;
    }

    @Bindable
    public float getWheelRpmDiffRearPercentage() {
        return wheelRpmDiffRearPercentage;
    }

    @Bindable
    public float getWheelRpmDiffRightAbsolute() {
        return wheelRpmDiffRightAbsolute;
    }

    @Bindable
    public float getWheelRpmDiffRightPercentage() {
        return wheelRpmDiffRightPercentage;
    }

    @Bindable
    public int getBoostProgressBarProgress() {
        return boostProgressBarProgress;
    }
    // endregion Getter

    // region Setter
    //
    public void setEnvironment(String environment) {
        if (!this.environment.getName().equals(environment)) {
            this.environment = Environment.getEnvironment(environment);
            notifyPropertyChanged(BR.environmentName);
        }
    }

    public void calcSector() {
        String sector = track.getSector(telemetry.getDistanceTraveledTotal());
        if (!this.sector.equals(sector)) {
            this.sector = sector;
            notifyPropertyChanged(BR.sector);
        }
    }

    public void setTrack(String track) {
        if (!this.track.getName().equals(track)) {
            this.track = environment.getTrack(track);
            notifyPropertyChanged(BR.trackName);
        }
    }

    public void calcAngularVelocity() {
        float angularVelocity = getVector3DLength(
                telemetry.getAngularVelocityX(),
                telemetry.getAngularVelocityY(),
                telemetry.getAngularVelocityZ()
        );
        if (this.angularVelocity != angularVelocity) {
            this.angularVelocity = angularVelocity;
            notifyPropertyChanged(BR.angularVelocity);
        }
    }

    public void setMaxMeasuredAcceleration(float maxMeasuredAcceleration) {
        if (this.maxMeasuredAcceleration != maxMeasuredAcceleration) {
            this.maxMeasuredAcceleration = maxMeasuredAcceleration;
            notifyPropertyChanged(BR.maxMeasuredAcceleration);
        }
    }

    public void setMaxMeasuredBoost(float maxMeasuredBoost) {
        if (this.maxMeasuredBoost != maxMeasuredBoost) {
            this.maxMeasuredBoost = maxMeasuredBoost;
            notifyPropertyChanged(BR.maxMeasuredBoost);
        }
    }

    public void setMaxMeasuredDeceleration(float maxMeasuredDeceleration) {
        if (this.maxMeasuredDeceleration != maxMeasuredDeceleration) {
            this.maxMeasuredDeceleration = maxMeasuredDeceleration;
            notifyPropertyChanged(BR.maxMeasuredDeceleration);
        }
    }

    public void setMaxMeasuredRpm(float maxMeasuredRpm) {
        if (this.maxMeasuredRpm != maxMeasuredRpm) {
            this.maxMeasuredRpm = maxMeasuredRpm;
            notifyPropertyChanged(BR.maxMeasuredRpm);
        }
    }

    public void setNormalizedAcceleration(float normalizedAcceleration) {
        if (this.normalizedAcceleration != normalizedAcceleration) {
            if (maxMeasuredAcceleration < normalizedAcceleration) {
                maxMeasuredAcceleration = normalizedAcceleration;
                notifyPropertyChanged(BR.maxMeasuredAcceleration);
            }
            this.normalizedAcceleration = normalizedAcceleration;
            notifyPropertyChanged(BR.normalizedAcceleration);
        }
    }

    public void setNormalizedDeceleration(float normalizedDeceleration) {
        if (this.normalizedDeceleration != normalizedDeceleration) {
            if (maxMeasuredDeceleration < normalizedDeceleration) {
                maxMeasuredDeceleration = normalizedDeceleration;
                notifyPropertyChanged(BR.maxMeasuredDeceleration);
            }
            this.normalizedDeceleration = normalizedDeceleration;
            notifyPropertyChanged(BR.normalizedDeceleration);
        }
    }

    public void setShiftWarning(float shiftWarning) {
        if (this.shiftWarning != shiftWarning) {
            this.shiftWarning = shiftWarning;
            notifyPropertyChanged(BR.shiftWarning);
        }
    }

    public void setShiftWarningThresholdLow(float shiftWarningThresholdLow) {
        if (this.shiftWarningThresholdLow != shiftWarningThresholdLow) {
            this.shiftWarningThresholdLow = shiftWarningThresholdLow;
            notifyPropertyChanged(BR.gear);
        }
    }

    public void setShiftWarningThresholdHigh(float shiftWarningThresholdHigh) {
        if (this.shiftWarningThresholdHigh != shiftWarningThresholdHigh) {
            this.shiftWarningThresholdHigh = shiftWarningThresholdHigh;
            notifyPropertyChanged(BR.shiftWarningThresholdHigh);
        }
    }

    public void calcTireTempAverageFront() {
        float tireTempFront = getAverage(
                telemetry.getTireTempFrontLeft(),
                telemetry.getTireTempFrontRight()
        );
        if (this.tireTempAverageFront != tireTempFront) {
            this.tireTempAverageFront = tireTempFront;
            notifyPropertyChanged(BR.tireTempAverageFrontFahrenheit);
        }
    }

    public void calcTireTempAverageRear() {
        float tireTempRear = getAverage(
                telemetry.getTireTempRearLeft(),
                telemetry.getTireTempRearRight()
        );
        if (this.tireTempAverageFront != tireTempRear) {
            this.tireTempAverageRear = tireTempRear;
            notifyPropertyChanged(BR.tireTempAverageRearFahrenheit);
        }
    }

    public void calcTireTempAverageLeft() {
        float tireTempLeft = getAverage(
                telemetry.getTireTempFrontLeft(),
                telemetry.getTireTempRearLeft()
        );
        if (this.tireTempAverageFront != tireTempLeft) {
            this.tireTempAverageLeft = tireTempLeft;
            notifyPropertyChanged(BR.tireTempAverageLeftFahrenheit);
        }
    }

    public void calcTireTempAverageRight() {
        float tireTempRight = getAverage(
                telemetry.getTireTempFrontRight(),
                telemetry.getTireTempRearRight()
        );
        if (this.tireTempAverageFront != tireTempRight) {
            this.tireTempAverageRight = tireTempRight;
            notifyPropertyChanged(BR.tireTempAverageRightFahrenheit);
        }
    }

    public void calcTireTempAverageTotal() {
        float tireTempRight = getAverage(
                telemetry.getTireTempFrontLeft(),
                telemetry.getTireTempFrontRight(),
                telemetry.getTireTempRearLeft(),
                telemetry.getTireTempRearRight()
        );
        if (this.tireTempAverageTotal != tireTempRight) {
            this.tireTempAverageTotal = tireTempRight;
            notifyPropertyChanged(BR.tireTempAverageTotalFahrenheit);
        }
    }

    public void calcVelocity() {
        float velocity = getVector3DLength(
                telemetry.getVelocityX(),
                telemetry.getVelocityY(),
                telemetry.getVelocityZ()
        );
        if (this.velocity != velocity) {
            this.velocity = velocity;
            notifyPropertyChanged(BR.velocity);
        }
    }

    public void setWheelRpmDiffFrontAbsolute(float wheelRpmDiffFrontAbsolute) {
        if (this.wheelRpmDiffFrontAbsolute != wheelRpmDiffFrontAbsolute) {
            this.wheelRpmDiffFrontAbsolute = wheelRpmDiffFrontAbsolute;
            notifyPropertyChanged(BR.wheelRpmDiffFrontAbsolute);
        }
    }

    public void setWheelRpmDiffFrontPercentage(float wheelRpmDiffFrontPercentage) {
        if (this.wheelRpmDiffFrontPercentage != wheelRpmDiffFrontPercentage) {
            this.wheelRpmDiffFrontPercentage = wheelRpmDiffFrontPercentage;
            notifyPropertyChanged(BR.wheelRpmDiffFrontPercentage);
        }
    }

    public void setWheelRpmDiffLeftAbsolute(float wheelRpmDiffLeftAbsolute) {
        if (this.wheelRpmDiffLeftAbsolute != wheelRpmDiffLeftAbsolute) {
            this.wheelRpmDiffLeftAbsolute = wheelRpmDiffLeftAbsolute;
            notifyPropertyChanged(BR.wheelRpmDiffLeftAbsolute);
        }
    }

    public void setWheelRpmDiffLeftPercentage(float wheelRpmDiffLeftPercentage) {
        if (this.wheelRpmDiffLeftPercentage != wheelRpmDiffLeftPercentage) {
            this.wheelRpmDiffLeftPercentage = wheelRpmDiffLeftPercentage;
            notifyPropertyChanged(BR.wheelRpmDiffLeftPercentage);
        }
    }

    public void setWheelRpmDiffRearAbsolute(float wheelRpmDiffRearAbsolute) {
        if (this.wheelRpmDiffRearAbsolute != wheelRpmDiffRearAbsolute) {
            this.wheelRpmDiffRearAbsolute = wheelRpmDiffRearAbsolute;
            notifyPropertyChanged(BR.wheelRpmDiffRearAbsolute);
        }
    }

    public void setWheelRpmDiffRearPercentage(float wheelRpmDiffRearPercentage) {
        if (this.wheelRpmDiffRearPercentage != wheelRpmDiffRearPercentage) {
            this.wheelRpmDiffRearPercentage = wheelRpmDiffRearPercentage;
            notifyPropertyChanged(BR.wheelRpmDiffRearPercentage);
        }
    }

    public void setWheelRpmDiffRightAbsolute(float wheelRpmDiffRightAbsolute) {
        if (this.wheelRpmDiffRightAbsolute != wheelRpmDiffRightAbsolute) {
            this.wheelRpmDiffRightAbsolute = wheelRpmDiffRightAbsolute;
            notifyPropertyChanged(BR.wheelRpmDiffRightAbsolute);
        }
    }

    public void setWheelRpmDiffRightPercentage(float wheelRpmDiffRightPercentage) {
        if (this.wheelRpmDiffRightPercentage != wheelRpmDiffRightPercentage) {
            this.wheelRpmDiffRightPercentage = wheelRpmDiffRightPercentage;
            notifyPropertyChanged(BR.wheelRpmDiffRightPercentage);
        }
    }

    public void setBoostProgressBarProgress(float boost) {
        int progress = Math.round((boost + 11.02f) / (maxMeasuredBoost + 11.02f) * 83f);
        if (boostProgressBarProgress != progress) {
            boostProgressBarProgress = progress;
            notifyPropertyChanged(BR.boostProgressBarProgress);
        }
    }

    public void resetMaxMeasuredValues() {
//        maxMeasuredAcceleration = -1f;
        maxMeasuredBoost = -11.02f;
        boostProgressBarProgress = 0;
//        maxMeasuredDeceleration = -1f;
//        maxMeasuredRpm = -1f;
    }
    // endregion Setter

    // region Utility methods
    //
    private float getAverage(float valueOne, float valueTwo, float valueThree, float valueFour) {
        return (valueOne + valueTwo + valueThree + valueFour) / 4f;
    }

    private float getAverage(float valueOne, float valueTwo) {
        return (valueOne + valueTwo) / 2f;
    }

    private float getVector3DLength(float x, float y, float z) {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }
    // endregion Utility methods
}
