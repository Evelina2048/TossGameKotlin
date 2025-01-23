import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class Leg : JPanel() {
    init {
        isOpaque = false // Make the panel transparent
    }
    override fun paintComponent(g: Graphics) {
            super.paintComponent(g) // Call to clear the panel properly

            val g2d = g as Graphics2D // Cast to Graphics2D for advanced features

            g2d.color = Color.BLUE

            g2d.rotate(Math.toDegrees(90.0), 80.0, 225.0)

            g2d.fillRect(0,200, 250, 5) //450 // Coordinates adjusted relative to pivot
    }
    }