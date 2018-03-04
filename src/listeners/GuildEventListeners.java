package listeners;

import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.core.events.channel.text.update.TextChannelUpdateNameEvent;
import net.dv8tion.jda.core.events.channel.text.update.TextChannelUpdatePermissionsEvent;
import net.dv8tion.jda.core.events.channel.text.update.TextChannelUpdatePositionEvent;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.core.events.channel.voice.update.VoiceChannelUpdateBitrateEvent;
import net.dv8tion.jda.core.events.channel.voice.update.VoiceChannelUpdateNameEvent;
import net.dv8tion.jda.core.events.channel.voice.update.VoiceChannelUpdatePermissionsEvent;
import net.dv8tion.jda.core.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.core.events.channel.voice.update.VoiceChannelUpdateUserLimitEvent;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateAfkChannelEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateAfkTimeoutEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateIconEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateMFALevelEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateNotificationLevelEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateOwnerEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateRegionEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateSplashEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateVerificationLevelEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.user.UserAvatarUpdateEvent;
import net.dv8tion.jda.core.events.user.UserGameUpdateEvent;
import net.dv8tion.jda.core.events.user.UserNameUpdateEvent;
import net.dv8tion.jda.core.events.user.UserOnlineStatusUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Reloj;

public class GuildEventListeners extends ListenerAdapter {
	
	
	String idCanalBOT = "323166928946593803";
	
	
	
	
	//User events
    public void onUserNameUpdate(UserNameUpdateEvent event) {
    	System.out.println("Un usuario ha cambiado de nombre! " + event.getOldName() + " -> " + event.getUser().getName());
    }
    public void onUserAvatarUpdate(UserAvatarUpdateEvent event) {
    	System.out.println("Un usuario ha cambiado de avatar! " + event.getUser().getName());
    }
    public void onUserOnlineStatusUpdate(UserOnlineStatusUpdateEvent event) {
    	String status = ""+event.getJDA().getStatus();
    	String previousStatus = ""+event.getPreviousOnlineStatus();
    	if (previousStatus.equals("DO_NOT_DISTURB") || previousStatus.equals("IDLE") || previousStatus.equals("ONLINE")) {
    		
    	}
    	else {
    		if (status.equals("CONNECTED")) {
        		event.getGuild().getTextChannelById(idCanalBOT).sendMessage("**" + event.getUser().getName() + "** se ha conectado!").queue();
        	}
        	else {
        		event.getGuild().getTextChannelById(idCanalBOT).sendMessage("**" + event.getUser().getName() + "** se ha desconectado!").queue();
        	}
    	}
    	
    	   	
    	//event.getGuild().getTextChannelById(idCanalBOT).sendMessage(event.getUser().getName() + " ha cambiado su estado a " + event.getJDA().getStatus()).queue();
    }
    /*public void onUserGameUpdate(UserGameUpdateEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage(event.getUser().getName() + " ha empezado a jugar a " + event.getClass().getName()).queue();
    }*/
    //public void onUserTyping(UserTypingEvent event) {}
	
    //Message events
    public void onGuildMessageDelete(GuildMessageDeleteEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha borrado un mensaje en el canal: " + event.getChannel().getName()).queue();;
    }
    
    //TextChannel events
    public void onTextChannelDelete(TextChannelDeleteEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha borrado un canal de texto: " + event.getChannel().getName()).queue();
    }
    
    public void onTextChannelUpdateName(TextChannelUpdateNameEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el nombre de un canal de texto: " + event.getOldName() + " -> " + event.getChannel().getName()).queue();
    }
    
    public void onTextChannelCreate(TextChannelCreateEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha creado un nuevo canal de texto: " + event.getChannel().getName()).queue();
    }
	
    public void onTextChannelUpdatePosition(TextChannelUpdatePositionEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado la posición del canal de texto: " + event.getChannel().getName() 
    			+ " - Posicion: " + event.getOldPosition() + " -> " + event.getChannel().getPosition()).queue();
    }
    public void onTextChannelUpdatePermissions(TextChannelUpdatePermissionsEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se han cambiado los permisos del canal de texto: " + event.getChannel().getName()).queue();
    }
    
    //VoiceChannel Events
    public void onVoiceChannelDelete(VoiceChannelDeleteEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha borrado un canal de voz: " + event.getChannel().getName()).queue();
    }
    public void onVoiceChannelUpdateName(VoiceChannelUpdateNameEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el nombre de un canal de voz: " + event.getOldName() + " -> " + event.getChannel().getName()).queue();
    }
    public void onVoiceChannelUpdatePosition(VoiceChannelUpdatePositionEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado la posición de un canal de voz: " + event.getChannel().getName() 
    			+ " - Posicion: " + event.getOldPosition() + " -> " + event.getChannel().getPosition()).queue();
    }
    public void onVoiceChannelUpdateUserLimit(VoiceChannelUpdateUserLimitEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado la capacidad de un canal de voz: " + event.getChannel().getName() + " - " 
    			+ event.getOldUserLimit() + " -> " + event.getChannel().getUserLimit()).queue();
    }
    public void onVoiceChannelUpdateBitrate(VoiceChannelUpdateBitrateEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el bitrate de un canal de voz: " + event.getChannel().getName()).queue();
    }
    public void onVoiceChannelUpdatePermissions(VoiceChannelUpdatePermissionsEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se han cambiado los permisos de un canal de voz: " + event.getChannel().getName()).queue();
    }
    public void onVoiceChannelCreate(VoiceChannelCreateEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha creado un nuevo canal de voz: " + event.getChannel().getName()).queue();
    }
	
    //Guild event
    public void onGuildBan(GuildBanEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha baneado a " + event.getUser().getName() + " Bye!").queue();
    }
    public void onGuildUnban(GuildUnbanEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha desbaneado a " + event.getUser().getName()).queue();;
    }
	
	//Guild update events
    public void onGuildUpdateAfkChannel(GuildUpdateAfkChannelEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el canal de AFK: " + event.getGuild().getAfkChannel().getName()).queue();
    }
    
    public void onGuildUpdateAfkTimeout(GuildUpdateAfkTimeoutEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el tiempo para ser movido a AFK: " + event.getGuild().getAfkTimeout().getSeconds() + " segundos").queue();
    }
    public void onGuildUpdateIcon(GuildUpdateIconEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el icono del servidor.").queue();
    }
    public void onGuildUpdateMFALevel(GuildUpdateMFALevelEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el nivel de MFA del servidor.").queue();
    }
    public void onGuildUpdateName(GuildUpdateNameEvent event){
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el nombre del servidor: " + event.getOldName() + " -> " + event.getGuild().getName()).queue();
    }
    public void onGuildUpdateNotificationLevel(GuildUpdateNotificationLevelEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el nivel de notificación del servidor.").queue();
    }
    public void onGuildUpdateOwner(GuildUpdateOwnerEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el dueño del servidor." + event.getOldOwner().getEffectiveName() 
    			+ " -> " + event.getGuild().getOwner().getEffectiveName()).queue();
    }
    public void onGuildUpdateRegion(GuildUpdateRegionEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado la región del servidor." + event.getOldRegion().getName() 
    			+ " -> " + event.getGuild().getRegion().getName()).queue();
    }
    public void onGuildUpdateSplash(GuildUpdateSplashEvent event) {}
    public void onGuildUpdateVerificationLevel(GuildUpdateVerificationLevelEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Se ha cambiado el nivel de verificación del servidor.").queue();
    }
    
    
    //Guild member events
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		System.out.println("Un usuario se ha unido al servidor!");
		event.getGuild().getTextChannelById(idCanalBOT).sendMessage("Nuevo usuario en el servidor! Bienvenido " + event.getMember().getAsMention()).queue();;
	}
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage(event.getMember().getEffectiveName() + " se ha ido del servidor!").queue();;
    }
    public void onGuildMemberNickChange(GuildMemberNickChangeEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage(event.getMember().getEffectiveName() + " ha cambiado su nick!").queue();
    }
    
    //Guild Voice Events
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage(new Reloj().getHora() + " **" + event.getMember().getEffectiveName() + "** ha entrado en el canal **" + event.getChannelJoined().getName() + "**.").queue();
    }
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage(new Reloj().getHora() + " **" + event.getMember().getEffectiveName() + "** se ha movido del canal **" + event.getChannelLeft().getName() 
    			+ "** al canal **" + event.getChannelJoined().getName() + "**.").queue();
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
    	event.getGuild().getTextChannelById(idCanalBOT).sendMessage(new Reloj().getHora() + " **" + event.getMember().getEffectiveName() + "** ha salido del canal **" + event.getChannelLeft().getName() + "**.").queue();
    }
    //public void onGuildVoiceMute(GuildVoiceMuteEvent event) {}
    //public void onGuildVoiceDeafen(GuildVoiceDeafenEvent event) {}
    //public void onGuildVoiceGuildMute(GuildVoiceGuildMuteEvent event) {}
    //public void onGuildVoiceGuildDeafen(GuildVoiceGuildDeafenEvent event) {}
    //public void onGuildVoiceSelfMute(GuildVoiceSelfMuteEvent event) {}
    //public void onGuildVoiceSelfDeafen(GuildVoiceSelfDeafenEvent event) {}
    //public void onGuildVoiceSuppress(GuildVoiceSuppressEvent event) {}
    
    
    
}
