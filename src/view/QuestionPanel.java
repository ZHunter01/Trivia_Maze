package view;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {

    private JLabel myQuestion;

    public QuestionPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.GREEN);

        myQuestion = new JLabel("This is where the question will show up");
        myQuestion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        myQuestion.setHorizontalAlignment(JLabel.CENTER);
        myQuestion.setVerticalAlignment(JLabel.CENTER);

        add(myQuestion);
    }

    public JLabel getMyQuestion() {
        return myQuestion;
    }

    public void setMyQuestion(JLabel theQuestion) {
        myQuestion = theQuestion;
    }
}
