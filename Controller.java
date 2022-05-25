package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import upo.progetto.*;

public class Controller {
	private View view;
	private Model model;
	// private Aula a;
	// private Docente d; -> da dichiarare nel metodo, perchè è una variabile di
	// classe, che serve solo nel metodo, perchè nel controller servono solo i
	// listener
	// private Prenotazione p;
	// private Report r;

	// costruttore
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void ListenerController() {
		ActionListener ActionListenerInserisciAulaInserisci;
		ActionListener ActionListenerInserisciDocenteInserisci;
		ActionListener ActionListenerPrenotaAulaCarica;
		ActionListener ActionListenerPrenotaAulaPrenota;
		ActionListener ActionListenerVisualizzaAula;
		ActionListener ActionListenerVisualizzaDocente;
		ActionListener ActionListenerVisualizzaPrenotazione;
		ActionListener ActionListenerModificaAulaCarica;
		ActionListener ActionListenerModificaAulaMostra;
		ActionListener ActionListenerModificaAulaInserisciAulaParticolare;
		ActionListener ActionListenerModificaAulaModifica;
		ActionListener ActionListenerEliminaAulaCarica;
		ActionListener ActionListenerEliminaAulaElimina;
		ActionListener ActionListenerEliminaDocenteElimina;
		ActionListener ActionListenerEliminaPrenotazioneCarica;
		ActionListener ActionListenerEliminaPrenotazioneCerca;
		ActionListener ActionListenerEliminaPrenotazioneElimina;
		// ActionListener ActionListenerStampaReportMostra;

		/* INSERISCI AULA */
		ActionListenerInserisciAulaInserisci = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aula a;
				ArrayList<Dotazione> dotAula = new ArrayList<Dotazione>();
				AulaParticolare ap = AulaParticolare.STANDARD;

				if (view.getTxtInserisciAulaNome().isEmpty() || view.getTxtInserisciAulaNome() == null) {
					view.Errore("NOME AULA", "InserisciAula");
				} else {
					if (view.getTxtInserisciAulaCapienza().isEmpty() || view.getTxtInserisciAulaCapienza() == null) {
						view.Errore("CAPIENZA AULA", "InserisciAula");
					} else {
						// if (!(view.getRbmInserisciAulaTipoStandard()) &&
						// !(view.getRbmInserisciAulaTipoParticolare())) {
						// view.Errore("TIPO AULA", "InserisciAula");
						// } else {
						if (view.getCbxInserisciAulaDotazioniProiettore()) {
							dotAula.add(Dotazione.PROIETTORE);
						}
						if (view.getCbxInserisciAulaDotazioniLavagna()) {
							dotAula.add(Dotazione.LAVAGNA);
						}
						if (view.getCbxInserisciAulaDotazioniMicrofono()) {
							dotAula.add(Dotazione.MICROFONO);
						}
						if (view.getCbxInserisciAulaDotazioniVideocamera()) {
							dotAula.add(Dotazione.VIDEOCAMERA);
						}
						// if (dotAula.isEmpty()) {
						// view.Errore("DOTAZIONE", "InserisciAula");
						// }
						if (view.getRbmInserisciAulaTipoParticolare()) {
							switch (view.getCmbAulaParticolare()) {
							case "Aula Magna":
								ap = AulaParticolare.AULA_MAGNA;
								break;
							case "Aula Informatica":
								ap = AulaParticolare.AULA_INFORMATICA;
								break;
							case "Laboratorio Chimica":
								ap = AulaParticolare.LABORATORIO_CHIMICA;
								break;
							}
						}
					}
				}
				// }
				try {
					a = new Aula(view.getTxtInserisciAulaNome().toUpperCase(),
							Integer.parseInt(view.getTxtInserisciAulaCapienza()), ap, dotAula);

					if (model.cercaAula(a.getNome()) == null) {
						if (model.inserisciAula(a) != null)
							view.tuttoOK("InserisciAula");
					} else
						view.Errore("", "DupInserisciAula");

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		view.getBtnInserisciAulaInserisci().addActionListener(ActionListenerInserisciAulaInserisci);

		/* INSERISCI DOCENTE */
		ActionListenerInserisciDocenteInserisci = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Docente d;

				if (view.getTxtInserisciDocenteNome().isEmpty() || view.getTxtInserisciDocenteNome() == null) {
					view.Errore("NOME DOCENTE", "InserisciDocente");
				}

				else {
					if (view.getTxtInserisciDocenteCognome().isEmpty()
							|| view.getTxtInserisciDocenteCognome() == null) {
						view.Errore("COGNOME DOCENTE", "InserisciDocente");
					} else {
						if (view.getTxtInserisciDocenteMatricola().isEmpty()
								|| view.getTxtInserisciDocenteMatricola() == null
								|| view.getSizeTxtInserisciDocenteMatricola() != 8)// lunghezza fissa di 8 x matricola
						{
							view.Errore("MATRICOLA DOCENTE", "InserisciDocenteMatricola");
						} else {
							try {
								d = new Docente(view.getTxtInserisciDocenteNome().toUpperCase(),
										view.getTxtInserisciDocenteCognome().toUpperCase(),
										Integer.parseInt(view.getTxtInserisciDocenteMatricola()));
								if (model.cercaDocente(d.getMatricola()) == null) {
									if (model.inserisciDocente(d) != null)
										view.tuttoOK("InserisciDocente");
								} else
									view.Errore("", "DupInserisciDocente");

							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		};
		view.getBtnInserisciDocenteInserisci().addActionListener(ActionListenerInserisciDocenteInserisci);

		/* PRENOTA AULA */
		ActionListenerPrenotaAulaCarica = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aula> listaAula = model.getListaAula();

				if (listaAula == null) {
					view.Errore("NON CI SONO AULE!", "PrenotaAulaCarica");
				} else {
					view.cmbAula.removeAllItems();
					for (Aula a : listaAula)
						view.cmbAula.addItem(a.getNome());
				}
			}
		};
		view.getBtnPrenotaAulaCarica().addActionListener(ActionListenerPrenotaAulaCarica);

		ActionListenerPrenotaAulaPrenota = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Prenotazione p;

				if (view.getcmbAula().isEmpty() || view.getcmbAula() == null) {
					view.Errore("NOME AULA", "PrenotaAula");
				} else {
					if (view.getTxtPrenotaAulaDocente().isEmpty() || view.getTxtPrenotaAulaDocente() == null) {
						view.Errore("MATRICOLA DOCENTE", "PrenotaAula");
					} else {
						if (view.getCmbGiorni().isEmpty() || view.getCmbGiorni() == null) {
							view.Errore("DATA GIORNO", "PrenotaAula");
						} else {
							if (view.getCmbMesi().isEmpty() || view.getCmbGiorni() == null) {
								view.Errore("DATA MESE", "PrenotaAula");
							} else {
								if (view.getCmbAnni().isEmpty() || view.getCmbAnni() == null) {
									view.Errore("DATA ANNO", "PrenotaAula");
								} else {
									if (view.getCmbOraInizio().isEmpty() || view.getCmbOraInizio() == null) {
										view.Errore("ORA INIZIO", "PrenotaAula");
									} else {
										if (model.getListaDocente() == null) {
											view.Errore("NON CI SONO DOCENTI!", "PrenotaAulaCarica");
										} else {
											if (model.cercaDocente(
													Integer.parseInt(view.getTxtPrenotaAulaDocente())) == null) {
												view.Errore("NON ESISTE QUESTO DOCENTE!", "PrenotaAulaCarica");
											}
										}
										try {
											p = new Prenotazione(model.cercaAula(view.getcmbAula()),
													model.cercaDocente(
															Integer.parseInt(view.getTxtPrenotaAulaDocente())),
													LocalDate.of(Integer.parseInt(view.getCmbAnni()),
															Integer.parseInt(view.getCmbMesi()),
															Integer.parseInt(view.getCmbGiorni())),
													LocalTime.parse(view.getCmbOraInizio()));

											if (p.getData().compareTo(LocalDate.now()) >= 0) {
												if (model.cercaPrenotazione(p.getAula(), p.getDocente(), p.getData(),
														p.getOraInizio()) == null) {

													if (model.prenotaAula(p) != null)
														view.tuttoOK("PrenotaAula");
												} else
													view.Errore("", "DupPrenotaAula");
											} else
												view.Errore("Non si possono effettuare prenotazioni prima di "
														+ LocalDate.now(), "PrenotaAulaData");
										} catch (Exception e1) {
											e1.printStackTrace();
										}
									}
								}
							}
						}
					}
				}
			}
		};
		view.getBtnPrenotaAulaPrenota().addActionListener(ActionListenerPrenotaAulaPrenota);

		/* VISUALIZZA AULA */
		ActionListenerVisualizzaAula = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getListaAula().isEmpty())
					view.Errore("NON CI SONO AULE!", "VisualizzaAula");
				else
					view.apriPanelVisualizzaAula(model.getListaAula());
			}
		};
		view.iVisualizzaAulaMetodo().addActionListener(ActionListenerVisualizzaAula);

		/* VISUALIZZA DOCENTE */
		ActionListenerVisualizzaDocente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getListaDocente().isEmpty())
					view.Errore("NON CI SONO DOCENTI!", "VisualizzaDocente");
				else
					view.apriPanelVisualizzaDocente(model.getListaDocente());
			}
		};
		view.iVisualizzaDocenteMetodo().addActionListener(ActionListenerVisualizzaDocente);

		/* VISUALIZZA PRENOTAZIONE */
		ActionListenerVisualizzaPrenotazione = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getListaPrenotazione().isEmpty())
					view.Errore("NON CI SONO PRENOTAZIONI!", "VisualizzaPrenotazione");
				else
					view.apriPanelVisualizzaPrenotazione(model.getListaPrenotazione());
			}
		};
		view.iVisualizzaPrenotazioneMetodo().addActionListener(ActionListenerVisualizzaPrenotazione);

		/* MODIFICA AULA */
		ActionListenerModificaAulaCarica = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aula> listaAula = model.getListaAula();

				if (listaAula == null) {
					view.Errore("NON CI SONO AULE!", "PrenotaAulaCarica");
				} else {
					view.cmbModificaAulaNome.removeAllItems();
					for (Aula a : listaAula)
						view.cmbModificaAulaNome.addItem(a.getNome());
				}
			}
		};
		view.getBtnModificaAulaCarica().addActionListener(ActionListenerModificaAulaCarica);

		ActionListenerModificaAulaMostra = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getCmbtModificaAulaNome().isEmpty() || view.getCmbtModificaAulaNome() == null) {
					view.Errore("NON CI SONO AULE!", "ModificaAula");
				} else {
					if (model.cercaAula(view.getCmbtModificaAulaNome()) == null) {
						view.Errore("NON ESISTE QUESTA AULA!", "ModificaAula");
					} else {
						view.apripModificaAulaModificaElementi().setVisible(true);
					}
				}
			}
		};
		view.getBtnModificaAulaMostra().addActionListener(ActionListenerModificaAulaMostra);

		ActionListenerModificaAulaInserisciAulaParticolare = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean selezione = view.getRbmModificaAulaInserisciTipoParticolare();
				view.cmbAulaParticolareModifica.setEnabled(selezione);
			}
		};
		view.rbmModificaAulaInserisciTipoStandard.addActionListener(ActionListenerModificaAulaInserisciAulaParticolare);
		view.rbmModificaAulaInserisciTipoParticolare
				.addActionListener(ActionListenerModificaAulaInserisciAulaParticolare);

		ActionListenerModificaAulaModifica = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Dotazione> dotAulaModificata = new ArrayList<Dotazione>();
				AulaParticolare apm = AulaParticolare.STANDARD;

				if (view.getCbxModificaAulaInserisciDotazioniProiettore()) {
					dotAulaModificata.add(Dotazione.PROIETTORE);
				}
				if (view.getCbxModificaAulaInserisciDotazioniLavagna()) {
					dotAulaModificata.add(Dotazione.LAVAGNA);
				}
				if (view.getCbxModificaAulaInserisciDotazioniMicrofono()) {
					dotAulaModificata.add(Dotazione.MICROFONO);
				}
				if (view.getCbxModificaAulaInserisciDotazioniVideocamera()) {
					dotAulaModificata.add(Dotazione.VIDEOCAMERA);
				}
				if (view.getRbmModificaAulaInserisciTipoParticolare()) {
					switch (view.getCmbAulaParticolareModifica()) {
					case "Aula Magna":
						apm = AulaParticolare.AULA_MAGNA;
						break;
					case "Aula Informatica":
						apm = AulaParticolare.AULA_INFORMATICA;
						break;
					case "Laboratorio Chimica":
						apm = AulaParticolare.LABORATORIO_CHIMICA;
						break;
					}
				}
				if (view.getTxtModificaAulaInserisciNome() != null || view.getTxtModificaAulaInserisciCapienza() != null
						|| view.getRbmModificaAulaInserisciTipoStandard() != false
						|| view.getRbmModificaAulaInserisciTipoParticolare() != false
						|| view.getCbxModificaAulaInserisciDotazioniProiettore() != false
						|| view.getCbxModificaAulaInserisciDotazioniLavagna() != false
						|| view.getCbxModificaAulaInserisciDotazioniMicrofono() != false
						|| view.getCbxModificaAulaInserisciDotazioniVideocamera() != false) {
					if (model.cercaAula(view.getCmbtModificaAulaNome()) != null) {

						if (view.getTxtModificaAulaInserisciCapienza().equals("")) {
							if (model.modificaAula(view.getCmbtModificaAulaNome(),
									view.getTxtModificaAulaInserisciNome(), null, apm, dotAulaModificata) != null)
								view.tuttoOK("ModificaAula");
						} else {
							if (model.modificaAula(view.getCmbtModificaAulaNome(),
									view.getTxtModificaAulaInserisciNome(),
									Integer.parseInt(view.getTxtModificaAulaInserisciCapienza()), apm,
									dotAulaModificata) != null)
								view.tuttoOK("ModificaAula");
						}
					}
				} else {
					view.Errore("Non c'è nulla da modificare!", "ModificaAula");
				}
			}
		};
		view.getBtnModificaAulaInserisciModifica().addActionListener(ActionListenerModificaAulaModifica);

		/* ELIMINA AULA */
		ActionListenerEliminaAulaCarica = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aula> listaAula = model.getListaAula();

				if (listaAula == null) {
					view.Errore("NON CI SONO AULE!", "PrenotaAulaCarica");
				} else {
					view.cmbEliminaAula.removeAllItems();
					for (Aula a : listaAula)
						view.cmbEliminaAula.addItem(a.getNome());
				}
			}
		};
		view.getBtnEliminaAulaCarica().addActionListener(ActionListenerEliminaAulaCarica);

		ActionListenerEliminaAulaElimina = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getCmbEliminaAulaNome().isEmpty() || view.getCmbEliminaAulaNome() == null) {
					view.Errore("NOME AULA", "EliminaAula");
				} else {
					if (model.getListaAula().isEmpty()) {
						view.Errore("NON CI SONO AULE", "EliminaAula");
					} else {
						try {
							if (model.eliminaAula(view.getCmbEliminaAulaNome()))
								view.tuttoOK("EliminaAula");
							else
								view.Errore("Esiste una prenotazione in corso!", "EliminaAula");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		};
		view.getBtnEliminaAulaElimina().addActionListener(ActionListenerEliminaAulaElimina);

		/* ELIMINA DOCENTE */
		ActionListenerEliminaDocenteElimina = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTxtEliminaDocenteMatricola().isEmpty() || view.getTxtEliminaDocenteMatricola() == null) {
					view.Errore("MATRICOLA DOCENTE", "EliminaDocente");
				} else {
					if (model.getListaDocente().isEmpty()) {
						view.Errore("NON CI SONO DOCENTI", "EliminaDocente");
					} else {
						try {
							if (model.eliminaDocente(Integer.parseInt(view.getTxtEliminaDocenteMatricola())))
								view.tuttoOK("EliminaDocente");
							else
								view.Errore("Esiste una prenotazione in corso!", "EliminaDocente");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		};
		view.getBtnEliminaDocenteElimina().addActionListener(ActionListenerEliminaDocenteElimina);

		/* ELIMINA PRENOTAZIONE */
		ActionListenerEliminaPrenotazioneCarica = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aula> listaAula = model.getListaAula();

				if (listaAula == null) {
					view.Errore("NON CI SONO AULE!", "PrenotaAulaCarica");
				} else {
					view.cmbEliminaPrenotazioneAula.removeAllItems();
					for (Aula a : listaAula)
						view.cmbEliminaPrenotazioneAula.addItem(a.getNome());
				}
			}
		};
		view.getBtnEliminaPrenotazioneCarica().addActionListener(ActionListenerEliminaPrenotazioneCarica);

		// apre pannello con ricerca
		// TODO da modificare
		ActionListenerEliminaPrenotazioneCerca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				if (view.getCmbEliminaPrenotazioneAula().isEmpty() || view.getCmbEliminaPrenotazioneAula() == null) {
					view.Errore("NON CI SONO AULE!", "EliminaPrenotazione");
				} else {
					if (view.getTxtEliminaPrenotazioneMatricola().isEmpty()
							|| view.getTxtEliminaPrenotazioneMatricola() == null) {
						view.Errore("MATRICOLA DOCENTE", "EliminaPrenotazione");
					} else {
							//if (/* controllo che la ricerca sia NULL */) {
								//view.Errore("NON CI SONO PRENOTAZIONI IN QUESTA AULA CON QUESTO DOCENTE!", "EliminaPrenotazione");
							//} else {
								view.apripEliminaPrenotazioneRicerca().setVisible(true);
							//}
						}
					}
				//}
			}
		};
		view.getBtnEliminaPrenotazioneCerca().addActionListener(ActionListenerEliminaPrenotazioneCerca);

		// elimina la prenotazione
		ActionListenerEliminaPrenotazioneElimina = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
		view.getBtnEliminaPrenotazioneElimina().addActionListener(ActionListenerEliminaPrenotazioneElimina);

		/* STAMPA REPORT */
		/*
		 * //da sistemare!!! ActionListenerStampaReportMostra = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { //Report r;
		 * 
		 * if (view.getTxtStampaReportMatricola().isEmpty() ||
		 * view.getTxtStampaReportMatricola() == null) {
		 * view.Errore("MATRICOLA DOCENTE", "StampaReport"); } else {
		 * if(model.getListaDocente().isEmpty()) { view.Errore("NON CI SONO DOCENTI",
		 * "StampaReport"); } else { try { //r = new Report(p, d);
		 * if(!(model.cercaDocente(d.getMatricola()) == null)) { if
		 * (!(model.stampaReport(r) == null)) {
		 * view.pStampaReportVisualizza.setVisible(true); //-> come faccio a rendere
		 * visibile il pannello per visualizzarlo e cosa devo fare qui?? } else {
		 * view.Errore("", "StampaReport"); } } catch (Exception e1) {
		 * e1.printStackTrace(); } } } } } };
		 * view.getBtnStampaReportMostra().addActionListener(
		 * ActionListenerStampaReportMostra);
		 */
	}

}