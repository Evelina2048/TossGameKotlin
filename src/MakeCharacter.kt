import java.awt.Color
import javax.swing.JLayeredPane

class MakeCharacter {
    private var layeredPane = JLayeredPane().apply {
        layout = null
        setBounds(0,0,window.width,window.height)
        background = Color.black
        isVisible = true

    }
    var originalArmX = 0;
    var originalArmY = 0;
    init {
    }
//    val setPositions = SetPositions.getInstance();

    fun makeCharacter1() {
        val eye1 = Eye()
        layeredPane.add(eye1, JLayeredPane.DEFAULT_LAYER)
        //window.add(eye1)
        eye1.isVisible = true
        eye1.setBounds(185,140,100,100)

        val mouth1 = Mouth(180,90)
        layeredPane.add(mouth1, JLayeredPane.DEFAULT_LAYER)

        mouth1.isVisible = true
        mouth1.setBounds(140,130,window.width,window.height) //95,90

        val head1 = Head()
        head1.setBounds(100, 100, 100, 100) //x coordinate is for leftmost part of the head1
        head1.isVisible = true
        layeredPane.add(head1, JLayeredPane.PALETTE_LAYER)

        val body1 = Body()
        body1.setBounds(head1.x+(head1.width/2),head1.y+head1.height,5,440)
        body1.isVisible = true
        layeredPane.add(body1, JLayeredPane.PALETTE_LAYER)

        layeredPane.setComponentZOrder(body1, 1)

        val arm1 = Arm(100, movable = true, 1) //body1.x
        arm1.setBounds(0,0,window.width,window.width) //body1.x
        arm1.isVisible = true
        layeredPane.add(arm1, JLayeredPane.DEFAULT_LAYER)
        layeredPane.setComponentZOrder(arm1, 0)

        val leg1 = Leg(90.0)
        leg1.setBounds(head1.x+(head1.width/2)-5,head1.y+head1.height+10+150,300,300)
        leg1.isVisible = true
        layeredPane.add(leg1, JLayeredPane.PALETTE_LAYER)

        window.contentPane.add(layeredPane);
        window.revalidate()
        window.repaint()


    }

    fun makeCharacter2() {
        val eye2 = Eye()
        layeredPane.add(eye2, JLayeredPane.DEFAULT_LAYER)
        eye2.isVisible = true
        eye2.setBounds(785,140,100,100)

        val mouth2 = Mouth(0,-90)
        layeredPane.add(mouth2, JLayeredPane.DEFAULT_LAYER)
        layeredPane.setComponentZOrder(mouth2, 1)
        mouth2.isVisible = true
        mouth2.setBounds(eye2.x-55,135,window.width,window.height) //95,90

        val head2 = Head()
        head2.setBounds(window.width-200, 100,100,100) //x coordinate is for leftmost part of the head1
        head2.isVisible = true
        layeredPane.add(head2, JLayeredPane.PALETTE_LAYER)

        val body2 = Body()
        body2.setBounds(head2.x+(head2.width/2),head2.y+head2.height,5,440)
        body2.isVisible = true
        layeredPane.add(body2, JLayeredPane.PALETTE_LAYER)
        layeredPane.setComponentZOrder(body2, 1)

        val leg2 = Leg(-90.0)
        leg2.setBounds(head2.x-(head2.width/2)-23,head2.y+head2.height+70,400,400) //300,300
        leg2.isVisible = true
        layeredPane.add(leg2, JLayeredPane.PALETTE_LAYER)
        layeredPane.setComponentZOrder(leg2, 0)

        val arm2 = Arm(100, movable = false, 2) //body1.x
        arm2.setBounds(body2.x-149,0,window.width,window.width) //0,0
        arm2.isVisible = true

        layeredPane.add(arm2, JLayeredPane.DEFAULT_LAYER)
//        layeredPane.setComponentZOrder(arm2, 0)

        layeredPane.add(makeBackground())

        window.contentPane.add(layeredPane);

        window.revalidate()
        window.repaint()
    }

    private fun makeBackground(): ScreenBackground {
        val screenBackground = ScreenBackground();
        screenBackground.setBounds(0,0,window.width,window.width) //body1.x
        screenBackground.isVisible = true
        return screenBackground
    }
    fun addGrass() {
        println("hello friends")
        val grass = Grass() //body1.x
        grass.setBounds(0,0,window.width,window.width) //0,0
        grass.isVisible = true
        layeredPane.add(grass, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setComponentZOrder(grass, 1) //4, changed to 1 on 4/9 to cover leg
//
//        return grass

    }
}