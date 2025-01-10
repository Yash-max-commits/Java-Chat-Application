import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.awt.geom.RoundRectangle2D;

public class Server implements ActionListener, KeyListener{
    //Here we don't get any frame bcoz the visibility of frame is by default hidden.

    //now we make constructor.
    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dout;
    public Server(String username){
        f.setLayout(null); //for lay outing the chat box
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(49, 94, 220));// used to set color of the boundaries.
        p1.setBounds(0, 0, 450, 70);// used to place the layout boundaries.
        p1.setLayout(null);
        f.add(p1);
        /* Now we set images in the chat box for selecting images we use image icon class to select the image,
        classloader used to pickup the image from the directory, get-system-resource is method used to pass the image
        address, now the image is inserted but it inserts into the frame of the chat box, but we have to add it to the
        main layout then we use p1.add(back); to add the image into the layout, set-bounds code only runs when the
        set-layout is null. now we make an image class to proper visible of the image so we used i2= i1.getImage and we
        use function getScaledInstance to scale the image. */
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(10, 20, 25, 30);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/download 1.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(270, 20, 30, 30);
        video.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    dout.writeUTF("VIDEO_CALL_REQUEST"); // Send a message to the client to open the video call dialog box
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        p1.add(video);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel call = new JLabel(i12);
        call.setBounds(320, 21, 35, 30);
        p1.add(call);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel dot = new JLabel(i15);
        dot.setBounds(370, 22, 10, 25);
        p1.add(dot);

        JLabel name = new JLabel(username);
        name.setBounds(105, 3, 100 ,45);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(107, 25, 100 ,45);
        status.setFont(new Font("Calibre", Font.BOLD, 10));
        status.setForeground(Color.BLACK);
        p1.add(status);

        a1 =new JPanel();
        a1.setBounds(2, 72, 397, 580);
        f.add(a1);

        text = new JTextField();
        text.addKeyListener(this);
        text.setBounds(2, 655, 290, 40);
        text.setFont(new Font("Serif Plain", Font.PLAIN, 16));
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(295, 655, 103 ,40);
        send.setBackground(new Color(49, 94, 220));
        send.setForeground(Color.BLACK);
        send.addActionListener(this);
        send.setFont(new Font("Serif Plain", Font.BOLD, 15));
        f.add(send);


        f.setSize(400, 700); // define the size of the frame.
        f.setLocation(200, 50);/*define the location of dialogue box opening.
        By default, it opens to left corner of the screen.*/
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.BLACK); // used to define the bgcolor of the chatbox.
        int diameter = 25; // diameter of the rounded corners
        f.setShape(new RoundRectangle2D.Double(0, 0, f.getWidth(), f.getHeight(), diameter, diameter));
        f.setVisible(true);// used to turn on the visibility of the dialogue box
    }

    public void actionPerformed(ActionEvent ae){
        try {
            String out = text.getText();
            JPanel p2 = formatLabel(out);
            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15)); // Strut used to maintain the space b/t two msgs.
            a1.add(vertical, BorderLayout.PAGE_START);
            dout.writeUTF(out);
            text.setText("");
            f.repaint();
            f.invalidate();
            f.validate(); } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String out = text.getText();
            JPanel p2 = formatLabel(out);
            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15)); // Strut used to maintain the space b/t two msgs.
            a1.add(vertical, BorderLayout.PAGE_START);

            // Start of the try-catch block
            try {
                dout.writeUTF(out);
            } catch (IOException ex) {
                System.err.println("Error writing to the output stream: " + ex.getMessage());
                ex.printStackTrace();
            }
            // End of the try-catch block

            text.setText("");
            f.repaint();
            f.invalidate();
            f.validate();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // No need for any action in this method
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No need for any action in this method
    }

    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output = new JLabel("<html><p style=\"width: 150px\">"+ out +"</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 15));
        output.setBackground(new Color(49, 94,220));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output);

        Calendar cal= Calendar.getInstance();
        SimpleDateFormat sdf =new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;

    }
    public static void main(String[] args){
        String username = JOptionPane.showInputDialog(null, "Enter your Username:");
        new Server(username); //Making object in class, for making proper object we write Server s =new Server();.
        try{
            ServerSocket skt = new ServerSocket(200);
            while (true){
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                while (true){
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
