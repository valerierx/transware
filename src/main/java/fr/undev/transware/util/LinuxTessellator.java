package fr.undev.transware.util;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by 086 on 9/07/2017.
 */
public class LinuxTessellator extends Tessellator {

    public static LinuxTessellator INSTANCE = new LinuxTessellator();

    public LinuxTessellator() {
        super(0x200000);
    }

    public static void prepare(int mode) {
        prepareGL();
        begin(mode);
    }

    public static void prepareGL() {
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(1.5F);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color(1,1,1);
    }

    public static void begin(int mode) {
        INSTANCE.getBuffer().begin(mode, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void release() {
        render();
        releaseGL();
    }

    public static void render() {
        INSTANCE.draw();
    }

    public static void releaseGL() {
        GlStateManager.enableCull();
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public static void drawBox(BlockPos blockPos, int argb, int sides) {
        final int a = (argb >>> 24) & 0xFF;
        final int r = (argb >>> 16) & 0xFF;
        final int g = (argb >>> 8) & 0xFF;
        final int b = argb & 0xFF;
        drawBox(blockPos, r, g, b, a, sides);
    }

    public static void drawBox(float x, float y, float z, int argb, int sides) {
        final int a = (argb >>> 24) & 0xFF;
        final int r = (argb >>> 16) & 0xFF;
        final int g = (argb >>> 8) & 0xFF;
        final int b = argb & 0xFF;
        drawBox(INSTANCE.getBuffer(), x, y, z, 1, 1, 1, r, g, b, a, sides);
    }

    public static void drawBox(BlockPos blockPos, int r, int g, int b, int a, int sides) {
        drawBox(INSTANCE.getBuffer(), blockPos.x, blockPos.y, blockPos.z, 1, 1, 1, r, g, b, a, sides);
    }

    public static BufferBuilder getBufferBuilder() {
        return INSTANCE.getBuffer();
    }

    public static void drawBox(final BufferBuilder buffer, float x, float y, float z, float w, float h, float d, int r, int g, int b, int a, int sides) {
        if ((sides & GeometryMasks.Quad.DOWN) != 0) {
            buffer.pos(x+w, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x, y, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Quad.UP) != 0) {
            buffer.pos(x+w, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Quad.NORTH) != 0) {
            buffer.pos(x+w, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Quad.SOUTH) != 0) {
            buffer.pos(x, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Quad.WEST) != 0) {
            buffer.pos(x, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Quad.EAST) != 0) {
            buffer.pos(x+w, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z+d).color(r, g, b, a).endVertex();
        }
    }

    public static void drawLines(final BufferBuilder buffer, float x, float y, float z, float w, float h, float d, int r, int g, int b, int a, int sides) {
        if ((sides & GeometryMasks.Line.DOWN_WEST) != 0) {
            buffer.pos(x, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.UP_WEST) != 0) {
            buffer.pos(x, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.DOWN_EAST) != 0) {
            buffer.pos(x+w, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.UP_EAST) != 0) {
            buffer.pos(x+w, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.DOWN_NORTH) != 0) {
            buffer.pos(x, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.UP_NORTH) != 0) {
            buffer.pos(x, y+h, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.DOWN_SOUTH) != 0) {
            buffer.pos(x, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.UP_SOUTH) != 0) {
            buffer.pos(x, y+h, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.NORTH_WEST) != 0) {
            buffer.pos(x, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.NORTH_EAST) != 0) {
            buffer.pos(x+w, y, z).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.SOUTH_WEST) != 0) {
            buffer.pos(x, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x, y+h, z+d).color(r, g, b, a).endVertex();
        }

        if ((sides & GeometryMasks.Line.SOUTH_EAST) != 0) {
            buffer.pos(x+w, y, z+d).color(r, g, b, a).endVertex();
            buffer.pos(x+w, y+h, z+d).color(r, g, b, a).endVertex();
        }
    }

    public static final class GeometryMasks {

        public static final class Quad {

            public static final int DOWN = 0x01;
            public static final int UP = 0x02;
            public static final int NORTH = 0x04;
            public static final int SOUTH = 0x08;
            public static final int WEST = 0x10;
            public static final int EAST = 0x20;
            public static final int ALL = DOWN | UP | NORTH | SOUTH | WEST | EAST;
        }

        public static final class Line {

            public static final int DOWN_WEST = 0x11;
            public static final int UP_WEST = 0x12;
            public static final int DOWN_EAST = 0x21;
            public static final int UP_EAST = 0x22;
            public static final int DOWN_NORTH = 0x05;
            public static final int UP_NORTH = 0x06;
            public static final int DOWN_SOUTH = 0x09;
            public static final int UP_SOUTH = 0x0A;
            public static final int NORTH_WEST = 0x14;
            public static final int NORTH_EAST = 0x24;
            public static final int SOUTH_WEST = 0x18;
            public static final int SOUTH_EAST = 0x28;
            public static final int ALL =
                    DOWN_WEST
                            | UP_WEST
                            | DOWN_EAST
                            | UP_EAST
                            | DOWN_NORTH
                            | UP_NORTH
                            | DOWN_SOUTH
                            | UP_SOUTH
                            | NORTH_WEST
                            | NORTH_EAST
                            | SOUTH_WEST
                            | SOUTH_EAST;
        }
    }
}