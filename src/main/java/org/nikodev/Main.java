package org.nikodev;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private long window;

    static void main() {
        IO.println("Hello and welcome!");
        new Main().run();
    }

    void run() {
        init();
        loop();

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    void init() {
        GLFWErrorCallback.createPrint(System.err);

        if (!glfwInit()) {
            throw new IllegalStateException("Could not init GLFW.");
        }

        glfwDefaultWindowHints();

        window = glfwCreateWindow(800, 600, "Hello!", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create GLFW Window.");
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
    }

    void loop() {
        GL.createCapabilities();

        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glBegin(GL_TRIANGLES);

            glColor3f(1.0f, 0.0f, 0.0f);
            glVertex2f(0.0f, 1.0f);

            glColor3f(0.0f, 1.0f, 0.0f);
            glVertex2f(1.0f, -1.0f);

            glColor3f(0.0f, 0.0f, 1.0f);
            glVertex2f(-1.0f, -1.0f);

            glEnd();
            glFlush();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
}
