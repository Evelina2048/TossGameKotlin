import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel

class Arm : JPanel() {
    init {
        isOpaque = false // Make the panel transparent

        addMouseMotionListener(object: MouseAdapter() {
            override fun mouseMoved(e: MouseEvent?) {
//                super.mouseMoved(e)
                print("mouse moved")
            }
        })
    }
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g) // Call to clear the panel properly

        val g2d = g as Graphics2D // Cast to Graphics2D for advanced features

        g2d.color = Color.MAGENTA

//        g2d.rotate(Math.toDegrees(90.0), 80.0, 100.0)

        g2d.fillRect(0,200, 150, 5) //450 // Coordinates adjusted relative to pivot
    }

}