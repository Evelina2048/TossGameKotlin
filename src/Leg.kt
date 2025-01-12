import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import javax.swing.SwingUtilities

class Leg : JPanel() {
    override fun paintComponent(g: Graphics) {
//        val g = g as Graphics2D
//        g.color = Color.BLUE // Set the drawing color
//        g.rotate(Math.toDegrees(70.0),100.0, 100.0)
//        g.fillRect(0,0,5,450)
            // Code to update the UI
            super.paintComponent(g) // Call to clear the panel properly

            val g2d = g as Graphics2D // Cast to Graphics2D for advanced features

            // Save the original transform
            //val originalTransform = g2d.transform

            // Set the drawing color
            g2d.color = Color.BLUE

            // Rotate the coordinate system (around the pivot point)
            g2d.rotate(Math.toDegrees(90.0), 80.0, 225.0)

            // Draw the rectangle after applying rotation
            g2d.fillRect(0,200, 250, 5) //450 // Coordinates adjusted relative to pivot
    }

        // Restore the original transform
        //g2d.transform = originalTransform
    }