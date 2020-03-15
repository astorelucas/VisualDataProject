package lucastorie;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.core.PApplet;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Canvas;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField pathImageF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\JavaIO\\icone.png"));
					frame.setTitle("Visual Data");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_17 = new JPanel();
		tabbedPane.addTab("Sobre", null, panel_17, null);
		
		JTextArea txtrVisualData = new JTextArea();
		txtrVisualData.setText("Visual Data é uma ferramenta computacional que permite\r\na criação de gráficos para análise visual de rede sociais,\r\nem especial Twitter.\r\n\r\nDesenvolvedor:\r\nLucas Malacarne Astore - astore.lucas@gmail.com\r\nOrientador:\r\nPatrick Marques Ciarelli - patrick.ciarelli@ufes.br\r\n\r\nUniversidade Federal do Espírito Santo\r\nCentro Técnológico\r\nDepartamento de Engenharia Elétrica");
		txtrVisualData.setForeground(Color.BLACK);
		txtrVisualData.setEditable(false);
		txtrVisualData.setBackground(new Color(220, 220, 220));
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(98)
					.addComponent(txtrVisualData, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_panel_17.setVerticalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(54)
					.addComponent(txtrVisualData, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		panel_17.setLayout(gl_panel_17);
		
		JPanel panel_14 = new JPanel();
		tabbedPane.addTab("Análise textual\r\n", null, panel_14, null);
		final JTextArea textArea_5 = new JTextArea();
		

		textArea_5.setText("Nenhum arquivo escolhido");
		
		JButton btnAnexarTweets_4 = new JButton("Anexar texto");
		btnAnexarTweets_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheTweetsFile();
					textArea_5.setText(theName);
					
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JLabel label_5 = new JLabel("");
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		

		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_14.createSequentialGroup()
							.addContainerGap(182, Short.MAX_VALUE)
							.addComponent(label_5)
							.addGap(401))
						.addGroup(gl_panel_14.createSequentialGroup()
							.addGap(21)
							.addComponent(btnAnexarTweets_4)
							.addGap(32)
							.addComponent(textArea_5, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(63))
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_6, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnexarTweets_4)
						.addComponent(textArea_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tabbedPane_6, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label_5)
					.addGap(378))
		);
		
		JPanel panel_16 = new JPanel();
		tabbedPane_6.addTab("N-gram", null, panel_16, null);
		
		JLabel lblFrequnciaDeCorte = new JLabel("Frequência de corte:");
		
		final JSpinner freq_corte = new JSpinner();
		
		JLabel lblNewLabel = new JLabel("Insira valor de N:");
		
		final JSpinner value_N = new JSpinner();
		
		JButton btnNewButton_4 = new JButton("?");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String message = "O valor de N define a quantidade de palavras dos conjuntos buscados.\n"
						+ "Por exemplo:\n "
						+ "Para N=2 -> 'amo vegetais'\n"
						+ "Para N=3 -> 'eu amo vegetais'\n"
						+ "Para N=4 -> 'eu amo vegetais verdes'\n"
						+ "Etc.\n";
				
				JOptionPane.showMessageDialog(null, message);
			}
		});
		
		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String message = "O valor da frequência de corte define a quantidade mínima de vezes citado.\n"
						+ "- 0 não elimina nada\n"
						+ "- 1 elimina as frequências menores que 1\n"
						+ "- 2 elimina as frequências menores que 2\n"
						+ "e assim por diante.";
				
				JOptionPane.showMessageDialog(null, message);
			}
		});
		
		JButton button_1 = new JButton("Help");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "\"N-grams: Conta conjuntos de palavras ou termos nos textos.\n"
						+ "Retorna lista de ngrams e frequência.\n";
				
				JOptionPane.showMessageDialog(null, message);
				
			}
		});
		
		JButton btnGerarNgram = new JButton("Gerar N-gram");
		btnGerarNgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int N = (Integer) value_N.getValue();
				
				int FC = (Integer) freq_corte.getValue();
				
				String in = FileOpener.fileName;
								
				String out0 = FileOpener.fileName;
				
				int pos = out0.lastIndexOf("\\");
				
				String out1 = out0.substring(0,pos+1);
				
				out1 = out1.concat("resultado-ngram.txt");
				
				TextualAnalysis.nGrams(in,out1,N,FC);
				
			}
		});
		
		
		final JTextArea textArea_10 = new JTextArea();
		textArea_10.setText("Nenhum arquivo escolhido");
		
		JButton btnAnexarNgram = new JButton("Anexar N-gram");
		btnAnexarNgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheTweetsFile();
					textArea_10.setText(theName);
					
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnGerarGrfico_6 = new JButton("Gerar gráfico");
		btnGerarGrfico_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nGram = FileOpener.fileName;
				
				ArrayList<String> ngramResult = DataEntry.dataEntry(nGram);
				
				try {
					GraphicsTA.createBarNgram(ngramResult);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		GroupLayout gl_panel_16 = new GroupLayout(panel_16);
		gl_panel_16.setHorizontalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addGap(251)
					.addComponent(btnGerarNgram)
					.addContainerGap(273, Short.MAX_VALUE))
				.addGroup(gl_panel_16.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_16.createSequentialGroup()
							.addComponent(btnAnexarNgram)
							.addGap(18)
							.addComponent(textArea_10, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
						.addGroup(gl_panel_16.createSequentialGroup()
							.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFrequnciaDeCorte)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING, false)
								.addComponent(freq_corte)
								.addComponent(value_N, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(54))
				.addGroup(gl_panel_16.createSequentialGroup()
					.addGap(253)
					.addComponent(btnGerarGrfico_6)
					.addContainerGap(273, Short.MAX_VALUE))
		);
		gl_panel_16.setVerticalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_16.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel_16.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_4)
								.addComponent(value_N, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_panel_16.createParallelGroup(Alignment.BASELINE)
								.addComponent(freq_corte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button)
								.addComponent(lblFrequnciaDeCorte))
							.addGap(26)
							.addComponent(btnGerarNgram))
						.addGroup(gl_panel_16.createSequentialGroup()
							.addGap(22)
							.addComponent(button_1)))
					.addGap(28)
					.addGroup(gl_panel_16.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAnexarNgram)
						.addComponent(textArea_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico_6)
					.addGap(31))
		);
		panel_16.setLayout(gl_panel_16);
		
		JPanel panel_18 = new JPanel();
		tabbedPane_6.addTab("Confiança/Abrangência", null, panel_18, null);
		
		final JTextArea txtrCampoOpicioanl = new JTextArea();
		txtrCampoOpicioanl.setText("Campo Opicioanl");
		
		JButton btnAnexarClasses = new JButton("Anexar Classes");
		btnAnexarClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					txtrCampoOpicioanl.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				
			}
		});
		
		
		
		JButton btnHelp_1 = new JButton("Help");
		btnHelp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String message = "Para avaliar várias combinações de termos que tenham uma frequencia minima no texto.\n"
						+ "threshold é a frequencia minima, entre 0 e 1 (0 e 100%).\n"
						+ "Retorna a confiança e a abrangência dos termos.\\n";
				
				JOptionPane.showMessageDialog(null, message);
				
				
			}
		});
		
		JLabel lblConfi = new JLabel("Frequência mínima:");
		
		final JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
		
		JButton btnNewButton_5 = new JButton("Gerar resultado");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float Nfreq = (Float) spinner_5.getValue();
				
				String cla = FileOpener.fileNameCat;
				
				String in = FileOpener.fileName;
								
				String out0 = FileOpener.fileName;
				
				int pos = out0.lastIndexOf("\\");
				
				String out1 = out0.substring(0,pos+1);
				
				out1 = out1.concat("Confianca_Abrangencia_Resultado.txt");
				
				TextualAnalysis.AW(in, cla, out1, Nfreq);
				
				
			}
		});
		
		JLabel label_1 = new JLabel("%");
		
		JButton btnResultado = new JButton("Resultado");
		final JTextArea textArea_12 = new JTextArea();
		textArea_12.setText("Nenhum arquivo escolhido");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_12.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				
				
			}
		});
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Confiança maior que:\r\n");
		
		final JSpinner spinner_6 = new JSpinner();
		final JSpinner spinner_7 = new JSpinner();
		JLabel label_6 = new JLabel("%");
		
		JButton btnGerarGrfico_9 = new JButton("Gerar gráfico");
		btnGerarGrfico_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String resultado = FileOpener.fileNameCat;
				
				ArrayList<String> in = DataEntry.dataEntry(resultado);
				
				int setco = (Integer) spinner_6.getValue();
				
				int setab = (Integer) spinner_7.getValue();
				
				GraphicsTA.createBarCA(in,setco,setab);
				
			}
		});
		
		JLabel lblAbrangnciaMaiorQue = new JLabel("Abrangência maior que:");
		

		
		JLabel label_7 = new JLabel("%");
		GroupLayout gl_panel_18 = new GroupLayout(panel_18);
		gl_panel_18.setHorizontalGroup(
			gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
						.addComponent(btnResultado)
						.addGroup(gl_panel_18.createSequentialGroup()
							.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAnexarClasses)
								.addComponent(lblConfi))
							.addGap(18)
							.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_18.createSequentialGroup()
									.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_1))
								.addComponent(txtrCampoOpicioanl, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
								.addComponent(textArea_12)))
						.addGroup(gl_panel_18.createSequentialGroup()
							.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAbrangnciaMaiorQue)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinner_7)
								.addComponent(spinner_6, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))))
					.addGap(111))
				.addGroup(Alignment.TRAILING, gl_panel_18.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGerarGrfico_9)
						.addComponent(btnNewButton_5))
					.addGap(142)
					.addComponent(btnHelp_1)
					.addGap(36))
		);
		gl_panel_18.setVerticalGroup(
			gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnexarClasses)
						.addComponent(txtrCampoOpicioanl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfi)
						.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(14)
					.addComponent(btnNewButton_5)
					.addGap(35)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnResultado)
						.addComponent(textArea_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addGap(18)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbrangnciaMaiorQue)
						.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_18.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHelp_1)
						.addComponent(btnGerarGrfico_9))
					.addGap(28))
		);
		panel_18.setLayout(gl_panel_18);
		
		JPanel panel_15 = new JPanel();
		tabbedPane_6.addTab("Regras\r\n", null, panel_15, null);
		
		JTabbedPane tabbedPane_7 = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_15 = new GroupLayout(panel_15);
		gl_panel_15.setHorizontalGroup(
			gl_panel_15.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_7, GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
		);
		gl_panel_15.setVerticalGroup(
			gl_panel_15.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_7, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
		);
		
		JPanel panel_19 = new JPanel();
		tabbedPane_7.addTab("1º Passo: Obtenção de Regras", null, panel_19, null);
		
		final JTextArea textArea_14 = new JTextArea();
		textArea_14.setText("Nenhum arquivo escolhido");
		
		JLabel lblAnexarTextosClassificados = new JLabel("Anexar textos classificados para treinamento:");
		
		JButton btnNewButton_6 = new JButton("Texto classificados\r\n");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheTweetsFile();
					textArea_14.setText(theName);
					
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
	
		
		JLabel lblAnexarClasses = new JLabel("Anexar classes:");
		final JTextArea textArea_15 = new JTextArea();
		textArea_15.setText("Nenhum arquivo escolhido");
		
		JButton btnClasses = new JButton("Classes");
		btnClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_15.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				
			}
		});
		
		
		
		JButton button_4 = new JButton("?");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String message = "Atenção!\n"
						+ "Neste 1º Passo, insira os tweets que serão usados para treinamento\n"
						+ "Não anexe os dados completos no topo da página. Ele será usado no 2º passo.";
				
				JOptionPane.showMessageDialog(null, message);
				
				
			}
		});
		
		JButton button_5 = new JButton("?");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String message = "Anexe aqui os classes/categorias na ordem dos tweets\n"
						+ "Este arquivo deve contém as categorias dos tweets listadas\n"
						+ "na mesma ordem dos tweets do arquivo adicionado anteriormente.";
				
				JOptionPane.showMessageDialog(null, message);
				
			}
		});
		
		JLabel lblEscolhaUmaDas = new JLabel("Escolha uma das opções:");
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Simples", "Canônico", "Canônico - Filtro"}));
		
		JButton btnNewButton_7 = new JButton("Obter regras");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cla = FileOpener.fileNameCat;
				
				String in = FileOpener.fileName;
				

				int value = (Integer) comboBox_3.getSelectedIndex();
				
				//simples
				if(value == 0 || value == -1 ) {
										
				TextualAnalysis.obterRegras(in, cla);
				}
				
				//canonico
				if(value == 1) {
					TextualAnalysis.obterRegrasCanonino(in, cla);
					
				}
				
				//canonico-filtro
				if(value == 2) {
					
					TextualAnalysis.obterRegrasCanoninoFiltro(in, cla);
					
				}
				
				
				
			}
		});
		
		JButton button_6 = new JButton("?");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String message = "Todas opções obtém regras de classificação!\n"+
						"Simples: Processa o texto. \n" + 
						"Canonino: Usa palavras em forma canonica.\n" + 
						"CanoninoFiltro: Usa palavras em forma canonica e filtra as palavras pelas classes gramaticais substantivo, adjetivo, adverbio e verbo.\n"
						+ "Todas opções retornam uma lista de regras que devem ser seguidas na sequências indicada.";
				
				JOptionPane.showMessageDialog(null, message);
				
				
				
			}
		});
		GroupLayout gl_panel_19 = new GroupLayout(panel_19);
		gl_panel_19.setHorizontalGroup(
			gl_panel_19.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_19.createSequentialGroup()
							.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_19.createSequentialGroup()
									.addComponent(button_6)
									.addGap(31)
									.addComponent(lblEscolhaUmaDas))
								.addComponent(btnNewButton_6))
							.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_19.createSequentialGroup()
									.addGap(52)
									.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_7)
										.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_19.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea_15, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
										.addComponent(textArea_14, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)))))
						.addGroup(gl_panel_19.createSequentialGroup()
							.addComponent(button_4)
							.addGap(31)
							.addComponent(lblAnexarTextosClassificados))
						.addGroup(gl_panel_19.createSequentialGroup()
							.addComponent(button_5)
							.addGap(34)
							.addComponent(lblAnexarClasses))
						.addComponent(btnClasses))
					.addContainerGap())
		);
		gl_panel_19.setVerticalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4)
						.addComponent(lblAnexarTextosClassificados))
					.addGap(18)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_6)
						.addComponent(textArea_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_5)
						.addComponent(lblAnexarClasses))
					.addGap(18)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClasses)
						.addComponent(textArea_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_6)
						.addComponent(lblEscolhaUmaDas)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnNewButton_7)
					.addGap(24))
		);
		panel_19.setLayout(gl_panel_19);
		
		JPanel panel_23 = new JPanel();
		tabbedPane_7.addTab("2º Passo: Aplicação e Representação", null, panel_23, null);
		
		JLabel lblAnexarRegras = new JLabel("Anexar Regras:");
		final JTextArea textArea_16 = new JTextArea();
		textArea_16.setText("Nenhum arquivo escolhido");
		
		JButton btnNewButton_8 = new JButton("Regras");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_16.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				
				
			}
		});
		
	
		
		JButton btnAplicarRegras = new JButton("Aplicar regras");
		btnAplicarRegras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String regras = FileOpener.fileNameCat;
				
				String in = FileOpener.fileName;
				
				TextualAnalysis.aplicarRegras(in,regras);
				
				
			}
		});
		
		JLabel lblAnexarResultado = new JLabel("Anexar Resultado:");
		
		JButton btnR = new JButton("Resultado Regras");
		final JTextArea textArea_17 = new JTextArea();
		textArea_17.setText("Nenhum arquivo escolhido");
		
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_17.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		
		JButton btnGerarGrfico_7 = new JButton("Gerar gráfico");
		btnGerarGrfico_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filein = FileOpener.fileNameCat;
				
				ArrayList<String> in = DataEntry.dataEntry(filein);
				
				try {
					GraphicsTA.createBarRegras(in);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_23 = new GroupLayout(panel_23);
		gl_panel_23.setHorizontalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_23.createSequentialGroup()
					.addContainerGap(265, Short.MAX_VALUE)
					.addComponent(btnAplicarRegras)
					.addGap(262))
				.addGroup(gl_panel_23.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_23.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_23.createSequentialGroup()
							.addComponent(btnR)
							.addGap(18)
							.addComponent(textArea_17))
						.addComponent(lblAnexarResultado)
						.addGroup(gl_panel_23.createSequentialGroup()
							.addComponent(btnNewButton_8)
							.addGap(18)
							.addComponent(textArea_16, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAnexarRegras))
					.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_23.createSequentialGroup()
					.addContainerGap(273, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico_7)
					.addGap(264))
		);
		gl_panel_23.setVerticalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_23.createSequentialGroup()
					.addGap(44)
					.addComponent(lblAnexarRegras)
					.addGap(18)
					.addGroup(gl_panel_23.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_8)
						.addComponent(textArea_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnAplicarRegras)
					.addGap(29)
					.addComponent(lblAnexarResultado)
					.addGap(18)
					.addGroup(gl_panel_23.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnR)
						.addComponent(textArea_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnGerarGrfico_7)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		panel_23.setLayout(gl_panel_23);
		panel_15.setLayout(gl_panel_15);
		panel_14.setLayout(gl_panel_14);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Geolocalização\r\n", null, panel, null);
		
		final JTextArea textArea = new JTextArea();
		
				final JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Leaflet", "Microsoft"}));
				
				textArea.setText("Nenhum arquivo escolhido");
				
				JButton btnAnexarTweets_1 = new JButton("Anexar tweets");
				btnAnexarTweets_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String theName = new String();
						
						try {
							theName = FileOpener.pickTheTweetsFile();
							textArea.setText(theName);
						//	
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						
					}
				});
				
				textArea.setEditable(false);
				
				JButton btnGerarGrfico_3 = new JButton("Gerar gráfico");
				btnGerarGrfico_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String fileTweetsName = FileOpener.fileName;
						
						ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
						
						int value = (Integer) comboBox_2.getSelectedIndex();
						
						HelloMap.mapChooser = value;
						
						System.out.println(HelloMap.mapChooser);
						
						HelloMap.createMapData(theTweets);

						 PApplet.main(new String[] { "lucastorie.HelloMap" }); 
						
						
					}
				});
				
				JTextArea txtrOGrficoPermite = new JTextArea();
				txtrOGrficoPermite.setText("O gráfico permite a visualização geográfica\r\ndos tweets.\r\n\r\nAtenção: é necessário estar conectado a internet!\r\n\r\nFormato: texto|latitude|longitude\r\nExemplo: \"Não vão calar a voz de Marielle\"|-23.00862982|-43.54317572");
				txtrOGrficoPermite.setForeground(Color.BLACK);
				txtrOGrficoPermite.setEditable(false);
				txtrOGrficoPermite.setBackground(new Color(220, 220, 220));
				
				
				JLabel lblMapProvider = new JLabel("Map Provider:");
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(281, Short.MAX_VALUE)
							.addComponent(btnAnexarTweets_1)
							.addGap(262))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(39, Short.MAX_VALUE)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
							.addGap(147))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(115)
									.addComponent(lblMapProvider)
									.addGap(65)
									.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(270)
									.addComponent(btnGerarGrfico_3)))
							.addContainerGap(281, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addComponent(txtrOGrficoPermite, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(48, Short.MAX_VALUE))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(txtrOGrficoPermite, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnAnexarTweets_1)
							.addGap(18)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMapProvider)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addComponent(btnGerarGrfico_3)
							.addGap(49))
				);
				panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gráficos Estáticos", null, panel_2, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		
		final JTextArea nameFileAnexarTweets = new JTextArea();
		 
		
		nameFileAnexarTweets.setText("Nenhum arquivo escolhido");
		

		final JTextArea numeroTweets = new JTextArea();
		numeroTweets.setEditable(false);
		
		JButton btnAnexarTweets = new JButton("Anexar Tweets");
		btnAnexarTweets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theName = new String();
					
					try {
						theName = FileOpener.pickTheTweetsFile();
						nameFileAnexarTweets.setText(theName);
						String fileTweetsName = FileOpener.fileName;
						ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
						int n = DataEntry.nTweets(theTweets);
						numeroTweets.setText( Integer.toString(n));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});


		
		//
		nameFileAnexarTweets.setEditable(false);
		
		JLabel lblOArquivoTem = new JLabel("O arquivo tem ");
		
		JLabel lblTweets = new JLabel("tweets.");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(116)
							.addComponent(nameFileAnexarTweets, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(213)
							.addComponent(btnAnexarTweets, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(lblOArquivoTem)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(numeroTweets, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTweets)
					.addGap(266))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_2, GroupLayout.PREFERRED_SIZE, 626, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAnexarTweets)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameFileAnexarTweets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTweets)
						.addComponent(numeroTweets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOArquivoTem))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(tabbedPane_2, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_2.addTab("Categorias", null, panel_4, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_3.addTab("Barras", null, panel_7, null);
		
		JLabel lblAnexarCategoriasCom = new JLabel("Anexar categorias:");
		
		final JTextArea nameCat = new JTextArea();
		
		JButton btnNewButton = new JButton("Categorias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					nameCat.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				
			}
		});
		
	
		nameCat.setEditable(false);
		
		JButton btnNewButton_2 = new JButton("Gerar gráfico");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fileTweetsName = FileOpener.fileName;
				
				ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
				
				String finalNameCatFile = FileOpener.fileNameCat;
				
				ArrayList<String> categories = DataEntry.dataEntry(finalNameCatFile);

				try {
					Category.createBarCat(theTweets,categories);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Category.clearAllVariables();
				

			}
		});
		
		JTextArea txtrFormatoDoArquivo = new JTextArea();
		txtrFormatoDoArquivo.setText("Formato do arquivo categorias:\r\n\r\nCategoria_1|termo_1;termo_2;...;termo_n;\r\nCategoria_2|termo_1;termo_2;...;termo_n;\r\n...\r\nCategoria_n|termo_1;termo_2;...;termo_n;");
		txtrFormatoDoArquivo.setForeground(Color.BLACK);
		txtrFormatoDoArquivo.setEditable(false);
		txtrFormatoDoArquivo.setBackground(new Color(220, 220, 220));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(258)
							.addComponent(btnNewButton_2))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAnexarCategoriasCom)
							.addGap(35)
							.addComponent(btnNewButton)
							.addGap(58)
							.addComponent(nameCat, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(105)
							.addComponent(txtrFormatoDoArquivo, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrFormatoDoArquivo, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(nameCat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnexarCategoriasCom))
					.addGap(34)
					.addComponent(btnNewButton_2)
					.addGap(20))
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_3.addTab("Linha", null, panel_9, null);
		
		final JTextArea textArea_7 = new JTextArea();
		textArea_7.setEditable(false);
		
		JLabel lblAnexarCategorias = new JLabel("Anexar categorias:");
		
		JButton btnCategorias_1 = new JButton("Categorias");
		btnCategorias_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_7.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});

		
		JLabel lblJanelaDeTempo_1 = new JLabel("Janela de tempo [Minutos]:");
		
		final JSpinner spinner_1 = new JSpinner();
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (comboBox.getSelectedIndex() == 0) {
					//Minuto
					spinner_1.setEnabled(true);
				}
				
				if (comboBox.getSelectedIndex() == 1) {
					//Dia
					spinner_1.setEnabled(false);
				}

				if (comboBox.getSelectedIndex() == 2) {
					//Mês
		    		spinner_1.setEnabled(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Minutos", "Dias", "Meses"}));
		
		JLabel lblEscolhaOPerodo = new JLabel("Escolha o período:");
		
		JButton btnGerarGrfico_8 = new JButton("Gerar gráfico");
		btnGerarGrfico_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int value = (Integer) spinner_1.getValue();

				if (comboBox.getSelectedIndex() == 0) {
				    //Minuto

					String fileTweetsName = FileOpener.fileName;
					
					ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
					
					String finalNameCatFile = FileOpener.fileNameCat;
					
					ArrayList<String> categories = DataEntry.dataEntry(finalNameCatFile);

					try {
						LineChart.createLineCatMinute(theTweets, categories, value);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Category.clearAllVariables();
					
					
				}
				
				if (comboBox.getSelectedIndex() == 1) {
					//Dia
					

					String fileTweetsName = FileOpener.fileName;
					
					ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
					
					String finalNameCatFile = FileOpener.fileNameCat;
					
					ArrayList<String> categories = DataEntry.dataEntry(finalNameCatFile);
					
					try {
						LineChart.createLineDayCat(theTweets, categories);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Category.clearAllVariables();
				}

				if (comboBox.getSelectedIndex() == 2) {
					//Mês

					String fileTweetsName = FileOpener.fileName;
					
					ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
					
					String finalNameCatFile = FileOpener.fileNameCat;
					
					ArrayList<String> categories = DataEntry.dataEntry(finalNameCatFile);
					
					try {
						LineChart.createLineMonthCat(theTweets, categories);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Category.clearAllVariables();
				}
		    		
			}
		});
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(lblJanelaDeTempo_1)
							.addGap(34)
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAnexarCategorias)
								.addComponent(lblEscolhaOPerodo))
							.addGap(41)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_9.createSequentialGroup()
									.addComponent(btnCategorias_1)
									.addGap(50)
									.addComponent(textArea_7, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnGerarGrfico_8)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))))
					.addGap(11))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnexarCategorias)
						.addComponent(btnCategorias_1)
						.addComponent(textArea_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEscolhaOPerodo))
					.addGap(27)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJanelaDeTempo_1))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico_8)
					.addGap(37))
		);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_3.addTab("Pizza", null, panel_10, null);
		
		final JTextArea nameCatPizza = new JTextArea();
		
		JLabel label = new JLabel("Anexar categorias:");
		
		JButton btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					nameCatPizza.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	
				
			}
		});
		
		
		
		JButton btnGerarGrfico = new JButton("Gerar Gráfico");
		btnGerarGrfico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String fileTweetsName = FileOpener.fileName;
				
				ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
				
				String finalNameCatFile = FileOpener.fileNameCat;
				
				ArrayList<String> categories = DataEntry.dataEntry(finalNameCatFile);

				try {
					Category.createPizzaCat(theTweets,categories);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Category.clearAllVariables();
				
			}
		});
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setText("Formato do arquivo categorias:\r\n\r\nCategoria_1|termo_1;termo_2;...;termo_n;\r\nCategoria_2|termo_1;termo_2;...;termo_n;\r\n...\r\nCategoria_n|termo_1;termo_2;...;termo_n;");
		textArea_8.setForeground(Color.BLACK);
		textArea_8.setEditable(false);
		textArea_8.setBackground(new Color(220, 220, 220));
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_10.createSequentialGroup()
					.addContainerGap(288, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico)
					.addGap(231))
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(26)
					.addComponent(btnCategorias)
					.addGap(36)
					.addComponent(nameCatPizza, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_10.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(textArea_8, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_8, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(btnCategorias)
						.addComponent(nameCatPizza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico)
					.addGap(25))
		);
		panel_10.setLayout(gl_panel_10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_3, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_3, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("Frequência de Termos", null, panel_5, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_4, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_4, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
		);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_4.addTab("Barras", null, panel_11, null);
		
		JLabel lblAnexarTermos = new JLabel("Anexar termos:");
		
		final JTextArea textArea_1 = new JTextArea();
		
		JButton btnTermos = new JButton("Termos");
		btnTermos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_1.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		JButton btnGerarGrfico_1 = new JButton("Gerar Gráfico");
		btnGerarGrfico_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fileTweetsName = FileOpener.fileName;
				
				ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
				
				String fileNameWR = FileOpener.fileNameCat;
				
				ArrayList<String> theWords = DataEntry.dataEntry(fileNameWR);

				try {
					WordsRelevance.createBarWR(theTweets,theWords);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				WordsRelevance.clearAllVariables();
				
				
				
			}
		});
		
		JTextArea txtrFormatoDoArquivo_1 = new JTextArea();
		txtrFormatoDoArquivo_1.setText("Formato do arquivo de termos:\r\n\r\nTermo_1\r\nTermo_2\r\n...\r\nTermo_n");
		txtrFormatoDoArquivo_1.setForeground(Color.BLACK);
		txtrFormatoDoArquivo_1.setEditable(false);
		txtrFormatoDoArquivo_1.setBackground(new Color(220, 220, 220));
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAnexarTermos, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_11.createSequentialGroup()
							.addGap(28)
							.addComponent(btnTermos))
						.addGroup(gl_panel_11.createSequentialGroup()
							.addGap(158)
							.addComponent(btnGerarGrfico_1))
						.addGroup(gl_panel_11.createSequentialGroup()
							.addGap(142)
							.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_11.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(txtrFormatoDoArquivo_1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrFormatoDoArquivo_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_11.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTermos)
						.addComponent(lblAnexarTermos))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico_1)
					.addGap(19))
		);
		panel_11.setLayout(gl_panel_11);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_4.addTab("Linha", null, panel_12, null);

		final JTextArea textArea_4 = new JTextArea();
		textArea_4.setText("Nenhum arquivo escolhido");
		
		JLabel lblAnexarTermos_1 = new JLabel("Anexar termos:");
		
		JButton btnTermos_2 = new JButton("Termos");
		btnTermos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_4.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				
			}
		});
		
		
		JLabel label_3 = new JLabel("Escolha o período:");
		
		final JComboBox comboBox_1 = new JComboBox();
		
		final JSpinner spinner = new JSpinner();

		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (comboBox_1.getSelectedIndex() == 0) {
					//Minuto
					spinner.setEnabled(true);
				}
				
				if (comboBox_1.getSelectedIndex() == 1) {
					//Dia
					spinner.setEnabled(false);
				}

				if (comboBox_1.getSelectedIndex() == 2) {
					//Mês
					spinner.setEnabled(false);
				}
			}
		});
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Minutos", "Dia", "Mês"}));
		
		JLabel label_4 = new JLabel("Janela de tempo [Minutos]:");
		
		
		JButton btnGerarGrfico_5 = new JButton("Gerar gráfico");
		btnGerarGrfico_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int value = (Integer) spinner.getValue();

				if (comboBox_1.getSelectedIndex() == 0) {
				    //Minuto
					String fileTweetsName = FileOpener.fileName;
					
					ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
					
					String fileNameWR = FileOpener.fileNameCat;
					
					ArrayList<String> theWords = DataEntry.dataEntry(fileNameWR);
					
						try {
							LineChart.createLineMinute(theTweets,theWords,value);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				}
				
				if (comboBox_1.getSelectedIndex() == 1) {
					//Dias
					String fileTweetsName = FileOpener.fileName;
					
					ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
					
					String fileNameWR = FileOpener.fileNameCat;
					
					ArrayList<String> theWords = DataEntry.dataEntry(fileNameWR);

					LineChart.createLineDay(theTweets,theWords);
				}
				
				if (comboBox_1.getSelectedIndex() == 2) {
					//Mês
					
					String fileTweetsName = FileOpener.fileName;
					
					ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
					
					String fileNameWR = FileOpener.fileNameCat;
					
					ArrayList<String> theWords = DataEntry.dataEntry(fileNameWR);

					LineChart.createLineMonth(theTweets,theWords);

					
				}
				
			}
		});
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAnexarTermos_1)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_12.createSequentialGroup()
									.addComponent(btnTermos_2)
									.addGap(43)
									.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_12.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap(296, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico_5)
					.addGap(225))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnexarTermos_1)
						.addComponent(btnTermos_2)
						.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addComponent(btnGerarGrfico_5)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_12.setLayout(gl_panel_12);
		
		JPanel panel_13 = new JPanel();
		tabbedPane_4.addTab("Pizza", null, panel_13, null);
		
		JLabel label_2 = new JLabel("Anexar termos:");
		final JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("Nenhum arquivo escolhido");
		JButton btnTermos_1 = new JButton("Termos");
		btnTermos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_3.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JButton btnGerarGrfico_2 = new JButton("Gerar Gráfico");
		btnGerarGrfico_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String fileTweetsName = FileOpener.fileName;
				
				ArrayList<String> theTweets = DataEntry.dataEntry(fileTweetsName);
				
				String fileNameWR = FileOpener.fileNameCat;
				
				ArrayList<String> theWords = DataEntry.dataEntry(fileNameWR);
	
				WordsRelevance.createPieWR(theTweets,theWords);
				
			}
		});
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setText("Formato do arquivo de termos:\r\n\r\nTermo_1\r\nTermo_2\r\n...\r\nTermo_n");
		textArea_6.setForeground(Color.BLACK);
		textArea_6.setEditable(false);
		textArea_6.setBackground(new Color(220, 220, 220));
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_13.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(173))
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(257)
					.addComponent(btnGerarGrfico_2)
					.addContainerGap(262, Short.MAX_VALUE))
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addGap(27)
					.addComponent(btnTermos_1)
					.addGap(35)
					.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTermos_1)
						.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnGerarGrfico_2)
					.addGap(25))
		);
		panel_13.setLayout(gl_panel_13);
		panel_5.setLayout(gl_panel_5);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Glove", null, panel_8, null);
		final JTextArea txtrOGlove = new JTextArea();
		final JTextPane textPane = new JTextPane();
		textPane.setText("Nenhum arquivo escolhido");
		JButton btnAnexarTweets_2 = new JButton("Anexar tweets");
		btnAnexarTweets_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheTweetsFile();
					textPane.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});

		txtrOGlove.setText("O GloVe é um algoritmo de aprendizado para obter\r\nrepresentações vetoriais para palavras. A representação\r\ngráfica mostra a similiaridades espacial das palavras \r\nno conteúdo textual");
		txtrOGlove.setForeground(Color.BLACK);
		txtrOGlove.setEditable(false);
		txtrOGlove.setBackground(new Color(220, 220, 220));
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Nenhum arquivo escolhido");
		JButton btnAnexarTermos = new JButton("Anexar termos");
		btnAnexarTermos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textPane_1.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				
			}
		});
		
		
		final JSpinner spinner_3 = new JSpinner();
		
		spinner_3.setValue(100);
		
		JLabel lblIteraes = new JLabel("Iterações:");
		
		JLabel lblTamanhoDaJanela = new JLabel("Tamanho da janela:");
		
		final JSpinner spinner_4 = new JSpinner();
		
		JButton btnNewButton_1 = new JButton("Gerar gráfico\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int value1 = (Integer) spinner_3.getValue();
				
				int value2 = (Integer) spinner_4.getValue();
				
				
				String fileName = FileOpener.fileName;
				
				String tqq1 = FileOpener.fileNameCat;
				
				ArrayList<String> TQQ = DataEntry.dataEntry(tqq1);
				
				Glove.createGlove(fileName,TQQ,value1,value2);
				
				
			}
		});
		
		JButton button_2 = new JButton("?");
		
		JButton button_3 = new JButton("?");
	
		
		
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(264)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_2)
								.addComponent(button_3))
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_8.createSequentialGroup()
									.addGap(9)
									.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_8.createSequentialGroup()
											.addComponent(btnAnexarTermos)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel_8.createSequentialGroup()
											.addComponent(btnAnexarTweets_2)
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addGroup(gl_panel_8.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTamanhoDaJanela, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblIteraes))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_8.createSequentialGroup()
									.addGap(36)
									.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(spinner_4, Alignment.LEADING)
										.addComponent(spinner_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
								.addGroup(gl_panel_8.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
								.addComponent(textPane_1))
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(98)
							.addComponent(txtrOGlove, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(22)
					.addComponent(txtrOGlove, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAnexarTweets_2)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAnexarTermos)
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2)
						.addComponent(lblIteraes))
					.addGap(18)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3)
						.addComponent(lblTamanhoDaJanela))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(20))
		);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Grafos", null, panel_1, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 545, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Imagens", null, panel_3, null);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("Nenhum arquivo escolhido");
		JButton btnNewButton_3 = new JButton("Anexar tweets");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theName = new String();
				
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_2.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNmeroMnimoDe = new JLabel("Número mínimo de imagens:");
		
		final JSpinner numMinImagens = new JSpinner();
		numMinImagens.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JButton btnGerarGrfico_4 = new JButton("Gerar gráfico");
		
		pathImageF = new JTextField();
		pathImageF.setColumns(10);
		
		btnGerarGrfico_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fileNameDGI = FileOpener.fileNameCat;
				
				int value = (Integer) numMinImagens.getValue();
				
				ArrayList<String> theTweets = DataEntry.dataEntry(fileNameDGI);
				
				String theImagesfile = pathImageF.getText();
								
				try {
					DynamicGraphs.ImageGraph(theImagesfile, theTweets, value);
				} catch (InterruptedException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
		
		JTextArea txtrOGrficoDinmico = new JTextArea();
		txtrOGrficoDinmico.setEditable(false);
		txtrOGrficoDinmico.setBackground(new Color(220, 220, 220));
		txtrOGrficoDinmico.setForeground(Color.BLACK);
		txtrOGrficoDinmico.setText("O gráfico dinâmico de imagens representa a relevância \r\nde imagens compartilhadas ao longo do tempo. \r\nDessa forma, o crescimento exponencial das imagens \r\nno gráfico é proporcional a quantidade de vezes que \r\na imagem é compartilhada\r\n\r\nFormato: user;id_da_imagem.jpg;\r\nExemplo: cascavellettes;100000.jpg;");
	
		JLabel lblIndicarOCaminho = new JLabel("Inserir caminho da pasta com imagens:");
		
		
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(164)
							.addComponent(btnGerarGrfico_4))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIndicarOCaminho)
								.addComponent(lblNmeroMnimoDe)
								.addComponent(btnNewButton_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(numMinImagens, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(pathImageF, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
								.addComponent(textArea_2))))
					.addContainerGap(28, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addGap(78)
					.addComponent(txtrOGrficoDinmico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrOGrficoDinmico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIndicarOCaminho)
						.addComponent(pathImageF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroMnimoDe)
						.addComponent(numMinImagens, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addComponent(btnGerarGrfico_4)
					.addGap(24))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Usuários/RT", null, panel_6, null);
		
		JTextArea txtrOGrficoDinmico_1 = new JTextArea();
		txtrOGrficoDinmico_1.setText("O gráfico dinâmico de users representa a relevância \r\nde users compartilhadas ao longo do tempo. \r\nDessa forma, o crescimento exponencial das imagens \r\nno gráfico é proporcional a quantidade de vezes que \r\na imagem é compartilhada\r\n\r\nCompatível para formatos com apenas texto,\r\nou com \"from_user\"\r\n\r\nFormatação: text  ou  text|from_user\r\n");
		txtrOGrficoDinmico_1.setForeground(Color.BLACK);
		txtrOGrficoDinmico_1.setEditable(false);
		txtrOGrficoDinmico_1.setBackground(new Color(220, 220, 220));
		
		final JTextArea textArea_9 = new JTextArea();
		JButton btnAnexarTweets_3 = new JButton("Anexar tweets");
		textArea_9.setText("Nenhum arquivo escolhido");
		
		btnAnexarTweets_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String theName = new String();
			
				try {
					theName = FileOpener.pickTheCatFile();
					textArea_9.setText(theName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
			JButton btnGerarGrfico_11 = new JButton("Gerar gráfico");
			
			final JSpinner spinner_2 = new JSpinner();
			final JCheckBox chckbxComFromuser = new JCheckBox("Com filtro \"from_user\"");
			
			btnGerarGrfico_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
									
					String fileNameDGI = FileOpener.fileNameCat;

					ArrayList<String> theTweets = DataEntry.dataEntry(fileNameDGI);
			
					int value = (Integer) spinner_2.getValue();
					
					boolean f = chckbxComFromuser.isSelected();
					
					if(f) {
					try {
						DynamicGraphs.RTGraph(theTweets,value);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
					}else {
						try {
							DynamicGraphs.RTGraphAll(theTweets,value);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
			});
			
			
			
			
			
			JLabel lblNmeroMnimo = new JLabel("Número mínimo:");
			
			
			spinner_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			
			
			GroupLayout gl_panel_6 = new GroupLayout(panel_6);
			gl_panel_6.setHorizontalGroup(
				gl_panel_6.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
						.addGap(45)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_6.createSequentialGroup()
								.addComponent(btnAnexarTweets_3)
								.addGap(18)
								.addComponent(textArea_9, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
							.addComponent(chckbxComFromuser)
							.addGroup(gl_panel_6.createSequentialGroup()
								.addComponent(lblNmeroMnimo)
								.addGap(31)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGap(142))
					.addGroup(gl_panel_6.createSequentialGroup()
						.addGap(93)
						.addComponent(txtrOGrficoDinmico_1, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(105, Short.MAX_VALUE))
					.addGroup(gl_panel_6.createSequentialGroup()
						.addGap(257)
						.addComponent(btnGerarGrfico_11)
						.addContainerGap(269, Short.MAX_VALUE))
			);
			gl_panel_6.setVerticalGroup(
				gl_panel_6.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_6.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtrOGrficoDinmico_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAnexarTweets_3)
							.addComponent(textArea_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addComponent(chckbxComFromuser)
						.addGap(18)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNmeroMnimo)
							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addComponent(btnGerarGrfico_11)
						.addGap(30))
			);
			panel_6.setLayout(gl_panel_6);
			panel_1.setLayout(gl_panel_1);
	}
}
