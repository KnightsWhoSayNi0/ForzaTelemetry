package de.henrikkaltenbach.forzatelemetry.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import de.henrikkaltenbach.forzatelemetry.BR;
import de.henrikkaltenbach.forzatelemetry.scenarios.*;

public class CalculatedViewModel extends BaseObservable {

    protected final TelemetryViewModel telemetry = TelemetryViewModel.getInstance();

    // region Singleton
    //
    protected static CalculatedViewModel instance;

    protected CalculatedViewModel() {
        track = Track.NO_TRACK;
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
    protected float maxMeasuredRpm;
    protected float maxMeasuredAcceleration;
    protected float maxMeasuredDeceleration;
    protected float velocity;
    protected float angularVelocity;
    protected float normalizedAcceleration;
    protected float normalizedDeceleration;
    protected float wheelRpmDiffFrontAbsolute;
    protected float wheelRpmDiffFrontPercentage;
    protected float wheelRpmDiffRearAbsolute;
    protected float wheelRpmDiffRearPercentage;
    protected float wheelRpmDiffLeftAbsolute;
    protected float wheelRpmDiffLeftPercentage;
    protected float wheelRpmDiffRightAbsolute;
    protected float wheelRpmDiffRightPercentage;
    protected float shiftWarning;
    protected float shiftWarningThresholdLow;
    protected float shiftWarningThresholdHigh;
    protected float tireTempAverageFront;
    protected float tireTempAverageRear;
    protected float tireTempAverageLeft;
    protected float tireTempAverageRight;
    protected float tireTempAverageTotal;
    protected Track track;
    protected String sector;
    // endregion Fields

    // region Getter
    //
    @Bindable
    public float getMaxMeasuredRpm() {
        return maxMeasuredRpm;
    }

    @Bindable
    public float getMaxMeasuredAcceleration() {
        return maxMeasuredAcceleration;
    }

    @Bindable
    public float getMaxMeasuredDeceleration() {
        return maxMeasuredDeceleration;
    }

    @Bindable
    public float getVelocityMps() {
        return velocity;
    }

    @Bindable
    public float getVelocityKph() {
        return velocity * 3.6f;
    }

    @Bindable
    public float getVelocityMph() {
        return velocity * 2.23693629f;
    }

    @Bindable
    public float getAngularVelocity() {
        return angularVelocity;
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
    public float getWheelRpmDiffFrontAbsolute() {
        return wheelRpmDiffFrontAbsolute;
    }

    @Bindable
    public float getWheelRpmDiffFrontPercentage() {
        return wheelRpmDiffFrontPercentage;
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
    public float getWheelRpmDiffLeftAbsolute() {
        return wheelRpmDiffLeftAbsolute;
    }

    @Bindable
    public float getWheelRpmDiffLeftPercentage() {
        return wheelRpmDiffLeftPercentage;
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
    public float getTireTempAverageFrontCelsius() {
        return convertFahrenheitToCelsius(tireTempAverageFront);
    }

    @Bindable
    public float getTireTempAverageRearCelsius() {
        return convertFahrenheitToCelsius(tireTempAverageRear);
    }

    @Bindable
    public float getTireTempAverageLeftCelsius() {
        return convertFahrenheitToCelsius(tireTempAverageLeft);
    }

    @Bindable
    public float getTireTempAverageRightCelsius() {
        return convertFahrenheitToCelsius(tireTempAverageRight);
    }

    @Bindable
    public float getTireTempAverageTotalCelsius() {
        return convertFahrenheitToCelsius(tireTempAverageTotal);
    }

    @Bindable
    public String getSector() {
        return sector;
    }
    // endregion Getter

    // region Setter
    //
    public void setNormalizedAcceleration(float normalizedAcceleration) {
        if (this.normalizedAcceleration != normalizedAcceleration) {
            if (maxMeasuredAcceleration < normalizedAcceleration) {
                maxMeasuredAcceleration = normalizedAcceleration;
            }
            this.normalizedAcceleration = normalizedAcceleration;
            notifyPropertyChanged(BR.normalizedAcceleration);
        }
    }

    public void setNormalizedDeceleration(float normalizedDeceleration) {
        if (this.normalizedDeceleration != normalizedDeceleration) {
            if (maxMeasuredDeceleration < normalizedDeceleration) {
                maxMeasuredDeceleration = normalizedDeceleration;
            }
            this.normalizedDeceleration = normalizedDeceleration;
            notifyPropertyChanged(BR.normalizedDeceleration);
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

    public void calcVelocity() {
        float velocity = getVector3DLength(
                telemetry.velocityX,
                telemetry.velocityY,
                telemetry.velocityZ
        );
        if (this.velocity != velocity) {
            this.velocity = velocity;
            notifyPropertyChanged(BR.velocityMps);
            notifyPropertyChanged(BR.velocityKph);
            notifyPropertyChanged(BR.velocityMph);
        }
    }

    public void calcAngularVelocity() {
        float angularVelocity = getVector3DLength(
                telemetry.angularVelocityX,
                telemetry.angularVelocityY,
                telemetry.angularVelocityZ
        );
        if (this.angularVelocity != angularVelocity) {
            this.angularVelocity = angularVelocity;
            notifyPropertyChanged(BR.angularVelocity);
        }
    }

    public void calcTireTempAverageFront() {
        float tireTempFront = getAverage(
                telemetry.tireTempFrontLeft,
                telemetry.tireTempFrontRight
        );
        if (this.tireTempAverageFront != tireTempFront) {
            this.tireTempAverageFront = tireTempFront;
            notifyPropertyChanged(BR.tireTempAverageFrontFahrenheit);
            notifyPropertyChanged(BR.tireTempAverageFrontCelsius);
        }
    }

    public void calcTireTempAverageRear() {
        float tireTempRear = getAverage(
                telemetry.tireTempRearLeft,
                telemetry.tireTempRearRight
        );
        if (this.tireTempAverageFront != tireTempRear) {
            this.tireTempAverageRear = tireTempRear;
            notifyPropertyChanged(BR.tireTempAverageRearFahrenheit);
            notifyPropertyChanged(BR.tireTempAverageRearCelsius);
        }
    }

    public void calcTireTempAverageLeft() {
        float tireTempLeft = getAverage(
                telemetry.tireTempFrontLeft,
                telemetry.tireTempRearLeft
        );
        if (this.tireTempAverageFront != tireTempLeft) {
            this.tireTempAverageLeft = tireTempLeft;
            notifyPropertyChanged(BR.tireTempAverageLeftFahrenheit);
            notifyPropertyChanged(BR.tireTempAverageLeftCelsius);
        }
    }

    public void calcTireTempAverageRight() {
        float tireTempRight = getAverage(
                telemetry.tireTempFrontRight,
                telemetry.tireTempRearRight
        );
        if (this.tireTempAverageFront != tireTempRight) {
            this.tireTempAverageRight = tireTempRight;
            notifyPropertyChanged(BR.tireTempAverageRightFahrenheit);
            notifyPropertyChanged(BR.tireTempAverageRightCelsius);
        }
    }

    public void calcTireTempAverageTotal() {
        float tireTempRight = getAverage(
                telemetry.tireTempFrontLeft,
                telemetry.tireTempFrontRight,
                telemetry.tireTempRearLeft,
                telemetry.tireTempRearRight
        );
        if (this.tireTempAverageTotal != tireTempRight) {
            this.tireTempAverageTotal = tireTempRight;
            notifyPropertyChanged(BR.tireTempAverageTotalFahrenheit);
            notifyPropertyChanged(BR.tireTempAverageTotalCelsius);
        }
    }

    public void calcSector() {
        String sector = track.getSector(telemetry.distanceTraveled);
        if (!this.sector.equals(sector)) {
            this.sector = sector;
            notifyPropertyChanged(BR.sector);
        }
    }
    // endregion Setter

    // region Utility methods
    //
    private float convertFahrenheitToCelsius(float temperature) {
        return (temperature - 32f) / 1.8f;
    }

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
