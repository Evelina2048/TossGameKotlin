//import java.awt.Graphics
//import java.awt.Color
//import javax.swing.JPanel
//import javax.swing.JLabel
//import javax.swing.ImageIcon
//
//private val image = ImageIcon("Ball.png").image
////private val image = ImageIcon(javaClass.getResource("/Ball.png")).image
//
//class Ball : JPanel() {
//    // Override the paintComponent method
//
//    init {
//        val icon = ImageIcon("Ball.png")
//        val label = JLabel(icon) // Use constructor to set the icon directly
//        this.add(label) // Add label to the JPanel itself, not `window`
//    }
//    override fun paintComponent(g: Graphics) {
//        super.paintComponent(g)
////        g.color = Color.DARK_GRAY // Set the drawing color
////      g.fillOval(0, 30, 500, 500) // Draw a filled circle. Height is top of circle
////     g.drawImage(image, 0, 30, 500, 500, this) //"this" puts jpanel as observor, to make sure of proper rendering
//    }
//
////    Image(500,500);
//}
import javax.swing.JPanel
import javax.swing.ImageIcon
import java.awt.Graphics
import java.awt.Image
import javax.imageio.ImageIO
import java.io.InputStream

class Ball : JPanel() {
    private val ball: Image //the image part is the type
    private val scaledImage: Image

    init {
        isOpaque = false
        val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png") //? allows null input
        ball = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
        scaledImage = ball.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
    }

    // Override paintComponent to draw the image
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        // Draw the image at position (0, 0)
        g.drawImage(scaledImage, 150, 200, this)
    }
}
