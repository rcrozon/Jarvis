package Creator3D;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class GLView extends GLSurfaceView {

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private final float TRACKBALL_SCALE_FACTOR = 36.0f;
    
    private float mPreviousX;
    private float mPreviousY;
	private final GLRenderer renderer;
	
	public GLView(Context context) {
		super(context);
		renderer = new GLRenderer(context);
		setRenderer(renderer);
	    setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
    @Override public boolean onTrackballEvent(MotionEvent e) {
        renderer.mAngleX += e.getX() * TRACKBALL_SCALE_FACTOR;
        renderer.mAngleY += e.getY() * TRACKBALL_SCALE_FACTOR;
        requestRender();
        return true;
    }

    @Override 
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
        case MotionEvent.ACTION_MOVE:
            float dx = x - mPreviousX;
            float dy = y - mPreviousY;
            renderer.mAngleX += dx * TOUCH_SCALE_FACTOR;
            renderer.mAngleY -= dy * TOUCH_SCALE_FACTOR;
            requestRender();
        }
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}