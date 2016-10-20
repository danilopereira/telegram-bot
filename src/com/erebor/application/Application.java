package com.erebor.application;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class Application {
	
	private static final String TELEGRAM_BOT_TOKEN = "251348206:AAFDr8cqCG18BMc6x9EOH5ccLiiDRbb1JPY";

	public static void main(String[] args) {
		TelegramBot bot = TelegramBotAdapter.build(TELEGRAM_BOT_TOKEN);
		
		GetUpdatesResponse updatesResponse;
		
		SendResponse sendResponse;
		
		BaseResponse baseResponse;
		
		int m = 0;
		
		while(true){
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));
			
			List<Update> updates = updatesResponse.updates();
			
			for(Update update : updates){
				m = update.updateId()+1;
				
				System.out.println("Recebendo mensagem : " + update.message().text());
				
				baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
				
				sendResponse = bot.execute(new SendMessage(update.message().chat().id(), "Não entendi..."));
				
				System.out.println("Status de envio: " + sendResponse.isOk());
			}
		}
	}

}
