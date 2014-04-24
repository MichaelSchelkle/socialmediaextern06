package de.hdm.gruppe6.itprojekt.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.gruppe6.itprojekt.shared.bo.Textbeitrag;
import de.hdm.gruppe6.itprojekt.shared.bo.User;
import de.hdm.gruppe6.itprojekt.shared.report.InfosVonAllenBeitraegenReport;
import de.hdm.gruppe6.itprojekt.shared.report.InfosVonAllenUsernReport;
import de.hdm.gruppe6.itprojekt.shared.report.InfosVonBeitragReport;
import de.hdm.gruppe6.itprojekt.shared.report.InfosVonUserReport;


/**
 * <p>
 * Synchrone Schnittstelle f�r eine RPC-f�hige Klasse zur Erstellung von
 * Reports. Diese Schnittstelle benutzt die gleiche Realisierungsgrundlage wir
 * das Paar {PinnwandVerwaltung} und {PinnwandVerwaltungImpl}. Zu
 * technischen Erl�uterung etwa bzgl. GWT RPC bzw. {@link RemoteServiceServlet}
 * siehe {@link PinnwandVerwaltung} und PinnwandVerwaltungImpl}.
 * </p>
 * <p>
 * Ein ReportGenerator bietet die M�glichkeit, eine Menge von Berichten
 * (Reports) zu erstellen, die Menge von Daten bzgl. bestimmter Sachverhalte des
 * Systems zweckspezifisch darstellen.
 * </p>
 * <p>
 * Die Klasse bietet eine Reihe von <code>create...</code>-Methoden, mit deren
 * Hilfe die Reports erstellt werden k�nnen. Jede dieser Methoden besitzt eine
 * dem Anwendungsfall entsprechende Parameterliste. Diese Parameter ben�tigt der
 * der Generator, um den Report erstellen zu k�nnen.
 * </p>
 * <p> 
 * Bei neu hinzukommenden Bedarfen an Berichten, kann diese Klasse auf einfache
 * Weise erweitert werden. Hierzu k�nnen zus�tzliche <code>create...</code>
 * -Methoden implementiert werden. Die bestehenden Methoden bleiben davon
 * unbeeinflusst, so dass bestehende Programmlogik nicht ver�ndert werden muss.
 * </p>
 * 
 * @author Anlehnung an Professor Thies
 */

public interface ReportGenerator extends RemoteService {

	/**
	   * Initialisierung des Objekts. Diese Methode ist vor dem Hintergrund von GWT
	   * RPC zus�tzlich zum No Argument Constructor der implementierenden Klasse
	   *PinnwandVerwaltungImpl} notwendig. Bitte diese Methode direkt nach der
	   * Instantiierung aufrufen.
	   * 
	   * @throws IllegalArgumentException
	   */
	
	public void init() throws IllegalArgumentException;
	
	public abstract InfosVonUserReport erstelleInfosVonUserReport(User user, Date anfangszeitpunkt, Date endzeitpunkt)
	throws IllegalArgumentException;
	
	public abstract InfosVonBeitragReport erstelleInfosVonBeitragReport(Textbeitrag textbeitrag, Date anfangszeitpunkt, Date endzeitpunkt) 
	throws IllegalArgumentException;
	
	public abstract InfosVonAllenUsernReport erstelleInfosVonAllenUsernReport(Date anfangszeitpunkt, Date endzeitpunkt)
	throws IllegalArgumentException;
	
	public abstract InfosVonAllenBeitraegenReport erstelleInfosVonAllenBeitraegenReport(Date anfangszeitpunkt, Date endzeitpunkt)
	throws IllegalArgumentException;
}
