import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Image
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.InputStream
import javax.imageio.ImageIO
import javax.swing.JPanel
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

private var arm: Int? = null
class Arm(var bodyX: Int, var movable: Boolean, arm : Int?): JPanel() {
    var angleInRadians = 90.0;
    var originalArmX = 0.0;
    var originalArmY = 0.0;
//    val setPositions = SetPositions.getInstance();
    val currentArm = arm
    
    private var ball: Image //the image part is the type
    private val ballImage: Image

    private var ballY = 0.0;
//    private val pivotY = 100;
//    private var arm ?= NULL

    init {
            isOpaque = false // Make the panel transparent
            val pivotY = 100;
            //GET ROTATIONS FROM ARM2: 90.0

        val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png")
        ball = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
        ballImage = ball.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
        if (movable) {
            background = Color.pink;

            addMouseMotionListener(object : MouseAdapter() {
                override fun mouseMoved(e: MouseEvent) {
                    print("mouse moved X: " + e.x.toDouble() + " Y: " + e.y.toDouble());

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

        val globalEndX = window.width - 295 //+ (armLength * kotlin.math.cos(90.0)).toInt() //- endX // 140 for where end of arm is in relation to screen (x)
        val globalEndY = 225 + endY //for where end of arm is in relation to screen (y)

        var currentStep = 0
        val steps = 100 //num of animation frames

        val controlX = (window.height) / 2
        val controlY = (window.height/5) //maxHeight

//        val controlY = minOf(startY, endY) - (baseHeight * force).toInt()

//        val steps = (100 / force).toInt().coerceIn(20, 150)

        super.paintComponent(g) // Call to clear the panel properly
        val g2d = g as Graphics2D // Cast to Graphics2D for advanced features
        g2d.color = Color.MAGENTA
        val originalTransform = g2d.transform
        g2d.translate(153, 300)
        g2d.rotate(angleInRadians)
        g2d.fillRect(0, 0, 150, 5) //450 // Coordinates adjusted relative to pivot
        
        if (movable) {
            ballY = 80.0;
            g2d.drawImage(ballImage, 75, -80, this)
            g2d.transform = originalTransform
        }
        
        g.color = Color.red // Set the drawing color
        //testing
//        g2d.drawImage(ballImage, globalEndX, globalEndY, this)
//        g2d.transform = originalTransform
        //testing
        g.fillOval(window.width/2,   (window.height/5), 15,15) // Draw a filled circle. Height is top of circle
        g.fillOval(0,  0, 15,15) // Draw a filled circle. Height is top of circle
        //Beyes Quad formula
//        g2d.drawImage(ballImage, 0, 0, this)
        val maxSteps = 100;
        for (i in 0..maxSteps) {
            
        }
        currentStep++
        val t = 1.0

        //needs to be in val for draw image
        val armPlacementBeforeTurnX = bodyX-149 //arm placement before turn is bodyX-149
        val armPlacementAfterTurnX = sin(armPlacementBeforeTurnX.toDouble());

        val armPlacementBeforeTurnY = armLength //arm placement before turn is bodyX-149
        val armPlacementAfterTurnY = cos(armPlacementBeforeTurnX.toDouble());

//        setArmPosition(armPlacementAfterTurnX,armPlacementAfterTurnY,arm);

        val BezierX = Math.pow((1 - t), 2.0) * armPlacementAfterTurnX + 2 * (1 - t) * t * window.width/2 + Math.pow(t,2.0) * 2
        print("bezierx "+BezierX)
        val BezierY = Math.pow((1 - t), 2.0) * armPlacementAfterTurnY + 2 * (1 - t) * t * window.height/5 + Math.pow(t,2.0) * 0

        g2d.drawImage(ballImage, BezierX.roundToInt(),BezierY.roundToInt(), this)

    }


//    fun setArmPosition (characterArmX: Double, characterArmY: Double, arm: Int?) {
//        if (arm == 1) {
////            setPositions.setArm1XAfterTurn(characterArmX)
////            setPositions.setArm1YAfterTurn(characterArmY)
//        }
//        else if (arm == 2) {
////            setPositions.setArm2XAfterTurn(characterArmX)
////            setPositions.setArm2YAfterTurn(characterArmY)
//
//        }
//        g.fillOval(characterArmX,  characterArmY, 15,15) // Draw a filled circle. Height is top of circle
//     }

}