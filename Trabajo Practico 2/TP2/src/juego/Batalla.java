package juego;

import archivo.LogWriter;
import pueblo.Pueblo;

public class Batalla {

	public static void batalla(Pueblo aliados, Pueblo enemigos) {

		LogWriter logWriter = LogWriter.getInstancia();

		if (aliados.hayEjercito() && enemigos.hayEjercito()) {
			Ejercito ejercitoAliado = aliados.getEjercito();
			Ejercito ejercitoEnemigo = enemigos.getEjercito();

			int turno = 1;
			while (ejercitoAliado.haySoldados() && ejercitoEnemigo.haySoldados()) {
				logWriter.escribirLog("\t\t\t\t\t-----------------------------------");
				logWriter.escribirLog("\t\t\t\t\t\t\t\tTurno: " + turno++);
				logWriter.escribirLog("\t\t\t\t\t-----------------------------------");
				logWriter.escribirLog("Ataque de nuestro ejercito:");
				ejercitoAliado.atacar(ejercitoEnemigo);

				if (ejercitoEnemigo.haySoldados()) {
					logWriter.escribirLog("Ataque del ejercito enemigo:");
					ejercitoEnemigo.atacar(ejercitoAliado);
				}
			}
			
			System.out.println("Final de la batalla!");
			logWriter.escribirLog("Final de la batalla!");
			if (ejercitoAliado.haySoldados()) {
				System.out.println("Pasando al siguiente pueblo");
				logWriter.escribirLog("Pasando al siguiente pueblo");
				ejercitoAliado.reordenarse();
			} else {
				System.out.println("Moriste bro");
				logWriter.escribirLog("Moriste bro");
				return;
			}
		}
	}
}
