package mvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import upo.progetto.*;

public class Model {
	private ArrayList<Aula> aule = new ArrayList<>();
	private ArrayList<Docente> docenti = new ArrayList<>();
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
	// private ArrayList<Report> report = new ArrayList<>();

	// metodi Inserisci
	public Aula inserisciAula(Aula a) {
		if (a.getNome() == null || a.getCapienza() == 0 || a.getTipo() == null || a.getDotazioneAula() == null)
			throw new IllegalArgumentException();
		else
			aule.add(a);

		return a;
	}

	public Docente inserisciDocente(Docente d) {
		if (d.getNome() == null || d.getCognome() == null || d.getMatricola() == 0)
			throw new IllegalArgumentException();
		else
			docenti.add(d);

		return d;
	}

	public Prenotazione prenotaAula(Prenotazione p) {
		if (p.getAula() == null || p.getDocente() == null || p.getData() == null || p.getOraInizio() == null)
			throw new IllegalArgumentException();
		else
			prenotazioni.add(p);

		return p;
	}

	public Aula modificaAula(String modifica, String nome, Integer capienza, AulaParticolare tipo,
			ArrayList<Dotazione> dotazioneAula) {

		Aula a = cercaAula(modifica);

		if (a == null)
			throw new IllegalArgumentException();
		else {
			if (nome != null && !nome.equals("") && !(nome.equals(a.getNome())))
				a.setNome(nome.toUpperCase());

			if (capienza != null && capienza != a.getCapienza())
				a.setCapienza(capienza);

			if (tipo != null && tipo != a.getTipo())
				a.setTipo(tipo);

			if (dotazioneAula != null && dotazioneAula != a.getDotazioneAula())
				a.setDotazioneAula(dotazioneAula);

			return a;
		}
	}

	// Metodi Elimina
	public boolean eliminaAula(String nome) {
		Aula a = cercaAula(nome);
		ArrayList<Prenotazione> p = new ArrayList<Prenotazione>();
		if (a != null) {
			p = CercaPrenotazione(a);
			if (p == null)
				aule.remove(a);
			else {
				for (Prenotazione e : p) {
					if (e.getOraFine().compareTo(LocalTime.now()) > 0)
						return false;
				}
				aule.remove(a);
				for (Prenotazione e1 : p) {
						prenotazioni.remove(e1);
				}
			}
		}
		return true;
	}

	public boolean eliminaDocente(int matricola) {
		Docente d = cercaDocente(matricola);
		ArrayList<Prenotazione> p = new ArrayList<Prenotazione>();

		if (d != null)
			p = CercaPrenotazione(d);
			if (p == null)
				docenti.remove(d);
			else {
				for (Prenotazione e : p) {
					if (e.getOraFine().compareTo(LocalTime.now()) > 0)
						return false;
				}
				docenti.remove(d);
				for (Prenotazione e1 : p) {
						prenotazioni.remove(e1);
				}
			}
		return true;
	}

	public void eliminaPrenotazione(String nome, int matricola) {
		if (nome == null || (Integer) matricola == null || nome == "")
			throw new IllegalArgumentException();
		else {
			for (Prenotazione p : prenotazioni) {
				if ((p.getAula()).getNome() == nome && (p.getDocente()).getMatricola() == matricola)
					prenotazioni.remove(p);
			}
		}
	}

	/*
	 * public ArrayList<Report> stampaReport(int matricola) { ArrayList<Report>
	 * listaReport = new ArrayList<>();
	 * 
	 * if ((Integer) matricola == null) throw new IllegalArgumentException(); else {
	 * for (Report r : report) { if ((r.getDocente()).getMatricola() == matricola)
	 * listaReport.add(r); } return listaReport; } }
	 */

	// Metodi Cerca
	public Aula cercaAula(String nome) {
		if (nome == null || nome == "")
			throw new IllegalArgumentException();
		else {
			for (Aula a : aule) {

				if (nome.equals(a.getNome()))
					return a;
			}
		}
		return null;
	}

	public Docente cercaDocente(int matricola) {
		if ((Integer) matricola == null)
			throw new IllegalArgumentException();
		else {
			for (Docente d : docenti) {
				if (d.getMatricola() == matricola)
					return d;
			}
		}
		return null;
	}

	public Prenotazione cercaPrenotazione(Aula a, Docente d, LocalDate date, LocalTime oraInizio) {
		Prenotazione p = new Prenotazione(a, d, date, oraInizio);

		if (a == null || d == null || date == null || oraInizio == null)
			throw new IllegalArgumentException();
		else {
			for (Prenotazione e : prenotazioni) {
				if (e.equals(p))
					return e;
			}
		}
		return null;
	}

	private ArrayList<Prenotazione> CercaPrenotazione(Aula a) {
		ArrayList<Prenotazione> p = new ArrayList<Prenotazione>();
		for (Prenotazione e : prenotazioni) {
			if (e.getAula().getNome().equals(a.getNome()))
				p.add(e);
		}
		return p;
	}
	
	private ArrayList<Prenotazione> CercaPrenotazione(Docente d) {
		ArrayList<Prenotazione> p = new ArrayList<Prenotazione>();
		for (Prenotazione e : prenotazioni) {
			if (e.getDocente().getMatricola() == d.getMatricola())
				p.add(e);
		}
		return p;
	}

	// Metodi Get
	public ArrayList<Aula> getListaAula() {
		return aule;
	}

	public ArrayList<Docente> getListaDocente() {
		return docenti;
	}

	public ArrayList<Prenotazione> getListaPrenotazione() {
		return prenotazioni;
	}
}