
import static com.raylib.Raylib.*;

static int WIDTH=1000;
static int HEIGHT=1000;
static int ITERATIONS=100;

public static void main(String args[]) {
    //SetTraceLogLevel(LOG_ERROR);
    initWindow(WIDTH, HEIGHT, "raylib");

    var texBunny = loadTexture("../bunny.png");
    long start, end;
    double elapsed_time, mbunnies_per_second;


    start = System.nanoTime();

    for(int i=0; i<ITERATIONS; i++)
    {

        beginDrawing();

        clearBackground(WHITE);

        for (int x=0; x<WIDTH; x++){
            for (int y=0; y<HEIGHT; y++){
                drawTexture(texBunny, x, y, WHITE);
            }
        }
        drawFPS(10, 10);

        endDrawing();

    }
    end = System.nanoTime();

    elapsed_time = (end - start) * 1e-9f;
    mbunnies_per_second = WIDTH*HEIGHT*ITERATIONS/elapsed_time/1000000f;

    unloadTexture(texBunny);

    closeWindow();
    System.out.println("Raylib | Java | Jaylib-FFM | "+mbunnies_per_second);


}



