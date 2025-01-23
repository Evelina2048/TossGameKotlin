//import javax.swing.JPanel
//import javax.swing.ImageIcon
//import java.awt.Graphics
//import java.awt.Image
//import javax.imageio.ImageIO
//import java.io.InputStream
//
//class Ball : JPanel() {
//    private val ball: Image //the image part is the type
//    private val scaledImage: Image
//
//    init {
//        isOpaque = false
//        val inputStream: InputStream? = javaClass.getResourceAsStream("/Ball.png") //? allows null input
//        ball = inputStream?.let { ImageIO.read(it) } ?: throw IllegalArgumentException("Image not found")
//        scaledImage = ball.getScaledInstance(100, 80, Image.SCALE_SMOOTH)
//    }
//
//    // Override paintComponent to draw the image
//    override fun paintComponent(g: Graphics) {
//        super.paintComponent(g)
//        // Draw the image at position (0, 0)
//        g.drawImage(scaledImage, 150, 200, this)
//    }
//}
