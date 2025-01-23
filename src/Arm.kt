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

class Arm(var bodyX: Int) : JPanel() {
    var angleInRadians = 90.0;
    //
    private val ball: Image //the image part is the type
    private val scaledImage: Image
    //

    init {
        isOpaque = false // Make the panel transparent
        background = Color.pink;
        //
        val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png") //? allows null input
        ball = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
        scaledImage = ball.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
        //
        addMouseMotionListener(object: MouseAdapter() {
            override fun mouseMoved(e: MouseEvent) {
                print("mouse moved X: "+e.x.toDouble() +" Y: "+e.y.toDouble());

                val pivotY= 100;

                val deltaX = e.x.toDouble() - bodyX//pivotX
                val deltaY = e.y.toDouble() - pivotY

                // Calculate angle in radians
                if (e.x.toDouble() < (bodyX.toDouble()-150)) {
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

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g) // Call to clear the panel properly

        val g2d = g as Graphics2D // Cast to Graphics2D for advanced features

        g2d.color = Color.MAGENTA
        val originalTransform = g2d.transform
        g2d.translate(153,300)

        g2d.rotate(angleInRadians)

        g2d.fillRect(0,0, 150, 5) //450 // Coordinates adjusted relative to pivot

        g2d.drawImage(scaledImage, 75, -80, this) //250,200

        g2d.transform = originalTransform

//        g2d.drawImage(scaledImage, 250, 200, this)

    }

}