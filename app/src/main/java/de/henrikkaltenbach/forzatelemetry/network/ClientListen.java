package de.henrikkaltenbach.forzatelemetry.network;

import de.henrikkaltenbach.forzatelemetry.telemetry.TelemetryViewModel;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Enumeration;

public class ClientListen implements Runnable {

    private final TelemetryViewModel model;
    private final int port;

    public ClientListen(TelemetryViewModel model, int port) {
        this.model = model;
        this.port = port;
    }

    public ClientListen(TelemetryViewModel model) {
        this(model, 8080);
    }

    @Override
    public void run() {
        boolean run = true;
        try {
            DatagramSocket udpSocket = new DatagramSocket(port);
            byte[] buffer = new byte[320];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (run) {
                try {
                    udpSocket.receive(packet);
                    parseData(packet.getData());
                    packet.setLength(buffer.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    run = false;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private void parseData(byte[] data) {
        // Forza data out
        //
        model.setIsRaceOn(getBytes(data, 0, 4).getInt());
        model.setTimestampMS(getBytes(data, 4, 8).getInt());

        model.setEngineMaxRpm(getBytes(data, 8, 12).getFloat());
        model.setEngineIdleRpm(getBytes(data, 12, 16).getFloat());
        model.setCurrentEngineRpm(getBytes(data, 16, 20).getFloat());

        model.setAccelerationX(getBytes(data, 20, 24).getFloat());
        model.setAccelerationY(getBytes(data, 24, 28).getFloat());
        model.setAccelerationZ(getBytes(data, 28, 32).getFloat());

        model.setVelocityX(getBytes(data, 32, 36).getFloat());
        model.setVelocityY(getBytes(data, 36, 40).getFloat());
        model.setVelocityZ(getBytes(data, 40, 44).getFloat());

        model.setAngularVelocityX(getBytes(data, 44, 48).getFloat());
        model.setAngularVelocityY(getBytes(data, 48, 52).getFloat());
        model.setAngularVelocityZ(getBytes(data, 52, 56).getFloat());

        model.setYaw(getBytes(data, 56, 60).getFloat());
        model.setPitch(getBytes(data, 60, 64).getFloat());
        model.setRoll(getBytes(data, 64, 68).getFloat());

        model.setNormalizedSuspensionTravelFrontLeft(getBytes(data, 68, 72).getFloat());
        model.setNormalizedSuspensionTravelFrontRight(getBytes(data, 72, 76).getFloat());
        model.setNormalizedSuspensionTravelRearLeft(getBytes(data, 76, 80).getFloat());
        model.setNormalizedSuspensionTravelRearRight(getBytes(data, 80, 84).getFloat());

        model.setTireSlipRatioFrontLeft(getBytes(data, 84, 88).getFloat());
        model.setTireSlipRatioFrontRight(getBytes(data, 88, 92).getFloat());
        model.setTireSlipRatioRearLeft(getBytes(data, 92, 96).getFloat());
        model.setTireSlipRatioRearRight(getBytes(data, 96, 100).getFloat());

        model.setWheelRotationSpeedFrontLeft(getBytes(data, 100, 104).getFloat());
        model.setWheelRotationSpeedFrontRight(getBytes(data, 104, 108).getFloat());
        model.setWheelRotationSpeedRearLeft(getBytes(data, 108, 112).getFloat());
        model.setWheelRotationSpeedRearRight(getBytes(data, 112, 116).getFloat());

        model.setWheelOnRumbleStripFrontLeft(getBytes(data, 116, 120).getInt());
        model.setWheelOnRumbleStripFrontRight(getBytes(data, 120, 124).getInt());
        model.setWheelOnRumbleStripRearLeft(getBytes(data, 124, 128).getInt());
        model.setWheelOnRumbleStripRearRight(getBytes(data, 128, 132).getInt());

        model.setWheelInPuddleDepthFrontLeft(getBytes(data, 132, 136).getFloat());
        model.setWheelInPuddleDepthFrontRight(getBytes(data, 136, 140).getFloat());
        model.setWheelInPuddleDepthRearLeft(getBytes(data, 140, 144).getFloat());
        model.setWheelInPuddleDepthRearRight(getBytes(data, 144, 148).getFloat());

        model.setSurfaceRumbleFrontLeft(getBytes(data, 148, 152).getFloat());
        model.setSurfaceRumbleFrontRight(getBytes(data, 152, 156).getFloat());
        model.setSurfaceRumbleRearLeft(getBytes(data, 156, 160).getFloat());
        model.setSurfaceRumbleRearRight(getBytes(data, 160, 164).getFloat());

        model.setTireSlipAngleFrontLeft(getBytes(data, 164, 168).getFloat());
        model.setTireSlipAngleFrontRight(getBytes(data, 168, 172).getFloat());
        model.setTireSlipAngleRearLeft(getBytes(data, 172, 176).getFloat());
        model.setTireSlipAngleRearRight(getBytes(data, 176, 180).getFloat());

        model.setTireCombinedSlipFrontLeft(getBytes(data, 180, 184).getFloat());
        model.setTireCombinedSlipFrontRight(getBytes(data, 184, 188).getFloat());
        model.setTireCombinedSlipRearLeft(getBytes(data, 188, 192).getFloat());
        model.setTireCombinedSlipRearRight(getBytes(data, 192, 196).getFloat());

        model.setSuspensionTravelMetersFrontLeft(getBytes(data, 196, 200).getFloat());
        model.setSuspensionTravelMetersFrontRight(getBytes(data, 200, 204).getFloat());
        model.setSuspensionTravelMetersRearLeft(getBytes(data, 204, 208).getFloat());
        model.setSuspensionTravelMetersRearRight(getBytes(data, 208, 212).getFloat());

        model.setCarOrdinal(getBytes(data, 212, 216).getInt());
        model.setCarClass(getBytes(data, 216, 220).getInt());
        model.setCarPerformanceIndex(getBytes(data, 220, 224).getInt());
        model.setDrivetrainType(getBytes(data, 224, 228).getInt());
        model.setNumCylinders(getBytes(data, 228, 232).getInt());

        model.setPositionX(getBytes(data, 232, 236).getFloat());
        model.setPositionY(getBytes(data, 236, 240).getFloat());
        model.setPositionZ(getBytes(data, 240, 244).getFloat());

        model.setSpeed(getBytes(data, 244, 248).getFloat());
        model.setPower(getBytes(data, 248, 252).getFloat());
        model.setTorque(getBytes(data, 252, 256).getFloat());

        model.setTireTempFrontLeft(getBytes(data, 256, 260).getFloat());
        model.setTireTempFrontRight(getBytes(data, 260, 264).getFloat());
        model.setTireTempRearLeft(getBytes(data, 264, 268).getFloat());
        model.setTireTempRearRight(getBytes(data, 268, 272).getFloat());

        model.setBoost(getBytes(data, 272, 276).getFloat());
        model.setFuel(getBytes(data, 276, 280).getFloat());
        model.setDistanceTraveled(getBytes(data, 280, 284).getFloat());
        model.setBestLap(getBytes(data, 284, 288).getFloat());
        model.setLastLap(getBytes(data, 288, 292).getFloat());
        model.setCurrentLap(getBytes(data, 292, 296).getFloat());
        model.setCurrentRaceTime(getBytes(data, 296, 300).getFloat());

        model.setLapNumber(getBytes(data, 300, 302).getShort());
        model.setRacePosition(getBytes(data, 302, 303).get());

        model.setAccel((byte) (getBytes(data, 303, 304).get() & 0xFF));
        model.setBrake((byte) (getBytes(data, 304, 305).get() & 0xFF));
        model.setClutch((byte) (getBytes(data, 305, 306).get() & 0xFF));
        model.setHandBrake((byte) (getBytes(data, 306, 307).get() & 0xFF));
        model.setGear((byte) (getBytes(data, 307, 308).get() & 0xFF));
        model.setSteer(getBytes(data, 308, 309).get());

        model.setNormalizedDrivingLine(getBytes(data, 309, 310).get());
        model.setNormalizedAIBrakeDifference(getBytes(data, 310, 311).get());

        // Calculated
        //
        model.calcVelocity();
        model.calcAngularVelocity();
        model.calcTireTempFront();
        model.calcTireTempRear();
        model.calcTireTempLeft();
        model.calcTireTempRight();
    }

    private ByteBuffer getBytes(byte[] array, int offset, int length) {
        return ByteBuffer.wrap(Arrays.copyOfRange(array, offset, length)).order(ByteOrder.LITTLE_ENDIAN);
    }

    private String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> eNI = NetworkInterface.getNetworkInterfaces(); eNI.hasMoreElements();) {
                NetworkInterface ni = eNI.nextElement();
                if (ni.getName().equals("wlan0")) {
                    for (Enumeration<InetAddress> eIA = ni.getInetAddresses(); eIA.hasMoreElements();) {
                        InetAddress ia = eIA.nextElement();
                        if (ia.toString().contains("192.168.")) {
                            return ia.toString().substring(1);
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }
}
