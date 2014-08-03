package Transfers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static final int port = 8090;

	public static void main(String[] args) throws Exception {
		
		ServerSocket s = new ServerSocket(port);
		while (true) {
			// On attend la connexion d'un client
			Socket socket = s.accept();

			Byte[] taillefichier;
			int lu;
			long taille = 0;

			// Création de l'entrée
			InputStream inpute = socket.getInputStream();

			OutputStream out = new FileOutputStream("tmp.txt");

			// Reçoit du client
			BufferedInputStream inBuffer = new BufferedInputStream(inpute);

			// Envoi vers le fichier
			BufferedOutputStream outBuffer = new BufferedOutputStream(out);

			lu = inBuffer.read();

			int compteur = 0;

			while (lu > -1) {
				outBuffer.write(lu);
				lu = inBuffer.read();

				compteur++;
			}

			outBuffer.write(lu);

			outBuffer.flush();
			outBuffer.close();
			inBuffer.close();

			out.flush();
			out.close();
			inpute.close();
			socket.close();

		}
	}
}