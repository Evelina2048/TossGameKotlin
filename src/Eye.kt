import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class Eye : JPanel() {
    init {
        isOpaque = false // Make the panel transparent
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.color = Color.GREEN // Set the drawing color
        g.fillOval(0, 0, 15, 15) // Draw a filled circle. Height is top of circle
    }
}