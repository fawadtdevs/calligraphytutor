package com.fyp.calligraphytutor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * TODO: document your custom view class.
 */
public class AutoDrawWAView extends View {
    private Paint drawPaint, canvasPaint;
    public Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private float lastonex;
    private float lastoney;
    private float lasttwox;
    private float lasttwoy;
    private float sonex;
    private float soney;
    private float stwox;
    private float stwoy;
    private float startx;
    private float starty;
    private float endx;
    private float endy;


    private SparseArray<Path> paths;

    // Constructors

    public AutoDrawWAView(Context context) {
        super(context);
        setupDrawing();
    }

    public AutoDrawWAView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    public AutoDrawWAView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupDrawing();
    }

    // Setup Drawing

    private void setupDrawing() {
        paths = new SparseArray<>();
        drawPaint = new Paint();
        drawPaint.setColor(Color.BLACK);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        for (int i=0; i<paths.size(); i++) {
            canvas.drawPath(paths.valueAt(i), drawPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int id = event.getPointerId(index);

        Path path;
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                lasttwox = lasttwoy = lastonex = lasttwox = 0.0f;
                stwox = stwoy = sonex = stwox = 0.0f;
                startx = event.getX(0);
                starty = event.getY(0);
                /*path = new Path();
                path.moveTo(event.getX(index), event.getY(index));
                paths.put(id, path);
                break;*/
            case MotionEvent.ACTION_POINTER_DOWN:
                break;


            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() > 1) {
                    if (event.getHistorySize() > 0) {
                        path = new Path();
                        path.moveTo(event.getX(0), event.getY(0));
                        path.lineTo((event.getX(1)), event.getY(1));
                        path.lineTo(event.getHistoricalX(1, 0), event.getHistoricalY(1, 0));
                        if (lasttwox != 0.0f && lasttwoy != 0.0f)
                            path.lineTo(lasttwox, lasttwoy);
                        if (lastonex != 0.0f && lastoney != 0.0f)
                            path.lineTo(lastonex, lastoney);
                        path.lineTo(event.getHistoricalX(0, 0), event.getHistoricalY(0, 0));
                        path.lineTo(event.getX(0), event.getY(0));
                        drawPaint.setStrokeWidth(1);
                        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                        drawCanvas.drawPath(path, drawPaint);
                        // Center line

                        Path cpath = new Path();
                        float clastx = (lastonex + lasttwox) / 2;
                        float clasty = (lastoney + lasttwoy) / 2;
                        float chisx = (event.getHistoricalX(0, 0) + event.getHistoricalX(1, 0)) / 2;
                        float chisy = (event.getHistoricalY(0, 0) + event.getHistoricalY(1, 0)) / 2;
                        float cnowx = ( event.getX(0) + event.getX(1) ) / 2;
                        float cnowy = ( event.getY(0) + event.getY(1) ) / 2;
                        if (clastx != 0.0f && clasty != 0.0f)
                            cpath.moveTo(clastx, clasty);
                            //if (chisx != 0.0f && chisy != 0.0f)
                            //cpath.lineTo(chisx, chisy);
                        else {
                            cpath.moveTo(cnowx, cnowy);
                        }
                        cpath.lineTo(cnowx, cnowy);
                        Paint cdrawPaint = new Paint();
                        cdrawPaint.setStrokeWidth(1);
                        cdrawPaint.setStyle(Paint.Style.STROKE);
                        cdrawPaint.setColor(Color.RED);
                        drawCanvas.drawPath(cpath, cdrawPaint);

                        // Stroke Lines

                        Path spath = new Path();
                        if (sonex == 0.0f && soney == 0.0f && stwox == 0.0f && stwoy == 0.0f) {
                            spath.moveTo(event.getX(0), event.getY(0));
                            spath.lineTo(event.getX(1), event.getY(1));
                            //Draw between
                            sonex = event.getX(0);
                            soney = event.getY(0);
                            stwox = event.getX(1);
                            stwoy = event.getY(1);
                            // Set S values
                        } else {
                            float dis1 = (float) Math.sqrt( (Math.pow((event.getX(0) - sonex), 2) + (Math.pow((event.getY(0) - soney), 2))));
                            float dis2 = (float) Math.sqrt( (Math.pow((event.getX(1) - stwox), 2) + (Math.pow((event.getY(1) - stwoy), 2))));
                            float dis = dis1 + dis2;
                            if (dis > 200.0f) {
                                spath.moveTo(event.getX(0), event.getY(0));
                                spath.lineTo(event.getX(1), event.getY(1));
                                //Draw between
                                sonex = event.getX(0);
                                soney = event.getY(0);
                                stwox = event.getX(1);
                                stwoy = event.getY(1);
                                // Set S values
                            }
                        }
                        Paint sdrawPaint = new Paint();
                        sdrawPaint.setStrokeWidth(10);
                        sdrawPaint.setStyle(Paint.Style.STROKE);
                        sdrawPaint.setColor(Color.BLUE);
                        drawCanvas.drawPath(spath, sdrawPaint);

                        lastonex = event.getX(0);
                        lastoney = event.getY(0);
                        lasttwox = event.getX(1);
                        lasttwoy = event.getY(1);
                    }
                } else {
                    //id = event.getPointerId(0);
                    //path = paths.get(id);
                    path = new Path();
                    if (lastonex != 0.0f && lastoney != 0.0f) {
                        path.moveTo(lastonex, lastoney);
                        path.lineTo(lastonex+40.0f, lastoney-80.0f);
                        path.lineTo(event.getX(0)+40.0f, event.getY(0)-80.0f);
                        path.lineTo(event.getX(0), event.getY(0));
                        path.lineTo(event.getX(0)-40.0f, event.getY(0)+80.0f);
                        path.lineTo(lastonex-40.0f, lastoney+80.0f);
                        path.lineTo(lastonex, lastoney);
                        //path.lineTo(lastoney+40.0f, event.getY(0));
                        //path.lineTo(event.getX(0), event.getY(0));
                        drawPaint.setStrokeWidth(5);
                        drawPaint.setStyle(Paint.Style.FILL);
                        drawCanvas.drawPath(path, drawPaint);
                    }
                    lastonex = event.getX(0);
                    lastoney = event.getY(0);
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                lastonex = lastoney = lasttwox = lasttwoy = 0.0f;
                stwox = stwoy = sonex = stwox = 0.0f;
                endx = event.getX(0);
                endy = event.getY(0);
                //Gson gson = new Gson();
                if ( ((startx - endx) < -200.0f) && ((starty - endy) < -500.0f) ) {
                    Toast.makeText(getContext(), "Jeem Family", Toast.LENGTH_SHORT).show();
                } else {// if ( ((startx - endx) < -100.0f) && ((starty - endy) < -150.0f) ) {
                    Toast.makeText(getContext(), "Other", Toast.LENGTH_SHORT).show();

                }

                /*path = paths.get(id);
                if (path != null) {
                    drawPaint.setStyle(Paint.Style.STROKE);
                    drawCanvas.drawPath(path, drawPaint);
                    drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paths.remove(id);
                }*/
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public boolean clear() {
        try {
            drawCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            return true;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
    }

}

