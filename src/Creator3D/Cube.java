package Creator3D;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Cube
{
    public Cube()
    {
        int one = 0x10000;
        int vertices[] = {
                -one, -one, -one,
                one, -one, -one,
                one,  one, -one,
                -one,  one, -one,
                -one, -one,  one,
                one, -one,  one,
                one,  one,  one,
                -one,  one,  one,
        };

        int colors[] = {0xFF0000};

        byte indices[] = {
                0, 4, 5,    0, 5, 1,
                1, 5, 6,    1, 6, 2,
                2, 6, 7,    2, 7, 3,
                3, 7, 4,    3, 4, 0,
                4, 7, 6,    4, 6, 5,
                3, 0, 1,    3, 1, 2
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb.asIntBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer = cbb.asIntBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
    }

    public void draw(GL10 gl)
    {
        gl.glFrontFace(GL10.GL_CW);
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);
        gl.glColorPointer(4, GL10.GL_FIXED, 0, mColorBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE, mIndexBuffer);
    }

    private IntBuffer   mVertexBuffer;
    private IntBuffer   mColorBuffer;
    private ByteBuffer  mIndexBuffer;
}
//public class Cube {
//    private final IntBuffer mVertexBuffer;
//    private final IntBuffer mTextureBuffer;
//private IntBuffer   mVertexBuffer;
//private IntBuffer   mColorBuffer;
//private ByteBuffer  mIndexBuffer;
//    public Cube() {
//		int width = 65536/2;
//		int height = width / 3; 
//		int half = width ; //(en bas a gauche, en bas a droite, en haut a gauche, en haut a droite)
//		int vertices[] = { 
//				// FRONT
//				-width, -height, half, width, -height, half,
//				-width, height, half, width, height, half, 
//				// LEFT
//				-width, -height, -half, -width, -height, half,
//				-width, height, -half, -width, height, half,
//				// BACK
//				width, -height, -half, -width, -height, -half,
//				width, height, -half, -width, height, -half,
//				// RIGHT
//				width, -height, half, width, -height, -half,
//				width, height, half, width, height, -half,
//				// TOP
//				width, -height, half, half, half, half,
//				-half, half, -half, half, half, -half,
//				// BOTTOM
//				-width, -height, half, -width, -height, -half,
//				width, -height, half, width, -height, -half, 
//				};
//
//		int texCoords[] = {
//				// FRONT
//				0, width, width, width, 0, 0, width, 0,
//				// BACK
//				width, width, width, 0, 0, width, 0, 0,
//				// LEFT
//				width, width, width, 0, 0, width, 0, 0,
//				// RIGHT
//				width, width, width, 0, 0, width, 0, 0,
//				// TOP
//				width, 0, 0, 0, width, width, 0, width,
//				// BOTTOM
//				0, 0, 0, width, width, 0, width, width, };
//	
//		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
//		vbb.order(ByteOrder.nativeOrder());
//		mVertexBuffer = vbb.asIntBuffer();
//		mVertexBuffer.put(vertices);
//		mVertexBuffer.position(0);
//
//		// ...
//		ByteBuffer tbb = ByteBuffer.allocateDirect(texCoords.length * 4);
//		tbb.order(ByteOrder.nativeOrder());
//		mTextureBuffer = tbb.asIntBuffer();
//		mTextureBuffer.put(texCoords);
//		mTextureBuffer.position(0);
//
//	}
//
//    public void draw(GL10 gl) { 
//		gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);
//
//		gl.glEnable(GL10.GL_TEXTURE_2D); // workaround bug 3623
//		gl.glTexCoordPointer(2, GL10.GL_FIXED, 0, mTextureBuffer);
//
//		gl.glColor4f(1, 1, 1, 1);
//		gl.glNormal3f(0, 0, 1);
//		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
//		gl.glNormal3f(0, 0, -1);
//		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);
//
//		gl.glColor4f(1, 1, 1, 1);
//		gl.glNormal3f(-1, 0, 0);
//		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);
//		gl.glNormal3f(1, 0, 0);
//		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);
//
//		gl.glColor4f(1, 1, 1, 1);
//		gl.glNormal3f(0, 1, 0);
//		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);
//		gl.glNormal3f(0, -1, 0);
//		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);
//	}
//
//	static void loadTexture(GL10 gl, Context context, int resource) {
//		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resource);
//		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bmp, 0);
//		gl.glTexParameterx(GL10.GL_TEXTURE_2D,
//				GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
//		gl.glTexParameterx(GL10.GL_TEXTURE_2D,
//				GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
//		bmp.recycle();
//	}
//}