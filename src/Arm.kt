import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Image
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.geom.AffineTransform

import java.io.InputStream
import javax.imageio.ImageIO
import javax.swing.JPanel
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import javax.swing.Timer

private var arm: Int? = null

private var animationTimer: Timer? = null
var animationStep = 0
var movable = false;
val maxSteps = 100 //num of animation frames
var t = 0.0
class Arm(var bodyX: Int, var thisMovable: Boolean, arm : Int?): JPanel() {
    var angleInRadians = 90.0;
    var originalArmX = 0.0;
    var originalArmY = 0.0;
//    val setPositions = SetPositions.getInstance();
    val currentArm = arm
    
    private var ball: Image //the image part is the type
    private val ballImage: Image

    var ballY = 0.0;
//    private val pivotY = 100;
//    private var arm ?= NULL

    init {
            isOpaque = false // Make the panel transparent
            val pivotY = 100;
            movable = thisMovable
            //GET ROTATIONS FROM ARM2: 90.0

        val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png")
        ball = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
        ballImage = ball.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
        if (movable) {
            background = Color.pink;

            addMouseMotionListener(object : MouseAdapter() {
                override fun mouseMoved(e: MouseEvent) {
//                    print("mouse moved X: " + e.x.toDouble() + " Y: " + e.y.toDouble());

//                    val pivotY = 100;

                    val deltaX = e.x.toDouble() - bodyX //pivotX
                    val deltaY = e.y.toDouble() - pivotY

                    if (originalArmX==0.0 && originalArmY==0.0) {
                        originalArmX = deltaX
                        originalArmY = deltaY
                    }

                    // Calculate angle in radians
                    if (e.x.toDouble() < (bodyX.toDouble() - 150)) {
                        print("behind arm start");
                    }
                    angleInRadians = atan2(deltaY, deltaX)

                    repaint()
                }
            })
            addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent) {
                    println("Mouse clicked. Coordinates: (${e.x}, ${e.y})")
                    startBallAnimation() //Uncomment plz
                    //

                    //
                }
            })
        }
    }

    override fun paintComponent(g: Graphics) {
        val baseHeight = 10;
        val baseSpeed = 10;
        val startY = ballY;

        //start y is specific position on screen
        //end y is end of player2 arm
        val armLength = 150;
        val endX = (armLength * kotlin.math.cos(90.0)).toInt() //cos helps with new horizontal position
        val endY = (armLength * kotlin.math.sin(90.0)).toInt() //cos helps with new horizontal position

        val globalEndX =
            window.width - 295 //+ (armLength * kotlin.math.cos(90.0)).toInt() //- endX // 140 for where end of arm is in relation to screen (x)
        val globalEndY = 225 + endY //for where end of arm is in relation to screen (y)

        val controlX = (window.height) / 2
        val controlY = (window.height / 5) //maxHeight

//        val controlY = minOf(startY, endY) - (baseHeight * force).toInt()

//        val steps = (100 / force).toInt().coerceIn(20, 150)

        super.paintComponent(g) // Call to clear the panel properly
        val g2d = g as Graphics2D // Cast to Graphics2D for advanced features
        g2d.color = Color.MAGENTA
        val originalTransform = g2d.transform
        g2d.translate(153, 300)
        g2d.rotate(angleInRadians)
        g2d.fillRect(0, 0, 150, 5) //450 // Coordinates adjusted relative to pivot

//        drawBall(g2d, originalTransform) //eliminated 5/18

        g.color = Color.red // Set the drawing color
        //testing
//        g2d.drawImage(ballImage, globalEndX, globalEndY, this) //look
//        g2d.transform = originalTransform
        //testing
        g.fillOval(window.width / 2, (window.height / 5), 15, 15) // Draw a filled circle. Height is top of circle
        g.fillOval(0, 0, 15, 15) // Draw a filled circle. Height is top of circle
        //Beyes Quad formula
//        g2d.drawImage(ballImage, 0, 0, this)
        for (i in 0..maxSteps) {


        }
        animationStep++
//        var t = 0.0 //moving 5/16

        //needs to be in val for draw image
//        val armPlacementBeforeTurnX = bodyX-149 //arm placement before turn is bodyX-149import java.awt.Color //4/27

        //
        val armPlacementBeforeTurnX = bodyX - 149 //arm placement before turn is bodyX-149import java.awt.Color
        val armPlacementAfterTurnX = 75.0 //sin(armPlacementBeforeTurnX.toDouble());

        val armPlacementBeforeTurnY = armLength //arm placement before turn is bodyX-149
        val armPlacementAfterTurnY = -80.0 //cos(armPlacementBeforeTurnX.toDouble());

//        setArmPosition(armPlacementAfterTurnX,armPlacementAfterTurnY,arm);

        val BezierX =
            Math.pow((1 - t), 2.0) * armPlacementAfterTurnX + 2 * (1 - t) * t * window.width / 2 + Math.pow(t, 2.0) * 2
//        print("bezierx "+BezierX)
        val BezierY =
            Math.pow((1 + t), 2.0) * armPlacementAfterTurnY + 2 * (1 + t) * t * window.height / 5 + Math.pow(t, 2.0) * 0

        g2d.drawImage(ballImage, BezierX.roundToInt(), BezierY.roundToInt(), this)

    }
    fun startBallAnimation() {
        println("hi from start ball animation")
        animationStep = 0
        t = 0.0

        animationTimer?.stop() // Stop any running animation

        animationTimer = Timer(16) { //larger the number slower it goes
            if (animationStep >= maxSteps) {
                animationTimer?.stop()
            } else {
                animationStep++
                t = animationStep.toDouble() / maxSteps //works but going in sideways hill, also animation stops when mouse moved
                repaint()
            }
        }
        animationTimer?.start()
    }
}
//✅ Here's how to fix it:
//To make the animation start from (75, -80), change the Bezier start point in these lines:
//
//kotlin
//Copy
//Edit
//val armPlacementAfterTurnX = 75.0
//val armPlacementAfterTurnY = -80.0

//adjust values till it works