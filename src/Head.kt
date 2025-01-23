import java.awt.Graphics
import java.awt.Color
import javax.swing.JPanel

class Head : JPanel() {
    init {
        isOpaque = false // Make the panel transparent
    }
    // Override the paintComponent method
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.color = Color.DARK_GRAY // Set the drawing color
        g.fillOval(0, 0, 100, 100) // Draw a filled circle. Height is top of circle
    }
}