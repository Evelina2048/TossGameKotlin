import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class Mouth(var mouthStartAngle: Int, var mouthArcAngle: Int) : JPanel() {
    init {
        isOpaque = false // Make the panel transparent
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2d = g as Graphics2D // Cast to Graphics2D for advanced features
        g2d.color = Color.GREEN // Set the drawing color
//        g.fillOval(0, 0, 15, 15) // Draw a filled circle. Height is top of circle
        g2d.drawArc(0, 0, 100, 50, mouthStartAngle,mouthArcAngle) //180,90
//        g2d.rotate(Math.toDegrees(180.0), -5.0, 40.0)
    }
}