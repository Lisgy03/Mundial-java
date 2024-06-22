package Mundial_de_futbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Interfaz {
    private JFrame frame;
    private Mundial mundial;

    private JTextArea resultadosTextArea;

    public Interfaz() {
        mundial = new Mundial();

        frame = new JFrame("Mundial de Fútbol");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(208, 240, 192));
        frame.setLayout(new BorderLayout());

        createEquipoWidgets();

        frame.setVisible(true);
    }

    private void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    private void createEquipoWidgets() {
        clearFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(208, 240, 192));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel imagenLabel = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("/Mundial_de_futbol/balon.png"));
        if (icono != null && icono.getIconWidth() > 0 && icono.getIconHeight() > 0) {
            imagenLabel.setIcon(new ImageIcon(icono.getImage().getScaledInstance(
                    icono.getIconWidth() / 4, icono.getIconHeight() / 4, Image.SCALE_DEFAULT)));
        }
        panel.add(imagenLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 0, 0, 5);

        JLabel labelEquipo1Nombre = new JLabel("Equipo 1 - Nombre:");
        panel.add(labelEquipo1Nombre, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 0);

        JTextField nombreEquipo1Field = new JTextField(20);
        panel.add(nombreEquipo1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 5);

        JLabel labelEntrenador1 = new JLabel("Equipo 1 - Entrenador:");
        panel.add(labelEntrenador1, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);

        JTextField entrenadorEquipo1Field = new JTextField(20);
        panel.add(entrenadorEquipo1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 5);

        JLabel labelEquipo2Nombre = new JLabel("Equipo 2 - Nombre:");
        panel.add(labelEquipo2Nombre, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);

        JTextField nombreEquipo2Field = new JTextField(20);
        panel.add(nombreEquipo2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 5);

        JLabel labelEntrenador2 = new JLabel("Equipo 2 - Entrenador:");
        panel.add(labelEntrenador2, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);

        JTextField entrenadorEquipo2Field = new JTextField(20);
        panel.add(entrenadorEquipo2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);

        JButton registrarEquiposButton = new JButton("Registrar Equipos");
        registrarEquiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEquipo1 = nombreEquipo1Field.getText();
                String entrenador1 = entrenadorEquipo1Field.getText();
                Equipo equipo1 = new Equipo(nombreEquipo1, entrenador1, null);
                mundial.registrarEquipo(equipo1);

                String nombreEquipo2 = nombreEquipo2Field.getText();
                String entrenador2 = entrenadorEquipo2Field.getText();
                Equipo equipo2 = new Equipo(nombreEquipo2, entrenador2, null);
                mundial.registrarEquipo(equipo2);

                JOptionPane.showMessageDialog(frame, String.format("Se han registrado los equipos %s y %s con éxito.",
                        nombreEquipo1, nombreEquipo2), "Equipos Registrados", JOptionPane.INFORMATION_MESSAGE);

                createGrupoWidgets();
            }
        });
        panel.add(registrarEquiposButton, gbc);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
    }

    private void createGrupoWidgets() {
        clearFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(208, 240, 192));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel seleccionaGrupoLabel = new JLabel("Selecciona el Grupo:");
        panel.add(seleccionaGrupoLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;

        String[] grupos = {"A", "B", "C", "D", "E", "F"};
        JComboBox<String> grupoComboBox = new JComboBox<>(grupos);
        panel.add(grupoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);

        JButton registrarGrupoButton = new JButton("Registrar Grupo");
        registrarGrupoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreGrupo = (String) grupoComboBox.getSelectedItem();
                Grupo grupo = new Grupo(nombreGrupo, null);
                mundial.registrarGrupo(grupo);

                JOptionPane.showMessageDialog(frame, String.format("Se ha registrado el grupo %s con éxito.",
                        nombreGrupo), "Grupo Registrado", JOptionPane.INFORMATION_MESSAGE);

                createEstadioWidgets();
            }
        });
        panel.add(registrarGrupoButton, gbc);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
    }

    private void createEstadioWidgets() {
        clearFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(208, 240, 192));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel nombreEstadioLabel = new JLabel("Nombre del Estadio:");
        panel.add(nombreEstadioLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;

        JTextField nombreEstadioField = new JTextField(20);
        panel.add(nombreEstadioField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);

        JLabel ciudadEstadioLabel = new JLabel("Ciudad del Estadio:");
        panel.add(ciudadEstadioLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;

        JTextField ciudadEstadioField = new JTextField(20);
        panel.add(ciudadEstadioField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);

        JButton registrarEstadioButton = new JButton("Registrar Estadio");
        registrarEstadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEstadio = nombreEstadioField.getText();
                String ciudadEstadio = ciudadEstadioField.getText();
                Estadio estadio = new Estadio(nombreEstadio, ciudadEstadio, 50000);
                mundial.registrarEstadio(estadio);

                JOptionPane.showMessageDialog(frame, String.format("Se ha registrado el estadio %s en %s con éxito.",
                        nombreEstadio, ciudadEstadio), "Estadio Registrado", JOptionPane.INFORMATION_MESSAGE);

                createFixtureWidgets();
            }
        });
        panel.add(registrarEstadioButton, gbc);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
    }

    private void createFixtureWidgets() {
        clearFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(208, 240, 192));

        JButton generarFixtureButton = new JButton("Generar Fixture");
        generarFixtureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mundial.generarFixture();
                JOptionPane.showMessageDialog(frame, "Se ha generado el fixture correctamente.",
                        "Fixture Generado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(generarFixtureButton, BorderLayout.NORTH);

        JButton mostrarResultadosButton = new JButton("Mostrar Resultados");
        mostrarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResultados();
            }
        });
        panel.add(mostrarResultadosButton, BorderLayout.SOUTH);

        resultadosTextArea = new JTextArea(10, 40);
        resultadosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadosTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
    }

    private void mostrarResultados() {
        List<Partido> partidos = mundial.getFixture();

        if (partidos.isEmpty()) {
            resultadosTextArea.setText("No hay resultados para mostrar aún.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Resultados del Mundial:\n\n");

        for (Partido partido : partidos) {
            sb.append(partido.getEquipo1().getNombre()).append(" vs ").append(partido.getEquipo2().getNombre());
            sb.append("\nResultado: ").append(partido.mostrarResultado());
            sb.append("\n\n");
        }

        resultadosTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interfaz();
            }
        });
    }
}
