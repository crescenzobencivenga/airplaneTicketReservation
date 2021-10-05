<H1 align="center">Progetto Programmazione 3</H1>
<!--  README  -->

<h3 align="center">Airplane ticket reservation</h3>


<!-- Descrizione del progetto -->
## Descrizione del progetto
Si vuole realizzare e sviluppare un sistema per la gestione e la prenotazione di biglietti aerei.
Si vogliono monitorare i dati persistenti del sistema attraverso un database SQLite. 
I dati da rendere persistenti sono quelli relativi ai voli, utenti, biglietti acquistati. L’accesso al sistema può avvenire secondo due modalità: amministratore e utente.
L’utente può:
-	Visualizzare i voli disponibili
-	Acquistare biglietti con più modalità di pagamento
-	Visualizzare i biglietti acquistati

Una volta scelto il volo l’utente può effettuare l’acquisto del biglietto relativo ad esso con diversi metodi di pagamento, una volta acquistato il biglietto il sistema memorizza l’acquisto nella tabella bigliettiAcquistati.
L’amministratore può:
-	Aggiungere voli
-	Eliminare voli
-	Annullare l’ultima operazione effettuata

### Realizzato con
- <b>JavaFX</b>:  una famiglia di software applicativi, basati sulla piattaforma Java, per la creazione di rich Internet applications, applicazioni web che hanno tutte le caratteristiche e funzionalità delle comuni applicazioni per computer. Con JavaFX è possibile realizzare delle applicazioni per dispositivi di vario genere e piattaforme.
JavaFX è stato usato con Scene Builder, uno strumento open source che permette di creare interfacce desktop mobile ed embedded attraverso una interfaccia drag & drop.
- <b>SQLite</b>: è una libreria software scritta in linguaggio C che implementa un DBMS SQL di tipo ACID incorporabile all'interno di applicazioni. Permette di creare una base di dati (comprese tabelle, query, form, report) incorporata in un unico file.
- <b>IntelliJ</b>

<!-- GETTING STARTED -->
## Replicare il progetto

1. Clonare la repository
  ```
 git clone https://github.com/crescenzobencivenga/airplaneTicketReservation
  ```
2. Aprire la repository all'interno di un ide
3. Aggiungere i driver JDBC per SQLite alle librerie del progetto


<!-- LICENSE -->
## License
_Apache license 2.0_
