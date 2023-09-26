package com.denverw.VoxelDrift;
import org.joml.Matrix4f;
import org.joml.Math;

public class Camera {
    private Matrix4f projectionMatrix;
    private int width, height;

    public Camera(int width, int height) {
        // Set up perspective projection matrix
        this.height = height;
        this.width = width;
		float fov = (float) Math.toRadians(45.0);
		float aspectRatio = (float) width / height; // Set this to your window's aspect ratio
		float zNear = 0.1f;
		float zFar = 100.0f;
        projectionMatrix = new Matrix4f().setPerspective(fov, aspectRatio, zNear, zFar);
    }

    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }
}
