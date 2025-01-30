import javax.swing.JFrame
import java.awt.Color
import javax.swing.JPanel

val window = JFrame("Toss Game Kotlin")
val backGround = JPanel()

fun main() {
    windowSetup()

    MakeCharacter()
    MakeCharacter().makeCharacter1()
    MakeCharacter().makeCharacter2()


//    val button = JButton("Click Me!")
//    button.setBounds(150, 100, 100, 40) // Set button position and size
//    button.isVisible = true
//    window.add(button)
//
//    // Add action listener to the button
//    button.addActionListener {
//        val windBounds = window.getBounds()
//        JOptionPane.showMessageDialog(window, windBounds)
//    }
}

fun windowSetup() : JFrame {
    window.setSize(966,685)
    window.isVisible = true
    window.layout = null
    window.background = Color.orange

    window.revalidate()
    window.repaint()

    return window
}