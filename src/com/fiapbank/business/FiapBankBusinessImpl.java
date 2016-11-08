package com.fiapbank.business;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class FiapBankBusinessImpl implements FiapBankBusiness {
	
	private static final String ERRO_MESSAGE = "Desculpe, comando não reconhecido.";
	
	TelegramBot bot;

	Update update;

	SendResponse sendResponse;

	BaseResponse baseResponse;
	
	public FiapBankBusinessImpl(TelegramBot bot,
			Update update) {
			this.bot = bot;
			this.update = update;
	}

	@Override
	public void iniciar() {
		try{
			String opcao = update.message().text();
			baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
			switch(opcao){
			case "1":
				sendResponse = bot.execute(new SendMessage(update.message().chat().id(), "Bom pra você!"));
				System.out.println("Status de envio: " + sendResponse.isOk());
				break;
			case "2":
				sendResponse = bot.execute(new SendMessage(update.message().chat().id(), "Vamos abrir uma então?"));
				System.out.println("Status de envio: " + sendResponse.isOk());
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

	@Override
	public void criar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void incluirDependentes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exibir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void extrato() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emprestimo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emprestimoInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lancamentos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void servicosTax() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajuda() {
		// TODO Auto-generated method stub

	}



	@Override
	public void erro() {
		sendResponse = bot.execute(new SendMessage(update.message().chat().id(), ERRO_MESSAGE));
		System.out.println("Status de envio: " + sendResponse.isOk());		
	}

}
