package com.fiapbank.application;

import java.util.List;

import com.fiapbank.business.FiapBankBusiness;
import com.fiapbank.business.FiapBankBusinessImpl;
import com.fiapbank.business.FiapBankCommanderBusiness;
import com.fiapbank.utils.PropertiesUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

public class ApplicationController {

	private static final String TELEGRAM_TOKEN_KEY = "telegram.token";

	private static FiapBankBusiness fiapBankBusiness;
	
	private static Message baseMessage = null;

	public static void main(String[] args) {
		try {
			TelegramBot bot = TelegramBotAdapter.build(PropertiesUtils.getProperty(TELEGRAM_TOKEN_KEY));

			GetUpdatesResponse updatesResponse;

			int m = 0;

			while (true) {

				updatesResponse = bot.execute(new GetUpdates().offset(m));

				List<Update> updates = updatesResponse.updates();

				for(Update update : updates) {
					m = update.updateId() + 1;
					System.out.println("Recebendo mensagem : " + update.message().text());
					Message message = update.message();
					String messageText = message.text();
					if (messageText.startsWith("/")) {
						fiapBankBusiness = new FiapBankCommanderBusiness(bot, update);
						baseMessage = message;
						filterMessage(messageText);
						continue;
					}
					if(baseMessage != null){
						fiapBankBusiness = new FiapBankBusinessImpl(bot, update);
						filterMessage(baseMessage.text());
						baseMessage = null;
						continue;
					}
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void filterMessage(String message){
		switch (message) {
		case "/iniciar":
			fiapBankBusiness.iniciar();
			break;
		case "/criar":
			break;
		case "/modificar":
			break;
		case "/incluirdependentes":
			break;
		case "/exibir":
			break;
		case "/depositar":
			break;
		case "/sacar":
			break;
		case "/extrato":
			break;
		case "/emprestimo":
			break;
		case "/emprestimoinfo":
			break;
		case "/lancamentos":
			break;
		case "/retiradas":
			break;
		case "/servicostax":
			break;
		case "/ajuda":
			break;
		}
	}

}
