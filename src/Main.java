import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;

public class Main extends JFrame {


    JButton setColor = new JButton("Set Color");
    Color userColor = Color.BLUE;
    JComboBox comboBox = new JComboBox();
    int mouseX;
    int mouseY;
    int size = 150;

    public Main(){
        //setup
        setTitle("Math Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel paintPanel = new JPanel();
        JPanel northPanel = new JPanel();

        //shape choose
        comboBox.addItem("SQUARE");
        comboBox.addItem("RECTANGLE");
        comboBox.addItem("CIRCLE");

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedItem());
            }
        });

        //color select
        setColor.setFocusable(false);
        setColor.setBackground(userColor);
        setColor.addActionListener(e -> setColor());

        comboBox.setFocusable(false);

        northPanel.add(setColor);
        northPanel.add(comboBox);

        //Painting
        paintPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                Graphics g = getGraphics();

                switch (
                        comboBox.getSelectedItem().toString()
                ){
                    case "SQUARE":
                        Square square = new Square(150,150,g);
                        square.c = userColor;
                        square.create(mouseX,mouseY);
                        break;
                    case "RECTANGLE":
                        g.fillRect(mouseX,mouseY,150,50);
                        break;
                    case "CIRCLE":
                        g.fillOval(mouseX,mouseY,150,150);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(paintPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

    }
    void setColor(){
        userColor = JColorChooser.showDialog(this, "Choose Color", userColor);
        setColor.setBackground(userColor);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(userColor);


    }

    public static void main(String[] args) {

        new Main().setVisible(true);
    }
}