package br.picheme.util;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.picheme.models.Pichacao;

public class MuroXmlHandler extends DefaultHandler {

	public static final String TAG = MuroXmlHandler.class.getName();
	
	public static final String ENTRY = "entry";
	public static final String ID = "id";
	public static final String CONTENT = "content";
	
	private StringBuilder currentValue;
	private List<Pichacao> pichacoes = null;
	private Pichacao pichacao = null;
	
	public MuroXmlHandler() {
		pichacoes = new ArrayList<Pichacao>();
	}
	
	public List<Pichacao> getPichacoes() {
		return pichacoes;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		currentValue = new StringBuilder();
		
		if (localName.equalsIgnoreCase(ENTRY)) {
			pichacao = new Pichacao();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		
		if (pichacao != null) { 
			if (localName.equalsIgnoreCase(ID)) {
				pichacao.setId("" + currentValue.toString());
				
			} else if (localName.equalsIgnoreCase(CONTENT)) {
				pichacao.setConteudo("" + currentValue.toString());
				
			} else if (localName.equalsIgnoreCase(ENTRY)) {
				pichacoes.add(pichacao);
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (currentValue != null) {
			currentValue.append(ch, start, length);
		}
	}

}
