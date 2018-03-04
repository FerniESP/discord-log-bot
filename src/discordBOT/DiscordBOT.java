package discordBOT;

import javax.security.auth.login.LoginException;

import listeners.ComandosBasicosListener;
import listeners.GuildEventListeners;
import listeners.MusicListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Reloj;

public class DiscordBOT {
	final static String botToken = "MzQwNzk5ODgzMzc0MTAwNTAw.DF3yKA.u3VJwm-121OX0h7vy1t_rPoXkq8"; //Token del BOT.

	@SuppressWarnings("unused")
	public void iniciarBOT () {
		System.out.println(new Reloj().getHora() + " [INFO]: Iniciando BOT.");
	    try {
			JDA jda = new JDABuilder(AccountType.BOT)
			        .setToken(botToken).setGame(Game.of("Escribe !ayuda"))          	
			        .addEventListener(new ComandosBasicosListener(), new GuildEventListeners(), new MusicListener())  	
			        .buildBlocking();
			
			System.out.println(new Reloj().getHora() + " [INFO]: BOT Iniciado.");
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			System.out.println(new Reloj().getHora() + " [INFO]: Error en la ejecución del BOT");
			e.printStackTrace();
		}
	}
}
