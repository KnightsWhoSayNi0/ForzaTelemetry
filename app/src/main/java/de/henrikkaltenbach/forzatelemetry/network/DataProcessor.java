package de.henrikkaltenbach.forzatelemetry.network;

import de.henrikkaltenbach.forzatelemetry.viewmodels.CalculatedViewModel;
import de.henrikkaltenbach.forzatelemetry.viewmodels.TelemetryViewModel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class DataProcessor {

    private final TelemetryViewModel telemetry;
    private final CalculatedViewModel calculated;

    protected DataProcessor() {
        telemetry = TelemetryViewModel.getInstance();
        calculated = CalculatedViewModel.getInstance();
    }

    protected void parseData(byte[] data, int counter) {
        telemetry.setIsRaceOn(getBytes(data, 0, 4).getInt());
        telemetry.setTimestampMS(getBytes(data, 4, 8).getInt());
        if (telemetry.getIsRaceOn() == 1 && counter % 2 == 0) {
            // region Forza data out
            //
            telemetry.setEngineMaxRpm(getBytes(data, 8, 12).getFloat());
            telemetry.setEngineIdleRpm(getBytes(data, 12, 16).getFloat());
            telemetry.setCurrentEngineRpm(getBytes(data, 16, 20).getFloat());

            telemetry.setAccelerationX(getBytes(data, 20, 24).getFloat());
            telemetry.setAccelerationY(getBytes(data, 24, 28).getFloat());
            telemetry.setAccelerationZ(getBytes(data, 28, 32).getFloat());

            telemetry.setVelocityX(getBytes(data, 32, 36).getFloat());
            telemetry.setVelocityY(getBytes(data, 36, 40).getFloat());
            telemetry.setVelocityZ(getBytes(data, 40, 44).getFloat());

            telemetry.setAngularVelocityX(getBytes(data, 44, 48).getFloat());
            telemetry.setAngularVelocityY(getBytes(data, 48, 52).getFloat());
            telemetry.setAngularVelocityZ(getBytes(data, 52, 56).getFloat());

            telemetry.setYaw(getBytes(data, 56, 60).getFloat());
            telemetry.setPitch(getBytes(data, 60, 64).getFloat());
            telemetry.setRoll(getBytes(data, 64, 68).getFloat());

            telemetry.setNormalizedSuspensionTravelFrontLeft(getBytes(data, 68, 72).getFloat());
            telemetry.setNormalizedSuspensionTravelFrontRight(getBytes(data, 72, 76).getFloat());
            telemetry.setNormalizedSuspensionTravelRearLeft(getBytes(data, 76, 80).getFloat());
            telemetry.setNormalizedSuspensionTravelRearRight(getBytes(data, 80, 84).getFloat());

            telemetry.setTireSlipRatioFrontLeft(getBytes(data, 84, 88).getFloat());
            telemetry.setTireSlipRatioFrontRight(getBytes(data, 88, 92).getFloat());
            telemetry.setTireSlipRatioRearLeft(getBytes(data, 92, 96).getFloat());
            telemetry.setTireSlipRatioRearRight(getBytes(data, 96, 100).getFloat());

            telemetry.setWheelRotationSpeedFrontLeft(getBytes(data, 100, 104).getFloat());
            telemetry.setWheelRotationSpeedFrontRight(getBytes(data, 104, 108).getFloat());
            telemetry.setWheelRotationSpeedRearLeft(getBytes(data, 108, 112).getFloat());
            telemetry.setWheelRotationSpeedRearRight(getBytes(data, 112, 116).getFloat());

            telemetry.setWheelOnRumbleStripFrontLeft(getBytes(data, 116, 120).getInt());
            telemetry.setWheelOnRumbleStripFrontRight(getBytes(data, 120, 124).getInt());
            telemetry.setWheelOnRumbleStripRearLeft(getBytes(data, 124, 128).getInt());
            telemetry.setWheelOnRumbleStripRearRight(getBytes(data, 128, 132).getInt());

            telemetry.setWheelInPuddleDepthFrontLeft(getBytes(data, 132, 136).getFloat());
            telemetry.setWheelInPuddleDepthFrontRight(getBytes(data, 136, 140).getFloat());
            telemetry.setWheelInPuddleDepthRearLeft(getBytes(data, 140, 144).getFloat());
            telemetry.setWheelInPuddleDepthRearRight(getBytes(data, 144, 148).getFloat());

            telemetry.setSurfaceRumbleFrontLeft(getBytes(data, 148, 152).getFloat());
            telemetry.setSurfaceRumbleFrontRight(getBytes(data, 152, 156).getFloat());
            telemetry.setSurfaceRumbleRearLeft(getBytes(data, 156, 160).getFloat());
            telemetry.setSurfaceRumbleRearRight(getBytes(data, 160, 164).getFloat());

            telemetry.setTireSlipAngleFrontLeft(getBytes(data, 164, 168).getFloat());
            telemetry.setTireSlipAngleFrontRight(getBytes(data, 168, 172).getFloat());
            telemetry.setTireSlipAngleRearLeft(getBytes(data, 172, 176).getFloat());
            telemetry.setTireSlipAngleRearRight(getBytes(data, 176, 180).getFloat());

            telemetry.setTireCombinedSlipFrontLeft(getBytes(data, 180, 184).getFloat());
            telemetry.setTireCombinedSlipFrontRight(getBytes(data, 184, 188).getFloat());
            telemetry.setTireCombinedSlipRearLeft(getBytes(data, 188, 192).getFloat());
            telemetry.setTireCombinedSlipRearRight(getBytes(data, 192, 196).getFloat());

            telemetry.setSuspensionTravelMetersFrontLeft(getBytes(data, 196, 200).getFloat());
            telemetry.setSuspensionTravelMetersFrontRight(getBytes(data, 200, 204).getFloat());
            telemetry.setSuspensionTravelMetersRearLeft(getBytes(data, 204, 208).getFloat());
            telemetry.setSuspensionTravelMetersRearRight(getBytes(data, 208, 212).getFloat());

            telemetry.setCarOrdinal(getBytes(data, 212, 216).getInt());
            telemetry.setCarClass(getBytes(data, 216, 220).getInt());
            telemetry.setCarPerformanceIndex(getBytes(data, 220, 224).getInt());
            telemetry.setDrivetrainType(getBytes(data, 224, 228).getInt());
            telemetry.setNumCylinders(getBytes(data, 228, 232).getInt());

            telemetry.setPositionX(getBytes(data, 232, 236).getFloat());
            telemetry.setPositionY(getBytes(data, 236, 240).getFloat());
            telemetry.setPositionZ(getBytes(data, 240, 244).getFloat());

            telemetry.setSpeed(getBytes(data, 244, 248).getFloat());
            telemetry.setPower(getBytes(data, 248, 252).getFloat());
            telemetry.setTorque(getBytes(data, 252, 256).getFloat());

            telemetry.setTireTempFrontLeft(getBytes(data, 256, 260).getFloat());
            telemetry.setTireTempFrontRight(getBytes(data, 260, 264).getFloat());
            telemetry.setTireTempRearLeft(getBytes(data, 264, 268).getFloat());
            telemetry.setTireTempRearRight(getBytes(data, 268, 272).getFloat());

            telemetry.setBoost(getBytes(data, 272, 276).getFloat());
            telemetry.setFuel(getBytes(data, 276, 280).getFloat());
            telemetry.setDistanceTraveled(getBytes(data, 280, 284).getFloat());
            telemetry.setBestLap(getBytes(data, 284, 288).getFloat());
            telemetry.setLastLap(getBytes(data, 288, 292).getFloat());
            telemetry.setCurrentLap(getBytes(data, 292, 296).getFloat());
            telemetry.setCurrentRaceTime(getBytes(data, 296, 300).getFloat());

            telemetry.setLapNumber(getBytes(data, 300, 302).getShort());
            telemetry.setRacePosition(getBytes(data, 302, 303).get());

            telemetry.setAccel((byte) (getBytes(data, 303, 304).get() & 0xFF));
            telemetry.setBrake((byte) (getBytes(data, 304, 305).get() & 0xFF));
            telemetry.setClutch((byte) (getBytes(data, 305, 306).get() & 0xFF));
            telemetry.setHandBrake((byte) (getBytes(data, 306, 307).get() & 0xFF));
            telemetry.setGear((byte) (getBytes(data, 307, 308).get() & 0xFF));
            telemetry.setSteer(getBytes(data, 308, 309).get());

            telemetry.setNormalizedDrivingLine(getBytes(data, 309, 310).get());
            telemetry.setNormalizedAIBrakeDifference(getBytes(data, 310, 311).get());
            // endregion Forza data out

            // region Calculated data
            //
            if (counter % 4 == 0) {
                calculated.calcVelocity();
                calculated.calcAngularVelocity();
                calculated.calcTireTempAverageFront();
                calculated.calcTireTempAverageRear();
                calculated.calcTireTempAverageLeft();
                calculated.calcTireTempAverageRight();
            }

            if (counter % 30 == 0) {
                calculated.calcSector();
            }
            // endregion Calculated data
        }
    }

    private ByteBuffer getBytes(byte[] array, int offset, int length) {
        return ByteBuffer.wrap(Arrays.copyOfRange(array, offset, length)).order(ByteOrder.LITTLE_ENDIAN);
    }
}
