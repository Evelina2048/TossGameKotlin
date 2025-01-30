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

class Arm(var bodyX: Int, var movable: Boolean ): JPanel() {
    var angleInRadians = 90.0;
    var originalArmX = 0.0;
    var originalArmY = 0.0;
    //
        private var ball: Image //the image part is the type
        private val scaledImage: Image
    //

    init {
            isOpaque = false // Make the panel transparent
        val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png")
        ball = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
        scaledImage = ball.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
        if (movable) {
            background = Color.pink;
            //
//            val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png") //? allows null input
            //
            addMouseMotionListener(object : MouseAdapter() {
                override fun mouseMoved(e: MouseEvent) {
                    print("mouse moved X: " + e.x.toDouble() + " Y: " + e.y.toDouble());

                    val pivotY = 100;

                    val deltaX = e.x.toDouble() - bodyX//pivotX
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

//        else {
//
//        }
    }

    override fun paintComponent(g: Graphics) {

            super.paintComponent(g) // Call to clear the panel properly

            val g2d = g as Graphics2D // Cast to Graphics2D for advanced features

            g2d.color = Color.MAGENTA
            val originalTransform = g2d.transform
            g2d.translate(153, 300)

            g2d.rotate(angleInRadians)

            g2d.fillRect(0, 0, 150, 5) //450 // Coordinates adjusted relative to pivot
        if (movable) {
            g2d.drawImage(scaledImage, 75, -80, this)

            g2d.transform = originalTransform
        }


            g.color = Color.red // Set the drawing color
            g.fillOval(originalArmX.toInt(), originalArmY.toInt(), 15, 15) // Draw a filled circle. Height is top of circle
//        else {
//            val g2d = g as Graphics2D // Cast to Graphics2D for advanced features
//
//            g2d.color = Color.MAGENTA
////            val originalTransform = g2d.transform
////            g2d.translate(153, 300)
////
////            g2d.rotate(angleInRadians)
//
//            //g2d.fillRect(0, 10, 150, 5) //450 // Coordinates adjusted relative to pivot
//        }

//        g2d.drawImage(scaledImage, 250, 200, this)

    }

}