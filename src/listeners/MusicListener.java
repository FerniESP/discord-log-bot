package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

public class MusicListener extends ListenerAdapter{
	

	public void onMessageReceived(MessageReceivedEvent event) {
		Message message = event.getMessage();
		String msg = message.getContent();
		MessageChannel channel = event.getChannel(); 
		
		VoiceChannel voiceChannel = event.getGuild().getVoiceChannelById("289704017574100993");
		
		
		
		
		if (msg.equals("!!conectarse"))
		{
			AudioManager manager = voiceChannel.getGuild().getAudioManager();
			manager.openAudioConnection(voiceChannel);
			
			
			
			
			channel.sendMessage("").queue();
		} 
		
	}
	
	
}
