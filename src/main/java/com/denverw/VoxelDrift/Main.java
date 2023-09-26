package com.denverw.VoxelDrift;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.joml.Matrix4f;
import org.joml.Vector3i;

public class Main {
    private long window;
	private int width;
	private int height;
	private Chunk world;
	private Camera camera;

    public void run() {
		// setting the window size
		width = 1280;
		height = 720;
        init();
        loop();
        cleanup();
    }

    private void init() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
        window = GLFW.glfwCreateWindow(width, height, "VoxelEngine", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (vidMode.width() - 800) / 2, (vidMode.height() - 600) / 2);
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		// creating the world (a single chunk for now)
		world = new Chunk();
		// creating a camera
		camera = new Camera(width, height);
		// creating a cube
		world.createVoxel(1.0f, 0.0f, 0.0f, 0.0f, 10, 5, -15);
    }

    private void loop() {
        while (!GLFW.glfwWindowShouldClose(window)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            // Draw a square
            /*GL11.glBegin(GL11.GL_QUADS);
            GL11.glColor3f(1.0f, 0.0f, 0.0f); // Red color
            GL11.glVertex2f(-0.5f, -0.5f);
            GL11.glVertex2f(0.5f, -0.5f);
            GL11.glVertex2f(0.5f, 0.5f);
            GL11.glVertex2f(-0.5f, 0.5f);
            GL11.glEnd();

			GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glColor3f(0.0f, 1.0f, 0.0f); // Red color

            // Triangle 1
            GL11.glVertex2f(-0.5f, -0.5f);
            GL11.glVertex2f(0.5f, -0.5f);
            GL11.glVertex2f(0.5f, 0.5f);

            GL11.glEnd();*/

			Matrix4f projectionMatrix = camera.getProjectionMatrix();
			// rendering a specific voxel
			Voxel voxel = world.getVoxel(10, 5, -15);
			Vector3i[] vertices = voxel.getVertices();


            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }

    private void cleanup() {
        GLFW.glfwTerminate();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
