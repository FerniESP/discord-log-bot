package listeners;

import java.util.List;

import javax.security.auth.login.LoginException;

import util.ControlVersion;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;



public class ComandosBasicosListener extends ListenerAdapter{
	
	public ControlVersion version = new ControlVersion();
	
	public void onPlayerJoin() {
		
	}
	
	 public void onMessageReceived(MessageReceivedEvent event)
	    {
	        //These are provided with every event in JDA
	        JDA jda = event.getJDA();                       //JDA, the core of the api.
	        long responseNumber = event.getResponseNumber();//The amount of discord events that JDA has received since the last reconnect.

	        //Event specific information
	        User author = event.getAuthor();                //The user that sent the message
	        Message message = event.getMessage();           //The message that was received.
	        MessageChannel channel = event.getChannel();    //This is the MessageChannel that the message was sent to.
	                                                        //  This could be a TextChannel, PrivateChannel, or Group!

	        String msg = message.getContent();              //This returns a human readable version of the Message. Similar to
	                                                        // what you would see in the client.

	        boolean bot = author.isBot();                    //This boolean is useful to determine if the User that
	                                                        // sent the Message is a BOT or not!


	        //Now that you have a grasp on the things that you might see in an event, specifically MessageReceivedEvent,
	        // we will look at sending / responding to messages!
	        //This will be an extremely simplified example of command processing.

	        //Remember, in all of these .equals checks it is actually comparing
	        // message.getContent().equals, which is comparing a string to a string.
	        // If you did message.equals() it will fail because you would be comparing a Message to a String!
	        if (msg.equals("!ayuda"))
	        {
	        	channel.sendMessage("Puedes consultar la lista de comandos usando: !comandos").queue();
	        }
	        else if (msg.equals("!help"))
	        {

	            channel.sendMessage("Try in spanish! (!ayuda) :D").queue();
	        }
	        else if (msg.equals("!hola")) {
	        	channel.sendMessage("Hola! Soy LogBOT, creado con :hearts: por Ferni!").queue();
	        }
	        else if (msg.equals("!servidor"))
	        {

	            channel.sendMessage("**Servidor:** " + event.getGuild().getName() + "\n"
	            		+ "**Número de miembros:** " + event.getGuild().getMembers().size() + "\n" +
	            		"**Región:** " + event.getGuild().getRegion().getName() + "\n"
	            		+ "**Owner:** " + event.getGuild().getOwner().getNickname()).queue();
	        }
	        else if (msg.equals("!adminlist"))
	        {	
	        	String salida = "";
	
     		
	        	for (int i = 0; i < event.getGuild().getRoles().size(); i++) {
	        		Role checkRol = event.getGuild().getRoles().get(i);
	
	        		List<Member> userRoles = event.getGuild().getMembersWithRoles(checkRol);
	        		//Se comprueba si el rol es de Admin o Moderador.
	        		if (checkRol.getName().equals("Admin") || checkRol.getName().equals("Moderador") ) {
	        			salida = salida + "Mostrando usuarios con el rol: " + checkRol.getName() + "\n";
	        			//Se recorre la lista de usuarios con ese rol.
	        			for (int ii = 0; ii < event.getGuild().getMembersWithRoles(checkRol).size(); ii++) {
	        				salida = salida + "- " + userRoles.get(ii).getEffectiveName() + "\n";

	        			}
	        		}
	        	}
				channel.sendMessage(salida).queue();
	        	
	            
	        }
	        else if (msg.equals("!pene"))
	        {

	            channel.sendMessage(event.getAuthor().getName() + "... -suspira- Que simple eres...").queue();
	        }
	        
	        
	        else if (msg.equals("!comandos"))
	        {
	        	
	            channel.sendMessage("```Markdown\n"
	            		+ "#Lista de comandos:\n"
	            		+ "!hola: Sirve para saludarme! \n"
	            		+ "!ayuda: Comando de ayuda. \n"
	            		+ "!stats: Muestro estadísticas del usuario.\n"
	            		+ "!servidor: Muestro estadísticas del servidor.\n"
	            		+ "!ping: Te dire !pong\n"
	            		+ "!version: Muestro información sobre mi versión de registro.\n"
	            		+ "!adminlist: Muestro una lista de usuarios con rango administrativo.\n"
	            		+ "```").queue();
	            /*
	             * 
	             * 	            channel.sendMessage("**!ayuda**: Comando de ayuda. \n"
	            		+ "**!stats**: Muestra estadísticas del usuario.\n"
	            		+ "**!abrircaja**: Abre una caja de CS:GO.\n"
	            		+ "**!ping**: Devuelve !pong\n"
	            		+ "**!roll**: Tira un dado.\n"
	            		+ "**!version**: Muestra información sobre la versión del BOT.").queue();
	             * 
	             * 
	             */
	        }
	        else if (msg.equals("!ping")) {
	        	channel.sendMessage("Pong!").queue();
	        }
	        else if (msg.equals("!version"))
	        {
	            channel.sendMessage("**Version actual**: " + version.getVersion() + "\n**Detalles**:\n" + version.getDetalles()).queue();
	        }
	        else if (msg.startsWith("!!summon")) {
	        	try {
	        	List<User> listaMiembros = event.getMessage().getMentionedUsers();
	        	
	        	
	        	event.getTextChannel().sendMessage("Moviendo al usuario.").queue();
	        	for (int i = 0; i < listaMiembros.size(); i++) {
	        		event.getGuild().getController().moveVoiceMember(listaMiembros.get(i), event.getGuild().getVoiceChannelById("233021289650978818")).queue();
	        	}
	        	}
	        	catch (Exception e) {
	        		e.printStackTrace();
	        	}
	        	
	        }



	    }
}
