package mvc;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import upo.progetto.*;

public class View {
	/* DICHIARAZIONI E INIZIALIZZAZIONI */
	private Font font = new Font("Helvetica", Font.PLAIN, 14);

	private JFrame fInzio = new JFrame();

	private JPanel pInzio = new JPanel();
	private JPanel pInzioMenu = new JPanel();
	private JPanel pInzioVuoto = new JPanel();
	private JPanel pInziodx = new JPanel();
	private JPanel pInziodxVuoto = new JPanel();

	private JPanel pVuoto = new JPanel();

	private JMenuBar mb = new JMenuBar();
	private JMenu menuOpzioni;
	private JMenu submenuInserisci;
	private JMenu submenuVisualizza;
	private JMenu submenuElimina;
	private JMenuItem iPrenotaAula;
	private JMenuItem iStampaReport;
	private JMenuItem iModificaAula;
	private JMenuItem iInserisciAula;
	private JMenuItem iInserisciDocente;
	private JMenuItem iVisualizzaAula;
	private JMenuItem iVisualizzaDocente;
	private JMenuItem iVisualizzaPrenotazione;
	private JMenuItem iEliminaAula;
	private JMenuItem iEliminaDocente;
	private JMenuItem iEliminaPrenotazione;

	/* INSERISCI AULA */
	private JPanel pInserisciAula = new JPanel();
	private JPanel pInserisciAulaNome = new JPanel();
	private JPanel pInserisciAulaCapienza = new JPanel();
	private JPanel pInserisciAulaTipo = new JPanel();
	private JPanel pInserisciAulaDotazioni = new JPanel();
	private JPanel pInserisciAulaBottoni = new JPanel();

	private JLabel lblInserisciAulaNome = new JLabel("Nome              ");
	private JLabel lblInserisciAulaCapienza = new JLabel("Capienza         ");
	private JLabel lblInserisciAulaTipo = new JLabel("Tipo               ");
	private JLabel lblInserisciAulaDotazioni = new JLabel("Dotazioni        ");

	private JTextField txtInserisciAulaNome = new JTextField();
	private JTextField txtInserisciAulaCapienza = new JTextField();

	private JButton btnInserisciAulaInserisci = new JButton("Inserisci");
	private JButton btnInserisciAulaCancella = new JButton("Cancella");
	private JButton btnInserisciAulaChiudi = new JButton("Chiudi");

	private JRadioButton rbmInserisciAulaTipoStandard = new JRadioButton("Standard");
	private JRadioButton rbmInserisciAulaTipoParticolare = new JRadioButton("Particolare");
	private ButtonGroup gruppoBottonirbm = new ButtonGroup();

	private JCheckBox cbxInserisciAulaDotazioniProiettore = new JCheckBox("Proiettore");
	private JCheckBox cbxInserisciAulaDotazioniLavagna = new JCheckBox("Lavagna");
	private JCheckBox cbxInserisciAulaDotazioniMicrofono = new JCheckBox("Microfono");
	private JCheckBox cbxInserisciAulaDotazioniVideocamera = new JCheckBox("Videocamera");

	private String[] aulaParticolare = { "Aula Magna", "Aula Informatica", "Laboratorio Chimica" };

	private JComboBox<String> cmbAulaParticolare = new JComboBox<>(aulaParticolare);

	/* INSERISCI DOCENTE */
	private JPanel pInserisciDocente = new JPanel();
	private JPanel pInserisciDocenteNome = new JPanel();
	private JPanel pInserisciDocenteCognome = new JPanel();
	private JPanel pInserisciDocenteMatricola = new JPanel();
	private JPanel pInserisciDocenteBottoni = new JPanel();

	private JLabel lblInserisciDocenteNome = new JLabel("Nome                    ");
	private JLabel lblInserisciDocenteCognome = new JLabel("Cognome              ");
	private JLabel lblInserisciDocenteMatricola = new JLabel("Matricola               ");

	private JTextField txtInserisciDocenteNome = new JTextField();
	private JTextField txtInserisciDocenteCognome = new JTextField();
	private JTextField txtInserisciDocenteMatricola = new JTextField();

	private JButton btnInserisciDocenteInserisci = new JButton("Inserisci");
	private JButton btnInserisciDocenteCancella = new JButton("Cancella");
	private JButton btnInserisciDocenteChiudi = new JButton("Chiudi");

	/* PRENOTA AULA */
	private JPanel pPrenotaAula = new JPanel();
	private JPanel pPrenotaAulaAula = new JPanel();
	private JPanel pPrenotaAulaDocente = new JPanel();
	private JPanel pPrenotaAulaData = new JPanel();
	private JPanel pPrenotaAulaOraInizio = new JPanel();
	private JPanel pPrenotaAulaBottoni = new JPanel();

	private JLabel lblPrenotaAulaAula = new JLabel("Aula                   ");
	private JLabel lblPrenotaAulaDocente = new JLabel("Docente             ");
	private JLabel lblPrenotaAulaData = new JLabel("Data                   ");
	private JLabel lblPrenotaAulaOraInizio = new JLabel("Ora Inizio            ");

	private Integer[] giorni = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
			25, 26, 27, 28, 29, 30, 31 };
	private Integer[] mesi = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	private Integer[] anni = { 2021, 2022, 2023};
	private String[] oraInizio = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
			"18:00" };

	JComboBox<String> cmbAula = new JComboBox<>();
	private JComboBox<Integer> cmbGiorni = new JComboBox<>(giorni);
	private JComboBox<Integer> cmbMesi = new JComboBox<>(mesi);
	private JComboBox<Integer> cmbAnni = new JComboBox<>(anni);
	private JComboBox<String> cmbOraInizio = new JComboBox<>(oraInizio);

	private JTextField txtPrenotaAulaDocente = new JTextField();

	private JButton btnPrenotaAulaCarica = new JButton("Carica Aula");
	private JButton btnPrenotaAulaPrenota = new JButton("Prenota");
	private JButton btnPrenotaAulaCancella = new JButton("Cancella");
	private JButton btnPrenotaAulaChiudi = new JButton("Chiudi");

	/* VISUALIZZA AULA */
	private JPanel pVisualizzaAula = new JPanel();

	private JTextArea txtAreaVisualizzaAula = new JTextArea();

	private JScrollPane scrollVisualizzaAula = new JScrollPane(txtAreaVisualizzaAula,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	/* VISUALIZZA DOCENTE */
	private JPanel pVisualizzaDocente = new JPanel();

	private JTextArea txtAreaVisualizzaDocente = new JTextArea();

	JScrollPane scrollVisualizzaDocente = new JScrollPane(txtAreaVisualizzaDocente,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	/* VISUALIZZA PRENOTAZIONE */
	private JPanel pVisualizzaPrenotazione = new JPanel();

	private JTextArea txtAreaVisualizzaPrenotazione = new JTextArea();

	// JScrollPane scrollVisualizzaPrenotazione = new
	// JScrollPane(txtAreaVisualizzaPrenotazione,
	// JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	// JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	/* MODIFICA AULA */
	private JPanel pModificaAula = new JPanel();
	private JPanel pModificaAulaNome = new JPanel();
	private JPanel pModificaAulaBottoni = new JPanel();
	private JPanel pModificaAulaModificaElementi = new JPanel();
	private JPanel pModificaAulaInserisciNome = new JPanel();
	private JPanel pModificaAulaInserisciCapienza = new JPanel();
	private JPanel pModificaAulaInserisciTipo = new JPanel();
	private JPanel pModificaAulaInserisciDotazioni = new JPanel();
	private JPanel pModificaAulaInserisciBottoni = new JPanel();

	private JLabel lblModificaAulaNome = new JLabel("Nome Aula                   ");
	private JLabel lblModificaAulaInserisciNome = new JLabel("Nome              ");
	private JLabel lblModificaAulaInserisciCapienza = new JLabel("Capienza         ");
	private JLabel lblModificaAulaInserisciTipo = new JLabel("Tipo               ");
	private JLabel lblModificaAulaInserisciDotazioni = new JLabel("Dotazioni        ");

	private JTextField txtModificaAulaInserisciNome = new JTextField();
	private JTextField txtModificaAulaInserisciCapienza = new JTextField();

	JRadioButton rbmModificaAulaInserisciTipoStandard = new JRadioButton("Standard");
	JRadioButton rbmModificaAulaInserisciTipoParticolare = new JRadioButton("Particolare");
	private ButtonGroup gruppoBottonirbmModificaAula = new ButtonGroup();

	private JCheckBox cbxModificaAulaInserisciDotazioniProiettore = new JCheckBox("Proiettore");
	private JCheckBox cbxModificaAulaInserisciDotazioniLavagna = new JCheckBox("Lavagna");
	private JCheckBox cbxModificaAulaInserisciDotazioniMicrofono = new JCheckBox("Microfono");
	private JCheckBox cbxModificaAulaInserisciDotazioniVideocamera = new JCheckBox("Videocamera");

	JComboBox<String> cmbModificaAulaNome = new JComboBox<>();
	JComboBox<String> cmbAulaParticolareModifica = new JComboBox<>(aulaParticolare);

	private JButton btnModificaAulaCarica = new JButton("Carica Aula");
	private JButton btnModificaAulaMostra = new JButton("Mostra");
	private JButton btnModificaAulaCancella = new JButton("Cancella");
	private JButton btnModificaAulaChiudi = new JButton("Chiudi");
	private JButton btnModificaAulaInserisciModifica = new JButton("Modifica");

	/* ELIMINA AULA */
	private JPanel pEliminaAula = new JPanel();
	private JPanel pEliminaAulaNome = new JPanel();
	private JPanel pEliminaAulaBottoni = new JPanel();

	private JLabel lblEliminaAulaNome = new JLabel("Nome Aula                   ");

	JComboBox<String> cmbEliminaAula = new JComboBox<>();

	private JButton btnEliminaAulaCarica = new JButton("Carica Aula");
	private JButton btnEliminaAulaElimina = new JButton("Elimina");
	private JButton btnEliminaAulaCancella = new JButton("Cancella");
	private JButton btnEliminaAulaChiudi = new JButton("Chiudi");

	/* ELIMINA DOCENTE */
	private JPanel pEliminaDocente = new JPanel();
	private JPanel pEliminaDocenteNome = new JPanel();
	private JPanel pEliminaDocenteBottoni = new JPanel();

	private JLabel lblEliminaDocenteMatricola = new JLabel("Matricola Docente                   ");

	private JTextField txtEliminaDocenteMatricola = new JTextField();

	private JButton btnEliminaDocenteElimina = new JButton("Elimina");
	private JButton btnEliminaDocenteCancella = new JButton("Cancella");
	private JButton btnEliminaDocenteChiudi = new JButton("Chiudi");

	/* ELIMINA PRENOTAZIONE */
	private JPanel pEliminaPrenotazione = new JPanel();
	private JPanel pEliminaPrenotazioneNome = new JPanel();
	private JPanel pEliminaPrenotazioneMatricola = new JPanel();
	private JPanel pEliminaPrenotazioneBottoni = new JPanel();
	private JPanel pEliminaPrenotazioneRicerca = new JPanel();
	private JPanel pEliminaPrenotazioneRicercaVisualizza = new JPanel();
	private JPanel pEliminaPrenotazioneRicercaElimina = new JPanel();

	private JLabel lblEliminaPrenotazioneNome = new JLabel("Nome Aula                              ");
	private JLabel lblEliminaPrenotazioneMatricola = new JLabel("Matricola Docente                   ");
	private JLabel lblEliminaPrenotazioneID = new JLabel("ID prenotazione da eliminare         ");

	JComboBox<String> cmbEliminaPrenotazioneAula = new JComboBox<>();

	private JTextArea txtEliminaPrenotazioneVisualizza = new JTextArea();

	private JTextField txtEliminaPrenotazioneMatricola = new JTextField();
	private JTextField txtEliminaPrenotazioneID = new JTextField();

	private JButton btnEliminaPrenotazioneCarica = new JButton("Carica Aula");
	private JButton btnEliminaPrenotazioneCerca = new JButton("Cerca");
	private JButton btnEliminaPrenotazioneCancella = new JButton("Cancella");
	private JButton btnEliminaPrenotazioneChiudi = new JButton("Chiudi");
	private JButton btnEliminaPrenotazioneElimina = new JButton("Elimina");

	/* STAMPA REPORT */
	private JPanel pStampaReport = new JPanel();
	private JPanel pStampaReportMatricola = new JPanel();
	private JPanel pStampaReportBottoni = new JPanel();
	private JPanel pStampaReportVisualizza = new JPanel();

	private JLabel lblStampaReportMatricola = new JLabel("Matricola Docente                   ");

	private JTextField txtStampaReportMatricola = new JTextField();

	private JButton btnStampaReportMostra = new JButton("Mostra");
	private JButton btnStampaReportCancella = new JButton("Cancella");
	private JButton btnStampaReportChiudi = new JButton("Chiudi");

	private JTextArea txtAreaStampaReportVisualizza = new JTextArea();

	JScrollPane scrollStampaReportVisualizza = new JScrollPane(txtAreaVisualizzaPrenotazione,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	/* IMMAGINI */
	// private File f1 = new
	// File("C:\\Users\\elisa\\eclipse-workspace\\ProgettoParadigmi\\immagini\\logoInteroUPO.png");
	private File f1 = new File("immagini\\logoInteroUPO.png");
	private JLabel lblImmagineIntera = new JLabel(new ImageIcon(f1.getPath()));
	// private File f2 = new
	// File("C:\\Users\\elisa\\eclipse-workspace\\ProgettoParadigmi\\immagini\\logoPiccoloUPO.png");
	private File f2 = new File("immagini\\logoPiccoloUPO.png");
	private JLabel lblImmaginePiccola = new JLabel(new ImageIcon(f2.getPath()));

	/* COSTRUTTORE */
	public View() {
		/* CARATTERISTICHE FRAME */
		fInzio.setVisible(true);
		fInzio.setTitle("PRENOTAZIONE AULE");
		fInzio.setSize(1366, 768);
		fInzio.setLayout(new BorderLayout());
		fInzio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiude e termina programma
		Container c1 = fInzio.getContentPane();
		c1.setBackground(Color.WHITE); // metto colore sfondo al frame

		/* CARATTERITICHE PANEL */

		pInzio.setBorder(BorderFactory.createTitledBorder("Menu"));
		pInzio.setPreferredSize(new Dimension(250, 50));
		pInzio.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInzio.setBackground(Color.RED); // metto colore sfondo al panel

		pInzioMenu.setPreferredSize(new Dimension(230, 50));
		pInzioMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInzioMenu.setBackground(Color.RED);
		pInzio.add(pInzioMenu);

		pVuoto.setPreferredSize(new Dimension(1000, 30));
		pVuoto.setLayout(new FlowLayout(FlowLayout.LEFT));
		pVuoto.setBackground(Color.WHITE); // metto colore sfondo al panel

		/* IMMAGINE PICCOLA */
		pInzioVuoto.setPreferredSize(new Dimension(230, 410));
		pInzioVuoto.setBackground(Color.RED);
		pInzio.add(pInzioVuoto);

		lblImmaginePiccola.setPreferredSize(new Dimension(230, 230));
		lblImmaginePiccola.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInzio.add(lblImmaginePiccola);

		pInziodx.setPreferredSize(new Dimension(1102, 718));
		pInziodx.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pInziodx.setBackground(Color.WHITE);

		/* IMMAGINE INTERA */
		pInziodxVuoto.setPreferredSize(new Dimension(1102, 106));
		pInziodxVuoto.setBackground(Color.WHITE);
		pInziodx.add(pInziodxVuoto);

		lblImmagineIntera.setPreferredSize(new Dimension(1098, 506));
		lblImmagineIntera.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInziodx.add(lblImmagineIntera);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pInzio, BorderLayout.WEST);
		fInzio.add(pInziodx, BorderLayout.EAST);

		/* GESTIONE MENU */
		menuOpzioni = new JMenu("Scegli opzione");
		menuOpzioni.setFont(font);

		/* INSERISCI */
		submenuInserisci = new JMenu("Inserisci");
		submenuInserisci.setFont(font);
		iInserisciAula = new JMenuItem("Aula");
		iInserisciAula.setFont(font);
		iInserisciDocente = new JMenuItem("Docente");
		iInserisciDocente.setFont(font);

		submenuInserisci.add(iInserisciAula);
		submenuInserisci.add(iInserisciDocente);
		menuOpzioni.add(submenuInserisci);

		/* PRENOTA AULA */
		iPrenotaAula = new JMenuItem("Prenota aula");
		iPrenotaAula.setFont(font);

		menuOpzioni.add(iPrenotaAula);

		/* VISUALIZZA */
		submenuVisualizza = new JMenu("Visualizza");
		submenuVisualizza.setFont(font);
		iVisualizzaAula = new JMenuItem("Aula");
		iVisualizzaAula.setFont(font);
		iVisualizzaDocente = new JMenuItem("Docente");
		iVisualizzaDocente.setFont(font);
		iVisualizzaPrenotazione = new JMenuItem("Prenotazione");
		iVisualizzaPrenotazione.setFont(font);

		submenuVisualizza.add(iVisualizzaAula);
		submenuVisualizza.add(iVisualizzaDocente);
		submenuVisualizza.add(iVisualizzaPrenotazione);
		menuOpzioni.add(submenuVisualizza);

		/* MODIFICA */
		iModificaAula = new JMenuItem("Modifica aula");
		iModificaAula.setFont(font);

		menuOpzioni.add(iModificaAula);

		/* ELIMINA */
		submenuElimina = new JMenu("Elimina");
		submenuElimina.setFont(font);
		iEliminaAula = new JMenuItem("Aula");
		iEliminaAula.setFont(font);
		iEliminaDocente = new JMenuItem("Docente");
		iEliminaDocente.setFont(font);
		iEliminaPrenotazione = new JMenuItem("Prenotazione");
		iEliminaPrenotazione.setFont(font);

		submenuElimina.add(iEliminaAula);
		submenuElimina.add(iEliminaDocente);
		submenuElimina.add(iEliminaPrenotazione);
		menuOpzioni.add(submenuElimina);

		/* STAMPA REPORT */
		iStampaReport = new JMenuItem("Stampa report");
		iStampaReport.setFont(font);

		menuOpzioni.add(iStampaReport);

		mb.add(menuOpzioni); // aggiungo il JMenu al JMenuBar
		pInzioMenu.add(mb);
	}

	/* METODI */
	/* INSERISCI AULA */
	/* GRAFICA */ // nell'acitionListener viene richiamato per far comparire la parte grafica
	public void apriPanelInserisciAula() {
		pInserisciAula.setBorder(BorderFactory.createTitledBorder("Inserisci Aula"));
		pInserisciAula.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pInserisciAula.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInserisciAula.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(true);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pInserisciAula, BorderLayout.EAST);
		pInserisciAula.add(pVuoto);

		/* caratteristiche pannello per nome aula */
		pInserisciAulaNome.setPreferredSize(new Dimension(1000, 40));
		pInserisciAulaNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciAulaNome.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciAulaNome.add(lblInserisciAulaNome);
		lblInserisciAulaNome.setFont(font);

		pInserisciAulaNome.add(txtInserisciAulaNome);
		txtInserisciAulaNome.setFont(font);
		txtInserisciAulaNome.setPreferredSize(new Dimension(250, 25));

		pInserisciAula.add(pInserisciAulaNome);

		/* caratteristiche pannello per capienza aula */
		pInserisciAulaCapienza.setPreferredSize(new Dimension(1000, 40));
		pInserisciAulaCapienza.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciAulaCapienza.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciAulaCapienza.add(lblInserisciAulaCapienza);
		lblInserisciAulaCapienza.setFont(font);

		pInserisciAulaCapienza.add(txtInserisciAulaCapienza);
		txtInserisciAulaCapienza.setFont(font);
		txtInserisciAulaCapienza.setPreferredSize(new Dimension(250, 25));

		pInserisciAula.add(pInserisciAulaCapienza);

		/* caratteristiche pannello per tipo aula */
		pInserisciAulaTipo.setPreferredSize(new Dimension(1000, 40));
		pInserisciAulaTipo.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciAulaTipo.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciAulaTipo.add(lblInserisciAulaTipo);
		lblInserisciAulaTipo.setFont(font);

		gruppoBottonirbm.add(rbmInserisciAulaTipoStandard);
		gruppoBottonirbm.add(rbmInserisciAulaTipoParticolare);
		pInserisciAulaTipo.add(rbmInserisciAulaTipoStandard);
		rbmInserisciAulaTipoStandard.setFont(font);
		rbmInserisciAulaTipoStandard.setBackground(Color.WHITE);
		pInserisciAulaTipo.add(rbmInserisciAulaTipoParticolare);
		rbmInserisciAulaTipoParticolare.setFont(font);
		rbmInserisciAulaTipoParticolare.setBackground(Color.WHITE);
		pInserisciAulaTipo.add(cmbAulaParticolare);
		cmbAulaParticolare.setFont(font);
		cmbAulaParticolare.setBackground(Color.WHITE);
		cmbAulaParticolare.setEnabled(false);

		pInserisciAula.add(pInserisciAulaTipo);

		/* caratteristiche pannello per dotazioni aula */
		pInserisciAulaDotazioni.setPreferredSize(new Dimension(1000, 40));
		pInserisciAulaDotazioni.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciAulaDotazioni.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciAulaDotazioni.add(lblInserisciAulaDotazioni);
		lblInserisciAulaDotazioni.setFont(font);

		pInserisciAulaDotazioni.add(cbxInserisciAulaDotazioniProiettore);
		cbxInserisciAulaDotazioniProiettore.setFont(font);
		cbxInserisciAulaDotazioniProiettore.setBackground(Color.WHITE);
		pInserisciAulaDotazioni.add(cbxInserisciAulaDotazioniLavagna);
		cbxInserisciAulaDotazioniLavagna.setFont(font);
		cbxInserisciAulaDotazioniLavagna.setBackground(Color.WHITE);
		pInserisciAulaDotazioni.add(cbxInserisciAulaDotazioniMicrofono);
		cbxInserisciAulaDotazioniMicrofono.setFont(font);
		cbxInserisciAulaDotazioniMicrofono.setBackground(Color.WHITE);
		pInserisciAulaDotazioni.add(cbxInserisciAulaDotazioniVideocamera);
		cbxInserisciAulaDotazioniVideocamera.setFont(font);
		cbxInserisciAulaDotazioniVideocamera.setBackground(Color.WHITE);

		pInserisciAula.add(pInserisciAulaDotazioni);

		/* caratteristiche pannello per bottoni */
		pInserisciAulaBottoni.setPreferredSize(new Dimension(1000, 40));
		pInserisciAulaBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInserisciAulaBottoni.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciAulaBottoni.add(btnInserisciAulaInserisci);
		btnInserisciAulaInserisci.setFont(font);
		btnInserisciAulaInserisci.setBackground(Color.RED);
		btnInserisciAulaInserisci.setForeground(Color.RED);
		btnInserisciAulaInserisci.setPreferredSize(new Dimension(100, 30));
		pInserisciAulaBottoni.add(btnInserisciAulaCancella);
		btnInserisciAulaCancella.setFont(font);
		btnInserisciAulaCancella.setBackground(Color.RED);
		btnInserisciAulaCancella.setForeground(Color.RED);
		btnInserisciAulaCancella.setPreferredSize(new Dimension(100, 30));
		pInserisciAulaBottoni.add(btnInserisciAulaChiudi);
		btnInserisciAulaChiudi.setFont(font);
		btnInserisciAulaChiudi.setBackground(Color.RED);
		btnInserisciAulaChiudi.setForeground(Color.RED);
		btnInserisciAulaChiudi.setPreferredSize(new Dimension(100, 30));

		pInserisciAula.add(pInserisciAulaBottoni);

	}

	/* GET PULSANTI */
	// quando clicco sul menu inserisci aula, mi ritorna il pulsante
	public JMenuItem getInserisciAula() {
		return iInserisciAula;
	}

	public String getTxtInserisciAulaNome() {
		return txtInserisciAulaNome.getText();
	}

	public String getTxtInserisciAulaCapienza() {
		return txtInserisciAulaCapienza.getText();
	}

	// prende il tipo STANDARD e restituisce se è selezionato (true) oppure no
	// (false)
	public boolean getRbmInserisciAulaTipoStandard() {
		return rbmInserisciAulaTipoStandard.isSelected();
	}

	// prende il tipo PARTICOLARE e restituisce se è selezionato (true) oppure no
	// (false)
	public boolean getRbmInserisciAulaTipoParticolare() {
		return rbmInserisciAulaTipoParticolare.isSelected();
	}

	// prende la dotazione PROIETTORE e restituisce se è selezionato (true) oppure
	// no (false)
	public boolean getCbxInserisciAulaDotazioniProiettore() {
		return cbxInserisciAulaDotazioniProiettore.isSelected();
	}

	// prende la dotazione LAVAGNA e restituisce se è selezionato (true) oppure no
	// (false)
	public boolean getCbxInserisciAulaDotazioniLavagna() {
		return cbxInserisciAulaDotazioniLavagna.isSelected();
	}

	// prende la dotazione MICROFONO e restituisce se è selezionato (true) oppure no
	// (false)
	public boolean getCbxInserisciAulaDotazioniMicrofono() {
		return cbxInserisciAulaDotazioniMicrofono.isSelected();
	}

	// prende la dotazione VIDEOCAMERA e restituisce se è selezionato (true) oppure
	// no (false)
	public boolean getCbxInserisciAulaDotazioniVideocamera() {
		return cbxInserisciAulaDotazioniVideocamera.isSelected();
	}

	public String getCmbAulaParticolare() {
		return cmbAulaParticolare.getSelectedItem().toString();
	}

	public JButton getBtnInserisciAulaInserisci() {
		return btnInserisciAulaInserisci;
	}

	public JButton getBtnInserisciAulaCancella() {
		return btnInserisciAulaCancella;
	}

	public JButton getBtnInserisciAulaChiudi() {
		return btnInserisciAulaChiudi;
	}

	public void cancellapInserimentoAula() {
		txtInserisciAulaNome.setText(null);
		txtInserisciAulaCapienza.setText(null);
		gruppoBottonirbm.setSelected(new DefaultButtonModel(), true); // pulire un gruppo di pulsanti
		cbxInserisciAulaDotazioniProiettore.setSelected(false);
		cbxInserisciAulaDotazioniLavagna.setSelected(false);
		cbxInserisciAulaDotazioniMicrofono.setSelected(false);
		cbxInserisciAulaDotazioniVideocamera.setSelected(false);
		cmbAulaParticolare.setEnabled(false);
	}

	public void chiudipInserimentoAula() {
		pInserisciAula.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* INSERISCI DOCENTE */
	/* GRAFICA */
	public void apriPanelInserisciDocente() {
		pInserisciDocente.setBorder(BorderFactory.createTitledBorder("Inserisci Docente"));
		pInserisciDocente.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pInserisciDocente.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInserisciDocente.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(true);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pInserisciDocente, BorderLayout.EAST);

		/* caratteristiche pannello vuoto */
		// serve per staccare il tutto dal bordo superiore
		pVuoto.setPreferredSize(new Dimension(1000, 30));
		pVuoto.setLayout(new FlowLayout(FlowLayout.LEFT));
		pVuoto.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciDocente.add(pVuoto);

		/* caratteristiche pannello per nome docente */
		pInserisciDocenteNome.setPreferredSize(new Dimension(1000, 40));
		pInserisciDocenteNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciDocenteNome.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciDocenteNome.add(lblInserisciDocenteNome);
		lblInserisciDocenteNome.setFont(font);

		pInserisciDocenteNome.add(txtInserisciDocenteNome);
		txtInserisciDocenteNome.setFont(font);
		txtInserisciDocenteNome.setPreferredSize(new Dimension(250, 25));

		pInserisciDocente.add(pInserisciDocenteNome);

		/* caratteristiche pannello per cognome docente */
		pInserisciDocenteCognome.setPreferredSize(new Dimension(1000, 40));
		pInserisciDocenteCognome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciDocenteCognome.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciDocenteCognome.add(lblInserisciDocenteCognome);
		lblInserisciDocenteCognome.setFont(font);

		pInserisciDocenteCognome.add(txtInserisciDocenteCognome);
		txtInserisciDocenteCognome.setFont(font);
		txtInserisciDocenteCognome.setPreferredSize(new Dimension(250, 25));

		pInserisciDocente.add(pInserisciDocenteCognome);

		/* caratteristiche pannello per matricola docente */
		pInserisciDocenteMatricola.setPreferredSize(new Dimension(1000, 40));
		pInserisciDocenteMatricola.setLayout(new FlowLayout(FlowLayout.LEFT));
		pInserisciDocenteMatricola.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciDocenteMatricola.add(lblInserisciDocenteMatricola);
		lblInserisciDocenteMatricola.setFont(font);

		pInserisciDocenteMatricola.add(txtInserisciDocenteMatricola);
		txtInserisciDocenteMatricola.setFont(font);
		txtInserisciDocenteMatricola.setPreferredSize(new Dimension(250, 25));

		pInserisciDocente.add(pInserisciDocenteMatricola);

		/* caratteristiche pannello per bottoni */
		pInserisciDocenteBottoni.setPreferredSize(new Dimension(1000, 40));
		pInserisciDocenteBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pInserisciDocenteBottoni.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciDocenteBottoni.add(btnInserisciDocenteInserisci);
		btnInserisciDocenteInserisci.setFont(font);
		btnInserisciDocenteInserisci.setBackground(Color.RED);
		btnInserisciDocenteInserisci.setForeground(Color.RED);
		btnInserisciDocenteInserisci.setPreferredSize(new Dimension(100, 30));
		pInserisciDocenteBottoni.add(btnInserisciDocenteCancella);
		btnInserisciDocenteCancella.setFont(font);
		btnInserisciDocenteCancella.setBackground(Color.RED);
		btnInserisciDocenteCancella.setForeground(Color.RED);
		btnInserisciDocenteCancella.setPreferredSize(new Dimension(100, 30));
		pInserisciDocenteBottoni.add(btnInserisciDocenteChiudi);
		btnInserisciDocenteChiudi.setFont(font);
		btnInserisciDocenteChiudi.setBackground(Color.RED);
		btnInserisciDocenteChiudi.setForeground(Color.RED);
		btnInserisciDocenteChiudi.setPreferredSize(new Dimension(100, 30));

		pInserisciDocente.add(pInserisciDocenteBottoni);
	}

	/* GET PULSANTI */
	public JMenuItem iInserisciDocenteMetodo() {
		return iInserisciDocente;
	}

	public String getTxtInserisciDocenteNome() {
		return txtInserisciDocenteNome.getText();
	}

	public String getTxtInserisciDocenteCognome() {
		return txtInserisciDocenteCognome.getText();
	}

	public String getTxtInserisciDocenteMatricola() {
		return txtInserisciDocenteMatricola.getText();
	}

	public int getSizeTxtInserisciDocenteMatricola() {
		return txtInserisciDocenteMatricola.getText().length();
	}

	public JButton getBtnInserisciDocenteInserisci() {
		return btnInserisciDocenteInserisci;
	}

	public JButton getBtnInserisciDocenteCancella() {
		return btnInserisciDocenteCancella;
	}

	public JButton getBtnInserisciDocenteChiudi() {
		return btnInserisciDocenteChiudi;
	}

	public void cancellapInserimentoDocente() {
		txtInserisciDocenteNome.setText(null);
		txtInserisciDocenteCognome.setText(null);
		txtInserisciDocenteMatricola.setText(null);
	}

	public void chiudipInserimentoDocente() {
		pInserisciDocente.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* PRENOTA AULA */
	/* GRAFICA */
	public void apriPanelPrenotaAula() {
		pPrenotaAula.setBorder(BorderFactory.createTitledBorder("Prenota Aula"));
		pPrenotaAula.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pPrenotaAula.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPrenotaAula.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(true);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pPrenotaAula, BorderLayout.EAST);

		/* caratteristiche pannello vuoto */
		// serve per staccare il tutto dal bordo superiore
		pVuoto.setPreferredSize(new Dimension(1000, 30));
		pVuoto.setLayout(new FlowLayout(FlowLayout.LEFT));
		pVuoto.setBackground(Color.WHITE); // metto colore sfondo al panel

		pInserisciDocente.add(pVuoto);

		/* TODO caratteristiche pannello per aula */
		pPrenotaAulaAula.setPreferredSize(new Dimension(1000, 40));
		pPrenotaAulaAula.setLayout(new FlowLayout(FlowLayout.LEFT));
		pPrenotaAulaAula.setBackground(Color.WHITE); // metto colore sfondo al panel

		pPrenotaAulaAula.add(lblPrenotaAulaAula);
		lblPrenotaAulaAula.setFont(font);

		pPrenotaAulaAula.add(cmbAula);
		cmbAula.setFont(font);
		cmbAula.setPreferredSize(new Dimension(250, 25));

		pPrenotaAulaAula.add(btnPrenotaAulaCarica);
		btnPrenotaAulaCarica.setFont(font);
		btnPrenotaAulaCarica.setBackground(Color.RED);
		btnPrenotaAulaCarica.setForeground(Color.RED);
		btnPrenotaAulaCarica.setPreferredSize(new Dimension(150, 30));

		pPrenotaAula.add(pPrenotaAulaAula);

		/* TODO caratteristiche pannello per docente */
		pPrenotaAulaDocente.setPreferredSize(new Dimension(1000, 40));
		pPrenotaAulaDocente.setLayout(new FlowLayout(FlowLayout.LEFT));
		pPrenotaAulaDocente.setBackground(Color.WHITE); // metto colore sfondo al panel

		pPrenotaAulaDocente.add(lblPrenotaAulaDocente);
		lblPrenotaAulaDocente.setFont(font);

		pPrenotaAulaDocente.add(txtPrenotaAulaDocente);
		txtPrenotaAulaDocente.setFont(font);
		txtPrenotaAulaDocente.setPreferredSize(new Dimension(250, 25));

		pPrenotaAula.add(pPrenotaAulaDocente);

		/* caratteristiche pannello per data */
		pPrenotaAulaData.setPreferredSize(new Dimension(1000, 40));
		pPrenotaAulaData.setLayout(new FlowLayout(FlowLayout.LEFT));
		pPrenotaAulaData.setBackground(Color.WHITE); // metto colore sfondo al panel

		pPrenotaAulaData.add(lblPrenotaAulaData);
		lblPrenotaAulaData.setFont(font);

		pPrenotaAulaData.add(cmbGiorni);
		cmbGiorni.setFont(font);
		cmbGiorni.setPreferredSize(new Dimension(50, 25));
		pPrenotaAulaData.add(cmbMesi);
		cmbMesi.setFont(font);
		cmbMesi.setPreferredSize(new Dimension(50, 25));
		pPrenotaAulaData.add(cmbAnni);
		cmbAnni.setFont(font);
		cmbAnni.setPreferredSize(new Dimension(100, 25));

		pPrenotaAula.add(pPrenotaAulaData);

		/* caratteristiche pannello per ora inizio */
		pPrenotaAulaOraInizio.setPreferredSize(new Dimension(1000, 40));
		pPrenotaAulaOraInizio.setLayout(new FlowLayout(FlowLayout.LEFT));
		pPrenotaAulaOraInizio.setBackground(Color.WHITE); // metto colore sfondo al panel

		pPrenotaAulaOraInizio.add(lblPrenotaAulaOraInizio);
		lblPrenotaAulaOraInizio.setFont(font);

		pPrenotaAulaOraInizio.add(cmbOraInizio);
		cmbOraInizio.setFont(font);
		cmbOraInizio.setPreferredSize(new Dimension(100, 25));

		pPrenotaAula.add(pPrenotaAulaOraInizio);

		/* caratteristiche pannello per bottoni */
		pPrenotaAulaBottoni.setPreferredSize(new Dimension(1000, 40));
		pPrenotaAulaBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPrenotaAulaBottoni.setBackground(Color.WHITE); // metto colore sfondo al panel

		pPrenotaAulaBottoni.add(btnPrenotaAulaPrenota);
		btnPrenotaAulaPrenota.setFont(font);
		btnPrenotaAulaPrenota.setBackground(Color.RED);
		btnPrenotaAulaPrenota.setForeground(Color.RED);
		btnPrenotaAulaPrenota.setPreferredSize(new Dimension(100, 30));
		pPrenotaAulaBottoni.add(btnPrenotaAulaCancella);
		btnPrenotaAulaCancella.setFont(font);
		btnPrenotaAulaCancella.setBackground(Color.RED);
		btnPrenotaAulaCancella.setForeground(Color.RED);
		btnPrenotaAulaCancella.setPreferredSize(new Dimension(100, 30));
		pPrenotaAulaBottoni.add(btnPrenotaAulaChiudi);
		btnPrenotaAulaChiudi.setFont(font);
		btnPrenotaAulaChiudi.setBackground(Color.RED);
		btnPrenotaAulaChiudi.setForeground(Color.RED);
		btnPrenotaAulaChiudi.setPreferredSize(new Dimension(100, 30));

		pPrenotaAula.add(pPrenotaAulaBottoni);
	}

	/* GET PULSANTI */
	public JMenuItem iPrenotaAulaMetodo() {
		return iPrenotaAula;
	}

	public String getcmbAula() {
		return cmbAula.getSelectedItem().toString();
	}

	public JButton getBtnPrenotaAulaCarica() {
		return btnPrenotaAulaCarica;
	}

	public String getTxtPrenotaAulaDocente() {
		return txtPrenotaAulaDocente.getText();
	}

	public String getCmbGiorni() {
		return cmbGiorni.getSelectedItem().toString();
	}

	public String getCmbMesi() {
		return cmbMesi.getSelectedItem().toString();
	}

	public String getCmbAnni() {
		return cmbAnni.getSelectedItem().toString();
	}

	public String getCmbOraInizio() {
		return cmbOraInizio.getSelectedItem().toString();
	}

	public JButton getBtnPrenotaAulaPrenota() {
		return btnPrenotaAulaPrenota;
	}

	public JButton getBtnPrenotaAulaCancella() {
		return btnPrenotaAulaCancella;
	}

	public JButton getBtnPrenotaAulaChiudi() {
		return btnPrenotaAulaChiudi;
	}

	public void cancellapPrenotaAula() {
		// TODO come faccio a pulire le combo box ???

		// cmbAula.setText(null);
		txtPrenotaAulaDocente.setText(null);
		// cmbData
		// cmbOraInizio
		// cmbOraFine
	}

	public void chiudipPrenotaAula() {
		pPrenotaAula.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* VISUALIZZA AULA */
	/* GRAFICA */
	public void apriPanelVisualizzaAula(ArrayList<Aula> aule) {
		pVisualizzaAula.setBorder(BorderFactory.createTitledBorder("Visualizza Aula"));
		pVisualizzaAula.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pVisualizzaAula.setLayout(new FlowLayout(FlowLayout.CENTER));
		pVisualizzaAula.setBackground(Color.RED); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(true);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pVisualizzaAula, BorderLayout.EAST);

		txtAreaVisualizzaAula.setPreferredSize(new Dimension(1000, 600));
		txtAreaVisualizzaAula.setFont(font);
		txtAreaVisualizzaAula.setText(null);
		txtAreaVisualizzaAula.append(aule.toString()); // come passo l'aula

		scrollVisualizzaAula.setPreferredSize(new Dimension(1080, 700));
		scrollVisualizzaAula.setFont(font);

		pVisualizzaAula.add(scrollVisualizzaAula);
	}

	/* GET PULSANTI */
	public JMenuItem iVisualizzaAulaMetodo() {
		return iVisualizzaAula;
	}

	/* VISUALIZZA DOCENTE */
	/* GRAFICA */
	public void apriPanelVisualizzaDocente(ArrayList<Docente> docenti) {
		pVisualizzaDocente.setBorder(BorderFactory.createTitledBorder("Visualizza Docente"));
		pVisualizzaDocente.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pVisualizzaDocente.setLayout(new FlowLayout(FlowLayout.CENTER));
		pVisualizzaDocente.setBackground(Color.RED); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(true);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pVisualizzaDocente, BorderLayout.EAST);

		txtAreaVisualizzaDocente.setPreferredSize(new Dimension(1000, 600));
		txtAreaVisualizzaDocente.setFont(font);
		scrollVisualizzaDocente.setPreferredSize(new Dimension(1080, 700));
		scrollVisualizzaDocente.setFont(font);
		txtAreaVisualizzaDocente.setText(null);
		txtAreaVisualizzaDocente.append(docenti.toString());

		pVisualizzaDocente.add(scrollVisualizzaDocente);
	}

	/* GET PULSANTI */
	public JMenuItem iVisualizzaDocenteMetodo() {
		return iVisualizzaDocente;
	}

	/* VISUALIZZA PRENOTAZIONE */
	/* GRAFICA */
	public void apriPanelVisualizzaPrenotazione(ArrayList<Prenotazione> prenotazioni) {
		pVisualizzaPrenotazione.setBorder(BorderFactory.createTitledBorder("Visualizza Prenotazione"));
		pVisualizzaPrenotazione.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pVisualizzaPrenotazione.setLayout(new FlowLayout(FlowLayout.CENTER));
		pVisualizzaPrenotazione.setBackground(Color.RED); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(true);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pVisualizzaPrenotazione, BorderLayout.EAST);

		txtAreaVisualizzaPrenotazione.setPreferredSize(new Dimension(1080, 700));
		txtAreaVisualizzaPrenotazione.setFont(font);
		// scrollVisualizzaDocente.setPreferredSize(new Dimension(1080, 700));
		// scrollVisualizzaDocente.setFont(font);
		// txtAreaVisualizzaDocente.setText(null);
		txtAreaVisualizzaPrenotazione.append(prenotazioni.toString());

		pVisualizzaPrenotazione.add(txtAreaVisualizzaPrenotazione);
	}

	/* GET PULSANTI */
	public JMenuItem iVisualizzaPrenotazioneMetodo() {
		return iVisualizzaPrenotazione;
	}

	/* MODIFICA AULA */
	/* GRAFICA */
	public void apriPanelModificaAula() {
		pModificaAula.setBorder(BorderFactory.createTitledBorder("Modifica Aula"));
		pModificaAula.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pModificaAula.setLayout(new FlowLayout(FlowLayout.CENTER));
		pModificaAula.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(true);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pModificaAula, BorderLayout.EAST);

		pModificaAulaNome.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pModificaAulaNome.setBackground(Color.WHITE);

		pModificaAulaNome.add(lblModificaAulaNome);
		lblModificaAulaNome.setFont(font);

		pModificaAulaNome.add(cmbModificaAulaNome);
		cmbModificaAulaNome.setFont(font);
		cmbModificaAulaNome.setPreferredSize(new Dimension(250, 25));

		pModificaAulaNome.add(btnModificaAulaCarica);
		btnModificaAulaCarica.setFont(font);
		btnModificaAulaCarica.setBackground(Color.RED);
		btnModificaAulaCarica.setForeground(Color.RED);
		btnModificaAulaCarica.setPreferredSize(new Dimension(150, 30));

		pModificaAula.add(pModificaAulaNome);

		/* caratteristiche bottoni */
		pModificaAulaBottoni.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pModificaAulaBottoni.setBackground(Color.WHITE);

		pModificaAulaBottoni.add(btnModificaAulaMostra);
		btnModificaAulaMostra.setFont(font);
		btnModificaAulaMostra.setBackground(Color.RED);
		btnModificaAulaMostra.setForeground(Color.RED);
		btnModificaAulaMostra.setPreferredSize(new Dimension(100, 30));
		pModificaAulaBottoni.add(btnModificaAulaCancella);
		btnModificaAulaCancella.setFont(font);
		btnModificaAulaCancella.setBackground(Color.RED);
		btnModificaAulaCancella.setForeground(Color.RED);
		btnModificaAulaCancella.setPreferredSize(new Dimension(100, 30));
		pModificaAulaBottoni.add(btnModificaAulaChiudi);
		btnModificaAulaChiudi.setFont(font);
		btnModificaAulaChiudi.setBackground(Color.RED);
		btnModificaAulaChiudi.setForeground(Color.RED);
		btnModificaAulaChiudi.setPreferredSize(new Dimension(100, 30));

		pModificaAula.add(pModificaAulaBottoni);

		pModificaAula.add(pVuoto);

		pModificaAulaModificaElementi.setPreferredSize(new Dimension(1000, 500));
		pModificaAulaModificaElementi.setLayout(new FlowLayout(FlowLayout.LEFT));
		pModificaAulaModificaElementi.setBackground(Color.WHITE);

		pModificaAula.add(pModificaAulaModificaElementi);

		pModificaAulaInserisciNome.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaInserisciNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pModificaAulaInserisciNome.setBackground(Color.WHITE); // metto colore sfondo al panel

		pModificaAulaInserisciNome.add(lblModificaAulaInserisciNome);
		lblModificaAulaInserisciNome.setFont(font);

		pModificaAulaInserisciNome.add(txtModificaAulaInserisciNome);
		txtModificaAulaInserisciNome.setFont(font);
		txtModificaAulaInserisciNome.setPreferredSize(new Dimension(250, 25));

		pModificaAulaModificaElementi.add(pModificaAulaInserisciNome);

		/* caratteristiche pannello per capienza aula */
		pModificaAulaInserisciCapienza.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaInserisciCapienza.setLayout(new FlowLayout(FlowLayout.LEFT));
		pModificaAulaInserisciCapienza.setBackground(Color.WHITE); // metto colore sfondo al panel

		pModificaAulaInserisciCapienza.add(lblModificaAulaInserisciCapienza);
		lblModificaAulaInserisciCapienza.setFont(font);

		pModificaAulaInserisciCapienza.add(txtModificaAulaInserisciCapienza);
		txtModificaAulaInserisciCapienza.setFont(font);
		txtModificaAulaInserisciCapienza.setPreferredSize(new Dimension(250, 25));

		pModificaAulaModificaElementi.add(pModificaAulaInserisciCapienza);

		/* caratteristiche pannello per tipo aula */
		pModificaAulaInserisciTipo.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaInserisciTipo.setLayout(new FlowLayout(FlowLayout.LEFT));
		pModificaAulaInserisciTipo.setBackground(Color.WHITE); // metto colore sfondo al panel

		pModificaAulaInserisciTipo.add(lblModificaAulaInserisciTipo);
		lblModificaAulaInserisciTipo.setFont(font);

		gruppoBottonirbmModificaAula.add(rbmModificaAulaInserisciTipoStandard);
		gruppoBottonirbmModificaAula.add(rbmModificaAulaInserisciTipoParticolare);
		pModificaAulaInserisciTipo.add(rbmModificaAulaInserisciTipoStandard);
		rbmModificaAulaInserisciTipoStandard.setFont(font);
		rbmModificaAulaInserisciTipoStandard.setBackground(Color.WHITE);
		pModificaAulaInserisciTipo.add(rbmModificaAulaInserisciTipoParticolare);
		rbmModificaAulaInserisciTipoParticolare.setFont(font);
		rbmModificaAulaInserisciTipoParticolare.setBackground(Color.WHITE);
		pModificaAulaInserisciTipo.add(cmbAulaParticolareModifica);
		cmbAulaParticolareModifica.setFont(font);
		cmbAulaParticolareModifica.setBackground(Color.WHITE);
		cmbAulaParticolareModifica.setEnabled(false);

		pModificaAulaModificaElementi.add(pModificaAulaInserisciTipo);

		/* caratteristiche pannello per dotazioni aula */
		pModificaAulaInserisciDotazioni.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaInserisciDotazioni.setLayout(new FlowLayout(FlowLayout.LEFT));
		pModificaAulaInserisciDotazioni.setBackground(Color.WHITE); // metto colore sfondo al panel

		pModificaAulaInserisciDotazioni.add(lblModificaAulaInserisciDotazioni);
		lblModificaAulaInserisciDotazioni.setFont(font);
		pModificaAulaInserisciDotazioni.add(cbxModificaAulaInserisciDotazioniProiettore);
		cbxModificaAulaInserisciDotazioniProiettore.setFont(font);
		cbxModificaAulaInserisciDotazioniProiettore.setBackground(Color.WHITE);
		pModificaAulaInserisciDotazioni.add(cbxModificaAulaInserisciDotazioniLavagna);
		cbxModificaAulaInserisciDotazioniLavagna.setFont(font);
		cbxModificaAulaInserisciDotazioniLavagna.setBackground(Color.WHITE);
		pModificaAulaInserisciDotazioni.add(cbxModificaAulaInserisciDotazioniMicrofono);
		cbxModificaAulaInserisciDotazioniMicrofono.setFont(font);
		cbxModificaAulaInserisciDotazioniMicrofono.setBackground(Color.WHITE);
		pModificaAulaInserisciDotazioni.add(cbxModificaAulaInserisciDotazioniVideocamera);
		cbxModificaAulaInserisciDotazioniVideocamera.setFont(font);
		cbxModificaAulaInserisciDotazioniVideocamera.setBackground(Color.WHITE);

		pModificaAulaModificaElementi.add(pModificaAulaInserisciDotazioni);

		/* caratteristiche pannello per bottoni */
		pModificaAulaInserisciBottoni.setPreferredSize(new Dimension(1000, 40));
		pModificaAulaInserisciBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pModificaAulaInserisciBottoni.setBackground(Color.WHITE); // metto colore sfondo al panel

		pModificaAulaInserisciBottoni.add(btnModificaAulaInserisciModifica);
		btnModificaAulaInserisciModifica.setFont(font);
		btnModificaAulaInserisciModifica.setBackground(Color.RED);
		btnModificaAulaInserisciModifica.setForeground(Color.RED);
		btnModificaAulaInserisciModifica.setPreferredSize(new Dimension(100, 30));

		pModificaAulaModificaElementi.add(pModificaAulaInserisciBottoni);
		pModificaAulaModificaElementi.setVisible(false);
	}

	/* GET PULSANTI */
	public JMenuItem iModificaAulaMetodo() {
		return iModificaAula;
	}

	public JPanel apripModificaAulaModificaElementi() {
		return pModificaAulaModificaElementi;
	}

	public String getCmbtModificaAulaNome() {
		return cmbModificaAulaNome.getSelectedItem().toString();
	}

	public String getTxtModificaAulaInserisciNome() {
		return txtModificaAulaInserisciNome.getText();
	}

	public String getTxtModificaAulaInserisciCapienza() {
		return txtModificaAulaInserisciCapienza.getText();
	}

	public boolean getRbmModificaAulaInserisciTipoStandard() {
		return rbmModificaAulaInserisciTipoStandard.isSelected();
	}

	public boolean getRbmModificaAulaInserisciTipoParticolare() {
		return rbmModificaAulaInserisciTipoParticolare.isSelected();
	}

	public String getCmbAulaParticolareModifica() {
		return cmbAulaParticolareModifica.getSelectedItem().toString();
	}

	public boolean getCbxModificaAulaInserisciDotazioniProiettore() {
		return cbxModificaAulaInserisciDotazioniProiettore.isSelected();
	}

	public boolean getCbxModificaAulaInserisciDotazioniLavagna() {
		return cbxModificaAulaInserisciDotazioniLavagna.isSelected();
	}

	public boolean getCbxModificaAulaInserisciDotazioniMicrofono() {
		return cbxModificaAulaInserisciDotazioniMicrofono.isSelected();
	}

	public boolean getCbxModificaAulaInserisciDotazioniVideocamera() {
		return cbxModificaAulaInserisciDotazioniVideocamera.isSelected();
	}

	public JButton getBtnModificaAulaCarica() {
		return btnModificaAulaCarica;
	}

	public JButton getBtnModificaAulaMostra() {
		return btnModificaAulaMostra;
	}

	public JButton getBtnModificaAulaCancella() {
		return btnModificaAulaCancella;
	}

	public JButton getBtnModificaAulaChiudi() {
		return btnModificaAulaChiudi;
	}

	public JButton getBtnModificaAulaInserisciModifica() {
		return btnModificaAulaInserisciModifica;
	}

	/* METODI */
	// TODO come si fa????
	public void cancellapModificaAula() {

	}

	public void chiudipModificaAula() {
		pModificaAula.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* ELIMINA AULA */
	/* GRAFICA */
	public void apriPanelEliminaAula() {
		pEliminaAula.setBorder(BorderFactory.createTitledBorder("Elimina Aula"));
		pEliminaAula.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pEliminaAula.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEliminaAula.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(true);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pEliminaAula, BorderLayout.EAST);

		pEliminaAulaNome.setPreferredSize(new Dimension(1000, 40));
		pEliminaAulaNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaAulaNome.setBackground(Color.WHITE);

		pEliminaAulaNome.add(lblEliminaAulaNome);
		lblEliminaAulaNome.setFont(font);

		pEliminaAulaNome.add(cmbEliminaAula);
		cmbEliminaAula.setFont(font);
		cmbEliminaAula.setPreferredSize(new Dimension(250, 25));

		pEliminaAulaNome.add(btnEliminaAulaCarica);
		btnEliminaAulaCarica.setFont(font);
		btnEliminaAulaCarica.setBackground(Color.RED);
		btnEliminaAulaCarica.setForeground(Color.RED);
		btnEliminaAulaCarica.setPreferredSize(new Dimension(150, 30));

		pEliminaAula.add(pEliminaAulaNome);

		/* caratteristiche bottoni */
		pEliminaAulaBottoni.setPreferredSize(new Dimension(1000, 40));
		pEliminaAulaBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEliminaAulaBottoni.setBackground(Color.WHITE);

		pEliminaAulaBottoni.add(btnEliminaAulaElimina);
		btnEliminaAulaElimina.setFont(font);
		btnEliminaAulaElimina.setBackground(Color.RED);
		btnEliminaAulaElimina.setForeground(Color.RED);
		btnEliminaAulaElimina.setPreferredSize(new Dimension(100, 30));
		pEliminaAulaBottoni.add(btnEliminaAulaCancella);
		btnEliminaAulaCancella.setFont(font);
		btnEliminaAulaCancella.setBackground(Color.RED);
		btnEliminaAulaCancella.setForeground(Color.RED);
		btnEliminaAulaCancella.setPreferredSize(new Dimension(100, 30));
		pEliminaAulaBottoni.add(btnEliminaAulaChiudi);
		btnEliminaAulaChiudi.setFont(font);
		btnEliminaAulaChiudi.setBackground(Color.RED);
		btnEliminaAulaChiudi.setForeground(Color.RED);
		btnEliminaAulaChiudi.setPreferredSize(new Dimension(100, 30));

		pEliminaAula.add(pEliminaAulaBottoni);
	}

	/* GET PULSANTI */
	public JMenuItem iEliminaAulaMetodo() {
		return iEliminaAula;
	}

	public String getCmbEliminaAulaNome() {
		return cmbEliminaAula.getSelectedItem().toString();
	}

	public JButton getBtnEliminaAulaCarica() {
		return btnEliminaAulaCarica;
	}

	public JButton getBtnEliminaAulaElimina() {
		return btnEliminaAulaElimina;
	}

	public JButton getBtnEliminaAulaCancella() {
		return btnEliminaAulaCancella;
	}

	public JButton getBtnEliminaAulaChiudi() {
		return btnEliminaAulaChiudi;
	}

	/* METODI */
	// TODO come si fa????
	public void cancellapEliminaAula() {

	}

	public void chiudipEliminaAula() {
		pEliminaAula.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* ELIMINA DOCENTE */
	/* GRAFICA */
	public void apriPanelEliminaDocente() {
		pEliminaDocente.setBorder(BorderFactory.createTitledBorder("Elimina Docente"));
		pEliminaDocente.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pEliminaDocente.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEliminaDocente.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(true);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pEliminaDocente, BorderLayout.EAST);

		pEliminaDocenteNome.setPreferredSize(new Dimension(1000, 40));
		pEliminaDocenteNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaDocenteNome.setBackground(Color.WHITE);

		pEliminaDocenteNome.add(lblEliminaDocenteMatricola);
		lblEliminaDocenteMatricola.setFont(font);

		pEliminaDocenteNome.add(txtEliminaDocenteMatricola);
		txtEliminaDocenteMatricola.setFont(font);
		txtEliminaDocenteMatricola.setPreferredSize(new Dimension(250, 25));

		pEliminaDocente.add(pEliminaDocenteNome);

		/* caratteristiche bottoni */
		pEliminaDocenteBottoni.setPreferredSize(new Dimension(1000, 40));
		pEliminaDocenteBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEliminaDocenteBottoni.setBackground(Color.WHITE);

		pEliminaDocenteBottoni.add(btnEliminaDocenteElimina);
		btnEliminaDocenteElimina.setFont(font);
		btnEliminaDocenteElimina.setBackground(Color.RED);
		btnEliminaDocenteElimina.setForeground(Color.RED);
		btnEliminaDocenteElimina.setPreferredSize(new Dimension(100, 30));
		pEliminaDocenteBottoni.add(btnEliminaDocenteCancella);
		btnEliminaDocenteCancella.setFont(font);
		btnEliminaDocenteCancella.setBackground(Color.RED);
		btnEliminaDocenteCancella.setForeground(Color.RED);
		btnEliminaDocenteCancella.setPreferredSize(new Dimension(100, 30));
		pEliminaDocenteBottoni.add(btnEliminaDocenteChiudi);
		btnEliminaDocenteChiudi.setFont(font);
		btnEliminaDocenteChiudi.setBackground(Color.RED);
		btnEliminaDocenteChiudi.setForeground(Color.RED);
		btnEliminaDocenteChiudi.setPreferredSize(new Dimension(100, 30));

		pEliminaDocente.add(pEliminaDocenteBottoni);
	}

	/* GET PULSANTI */
	public JMenuItem iEliminaDocenteMetodo() {
		return iEliminaDocente;
	}

	public String getTxtEliminaDocenteMatricola() {
		return txtEliminaDocenteMatricola.getText();
	}

	public JButton getBtnEliminaDocenteElimina() {
		return btnEliminaDocenteElimina;
	}

	public JButton getBtnEliminaDocenteCancella() {
		return btnEliminaDocenteCancella;
	}

	public JButton getBtnEliminaDocenteChiudi() {
		return btnEliminaDocenteChiudi;
	}

	/* METODI */
	public void cancellapEliminaDocente() {
		txtEliminaDocenteMatricola.setText(null);
	}

	public void chiudipEliminaDocente() {
		pEliminaDocente.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* ELIMINA PRENOTAZIONE */
	/* GRAFICA */
	public void apriPanelEliminaPrenotazione() {
		pEliminaPrenotazione.setBorder(BorderFactory.createTitledBorder("Elimina Prenotazione"));
		pEliminaPrenotazione.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pEliminaPrenotazione.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEliminaPrenotazione.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(true);
		pStampaReport.setVisible(false);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pEliminaPrenotazione, BorderLayout.EAST);

		pEliminaPrenotazioneNome.setPreferredSize(new Dimension(1000, 40));
		pEliminaPrenotazioneNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaPrenotazioneNome.setBackground(Color.WHITE);

		pEliminaPrenotazioneNome.add(lblEliminaPrenotazioneNome);
		lblEliminaPrenotazioneNome.setFont(font);

		pEliminaPrenotazioneNome.add(cmbEliminaPrenotazioneAula);
		cmbEliminaPrenotazioneAula.setFont(font);
		cmbEliminaPrenotazioneAula.setPreferredSize(new Dimension(250, 25));

		pEliminaPrenotazioneNome.add(btnEliminaPrenotazioneCarica);
		btnEliminaPrenotazioneCarica.setFont(font);
		btnEliminaPrenotazioneCarica.setBackground(Color.RED);
		btnEliminaPrenotazioneCarica.setForeground(Color.RED);
		btnEliminaPrenotazioneCarica.setPreferredSize(new Dimension(150, 30));

		pEliminaPrenotazione.add(pEliminaPrenotazioneNome);

		pEliminaPrenotazioneMatricola.setPreferredSize(new Dimension(1000, 40));
		pEliminaPrenotazioneMatricola.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaPrenotazioneMatricola.setBackground(Color.WHITE);

		pEliminaPrenotazioneMatricola.add(lblEliminaPrenotazioneMatricola);
		lblEliminaPrenotazioneMatricola.setFont(font);

		pEliminaPrenotazioneMatricola.add(txtEliminaPrenotazioneMatricola);
		txtEliminaPrenotazioneMatricola.setFont(font);
		txtEliminaPrenotazioneMatricola.setPreferredSize(new Dimension(250, 25));

		pEliminaPrenotazione.add(pEliminaPrenotazioneMatricola);

		/* caratteristiche bottoni */
		pEliminaPrenotazioneBottoni.setPreferredSize(new Dimension(1000, 40));
		pEliminaPrenotazioneBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEliminaPrenotazioneBottoni.setBackground(Color.WHITE);

		pEliminaPrenotazioneBottoni.add(btnEliminaPrenotazioneCerca);
		btnEliminaPrenotazioneCerca.setFont(font);
		btnEliminaPrenotazioneCerca.setBackground(Color.RED);
		btnEliminaPrenotazioneCerca.setForeground(Color.RED);
		btnEliminaPrenotazioneCerca.setPreferredSize(new Dimension(100, 30));
		pEliminaPrenotazioneBottoni.add(btnEliminaPrenotazioneCancella);
		btnEliminaPrenotazioneCancella.setFont(font);
		btnEliminaPrenotazioneCancella.setBackground(Color.RED);
		btnEliminaPrenotazioneCancella.setForeground(Color.RED);
		btnEliminaPrenotazioneCancella.setPreferredSize(new Dimension(100, 30));
		pEliminaPrenotazioneBottoni.add(btnEliminaPrenotazioneChiudi);
		btnEliminaPrenotazioneChiudi.setFont(font);
		btnEliminaPrenotazioneChiudi.setBackground(Color.RED);
		btnEliminaPrenotazioneChiudi.setForeground(Color.RED);
		btnEliminaPrenotazioneChiudi.setPreferredSize(new Dimension(100, 30));

		pEliminaPrenotazione.add(pEliminaPrenotazioneBottoni);

		pEliminaPrenotazioneRicerca.setPreferredSize(new Dimension(1080, 565));
		pEliminaPrenotazioneRicerca.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaPrenotazioneRicerca.setBackground(Color.WHITE);

		pEliminaPrenotazioneRicercaVisualizza.setPreferredSize(new Dimension(1040, 500));
		pEliminaPrenotazioneRicercaVisualizza.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaPrenotazioneRicercaVisualizza.setBackground(Color.WHITE);

		pEliminaPrenotazioneRicercaVisualizza.add(txtEliminaPrenotazioneVisualizza);
		txtEliminaPrenotazioneVisualizza.setFont(font);
		txtEliminaPrenotazioneVisualizza.setPreferredSize(new Dimension(1040, 500));
		// txtEliminaPrenotazioneVisualizza.append(); -> mi sa che va nel controller

		pEliminaPrenotazioneRicerca.add(pEliminaPrenotazioneRicercaVisualizza);

		pEliminaPrenotazioneRicercaElimina.setPreferredSize(new Dimension(1000, 50));
		pEliminaPrenotazioneRicercaElimina.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEliminaPrenotazioneRicercaElimina.setBackground(Color.WHITE);

		pEliminaPrenotazioneRicercaElimina.add(lblEliminaPrenotazioneID);
		lblEliminaPrenotazioneID.setFont(font);

		pEliminaPrenotazioneRicercaElimina.add(txtEliminaPrenotazioneID);
		txtEliminaPrenotazioneID.setFont(font);
		txtEliminaPrenotazioneID.setPreferredSize(new Dimension(250, 25));

		pEliminaPrenotazioneRicercaElimina.add(btnEliminaPrenotazioneElimina);
		btnEliminaPrenotazioneElimina.setFont(font);
		btnEliminaPrenotazioneElimina.setBackground(Color.RED);
		btnEliminaPrenotazioneElimina.setForeground(Color.RED);
		btnEliminaPrenotazioneElimina.setPreferredSize(new Dimension(100, 30));

		pEliminaPrenotazioneRicerca.add(pEliminaPrenotazioneRicercaElimina);
		pEliminaPrenotazioneRicerca.setVisible(false);

		pEliminaPrenotazione.add(pEliminaPrenotazioneRicerca);
	}

	/* GET PULSANTI */
	public JMenuItem iEliminaPrenotazioneMetodo() {
		return iEliminaPrenotazione;
	}

	public JPanel apripEliminaPrenotazioneRicerca() {
		return pEliminaPrenotazioneRicerca;
	}

	public String getCmbEliminaPrenotazioneAula() {
		return cmbEliminaPrenotazioneAula.getSelectedItem().toString();
	}

	public JButton getBtnEliminaPrenotazioneCarica() {
		return btnEliminaPrenotazioneCarica;
	}

	public String getTxtEliminaPrenotazioneMatricola() {
		return txtEliminaPrenotazioneMatricola.getText();
	}

	public String getTxtEliminaPrenotazioneID() {
		return txtEliminaPrenotazioneID.getText();
	}

	public JButton getBtnEliminaPrenotazioneCerca() {
		return btnEliminaPrenotazioneCerca;
	}

	public JButton getBtnEliminaPrenotazioneCancella() {
		return btnEliminaPrenotazioneCancella;
	}

	public JButton getBtnEliminaPrenotazioneChiudi() {
		return btnEliminaPrenotazioneChiudi;
	}

	public JButton getBtnEliminaPrenotazioneElimina() {
		return btnEliminaPrenotazioneElimina;
	}

	/* METODI */
	public void cancellapEliminaPrenotazione() {
		txtEliminaPrenotazioneMatricola.setText(null);
	}

	public void chiudipEliminaPrenotazione() {
		pEliminaPrenotazione.setVisible(false);
		pInziodx.setVisible(true);
	}

	/* STAMPA REPORT */
	/* GRAFICA */
	public void apriPanelStampaReport() {
		pStampaReport.setBorder(BorderFactory.createTitledBorder("Stampa Report"));
		pStampaReport.setPreferredSize(new Dimension(1102, 718)); // parte dx del frame
		pStampaReport.setLayout(new FlowLayout(FlowLayout.CENTER));
		pStampaReport.setBackground(Color.WHITE); // metto colore sfondo al panel

		// stabilisco quale panel deve essere visibile
		pInzio.setVisible(true);
		pInziodx.setVisible(false);
		pInserisciAula.setVisible(false);
		pInserisciDocente.setVisible(false);
		pPrenotaAula.setVisible(false);
		pVisualizzaAula.setVisible(false);
		pVisualizzaDocente.setVisible(false);
		pVisualizzaPrenotazione.setVisible(false);
		pModificaAula.setVisible(false);
		pEliminaAula.setVisible(false);
		pEliminaDocente.setVisible(false);
		pEliminaPrenotazione.setVisible(false);
		pStampaReport.setVisible(true);

		/* AGGIUNTA AL PANEL / FRAME */
		fInzio.add(pStampaReport, BorderLayout.EAST);

		pStampaReportMatricola.setPreferredSize(new Dimension(1000, 40));
		pStampaReportMatricola.setLayout(new FlowLayout(FlowLayout.LEFT));
		pStampaReportMatricola.setBackground(Color.WHITE);

		pStampaReportMatricola.add(lblStampaReportMatricola);
		lblStampaReportMatricola.setFont(font);

		pStampaReportMatricola.add(txtStampaReportMatricola);
		txtStampaReportMatricola.setFont(font);
		txtStampaReportMatricola.setPreferredSize(new Dimension(250, 25));

		pStampaReport.add(pStampaReportMatricola);

		/* caratteristiche bottoni */
		pStampaReportBottoni.setPreferredSize(new Dimension(1000, 40));
		pStampaReportBottoni.setLayout(new FlowLayout(FlowLayout.CENTER));
		pStampaReportBottoni.setBackground(Color.WHITE);

		pStampaReportBottoni.add(btnStampaReportMostra);
		btnStampaReportMostra.setFont(font);
		btnStampaReportMostra.setBackground(Color.RED);
		btnStampaReportMostra.setForeground(Color.RED);
		btnStampaReportMostra.setPreferredSize(new Dimension(100, 30));
		pStampaReportBottoni.add(btnStampaReportCancella);
		btnStampaReportCancella.setFont(font);
		btnStampaReportCancella.setBackground(Color.RED);
		btnStampaReportCancella.setForeground(Color.RED);
		btnStampaReportCancella.setPreferredSize(new Dimension(100, 30));
		pStampaReportBottoni.add(btnStampaReportChiudi);
		btnStampaReportChiudi.setFont(font);
		btnStampaReportChiudi.setBackground(Color.RED);
		btnStampaReportChiudi.setForeground(Color.RED);
		btnStampaReportChiudi.setPreferredSize(new Dimension(100, 30));

		pStampaReport.add(pStampaReportBottoni);

		pStampaReportVisualizza.setPreferredSize(new Dimension(1080, 610));
		pStampaReportVisualizza.setLayout(new FlowLayout(FlowLayout.LEFT));
		pStampaReportVisualizza.setBackground(Color.RED);

		pStampaReportVisualizza.add(txtAreaStampaReportVisualizza);
		txtAreaStampaReportVisualizza.setPreferredSize(new Dimension(1070, 600));
		txtAreaStampaReportVisualizza.setFont(font);
		pStampaReportVisualizza.add(scrollStampaReportVisualizza);
		scrollStampaReportVisualizza.setPreferredSize(new Dimension(1080, 610));
		scrollStampaReportVisualizza.setFont(font);
		// txtAreaVisualizzaAula.setText(null);
		// txtAreaVisualizzaAula.append(aula.toString());

		pStampaReportVisualizza.setVisible(false);
		pStampaReport.add(pStampaReportVisualizza);
	}

	/* GET PULSANTI */
	public JMenuItem iStampaReportMetodo() {
		return iStampaReport;
	}

	public String getTxtStampaReportMatricola() {
		return txtStampaReportMatricola.getText();
	}

	public JButton getBtnStampaReportMostra() {
		return btnStampaReportMostra;
	}

	public JButton getBtnStampaReportCancella() {
		return btnStampaReportCancella;
	}

	public JButton getBtnStampaReportChiudi() {
		return btnStampaReportChiudi;
	}

	/* METODI */
	public void cancellapStampaReport() {
		txtStampaReportMatricola.setText(null);
		txtAreaStampaReportVisualizza.setText(null);
	}

	public void chiudipStampaReport() {
		pStampaReport.setVisible(false);
		pInziodx.setVisible(true);
	}

	public void Errore(String campo, String panel) {
		switch (panel) {
		/* INSERISCI AULA */
		case "InserisciAula":
			JOptionPane.showMessageDialog(pInserisciAula, "ERRORE! Il campo " + campo + " risulta vuoto o errato.",
					"ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		case "DupInserisciAula":
			JOptionPane.showMessageDialog(pInserisciAula, "Esiste già un'aula con questo nome!", "ERRORE",
					JOptionPane.ERROR_MESSAGE);
			break;
		/* INSERISCI DOCENTE */
		case "InserisciDocente":
			JOptionPane.showMessageDialog(pInserisciDocente, "ERRORE! Il campo " + campo + " risulta vuoto o errato.",
					"ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		case "InserisciDocenteMatricola":
			JOptionPane.showMessageDialog(pInserisciDocente, "ERRORE! Il campo " + campo
					+ " risulta vuoto o errato.\nLa lunghezza della " + campo + " deve essere di 8 cifre!", "ERRORE",
					JOptionPane.ERROR_MESSAGE);
			break;
		case "DupInserisciDocente":
			JOptionPane.showMessageDialog(pInserisciDocente, "Esiste già un docente con questa matricola!", "ERRORE",
					JOptionPane.ERROR_MESSAGE);
			break;
		/* PRENOTA AULA */
		case "PrenotaAulaCarica":
			JOptionPane.showMessageDialog(pPrenotaAula, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		case "PrenotaAula":
			JOptionPane.showMessageDialog(pPrenotaAula, "ERRORE! Il campo " + campo + " risulta vuoto o errato.",
					"ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		case "PrenotaAulaData":
			JOptionPane.showMessageDialog(pPrenotaAula, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		case "DupPrenotaAula":
			JOptionPane.showMessageDialog(pPrenotaAula,
					"Esiste già una prenotazione di quest'aula da parte di questo docente!", "ERRORE",
					JOptionPane.ERROR_MESSAGE);
			break;
		/* VISUALIZZA AULA */
		case "VisualizzaAula":
			JOptionPane.showMessageDialog(pVisualizzaAula, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* VISUALIZZA DOCENTE */
		case "VisualizzaDocente":
			JOptionPane.showMessageDialog(pVisualizzaDocente, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* VISUALIZZA PRENOTAZIONE */
		case "VisualizzaPrenotazione":
			JOptionPane.showMessageDialog(pVisualizzaPrenotazione, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* MODIFICA AULA */
		case "ModificaAula":
			JOptionPane.showMessageDialog(pModificaAula, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* ELIMINA AULA */
		case "EliminaAula":
			JOptionPane.showMessageDialog(pEliminaAula, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* ELIMINA DOCENTE */
		case "EliminaDocente":
			JOptionPane.showMessageDialog(pEliminaDocente, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* ELIMINA PRENOTAZIONE */
		case "EliminaPrenotazione":
			JOptionPane.showMessageDialog(pEliminaPrenotazione, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		/* STAMPA REPORT */
		case "StampaReport":
			JOptionPane.showMessageDialog(pStampaReport, campo, "ERRORE", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	public void tuttoOK(String panel) {
		switch (panel) {
		/* INSERISCI AULA */
		case "InserisciAula":
			JOptionPane.showMessageDialog(pInserisciAula, "AULA INSERITA");
			cancellapInserimentoAula();
			break;
		/* INSERISCI DOCENTE */
		case "InserisciDocente":
			JOptionPane.showMessageDialog(pInserisciDocente, "DOCENTE INSERITO");
			cancellapInserimentoDocente();
			break;
		/* PRENOTA AULA */
		case "PrenotaAula":
			JOptionPane.showMessageDialog(pPrenotaAula, "AULA PRENOTATA");
			cancellapPrenotaAula();
			break;
		/* MODIFICA AULA */
		case "ModificaAula":
			JOptionPane.showMessageDialog(pModificaAula, "AULA MODIFICATA");
			cancellapModificaAula();
			break;
		/* ELIMINA AULA */
		case "EliminaAula":
			JOptionPane.showMessageDialog(pEliminaAula, "AULA ELIMINATA");
			cancellapEliminaAula();
			break;
		/* ELIMINA DOCENTE */
		case "EliminaDocente":
			JOptionPane.showMessageDialog(pEliminaDocente, "DOCENTE ELIMINATO");
			cancellapEliminaDocente();
			break;
		/* ELIMINA PRENOTAZIONE */
		case "EliminaPrenotazione":
			JOptionPane.showMessageDialog(pEliminaPrenotazione, "PRENOTAZIONE ELIMINATA");
			cancellapEliminaPrenotazione();
			break;
		}
	}

	/* LISTENER */
	public void ListenerView() {
		/* INSERISCI AULA */
		ActionListener ActionListenerInserisciAula;
		ActionListener ActionListenerInserisciAulaCancella;
		ActionListener ActionListenerInserisciAulaChiudi;
		ActionListener ActionListenerInserisciAulaParticolare;

		/* INSERISCI DOCENTE */
		ActionListener ActionListenerInserisciDocente;
		ActionListener ActionListenerInserisciDocenteCancella;
		ActionListener ActionListenerInserisciDocenteChiudi;

		/* PRENOTA AULA */
		ActionListener ActionListenerPrenotaAula;
		ActionListener ActionListenerPrenotaAulaCancella;
		ActionListener ActionListenerPrenotaAulaChiudi;

		/* MODIFICA AULA */
		ActionListener ActionListenerModificaAula;
		ActionListener ActionListenerModificaAulaCancella;
		ActionListener ActionListenerModificaAulaChiudi;

		/* ELIMINA AULA */
		ActionListener ActionListenerEliminaAula;
		ActionListener ActionListenerEliminaAulaCancella;
		ActionListener ActionListenerEliminaAulaChiudi;

		/* ELIMINA DOCENTE */
		ActionListener ActionListenerEliminaDocente;
		ActionListener ActionListenerEliminaDocenteCancella;
		ActionListener ActionListenerEliminaDocenteChiudi;

		/* ELIMINA PRENOTAZIONE */
		ActionListener ActionListenerEliminaPrenotazione;
		ActionListener ActionListenerEliminaPrenotazioneCancella;
		ActionListener ActionListenerEliminaPrenotazioneChiudi;

		/* STAMPA REPORT */
		ActionListener ActionListenerStampaReport;
		ActionListener ActionListenerStampaReportCancella;
		ActionListener ActionListenerStampaReportChiudi;

		/* INSERISCI AULA */
		// quello che attiva il pulsante Menu
		ActionListenerInserisciAula = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // metodo che genera un evento
				apriPanelInserisciAula();
			}
		};
		getInserisciAula().addActionListener(ActionListenerInserisciAula);

		// quello che attiva il bottone Cancella
		ActionListenerInserisciAulaCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapInserimentoAula();
			}
		};
		getBtnInserisciAulaCancella().addActionListener(ActionListenerInserisciAulaCancella);

		// quello che attiva il bottone Chiudi
		ActionListenerInserisciAulaChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipInserimentoAula();
			}
		};
		getBtnInserisciAulaChiudi().addActionListener(ActionListenerInserisciAulaChiudi);

		// quello che attiva la combobox
		ActionListenerInserisciAulaParticolare = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean selezione = getRbmInserisciAulaTipoParticolare();
				cmbAulaParticolare.setEnabled(selezione);
			}
		};
		rbmInserisciAulaTipoStandard.addActionListener(ActionListenerInserisciAulaParticolare);
		rbmInserisciAulaTipoParticolare.addActionListener(ActionListenerInserisciAulaParticolare);

		/* INSERISCI DOCENTE */
		ActionListenerInserisciDocente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelInserisciDocente();
			}
		};
		iInserisciDocenteMetodo().addActionListener(ActionListenerInserisciDocente);

		// quello che attiva il bottone Cancella
		ActionListenerInserisciDocenteCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapInserimentoDocente();
			}
		};
		getBtnInserisciDocenteCancella().addActionListener(ActionListenerInserisciDocenteCancella);

		// quello che attiva il bottone Chiudi
		ActionListenerInserisciDocenteChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipInserimentoDocente();
			}
		};
		getBtnInserisciDocenteChiudi().addActionListener(ActionListenerInserisciDocenteChiudi);

		/* PRENOTA AULA */
		ActionListenerPrenotaAula = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelPrenotaAula();

			}
		};
		iPrenotaAulaMetodo().addActionListener(ActionListenerPrenotaAula);

		// quello che attiva il bottone Cancella
		ActionListenerPrenotaAulaCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapPrenotaAula();
			}
		};
		getBtnPrenotaAulaCancella().addActionListener(ActionListenerPrenotaAulaCancella);

		// quello che attiva il bottone Chiudi
		ActionListenerPrenotaAulaChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipPrenotaAula();
			}
		};
		getBtnPrenotaAulaChiudi().addActionListener(ActionListenerPrenotaAulaChiudi);

		/* MODIFICA AULA */
		ActionListenerModificaAula = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelModificaAula();
			}
		};
		iModificaAulaMetodo().addActionListener(ActionListenerModificaAula);

		ActionListenerModificaAulaCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapModificaAula();
			}
		};
		getBtnModificaAulaCancella().addActionListener(ActionListenerModificaAulaCancella);

		ActionListenerModificaAulaChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipModificaAula();
			}
		};
		getBtnModificaAulaChiudi().addActionListener(ActionListenerModificaAulaChiudi);

		/* ELIMINA AULA */
		ActionListenerEliminaAula = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelEliminaAula();
			}
		};
		iEliminaAulaMetodo().addActionListener(ActionListenerEliminaAula);

		ActionListenerEliminaAulaCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapEliminaAula();
			}
		};
		getBtnEliminaAulaCancella().addActionListener(ActionListenerEliminaAulaCancella);

		ActionListenerEliminaAulaChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipEliminaAula();
			}
		};
		getBtnEliminaAulaChiudi().addActionListener(ActionListenerEliminaAulaChiudi);

		/* ELIMINA DOCENTE */
		ActionListenerEliminaDocente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelEliminaDocente();
			}
		};
		iEliminaDocenteMetodo().addActionListener(ActionListenerEliminaDocente);

		ActionListenerEliminaDocenteCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapEliminaDocente();
			}
		};
		getBtnEliminaDocenteCancella().addActionListener(ActionListenerEliminaDocenteCancella);

		ActionListenerEliminaDocenteChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipEliminaDocente();
			}
		};
		getBtnEliminaDocenteChiudi().addActionListener(ActionListenerEliminaDocenteChiudi);

		/* ELIMINA PRENOTAZIONE */
		ActionListenerEliminaPrenotazione = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelEliminaPrenotazione();
			}
		};
		iEliminaPrenotazioneMetodo().addActionListener(ActionListenerEliminaPrenotazione);

		ActionListenerEliminaPrenotazioneCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapEliminaPrenotazione();
			}
		};
		getBtnEliminaPrenotazioneCancella().addActionListener(ActionListenerEliminaPrenotazioneCancella);

		ActionListenerEliminaPrenotazioneChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipEliminaPrenotazione();
			}
		};
		getBtnEliminaPrenotazioneChiudi().addActionListener(ActionListenerEliminaPrenotazioneChiudi);

		/* STAMPA REPORT */
		ActionListenerStampaReport = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apriPanelStampaReport();
			}
		};
		iStampaReportMetodo().addActionListener(ActionListenerStampaReport);

		ActionListenerStampaReportCancella = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancellapStampaReport();
			}
		};
		getBtnStampaReportCancella().addActionListener(ActionListenerStampaReportCancella);

		ActionListenerStampaReportChiudi = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chiudipStampaReport();
			}
		};
		getBtnStampaReportChiudi().addActionListener(ActionListenerStampaReportChiudi);
	}
}