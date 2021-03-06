import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow extends JFrame {

    //Components that we will be added to this window
    private JTextField textFStep = new JTextField("");
    private JTextField textFX0 = new JTextField("");
    private JTextField textFY0 = new JTextField("");
    private JTextField textFXFinal= new JTextField("");
    private JTextField textN0 = new JTextField("");
    private JTextField textNFinal = new JTextField("");
    private JLabel labelStep = new JLabel("Step:");
    private JLabel labelX0 = new JLabel("X0:");
    private JLabel labelY0 = new JLabel("Y0:");
    private JLabel labelXFinal = new JLabel("X(final):");
    private JLabel labelN0 = new JLabel("N0:");
    private JLabel labelNFinal = new JLabel("N(final):");
    private JLabel empty = new JLabel("");
    private JButton build = new JButton("Build");

    public FirstWindow(){
        //Tuning window settings:
        super("FirstWindow");
        this.setBounds(100, 100, 250, 280);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setDefaultButton(build);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 2, 2,2));
        //Adding components into the window:
        container.add(labelStep);
        container.add(textFStep);
        container.add(labelX0);
        container.add(textFX0);
        container.add(labelY0);
        container.add(textFY0);
        container.add(labelXFinal);
        container.add(textFXFinal);
        container.add(labelN0);
        container.add(textN0);
        container.add(labelNFinal);
        container.add(textNFinal);
        container.add(empty);
        container.add(build, BorderLayout.SOUTH);
        //Tuning "build" button settings:
        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "OK";
                //If some box is empty:
                if (textFStep.getText().equals("") | textFX0.getText().equals("") | textFY0.getText().equals("") |
                        textFXFinal.getText().equals("") | textN0.getText().equals("") | textNFinal.getText().equals("")){
                    //If there at least one is empty, then error message:
                    message = "Please, enter all required data";
                    JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.PLAIN_MESSAGE);
                }
                //If each box is filled:
                else{
                    //Check whether format of each one is correct:
                    try{
                        Double.valueOf(textFStep.getText());
                        Double.valueOf(textFX0.getText());
                        Double.valueOf(textFY0.getText());
                        Double.valueOf(textFXFinal.getText());
                        Double.valueOf(textN0.getText());
                        Double.valueOf(textNFinal.getText());
                    //If not, then error message:
                    }catch (java.lang.NumberFormatException e1){
                        message = "Wrong format!";
                        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.PLAIN_MESSAGE);
                    }
                    //If it is, then delete FirstWindow and create Graphs window:
                    if(message.equals("OK")){
                        Graphs graphs = new Graphs(textFStep.getText(), textFX0.getText(), textFY0.getText(),
                                textFXFinal.getText(), textN0.getText(), textNFinal.getText());
                        delete();
                    }
                }
            }
        });
    }

    //Function for deleting current window
    public void delete(){
        this.dispose();
    }
}
