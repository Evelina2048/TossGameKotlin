import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Color
import javax.swing.JPanel

class Grass : JPanel() {
    init {
        isOpaque = false // Make the panel transparent
    }

    // Override the paintComponent method
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g) // Call the superclass to clear the panel

        val g2d = g as Graphics2D

        g2d.color = Color.decode("#61921f") // #2baa36
//        g2d.rotate(Math.toDegrees(90.0),80.0, 80.0)
        g2d.fillRect(0,window.height-50,window.width,25) //50,300
//        g2d.rotate(Math.toDegrees(degrees), 80.0, 225.0)
    }
}