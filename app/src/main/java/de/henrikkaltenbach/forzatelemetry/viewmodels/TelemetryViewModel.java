package de.henrikkaltenbach.forzatelemetry.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import de.henrikkaltenbach.forzatelemetry.BR;

public class TelemetryViewModel extends BaseObservable {

    private final CalculatedViewModel calculated = CalculatedViewModel.getInstance();

    // region Singleton
    //
    private static TelemetryViewModel instance;

    private TelemetryViewModel() {}

    public static synchronized TelemetryViewModel getInstance() {
        if (instance == null) {
            instance = new TelemetryViewModel();
        }
        return instance;
    }
    // endregion Singleton

    // region Fields
    //
    protected int isRaceOn;
    protected int timestampMS;
    protected float engineMaxRpm;
    protected float engineIdleRpm;
    protected float currentEngineRpm;
    protected float accelerationX;
    protected float accelerationY;
    protected float accelerationZ;
    protected float velocityX;
    protected float velocityY;
    protected float velocityZ;
    protected float angularVelocityX;
    protected float angularVelocityY;
    protected float angularVelocityZ;
    protected float yaw;
    protected float pitch;
    protected float roll;
    protected float normalizedSuspensionTravelFrontLeft;
    protected float normalizedSuspensionTravelFrontRight;
    protected float normalizedSuspensionTravelRearLeft;
    protected float normalizedSuspensionTravelRearRight;
    protected float tireSlipRatioFrontLeft;
    protected float tireSlipRatioFrontRight;
    protected float tireSlipRatioRearLeft;
    protected float tireSlipRatioRearRight;
    protected float wheelRotationSpeedFrontLeft;
    protected float wheelRotationSpeedFrontRight;
    protected float wheelRotationSpeedRearLeft;
    protected float wheelRotationSpeedRearRight;
    protected int wheelOnRumbleStripFrontLeft;
    protected int wheelOnRumbleStripFrontRight;
    protected int wheelOnRumbleStripRearLeft;
    protected int wheelOnRumbleStripRearRight;
    protected float wheelInPuddleDepthFrontLeft;
    protected float wheelInPuddleDepthFrontRight;
    protected float wheelInPuddleDepthRearLeft;
    protected float wheelInPuddleDepthRearRight;
    protected float surfaceRumbleFrontLeft;
    protected float surfaceRumbleFrontRight;
    protected float surfaceRumbleRearLeft;
    protected float surfaceRumbleRearRight;
    protected float tireSlipAngleFrontLeft;
    protected float tireSlipAngleFrontRight;
    protected float tireSlipAngleRearLeft;
    protected float tireSlipAngleRearRight;
    protected float tireCombinedSlipFrontLeft;
    protected float tireCombinedSlipFrontRight;
    protected float tireCombinedSlipRearLeft;
    protected float tireCombinedSlipRearRight;
    protected float suspensionTravelMetersFrontLeft;
    protected float suspensionTravelMetersFrontRight;
    protected float suspensionTravelMetersRearLeft;
    protected float suspensionTravelMetersRearRight;
    protected int carOrdinal;
    protected int carClass;
    protected int carPerformanceIndex;
    protected int drivetrainType;
    protected int numCylinders;
    protected float positionX;
    protected float positionY;
    protected float positionZ;
    protected float speed;
    protected float power;
    protected float torque;
    protected float tireTempFrontLeft;
    protected float tireTempFrontRight;
    protected float tireTempRearLeft;
    protected float tireTempRearRight;    // Todo: tire temp rear right seems to be the same as rear left.
    protected float boost;
    protected float fuel;
    protected float distanceTraveled;
    protected float bestLap;
    protected float lastLap;
    protected float currentLap;
    protected float currentRaceTime;
    protected short lapNumber;
    protected byte racePosition;
    protected byte accel;
    protected byte brake;
    protected byte clutch;
    protected byte handBrake;
    protected byte gear;
    protected byte steer;
    protected byte normalizedDrivingLine;
    protected byte normalizedAIBrakeDifference;
    // endregion Fields

    // region Getter
    //
    @Bindable
    public int getIsRaceOn() {
        return isRaceOn;
    }

    @Bindable
    public int getTimestampMS() {
        return timestampMS;
    }

    @Bindable
    public float getEngineMaxRpm() {
        return engineMaxRpm;
    }

    @Bindable
    public float getEngineIdleRpm() {
        return engineIdleRpm;
    }

    @Bindable
    public float getCurrentEngineRpm() {
        return currentEngineRpm;
    }

    @Bindable
    public float getAccelerationX() {
        return accelerationX;
    }

    @Bindable
    public float getAccelerationY() {
        return accelerationY;
    }

    @Bindable
    public float getAccelerationZ() {
        return accelerationZ;
    }

    @Bindable
    public float getVelocityX() {
        return velocityX;
    }

    @Bindable
    public float getVelocityY() {
        return velocityY;
    }

    @Bindable
    public float getVelocityZ() {
        return velocityZ;
    }

    @Bindable
    public float getAngularVelocityX() {
        return angularVelocityX;
    }

    @Bindable
    public float getAngularVelocityY() {
        return angularVelocityY;
    }

    @Bindable
    public float getAngularVelocityZ() {
        return angularVelocityZ;
    }

    @Bindable
    public float getYaw() {
        return yaw;
    }

    @Bindable
    public float getPitch() {
        return pitch;
    }

    @Bindable
    public float getRoll() {
        return roll;
    }

    @Bindable
    public float getNormalizedSuspensionTravelFrontLeft() {
        return normalizedSuspensionTravelFrontLeft;
    }

    @Bindable
    public float getNormalizedSuspensionTravelFrontRight() {
        return normalizedSuspensionTravelFrontRight;
    }

    @Bindable
    public float getNormalizedSuspensionTravelRearLeft() {
        return normalizedSuspensionTravelRearLeft;
    }

    @Bindable
    public float getNormalizedSuspensionTravelRearRight() {
        return normalizedSuspensionTravelRearRight;
    }

    @Bindable
    public float getTireSlipRatioFrontLeft() {
        return tireSlipRatioFrontLeft;
    }

    @Bindable
    public float getTireSlipRatioFrontRight() {
        return tireSlipRatioFrontRight;
    }

    @Bindable
    public float getTireSlipRatioRearLeft() {
        return tireSlipRatioRearLeft;
    }

    @Bindable
    public float getTireSlipRatioRearRight() {
        return tireSlipRatioRearRight;
    }

    @Bindable
    public float getWheelRotationSpeedFrontLeft() {
        return wheelRotationSpeedFrontLeft;
    }

    @Bindable
    public float getWheelRotationSpeedFrontRight() {
        return wheelRotationSpeedFrontRight;
    }

    @Bindable
    public float getWheelRotationSpeedRearLeft() {
        return wheelRotationSpeedRearLeft;
    }

    @Bindable
    public float getWheelRotationSpeedRearRight() {
        return wheelRotationSpeedRearRight;
    }

    @Bindable
    public int getWheelOnRumbleStripFrontLeft() {
        return wheelOnRumbleStripFrontLeft;
    }

    @Bindable
    public int getWheelOnRumbleStripFrontRight() {
        return wheelOnRumbleStripFrontRight;
    }

    @Bindable
    public int getWheelOnRumbleStripRearLeft() {
        return wheelOnRumbleStripRearLeft;
    }

    @Bindable
    public int getWheelOnRumbleStripRearRight() {
        return wheelOnRumbleStripRearRight;
    }

    @Bindable
    public float getWheelInPuddleDepthFrontLeft() {
        return wheelInPuddleDepthFrontLeft;
    }

    @Bindable
    public float getWheelInPuddleDepthFrontRight() {
        return wheelInPuddleDepthFrontRight;
    }

    @Bindable
    public float getWheelInPuddleDepthRearLeft() {
        return wheelInPuddleDepthRearLeft;
    }

    @Bindable
    public float getWheelInPuddleDepthRearRight() {
        return wheelInPuddleDepthRearRight;
    }

    @Bindable
    public float getSurfaceRumbleFrontLeft() {
        return surfaceRumbleFrontLeft;
    }

    @Bindable
    public float getSurfaceRumbleFrontRight() {
        return surfaceRumbleFrontRight;
    }

    @Bindable
    public float getSurfaceRumbleRearLeft() {
        return surfaceRumbleRearLeft;
    }

    @Bindable
    public float getSurfaceRumbleRearRight() {
        return surfaceRumbleRearRight;
    }

    @Bindable
    public float getTireSlipAngleFrontLeft() {
        return tireSlipAngleFrontLeft;
    }

    @Bindable
    public float getTireSlipAngleFrontRight() {
        return tireSlipAngleFrontRight;
    }

    @Bindable
    public float getTireSlipAngleRearLeft() {
        return tireSlipAngleRearLeft;
    }

    @Bindable
    public float getTireSlipAngleRearRight() {
        return tireSlipAngleRearRight;
    }

    @Bindable
    public float getTireCombinedSlipFrontLeft() {
        return tireCombinedSlipFrontLeft;
    }

    @Bindable
    public float getTireCombinedSlipFrontRight() {
        return tireCombinedSlipFrontRight;
    }

    @Bindable
    public float getTireCombinedSlipRearLeft() {
        return tireCombinedSlipRearLeft;
    }

    @Bindable
    public float getTireCombinedSlipRearRight() {
        return tireCombinedSlipRearRight;
    }

    @Bindable
    public float getSuspensionTravelMetersFrontLeft() {
        return suspensionTravelMetersFrontLeft;
    }

    @Bindable
    public float getSuspensionTravelMetersFrontRight() {
        return suspensionTravelMetersFrontRight;
    }

    @Bindable
    public float getSuspensionTravelMetersRearLeft() {
        return suspensionTravelMetersRearLeft;
    }

    @Bindable
    public float getSuspensionTravelMetersRearRight() {
        return suspensionTravelMetersRearRight;
    }

    @Bindable
    public int getCarOrdinal() {
        return carOrdinal;
    }

    @Bindable
    public int getCarClass() {
        return carClass;
    }

    @Bindable
    public int getCarPerformanceIndex() {
        return carPerformanceIndex;
    }

    @Bindable
    public int getDrivetrainType() {
        return drivetrainType;
    }

    @Bindable
    public int getNumCylinders() {
        return numCylinders;
    }

    @Bindable
    public float getPositionX() {
        return positionX;
    }

    @Bindable
    public float getPositionY() {
        return positionY;
    }

    @Bindable
    public float getPositionZ() {
        return positionZ;
    }

    @Bindable
    public float getSpeed() {
        return speed;
    }

    @Bindable
    public float getPower() {
        return power;
    }

    @Bindable
    public float getTorque() {
        return torque;
    }

    @Bindable
    public float getTireTempFrontLeftFahrenheit() {
        return tireTempFrontLeft;
    }

    @Bindable
    public float getTireTempFrontRightFahrenheit() {
        return tireTempFrontRight;
    }

    @Bindable
    public float getTireTempRearLeftFahrenheit() {
        return tireTempRearLeft;
    }

    @Bindable
    public float getTireTempRearRightFahrenheit() {
        return tireTempRearRight;
    }

    @Bindable
    public float getTireTempFrontLeftCelsius() {
        return convertFahrenheitToCelsius(tireTempFrontLeft);
    }

    @Bindable
    public float getTireTempFrontRightCelsius() {
        return convertFahrenheitToCelsius(tireTempFrontRight);
    }

    @Bindable
    public float getTireTempRearLeftCelsius() {
        return convertFahrenheitToCelsius(tireTempRearLeft);
    }

    @Bindable
    public float getTireTempRearRightCelsius() {
        return convertFahrenheitToCelsius(tireTempRearRight);
    }

    @Bindable
    public float getBoostPsi() {
        return boost;
    }

    @Bindable
    public float getBoostBar() {
        return convertPsiToBar(boost);
    }

    @Bindable
    public float getFuel() {
        return fuel;
    }

    @Bindable
    public float getDistanceTraveledTotal() {
        return distanceTraveled;
    }

    @Bindable
    public float getDistanceTraveledLap() {
        return calculated.track.getDistanceTraveledLap(distanceTraveled);
    }

    @Bindable
    public float getBestLap() {
        return bestLap;
    }

    @Bindable
    public float getLastLap() {
        return lastLap;
    }

    @Bindable
    public float getCurrentLap() {
        return currentLap;
    }

    @Bindable
    public float getCurrentRaceTime() {
        return currentRaceTime;
    }

    @Bindable
    public short getLapNumber() {
        return lapNumber;
    }

    @Bindable
    public byte getRacePosition() {
        return racePosition;
    }

    @Bindable
    public byte getAccel() {
        return accel;
    }

    @Bindable
    public byte getBrake() {
        return brake;
    }

    @Bindable
    public byte getClutch() {
        return clutch;
    }

    @Bindable
    public byte getHandBrake() {
        return handBrake;
    }

    @Bindable
    public byte getGear() {
        return gear;
    }

    @Bindable
    public byte getSteer() {
        return steer;
    }

    @Bindable
    public byte getNormalizedDrivingLine() {
        return normalizedDrivingLine;
    }

    @Bindable
    public byte getNormalizedAIBrakeDifference() {
        return normalizedAIBrakeDifference;
    }
    // endregion Getter

    // region Setter
    //
    public void setIsRaceOn(int isRaceOn) {
        if (this.isRaceOn != isRaceOn) {
            this.isRaceOn = isRaceOn;
            notifyPropertyChanged(BR.isRaceOn);
        }
    }

    public void setTimestampMS(int timestampMS) {
        if (this.timestampMS != timestampMS) {
            this.timestampMS = timestampMS;
            notifyPropertyChanged(BR.timestampMS);
        }
    }

    public void setEngineMaxRpm(float engineMaxRpm) {
        if (this.engineMaxRpm != engineMaxRpm) {
            this.engineMaxRpm = engineMaxRpm;
            notifyPropertyChanged(BR.engineMaxRpm);
        }
    }

    public void setEngineIdleRpm(float engineIdleRpm) {
        if (this.engineIdleRpm != engineIdleRpm) {
            this.engineIdleRpm = engineIdleRpm;
            notifyPropertyChanged(BR.engineIdleRpm);
        }
    }

    public void setCurrentEngineRpm(float currentEngineRpm) {
        if (this.currentEngineRpm != currentEngineRpm) {
            if (calculated.maxMeasuredRpm < currentEngineRpm) {
                calculated.maxMeasuredRpm = currentEngineRpm;
            }
            this.currentEngineRpm = currentEngineRpm;
            notifyPropertyChanged(BR.currentEngineRpm);
        }
    }

    public void setAccelerationX(float accelerationX) {
        if (this.accelerationX != accelerationX) {
            this.accelerationX = accelerationX;
            notifyPropertyChanged(BR.accelerationX);
        }
    }

    public void setAccelerationY(float accelerationY) {
        if (this.accelerationY != accelerationY) {
            this.accelerationY = accelerationY;
            notifyPropertyChanged(BR.accelerationY);
        }
    }

    public void setAccelerationZ(float accelerationZ) {
        if (this.accelerationZ != accelerationZ) {
            this.accelerationZ = accelerationZ;
            notifyPropertyChanged(BR.accelerationZ);
        }
    }

    public void setVelocityX(float velocityX) {
        if (this.velocityX != velocityX) {
            this.velocityX = velocityX;
            notifyPropertyChanged(BR.velocityX);
        }
    }

    public void setVelocityY(float velocityY) {
        if (this.velocityY != velocityY) {
            this.velocityY = velocityY;
            notifyPropertyChanged(BR.velocityY);
        }
    }

    public void setVelocityZ(float velocityZ) {
        if (this.velocityZ != velocityZ) {
            this.velocityZ = velocityZ;
            notifyPropertyChanged(BR.velocityZ);
        }
    }

    public void setAngularVelocityX(float angularVelocityX) {
        if (this.angularVelocityX != angularVelocityX) {
            this.angularVelocityX = angularVelocityX;
            notifyPropertyChanged(BR.angularVelocityX);
        }
    }

    public void setAngularVelocityY(float angularVelocityY) {
        if (this.angularVelocityY != angularVelocityY) {
            this.angularVelocityY = angularVelocityY;
            notifyPropertyChanged(BR.angularVelocityY);
        }
    }

    public void setAngularVelocityZ(float angularVelocityZ) {
        if (this.angularVelocityZ != angularVelocityZ) {
            this.angularVelocityZ = angularVelocityZ;
            notifyPropertyChanged(BR.angularVelocityZ);
        }
    }

    public void setYaw(float yaw) {
        if (this.yaw != yaw) {
            this.yaw = yaw;
            notifyPropertyChanged(BR.yaw);
        }
    }

    public void setPitch(float pitch) {
        if (this.pitch != pitch) {
            this.pitch = pitch;
            notifyPropertyChanged(BR.pitch);
        }
    }

    public void setRoll(float roll) {
        if (this.roll != roll) {
            this.roll = roll;
            notifyPropertyChanged(BR.roll);
        }
    }

    public void setNormalizedSuspensionTravelFrontLeft(float normalizedSuspensionTravelFrontLeft) {
        if (this.normalizedSuspensionTravelFrontLeft != normalizedSuspensionTravelFrontLeft) {
            this.normalizedSuspensionTravelFrontLeft = normalizedSuspensionTravelFrontLeft;
            notifyPropertyChanged(BR.normalizedSuspensionTravelFrontLeft);
        }
    }

    public void setNormalizedSuspensionTravelFrontRight(float normalizedSuspensionTravelFrontRight) {
        if (this.normalizedSuspensionTravelFrontRight != normalizedSuspensionTravelFrontRight) {
            this.normalizedSuspensionTravelFrontRight = normalizedSuspensionTravelFrontRight;
            notifyPropertyChanged(BR.normalizedSuspensionTravelFrontRight);
        }
    }

    public void setNormalizedSuspensionTravelRearLeft(float normalizedSuspensionTravelRearLeft) {
        if (this.normalizedSuspensionTravelRearLeft != normalizedSuspensionTravelRearLeft) {
            this.normalizedSuspensionTravelRearLeft = normalizedSuspensionTravelRearLeft;
            notifyPropertyChanged(BR.normalizedSuspensionTravelRearLeft);
        }
    }

    public void setNormalizedSuspensionTravelRearRight(float normalizedSuspensionTravelRearRight) {
        if (this.normalizedSuspensionTravelRearRight != normalizedSuspensionTravelRearRight) {
            this.normalizedSuspensionTravelRearRight = normalizedSuspensionTravelRearRight;
            notifyPropertyChanged(BR.normalizedSuspensionTravelRearRight);
        }
    }

    public void setTireSlipRatioFrontLeft(float tireSlipRatioFrontLeft) {
        if (this.tireSlipRatioFrontLeft != tireSlipRatioFrontLeft) {
            this.tireSlipRatioFrontLeft = tireSlipRatioFrontLeft;
            notifyPropertyChanged(BR.tireSlipRatioFrontLeft);
        }
    }

    public void setTireSlipRatioFrontRight(float tireSlipRatioFrontRight) {
        if (this.tireSlipRatioFrontRight != tireSlipRatioFrontRight) {
            this.tireSlipRatioFrontRight = tireSlipRatioFrontRight;
            notifyPropertyChanged(BR.tireSlipRatioFrontRight);
        }
    }

    public void setTireSlipRatioRearLeft(float tireSlipRatioRearLeft) {
        if (this.tireSlipRatioRearLeft != tireSlipRatioRearLeft) {
            this.tireSlipRatioRearLeft = tireSlipRatioRearLeft;
            notifyPropertyChanged(BR.tireSlipRatioRearLeft);
        }
    }

    public void setTireSlipRatioRearRight(float tireSlipRatioRearRight) {
        if (this.tireSlipRatioRearRight != tireSlipRatioRearRight) {
            this.tireSlipRatioRearRight = tireSlipRatioRearRight;
            notifyPropertyChanged(BR.tireSlipRatioRearRight);
        }
    }

    public void setWheelRotationSpeedFrontLeft(float wheelRotationSpeedFrontLeft) {
        if (this.wheelRotationSpeedFrontLeft != wheelRotationSpeedFrontLeft) {
            this.wheelRotationSpeedFrontLeft = wheelRotationSpeedFrontLeft;
            notifyPropertyChanged(BR.wheelRotationSpeedFrontLeft);
        }
    }

    public void setWheelRotationSpeedFrontRight(float wheelRotationSpeedFrontRight) {
        if (this.wheelRotationSpeedFrontRight != wheelRotationSpeedFrontRight) {
            this.wheelRotationSpeedFrontRight = wheelRotationSpeedFrontRight;
            notifyPropertyChanged(BR.wheelRotationSpeedFrontRight);
        }
    }

    public void setWheelRotationSpeedRearLeft(float wheelRotationSpeedRearLeft) {
        if (this.wheelRotationSpeedRearLeft != wheelRotationSpeedRearLeft) {
            this.wheelRotationSpeedRearLeft = wheelRotationSpeedRearLeft;
            notifyPropertyChanged(BR.wheelRotationSpeedRearLeft);
        }
    }

    public void setWheelRotationSpeedRearRight(float wheelRotationSpeedRearRight) {
        if (this.wheelRotationSpeedRearRight != wheelRotationSpeedRearRight) {
            this.wheelRotationSpeedRearRight = wheelRotationSpeedRearRight;
            notifyPropertyChanged(BR.wheelRotationSpeedRearRight);
        }
    }

    public void setWheelOnRumbleStripFrontLeft(int wheelOnRumbleStripFrontLeft) {
        if (this.wheelOnRumbleStripFrontLeft != wheelOnRumbleStripFrontLeft) {
            this.wheelOnRumbleStripFrontLeft = wheelOnRumbleStripFrontLeft;
            notifyPropertyChanged(BR.wheelOnRumbleStripFrontLeft);
        }
    }

    public void setWheelOnRumbleStripFrontRight(int wheelOnRumbleStripFrontRight) {
        if (this.wheelOnRumbleStripFrontRight != wheelOnRumbleStripFrontRight) {
            this.wheelOnRumbleStripFrontRight = wheelOnRumbleStripFrontRight;
            notifyPropertyChanged(BR.wheelOnRumbleStripFrontRight);
        }
    }

    public void setWheelOnRumbleStripRearLeft(int wheelOnRumbleStripRearLeft) {
        if (this.wheelOnRumbleStripRearLeft != wheelOnRumbleStripRearLeft) {
            this.wheelOnRumbleStripRearLeft = wheelOnRumbleStripRearLeft;
            notifyPropertyChanged(BR.wheelOnRumbleStripRearLeft);
        }
    }

    public void setWheelOnRumbleStripRearRight(int wheelOnRumbleStripRearRight) {
        if (this.wheelOnRumbleStripRearRight != wheelOnRumbleStripRearRight) {
            this.wheelOnRumbleStripRearRight = wheelOnRumbleStripRearRight;
            notifyPropertyChanged(BR.wheelOnRumbleStripRearRight);
        }
    }

    public void setWheelInPuddleDepthFrontLeft(float wheelInPuddleDepthFrontLeft) {
        if (this.wheelInPuddleDepthFrontLeft != wheelInPuddleDepthFrontLeft) {
            this.wheelInPuddleDepthFrontLeft = wheelInPuddleDepthFrontLeft;
            notifyPropertyChanged(BR.wheelInPuddleDepthFrontLeft);
        }
    }

    public void setWheelInPuddleDepthFrontRight(float wheelInPuddleDepthFrontRight) {
        if (this.wheelInPuddleDepthFrontRight != wheelInPuddleDepthFrontRight) {
            this.wheelInPuddleDepthFrontRight = wheelInPuddleDepthFrontRight;
            notifyPropertyChanged(BR.wheelInPuddleDepthFrontRight);
        }
    }

    public void setWheelInPuddleDepthRearLeft(float wheelInPuddleDepthRearLeft) {
        if (this.wheelInPuddleDepthRearLeft != wheelInPuddleDepthRearLeft) {
            this.wheelInPuddleDepthRearLeft = wheelInPuddleDepthRearLeft;
            notifyPropertyChanged(BR.wheelInPuddleDepthRearLeft);
        }
    }

    public void setWheelInPuddleDepthRearRight(float wheelInPuddleDepthRearRight) {
        if (this.wheelInPuddleDepthRearRight != wheelInPuddleDepthRearRight) {
            this.wheelInPuddleDepthRearRight = wheelInPuddleDepthRearRight;
            notifyPropertyChanged(BR.wheelInPuddleDepthRearRight);
        }
    }

    public void setSurfaceRumbleFrontLeft(float surfaceRumbleFrontLeft) {
        if (this.surfaceRumbleFrontLeft != surfaceRumbleFrontLeft) {
            this.surfaceRumbleFrontLeft = surfaceRumbleFrontLeft;
            notifyPropertyChanged(BR.surfaceRumbleFrontLeft);
        }
    }

    public void setSurfaceRumbleFrontRight(float surfaceRumbleFrontRight) {
        if (this.surfaceRumbleFrontRight != surfaceRumbleFrontRight) {
            this.surfaceRumbleFrontRight = surfaceRumbleFrontRight;
            notifyPropertyChanged(BR.surfaceRumbleFrontRight);
        }
    }

    public void setSurfaceRumbleRearLeft(float surfaceRumbleRearLeft) {
        if (this.surfaceRumbleRearLeft != surfaceRumbleRearLeft) {
            this.surfaceRumbleRearLeft = surfaceRumbleRearLeft;
            notifyPropertyChanged(BR.surfaceRumbleRearLeft);
        }
    }

    public void setSurfaceRumbleRearRight(float surfaceRumbleRearRight) {
        if (this.surfaceRumbleRearRight != surfaceRumbleRearRight) {
            this.surfaceRumbleRearRight = surfaceRumbleRearRight;
            notifyPropertyChanged(BR.surfaceRumbleRearRight);
        }
    }

    public void setTireSlipAngleFrontLeft(float tireSlipAngleFrontLeft) {
        if (this.tireSlipAngleFrontLeft != tireSlipAngleFrontLeft) {
            this.tireSlipAngleFrontLeft = tireSlipAngleFrontLeft;
            notifyPropertyChanged(BR.tireSlipAngleFrontLeft);
        }
    }

    public void setTireSlipAngleFrontRight(float tireSlipAngleFrontRight) {
        if (this.tireSlipAngleFrontRight != tireSlipAngleFrontRight) {
            this.tireSlipAngleFrontRight = tireSlipAngleFrontRight;
            notifyPropertyChanged(BR.tireSlipAngleFrontRight);
        }
    }

    public void setTireSlipAngleRearLeft(float tireSlipAngleRearLeft) {
        if (this.tireSlipAngleRearLeft != tireSlipAngleRearLeft) {
            this.tireSlipAngleRearLeft = tireSlipAngleRearLeft;
            notifyPropertyChanged(BR.tireSlipAngleRearLeft);
        }
    }

    public void setTireSlipAngleRearRight(float tireSlipAngleRearRight) {
        if (this.tireSlipAngleRearRight != tireSlipAngleRearRight) {
            this.tireSlipAngleRearRight = tireSlipAngleRearRight;
            notifyPropertyChanged(BR.tireSlipAngleRearRight);
        }
    }

    public void setTireCombinedSlipFrontLeft(float tireCombinedSlipFrontLeft) {
        if (this.tireCombinedSlipFrontLeft != tireCombinedSlipFrontLeft) {
            this.tireCombinedSlipFrontLeft = tireCombinedSlipFrontLeft;
            notifyPropertyChanged(BR.tireCombinedSlipFrontLeft);
        }
    }

    public void setTireCombinedSlipFrontRight(float tireCombinedSlipFrontRight) {
        if (this.tireCombinedSlipFrontRight != tireCombinedSlipFrontRight) {
            this.tireCombinedSlipFrontRight = tireCombinedSlipFrontRight;
            notifyPropertyChanged(BR.tireCombinedSlipFrontRight);
        }
    }

    public void setTireCombinedSlipRearLeft(float tireCombinedSlipRearLeft) {
        if (this.tireCombinedSlipRearLeft != tireCombinedSlipRearLeft) {
            this.tireCombinedSlipRearLeft = tireCombinedSlipRearLeft;
            notifyPropertyChanged(BR.tireCombinedSlipRearLeft);
        }
    }

    public void setTireCombinedSlipRearRight(float tireCombinedSlipRearRight) {
        if (this.tireCombinedSlipRearRight != tireCombinedSlipRearRight) {
            this.tireCombinedSlipRearRight = tireCombinedSlipRearRight;
            notifyPropertyChanged(BR.tireCombinedSlipRearRight);
        }
    }

    public void setSuspensionTravelMetersFrontLeft(float suspensionTravelMetersFrontLeft) {
        if (this.suspensionTravelMetersFrontLeft != suspensionTravelMetersFrontLeft) {
            this.suspensionTravelMetersFrontLeft = suspensionTravelMetersFrontLeft;
            notifyPropertyChanged(BR.suspensionTravelMetersFrontLeft);
        }
    }

    public void setSuspensionTravelMetersFrontRight(float suspensionTravelMetersFrontRight) {
        if (this.suspensionTravelMetersFrontRight != suspensionTravelMetersFrontRight) {
            this.suspensionTravelMetersFrontRight = suspensionTravelMetersFrontRight;
            notifyPropertyChanged(BR.suspensionTravelMetersFrontRight);
        }
    }

    public void setSuspensionTravelMetersRearLeft(float suspensionTravelMetersRearLeft) {
        if (this.suspensionTravelMetersRearLeft != suspensionTravelMetersRearLeft) {
            this.suspensionTravelMetersRearLeft = suspensionTravelMetersRearLeft;
            notifyPropertyChanged(BR.suspensionTravelMetersRearLeft);
        }
    }

    public void setSuspensionTravelMetersRearRight(float suspensionTravelMetersRearRight) {
        if (this.suspensionTravelMetersRearRight != suspensionTravelMetersRearRight) {
            this.suspensionTravelMetersRearRight = suspensionTravelMetersRearRight;
            notifyPropertyChanged(BR.suspensionTravelMetersRearRight);
        }
    }

    public void setCarOrdinal(int carOrdinal) {
        if (this.carOrdinal != carOrdinal) {
            this.carOrdinal = carOrdinal;
            notifyPropertyChanged(BR.carOrdinal);
        }
    }

    public void setCarClass(int carClass) {
        if (this.carClass != carClass) {
            this.carClass = carClass;
            notifyPropertyChanged(BR.carClass);
        }
    }

    public void setCarPerformanceIndex(int carPerformanceIndex) {
        if (this.carPerformanceIndex != carPerformanceIndex) {
            this.carPerformanceIndex = carPerformanceIndex;
            notifyPropertyChanged(BR.carPerformanceIndex);
        }
    }

    public void setDrivetrainType(int drivetrainType) {
        if (this.drivetrainType != drivetrainType) {
            this.drivetrainType = drivetrainType;
            notifyPropertyChanged(BR.drivetrainType);
        }
    }

    public void setNumCylinders(int numCylinders) {
        if (this.numCylinders != numCylinders) {
            this.numCylinders = numCylinders;
            notifyPropertyChanged(BR.numCylinders);
        }
    }

    public void setPositionX(float positionX) {
        if (this.positionX != positionX) {
            this.positionX = positionX;
            notifyPropertyChanged(BR.positionX);
        }
    }

    public void setPositionY(float positionY) {
        if (this.positionY != positionY) {
            this.positionY = positionY;
            notifyPropertyChanged(BR.positionY);
        }
    }

    public void setPositionZ(float positionZ) {
        if (this.positionZ != positionZ) {
            this.positionZ = positionZ;
            notifyPropertyChanged(BR.positionZ);
        }
    }

    public void setSpeed(float speed) {
        if (this.speed != speed) {
            this.speed = speed;
            notifyPropertyChanged(BR.speed);
        }
    }

    public void setPower(float power) {
        if (this.power != power) {
            this.power = power;
            notifyPropertyChanged(BR.power);
        }
    }

    public void setTorque(float torque) {
        if (this.torque != torque) {
            this.torque = torque;
            notifyPropertyChanged(BR.torque);
        }
    }

    public void setTireTempFrontLeft(float tireTempFrontLeft) {
        if (this.tireTempFrontLeft != tireTempFrontLeft) {
            this.tireTempFrontLeft = tireTempFrontLeft;
            notifyPropertyChanged(BR.tireTempFrontLeftFahrenheit);
            notifyPropertyChanged(BR.tireTempFrontLeftCelsius);
        }
    }

    public void setTireTempFrontRight(float tireTempFrontRight) {
        if (this.tireTempFrontRight != tireTempFrontRight) {
            this.tireTempFrontRight = tireTempFrontRight;
            notifyPropertyChanged(BR.tireTempFrontRightFahrenheit);
            notifyPropertyChanged(BR.tireTempFrontRightCelsius);
        }
    }

    public void setTireTempRearLeft(float tireTempRearLeft) {
        if (this.tireTempRearLeft != tireTempRearLeft) {
            this.tireTempRearLeft = tireTempRearLeft;
            notifyPropertyChanged(BR.tireTempRearLeftFahrenheit);
            notifyPropertyChanged(BR.tireTempRearLeftCelsius);
        }
    }

    public void setTireTempRearRight(float tireTempRearRight) {
        if (this.tireTempRearRight != tireTempRearRight) {
            this.tireTempRearRight = tireTempRearRight;
            notifyPropertyChanged(BR.tireTempRearRightFahrenheit);
            notifyPropertyChanged(BR.tireTempRearRightCelsius);
        }
    }

    public void setBoost(float boost) {
        if (this.boost != boost) {
            this.boost = boost;
            notifyPropertyChanged(BR.boostPsi);
            notifyPropertyChanged(BR.boostBar);
        }
    }

    public void setFuel(float fuel) {
        if (this.fuel != fuel) {
            this.fuel = fuel;
            notifyPropertyChanged(BR.fuel);
        }
    }

    public void setDistanceTraveled(float distanceTraveled) {
        if (this.distanceTraveled != distanceTraveled) {
            this.distanceTraveled = distanceTraveled;
            notifyPropertyChanged(BR.distanceTraveledTotal);
            notifyPropertyChanged(BR.distanceTraveledLap);
        }
    }

    public void setBestLap(float bestLap) {
        if (this.bestLap != bestLap) {
            this.bestLap = bestLap;
            notifyPropertyChanged(BR.bestLap);
        }
    }

    public void setLastLap(float lastLap) {
        if (this.lastLap != lastLap) {
            this.lastLap = lastLap;
            notifyPropertyChanged(BR.lastLap);
        }
    }

    public void setCurrentLap(float currentLap) {
        if (this.currentLap != currentLap) {
            this.currentLap = currentLap;
            notifyPropertyChanged(BR.currentLap);
        }
    }

    public void setCurrentRaceTime(float currentRaceTime) {
        if (this.currentRaceTime != currentRaceTime) {
            this.currentRaceTime = currentRaceTime;
            notifyPropertyChanged(BR.currentRaceTime);
        }
    }

    public void setLapNumber(short lapNumber) {
        if (this.lapNumber != lapNumber) {
            this.lapNumber = lapNumber;
            notifyPropertyChanged(BR.lapNumber);
        }
    }

    public void setRacePosition(byte racePosition) {
        if (this.racePosition != racePosition) {
            this.racePosition = racePosition;
            notifyPropertyChanged(BR.racePosition);
        }
    }

    public void setAccel(byte accel) {
        if (this.accel != accel) {
            this.accel = accel;
            notifyPropertyChanged(BR.accel);
        }
    }

    public void setBrake(byte brake) {
        if (this.brake != brake) {
            this.brake = brake;
            notifyPropertyChanged(BR.brake);
        }
    }

    public void setClutch(byte clutch) {
        if (this.clutch != clutch) {
            this.clutch = clutch;
            notifyPropertyChanged(BR.clutch);
        }
    }

    public void setHandBrake(byte handBrake) {
        if (this.handBrake != handBrake) {
            this.handBrake = handBrake;
            notifyPropertyChanged(BR.handBrake);
        }
    }

    public void setGear(byte gear) {
        if (this.gear != gear) {
            this.gear = gear;
            notifyPropertyChanged(BR.gear);
        }
    }

    public void setSteer(byte steer) {
        if (this.steer != steer) {
            this.steer = steer;
            notifyPropertyChanged(BR.gear);
        }
    }

    public void setNormalizedDrivingLine(byte normalizedDrivingLine) {
        if (this.normalizedDrivingLine != normalizedDrivingLine) {
            this.normalizedDrivingLine = normalizedDrivingLine;
            notifyPropertyChanged(BR.normalizedDrivingLine);
        }
    }

    public void setNormalizedAIBrakeDifference(byte normalizedAIBrakeDifference) {
        if (this.normalizedAIBrakeDifference != normalizedAIBrakeDifference) {
            this.normalizedAIBrakeDifference = normalizedAIBrakeDifference;
            notifyPropertyChanged(BR.normalizedAIBrakeDifference);
        }
    }
    // endregion Setter

    // region Utility methods
    //
    private float convertFahrenheitToCelsius(float temperature) {
        return (temperature - 32f) / 1.8f;
    }

    private float convertPsiToBar(float pressure) {
        return pressure * 0.06894757f;
    }
    // endregion Utility methods
}
