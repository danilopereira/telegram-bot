package com.fiapbank.business;

import com.fiapbank.utils.PropertiesUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class FiapBankCommanderBusiness implements FiapBankBusiness {
	
	private static final String TEMPLATE_INICIAR = "template.iniciar";

	TelegramBot bot;

	Update update;

	SendResponse sendResponse;

	BaseResponse baseResponse;
	
	public FiapBankCommanderBusiness(TelegramBot bot,
			Update update){
		this.bot = bot;
		this.update = update;
	}


	@Override
	public void iniciar() {
		try{
			baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
			String templateIniciar = PropertiesUtils.getProperty(TEMPLATE_INICIAR);
			String iniciar = String.format(templateIniciar, update.message().chat().firstName());
			sendResponse = bot.execute(new SendMessage(update.message().chat().id(), iniciar));
			System.out.println("Status de envio: " + sendResponse.isOk());
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
		// TODO Auto-generated method stub

	}

}
