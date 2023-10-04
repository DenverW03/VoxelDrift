package com.denverw.VoxelDrift;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Math;

public class Camera {
    private Matrix4f projectionMatrix;
    private Matrix4f viewMatrix;
    private Vector3f position;
    private float pitch;
    private float yaw;

    public Camera(int width, int height) {
        // Set up perspective projection matrix
		float fov = (float) Math.toRadians(45.0);
		float aspectRatio = (float) width / height; // Set this to your window's aspect ratio
		float zNear = 1.0f;
		float zFar = 100.0f;
        projectionMatrix = new Matrix4f().setPerspective(fov, aspectRatio, zNear, zFar);
        position = new Vector3f(0.0f, 0.0f, 0.0f);
        pitch = 0.0f;
        yaw = 0.0f;
        updateViewMatrix();
    }

    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }

    public Matrix4f getViewMatrix() {
        return viewMatrix;
    }

    public void move(float offsetX, float offsetY, float offsetZ) {
        // Update the camera position
        position.add(offsetX, offsetY, offsetZ);

        // Update the view matrix
        updateViewMatrix();
    }

    public void rotate(float pitchOffset, float yawOffset) {
        // Update the camera rotation
        pitch += pitchOffset;
        yaw += yawOffset;

        // Update the view matrix
        updateViewMatrix();
    }

    private void updateViewMatrix() {
        viewMatrix = new Matrix4f()
                .identity()
                .rotateX(pitch)
                .rotateY(yaw)
                .translate(-position.x, -position.y, -position.z);
    }
}
