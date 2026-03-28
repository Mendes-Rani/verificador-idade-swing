/** Código representa uma aplicação Swing que calcula a idade de uma pessoa com base no ano de nascimento fornecido pelo usuário.
 * A aplicação também determina se a pessoa tem a obrigação de votar ou se o voto é opcional, com base na idade calculada.
 * O resultado é exibido em dois rótulos: um para a idade e outro para a situação do voto.
 */
package verificadoridadeswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TelaIdade {
    private JTextField txtAno;
    private JButton btnCalc;
    private JLabel lblIdade;
    private JLabel lblSituacao;
    private JPanel telaInic;

    public TelaIdade() {
        LocalDate data = LocalDate.now();

        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ano = Integer.parseInt(txtAno.getText());
                int idade = data.getYear() - ano;
                lblIdade.setText(Integer.toString(idade));
                String sit = ((idade>=16 && idade<18) || (idade>70)) ?"É opcional":"Não é opcional";
                lblSituacao.setText(sit);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaIdade");
        frame.setContentPane(new TelaIdade().telaInic);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
