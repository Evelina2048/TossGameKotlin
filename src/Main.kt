import javax.swing.JFrame
import java.awt.Color
import javax.swing.JPanel

val window = JFrame("Toss Game Kotlin")
val backGround = JPanel();

fun main() {
    val window = windowSetup();

    makeCharacter1();
    makeCharacter2();


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

    return window;
}

fun makeCharacter1() {
    //
    val eye1 = Eye()
    //backGround.add(eye1)
//    window.add(backGround)
    window.add(eye1)

    eye1.isVisible = true
    eye1.setBounds(185,140,100,100)
    //eye1.setBounds(0,0,300,300)

//    window.add(eye1)
    //
    val head1 = Head()
    head1.setBounds(100, 100, 100, 100) //x coordinate is for leftmost part of the head1
    head1.isVisible = true
    window.add(head1)
//
    val body1 = Body()
    body1.setBounds(head1.x+(head1.width/2),head1.y+head1.height+10,5,440)
    body1.isVisible = true
    window.add(body1)

    val leg1 = Leg()
//    leg1.setBounds(100,200,900,900)
    leg1.setBounds(head1.x+(head1.width/2)-5,head1.y+head1.height+10+150,300,300)
    leg1.isVisible = true
    //backGround.add(leg1)
    window.add(leg1)

    backGround.background = Color.cyan
    backGround.layout = null
    //backGround.setSize(window.width,window.height)
    backGround.setBounds(0,0,window.width,window.height)
    backGround.isVisible = true

    window.revalidate()
    window.repaint()

//  val otherLeg

}

fun makeCharacter2() {
    val head2 = Head()
    head2.setBounds(window.width-200, 100,100,100) //x coordinate is for leftmost part of the head1
    head2.isVisible = true
    window.add(head2)

    window.revalidate()
    window.repaint()

    val body2 = Body()
    body2.setBounds(head2.x+(head2.width/2),head2.y+head2.height+10,5,440)
    body2.isVisible = true
    window.add(body2)

    window.revalidate()
    window.repaint()
}