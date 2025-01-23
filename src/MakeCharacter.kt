//import sun.security.x509.OIDMap.getClass
import java.awt.Color
import javax.swing.JLayeredPane

//import java.awt.Image


class MakeCharacter {
    fun makeCharacter1() {
        //
        val layeredPane = JLayeredPane()
        val eye1 = Eye()
        layeredPane.add(eye1, JLayeredPane.DEFAULT_LAYER)
        //window.add(eye1)
        eye1.isVisible = true
        eye1.setBounds(185,140,100,100)

        print("hello")

        val mouth1 = Mouth()
        layeredPane.add(mouth1, JLayeredPane.PALETTE_LAYER)
//        window.add(mouth1)
        mouth1.isVisible = true
        mouth1.setBounds(140,130,window.width,window.height) //95,90
//
        val head1 = Head()
        head1.setBounds(100, 100, 100, 100) //x coordinate is for leftmost part of the head1
        head1.isVisible = true
        layeredPane.add(head1, JLayeredPane.PALETTE_LAYER)
//        window.add(head1)
//
//        val ball = Ball()
//        ball.setBounds(0, 0, window.width, window.height) //100,80
////      ball.setSize(500,500)
//        ball.isVisible = true
//        layeredPane.add(ball, JLayeredPane.PALETTE_LAYER)
//        window.add(ball)

        val body1 = Body()
        body1.setBounds(head1.x+(head1.width/2),head1.y+head1.height+10,5,440)
        body1.isVisible = true
        layeredPane.add(body1, JLayeredPane.PALETTE_LAYER)
//        window.add(body1)
        layeredPane.setComponentZOrder(body1, 1)

        val arm1 = Arm(100) //body1.x
//      arm1.setBounds(head1.x+(head1.width/2)-5,head1.y+head1.height+10+150,400,400)
        arm1.setBounds(0,0,window.width,window.width) //body1.x
//        arm1.setLocation(0,100) //x 148
        arm1.isVisible = true
//        arm1.translate()
//        window.add(arm1)
//        window.setComponentZOrder(arm1, 0)
        layeredPane.add(arm1, JLayeredPane.DEFAULT_LAYER)
        layeredPane.setComponentZOrder(arm1, 0)

        val leg1 = Leg()
        leg1.setBounds(head1.x+(head1.width/2)-5,head1.y+head1.height+10+150,300,300)
        leg1.isVisible = true
        layeredPane.add(leg1, JLayeredPane.PALETTE_LAYER)
//        window.add(leg1)

        layeredPane.layout = null
        layeredPane.setBounds(0,0,window.width,window.height)
    layeredPane.isVisible = true
        window.add(layeredPane);
//    backGround.background = Color.cyan
//    backGround.layout = null
//    //backGround.setSize(window.width,window.height)
//    backGround.setBounds(0,0,window.width,window.height)
//    backGround.isVisible = true
//        window.add(backGround)
//        backGround.add(arm1);

        window.revalidate()
        window.repaint()


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
}