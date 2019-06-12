package com.fyp.calligraphytutor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * TODO: document your custom view class.
 */
public class DrawWAView extends View {
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
    private float leftmost;
    private float rightmost;
    private float upmost;
    private float downmost;
    private float skstartx;
    private float skstarty;
    private float skendx;
    private float skendy;
    private float firstangle;
    private int wh, an, fa;
    private String message;
    public int alifvalue;
    public Characters chars;
    public CharactersPartTwo chars2;
    public CharactersPartThree chars3;
    public CharactersPartFour chars4;
    public CharactersPartFive chars5;
    public CharactersPartSix chars6;
    public CharactersPartSeven chars7;
    public CharsTwo charstwo;
    public CharsThree charsthree;
    public CharsFour charsfour;
    public CharsFive charsfive;
    public CharsSix charssix;
    public CharsSeven charsseven;
    public CharsEight charseight;
    public CharsNine charsnine;
    public BayCharsOne bayone;
    public BayCharsTwo baytwo;
    public BayCharsThree baythree;
    public BayCharsFour bayfour;
    public BayCharsFive bayfive;
    public BayCharsSix baysix;
    public BayCharsSeven bayseven;
    public BayCharsEight bayeight;
    public BayCharsNine baynine;
    public BayCharsTen bayten;

    public boolean setvalue(int coming) {
        alifvalue = coming;
        return true;
    }

    public boolean autodrawvalue;

    /*private int shapedal[][] = {
            {95,57},{106,63},{114,72},{116,83},{116,96},{113,108},{107,123},{100,133},{90,145},{52,153},{63,144},{89,128},{101,119},{104,109},{99,99},{88,90},{82,85},{97,55}
    };*/
    private int shapedal[][] = {
            {88,159},{88,160},{88,161},{88,162},{88,163},{88,164},{88,165},{89,166},{90,167},{91,166},{92,166},{93,165},{93,164},{94,163},{94,162},{95,161},{95,160},{95,159},{96,158},{96,157},{97,156},{97,155},{98,154},{98,153},{98,152},{99,151},{99,150},{99,149},{100,148},{100,147},{100,146},{101,145},{101,144},{101,143},{102,142},{102,141},{102,140},{102,139},{103,138},{103,137},{103,136},{103,135},{104,134},{104,133},{104,132},{104,131},{104,130},{105,129},{105,128},{105,127},{105,126},{105,125},{105,124},{105,123},{105,122},{106,121},{106,120},{106,119},{106,118},{106,117},{106,116},{106,115},{106,114},{106,113},{106,112},{106,111},{106,110},{106,109},{106,108},{106,107},{106,106},{106,105},{106,104},{106,103},{106,102},{106,101},{106,100},{106,99},{106,98},{106,97},{106,96},{106,95},{106,94},{106,93},{106,92},{106,91},{106,90},{106,89},{106,88},{106,87},{106,86},{106,85},{106,84},{106,83},{106,82},{106,81},{106,80},{106,79},{106,78},{106,77},{106,76},{106,75},{106,74},{106,73},{106,72},{107,71},{107,70},{107,69},{107,68},{107,67},{107,66},{107,65},{107,64},{107,63},{107,62},{107,61},{107,60},{107,59},{107,58},{107,57},{107,56},{107,55},{107,54},{107,53},{108,52},{108,51},{108,50},{108,49},{108,48},{108,47},{108,46},{108,45},{108,44},{109,43},{109,42},{109,41},{109,40},{109,39},{108,38},{107,37},{106,37},{105,38},{104,39},{103,40},{103,41},{102,42},{102,43},{101,44},{101,45},{101,46},{100,47},{100,48},{99,49},{99,50},{98,51},{98,52},{97,53},{97,54},{97,55},{96,56},{96,57},{95,58},{95,59},{94,60},{94,61},{94,62},{93,63},{93,64},{93,65},{92,66},{92,67},{92,68},{91,69},{91,70},{91,71},{90,72},{90,73},{90,74},{90,75},{90,76},{90,77},{90,78},{90,79},{90,80},{90,81},{90,82},{90,83},{90,84},{90,85},{90,86},{90,87},{90,88},{90,89},{90,90},{90,91},{90,92},{90,93},{90,94},{90,95},{90,96},{90,97},{90,98},{90,99},{90,100},{90,101},{90,102},{90,103},{90,104},{90,105},{90,106},{90,107},{91,108},{91,109},{91,110},{91,111},{91,112},{91,113},{91,114},{91,115},{91,116},{91,117},{91,118},{91,119},{91,120},{91,121},{91,122},{91,123},{91,124},{92,125},{92,126},{91,127},{91,128},{91,129},{91,130},{91,131},{91,132},{91,133},{91,134},{91,135},{91,136},{91,137},{91,138},{91,139},{91,140},{91,141},{91,142},{90,143},{90,144},{90,145},{90,146},{90,147},{90,148},{90,149},{90,150},{90,151},{90,152},{89,153},{89,154},{89,155},{89,156},{89,157},{89,158}
    };
    

    /*private int shapealif[][] = {
            {106,37},{88,73},{88,70},{89,102},{89,118},{89,145},{88,166},{104,118},{104,88},{105,54},{106,37}
    };*/

    private int shapealif[][] = {
            {64,290},{64,291},{64,292},{64,293},{64,294},{64,295},{64,296},{64,297},{64,298},{64,299},{64,300},{64,301},{64,302},{64,303},{64,304},{64,305},{64,306},{64,307},{64,308},{64,309},{64,310},{64,311},{64,312},{64,313},{64,314},{64,315},{65,316},{65,317},{65,318},{65,319},{65,320},{65,321},{66,322},{66,323},{66,324},{66,325},{67,326},{67,327},{67,328},{68,329},{68,330},{69,331},{70,332},{70,333},{71,333},{71,334},{72,334},{72,335},{73,335},{73,336},{74,336},{74,337},{75,337},{75,338},{76,338},{77,339},{78,340},{79,340},{80,341},{81,341},{82,342},{83,342},{84,343},{85,343},{86,343},{87,344},{88,344},{89,344},{90,344},{91,345},{92,345},{93,345},{94,345},{95,345},{96,346},{97,346},{98,346},{99,346},{100,346},{101,346},{102,347},{103,347},{104,347},{105,347},{106,347},{107,347},{108,348},{109,348},{110,348},{111,348},{112,348},{113,348},{114,348},{115,348},{116,349},{117,349},{118,349},{119,349},{120,349},{121,349},{122,349},{123,349},{124,349},{125,349},{126,350},{127,350},{128,350},{129,350},{130,350},{131,350},{132,350},{133,350},{134,350},{135,350},{136,350},{137,350},{138,350},{139,350},{140,350},{141,350},{142,350},{143,350},{144,351},{145,351},{146,351},{147,351},{148,351},{149,351},{150,351},{151,351},{152,351},{153,351},{154,351},{155,351},{156,351},{157,351},{158,351},{159,351},{160,351},{161,351},{162,351},{163,351},{164,350},{165,350},{166,350},{167,350},{168,350},{169,350},{170,350},{171,350},{172,350},{173,350},{174,350},{175,350},{176,350},{177,350},{178,350},{179,350},{180,350},{181,350},{182,349},{183,349},{184,349},{185,349},{186,349},{187,349},{188,349},{189,349},{190,349},{191,349},{192,349},{193,349},{194,348},{195,348},{196,348},{197,348},{198,348},{199,348},{200,348},{201,348},{202,348},{203,347},{204,347},{205,347},{206,347},{207,347},{208,347},{209,347},{210,347},{211,346},{212,346},{213,346},{214,346},{215,346},{216,346},{217,345},{218,345},{219,345},{220,345},{221,345},{222,345},{223,344},{224,344},{225,344},{226,344},{227,344},{228,344},{229,343},{230,343},{231,343},{232,343},{233,343},{234,342},{235,342},{236,342},{237,342},{238,342},{239,341},{240,341},{241,341},{242,341},{243,340},{244,340},{245,340},{246,340},{247,340},{248,339},{249,339},{250,339},{251,339},{252,338},{253,338},{254,338},{255,338},{256,337},{257,337},{258,337},{259,337},{260,336},{261,336},{262,336},{263,336},{264,335},{265,335},{266,335},{267,334},{268,334},{269,334},{270,334},{271,333},{272,333},{273,333},{274,332},{275,332},{276,332},{277,332},{278,331},{279,331},{280,331},{281,330},{282,330},{283,330},{284,329},{285,329},{286,328},{287,328},{288,328},{289,327},{290,327},{291,326},{292,326},{293,325},{294,325},{295,324},{296,324},{297,323},{298,322},{299,322},{300,321},{301,321},{302,320},{303,319},{304,319},{305,318},{306,317},{307,316},{308,316},{309,315},{310,314},{311,313},{312,312},{313,311},{314,310},{315,310},{316,309},{317,308},{317,307},{318,306},{319,305},{320,304},{321,303},{322,302},{323,301},{324,300},{324,299},{325,298},{326,297},{327,296},{327,295},{328,294},{329,293},{329,292},{330,291},{331,290},{331,289},{332,288},{333,287},{333,286},{334,285},{334,284},{335,283},{335,282},{336,281},{336,280},{337,279},{337,278},{338,277},{338,276},{339,275},{339,274},{340,273},{340,272},{341,271},{341,270},{341,269},{342,268},{342,267},{342,266},{343,265},{343,264},{343,263},{344,262},{344,261},{344,260},{344,259},{345,258},{345,257},{345,256},{345,255},{344,254},{343,254},{342,254},{341,254},{340,255},{339,256},{338,257},{338,258},{337,259},{337,260},{336,261},{335,262},{335,263},{334,264},{334,265},{333,266},{332,267},{331,268},{331,269},{330,270},{329,271},{328,272},{327,273},{326,274},{325,275},{324,276},{323,277},{322,278},{321,279},{320,279},{319,280},{318,281},{317,281},{316,282},{315,282},{314,283},{313,284},{312,284},{311,285},{310,285},{309,285},{308,286},{307,286},{306,287},{305,287},{304,287},{303,288},{302,288},{301,288},{300,289},{299,289},{298,289},{297,290},{296,290},{295,290},{294,291},{293,291},{292,291},{291,292},{290,292},{289,292},{288,292},{287,293},{286,293},{285,293},{284,293},{283,294},{282,294},{281,294},{280,294},{279,295},{278,295},{277,295},{276,295},{275,296},{274,296},{273,296},{272,296},{271,296},{270,297},{269,297},{268,297},{267,297},{266,297},{265,298},{264,298},{263,298},{262,298},{261,298},{260,298},{259,299},{258,299},{257,299},{256,299},{255,299},{254,299},{253,300},{252,300},{251,300},{250,300},{249,300},{248,300},{247,300},{246,300},{245,301},{244,301},{243,301},{242,301},{241,301},{240,301},{239,301},{238,301},{237,302},{236,302},{235,302},{234,302},{233,302},{232,302},{231,302},{230,302},{229,302},{228,302},{227,303},{226,303},{225,303},{224,303},{223,303},{222,303},{221,303},{220,303},{219,303},{218,303},{217,303},{216,303},{215,303},{214,303},{213,303},{212,304},{211,304},{210,304},{209,304},{208,304},{207,304},{206,304},{205,304},{204,304},{203,304},{202,304},{201,304},{200,304},{199,304},{198,304},{197,304},{196,304},{195,304},{194,304},{193,304},{192,304},{191,304},{190,304},{189,304},{188,304},{187,304},{186,304},{185,304},{184,304},{183,304},{182,304},{181,304},{180,304},{179,304},{178,304},{177,304},{176,304},{175,304},{174,304},{173,304},{172,304},{171,304},{170,304},{169,304},{168,304},{167,304},{166,304},{165,304},{164,304},{163,304},{162,304},{161,304},{160,304},{159,304},{158,304},{157,304},{156,304},{155,304},{154,304},{153,304},{152,304},{151,304},{150,304},{149,303},{148,303},{147,303},{146,303},{145,303},{144,303},{143,303},{142,303},{141,303},{140,303},{139,303},{138,303},{137,302},{136,302},{135,302},{134,302},{133,302},{132,302},{131,302},{130,302},{129,302},{128,302},{127,302},{126,301},{125,301},{124,301},{123,301},{122,301},{121,301},{120,301},{119,300},{118,300},{117,300},{116,300},{115,300},{114,300},{113,299},{112,299},{111,299},{110,299},{109,299},{108,298},{107,298},{106,298},{105,298},{104,297},{103,297},{102,297},{101,297},{100,296},{99,296},{98,296},{97,295},{96,295},{95,295},{94,295},{93,294},{92,294},{91,294},{90,293},{89,293},{88,292},{87,292},{86,291},{85,291},{84,290},{83,290},{83,289},{82,289},{82,288},{81,288},{81,287},{80,286},{79,285},{79,284},{78,283},{78,282},{78,281},{78,280},{78,279},{77,278},{77,277},{77,276},{77,275},{77,274},{77,273},{77,272},{77,271},{77,270},{77,269},{77,268},{77,267},{77,266},{77,265},{77,264},{77,263},{77,262},{77,261},{77,260},{77,259},{77,258},{77,257},{76,256},{75,255},{74,255},{73,255},{72,255},{71,255},{70,256},{70,257},{70,258},{69,259},{69,260},{69,261},{69,262},{69,263},{68,264},{68,265},{68,266},{68,267},{68,268},{67,269},{67,270},{67,271},{67,272},{67,273},{67,274},{66,275},{66,276},{66,277},{66,278},{66,279},{66,280},{66,281},{65,282},{65,283},{65,284},{65,285},{65,286},{65,287},{65,288},{65,289}
    };

    private int shapechotiya[][] = {
            {183,382},{183,383},{182,384},{181,385},{180,386},{180,387},{179,388},{178,389},{177,390},{176,391},{175,392},{175,393},{174,394},{173,395},{172,396},{171,397},{170,398},{170,399},{169,400},{168,401},{167,402},{166,403},{166,404},{165,405},{164,406},{163,407},{162,408},{162,409},{161,410},{160,411},{159,412},{158,413},{158,414},{157,415},{157,416},{157,417},{158,418},{158,419},{159,419},{159,420},{160,420},{160,421},{161,421},{161,422},{162,422},{162,423},{163,423},{163,424},{164,424},{164,425},{165,425},{165,426},{166,426},{166,427},{167,427},{167,428},{168,428},{169,429},{170,430},{171,430},{171,431},{172,431},{172,432},{173,432},{174,433},{175,434},{176,434},{177,435},{178,436},{179,436},{180,437},{181,437},{182,438},{183,438},{184,439},{185,439},{186,440},{187,440},{188,441},{189,441},{190,441},{191,440},{192,440},{193,439},{194,439},{195,438},{195,437},{196,436},{197,435},{198,434},{199,433},{200,432},{201,431},{202,430},{203,429},{203,428},{204,427},{205,426},{206,425},{207,424},{208,423},{208,422},{209,421},{210,420},{211,419},{212,418},{212,417},{213,416},{214,415},{215,414},{216,413},{216,412},{217,411},{217,410},{218,409},{218,408},{217,407},{217,406},{216,406},{216,405},{215,405},{214,404},{213,403},{212,403},{211,402},{210,401},{209,401},{209,400},{208,400},{207,399},{206,398},{205,398},{205,397},{204,397},{203,396},{202,395},{201,395},{201,394},{200,394},{199,393},{198,392},{197,392},{197,391},{196,391},{195,390},{194,389},{193,389},{193,388},{192,388},{192,387},{191,387},{190,386},{189,385},{188,385},{188,384},{187,384},{186,383},{185,382},{184,382}
    };
    private int datapoints[][] = {
            {11,264,269,0},
            {12,274,270,0},
            {15,249,269,0},
            {13,282,271,0},
            {16,274,271,0},
            {207,246,83,1},
            {187,277,185,1},
            {187,269,183,1},
            {224,257,181,1},
            {202,268,184,1},
            {65,47,318,2},
            {69,72,31,2},
            {66,39,326,2},
            {69,40,321,2},
            {58,49,311,2},
            {80,358,247,3},
            {79,356,352,3},
            {85,353,249,3},
            {84,357,250,3},
            {96,6,243,3},
            {83,267,226,4},
            {84,265,225,4},
            {78,262,231,4},
            {68,263,235,4},
            {75,281,234,4},
            {84,272,197,5},
            {89,259,198,5},
            {86,263,199,5},
            {82,261,203,5},
            {96,261,181,5},
            {81,93,192,6},
            {82,88,184,6},
            {91,88,195,6},
            {84,89,179,6},
            {60,267,256,7},
            {77,278,257,7},
            {76,275,248,7},
            {91,271,254,7},
            {69,257,318,8},
            {59,255,310,8},
            {59,247,306,8},
            {63,234,298,8},
            {177,138,178,9},
            {181,16,182,9},
            {176,121,178,9},
            {176,146,180,9},
            {73,153,178,10},
            {75,178,172,10},
            {76,187,175,10},
            {77,197,180,10},
            {115,279,207,11},
            {125,276,202,11},
            {102,274,202,11},
            {107,267,209,11},
            {49,280,232,12},
            {50,286,233,12},
            {45,279,239,12},
            {39,282,244,12},
            {39,35,257,13},
            {41,348,258,13},
            {37,342,264,13,},
            {34,0,262,13},
            {67,286,206,14},
            {68,282,211,14},
            {73,286,200,14},
            {73,281,205,14},
            {53,200,231,15},
            {47,188,233,15},
            {54,198,232,15},
            {70,197,221,15},
            {66,342,267,16},
            {62,335,251,16},
            {66,0,268,16},
            {69,356,265,16},
            {54,239,259,17},
            {54,238,258,17},
            {58,256,259,17},
            {54,233,256,17},
            {68,82,192,18},
            {69,210,210,18},
            {66,18,210,18},
            {72,161,202,18},
            {141,272,326,19},
            {157,264,172,19},
            {160,263,330,19},
            {149,267,327,19}
    };


    private SparseArray<Path> paths;

    // Constructors

    public DrawWAView(Context context) {
        super(context);
        setupDrawing();
    }

    public DrawWAView(Context context, int comevalue) {
        super(context);
        alifvalue = comevalue;
        setupDrawing();
    }

    public DrawWAView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    public DrawWAView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //if (alifvalue == 4) {
            /*for (int i=0; i < aliftest.length; i++) {
                canvasBitmap.setPixel(aliftest[i][0]*6, aliftest[i][1]*6, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6-1, aliftest[i][1]*6, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6+1, aliftest[i][1]*6, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6, aliftest[i][1]*6-1, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6, aliftest[i][1]*6+1, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6+1, aliftest[i][1]*6+1, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6-1, aliftest[i][1]*6+1, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6+1, aliftest[i][1]*6-1, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6-1, aliftest[i][1]*6-1, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6-2, aliftest[i][1]*6, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6+2, aliftest[i][1]*6, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6, aliftest[i][1]*6-2, Color.RED);
                canvasBitmap.setPixel(aliftest[i][0]*6, aliftest[i][1]*6+2, Color.RED);
            }*/
        //}
        drawCanvas = new Canvas(canvasBitmap);
        //drawguide();
        drawshapeguide();
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
                if (autodrawvalue) {
                    lasttwox = lasttwoy = lastonex = lasttwox = 0.0f;
                    stwox = stwoy = sonex = stwox = 0.0f;
                    startx = event.getX(0);
                    starty = event.getY(0);
                    /*path = new Path();
                    path.moveTo(event.getX(index), event.getY(index));
                    paths.put(id, path);
                    break;*/
                } else {
                    lasttwox = lasttwoy = lastonex = lasttwox = 0.0f;
                    stwox = stwoy = sonex = stwox = 0.0f;
                    skendx = skendy = skstartx = skstarty = 0.0f;
                    firstangle = 0.0f;
                    startx = event.getX(0);
                    starty = event.getY(0);
                    leftmost = event.getX(0);
                    rightmost = event.getX(0);
                    upmost = event.getY(0);
                    downmost = event.getY(0);
                    /*path = new Path();
                    path.moveTo(event.getX(index), event.getY(index));
                    paths.put(id, path);*/
                }

                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                if (!autodrawvalue) {
                    if (event.getX(1) < leftmost) leftmost = event.getX(1);
                    if (event.getX(1) > rightmost) rightmost = event.getX(1);
                    if (event.getY(1) < upmost) upmost = event.getY(1);
                    if (event.getY(1) > downmost) downmost = event.getY(1);
                }
                break;


            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() > 1 && !autodrawvalue) {
                    if (event.getX(0) < leftmost) leftmost = event.getX(0);
                    if (event.getX(0) > rightmost) rightmost = event.getX(0);
                    if (event.getY(0) < upmost) upmost = event.getY(0);
                    if (event.getY(0) > downmost) downmost = event.getY(0);
                    if (event.getX(1) < leftmost) leftmost = event.getX(1);
                    if (event.getX(1) > rightmost) rightmost = event.getX(1);
                    if (event.getY(1) < upmost) upmost = event.getY(1);
                    if (event.getY(1) > downmost) downmost = event.getY(1);
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
                        drawPaint.setColor(Color.BLACK);
                        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                        drawCanvas.drawPath(path, drawPaint);
                        // Center line

                        Path cpath = new Path();
                        float clastx = (lastonex + lasttwox) / 2;
                        float clasty = (lastoney + lasttwoy) / 2;
                        float chisx = (event.getHistoricalX(0, 0) + event.getHistoricalX(1, 0)) / 2;
                        float chisy = (event.getHistoricalY(0, 0) + event.getHistoricalY(1, 0)) / 2;
                        float cnowx = (event.getX(0) + event.getX(1)) / 2;
                        float cnowy = (event.getY(0) + event.getY(1)) / 2;
                        if (clastx != 0.0f && clasty != 0.0f) {
                            if (skstartx == 0.0f && skstarty == 0.0f) {
                                skstartx = clastx;
                                skstarty = clasty;
                            }
                            cpath.moveTo(clastx, clasty);
                            //if (chisx != 0.0f && chisy != 0.0f)
                            //cpath.lineTo(chisx, chisy);
                        }
                        else {
                            if (skstartx == 0.0f && skstarty == 0.0f) {
                                skstartx = cnowx;
                                skstarty = cnowy;
                            }
                            cpath.moveTo(cnowx, cnowy);
                        }
                        if (skstartx != 0.0f || skstarty != 0.0f) {
                            skendx = cnowx;
                            skendy = cnowy;
                        }
                        float firstangledis = (float) Math.sqrt( (Math.pow((cnowx - skstartx), 2) + (Math.pow((cnowy - skstarty), 2))));
                        if (firstangle == 0.0f && firstangledis > 60) {
                            firstangle = (float) findangle(skstartx, skstarty, cnowx, cnowy);
                        }
                        cpath.lineTo(cnowx, cnowy);
                        Paint cdrawPaint = new Paint();
                        cdrawPaint.setStrokeWidth(1);
                        cdrawPaint.setStyle(Paint.Style.STROKE);
                        cdrawPaint.setColor(Color.BLACK);
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
                        sdrawPaint.setStrokeWidth(1);
                        sdrawPaint.setStyle(Paint.Style.STROKE);
                        sdrawPaint.setColor(Color.BLACK);
                        drawCanvas.drawPath(spath, sdrawPaint);

                        lastonex = event.getX(0);
                        lastoney = event.getY(0);
                        lasttwox = event.getX(1);
                        lasttwoy = event.getY(1);
                    }
                } else {
                    if (autodrawvalue) {
                        path = new Path();
                        if (lastonex != 0.0f && lastoney != 0.0f) {
                            path.moveTo(lastonex, lastoney);
                            path.lineTo(lastonex + 30.0f, lastoney - 50.0f);
                            path.lineTo(event.getX(0) + 30.0f, event.getY(0) - 50.0f);
                            path.lineTo(event.getX(0), event.getY(0));
                            path.lineTo(event.getX(0) - 30.0f, event.getY(0) + 50.0f);
                            path.lineTo(lastonex - 30.0f, lastoney + 50.0f);
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
                    //id = event.getPointerId(0);
                    //path = paths.get(id);
                    /*path = new Path();
                    if (lastonex != 0.0f && lastoney != 0.0f) {
                        path.moveTo(lastonex, lastoney);
                        path.lineTo(event.getX(0), event.getY(0));
                        drawPaint.setStrokeWidth(5);
                        drawPaint.setStyle(Paint.Style.STROKE);
                        drawCanvas.drawPath(path, drawPaint);
                    }
                    lastonex = event.getX(0);
                    lastoney = event.getY(0);*/
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                double angle = findangle(skstartx, skstarty, skendx, skendy);
                lastonex = lastoney = lasttwox = lasttwoy = 0.0f;
                stwox = stwoy = sonex = stwox = 0.0f;
                endx = event.getX(0);
                endy = event.getY(0);
                if ( (rightmost-leftmost) + (downmost-upmost) > 550 ) {
                    //message = "WH:" + Math.round( (rightmost - leftmost) / (downmost - upmost) * 100.0f) + " FA:" + Math.round(firstangle) + " A:" + Math.round(angle);
                    wh = Math.round( (rightmost - leftmost) / (downmost - upmost) * 100.0f);
                    fa = Math.round(firstangle);
                    an = (int) Math.round(angle);
                    //message = "WH:"+Math.round(firstangle)+"A:"+Math.round(angle)+"S("+Math.round(skstartx)+","+Math.round(skstarty)+")"+"E("+Math.round(skendx)+","+Math.round(skendy)+")"+"Width: " + Math.round(rightmost - leftmost) + "Height: " + Math.round(downmost - upmost) + "L:" + Math.round(leftmost) + "R:" + Math.round(rightmost) + "U:" + Math.round(upmost) + "D:" + Math.round(downmost);
                }
                int awidth = canvasBitmap.getWidth();
                int aheight = canvasBitmap.getHeight();
                int componentsPerPixel = 3;
                int totalPixels = awidth * aheight;
                int totalBytes = totalPixels * componentsPerPixel;
                int[] argbPixels = new int[totalPixels];
                canvasBitmap.getPixels(argbPixels, 0, awidth, 0, 0, awidth, aheight);
                for (int i = 0; i < totalPixels; i++) {
                    if ( Color.red(argbPixels[i]) != 0 || Color.green(argbPixels[i]) != 0 || Color.blue(argbPixels[i]) != 0) {
                        if ( (i%awidth) % 5 == 0 && (i/awidth) % 5 == 0 )
                            Log.d(TAG, "{" + (i%awidth) + "," + (i/awidth) + "}");
                        //String temps = "(" + Color.red(argbPixels[i]) + "," + Color.green(argbPixels[i]) + "," + Color.blue(argbPixels[i]) + ")";
                    }
                }
                //int tempa = canvasBitmap.getPixels();
                //int tempr = Color.red(tempa);
                //int tempg = Color.green(tempa);
                //int tempb = Color.blue(tempa);

                //message = "Value found:"+tempr+tempg+tempb;
                //Gson gson = new Gson();
                if ( ((startx - endx) < -200.0f) && ((starty - endy) < -500.0f) ) {
                    //message = "Jeem Family";
                    //Toast.makeText(getContext(), "Jeem Family", Toast.LENGTH_SHORT).show();
                } else {// if ( ((startx - endx) < -100.0f) && ((starty - endy) < -150.0f) ) {
                    //Toast.makeText(getContext(), "Other", Toast.LENGTH_SHORT).show();

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
            drawshapeguide();
            return true;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
    }

    public String recognize(boolean perc) {
        double shortest = 99999.0d;
        int classi = 1000;
        double temp = 0.0d;
        for (int i = 0; i < datapoints.length; i++) {
            temp = calculatedistance(datapoints[i][0], datapoints[i][1], datapoints[i][2], wh, fa, an);
            if (temp < shortest) {
                shortest = temp;
                classi = datapoints[i][3];
            }
        }
        int awidth = canvasBitmap.getWidth();
        int aheight = canvasBitmap.getHeight();
        int componentsPerPixel = 3;
        int totalPixels = awidth * aheight;
        int totalBytes = totalPixels * componentsPerPixel;
        int[] argbPixels = new int[totalPixels];
        canvasBitmap.getPixels(argbPixels, 0, awidth, 0, 0, awidth, aheight);
        for (int i = 0; i < totalPixels; i++) {
            if ( Color.red(argbPixels[i]) == 0 && Color.green(argbPixels[i]) == 0 && Color.blue(argbPixels[i]) == 0 && Color.alpha(argbPixels[i]) == 255) {
                canvasBitmap.setPixel(i%awidth, i/awidth, Color.argb(127, 255, 0, 0));
            }
        }
        drawshapeguide();
        drawborderguide();
        int greennum = 0;
        int rednum = 0;
        int graynum = 0;
        int aala = canvasBitmap.getPixel(200, 300);
        int red = Color.red(aala);
        int green = Color.green(aala);
        int blue = Color.blue(aala);
        int alpha = Color.alpha(aala);
        String abc = "("+alpha+","+red+","+green+","+blue+")";
        for (int i = 0; i < totalPixels; i++) {
            if ( Color.red(argbPixels[i]) == 255 && Color.green(argbPixels[i]) == 0 && Color.blue(argbPixels[i]) == 0 && Color.alpha(argbPixels[i]) == 127) {
                canvasBitmap.setPixel(i%awidth, i/awidth, Color.argb(255, 255, 0, 0));
                rednum++;
            }
        }
        for (int i = 0; i < totalPixels; i++) {
            if ( Color.red(argbPixels[i]) == 255 && Color.green(argbPixels[i]) == 170 && Color.blue(argbPixels[i]) == 0 && Color.alpha(argbPixels[i]) == 191) {
                canvasBitmap.setPixel(i%awidth, i/awidth, Color.argb(255, 0, 255, 0));
                greennum++;
            }
        }
        for (int i = 0; i < totalPixels; i++) {
            if ( Color.red(argbPixels[i]) == 255 && Color.green(argbPixels[i]) == 255 && Color.blue(argbPixels[i]) == 0 && Color.alpha(argbPixels[i]) == 191) {
                canvasBitmap.setPixel(i%awidth, i/awidth, Color.argb(255, 127, 127, 127));
                graynum++;
            }
        }
        if (perc) {
            int totalarea = greennum + rednum + graynum;
            int percentage = (int) ( 100.0f - (  ( (float) ( (float) totalarea - (float) greennum ) / (float) (totalarea) ) * 100.0f ) );
            Toast.makeText(getContext(), "Accuracy: " + percentage + "%", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getContext(), "Green:"+greennum+" || Red:"+rednum+" || Gray:"+graynum, Toast.LENGTH_SHORT).show();
        }
        String family[] = {"Alif", "Bay", "Jeem", "Daal", "Ray", "Seen", "Suad", "Tuoyain", "Aaien", "Fay", "Kaf", "Kaaf", "Laam", "Meem", "Noon", "Wao", "Hay", "Hamza", "ChotiYa", "BariYa"};
        return "";//family[classi]+abc;
    }

    public double findangle(float sx, float sy, float ex, float ey) {
        double angle = Math.toDegrees(Math.atan((sy-ey)/(ex-sx)));
        if (angle < 0.0d) { angle = angle*-1.0d; }
        if (ex > sx && ey < sy) {
            // Do nothing
        } else if (ex < sx && ey < sy) {
            angle = 180.0d - angle;
        } else if (ex < sx && ey > sy) {
            angle = angle + 180.0d;
        } else if (ex > sx && ey > sy) {
            angle = 360.0d - angle;
        }
        return angle;
    }

    public double distance(int a1, int b1, int a2, int b2) {
        double dist = Math.sqrt( (Math.pow((a1-a2), 2)) + (Math.pow((b1-b2), 2)) );
        return dist;
    }

    public double calculatedistance(int a1, int b1, int c1, int a2, int b2, int c2) {
        double dist = Math.sqrt( (Math.pow((a1-a2), 2)) + (Math.pow((b1-b2), 2)) + (Math.pow((c1-c2), 2)) );
        return dist;
    }

    public boolean drawguide() {
        Paint drawPaint2 = new Paint();
        drawPaint2.setColor(Color.RED);
        drawPaint2.setAntiAlias(true);
        drawPaint2.setStrokeJoin(Paint.Join.ROUND);
        drawPaint2.setStrokeCap(Paint.Cap.ROUND);
        //for (int i=0; i < aliftest.length; i++) {
        //    drawCanvas.drawCircle(aliftest[i][0] * 4, aliftest[i][1] * 4, 2.0f, drawPaint2);
        //}
        return true;
    }

    public boolean drawshapeguide() {
        Paint drawPaint2 = new Paint();
        drawPaint2.setColor(Color.argb(127, 255, 255, 0));
        //drawPaint2.setColor(Color.argb(255, 0, 0, 0));
        drawPaint2.setStyle(Paint.Style.FILL);
        drawPaint2.setAntiAlias(true);
        drawPaint2.setStrokeJoin(Paint.Join.ROUND);
        drawPaint2.setStrokeCap(Paint.Cap.ROUND);

        if (alifvalue == 0 || alifvalue == 9 || alifvalue == 11 || alifvalue == 14 || alifvalue == 18
                || alifvalue == 20 || alifvalue == 22 || alifvalue == 24 || alifvalue == 28 ||
                alifvalue == 30 || alifvalue == 31 || alifvalue == 33 || alifvalue == 34 ||
                alifvalue == 35 || alifvalue == 36 || alifvalue == 37) {

            int[][] shapenow;
            if (alifvalue == 0) {
                shapenow = chars.char0;
            } else if (alifvalue == 9) {
                shapenow = chars2.char9;
            } else if (alifvalue == 11) {
                shapenow = chars3.char11;
            }  else if (alifvalue == 14) {
                shapenow = chars3.char14;
            } else if (alifvalue == 18) {
                shapenow = chars4.char18;
            } else if (alifvalue == 20) {
                shapenow = charsfour.char20;
            } else if (alifvalue == 22) {
                shapenow = charsthree.char22;
            } else if (alifvalue == 24) {
                shapenow = charsthree.char24;
            } else if (alifvalue == 28) {
                shapenow = charssix.char28;
            } else if (alifvalue == 30) {
                shapenow = charssix.char30;
            } else if (alifvalue == 31) {
                shapenow = chars7.char31;
            } else if (alifvalue == 33) {
                shapenow = chars7.char33;
            } else if (alifvalue == 34) {
                shapenow = chars7.char34;
            } else if (alifvalue == 35) {
                shapenow = charsfive.char35;
            } else if (alifvalue == 36) {
                shapenow = charsfive.char36;
            } else if (alifvalue == 37) {
                shapenow = charsfive.char37;
            } else {
                shapenow = chars.char0;
            }
            Path pshape = new Path();
            pshape.moveTo(shapenow[0][0]*2, shapenow[0][1]*2);
            for (int i=1; i < shapenow.length; i++) {
                pshape.lineTo(shapenow[i][0]*2, shapenow[i][1]*2);
            }
            pshape.lineTo(shapenow[0][0]*2, shapenow[0][1]*2);
            drawCanvas.drawPath(pshape, drawPaint2);

        } else {

            // DOTTED ONES

            int[][][] shapenow;
            if (alifvalue == 1) {
                shapenow = chars.char1;
            } else if (alifvalue == 2) {
                shapenow = chars.char2;
            } else if (alifvalue == 3) {
                shapenow = charstwo.char3;
            }  else if (alifvalue == 4) {
                shapenow = charstwo.char4;
            } else if (alifvalue == 5) {
                shapenow = charstwo.char5;
            } else if (alifvalue == 6) {
                shapenow = charseight.char6;
            } else if (alifvalue == 7) {
                shapenow = charsseven.char7;
            } else if (alifvalue == 8) {
                shapenow = charsseven.char8;
            } else if (alifvalue == 10) {
                shapenow = chars2.char10;
            } else if (alifvalue == 12) {
                shapenow = chars3.char12;
            } else if (alifvalue == 13) {
                shapenow = chars3.char13;
            } else if (alifvalue == 15) {
                shapenow = chars3.char15;
            } else if (alifvalue == 16) {
                shapenow = chars4.char16;
            } else if (alifvalue == 17) {
                shapenow = chars4.char17;
            } else if (alifvalue == 19) {
                shapenow = charsfour.char19;
            } else if (alifvalue == 21) {
                shapenow = chars5.char21;
            } else if (alifvalue == 23) {
                shapenow = charsthree.char23;
            } else if (alifvalue == 25) {
                shapenow = chars5.char25;
            } else if (alifvalue == 26) {
                shapenow = chars6.char26;
            } else if (alifvalue == 27) {
                shapenow = chars6.char27;
            } else if (alifvalue == 29) {
                shapenow = charsnine.char29;
            } else if (alifvalue == 32) {
                shapenow = chars7.char32;
            } else if (alifvalue == 38) {
                shapenow = bayone.char38;
            } else if (alifvalue == 39) {
                shapenow = bayone.char39;
            } else if (alifvalue == 40) {
                shapenow = baytwo.char40;
            } else if (alifvalue == 41) {
                shapenow = baytwo.char41;
            } else if (alifvalue == 42) {
                shapenow = baythree.char42;
            } else if (alifvalue == 43) {
                shapenow = baythree.char43;
            } else if (alifvalue == 44) {
                shapenow = bayten.char44;
            } else if (alifvalue == 45) {
                shapenow = bayfour.char45;
            } else if (alifvalue == 46) {
                shapenow = bayfour.char46;
            } else if (alifvalue == 47) {
                shapenow = bayfive.char47;
            } else if (alifvalue == 48) {
                shapenow = bayfive.char48;
            } else if (alifvalue == 49) {
                shapenow = baysix.char49;
            } else if (alifvalue == 50) {
                shapenow = bayseven.char50;
            } else if (alifvalue == 51) {
                shapenow = bayseven.char51;
            } else if (alifvalue == 52) {
                shapenow = bayeight.char52;
            } else if (alifvalue == 53) {
                shapenow = bayeight.char53;
            } else if (alifvalue == 54) {
                shapenow = baynine.char54;
            } else if (alifvalue == 55) {
                shapenow = baynine.char55;
            } else if (alifvalue == 56) {
                shapenow = baynine.char56;
            } else {
                shapenow = chars.char1;
            }
            for (int m = 0; m < shapenow.length; m++) {
                Path smshape = new Path();
                smshape.moveTo(shapenow[m][0][0]*2, shapenow[m][0][1]*2);
                for (int i=1; i < shapenow[m].length; i++) {
                    smshape.lineTo(shapenow[m][i][0]*2, shapenow[m][i][1]*2);
                }
                smshape.lineTo(shapenow[m][0][0]*2, shapenow[m][0][1]*2);
                drawCanvas.drawPath(smshape, drawPaint2);
            }
        }

        /*Path pshape = new Path();
        int[][] shapenow;
        if (alifvalue == 0) {
            shapenow = shapealif;
        } else if (alifvalue == 1) {
            shapenow = shapedal;
        } else {
            shapenow = shapechotiya;
        }
        pshape.moveTo(shapenow[0][0]*2, shapenow[0][1]*2);
        for (int i=1; i < shapenow.length; i++) {
            pshape.lineTo(shapenow[i][0]*2, shapenow[i][1]*2);
        }
        pshape.lineTo(shapenow[0][0]*2, shapenow[0][1]*2);
        drawCanvas.drawPath(pshape, drawPaint2);*/
        /*Region reg = new Region();
        reg.setPath(pshape, new Region(0, 0, 900, 900));
        if (reg.contains(100, 100)) {
            Toast.makeText(getContext(), "100100Yes", Toast.LENGTH_SHORT).show();
        }
        if (reg.contains(200, 200)) {
            Toast.makeText(getContext(), "200200Yes", Toast.LENGTH_SHORT).show();
        }
        if (reg.contains(300, 300)) {
            Toast.makeText(getContext(), "300300Yes", Toast.LENGTH_SHORT).show();
        }
        if (reg.contains(305, 305)) {
            Toast.makeText(getContext(), "305305Yes", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "warr gye", Toast.LENGTH_SHORT).show();
        }*/
        return true;
    }
    public boolean drawborderguide() {
        Paint drawPaint2 = new Paint();
        drawPaint2.setColor(Color.argb(255, 85, 85, 85));
        drawPaint2.setStyle(Paint.Style.STROKE);
        drawPaint2.setAntiAlias(true);
        drawPaint2.setStrokeWidth(1.5f);
        drawPaint2.setStrokeJoin(Paint.Join.ROUND);
        drawPaint2.setStrokeCap(Paint.Cap.ROUND);

        if (alifvalue == 0 || alifvalue == 9 || alifvalue == 11 || alifvalue == 14 || alifvalue == 18
                || alifvalue == 20 || alifvalue == 22 || alifvalue == 24 || alifvalue == 28 ||
                alifvalue == 30 || alifvalue == 31 || alifvalue == 33 || alifvalue == 34 ||
                alifvalue == 35 || alifvalue == 36 || alifvalue == 37) {

            Path pshape = new Path();
            int[][] shapenow;
            if (alifvalue == 0) {
                shapenow = chars.char0;
            } else if (alifvalue == 9) {
                shapenow = chars2.char9;
            } else if (alifvalue == 11) {
                shapenow = chars3.char11;
            } else if (alifvalue == 14) {
                shapenow = chars3.char14;
            } else if (alifvalue == 18) {
                shapenow = chars4.char18;
            } else if (alifvalue == 20) {
                shapenow = charsfour.char20;
            } else if (alifvalue == 22) {
                shapenow = charsthree.char22;
            } else if (alifvalue == 24) {
                shapenow = charsthree.char24;
            } else if (alifvalue == 28) {
                shapenow = charssix.char28;
            } else if (alifvalue == 30) {
                shapenow = charssix.char30;
            } else if (alifvalue == 31) {
                shapenow = chars7.char31;
            } else if (alifvalue == 33) {
                shapenow = chars7.char33;
            } else if (alifvalue == 34) {
                shapenow = chars7.char34;
            } else if (alifvalue == 35) {
                shapenow = charsfive.char35;
            } else if (alifvalue == 36) {
                shapenow = charsfive.char36;
            } else if (alifvalue == 37) {
                shapenow = charsfive.char37;
            } else {
                shapenow = chars.char0;
            }
            pshape.moveTo(shapenow[0][0] * 2, shapenow[0][1] * 2);
            for (int i = 1; i < shapenow.length; i++) {
                pshape.lineTo(shapenow[i][0] * 2, shapenow[i][1] * 2);
            }
            pshape.lineTo(shapenow[0][0] * 2, shapenow[0][1] * 2);
            drawCanvas.drawPath(pshape, drawPaint2);

        } else {

            // DOTTED ONES

            int[][][] shapenow;
            if (alifvalue == 1) {
                shapenow = chars.char1;
            } else if (alifvalue == 2) {
                shapenow = chars.char2;
            } else if (alifvalue == 3) {
                shapenow = charstwo.char3;
            } else if (alifvalue == 4) {
                shapenow = charstwo.char4;
            } else if (alifvalue == 5) {
                shapenow = charstwo.char5;
            } else if (alifvalue == 6) {
                shapenow = charseight.char6;
            } else if (alifvalue == 7) {
                shapenow = charsseven.char7;
            } else if (alifvalue == 8) {
                shapenow = charsseven.char8;
            } else if (alifvalue == 10) {
                shapenow = chars2.char10;
            } else if (alifvalue == 12) {
                shapenow = chars3.char12;
            } else if (alifvalue == 13) {
                shapenow = chars3.char13;
            } else if (alifvalue == 15) {
                shapenow = chars3.char15;
            } else if (alifvalue == 16) {
                shapenow = chars4.char16;
            } else if (alifvalue == 17) {
                shapenow = chars4.char17;
            } else if (alifvalue == 19) {
                shapenow = charsfour.char19;
            } else if (alifvalue == 21) {
                shapenow = chars5.char21;
            } else if (alifvalue == 23) {
                shapenow = charsthree.char23;
            } else if (alifvalue == 25) {
                shapenow = chars5.char25;
            } else if (alifvalue == 26) {
                shapenow = chars6.char26;
            } else if (alifvalue == 27) {
                shapenow = chars6.char27;
            } else if (alifvalue == 29) {
                shapenow = charsnine.char29;
            } else if (alifvalue == 32) {
                shapenow = chars7.char32;
            } else if (alifvalue == 38) {
                shapenow = bayone.char38;
            } else if (alifvalue == 39) {
                shapenow = bayone.char39;
            } else if (alifvalue == 40) {
                shapenow = baytwo.char40;
            } else if (alifvalue == 41) {
                shapenow = baytwo.char41;
            } else if (alifvalue == 42) {
                shapenow = baythree.char42;
            } else if (alifvalue == 43) {
                shapenow = baythree.char43;
            } else if (alifvalue == 44) {
                shapenow = bayten.char44;
            } else if (alifvalue == 45) {
                shapenow = bayfour.char45;
            } else if (alifvalue == 46) {
                shapenow = bayfour.char46;
            } else if (alifvalue == 47) {
                shapenow = bayfive.char47;
            } else if (alifvalue == 48) {
                shapenow = bayfive.char48;
            } else if (alifvalue == 49) {
                shapenow = baysix.char49;
            } else if (alifvalue == 50) {
                shapenow = bayseven.char50;
            } else if (alifvalue == 51) {
                shapenow = bayseven.char51;
            } else if (alifvalue == 52) {
                shapenow = bayeight.char52;
            } else if (alifvalue == 53) {
                shapenow = bayeight.char53;
            } else if (alifvalue == 54) {
                shapenow = baynine.char54;
            } else if (alifvalue == 55) {
                shapenow = baynine.char55;
            } else if (alifvalue == 56) {
                shapenow = baynine.char56;
            } else {
                shapenow = chars.char1;
            }
            for (int m = 0; m < shapenow.length; m++) {
                Path smshape = new Path();
                smshape.moveTo(shapenow[m][0][0] * 2, shapenow[m][0][1] * 2);
                for (int i = 1; i < shapenow[m].length; i++) {
                    smshape.lineTo(shapenow[m][i][0] * 2, shapenow[m][i][1] * 2);
                }
                smshape.lineTo(shapenow[m][0][0] * 2, shapenow[m][0][1] * 2);
                drawCanvas.drawPath(smshape, drawPaint2);
            }
        }
        return true;
    }
}