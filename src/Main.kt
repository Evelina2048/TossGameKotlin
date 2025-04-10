import javax.swing.JFrame
import java.awt.Color
import javax.swing.JPanel

val window = JFrame("Toss Game Kotlin")
val backGround = JPanel()

fun main() {
    windowSetup()

    val makeCharacter = MakeCharacter()
//    makeCharacter.addGrass()
    makeCharacter.makeCharacter1()
    makeCharacter.makeCharacter2()
    makeCharacter.addGrass()

    window.revalidate()
    window.repaint()



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

//    val screenBackground = ScreenBackground();
//    screenBackground.setBounds(0,0,window.width,window.width) //body1.x
//    screenBackground.isVisible = true
//    window.contentPane.add(screenBackground)

    window.revalidate()
    window.repaint()

    return window
}