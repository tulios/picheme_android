package br.picheme.activities;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import br.picheme.R;
import br.picheme.models.Pichacao;
import br.picheme.services.MuroService;
import br.picheme.util.FeedParser;
import br.picheme.util.MuroXmlHandler;

public class MurosList extends ListActivity {

	public static final String TAG = MurosList.class.getName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		InputStream inputStream = MuroService.getFeed("");
		MuroXmlHandler muroXmlHandler = FeedParser.parse(MuroXmlHandler.class, inputStream);
		
		List<Pichacao> pichacoes = muroXmlHandler.getPichacoes();
		if (pichacoes != null) {
			Log.i(TAG, "quantidade de pichacoes: " + pichacoes.size());
		}
		
		List<String> stringList = new ArrayList<String>();
		for (Pichacao pichacao : muroXmlHandler.getPichacoes()) {
			stringList.add(pichacao.getConteudo()); 
		}
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, stringList);
		setListAdapter(listAdapter);
	}

}























