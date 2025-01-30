//import sun.security.x509.OIDMap.getClass
import java.awt.Color
import javax.swing.JLayeredPane

//import java.awt.Image


class MakeCharacter {
    val layeredPane = JLayeredPane()
    var originalArmX = 0;
    var originalArmY = 0;
    init {
        layeredPane.layout = null
        layeredPane.setBounds(0,0,window.width,window.height)
        layeredPane.background = Color.black
        layeredPane.isVisible = true
        window.add(layeredPane);
    }
    val layeredPane2 = JLayeredPane()
    fun makeCharacter1() {
        //
//        val layeredPane = JLayeredPane()
        val eye1 = Eye()
        layeredPane.add(eye1, JLayeredPane.DEFAULT_LAYER)
        //window.add(eye1)
        eye1.isVisible = true
        eye1.setBounds(185,140,100,100)

        print("hello")

        val mouth1 = Mouth(180,90)
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
        body1.setBounds(head1.x+(head1.width/2),head1.y+head1.height,5,440)
        body1.isVisible = true
        layeredPane.add(body1, JLayeredPane.PALETTE_LAYER)
//        window.add(body1)
        layeredPane.setComponentZOrder(body1, 1)

        val arm1 = Arm(100, movable = true) //body1.x
        arm1.setBounds(0,0,window.width,window.width) //body1.x
        arm1.isVisible = true
        layeredPane.add(arm1, JLayeredPane.DEFAULT_LAYER)
        layeredPane.setComponentZOrder(arm1, 0)

        val leg1 = Leg(90.0)
        leg1.setBounds(head1.x+(head1.width/2)-5,head1.y+head1.height+10+150,300,300)
        leg1.isVisible = true
        layeredPane.add(leg1, JLayeredPane.PALETTE_LAYER)
//        window.add(leg1)

//        layeredPane.layout = null
//        layeredPane.setBounds(0,0,window.width,window.height)
//        layeredPane.background = Color.black
//        layeredPane.isVisible = true
//        window.add(layeredPane);

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
        val eye2 = Eye()
        //layeredPane.add(eye2, JLayeredPane.DEFAULT_LAYER)
        layeredPane.add(eye2, JLayeredPane.DEFAULT_LAYER)
//        window.add(eye2)
        eye2.isVisible = true
        eye2.setBounds(785,140,100,100)

        val mouth2 = Mouth(0,-90)
        layeredPane.add(mouth2, JLayeredPane.DEFAULT_LAYER)
//        window.add(mouth2)
//        window.add(mouth1)
        mouth2.isVisible = true
        mouth2.setBounds(eye2.x-55,135,window.width,window.height) //95,90

        val head2 = Head()
        head2.setBounds(window.width-200, 100,100,100) //x coordinate is for leftmost part of the head1
        head2.isVisible = true
//        window.add(head2)
        layeredPane.add(head2, JLayeredPane.PALETTE_LAYER)

        val body2 = Body()
        body2.setBounds(head2.x+(head2.width/2),head2.y+head2.height,5,440)
        body2.isVisible = true
        layeredPane.add(body2, JLayeredPane.PALETTE_LAYER)
        layeredPane.setComponentZOrder(body2, 1)
//        window.add(body2)

        val leg2 = Leg(-90.0)
        leg2.setBounds(head2.x-(head2.width/2)-23,head2.y+head2.height+70,400,400) //300,300
        leg2.isVisible = true
        window.add(leg2)

        val arm2 = Arm(100, movable = false) //body1.x
        arm2.setBounds(body2.x-149,0,window.width,window.width) //0,0
        arm2.isVisible = true
//        window.add(arm2)
        layeredPane.add(arm2, JLayeredPane.DEFAULT_LAYER)
        layeredPane.setComponentZOrder(arm2, 0)
//        layeredPane.add(arm2, JLayeredPane.DEFAULT_LAYER)
//        layeredPane.setComponentZOrder(arm2, 0)



        window.revalidate()
        window.repaint()
    }
}