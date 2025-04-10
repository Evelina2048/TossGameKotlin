import javax.swing.JPanel
import javax.swing.ImageIcon
import java.awt.Graphics
import java.awt.Image
import javax.imageio.ImageIO
import java.io.InputStream

//import javax.swing.JPanel
//import javax.swing.ImageIcon
//import java.awt.Graphics
//import java.awt.Image
//import javax.imageio.ImageIO
//import java.io.InputStream

class ScreenBackground : JPanel() {
//    private val background: Image //the image part is the type
//    private val scaledImage: Image
//    init {
//        isOpaque = false
//        val inputStream: InputStream? = javaClass.getResourceAsStream("DayBackground.avif") //? allows null input
//        background = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
//        scaledImage = background.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
//    }
//
//    // Override paintComponent to draw the image
//    override fun paintComponent(g: Graphics) {
//        super.paintComponent(g)
//        // Draw the image at position (0, 0)
//        g.drawImage(scaledImage, 0, 0, this)
//    }

    private val dayBackground: Image //the image part is the type
    private val scaledImage: Image

    init {
        isOpaque = false
        val inputStream: InputStream? = javaClass.getResourceAsStream("/DayBackground.jpg") //? allows null input
        dayBackground = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
        scaledImage = dayBackground.getScaledInstance(window.width, window.height, Image.SCALE_SMOOTH)
    }

    // Override paintComponent to draw the image
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        // Draw the image at position (0, 0)
        g.drawImage(scaledImage, 0, 0, this)
    }
}