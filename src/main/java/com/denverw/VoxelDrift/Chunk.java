package com.denverw.VoxelDrift;

public class Chunk {
    private Voxel[][][] voxels;

    /**
     * Constructor creates a voxel 32x32x32 matrix
     */
    public Chunk() {
        voxels = new Voxel[32][32][32];
    }

    /**
     * Create a new voxel at the given location
     * @param r red balance
     * @param g green balance
     * @param b blue balance
     * @param a alpha level
     * @param x x plane
     * @param y y plane
     * @param z z plane
     */
    public void createVoxel(float r, float g, float b, float a, int x, int y, int z) {
        voxels[x][y][z] = new Voxel(r, g, b, a);
    }
}
