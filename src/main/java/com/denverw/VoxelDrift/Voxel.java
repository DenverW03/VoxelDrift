package com.denverw.VoxelDrift;
import org.joml.Vector3i;

public class Voxel {
    private float red, green, blue, alpha;
    private int x, y, z;
    private Vector3i[] vertices;

    public Voxel(float red, float green, float blue, float alpha, int x, int y, int z) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        this.x = x;
        this.y = y;
        this.z = z;
        calculateVertices();
        for(int i=0; i<8; i++){
            System.out.println(vertices[i]);
        }
    }

    public Vector3i[] getVertices() {
        return vertices;
    }

    /**
     * Calculates the vertices of the voxel and stores it in a Vector3i array
     */
    public void calculateVertices() {
        vertices = new Vector3i[8];
        vertices[0] = new Vector3i(x, y, z);
        vertices[1] = new Vector3i(increaseMagnitudeByOne(x), y, z);
        vertices[2] = new Vector3i(x, increaseMagnitudeByOne(y), z);
        vertices[3] = new Vector3i(increaseMagnitudeByOne(x), increaseMagnitudeByOne(y), z);
        vertices[4] = new Vector3i(x, y, increaseMagnitudeByOne(z));
        vertices[5] = new Vector3i(increaseMagnitudeByOne(x), y, increaseMagnitudeByOne(z));
        vertices[6] = new Vector3i(x, increaseMagnitudeByOne(y), increaseMagnitudeByOne(z));
        vertices[7] = new Vector3i(increaseMagnitudeByOne(x), increaseMagnitudeByOne(y), increaseMagnitudeByOne(z));
    }

    /**
     * Returns the number passed to it with the magnitude increase by a value of one
     * @param num the number to apply the function to
     * @return
     */
    public int increaseMagnitudeByOne(int num) { // not necessary, can be removed and calculations refactored
        if(num >= 0) {
            return num + 1;
        }
        else {
            return num - 1;
        }
    }

    public float getRed() {
        return red;
    }
    public float getGreen() {
        return green;
    }
    public float getBlue() {
        return blue;
    }
    public float getAlpha() {
        return alpha;
    }
}
