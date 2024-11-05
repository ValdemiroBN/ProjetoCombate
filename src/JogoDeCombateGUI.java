import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDeCombateGUI extends JFrame {
    JTextArea resultadoArea;
    JTextField nome1Field, ataque1Field, armadura1Field, vida1Field;
    JTextField nome2Field, ataque2Field, armadura2Field, vida2Field;
    JButton iniciarButton;
    int nTurnos = 10;

    public JogoDeCombateGUI() {
        setTitle("Jogo de Combate");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 4));

        inputPanel.add(new JLabel("Nome Campeão 1:"));
        nome1Field = new JTextField(); // Corrigido aqui
        inputPanel.add(nome1Field);

        inputPanel.add(new JLabel("Ataque Campeão 1:"));
        ataque1Field = new JTextField();
        inputPanel.add(ataque1Field);

        inputPanel.add(new JLabel("Armadura Campeão 1:"));
        armadura1Field = new JTextField();
        inputPanel.add(armadura1Field);

        inputPanel.add(new JLabel("Vida Campeão 1:"));
        vida1Field = new JTextField();
        inputPanel.add(vida1Field);

        inputPanel.add(new JLabel("Nome Campeão 2:"));
        nome2Field = new JTextField();
        inputPanel.add(nome2Field);

        inputPanel.add(new JLabel("Ataque Campeão 2:"));
        ataque2Field = new JTextField();
        inputPanel.add(ataque2Field);

        inputPanel.add(new JLabel("Armadura Campeão 2:"));
        armadura2Field = new JTextField();
        inputPanel.add(armadura2Field);

        inputPanel.add(new JLabel("Vida Campeão 2:"));
        vida2Field = new JTextField();
        inputPanel.add(vida2Field);

        add(inputPanel, BorderLayout.NORTH);

        iniciarButton = new JButton("Iniciar Combate");
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarCombate();
            }
        });
        add(iniciarButton, BorderLayout.SOUTH);
    }

    private void iniciarCombate() {
        resultadoArea.setText(""); // Limpar resultados anteriores

        // Criar campeões com os valores inseridos pelo usuário
        Champion campeao1 = new Champion(nome1Field.getText(), Integer.parseInt(ataque1Field.getText()), Integer.parseInt(armadura1Field.getText()), Integer.parseInt(vida1Field.getText()));
        Champion campeao2 = new Champion(nome2Field.getText(), Integer.parseInt(ataque2Field.getText()), Integer.parseInt(armadura2Field.getText()), Integer.parseInt(vida2Field.getText()));

        JogoDeCombate jogo = new JogoDeCombate(campeao1, campeao2, nTurnos);
        resultadoArea.setText(jogo.iniciarCombate());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JogoDeCombateGUI gui = new JogoDeCombateGUI();
                gui.setVisible(true);
            }
        });
    }
}