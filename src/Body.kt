import java.awt.Graphics
import java.awt.Color
import javax.swing.JPanel

class Body : JPanel() {
    init {
        isOpaque = false // Make the panel transparent
    }

    // Override the paintComponent method
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g) // Call the superclass to clear the panel
        g.color = Color.PINK // Set the drawing color Color.DARK_GRAY
        g.fillRect(0,0,5,450) //50,300
    }
}